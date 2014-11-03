package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for VehicleSize complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="VehicleSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="weight" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleSize")
public class VehicleSize {

    @XmlAttribute(name = "width")
    protected Double width;
    @XmlAttribute(name = "height")
    protected Double height;
    @XmlAttribute(name = "length")
    protected Double length;
    @XmlAttribute(name = "weight")
    protected Double weight;

    /**
     * Gets the value of the width property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getWidth() {
        return width;
    }

    /**
     * Sets the value of the width property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setWidth(Double value) {
        this.width = value;
    }

    /**
     * Gets the value of the height property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getHeight() {
        return height;
    }

    /**
     * Sets the value of the height property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setHeight(Double value) {
        this.height = value;
    }

    /**
     * Gets the value of the length property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getLength() {
        return length;
    }

    /**
     * Sets the value of the length property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setLength(Double value) {
        this.length = value;
    }

    /**
     * Gets the value of the weight property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * Sets the value of the weight property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setWeight(Double value) {
        this.weight = value;
    }

}
