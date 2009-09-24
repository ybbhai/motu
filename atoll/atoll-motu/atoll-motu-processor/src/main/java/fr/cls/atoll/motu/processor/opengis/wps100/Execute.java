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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import fr.cls.atoll.motu.processor.opengis.ows110.CodeType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}RequestBaseType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.opengis.net/ows/1.1}Identifier"/>
 *         &lt;element name="DataInputs" type="{http://www.opengis.net/wps/1.0.0}DataInputsType" minOccurs="0"/>
 *         &lt;element name="ResponseForm" type="{http://www.opengis.net/wps/1.0.0}ResponseFormType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "identifier",
    "dataInputs",
    "responseForm"
})
@XmlRootElement(name = "Execute")
public class Execute
    extends RequestBaseType
{

    @XmlElement(name = "Identifier", namespace = "http://www.opengis.net/ows/1.1", required = true)
    protected CodeType identifier;
    @XmlElement(name = "DataInputs")
    protected DataInputsType dataInputs;
    @XmlElement(name = "ResponseForm")
    protected ResponseFormType responseForm;

    /**
     * Identifier of the Process to be executed. This Process identifier shall be as listed in the ProcessOfferings section of the WPS Capabilities document. 
     * 
     * @return
     *     possible object is
     *     {@link CodeType }
     *     
     */
    public CodeType getIdentifier() {
        return identifier;
    }

    /**
     * Sets the value of the identifier property.
     * 
     * @param value
     *     allowed object is
     *     {@link CodeType }
     *     
     */
    public void setIdentifier(CodeType value) {
        this.identifier = value;
    }

    /**
     * Gets the value of the dataInputs property.
     * 
     * @return
     *     possible object is
     *     {@link DataInputsType }
     *     
     */
    public DataInputsType getDataInputs() {
        return dataInputs;
    }

    /**
     * Sets the value of the dataInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataInputsType }
     *     
     */
    public void setDataInputs(DataInputsType value) {
        this.dataInputs = value;
    }

    /**
     * Gets the value of the responseForm property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseFormType }
     *     
     */
    public ResponseFormType getResponseForm() {
        return responseForm;
    }

    /**
     * Sets the value of the responseForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseFormType }
     *     
     */
    public void setResponseForm(ResponseFormType value) {
        this.responseForm = value;
    }

}
