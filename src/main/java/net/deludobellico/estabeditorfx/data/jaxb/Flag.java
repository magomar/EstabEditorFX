
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Flag.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="Flag">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="new"/>
 *     &lt;enumeration value="copy"/>
 *     &lt;enumeration value="remove"/>
 *     &lt;enumeration value="user"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "Flag")
@XmlEnum
public enum Flag {

    @XmlEnumValue("new")
    NEW("new"),
    @XmlEnumValue("copy")
    COPY("copy"),
    @XmlEnumValue("remove")
    REMOVE("remove"),
    @XmlEnumValue("user")
    USER("user");
    private final String value;

    Flag(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Flag fromValue(String v) {
        for (Flag c: Flag.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
