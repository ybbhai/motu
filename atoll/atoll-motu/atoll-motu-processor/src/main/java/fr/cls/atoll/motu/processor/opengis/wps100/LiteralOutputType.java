//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.24 at 04:55:55 PM CEST 
//


package fr.cls.atoll.motu.processor.opengis.wps100;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import fr.cls.atoll.motu.processor.opengis.ows110.DomainMetadataType;


/**
 * Description of a literal output (or input). 
 * 
 * <p>Java class for LiteralOutputType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LiteralOutputType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}DataType" minOccurs="0"/>
 *         &lt;element name="UOMs" type="{http://www.opengis.net/wps/1.0.0}SupportedUOMsType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LiteralOutputType", propOrder = {
    "dataType",
    "uoMs"
})
@XmlSeeAlso({
    LiteralInputType.class
})
public class LiteralOutputType {

    @XmlElement(name = "DataType", namespace = "http://www.opengis.net/ows/1.1")
    protected DomainMetadataType dataType;
    @XmlElement(name = "UOMs", namespace = "")
    protected SupportedUOMsType uoMs;

    /**
     * Data type of this set of values (e.g. integer, real, etc). This data type metadata should be included for each quantity whose data type is not a string. 
     * 
     * @return
     *     possible object is
     *     {@link DomainMetadataType }
     *     
     */
    public DomainMetadataType getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DomainMetadataType }
     *     
     */
    public void setDataType(DomainMetadataType value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the uoMs property.
     * 
     * @return
     *     possible object is
     *     {@link SupportedUOMsType }
     *     
     */
    public SupportedUOMsType getUOMs() {
        return uoMs;
    }

    /**
     * Sets the value of the uoMs property.
     * 
     * @param value
     *     allowed object is
     *     {@link SupportedUOMsType }
     *     
     */
    public void setUOMs(SupportedUOMsType value) {
        this.uoMs = value;
    }

}
