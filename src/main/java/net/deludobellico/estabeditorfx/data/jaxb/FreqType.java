
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para FreqType.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
