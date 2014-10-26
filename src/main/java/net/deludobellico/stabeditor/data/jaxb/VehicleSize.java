//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 04:36:56 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;

import javax.xml.bind.annotation.XmlAttribute;


/**
 * <p>Java class for VehicleSize complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="VehicleSize">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="width" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="height" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="length" type="{http://www.w3.org/2001/XMLSchema}float" />
 *       &lt;attribute name="weight" type="{http://www.w3.org/2001/XMLSchema}float" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class VehicleSize {

    protected Float width;
    protected Float height;
    protected Float length;
    protected Float weight;
    private final transient FloatProperty widthProxy = new SimpleFloatProperty();
    private final transient FloatProperty heightProxy = new SimpleFloatProperty();
    private final transient FloatProperty lengthProxy = new SimpleFloatProperty();
    private final transient FloatProperty weightProxy = new SimpleFloatProperty();

    /**
     * Sets the value of the width property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @XmlAttribute(name = "width")
    public void setWidth(Float value) {
        this.width = value;
        this.widthProxy.set(value);
    }

    /**
     * Sets the value of the height property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @XmlAttribute(name = "height")
    public void setHeight(Float value) {
        this.height = value;
        this.heightProxy.set(value);
    }

    /**
     * Sets the value of the length property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @XmlAttribute(name = "length")
    public void setLength(Float value) {
        this.length = value;
        this.lengthProxy.set(value);
    }

    /**
     * Sets the value of the weight property.
     * 
     * @param value
     *     allowed object is
     *     {@link Float }
     *     
     */
    @XmlAttribute(name = "weight")
    public void setWeight(Float value) {
        this.weight = value;
        this.weightProxy.set(value);
    }

    /**
     * Gets the value of the width property.
     * 
     */
    public Float getWidth() {
        return this.widthProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty widthProperty() {
        return this.widthProxy;
    }

    /**
     * Gets the value of the height property.
     * 
     */
    public Float getHeight() {
        return this.heightProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty heightProperty() {
        return this.heightProxy;
    }

    /**
     * Gets the value of the length property.
     * 
     */
    public Float getLength() {
        return this.lengthProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty lengthProperty() {
        return this.lengthProxy;
    }

    /**
     * Gets the value of the weight property.
     * 
     */
    public Float getWeight() {
        return this.weightProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty weightProperty() {
        return this.weightProxy;
    }

}
