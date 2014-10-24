//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 04:24:04 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TargetPercentages complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
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
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TargetPercentages", propOrder = {
        "front",
        "left",
        "right",
        "rear"
})
public class TargetPercentages {

    private final transient FloatProperty frontProxy = new SimpleFloatProperty();
    private final transient FloatProperty leftProxy = new SimpleFloatProperty();
    private final transient FloatProperty rightProxy = new SimpleFloatProperty();
    private final transient FloatProperty rearProxy = new SimpleFloatProperty();
    protected float front;
    protected float left;
    protected float right;
    protected float rear;

    /**
     * Gets the value of the front property.
     */
    public float getFront() {
        if (this.frontProxy.get() == 0) {
            this.frontProxy.set(front);
        }
        return this.frontProxy.get();
    }

    /**
     * Sets the value of the front property.
     */
    public void setFront(float value) {
        this.front = value;
        this.frontProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty frontProperty() {
        return this.frontProxy;
    }

    /**
     * Gets the value of the left property.
     */
    public float getLeft() {
        if (this.leftProxy.get() == 0) {
            this.leftProxy.set(left);
        }
        return this.leftProxy.get();
    }

    /**
     * Sets the value of the left property.
     */
    public void setLeft(float value) {
        this.left = value;
        this.leftProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty leftProperty() {
        return this.leftProxy;
    }

    /**
     * Gets the value of the right property.
     */
    public float getRight() {
        if (this.rightProxy.get() == 0) {
            this.rightProxy.set(right);
        }
        return this.rightProxy.get();
    }

    /**
     * Sets the value of the right property.
     */
    public void setRight(float value) {
        this.right = value;
        this.rightProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty rightProperty() {
        return this.rightProxy;
    }

    /**
     * Gets the value of the rear property.
     */
    public float getRear() {
        if (this.rearProxy.get() == 0) {
            this.rearProxy.set(rear);
        }
        return this.rearProxy.get();
    }

    /**
     * Sets the value of the rear property.
     */
    public void setRear(float value) {
        this.rear = value;
        this.rearProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty rearProperty() {
        return this.rearProxy;
    }

}
