package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RGBColor complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
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
     * Gets the value of the red property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getRed() {
        return red;
    }

    /**
     * Sets the value of the red property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setRed(Integer value) {
        this.red = value;
    }

    /**
     * Gets the value of the green property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getGreen() {
        return green;
    }

    /**
     * Sets the value of the green property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setGreen(Integer value) {
        this.green = value;
    }

    /**
     * Gets the value of the blue property.
     *
     * @return possible object is
     * {@link Integer }
     */
    public Integer getBlue() {
        return blue;
    }

    /**
     * Sets the value of the blue property.
     *
     * @param value allowed object is
     *              {@link Integer }
     */
    public void setBlue(Integer value) {
        this.blue = value;
    }

}
