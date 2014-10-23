//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.23 at 11:16:24 AM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeaponType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="WeaponType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="small-arm"/>
 *     &lt;enumeration value="rpg"/>
 *     &lt;enumeration value="mortar"/>
 *     &lt;enumeration value="gun"/>
 *     &lt;enumeration value="rocket-launcher"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "WeaponType")
@XmlEnum
public enum WeaponType {

    @XmlEnumValue("small-arm")
    SMALL_ARM("small-arm"),
    @XmlEnumValue("rpg")
    RPG("rpg"),
    @XmlEnumValue("mortar")
    MORTAR("mortar"),
    @XmlEnumValue("gun")
    GUN("gun"),
    @XmlEnumValue("rocket-launcher")
    ROCKET_LAUNCHER("rocket-launcher"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    WeaponType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static WeaponType fromValue(String v) {
        for (WeaponType c: WeaponType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
