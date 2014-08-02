
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para RGBColor complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="RGBColor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="red" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="green" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="blue" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RGBColor")
public class RGBColor {

    @XmlAttribute(name = "red")
    protected Short red;
    @XmlAttribute(name = "green")
    protected Short green;
    @XmlAttribute(name = "blue")
    protected Short blue;

    /**
     * Obtiene el valor de la propiedad red.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getRed() {
        return red;
    }

    /**
     * Define el valor de la propiedad red.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setRed(Short value) {
        this.red = value;
    }

    /**
     * Obtiene el valor de la propiedad green.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getGreen() {
        return green;
    }

    /**
     * Define el valor de la propiedad green.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setGreen(Short value) {
        this.green = value;
    }

    /**
     * Obtiene el valor de la propiedad blue.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getBlue() {
        return blue;
    }

    /**
     * Define el valor de la propiedad blue.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setBlue(Short value) {
        this.blue = value;
    }

}
