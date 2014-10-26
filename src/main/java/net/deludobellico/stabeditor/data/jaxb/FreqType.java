//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 04:36:56 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FreqType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="FreqType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hf"/>
 *     &lt;enumeration value="vhf"/>
 *     &lt;enumeration value="uhf"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FreqType")
@XmlEnum
public enum FreqType {

    @XmlEnumValue("hf")
    HF("hf"),
    @XmlEnumValue("vhf")
    VHF("vhf"),
    @XmlEnumValue("uhf")
    UHF("uhf");
    private final String value;

    FreqType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FreqType fromValue(String v) {
        for (FreqType c: FreqType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
