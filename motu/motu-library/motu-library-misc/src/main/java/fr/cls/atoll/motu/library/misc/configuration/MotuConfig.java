//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.20 at 05:26:30 PM CEST 
//


package fr.cls.atoll.motu.library.misc.configuration;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.cls.atoll.motu.library.converter.jaxb.JodaPeriodAdapter;
import org.joda.time.Period;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="configService" type="{}configService" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="queueServerConfig" type="{}queueServerType"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}proxyOptions"/>
 *       &lt;attGroup ref="{}ftpOptions"/>
 *       &lt;attGroup ref="{}sftpOptions"/>
 *       &lt;attribute name="defaultService" type="{http://www.w3.org/2001/XMLSchema}string" default="aviso_nrt" />
 *       &lt;attribute name="useAuthentication" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="authFilePath" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="dataBlockSize" type="{http://www.w3.org/2001/XMLSchema}integer" default="2048" />
 *       &lt;attribute name="maxSizePerFile" type="{http://www.w3.org/2001/XMLSchema}integer" default="1024" />
 *       &lt;attribute name="extractionPath" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="downloadHttpUrl" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="httpDocumentRoot" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="cleanRequestInterval" default="60">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="cleanExtractionFileInterval" default="60">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="extractionFilePatterns" type="{http://www.w3.org/2001/XMLSchema}string" default=".*\.nc$|.*\.zip$|.*\.tar$|.*\.gz$|.*\.extract$|wps_output_.*$|wps_response_.*$" />
 *       &lt;attribute name="extractionFileCacheSize" default="0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="runCleanInterval" default="1">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="1"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="runGCInterval" default="0">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *             &lt;minInclusive value="0"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *       &lt;attribute name="casRestUrlSuffix" type="{http://www.w3.org/2001/XMLSchema}string" default="/v1/tickets" />
 *       &lt;attribute name="commonVeloTemplatePrefix" type="{http://www.w3.org/2001/XMLSchema}string" default="myocean" />
 *       &lt;attribute name="commonDefaultLanguage" type="{http://www.w3.org/2001/XMLSchema}string" default="UK" />
 *       &lt;attribute name="httpBaseRef" type="{http://www.w3.org/2001/XMLSchema}string" default="http://www.myocean.eu.org" />
 *       &lt;attribute name="defaultActionIsListServices" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "configService",
    "queueServerConfig"
})
@XmlRootElement(name = "motuConfig")
public class MotuConfig {

    protected List<ConfigService> configService;
    @XmlElement(required = true)
    protected QueueServerType queueServerConfig;
    @XmlAttribute
    protected String defaultService;
    @XmlAttribute
    protected Boolean useAuthentication;
    @XmlAttribute
    protected String authFilePath;
    @XmlAttribute
    protected BigInteger dataBlockSize;
    @XmlAttribute
    protected BigInteger maxSizePerFile;
    @XmlAttribute(required = true)
    protected String extractionPath;
    @XmlAttribute(required = true)
    protected String downloadHttpUrl;
    @XmlAttribute(required = true)
    protected String httpDocumentRoot;
    @XmlAttribute
    protected Integer cleanRequestInterval;
    @XmlAttribute
    protected Integer cleanExtractionFileInterval;
    @XmlAttribute
    protected String extractionFilePatterns;
    @XmlAttribute
    protected Integer extractionFileCacheSize;
    @XmlAttribute
    protected Integer runCleanInterval;
    @XmlAttribute
    protected Integer runGCInterval;
    @XmlAttribute
    protected String casRestUrlSuffix;
    @XmlAttribute
    protected String commonVeloTemplatePrefix;
    @XmlAttribute
    protected String commonDefaultLanguage;
    @XmlAttribute
    protected String httpBaseRef;
    @XmlAttribute
    protected Boolean defaultActionIsListServices;
    @XmlAttribute
    protected Boolean useProxy;
    @XmlAttribute
    protected String proxyLogin;
    @XmlAttribute
    protected String proxyPwd;
    @XmlAttribute
    protected String proxyHost;
    @XmlAttribute
    protected String proxyPort;
    @XmlAttribute
    protected Boolean ftpUserDirIsRoot;
    @XmlAttribute
    protected Boolean ftpPassiveMode;
    @XmlAttribute
    @XmlJavaTypeAdapter(JodaPeriodAdapter.class)
    @XmlSchemaType(name = "duration")
    protected Period ftpDataTimeOut;
    @XmlAttribute
    protected Boolean sftpUserDirIsRoot;
    @XmlAttribute
    @XmlJavaTypeAdapter(JodaPeriodAdapter.class)
    @XmlSchemaType(name = "duration")
    protected Period sftpSessionTimeOut;
    @XmlAttribute
    protected String strictHostKeyChecking;

    /**
     * Gets the value of the configService property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the configService property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConfigService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConfigService }
     * 
     * 
     */
    public List<ConfigService> getConfigService() {
        if (configService == null) {
            configService = new ArrayList<ConfigService>();
        }
        return this.configService;
    }

    /**
     * Gets the value of the queueServerConfig property.
     * 
     * @return
     *     possible object is
     *     {@link QueueServerType }
     *     
     */
    public QueueServerType getQueueServerConfig() {
        return queueServerConfig;
    }

    /**
     * Sets the value of the queueServerConfig property.
     * 
     * @param value
     *     allowed object is
     *     {@link QueueServerType }
     *     
     */
    public void setQueueServerConfig(QueueServerType value) {
        this.queueServerConfig = value;
    }

    /**
     * Gets the value of the defaultService property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDefaultService() {
        if (defaultService == null) {
            return "aviso_nrt";
        } else {
            return defaultService;
        }
    }

    /**
     * Sets the value of the defaultService property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDefaultService(String value) {
        this.defaultService = value;
    }

    /**
     * Gets the value of the useAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUseAuthentication() {
        if (useAuthentication == null) {
            return false;
        } else {
            return useAuthentication;
        }
    }

    /**
     * Sets the value of the useAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseAuthentication(Boolean value) {
        this.useAuthentication = value;
    }

    /**
     * Gets the value of the authFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthFilePath() {
        return authFilePath;
    }

    /**
     * Sets the value of the authFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthFilePath(String value) {
        this.authFilePath = value;
    }

    /**
     * Gets the value of the dataBlockSize property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getDataBlockSize() {
        if (dataBlockSize == null) {
            return new BigInteger("2048");
        } else {
            return dataBlockSize;
        }
    }

    /**
     * Sets the value of the dataBlockSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setDataBlockSize(BigInteger value) {
        this.dataBlockSize = value;
    }

    /**
     * Gets the value of the maxSizePerFile property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getMaxSizePerFile() {
        if (maxSizePerFile == null) {
            return new BigInteger("1024");
        } else {
            return maxSizePerFile;
        }
    }

    /**
     * Sets the value of the maxSizePerFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setMaxSizePerFile(BigInteger value) {
        this.maxSizePerFile = value;
    }

    /**
     * Gets the value of the extractionPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractionPath() {
        return extractionPath;
    }

    /**
     * Sets the value of the extractionPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractionPath(String value) {
        this.extractionPath = value;
    }

    /**
     * Gets the value of the downloadHttpUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDownloadHttpUrl() {
        return downloadHttpUrl;
    }

    /**
     * Sets the value of the downloadHttpUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDownloadHttpUrl(String value) {
        this.downloadHttpUrl = value;
    }

    /**
     * Gets the value of the httpDocumentRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpDocumentRoot() {
        return httpDocumentRoot;
    }

    /**
     * Sets the value of the httpDocumentRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpDocumentRoot(String value) {
        this.httpDocumentRoot = value;
    }

    /**
     * Gets the value of the cleanRequestInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getCleanRequestInterval() {
        if (cleanRequestInterval == null) {
            return  60;
        } else {
            return cleanRequestInterval;
        }
    }

    /**
     * Sets the value of the cleanRequestInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCleanRequestInterval(Integer value) {
        this.cleanRequestInterval = value;
    }

    /**
     * Gets the value of the cleanExtractionFileInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getCleanExtractionFileInterval() {
        if (cleanExtractionFileInterval == null) {
            return  60;
        } else {
            return cleanExtractionFileInterval;
        }
    }

    /**
     * Sets the value of the cleanExtractionFileInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCleanExtractionFileInterval(Integer value) {
        this.cleanExtractionFileInterval = value;
    }

    /**
     * Gets the value of the extractionFilePatterns property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtractionFilePatterns() {
        if (extractionFilePatterns == null) {
            return ".*\\.nc$|.*\\.zip$|.*\\.tar$|.*\\.gz$|.*\\.extract$|wps_output_.*$|wps_response_.*$";
        } else {
            return extractionFilePatterns;
        }
    }

    /**
     * Sets the value of the extractionFilePatterns property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtractionFilePatterns(String value) {
        this.extractionFilePatterns = value;
    }

    /**
     * Gets the value of the extractionFileCacheSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getExtractionFileCacheSize() {
        if (extractionFileCacheSize == null) {
            return  0;
        } else {
            return extractionFileCacheSize;
        }
    }

    /**
     * Sets the value of the extractionFileCacheSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setExtractionFileCacheSize(Integer value) {
        this.extractionFileCacheSize = value;
    }

    /**
     * Gets the value of the runCleanInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getRunCleanInterval() {
        if (runCleanInterval == null) {
            return  1;
        } else {
            return runCleanInterval;
        }
    }

    /**
     * Sets the value of the runCleanInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunCleanInterval(Integer value) {
        this.runCleanInterval = value;
    }

    /**
     * Gets the value of the runGCInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public int getRunGCInterval() {
        if (runGCInterval == null) {
            return  0;
        } else {
            return runGCInterval;
        }
    }

    /**
     * Sets the value of the runGCInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRunGCInterval(Integer value) {
        this.runGCInterval = value;
    }

    /**
     * Gets the value of the casRestUrlSuffix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCasRestUrlSuffix() {
        if (casRestUrlSuffix == null) {
            return "/v1/tickets";
        } else {
            return casRestUrlSuffix;
        }
    }

    /**
     * Sets the value of the casRestUrlSuffix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCasRestUrlSuffix(String value) {
        this.casRestUrlSuffix = value;
    }

    /**
     * Gets the value of the commonVeloTemplatePrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonVeloTemplatePrefix() {
        if (commonVeloTemplatePrefix == null) {
            return "myocean";
        } else {
            return commonVeloTemplatePrefix;
        }
    }

    /**
     * Sets the value of the commonVeloTemplatePrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonVeloTemplatePrefix(String value) {
        this.commonVeloTemplatePrefix = value;
    }

    /**
     * Gets the value of the commonDefaultLanguage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCommonDefaultLanguage() {
        if (commonDefaultLanguage == null) {
            return "UK";
        } else {
            return commonDefaultLanguage;
        }
    }

    /**
     * Sets the value of the commonDefaultLanguage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCommonDefaultLanguage(String value) {
        this.commonDefaultLanguage = value;
    }

    /**
     * Gets the value of the httpBaseRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHttpBaseRef() {
        if (httpBaseRef == null) {
            return "http://www.myocean.eu.org";
        } else {
            return httpBaseRef;
        }
    }

    /**
     * Sets the value of the httpBaseRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHttpBaseRef(String value) {
        this.httpBaseRef = value;
    }

    /**
     * Gets the value of the defaultActionIsListServices property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isDefaultActionIsListServices() {
        if (defaultActionIsListServices == null) {
            return false;
        } else {
            return defaultActionIsListServices;
        }
    }

    /**
     * Sets the value of the defaultActionIsListServices property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDefaultActionIsListServices(Boolean value) {
        this.defaultActionIsListServices = value;
    }

    /**
     * Gets the value of the useProxy property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isUseProxy() {
        if (useProxy == null) {
            return false;
        } else {
            return useProxy;
        }
    }

    /**
     * Sets the value of the useProxy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseProxy(Boolean value) {
        this.useProxy = value;
    }

    /**
     * Gets the value of the proxyLogin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyLogin() {
        return proxyLogin;
    }

    /**
     * Sets the value of the proxyLogin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyLogin(String value) {
        this.proxyLogin = value;
    }

    /**
     * Gets the value of the proxyPwd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyPwd() {
        return proxyPwd;
    }

    /**
     * Sets the value of the proxyPwd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyPwd(String value) {
        this.proxyPwd = value;
    }

    /**
     * Gets the value of the proxyHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyHost() {
        if (proxyHost == null) {
            return "proxy-prod.cls.fr";
        } else {
            return proxyHost;
        }
    }

    /**
     * Sets the value of the proxyHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyHost(String value) {
        this.proxyHost = value;
    }

    /**
     * Gets the value of the proxyPort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProxyPort() {
        if (proxyPort == null) {
            return "8080";
        } else {
            return proxyPort;
        }
    }

    /**
     * Sets the value of the proxyPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProxyPort(String value) {
        this.proxyPort = value;
    }

    /**
     * Gets the value of the ftpUserDirIsRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFtpUserDirIsRoot() {
        return ftpUserDirIsRoot;
    }

    /**
     * Sets the value of the ftpUserDirIsRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFtpUserDirIsRoot(Boolean value) {
        this.ftpUserDirIsRoot = value;
    }

    /**
     * Gets the value of the ftpPassiveMode property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isFtpPassiveMode() {
        return ftpPassiveMode;
    }

    /**
     * Sets the value of the ftpPassiveMode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setFtpPassiveMode(Boolean value) {
        this.ftpPassiveMode = value;
    }

    /**
     * Gets the value of the ftpDataTimeOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Period getFtpDataTimeOut() {
        return ftpDataTimeOut;
    }

    /**
     * Sets the value of the ftpDataTimeOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFtpDataTimeOut(Period value) {
        this.ftpDataTimeOut = value;
    }

    /**
     * Gets the value of the sftpUserDirIsRoot property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSftpUserDirIsRoot() {
        return sftpUserDirIsRoot;
    }

    /**
     * Sets the value of the sftpUserDirIsRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSftpUserDirIsRoot(Boolean value) {
        this.sftpUserDirIsRoot = value;
    }

    /**
     * Gets the value of the sftpSessionTimeOut property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Period getSftpSessionTimeOut() {
        if (sftpSessionTimeOut == null) {
            return new JodaPeriodAdapter().unmarshal("PT0M");
        } else {
            return sftpSessionTimeOut;
        }
    }

    /**
     * Sets the value of the sftpSessionTimeOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSftpSessionTimeOut(Period value) {
        this.sftpSessionTimeOut = value;
    }

    /**
     * Gets the value of the strictHostKeyChecking property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrictHostKeyChecking() {
        if (strictHostKeyChecking == null) {
            return "no";
        } else {
            return strictHostKeyChecking;
        }
    }

    /**
     * Sets the value of the strictHostKeyChecking property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrictHostKeyChecking(String value) {
        this.strictHostKeyChecking = value;
    }

}
