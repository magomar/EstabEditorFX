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
 * <p>Clase Java para PrimaryRole.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="PrimaryRole">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="anti-personnel"/>
 *     &lt;enumeration value="anti-armor"/>
 *     &lt;enumeration value="anti-air"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PrimaryRole")
@XmlEnum
public enum PrimaryRole {

    @XmlEnumValue("anti-personnel")
    ANTI_PERSONNEL("anti-personnel"),
    @XmlEnumValue("anti-armor")
    ANTI_ARMOR("anti-armor"),
    @XmlEnumValue("anti-air")
    ANTI_AIR("anti-air");
    private final String value;

    PrimaryRole(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PrimaryRole fromValue(String v) {
        for (PrimaryRole c: PrimaryRole.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
