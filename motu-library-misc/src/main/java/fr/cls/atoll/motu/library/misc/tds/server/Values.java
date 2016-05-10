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
// Generated on: 2009.03.25 at 11:44:51 AM CET 
//

package fr.cls.atoll.motu.library.misc.tds.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

/**
 * <p>
 * Java class for values element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="values">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;attribute name="increment" type="{http://www.w3.org/2001/XMLSchema}float" />
 *         &lt;attribute name="npts" type="{http://www.w3.org/2001/XMLSchema}int" />
 *         &lt;attribute name="separator" type="{http://www.w3.org/2001/XMLSchema}string" />
 *         &lt;attribute name="start" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "content" })
@XmlRootElement(name = "values", namespace = "http://www.unidata.ucar.edu/namespaces/netcdf/ncml-2.2")
public class Values {

    @XmlValue
    protected String content;
    @XmlAttribute
    protected Float increment;
    @XmlAttribute
    protected Integer npts;
    @XmlAttribute
    protected String separator;
    @XmlAttribute
    protected Float start;

    /**
     * Gets the value of the content property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setContent(String value) {
        this.content = value;
    }

    /**
     * Gets the value of the increment property.
     * 
     * @return possible object is {@link Float }
     * 
     */
    public Float getIncrement() {
        return increment;
    }

    /**
     * Sets the value of the increment property.
     * 
     * @param value allowed object is {@link Float }
     * 
     */
    public void setIncrement(Float value) {
        this.increment = value;
    }

    /**
     * Gets the value of the npts property.
     * 
     * @return possible object is {@link Integer }
     * 
     */
    public Integer getNpts() {
        return npts;
    }

    /**
     * Sets the value of the npts property.
     * 
     * @param value allowed object is {@link Integer }
     * 
     */
    public void setNpts(Integer value) {
        this.npts = value;
    }

    /**
     * Gets the value of the separator property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getSeparator() {
        return separator;
    }

    /**
     * Sets the value of the separator property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setSeparator(String value) {
        this.separator = value;
    }

    /**
     * Gets the value of the start property.
     * 
     * @return possible object is {@link Float }
     * 
     */
    public Float getStart() {
        return start;
    }

    /**
     * Sets the value of the start property.
     * 
     * @param value allowed object is {@link Float }
     * 
     */
    public void setStart(Float value) {
        this.start = value;
    }

}
