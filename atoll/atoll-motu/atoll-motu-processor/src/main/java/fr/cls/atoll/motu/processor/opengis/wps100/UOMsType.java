//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.24 at 04:55:55 PM CEST 
//


package fr.cls.atoll.motu.processor.opengis.wps100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import fr.cls.atoll.motu.processor.opengis.ows110.DomainMetadataType;


/**
 * Identifies a UOM supported for this input or output.
 * 
 * <p>Java class for UOMsType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UOMsType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}UOM" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UOMsType", propOrder = {
    "uom"
})
public class UOMsType {

    @XmlElement(name = "UOM", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected List<DomainMetadataType> uom;

    /**
     * Reference to a UOM supported for this input or output. Gets the value of the uom property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uom property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUOM().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DomainMetadataType }
     * 
     * 
     */
    public List<DomainMetadataType> getUOM() {
        if (uom == null) {
            uom = new ArrayList<DomainMetadataType>();
        }
        return this.uom;
    }

}
