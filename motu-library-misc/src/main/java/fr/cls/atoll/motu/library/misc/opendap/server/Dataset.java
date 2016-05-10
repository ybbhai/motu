/* 
 * Motu, a high efficient, robust and Standard compliant Web Server for Geographic
 * Data Dissemination.
 *
 * http://cls-motu.sourceforge.net/
 *
 * (C) Copyright 2009-2010, by CLS (Collecte Localisation Satellites) - 
 * http://www.cls.fr - and  Contributors
 *
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this library; if not, write to the Free Software Foundation,
 * Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307, USA.
 */
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.03.25 at 11:43:43 AM CET 
//


package fr.cls.atoll.motu.library.misc.opendap.server;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for dataset element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="dataset">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;choice maxOccurs="unbounded" minOccurs="0">
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}service"/>
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}documentation"/>
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}metadata"/>
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}property"/>
 *           &lt;/choice>
 *           &lt;element ref="{http://www.unidata.ucar.edu/thredds}access" maxOccurs="unbounded" minOccurs="0"/>
 *           &lt;choice maxOccurs="unbounded" minOccurs="0">
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}dataset"/>
 *             &lt;element ref="{http://www.unidata.ucar.edu/thredds}catalogRef"/>
 *           &lt;/choice>
 *         &lt;/sequence>
 *         &lt;attribute name="ID" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *         &lt;attribute name="alias" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *         &lt;attribute name="authority" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *         &lt;attribute name="dataType" type="{http://www.unidata.ucar.edu/thredds}DataType" />
 *         &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *         &lt;attribute name="serviceName" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *         &lt;attribute name="urlPath" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "serviceOrDocumentationOrMetadata",
    "access",
    "datasetOrCatalogRef"
})
@XmlRootElement(name = "dataset")
public class Dataset {

    @XmlElements({
        @XmlElement(name = "service", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = Service.class),
        @XmlElement(name = "property", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = Property.class),
        @XmlElement(name = "metadata", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = Metadata.class),
        @XmlElement(name = "documentation", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = Documentation.class)
    })
    protected List<Object> serviceOrDocumentationOrMetadata;
    @XmlElement(namespace = "http://www.unidata.ucar.edu/thredds", required = true)
    protected List<Access> access;
    @XmlElements({
        @XmlElement(name = "dataset", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = Dataset.class),
        @XmlElement(name = "catalogRef", namespace = "http://www.unidata.ucar.edu/thredds", required = true, type = CatalogRef.class)
    })
    protected List<Object> datasetOrCatalogRef;
    @XmlAttribute(name = "ID")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlAttribute
    @XmlIDREF
    protected Object alias;
    @XmlAttribute
    protected String authority;
    @XmlAttribute
    protected DataType dataType;
    @XmlAttribute(required = true)
    protected String name;
    @XmlAttribute
    protected String serviceName;
    @XmlAttribute
    protected String urlPath;

    /**
     * Gets the value of the serviceOrDocumentationOrMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the serviceOrDocumentationOrMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getServiceOrDocumentationOrMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Service }
     * {@link Property }
     * {@link Metadata }
     * {@link Documentation }
     * 
     * 
     */
    public List<Object> getServiceOrDocumentationOrMetadata() {
        if (serviceOrDocumentationOrMetadata == null) {
            serviceOrDocumentationOrMetadata = new ArrayList<Object>();
        }
        return this.serviceOrDocumentationOrMetadata;
    }

    /**
     * Gets the value of the access property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the access property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccess().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Access }
     * 
     * 
     */
    public List<Access> getAccess() {
        if (access == null) {
            access = new ArrayList<Access>();
        }
        return this.access;
    }

    /**
     * Gets the value of the datasetOrCatalogRef property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the datasetOrCatalogRef property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDatasetOrCatalogRef().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dataset }
     * {@link CatalogRef }
     * 
     * 
     */
    public List<Object> getDatasetOrCatalogRef() {
        if (datasetOrCatalogRef == null) {
            datasetOrCatalogRef = new ArrayList<Object>();
        }
        return this.datasetOrCatalogRef;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
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
    public void setID(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the alias property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getAlias() {
        return alias;
    }

    /**
     * Sets the value of the alias property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setAlias(Object value) {
        this.alias = value;
    }

    /**
     * Gets the value of the authority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the value of the authority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthority(String value) {
        this.authority = value;
    }

    /**
     * Gets the value of the dataType property.
     * 
     * @return
     *     possible object is
     *     {@link DataType }
     *     
     */
    public DataType getDataType() {
        return dataType;
    }

    /**
     * Sets the value of the dataType property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataType }
     *     
     */
    public void setDataType(DataType value) {
        this.dataType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the serviceName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * Sets the value of the serviceName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceName(String value) {
        this.serviceName = value;
    }

    /**
     * Gets the value of the urlPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlPath() {
        return urlPath;
    }

    /**
     * Sets the value of the urlPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlPath(String value) {
        this.urlPath = value;
    }

}
