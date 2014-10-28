//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.28 at 06:50:22 AM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.xml.bind.annotation.XmlAttribute;


/**
 * <p>Java class for RangeItem complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RangeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="range" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="accuracy" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="armour-penetration" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
public class RangeItem {

    protected int range;
    protected float accuracy;
    protected float armourPenetration;
    private final transient IntegerProperty rangeProxy = new SimpleIntegerProperty();
    private final transient FloatProperty accuracyProxy = new SimpleFloatProperty();
    private final transient FloatProperty armourPenetrationProxy = new SimpleFloatProperty();

    /**
     * Sets the value of the range property.
     */
    @XmlAttribute(required = true, name = "range")
    public void setRange(int value) {
        this.range = value;
        this.rangeProxy.set(value);
    }

    /**
     * Sets the value of the accuracy property.
     */
    @XmlAttribute(required = true, name = "accuracy")
    public void setAccuracy(float value) {
        this.accuracy = value;
        this.accuracyProxy.set(value);
    }

    /**
     * Sets the value of the armourPenetration property.
     */
    @XmlAttribute(required = true, name = "armour-penetration")
    public void setArmourPenetration(float value) {
        this.armourPenetration = value;
        this.armourPenetrationProxy.set(value);
    }

    /**
     * Gets the value of the range property.
     */
    public int getRange() {
        return this.rangeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public IntegerProperty rangeProperty() {
        return this.rangeProxy;
    }

    /**
     * Gets the value of the accuracy property.
     */
    public float getAccuracy() {
        return this.accuracyProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty accuracyProperty() {
        return this.accuracyProxy;
    }

    /**
     * Gets the value of the armourPenetration property.
     */
    public float getArmourPenetration() {
        return this.armourPenetrationProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty armourPenetrationProperty() {
        return this.armourPenetrationProxy;
    }

}
