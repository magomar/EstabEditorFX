//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 04:24:04 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RangeItem complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="RangeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="range" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="accuracy" use="required" type="{}Proportion" />
 *       &lt;attribute name="armour-penetration" use="required" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RangeItem")
public class RangeItem {

    private final transient ObjectProperty<Short> rangeProxy = new SimpleObjectProperty<Short>();
    private final transient FloatProperty accuracyProxy = new SimpleFloatProperty();
    private final transient FloatProperty armourPenetrationProxy = new SimpleFloatProperty();
    @XmlAttribute(name = "range", required = true)
    protected short range;
    @XmlAttribute(name = "accuracy", required = true)
    protected float accuracy;
    @XmlAttribute(name = "armour-penetration", required = true)
    protected float armourPenetration;

    /**
     * Gets the value of the range property.
     */
    public short getRange() {
        if (this.rangeProxy.get() == null) {
            this.rangeProxy.set(range);
        }
        return this.rangeProxy.get();
    }

    /**
     * Sets the value of the range property.
     */
    public void setRange(short value) {
        this.range = value;
        this.rangeProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Short> rangeProperty() {
        return this.rangeProxy;
    }

    /**
     * Gets the value of the accuracy property.
     */
    public float getAccuracy() {
        if (this.accuracyProxy.get() == 0) {
            this.accuracyProxy.set(accuracy);
        }
        return this.accuracyProxy.get();
    }

    /**
     * Sets the value of the accuracy property.
     */
    public void setAccuracy(float value) {
        this.accuracy = value;
        this.accuracyProxy.set(value);
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
        if (this.armourPenetrationProxy.get() == 0) {
            this.armourPenetrationProxy.set(armourPenetration);
        }
        return this.armourPenetrationProxy.get();
    }

    /**
     * Sets the value of the armourPenetration property.
     */
    public void setArmourPenetration(float value) {
        this.armourPenetration = value;
        this.armourPenetrationProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty armourPenetrationProperty() {
        return this.armourPenetrationProxy;
    }

}
