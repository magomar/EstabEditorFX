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
 * <p>Clase Java para ForceSize.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ForceSize">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="section"/>
 *     &lt;enumeration value="platoon"/>
 *     &lt;enumeration value="company"/>
 *     &lt;enumeration value="battalion"/>
 *     &lt;enumeration value="brigade"/>
 *     &lt;enumeration value="regiment"/>
 *     &lt;enumeration value="division"/>
 *     &lt;enumeration value="corps"/>
 *     &lt;enumeration value="army"/>
 *     &lt;enumeration value="army-group"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ForceSize")
@XmlEnum
public enum ForceSize {

    @XmlEnumValue("section")
    SECTION("section"),
    @XmlEnumValue("platoon")
    PLATOON("platoon"),
    @XmlEnumValue("company")
    COMPANY("company"),
    @XmlEnumValue("battalion")
    BATTALION("battalion"),
    @XmlEnumValue("brigade")
    BRIGADE("brigade"),
    @XmlEnumValue("regiment")
    REGIMENT("regiment"),
    @XmlEnumValue("division")
    DIVISION("division"),
    @XmlEnumValue("corps")
    CORPS("corps"),
    @XmlEnumValue("army")
    ARMY("army"),
    @XmlEnumValue("army-group")
    ARMY_GROUP("army-group");
    private final String value;

    ForceSize(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ForceSize fromValue(String v) {
        for (ForceSize c: ForceSize.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
