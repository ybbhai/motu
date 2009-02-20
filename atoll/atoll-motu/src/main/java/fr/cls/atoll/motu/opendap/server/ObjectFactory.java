//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.21 at 08:38:29 AM CET 
//

package fr.cls.atoll.motu.opendap.server;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated
 * in the fr.cls.atoll.motu.opendap.server package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML
 * content. The Java representation of XML content can consist of schema derived interfaces and classes
 * representing the binding of schema type definitions, element declarations and model groups. Factory methods
 * for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for
     * package: fr.cls.atoll.motu.opendap.server
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Catalog }
     * 
     */
    public Catalog createCatalog() {
        return new Catalog();
    }

    /**
     * Create an instance of {@link Documentation }
     * 
     */
    public Documentation createDocumentation() {
        return new Documentation();
    }

    /**
     * Create an instance of {@link Access }
     * 
     */
    public Access createAccess() {
        return new Access();
    }

    /**
     * Create an instance of {@link Service }
     * 
     */
    public Service createService() {
        return new Service();
    }

    /**
     * Create an instance of {@link Property }
     * 
     */
    public Property createProperty() {
        return new Property();
    }

    /**
     * Create an instance of {@link Dataset }
     * 
     */
    public Dataset createDataset() {
        return new Dataset();
    }

    /**
     * Create an instance of {@link Variable }
     * 
     */
    public Variable createVariable() {
        return new Variable();
    }

    /**
     * Create an instance of {@link FileAccess }
     * 
     */
    public FileAccess createFileAccess() {
        return new FileAccess();
    }

    /**
     * Create an instance of {@link Any }
     * 
     */
    public Any createAny() {
        return new Any();
    }

    /**
     * Create an instance of {@link CatalogRef }
     * 
     */
    public CatalogRef createCatalogRef() {
        return new CatalogRef();
    }

    /**
     * Create an instance of {@link Aggregation }
     * 
     */
    public Aggregation createAggregation() {
        return new Aggregation();
    }

    /**
     * Create an instance of {@link Metadata }
     * 
     */
    public Metadata createMetadata() {
        return new Metadata();
    }

    /**
     * Create an instance of {@link FileScan }
     * 
     */
    public FileScan createFileScan() {
        return new FileScan();
    }

}
