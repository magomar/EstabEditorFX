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
 * <p>Clase Java para CombatClass.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="CombatClass">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="line"/>
 *     &lt;enumeration value="line-support"/>
 *     &lt;enumeration value="support"/>
 *     &lt;enumeration value="hq"/>
 *     &lt;enumeration value="base"/>
 *     &lt;enumeration value="static"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CombatClass")
@XmlEnum
public enum CombatClass {

    @XmlEnumValue("line")
    LINE("line"),
    @XmlEnumValue("line-support")
    LINE_SUPPORT("line-support"),
    @XmlEnumValue("support")
    SUPPORT("support"),
    @XmlEnumValue("hq")
    HQ("hq"),
    @XmlEnumValue("base")
    BASE("base"),
    @XmlEnumValue("static")
    STATIC("static");
    private final String value;

    CombatClass(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CombatClass fromValue(String v) {
        for (CombatClass c: CombatClass.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
