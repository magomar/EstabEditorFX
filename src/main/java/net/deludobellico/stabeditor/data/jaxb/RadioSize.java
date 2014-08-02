
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RadioSize complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RadioSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="width" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="height" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="length" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="weight" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RadioSize")
public class RadioSize {

    @XmlAttribute(name = "width", required = true)
    protected float width;
    @XmlAttribute(name = "height", required = true)
    protected float height;
    @XmlAttribute(name = "length", required = true)
    protected float length;
    @XmlAttribute(name = "weight", required = true)
    protected float weight;

    /**
     * Obtiene el valor de la propiedad width.
     * 
     */
    public float getWidth() {
        return width;
    }

    /**
     * Define el valor de la propiedad width.
     * 
     */
    public void setWidth(float value) {
        this.width = value;
    }

    /**
     * Obtiene el valor de la propiedad height.
     * 
     */
    public float getHeight() {
        return height;
    }

    /**
     * Define el valor de la propiedad height.
     * 
     */
    public void setHeight(float value) {
        this.height = value;
    }

    /**
     * Obtiene el valor de la propiedad length.
     * 
     */
    public float getLength() {
        return length;
    }

    /**
     * Define el valor de la propiedad length.
     * 
     */
    public void setLength(float value) {
        this.length = value;
    }

    /**
     * Obtiene el valor de la propiedad weight.
     * 
     */
    public float getWeight() {
        return weight;
    }

    /**
     * Define el valor de la propiedad weight.
     * 
     */
    public void setWeight(float value) {
        this.weight = value;
    }

}
