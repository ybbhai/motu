/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
package fr.cls.atoll.motu.web.dal.request.netcdf.data.vfs;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.vfs2.CacheStrategy;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSelector;
import org.apache.commons.vfs2.FileSystemConfigBuilder;
import org.apache.commons.vfs2.FileSystemException;
import org.apache.commons.vfs2.FileSystemOptions;
import org.apache.commons.vfs2.FileType;
import org.apache.commons.vfs2.Selectors;
import org.apache.commons.vfs2.UserAuthenticator;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.impl.StandardFileSystemManager;
import org.apache.commons.vfs2.provider.ftp.FtpFileSystem;
import org.apache.commons.vfs2.provider.ftp.FtpFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.http.HttpFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joda.time.Period;

import fr.cls.atoll.motu.api.message.xml.ErrorType;
import fr.cls.atoll.motu.web.bll.exception.MotuException;
import fr.cls.atoll.motu.web.bll.exception.MotuExceptionBase;
import fr.cls.atoll.motu.web.common.utils.StringUtils;

/**
 * 
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites)
 * 
 * @version $Revision: 1.1 $ - $Date: 2009-03-18 12:18:22 $
 * @author <a href="mailto:dearith@cls.fr">Didier Earith</a>
 */
public class VFSManager {

    /** Logger for this class. */
    private static final Logger LOG = LogManager.getLogger();

    /** The Constant DEFAULT_SCHEME. */
    public static final String DEFAULT_SCHEME = "local";

    /**
     * Instantiates a new vFS manager.
     */
    public VFSManager() {
    }

    /** The standard file system manager. */
    protected StandardFileSystemManager standardFileSystemManager = null;

    /**
     * Gets the opts.
     * 
     * @return the opts
     */
    public FileSystemOptions getOpts() {
        return opts;
    }

    /**
     * Gets the standard file system manager.
     * 
     * @return the standard file system manager
     */
    public StandardFileSystemManager getStandardFileSystemManager() {
        return standardFileSystemManager;
    }

    /** The opts. */
    protected FileSystemOptions opts = null;

    /**
     * Sets the opts.
     * 
     * @param opts the new opts
     */
    public void setOpts(FileSystemOptions opts) {
        this.opts = opts;
    }

    /** The open. */
    protected boolean open = false;

    /**
     * Checks if is opened.
     * 
     * @return true, if is opened
     */
    public boolean isOpened() {
        return open;
    }

    /**
     * Open.
     * 
     * @throws MotuException the motu exception
     */
    public void open() throws MotuException {
        open("", "", "", "");
    }

    /**
     * Open.
     * 
     * @param user the user
     * @param pwd the pwd
     * @param scheme the scheme
     * 
     * @throws MotuException the motu exception
     */
    public void open(String user, String pwd, String scheme, String host) throws MotuException {
        if (isOpened()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("open(String, String, String) - exiting");
            }
            return;
        }

        standardFileSystemManager = new StandardFileSystemManager();
        // standardFileSystemManager.setLogger(LogFactory.getLog(VFS.class));

        standardFileSystemManager.setClassLoader(this.getClass().getClassLoader());
        try {
            standardFileSystemManager.setConfiguration(ConfigLoader.getInstance().get("motuVFSProvider.xml"));
            // standardFileSystemManager.setCacheStrategy(CacheStrategy.ON_CALL);
            standardFileSystemManager.setCacheStrategy(CacheStrategy.ON_RESOLVE);
            // standardFileSystemManager.setFilesCache(new SoftRefFilesCache());
            // standardFileSystemManager.addProvider("jar", new JarFileProvider());
            standardFileSystemManager.init();
            open = true;
        } catch (FileSystemException e) {
            LOG.fatal("Error in VFS initialisation - Unable to intiialize VFS", e);
            throw new MotuException(ErrorType.NETCDF_LOADING, "Error in VFS initialisation - Unable to intiialize VFS", e);
        } catch (IOException e) {
            LOG.fatal("Error in VFS initialisation - Unable to intiialize VFS", e);
            throw new MotuException(ErrorType.NETCDF_LOADING, "Error in VFS initialisation - Unable to intiialize VFS", e);
        }

        opts = new FileSystemOptions();

        setUserInfo(user, pwd);
        setSchemeOpts(scheme, host);
    }

    /**
     * Sets the user info.
     * 
     * @param user the user
     * @param pwd the pwd
     * @param fileSystemOptions the file system options
     * @return the file system options
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setUserInfo(String user, String pwd, FileSystemOptions fileSystemOptions) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(String, String, FileSystemOptions) - start");
        }

        if (fileSystemOptions == null) {
            fileSystemOptions = new FileSystemOptions();
        }
        StaticUserAuthenticator auth = new StaticUserAuthenticator(null, user, pwd);

        FileSystemOptions returnFileSystemOptions = setUserInfo(auth);
        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(String, String, FileSystemOptions) - end");
        }
        return returnFileSystemOptions;

    }

    /**
     * Sets the user info.
     * 
     * @param user the user
     * @param pwd the pwd
     * @return the file system options
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setUserInfo(String user, String pwd) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(String, String) - start");
        }

        FileSystemOptions returnFileSystemOptions = setUserInfo(user, pwd, opts);
        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(String, String) - end");
        }
        return returnFileSystemOptions;

    }

    /**
     * Sets the user info.
     * 
     * @param auth the auth
     * 
     * @return the file system options
     * 
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setUserInfo(UserAuthenticator auth) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(StaticUserAuthenticator) - entering");
        }

        if (opts == null) {
            opts = new FileSystemOptions();
        }

        if (auth == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("setUserInfo(StaticUserAuthenticator) - exiting");
            }
            return opts;
        }
        try {
            DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
        } catch (FileSystemException e) {
            LOG.error("setUserInfo(StaticUserAuthenticator)", e);

            throw new MotuException(ErrorType.NETCDF_LOADING, "Error in VFSManager#setUserInfo", e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("setUserInfo(StaticUserAuthenticator) - exiting");
        }
        return opts;

    }

    /**
     * Sets the scheme.
     * 
     * @param scheme the scheme
     * 
     * @return the file system options
     * 
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setSchemeOpts(String scheme, String host) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setSchemeOpts(String, String) - start");
        }

        if (StringUtils.isNullOrEmpty(scheme)) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("setSchemeOpts(String, String) - end");
            }
            return opts;
        }

        if (opts == null) {
            opts = new FileSystemOptions();
        }

        FileSystemConfigBuilder fscb = null;
        MotuConfigFileSystemWrapper<Boolean> wrapperBoolean = new MotuConfigFileSystemWrapper<Boolean>();
        MotuConfigFileSystemWrapper<Period> wrapperPeriod = new MotuConfigFileSystemWrapper<Period>();
        MotuConfigFileSystemWrapper<String> wrapperString = new MotuConfigFileSystemWrapper<String>();

        try {
            try {
                fscb = standardFileSystemManager.getFileSystemConfigBuilder(scheme);
            } catch (FileSystemException e) {
                LOG.error("setSchemeOpts(String)", e);

                fscb = standardFileSystemManager.getFileSystemConfigBuilder(VFSManager.DEFAULT_SCHEME);
            }

            if (fscb instanceof FtpFileSystemConfigBuilder) {
                FtpFileSystemConfigBuilder ftpFscb = (FtpFileSystemConfigBuilder) fscb;
                Boolean userDirIsRoot = wrapperBoolean.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_FTPUSERDIRISROOT);
                if (userDirIsRoot != null) {
                    ftpFscb.setUserDirIsRoot(opts, userDirIsRoot);
                } else {
                    ftpFscb.setUserDirIsRoot(opts, false);
                }

                Boolean passiveMode = wrapperBoolean.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_FTPPASSIVEMODE);
                ;
                if (passiveMode != null) {
                    ftpFscb.setPassiveMode(opts, passiveMode);
                }
                Period dataTimeOut = wrapperPeriod.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_FTPDATATIMEOUT);
                if (dataTimeOut != null) {
                    long value = dataTimeOut.toStandardDuration().getMillis();
                    if (value > Integer.MAX_VALUE) {
                        throw new MotuException(
                                ErrorType.MOTU_CONFIG,
                                String.format("Motu Configuration : sftp timeout value is too large '%ld' milliseconds. Max is '%d'",
                                              value,
                                              Integer.MAX_VALUE));
                    }
                    if (value > 0) {
                        ftpFscb.setDataTimeout(opts, (int) value);
                    }
                }
            }

            if (fscb instanceof HttpFileSystemConfigBuilder) {
                HttpFileSystemConfigBuilder httpFscb = (HttpFileSystemConfigBuilder) fscb;

                Boolean isUseProxy = wrapperBoolean.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_USEHTTPPROXY);
                if ((isUseProxy != null) && (isUseProxy)) {
                    String proxyHost = wrapperString.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_HTTPPROXYHOST);
                    String proxyPort = wrapperString.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_HTTPPROXYPORT);
                    httpFscb.setProxyHost(opts, proxyHost);
                    httpFscb.setProxyPort(opts, Integer.parseInt(proxyPort));
                }

            }

            if (fscb instanceof SftpFileSystemConfigBuilder) {
                SftpFileSystemConfigBuilder sftpFscb = (SftpFileSystemConfigBuilder) fscb;

                Boolean userDirIsRoot = wrapperBoolean.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_SFTPUSERDIRISROOT);
                if (userDirIsRoot != null) {
                    sftpFscb.setUserDirIsRoot(opts, userDirIsRoot);
                } else {
                    sftpFscb.setUserDirIsRoot(opts, false);
                }

                String strictHostKeyChecking = wrapperString.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_STRICTHOSTKEYCHECKING);
                if (strictHostKeyChecking != null) {
                    sftpFscb.setStrictHostKeyChecking(opts, strictHostKeyChecking);
                }

                Period SftpSessionTimeOut = wrapperPeriod.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_SFTPSESSIONTIMEOUT);
                if (SftpSessionTimeOut != null) {
                    long value = SftpSessionTimeOut.toStandardDuration().getMillis();
                    if (value > Integer.MAX_VALUE) {
                        throw new MotuException(
                                ErrorType.MOTU_CONFIG,
                                String.format("Motu Configuration : sftp timeout value is too large '%ld' milliseconds. Max is '%d'",
                                              value,
                                              Integer.MAX_VALUE));
                    }
                    if (value > 0) {
                        sftpFscb.setTimeout(opts, (int) value);
                    }
                }

                Boolean isUseProxy = wrapperBoolean.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_USESFTPPROXY);
                if ((isUseProxy != null) && (isUseProxy)) {
                    String proxyHost = wrapperString.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_SFTPPROXYHOST);
                    String proxyPort = wrapperString.getFieldValue(host, MotuConfigFileSystemWrapper.PROP_SFTPPROXYPORT);
                    sftpFscb.setProxyHost(opts, proxyHost);
                    sftpFscb.setProxyPort(opts, Integer.parseInt(proxyPort));
                }

            }

        } catch (FileSystemException e) {
            LOG.error("setSchemeOpts(String, String)", e);

            throw new MotuException(ErrorType.NETCDF_LOADING, "Error in VFSManager#setScheme", e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("setSchemeOpts(String, String) - end");
        }
        return opts;
    }

    /**
     * Sets the scheme opts.
     * 
     * @param scheme the scheme
     * @return the file system options
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setSchemeOpts(String scheme) throws MotuException {
        return setSchemeOpts(scheme, null);

    }

    /**
     * Sets the scheme opts.
     * 
     * @param url the url
     * @return the file system options
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setSchemeOpts(URL url) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setSchemeOpts(URL) - start");
        }

        try {
            FileSystemOptions returnFileSystemOptions = setSchemeOpts(url.toURI());
            if (LOG.isDebugEnabled()) {
                LOG.debug("setSchemeOpts(URL) - end");
            }
            return returnFileSystemOptions;
        } catch (URISyntaxException e) {
            LOG.error("setSchemeOpts(URL)", e);

            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to convert url '%s' to URI object ", url), e);
        }
    }

    /**
     * Sets the scheme opts.
     * 
     * @param uri the uri
     * @return the file system options
     * @throws MotuException the motu exception
     */
    public FileSystemOptions setSchemeOpts(URI uri) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("setSchemeOpts(URI) - start");
        }

        String scheme = uri.getScheme();
        String host = uri.getHost();
        FileSystemOptions returnFileSystemOptions = setSchemeOpts(scheme, host);

        String theUserInfo = uri.getUserInfo();
        if (!StringUtils.isNullOrEmpty(theUserInfo)) {
            String userInfo[] = theUserInfo.split(":");
            if (userInfo.length >= 2) {
                setUserInfo(userInfo[0], userInfo[1], returnFileSystemOptions);
            }
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("setSchemeOpts(URI) - end");
        }
        return returnFileSystemOptions;
    }

    /**
     * Close.
     */
    public void close() {
        if (isOpened()) {
            standardFileSystemManager.close();
            open = false;
        }
    }

    /**
     * Gets the uri as input stream.
     * 
     * @param uri the uri
     * 
     * @return the uri as input stream
     * 
     * @throws MotuException the motu exception
     */
    public InputStream getUriAsInputStream(String uri) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("getUriAsInputStream(String) - entering");
        }

        InputStream in = null;
        try {

            FileObject fileObject = resolveFile(uri);
            if (fileObject != null) {
                in = fileObject.getContent().getInputStream();
            }
        } catch (IOException e) {
            LOG.error("getUriAsInputStream(String)", e);

            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("'%s' uri file has not be found", uri), e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("getUriAsInputStream(String) - exiting");
        }
        return in;
    }

    /**
     * Resolve file.
     * 
     * @param uri the uri
     * 
     * @return the file object
     * 
     * @throws MotuException the motu exception
     */
    public FileObject resolveFile(final String uri) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(String) - entering");
        }

        FileObject returnFileObject = resolveFile(uri, this.opts);
        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(String) - exiting");
        }
        return returnFileObject;
    }

    /**
     * Resolve file.
     * 
     * @param uri the uri
     * @param fileSystemOptions the file system options
     * 
     * @return the file object
     * 
     * @throws MotuException the motu exception
     */
    public FileObject resolveFile(final String uri, FileSystemOptions fileSystemOptions) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(String, FileSystemOptions) - entering");
        }

        FileObject fileObject = null;
        // String userName = "";
        // String password = "";

        UserAuthenticator auth = DefaultFileSystemConfigBuilder.getInstance().getUserAuthenticator(fileSystemOptions);

        // if (auth != null) {
        // UserAuthenticationData.Type[] types = new UserAuthenticationData.Type[]
        // {UserAuthenticationData.USERNAME, UserAuthenticationData.PASSWORD,};
        //
        // UserAuthenticationData userAuthenticationData = auth.requestAuthentication(types);
        // char[] u = userAuthenticationData.getData(UserAuthenticationData.USERNAME);
        // char[] p = userAuthenticationData.getData(UserAuthenticationData.PASSWORD);
        // userName = new String(u);
        // password = new String(p);
        // }

        open();

        // if (fileSystemOptions == null) {
        // fileSystemOptions = new FileSystemOptions();
        // }

        try {
            // URI uriObject = new URI(uri);
            URI uriObject = new URI(uri.replace("\\", "/"));

            fileSystemOptions = setUserInfo(auth);
            fileSystemOptions = setSchemeOpts(uriObject);

            try {
                fileObject = standardFileSystemManager.resolveFile(uri, fileSystemOptions);
            } catch (FileSystemException e) {
                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve uri '%s' ", uri), e);
            }

        } catch (URISyntaxException e) {
            LOG.error("resolveFile(String, FileSystemOptions)", e);

            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve uri '%s' ", uri), e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(String, FileSystemOptions) - exiting");
        }
        return fileObject;

    }

    /**
     * Resolve file.
     * 
     * @param baseFile the base file
     * @param file the file
     * 
     * @return the file object
     * 
     * @throws MotuException the motu exception
     */
    public FileObject resolveFile(FileObject baseFile, final String file) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(FileObject, String) - entering");
        }

        FileObject fileObject = null;
        open();
        if (opts == null) {
            opts = new FileSystemOptions();
        }

        try {

            // setSchemeOpts(baseFile.getName().getScheme());
            setSchemeOpts(baseFile.getURL());

            fileObject = standardFileSystemManager.resolveFile(baseFile, file, opts);

        } catch (FileSystemException e) {
            throw new MotuException(
                    ErrorType.NETCDF_LOADING,
                    String.format("Unable to resolve uri '%s/%s' ", baseFile.getName().toString(), file),
                    e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("resolveFile(FileObject, String) - exiting");
        }
        return fileObject;

    }

    /**
     * Copy file.
     * 
     * @param user the user
     * @param pwd the pwd
     * @param scheme the scheme
     * @param host the host
     * @param fileSrc the file src
     * @param fileDest the file dest
     * 
     * @throws MotuExceptionBase the motu exception base
     */
    public void copyFileToLocalFile(String user, String pwd, String scheme, String host, String fileSrc, String fileDest) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFileToLocalFile(String, String, String, String, String, String) - entering");
        }

        open(user, pwd, scheme, null);

        FileObject foSrc = null;
        FileObject foDest = null;
        String uri = "";

        try {
            File newFile = VFSManager.createLocalFile(fileDest);

            uri = String.format("%s://%s/%s", scheme, host, fileSrc);
            foSrc = resolveFile(uri);
            if (foSrc == null) {
                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve source uri '%s' ", uri));
            }

            foDest = standardFileSystemManager.toFileObject(newFile);
            if (foDest == null) {
                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve dest uri '%s' ", fileDest));
            }

            this.copyFrom(foSrc, foDest, Selectors.SELECT_ALL);

        } catch (MotuException e) {
            LOG.error("copyFileToLocalFile(String, String, String, String, String, String)", e);

            throw e;
        } catch (Exception e) {
            LOG.error("copyFileToLocalFile(String, String, String, String, String, String)", e);

            // throw new MotuException(String.format("Unable to copy file '%s' to '%s'",
            // foSrc.getURL().toString(), foDest.getURL().toString()), e);
            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to copy file '%s' to '%s'", uri.toString(), fileDest), e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFileToLocalFile(String, String, String, String, String, String) - exiting");
        }
    }

    /**
     * Copy file to local file.
     * 
     * @param uriSrc the uri src
     * @param fileDest the file dest
     * 
     * @throws MotuException the motu exception
     */
    public void copyFileToLocalFile(String uriSrc, String fileDest) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFileToLocalFile(String, String) - entering");
        }

        // URI uri = new URI(uriSrc);
        //
        // String[] userInfo = uri.getUserInfo().split(":");
        // String user = "";
        // String pwd = "";
        //
        // if (userInfo.length >= 2) {
        // pwd = userInfo[1];
        // }
        //
        // if (userInfo.length >= 1) {
        // user = userInfo[0];
        // }
        //
        // copyFile(user, pwd, uri.getScheme(), uri.

        FileObject foSrc = null;
        FileObject foDest = null;

        try {
            File newFile = VFSManager.createLocalFile(fileDest);

            foSrc = resolveFile(uriSrc);
            if (foSrc == null) {
                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve source uri '%s' ", uriSrc));
            }

            foDest = standardFileSystemManager.toFileObject(newFile);
            if (foDest == null) {
                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to resolve dest uri '%s' ", newFile.getAbsolutePath()));
            }

            this.copyFrom(foSrc, foDest, Selectors.SELECT_ALL);

        } catch (MotuException e) {
            LOG.error("copyFileToLocalFile(String, String)", e);
            throw e;

        } catch (Exception e) {
            LOG.error("copyFileToLocalFile(String, String)", e);

            try {
                throw new MotuException(
                        ErrorType.NETCDF_LOADING,
                        String.format("Unable to copy file '%s' to '%s'", foSrc.getURL().toString(), foDest.getURL().toString()),
                        e);
            } catch (FileSystemException e1) {
                LOG.error("copyFileToLocalFile(String, String)", e1);

                throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to copy files", e1));
            }
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFileToLocalFile(String, String) - exiting");
        }
    }

    /**
     * Creates the local file.
     * 
     * @param localFile the local file
     * 
     * @return the file
     * 
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static File createLocalFile(String localFile) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("createLocalFile(String) - entering");
        }

        File newFile = new File(localFile);
        File path = new File(newFile.getParent());
        path.mkdirs();
        newFile.createNewFile();

        if (LOG.isDebugEnabled()) {
            LOG.debug("createLocalFile(String) - exiting");
        }
        return newFile;

    }

    /**
     * Delete a file.
     * 
     * @param file the file to delete
     * 
     * @return true, if successful
     * @throws MotuException
     */
    public boolean deleteFile(String file) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteFile(String) - entering");
        }

        FileObject fileToDelete = resolveFile(file);
        boolean returnboolean = deleteFile(fileToDelete);
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteFile(String) - exiting");
        }
        return returnboolean;
    }

    // public static boolean deleteDirectory(String path) {
    // return VFSManager.deleteDirectory(new File(path));
    //
    // }

    /**
     * Delete directory.
     * 
     * @param path the path
     * 
     * @return true, if successful
     * @throws MotuException
     */
    public boolean deleteDirectory(String path) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(String) - entering");
        }

        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(path);

        if (!(path.endsWith("/") || path.endsWith("\\"))) {
            stringBuffer.append("/");
        }
        FileObject pathToDelete = resolveFile(stringBuffer.toString());
        boolean returnboolean = deleteDirectory(pathToDelete);
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(String) - exiting");
        }
        return returnboolean;

    }

    /**
     * Delete directory �nd all descendents of the file.
     * 
     * @param file the file
     * 
     * @return true, if successful
     * @throws MotuException
     */
    public boolean deleteDirectory(FileObject file) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(FileObject) - entering");
        }

        boolean returnboolean = delete(file, Selectors.SELECT_ALL);
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(FileObject) - exiting");
        }
        return returnboolean;
    }

    /**
     * Delete directory.
     * 
     * @param path the path
     * 
     * @return true, if successful
     */
    public static boolean deleteDirectory(File path) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(File) - entering");
        }

        if (path.exists()) {
            File[] files = path.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isDirectory()) {
                    deleteDirectory(files[i]);
                } else {
                    files[i].delete();
                }
            }
        }
        boolean returnboolean = (path.delete());
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteDirectory(File) - exiting");
        }
        return returnboolean;
    }

    /**
     * Delete the file repsented by the file parameter.
     * 
     * @param file the file
     * 
     * @return true, if successful
     * @throws MotuException
     */
    public boolean deleteFile(FileObject file) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteFile(FileObject) - entering");
        }

        boolean deleted = false;
        try {

            if (file.exists()) {
                if (file.getType() != FileType.FILE) {
                    throw new MotuException(
                            ErrorType.NETCDF_LOADING,
                            String.format("Delete file '%s' is rejected: it is a folder. ", file.getName().toString()));
                }

                deleted = file.delete();
            }
        } catch (FileSystemException e) {
            LOG.error("deleteFile(FileObject)", e);

            // throw new MotuException(String.format("Unable to copy file '%s' to '%s'",
            // foSrc.getURL().toString(), foDest.getURL().toString()), e);
            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to delete '%s'", file.getName().toString()), e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("deleteFile(FileObject) - exiting");
        }
        return deleted;
    }

    /**
     * Delete all descendents of this file that match a selector.
     * 
     * @param file the file
     * @param selector the selector
     * 
     * @return true, if successful
     * @throws MotuException
     */
    public boolean delete(FileObject file, FileSelector selector) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("delete(FileObject, FileSelector) - entering");
        }

        int deleted = 0;
        try {
            if (file.exists()) {
                deleted = file.delete(selector);
            }
        } catch (FileSystemException e) {
            LOG.error("delete(FileObject, FileSelector)", e);

            // throw new MotuException(String.format("Unable to copy file '%s' to '%s'",
            // foSrc.getURL().toString(), foDest.getURL().toString()), e);
            throw new MotuException(ErrorType.NETCDF_LOADING, String.format("Unable to delete '%s'", file.getName().toString()), e);
        }
        boolean returnboolean = (deleted > 0);
        if (LOG.isDebugEnabled()) {
            LOG.debug("delete(FileObject, FileSelector) - exiting");
        }
        return returnboolean;
    }

    /**
     * Copy file.
     * 
     * @param from the from
     * @param to the to
     * 
     * @throws MotuException the motu exception
     */
    public void copyFile(String from, String to) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String) - entering");
        }

        // FileObject originBase = fsManager.resolveFile(uri, opts);
        // fsManager.setBaseFile(originBase);

        FileObject src = resolveFile(from);
        FileObject dest = resolveFile(to);
        copyFile(src, dest);

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String) - exiting");
        }
    }

    /**
     * Copy file.
     * 
     * @param from the from
     * @param to the to
     * @param optsFrom the opts from
     * @param optsTo the opts to
     * 
     * @throws MotuException the motu exception
     */
    public void copyFile(String from, String to, FileSystemOptions optsFrom, FileSystemOptions optsTo) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String, FileSystemOptions, FileSystemOptions) - entering");
        }

        FileObject src = resolveFile(from, optsFrom);
        FileObject dest = resolveFile(to, optsTo);
        copyFile(src, dest);

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String, FileSystemOptions, FileSystemOptions) - exiting");
        }
    }

    /**
     * Copy file.
     * 
     * @param from the from
     * @param to the to
     * @param userFrom the user from
     * @param pwdFrom the pwd from
     * @param userTo the user to
     * @param pwdTo the pwd to
     * 
     * @throws MotuException the motu exception
     */
    public void copyFile(String from, String to, String userFrom, String pwdFrom, String userTo, String pwdTo) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String, String, String, String, String) - entering");
        }

        opts = null;
        if (!StringUtils.isNullOrEmpty(userFrom)) {
            opts = setUserInfo(userFrom, pwdFrom);
        }
        FileObject src = resolveFile(from, opts);

        opts = null;
        if (!StringUtils.isNullOrEmpty(userTo)) {
            opts = setUserInfo(userTo, pwdTo);
        }

        FileObject dest = resolveFile(to, opts);

        copyFile(src, dest);

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(String, String, String, String, String, String) - exiting");
        }
    }

    /**
     * Copy file.
     * 
     * @param from the from
     * @param to the to
     * 
     * @throws MotuException the motu exception
     */
    public void copyFile(FileObject from, FileObject to) throws MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(FileObject, FileObject) - entering");
        }

        try {
            if ((to.exists()) && (to.getType() == FileType.FOLDER)) {
                throw new MotuException(
                        ErrorType.NETCDF_LOADING,
                        String.format("File copy from '%s' to '%s' is rejected: the destination already exists and is a folder. You were about to loose all of the content of '%s' ",
                                      from.getName().toString(),
                                      to.getName().toString(),
                                      to.getName().toString()));
            }
            this.copyFrom(from, to, Selectors.SELECT_ALL);
        } catch (MotuException e) {
            LOG.error("copyFile(FileObject, FileObject)", e);

            throw e;
        } catch (Exception e) {
            LOG.error("copyFile(FileObject, FileObject)", e);

            // throw new MotuException(String.format("Unable to copy file '%s' to '%s'",
            // foSrc.getURL().toString(), foDest.getURL().toString()), e);
            throw new MotuException(
                    ErrorType.NETCDF_LOADING,
                    String.format("Unable to copy file '%s' to '%s'", from.getName().toString(), to.getName().toString()),
                    e);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("copyFile(FileObject, FileObject) - exiting");
        }
    }

    /**
     * Refresh ftp cache.
     * 
     * @param fileObject the file object
     * @throws FileSystemException
     */
    public void refreshFtpCache(FileObject fileObject) throws FileSystemException {

        if (fileObject == null) {
            return;
        }

        if (!(fileObject.getFileSystem() instanceof FtpFileSystem)) {
            return;
        }
        if (fileObject.exists()) {
            return;
        }
        FileObject fileObjectParent = fileObject.getParent();
        if (fileObjectParent == null) {
            return;
        }

        fileObjectParent.getType(); // force to attach : needed for force refresh
        fileObjectParent.refresh();

    }

    /**
     * Copy from.
     * 
     * @param srcFile the src file
     * @param destFile the dest file
     * @param selector the selector
     * @throws FileSystemException the file system exception
     */
    public void copyFrom(FileObject srcFile, FileObject destFile, FileSelector selector) throws FileSystemException {

        // MIS-203
        refreshFtpCache(srcFile);

        destFile.copyFrom(srcFile, selector);

    }
}
