package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Armor complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Armor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="front" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="side" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="rear" type="{http://www.w3.org/2001/XMLSchema}double" />
 *       &lt;attribute name="top" type="{http://www.w3.org/2001/XMLSchema}double" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armor")
public class Armor {

    @XmlAttribute(name = "front")
    protected Double front;
    @XmlAttribute(name = "side")
    protected Double side;
    @XmlAttribute(name = "rear")
    protected Double rear;
    @XmlAttribute(name = "top")
    protected Double top;

    /**
     * Gets the value of the front property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getFront() {
        return front;
    }

    /**
     * Sets the value of the front property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setFront(Double value) {
        this.front = value;
    }

    /**
     * Gets the value of the side property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getSide() {
        return side;
    }

    /**
     * Sets the value of the side property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setSide(Double value) {
        this.side = value;
    }

    /**
     * Gets the value of the rear property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getRear() {
        return rear;
    }

    /**
     * Sets the value of the rear property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setRear(Double value) {
        this.rear = value;
    }

    /**
     * Gets the value of the top property.
     *
     * @return possible object is
     * {@link Double }
     */
    public Double getTop() {
        return top;
    }

    /**
     * Sets the value of the top property.
     *
     * @param value allowed object is
     *              {@link Double }
     */
    public void setTop(Double value) {
        this.top = value;
    }

}
