package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RGBColor complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="RGBColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="red" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="green" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="blue" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RGBColor")
public class RGBColor {

    @XmlAttribute(name = "red", required = true)
    protected int red;
    @XmlAttribute(name = "green", required = true)
    protected int green;
    @XmlAttribute(name = "blue", required = true)
    protected int blue;

    /**
     * Obtiene el valor de la propiedad red.
     */
    public int getRed() {
        return red;
    }

    /**
     * Define el valor de la propiedad red.
     */
    public void setRed(int value) {
        this.red = value;
    }

    /**
     * Obtiene el valor de la propiedad green.
     */
    public int getGreen() {
        return green;
    }

    /**
     * Define el valor de la propiedad green.
     */
    public void setGreen(int value) {
        this.green = value;
    }

    /**
     * Obtiene el valor de la propiedad blue.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Define el valor de la propiedad blue.
     */
    public void setBlue(int value) {
        this.blue = value;
    }

}
