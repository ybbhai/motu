//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2012.12.05 at 02:32:28 PM CET 
//


package fr.cls.atoll.motu.library.misc.configuration;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the fr.cls.atoll.motu.library.misc.configuration package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: fr.cls.atoll.motu.library.misc.configuration
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ConfigFileSystemType }
     * 
     */
    public ConfigFileSystemType createConfigFileSystemType() {
        return new ConfigFileSystemType();
    }

    /**
     * Create an instance of {@link QueueType }
     * 
     */
    public QueueType createQueueType() {
        return new QueueType();
    }

    /**
     * Create an instance of {@link CatalogService }
     * 
     */
    public CatalogService createCatalogService() {
        return new CatalogService();
    }

    /**
     * Create an instance of {@link ConfigService }
     * 
     */
    public ConfigService createConfigService() {
        return new ConfigService();
    }

    /**
     * Create an instance of {@link MotuConfig }
     * 
     */
    public MotuConfig createMotuConfig() {
        return new MotuConfig();
    }

    /**
     * Create an instance of {@link QueueServerType }
     * 
     */
    public QueueServerType createQueueServerType() {
        return new QueueServerType();
    }

}
