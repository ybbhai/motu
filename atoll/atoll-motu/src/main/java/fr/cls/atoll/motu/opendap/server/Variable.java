//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.21 at 08:38:29 AM CET 
//

package fr.cls.atoll.motu.opendap.server;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for variable element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 *  &lt;element name=&quot;variable&quot;&gt;
 *    &lt;complexType&gt;
 *      &lt;complexContent&gt;
 *        &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *          &lt;attribute name=&quot;name&quot; use=&quot;required&quot; type=&quot;{http://www.w3.org/2001/XMLSchema}anySimpleType&quot; /&gt;
 *        &lt;/restriction&gt;
 *      &lt;/complexContent&gt;
 *    &lt;/complexType&gt;
 *  &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "variable")
public class Variable {

    @XmlAttribute(required = true)
    protected String name;

    /**
     * Gets the value of the name property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setName(String value) {
        this.name = value;
    }

}
