//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-792 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.08.06 at 12:27:04 PM CEST 
//


package fr.cls.atoll.motu.processor.opengis.wps100;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Full description of a process. 
 * 
 * <p>Java class for ProcessDescriptionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ProcessDescriptionType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://www.opengis.net/wps/1.0.0}ProcessBriefType">
 *       &lt;sequence>
 *         &lt;element name="DataInputs" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Input" type="{http://www.opengis.net/wps/1.0.0}InputDescriptionType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProcessOutputs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDescriptionType" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="storeSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *       &lt;attribute name="statusSupported" type="{http://www.w3.org/2001/XMLSchema}boolean" default="false" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ProcessDescriptionType", propOrder = {
    "dataInputs",
    "processOutputs"
})
public class ProcessDescriptionType
    extends ProcessBriefType
{

    @XmlElement(name = "DataInputs", namespace = "")
    protected ProcessDescriptionType.DataInputs dataInputs;
    @XmlElement(name = "ProcessOutputs", namespace = "", required = true)
    protected ProcessDescriptionType.ProcessOutputs processOutputs;
    @XmlAttribute
    protected Boolean storeSupported;
    @XmlAttribute
    protected Boolean statusSupported;

    /**
     * Gets the value of the dataInputs property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessDescriptionType.DataInputs }
     *     
     */
    public ProcessDescriptionType.DataInputs getDataInputs() {
        return dataInputs;
    }

    /**
     * Sets the value of the dataInputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessDescriptionType.DataInputs }
     *     
     */
    public void setDataInputs(ProcessDescriptionType.DataInputs value) {
        this.dataInputs = value;
    }

    /**
     * Gets the value of the processOutputs property.
     * 
     * @return
     *     possible object is
     *     {@link ProcessDescriptionType.ProcessOutputs }
     *     
     */
    public ProcessDescriptionType.ProcessOutputs getProcessOutputs() {
        return processOutputs;
    }

    /**
     * Sets the value of the processOutputs property.
     * 
     * @param value
     *     allowed object is
     *     {@link ProcessDescriptionType.ProcessOutputs }
     *     
     */
    public void setProcessOutputs(ProcessDescriptionType.ProcessOutputs value) {
        this.processOutputs = value;
    }

    /**
     * Gets the value of the storeSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStoreSupported() {
        if (storeSupported == null) {
            return false;
        } else {
            return storeSupported;
        }
    }

    /**
     * Sets the value of the storeSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStoreSupported(Boolean value) {
        this.storeSupported = value;
    }

    /**
     * Gets the value of the statusSupported property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public boolean isStatusSupported() {
        if (statusSupported == null) {
            return false;
        } else {
            return statusSupported;
        }
    }

    /**
     * Sets the value of the statusSupported property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStatusSupported(Boolean value) {
        this.statusSupported = value;
    }


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
     *         &lt;element name="Input" type="{http://www.opengis.net/wps/1.0.0}InputDescriptionType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "input"
    })
    public static class DataInputs {

        @XmlElement(name = "Input", namespace = "", required = true)
        protected List<InputDescriptionType> input;

        /**
         * Gets the value of the input property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the input property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link InputDescriptionType }
         * 
         * 
         */
        public List<InputDescriptionType> getInput() {
            if (input == null) {
                input = new ArrayList<InputDescriptionType>();
            }
            return this.input;
        }

    }


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
     *         &lt;element name="Output" type="{http://www.opengis.net/wps/1.0.0}OutputDescriptionType" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "output"
    })
    public static class ProcessOutputs {

        @XmlElement(name = "Output", namespace = "", required = true)
        protected List<OutputDescriptionType> output;

        /**
         * Gets the value of the output property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the output property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getOutput().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link OutputDescriptionType }
         * 
         * 
         */
        public List<OutputDescriptionType> getOutput() {
            if (output == null) {
                output = new ArrayList<OutputDescriptionType>();
            }
            return this.output;
        }

    }

}
