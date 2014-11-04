
package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para SymbolColor.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="SymbolColor">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="black"/>
 *     &lt;enumeration value="white"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "SymbolColor")
@XmlEnum
public enum SymbolColor {

    @XmlEnumValue("black")
    BLACK("black"),
    @XmlEnumValue("white")
    WHITE("white");
    private final String value;

    SymbolColor(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SymbolColor fromValue(String v) {
        for (SymbolColor c: SymbolColor.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
