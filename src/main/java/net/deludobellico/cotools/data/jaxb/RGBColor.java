
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RGBColor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
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
     * Gets the value of the red property.
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
     * Sets the value of the red property.
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
     * Gets the value of the green property.
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
     * Sets the value of the green property.
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
     * Gets the value of the blue property.
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
     * Sets the value of the blue property.
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
