//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WeaponType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
