
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetPercentages complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TargetPercentages">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="front" type="{}Proportion"/>
 *         &lt;element name="left" type="{}Proportion"/>
 *         &lt;element name="right" type="{}Proportion"/>
 *         &lt;element name="rear" type="{}Proportion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetPercentages", propOrder = {
    "front",
    "left",
    "right",
    "rear"
})
public class TargetPercentages {

    protected float front;
    protected float left;
    protected float right;
    protected float rear;

    /**
     * Gets the value of the front property.
     * 
     */
    public float getFront() {
        return front;
    }

    /**
     * Sets the value of the front property.
     * 
     */
    public void setFront(float value) {
        this.front = value;
    }

    /**
     * Gets the value of the left property.
     * 
     */
    public float getLeft() {
        return left;
    }

    /**
     * Sets the value of the left property.
     * 
     */
    public void setLeft(float value) {
        this.left = value;
    }

    /**
     * Gets the value of the right property.
     * 
     */
    public float getRight() {
        return right;
    }

    /**
     * Sets the value of the right property.
     * 
     */
    public void setRight(float value) {
        this.right = value;
    }

    /**
     * Gets the value of the rear property.
     * 
     */
    public float getRear() {
        return rear;
    }

    /**
     * Sets the value of the rear property.
     * 
     */
    public void setRear(float value) {
        this.rear = value;
    }

}
