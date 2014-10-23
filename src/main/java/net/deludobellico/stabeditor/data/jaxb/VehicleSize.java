//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.23 at 11:16:24 AM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VehicleSize")
public class VehicleSize {

    @XmlAttribute(name = "width")
    protected Float width;
    @XmlAttribute(name = "height")
    protected Float height;
    @XmlAttribute(name = "length")
    protected Float length;
    @XmlAttribute(name = "weight")
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
