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
 * <p>Clase Java para MoveType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="MoveType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="foot"/>
 *     &lt;enumeration value="wheeled"/>
 *     &lt;enumeration value="tracked"/>
 *     &lt;enumeration value="half-track"/>
 *     &lt;enumeration value="horse"/>
 *     &lt;enumeration value="bicycle"/>
 *     &lt;enumeration value="air"/>
 *     &lt;enumeration value="sea"/>
 *     &lt;enumeration value="sub"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "MoveType")
@XmlEnum
public enum MoveType {

    @XmlEnumValue("foot")
    FOOT("foot"),
    @XmlEnumValue("wheeled")
    WHEELED("wheeled"),
    @XmlEnumValue("tracked")
    TRACKED("tracked"),
    @XmlEnumValue("half-track")
    HALF_TRACK("half-track"),
    @XmlEnumValue("horse")
    HORSE("horse"),
    @XmlEnumValue("bicycle")
    BICYCLE("bicycle"),
    @XmlEnumValue("air")
    AIR("air"),
    @XmlEnumValue("sea")
    SEA("sea"),
    @XmlEnumValue("sub")
    SUB("sub");
    private final String value;

    MoveType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MoveType fromValue(String v) {
        for (MoveType c: MoveType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
