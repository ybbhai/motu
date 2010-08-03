//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.08.03 at 12:15:53 PM CEST 
//


package fr.cls.atoll.motu.library.inventory;

import java.net.URI;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.cls.atoll.motu.library.converter.jaxb.UriAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="urn" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="inventoryUrl" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "resourceOLA")
public class ResourceOLA {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(UriAdapter.class)
    @XmlSchemaType(name = "anyURI")
    protected URI urn;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(UriAdapter.class)
    @XmlSchemaType(name = "anyURI")
    protected URI inventoryUrl;

    /**
     * Gets the value of the urn property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public URI getUrn() {
        return urn;
    }

    /**
     * Sets the value of the urn property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrn(URI value) {
        this.urn = value;
    }

    /**
     * Gets the value of the inventoryUrl property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public URI getInventoryUrl() {
        return inventoryUrl;
    }

    /**
     * Sets the value of the inventoryUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInventoryUrl(URI value) {
        this.inventoryUrl = value;
    }

}
