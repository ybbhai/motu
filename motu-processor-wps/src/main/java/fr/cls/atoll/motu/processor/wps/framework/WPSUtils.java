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
package fr.cls.atoll.motu.processor.wps.framework;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.deegree.commons.utils.HttpUtils;
import org.deegree.commons.utils.HttpUtils.Worker;
import org.deegree.services.wps.input.LiteralInput;

import fr.cls.atoll.motu.api.message.xml.ErrorType;
import fr.cls.atoll.motu.library.cas.HttpClientCAS;
import fr.cls.atoll.motu.library.cas.util.HttpUtil;
import fr.cls.atoll.motu.library.misc.exception.MotuException;
import fr.cls.atoll.motu.library.misc.intfce.Organizer;

/**
 * <br>
 * <br>
 * Copyright : Copyright (c) 2009. <br>
 * <br>
 * Soci�t� : CLS (Collecte Localisation Satellites)
 * 
 * @author $Author: dearith $
 * @version $Revision: 1.7 $ - $Date: 2009-10-29 10:52:04 $
 */
public class WPSUtils {
    /**
     * Logger for this class
     */
    private static final Logger LOG = Logger.getLogger(WPSUtils.class);

    /** The Constant PROCESSLET_EXCEPTION_FORMAT_CODE. */
    public static final String PROCESSLET_EXCEPTION_FORMAT_CODE = "ERROR - Code: ";

    /** The Constant PROCESSLET_EXCEPTION_FORMAT_MSG. */
    public static final String PROCESSLET_EXCEPTION_FORMAT_MSG = ", Message: ";

    /** The Constant PROCESSLET_EXCEPTION_INDEX_MAX. */
    public final static int PROCESSLET_EXCEPTION_INDEX_MAX = 4;

    /** The Constant PROCESSLET_EXCEPTION_FORMAT_CODE_INDEX. */
    public final static int PROCESSLET_EXCEPTION_FORMAT_CODE_INDEX = 1;

    /** The Constant PROCESSLET_EXCEPTION_MSG_VALUE_INDEX. */
    public final static int PROCESSLET_EXCEPTION_FORMAT_MSG_INDEX = 3;

    /** The Constant PROCESSLET_EXCEPTION_CODE_VALUE_INDEX. */
    public final static int PROCESSLET_EXCEPTION_CODE_VALUE_INDEX = 2;

    /** The Constant PROCESSLET_EXCEPTION_MSG_VALUE_INDEX. */
    public final static int PROCESSLET_EXCEPTION_MSG_VALUE_INDEX = WPSUtils.PROCESSLET_EXCEPTION_INDEX_MAX;

    /**
     * Instantiates a new wPS utils.
     */
    public WPSUtils() {
    }

    /**
     * Post.
     * 
     * @param url the url
     * @param urlFile the url file
     * 
     * @return the input stream
     * 
     * @throws MotuException the motu exception
     */
    public static InputStream post(String url, URL urlFile) throws MotuException {
        return WPSUtils.post(url, urlFile, null);
    }

    
    public static InputStream post(String url, URL urlFile, Map<String, String> headers) throws MotuException {
        return WPSUtils.post(url, urlFile.toString(), headers);
    }
    /**
     * Post.
     * 
     * @param url the url
     * @param xmlFile the xml file
     * 
     * @return the input stream
     * 
     * @throws MotuException the motu exception
     */
    public static InputStream post(String url, String xmlFile) throws MotuException {
    	return post(url, xmlFile, null);
    }
    
    /**
     * Post.
     *
     * @param url the url
     * @param xmlFile the xml file
     * @param headers the headers
     * @return the input stream
     * @throws MotuException the motu exception
     */
    public static InputStream post(String url, String xmlFile, Map<String, String> headers) throws MotuException {

        if (Organizer.isNullOrEmpty(url)) {
            throw new MotuException("WPSUtils#post - Unable to process : url is null or empty.");
        }

        InputStream in = null;
        try {
            in = Organizer.getUriAsInputStream(xmlFile);

        } catch (Exception e) {
            throw new MotuException("WPSUtils#post - Unable to process.", e);
        }

        if (in == null) {
            throw new MotuException("WPSUtils#post - Unable to process : null input stream.");
        }

        return WPSUtils.post(url, in, headers);
    }

    /**
     * Post.
     * 
     * @param url the url
     * @param in the in
     * 
     * @return the input stream
     * 
     * @throws MotuException the motu exception
     */
    public static InputStream post(String url, InputStream in) throws MotuException {
    	return post(url, in, null);
    }    
    public static InputStream post(String url, InputStream in, Map<String, String> headers) throws MotuException {

        if (in == null) {
            throw new MotuException("WPSUtils#post - Unable to process : null input stream.");
        }

        InputStream is = null;
        
        Map<String, String> headersToUse = headers;
        
        if (headersToUse == null) {
        	headersToUse = new HashMap<String, String>();
        }
        try {
            is = WPSUtils.post(HttpUtils.STREAM, url, in, headersToUse);

        } catch (Exception e) {
            throw new MotuException("WPSUtils#post - Unable to process.", e);
        }

        if (is == null) {
            throw new MotuException("WPSUtils#post - Unable to process : post return a null input stream.");
        }

        return is;
    }

    /**
     * Performs an HTTP-Get request and provides typed access to the response.
     * 
     * @param <T>
     * @param worker
     * @param url
     * @param postBody
     * @param headers
     * @return some object from the url
     * @throws HttpException
     * @throws IOException
     * @throws MotuException 
     */
    public static <T> T post(Worker<T> worker, String url, InputStream postBody, Map<String, String> headers) throws HttpException, IOException, MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - start");
        }

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            IOUtils.copy(postBody, out);
        } finally {
            IOUtils.closeQuietly(out);
        }

        InputStream postBodyCloned = new ByteArrayInputStream(out.toString().getBytes());

        MultiThreadedHttpConnectionManager connectionManager = HttpUtil.createConnectionManager();
        HttpClientCAS client = new HttpClientCAS(connectionManager);
        
        HttpClientParams clientParams = new HttpClientParams();
        //clientParams.setParameter("http.protocol.allow-circular-redirects", true); //HttpClientParams.ALLOW_CIRCULAR_REDIRECTS
        client.setParams(clientParams);
        
        PostMethod post = new PostMethod(url);
        post.getParams().setCookiePolicy(CookiePolicy.RFC_2109);

        InputStreamRequestEntity inputStreamRequestEntity = new InputStreamRequestEntity(postBody);
        post.setRequestEntity(inputStreamRequestEntity);
        for (String key : headers.keySet()) {
            post.setRequestHeader(key, headers.get(key));
        }

        
        String query = post.getQueryString();
        
        // Check redirection
        // DONT USE post.setFollowRedirects(true); see http://hc.apache.org/httpclient-3.x/redirects.html
   
        int httpReturnCode = client.executeMethod(post);
        if (LOG.isDebugEnabled()) {
            String msg = String.format("Executing the query:\n==> http code: '%d':\n==> url: '%s'\n==> body:\n'%s'", httpReturnCode, url, query);
            LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - end - " + msg);
        }
        
        if (httpReturnCode == 302) {
	        post.releaseConnection();
        	String redirectLocation = null;
	        Header locationHeader = post.getResponseHeader("location");
	        
	        if (locationHeader != null) {
	            redirectLocation = locationHeader.getValue();
	            if (!WPSUtils.isNullOrEmpty(redirectLocation)) {
		            if (LOG.isDebugEnabled()) {
		                String msg = String.format("Query is redirected to url: '%s'", redirectLocation);
		                LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - end - " + msg);
		            }
		            post = new PostMethod(url);
		            post.setRequestEntity(new InputStreamRequestEntity(postBodyCloned)); // Recrire un nouveau InputStream
		            for (String key : headers.keySet()) {
		                post.setRequestHeader(key, headers.get(key));
		            }
	
		            clientParams.setBooleanParameter(HttpClientCAS.ADD_CAS_TICKET_PARAM, false);
		            httpReturnCode = client.executeMethod(post);
		            clientParams.setBooleanParameter(HttpClientCAS.ADD_CAS_TICKET_PARAM, true);
		            		            
		            if (LOG.isDebugEnabled()) {
		                String msg = String.format("Executing the query:\n==> http code: '%d':\n==> url: '%s'\n==> body:\n'%s'", httpReturnCode, url, query);
		                LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - end - " + msg);
		            }

		            
	            }
	        	
	        }
        }
        

        T returnValue = worker.work(post.getResponseBodyAsStream());

        if (httpReturnCode >= 400) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - end");
            }

            String msg = String.format("Error while executing the query:\n==> http code: '%d':\n==> url: '%s'\n==> body:\n'%s'", httpReturnCode, url, query);
            throw new MotuException(msg);
        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("post(Worker<T>, String, InputStream, Map<String,String>) - end");
        }
        return returnValue;
    }

    /**
     * Stream to string.
     *
     * @param is the is
     * @return the string
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static String streamToString(InputStream is) throws IOException {
        /*
         * To convert the InputStream to String we use the BufferedReader.readLine() method. We iterate until
         * the BufferedReader return null which means there's no more data to read. Each line will appended to
         * a StringBuilder and returned as String.
         */
        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                while ((line = reader.readLine()) != null) {
                    sb.append(line).append("\n");
                }
            } finally {
                is.close();
            }
            return sb.toString();
        } else {
            return "";
        }
    }

    /**
     * Gets the.
     * 
     * @param url the url
     * 
     * @return the input stream
     * 
     * @throws MotuException the motu exception
     */
    public static InputStream get(String url) throws MotuException {

        if (Organizer.isNullOrEmpty(url)) {
            throw new MotuException("WPSUtils#get - Unable to process : url is null or empty.");
        }

        InputStream in = null;
        Map<String, String> headers = new HashMap<String, String>();
        try {
            in = WPSUtils.get(HttpUtils.STREAM, url, headers);

        } catch (MotuException e) {
            throw new MotuException("WPSUtils#get - Unable to process url: " + url + " - Reason: " + e.notifyException());
        } catch (Exception e) {
            throw new MotuException("WPSUtils#get - Unable to process url: " + url + " - Reason: " + e.getMessage());
        }

        if (in == null) {
            throw new MotuException("WPSUtils#get - Unable to process : get return a null input stream.");
        }

        return in;
    }
    /**
     * Performs an HTTP-Get request and provides typed access to the response.
     * 
     * @param <T>
     * @param worker
     * @param url
     * @param headers
     * @return some object from the url
     * @throws HttpException
     * @throws IOException
     * @throws MotuException 
     */
    public static <T> T get( Worker<T> worker, String url, Map<String,String> headers)
                            throws HttpException, IOException, MotuException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("get(Worker<T>, String, Map<String,String>) - start");
        }
        MultiThreadedHttpConnectionManager connectionManager = HttpUtil.createConnectionManager();
        HttpClientCAS client = new HttpClientCAS(connectionManager);

        HttpClientParams clientParams = new HttpClientParams();
        //clientParams.setParameter("http.protocol.allow-circular-redirects", true); //HttpClientParams.ALLOW_CIRCULAR_REDIRECTS
        clientParams.setParameter(HttpClientParams.ALLOW_CIRCULAR_REDIRECTS, true);
        client.setParams(clientParams);

        GetMethod get = new GetMethod( url );
        for ( String key : headers.keySet() ) {
            get.setRequestHeader( key, headers.get( key ));    
        }      
        
        String query = get.getQueryString();
        get.setFollowRedirects(true);
        
        int httpReturnCode = client.executeMethod( get );

        if (LOG.isDebugEnabled()) {
            String msg = String.format("Executing the query:\n==> http code: '%d':\n==> url: '%s'\n==> body:\n'%s'", httpReturnCode, url, query);
            LOG.debug("get(Worker<T>, String, Map<String,String>) - end" + msg);
        }

        T returnValue = worker.work( get.getResponseBodyAsStream());
        
        if (httpReturnCode >= 400) {

            String msg = String.format("Error while executing the query:\n==> http code: '%d':\n==> url: '%s'\n==> body:\n'%s'", httpReturnCode, url, query);
            throw new MotuException(msg);

        }

        if (LOG.isDebugEnabled()) {
            LOG.debug("get(Worker<T>, String, Map<String,String>) - end");
        }
        return returnValue;
    }    
    /**
     * Encode processlet exception error message.
     * 
     * @param code the code
     * @param msg the msg
     * 
     * @return the string
     */
    public static String encodeProcessletExceptionErrorMessage(ErrorType code, String msg) {
        return encodeProcessletExceptionErrorMessage(code.toString(), msg);
    }

    /**
     * Encode processlet exception error message.
     * 
     * @param code the code
     * @param msg the msg
     * 
     * @return the string
     */
    public static String encodeProcessletExceptionErrorMessage(String code, String msg) {
        return String.format(WPSUtils.PROCESSLET_EXCEPTION_FORMAT_CODE + "%s" + WPSUtils.PROCESSLET_EXCEPTION_FORMAT_MSG + "%s", code, msg);
    }

    /**
     * Decode processlet exception error message.
     * 
     * @param msg the msg
     * 
     * @return the list< string>
     */
    public static List<String> decodeProcessletExceptionErrorMessage(String msg) {

        List<String> result = new ArrayList<String>();

        String regExpr = "(" + WPSUtils.PROCESSLET_EXCEPTION_FORMAT_CODE + ")(.*)(" + WPSUtils.PROCESSLET_EXCEPTION_FORMAT_MSG + ")(.*)";

        Pattern p = Pattern.compile(regExpr);

        Matcher matcher = p.matcher(msg);
        boolean matchFound = matcher.find();

        // Find all matches
        if (matchFound) {
            // Get all groups for this match
            for (int i = 0; i <= matcher.groupCount(); i++) {
                String groupStr = matcher.group(i);
                result.add(groupStr);
            }
        }

        return result;
    }

    /**
     * Gets the code from processlet exception error message.
     * 
     * @param msg the msg
     * 
     * @return the code from processlet exception error message
     */
    public static String getCodeFromProcessletExceptionErrorMessage(String msg) {

        return getCodeFromProcessletExceptionErrorMessage(WPSUtils.decodeProcessletExceptionErrorMessage(msg));

    }

    /**
     * Gets the code from processlet exception error message.
     * 
     * @param decodedMsg the decoded msg
     * 
     * @return the code from processlet exception error message
     */
    public static String getCodeFromProcessletExceptionErrorMessage(List<String> decodedMsg) {

        if (decodedMsg.size() != (WPSUtils.PROCESSLET_EXCEPTION_INDEX_MAX + 1)) {
            return "";
        }

        return decodedMsg.get(WPSUtils.PROCESSLET_EXCEPTION_CODE_VALUE_INDEX);
    }

    /**
     * Gets the msg from processlet exception error message.
     * 
     * @param msg the msg
     * 
     * @return the msg from processlet exception error message
     */
    public static String getMsgFromProcessletExceptionErrorMessage(String msg) {

        return getMsgFromProcessletExceptionErrorMessage(WPSUtils.decodeProcessletExceptionErrorMessage(msg));

    }

    /**
     * Gets the msg from processlet exception error message.
     * 
     * @param decodedMsg the decoded msg
     * 
     * @return the msg from processlet exception error message
     */
    public static String getMsgFromProcessletExceptionErrorMessage(List<String> decodedMsg) {

        if (decodedMsg.size() != (WPSUtils.PROCESSLET_EXCEPTION_INDEX_MAX + 1)) {
            return "";
        }

        return decodedMsg.get(WPSUtils.PROCESSLET_EXCEPTION_MSG_VALUE_INDEX);
    }

    /**
     * Checks if is processlet exception error message encode.
     * 
     * @param msg the msg
     * 
     * @return true, if is processlet exception error message encode
     */
    public static boolean isProcessletExceptionErrorMessageEncode(String msg) {

        List<String> result = decodeProcessletExceptionErrorMessage(msg);

        if (result.size() != (WPSUtils.PROCESSLET_EXCEPTION_INDEX_MAX + 1)) {
            return false;
        }

        return (result.get(WPSUtils.PROCESSLET_EXCEPTION_FORMAT_CODE_INDEX).equals(WPSUtils.PROCESSLET_EXCEPTION_FORMAT_CODE) && result
                .get(WPSUtils.PROCESSLET_EXCEPTION_FORMAT_MSG_INDEX).equals(WPSUtils.PROCESSLET_EXCEPTION_FORMAT_MSG));

    }

    /**
     * Test if a string is null or empty.
     * 
     * @param value string to be tested.
     * 
     * @return true if string is null or empty, otherwise false.
     */
    public static boolean isNullOrEmpty(String value) {
        if (value == null) {
            return true;
        }
        if (value.equals("")) {
            return true;
        }
        return false;
    }

    /**
     * Checks if is null or empty.
     * 
     * @param value the value
     * 
     * @return true, if is null or empty
     */
    public static boolean isNullOrEmpty(LiteralInput value) {
        if (value == null) {
            return true;
        }

        return WPSUtils.isNullOrEmpty(value.getValue());
    }

}