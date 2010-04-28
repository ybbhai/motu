//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.28 at 03:32:09 PM CEST 
//


package fr.cls.atoll.motu.api.message.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 					Response on a metadata query of a product.
 * 				
 * 
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}timeCoverage" minOccurs="0"/>
 *         &lt;element ref="{}availableTimes" minOccurs="0"/>
 *         &lt;element ref="{}geospatialCoverage" minOccurs="0"/>
 *         &lt;element ref="{}variablesVocabulary" minOccurs="0"/>
 *         &lt;element ref="{}variables" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}codeMsg"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "timeCoverage",
    "availableTimes",
    "geospatialCoverage",
    "variablesVocabulary",
    "variables",
    "properties"
})
@XmlRootElement(name = "productMetadataInfo")
public class ProductMetadataInfo {

    protected TimeCoverage timeCoverage;
    protected AvailableTimes availableTimes;
    protected GeospatialCoverage geospatialCoverage;
    protected VariablesVocabulary variablesVocabulary;
    protected Variables variables;
    protected Properties properties;
    @XmlAttribute
    protected String msg;
    @XmlAttribute
    protected ErrorType code;

    /**
     * Gets the value of the timeCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link TimeCoverage }
     *     
     */
    public TimeCoverage getTimeCoverage() {
        return timeCoverage;
    }

    /**
     * Sets the value of the timeCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeCoverage }
     *     
     */
    public void setTimeCoverage(TimeCoverage value) {
        this.timeCoverage = value;
    }

    /**
     * Gets the value of the availableTimes property.
     * 
     * @return
     *     possible object is
     *     {@link AvailableTimes }
     *     
     */
    public AvailableTimes getAvailableTimes() {
        return availableTimes;
    }

    /**
     * Sets the value of the availableTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableTimes }
     *     
     */
    public void setAvailableTimes(AvailableTimes value) {
        this.availableTimes = value;
    }

    /**
     * Gets the value of the geospatialCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link GeospatialCoverage }
     *     
     */
    public GeospatialCoverage getGeospatialCoverage() {
        return geospatialCoverage;
    }

    /**
     * Sets the value of the geospatialCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link GeospatialCoverage }
     *     
     */
    public void setGeospatialCoverage(GeospatialCoverage value) {
        this.geospatialCoverage = value;
    }

    /**
     * Gets the value of the variablesVocabulary property.
     * 
     * @return
     *     possible object is
     *     {@link VariablesVocabulary }
     *     
     */
    public VariablesVocabulary getVariablesVocabulary() {
        return variablesVocabulary;
    }

    /**
     * Sets the value of the variablesVocabulary property.
     * 
     * @param value
     *     allowed object is
     *     {@link VariablesVocabulary }
     *     
     */
    public void setVariablesVocabulary(VariablesVocabulary value) {
        this.variablesVocabulary = value;
    }

    /**
     * Gets the value of the variables property.
     * 
     * @return
     *     possible object is
     *     {@link Variables }
     *     
     */
    public Variables getVariables() {
        return variables;
    }

    /**
     * Sets the value of the variables property.
     * 
     * @param value
     *     allowed object is
     *     {@link Variables }
     *     
     */
    public void setVariables(Variables value) {
        this.variables = value;
    }

    /**
     * Gets the value of the properties property.
     * 
     * @return
     *     possible object is
     *     {@link Properties }
     *     
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     * Sets the value of the properties property.
     * 
     * @param value
     *     allowed object is
     *     {@link Properties }
     *     
     */
    public void setProperties(Properties value) {
        this.properties = value;
    }

    /**
     * Gets the value of the msg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsg() {
        return msg;
    }

    /**
     * Sets the value of the msg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsg(String value) {
        this.msg = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link ErrorType }
     *     
     */
    public ErrorType getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link ErrorType }
     *     
     */
    public void setCode(ErrorType value) {
        this.code = value;
    }

}
