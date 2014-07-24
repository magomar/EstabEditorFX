
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Armor complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Armor">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="front" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="side" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="rear" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="top" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armor")
public class Armor {

    @XmlAttribute(name = "front")
    protected Float front;
    @XmlAttribute(name = "side")
    protected Float side;
    @XmlAttribute(name = "rear")
    protected Float rear;
    @XmlAttribute(name = "top")
    protected Float top;

    /**
     * Gets the value of the front property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getFront() {
        return front;
    }

    /**
     * Sets the value of the front property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setFront(Float value) {
        this.front = value;
    }

    /**
     * Gets the value of the side property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getSide() {
        return side;
    }

    /**
     * Sets the value of the side property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setSide(Float value) {
        this.side = value;
    }

    /**
     * Gets the value of the rear property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getRear() {
        return rear;
    }

    /**
     * Sets the value of the rear property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setRear(Float value) {
        this.rear = value;
    }

    /**
     * Gets the value of the top property.
     * 
     * @return
     *     possible object is
     *     {@link Float }
     *     
     */
    public Float getTop() {
        return top;
    }

    /**
     * Sets the value of the top property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    public void setTop(Float value) {
        this.top = value;
    }

}
