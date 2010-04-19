//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.01 at 05:10:30 PM CET 
//


package fr.cls.atoll.motu.library.misc.inventory;

import java.net.URI;
import javax.measure.DecimalMeasure;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import fr.cls.atoll.motu.library.converter.jaxb.DecimalMeasureAdapter;
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
 *       &lt;attribute name="west" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="eastResolution" type="{http://purl.org/cls/atoll}resolutiontype" />
 *       &lt;attribute name="units" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="south" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="east" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *       &lt;attribute name="northResolution" type="{http://purl.org/cls/atoll}resolutiontype" />
 *       &lt;attribute name="north" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "geospatialCoverage")
public class GeospatialCoverage {

    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(DecimalMeasureAdapter.class)
    @XmlSchemaType(name = "decimal")
    protected DecimalMeasure west;
    @XmlAttribute
    protected String eastResolution;
    @XmlAttribute(required = true)
    protected String units;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(UriAdapter.class)
    @XmlSchemaType(name = "anyURI")
    protected URI type;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(DecimalMeasureAdapter.class)
    @XmlSchemaType(name = "decimal")
    protected DecimalMeasure south;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(DecimalMeasureAdapter.class)
    @XmlSchemaType(name = "decimal")
    protected DecimalMeasure east;
    @XmlAttribute
    protected String northResolution;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(DecimalMeasureAdapter.class)
    @XmlSchemaType(name = "decimal")
    protected DecimalMeasure north;

    /**
     * Gets the value of the west property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DecimalMeasure getWest() {
        return west;
    }

    /**
     * Sets the value of the west property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWest(DecimalMeasure value) {
        this.west = value;
    }

    /**
     * Gets the value of the eastResolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEastResolution() {
        return eastResolution;
    }

    /**
     * Sets the value of the eastResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEastResolution(String value) {
        this.eastResolution = value;
    }

    /**
     * Gets the value of the units property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnits() {
        return units;
    }

    /**
     * Sets the value of the units property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnits(String value) {
        this.units = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public URI getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(URI value) {
        this.type = value;
    }

    /**
     * Gets the value of the south property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DecimalMeasure getSouth() {
        return south;
    }

    /**
     * Sets the value of the south property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSouth(DecimalMeasure value) {
        this.south = value;
    }

    /**
     * Gets the value of the east property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DecimalMeasure getEast() {
        return east;
    }

    /**
     * Sets the value of the east property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEast(DecimalMeasure value) {
        this.east = value;
    }

    /**
     * Gets the value of the northResolution property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNorthResolution() {
        return northResolution;
    }

    /**
     * Sets the value of the northResolution property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNorthResolution(String value) {
        this.northResolution = value;
    }

    /**
     * Gets the value of the north property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public DecimalMeasure getNorth() {
        return north;
    }

    /**
     * Sets the value of the north property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNorth(DecimalMeasure value) {
        this.north = value;
    }

}
