package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para WeaponSize complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="WeaponSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="width" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="height" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="length" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="weight" use="required" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeaponSize")
public class WeaponSize {

    @XmlAttribute(name = "width", required = true)
    protected double width;
    @XmlAttribute(name = "height", required = true)
    protected double height;
    @XmlAttribute(name = "length", required = true)
    protected double length;
    @XmlAttribute(name = "weight", required = true)
    protected double weight;

    /**
     * Obtiene el valor de la propiedad width.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Define el valor de la propiedad width.
     */
    public void setWidth(double value) {
        this.width = value;
    }

    /**
     * Obtiene el valor de la propiedad height.
     */
    public double getHeight() {
        return height;
    }

    /**
     * Define el valor de la propiedad height.
     */
    public void setHeight(double value) {
        this.height = value;
    }

    /**
     * Obtiene el valor de la propiedad length.
     */
    public double getLength() {
        return length;
    }

    /**
     * Define el valor de la propiedad length.
     */
    public void setLength(double value) {
        this.length = value;
    }

    /**
     * Obtiene el valor de la propiedad weight.
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     */
    public void setWeight(double value) {
        this.weight = value;
    }

}
