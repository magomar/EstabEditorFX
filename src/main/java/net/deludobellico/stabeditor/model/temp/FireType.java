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
 * <p>Clase Java para FireType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="FireType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="aper"/>
 *     &lt;enumeration value="aarm"/>
 *     &lt;enumeration value="aair"/>
 *     &lt;enumeration value="bombard"/>
 *     &lt;enumeration value="smoke"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "FireType")
@XmlEnum
public enum FireType {

    @XmlEnumValue("aper")
    APER("aper"),
    @XmlEnumValue("aarm")
    AARM("aarm"),
    @XmlEnumValue("aair")
    AAIR("aair"),
    @XmlEnumValue("bombard")
    BOMBARD("bombard"),
    @XmlEnumValue("smoke")
    SMOKE("smoke");
    private final String value;

    FireType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static FireType fromValue(String v) {
        for (FireType c: FireType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
