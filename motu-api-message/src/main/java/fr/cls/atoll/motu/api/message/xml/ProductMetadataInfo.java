//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.07.13 at 08:52:53 AM CEST 
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
 *         &lt;element ref="{}availableDepths" minOccurs="0"/>
 *         &lt;element ref="{}geospatialCoverage" minOccurs="0"/>
 *         &lt;element ref="{}variablesVocabulary" minOccurs="0"/>
 *         &lt;element ref="{}variables" minOccurs="0"/>
 *         &lt;element ref="{}properties" minOccurs="0"/>
 *         &lt;element ref="{}dataGeospatialCoverage" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{}codeMsg"/>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="title" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="lastUpdate" type="{http://www.w3.org/2001/XMLSchema}string" />
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
    "availableDepths",
    "geospatialCoverage",
    "variablesVocabulary",
    "variables",
    "properties",
    "dataGeospatialCoverage"
})
@XmlRootElement(name = "productMetadataInfo")
public class ProductMetadataInfo {

    protected TimeCoverage timeCoverage;
    protected AvailableTimes availableTimes;
    protected AvailableDepths availableDepths;
    protected GeospatialCoverage geospatialCoverage;
    protected VariablesVocabulary variablesVocabulary;
    protected Variables variables;
    protected Properties properties;
    protected DataGeospatialCoverage dataGeospatialCoverage;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "title")
    protected String title;
    @XmlAttribute(name = "url")
    protected String url;
    @XmlAttribute(name = "lastUpdate")
    protected String lastUpdate;
    @XmlAttribute(name = "msg")
    protected String msg;
    @XmlAttribute(name = "code")
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
     * Gets the value of the availableDepths property.
     * 
     * @return
     *     possible object is
     *     {@link AvailableDepths }
     *     
     */
    public AvailableDepths getAvailableDepths() {
        return availableDepths;
    }

    /**
     * Sets the value of the availableDepths property.
     * 
     * @param value
     *     allowed object is
     *     {@link AvailableDepths }
     *     
     */
    public void setAvailableDepths(AvailableDepths value) {
        this.availableDepths = value;
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
     * Gets the value of the dataGeospatialCoverage property.
     * 
     * @return
     *     possible object is
     *     {@link DataGeospatialCoverage }
     *     
     */
    public DataGeospatialCoverage getDataGeospatialCoverage() {
        return dataGeospatialCoverage;
    }

    /**
     * Sets the value of the dataGeospatialCoverage property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataGeospatialCoverage }
     *     
     */
    public void setDataGeospatialCoverage(DataGeospatialCoverage value) {
        this.dataGeospatialCoverage = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the lastUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastUpdate() {
        return lastUpdate;
    }

    /**
     * Sets the value of the lastUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastUpdate(String value) {
        this.lastUpdate = value;
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
