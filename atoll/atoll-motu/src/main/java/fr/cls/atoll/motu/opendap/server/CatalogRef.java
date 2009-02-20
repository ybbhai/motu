//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2007.12.21 at 08:38:29 AM CET 
//

package fr.cls.atoll.motu.opendap.server;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>
 * Java class for catalogRef element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 *  &lt;element name=&quot;catalogRef&quot;&gt;
 *    &lt;complexType&gt;
 *      &lt;complexContent&gt;
 *        &lt;restriction base=&quot;{http://www.w3.org/2001/XMLSchema}anyType&quot;&gt;
 *          &lt;sequence&gt;
 *            &lt;element ref=&quot;{http://www.unidata.ucar.edu/thredds}documentation&quot; maxOccurs=&quot;unbounded&quot; minOccurs=&quot;0&quot;/&gt;
 *          &lt;/sequence&gt;
 *          &lt;attribute ref=&quot;{http://www.w3.org/1999/xlink}href use=&quot;required&quot;&quot;/&gt;
 *          &lt;attribute ref=&quot;{http://www.w3.org/1999/xlink}title use=&quot;required&quot;&quot;/&gt;
 *          &lt;attribute ref=&quot;{http://www.w3.org/1999/xlink}type default=&quot;simple&quot;&quot;/&gt;
 *        &lt;/restriction&gt;
 *      &lt;/complexContent&gt;
 *    &lt;/complexType&gt;
 *  &lt;/element&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "documentation" })
@XmlRootElement(name = "catalogRef")
public class CatalogRef {

    @XmlElement(namespace = "http://www.unidata.ucar.edu/thredds", required = true)
    protected List<Documentation> documentation;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String href;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink", required = true)
    protected String title;
    @XmlAttribute(namespace = "http://www.w3.org/1999/xlink")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String type;

    /**
     * Gets the value of the documentation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list, not a snapshot. Therefore any modification
     * you make to the returned list will be present inside the JAXB object. This is why there is not a <CODE>set</CODE>
     * method for the documentation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * 
     * <pre>
     * getDocumentation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list {@link Documentation }
     * 
     * 
     */
    public List<Documentation> getDocumentation() {
        if (documentation == null) {
            documentation = new ArrayList<Documentation>();
        }
        return this.documentation;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setHref(String value) {
        this.href = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return possible object is {@link String }
     * 
     */
    public String getType() {
        if (type == null) {
            return "simple";
        } else {
            return type;
        }
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value allowed object is {@link String }
     * 
     */
    public void setType(String value) {
        this.type = value;
    }

}
