//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-3268 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2008.04.02 at 10:55:41 AM CEST 
//


package fr.cls.atoll.motu.msg.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;


/**
 * <p>Java class for errorType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="errorType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}unsignedShort">
 *     &lt;enumeration value="0"/>
 *     &lt;enumeration value="1"/>
 *     &lt;enumeration value="2"/>
 *     &lt;enumeration value="3"/>
 *     &lt;enumeration value="4"/>
 *     &lt;enumeration value="5"/>
 *     &lt;enumeration value="6"/>
 *     &lt;enumeration value="7"/>
 *     &lt;enumeration value="8"/>
 *     &lt;enumeration value="9"/>
 *     &lt;enumeration value="10"/>
 *     &lt;enumeration value="11"/>
 *     &lt;enumeration value="12"/>
 *     &lt;enumeration value="13"/>
 *     &lt;enumeration value="14"/>
 *     &lt;enumeration value="15"/>
 *     &lt;enumeration value="16"/>
 *     &lt;enumeration value="17"/>
 *     &lt;enumeration value="18"/>
 *     &lt;enumeration value="19"/>
 *     &lt;enumeration value="20"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlEnum(Integer.class)
public enum ErrorType {

    @XmlEnumValue("7")
    EXCEEDING_CAPACITY(7),
    @XmlEnumValue("15")
    EXCEEDING_QUEUE_CAPACITY(15),
    @XmlEnumValue("20")
    EXCEEDING_QUEUE_DATA_CAPACITY(20),
    @XmlEnumValue("16")
    EXCEEDING_USER_CAPACITY(16),
    @XmlEnumValue("2")
    INCONSISTENCY(2),
    @XmlEnumValue("3")
    INVALID_DATE(3),
    @XmlEnumValue("6")
    INVALID_DATE_RANGE(6),
    @XmlEnumValue("17")
    INVALID_DEPTH(17),
    @XmlEnumValue("9")
    INVALID_DEPTH_RANGE(9),
    @XmlEnumValue("4")
    INVALID_LATITUDE(4),
    @XmlEnumValue("8")
    INVALID_LAT_LON_RANGE(8),
    @XmlEnumValue("5")
    INVALID_LONGITUDE(5),
    @XmlEnumValue("18")
    INVALID_QUEUE_PRIORITY(18),
    @XmlEnumValue("14")
    NETCDF_ATTRIBUTE(14),
    @XmlEnumValue("11")
    NETCDF_VARIABLE(11),
    @XmlEnumValue("13")
    NETCDF_VARIABLE_NOT_FOUND(13),
    @XmlEnumValue("10")
    NOT_IMPLEMENTED(10),
    @XmlEnumValue("12")
    NO_VARIABLE(12),
    @XmlEnumValue("0")
    OK(0),
    @XmlEnumValue("1")
    SYSTEM(1),
    @XmlEnumValue("19")
    UNKNOWN_REQUEST_ID(19);
    private final int value;

    ErrorType(int v) {
        value = v;
    }

    public int value() {
        return value;
    }

    public static ErrorType fromValue(int v) {
        for (ErrorType c: ErrorType.values()) {
            if (c.value == v) {
                return c;
            }
        }
        throw new IllegalArgumentException(String.valueOf(v));
    }

}