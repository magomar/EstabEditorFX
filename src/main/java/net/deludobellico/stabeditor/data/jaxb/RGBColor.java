
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
 *       &lt;attribute name="red" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="green" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="blue" type="{http://www.w3.org/2001/XMLSchema}int" />
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
    protected Integer red;
    @XmlAttribute(name = "green")
    protected Integer green;
    @XmlAttribute(name = "blue")
    protected Integer blue;

    /**
     * Obtiene el valor de la propiedad red.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRed() {
        return red;
    }

    /**
     * Define el valor de la propiedad red.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRed(Integer value) {
        this.red = value;
    }

    /**
     * Obtiene el valor de la propiedad green.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getGreen() {
        return green;
    }

    /**
     * Define el valor de la propiedad green.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setGreen(Integer value) {
        this.green = value;
    }

    /**
     * Obtiene el valor de la propiedad blue.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBlue() {
        return blue;
    }

    /**
     * Define el valor de la propiedad blue.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBlue(Integer value) {
        this.blue = value;
    }

}
