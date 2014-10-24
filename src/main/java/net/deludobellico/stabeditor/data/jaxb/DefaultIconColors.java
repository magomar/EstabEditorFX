//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 04:24:04 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DefaultIconColors complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="DefaultIconColors">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="background-color" type="{}RGBColor"/>
 *         &lt;element name="background-dark-color" type="{}RGBColor"/>
 *         &lt;element name="background-light-color" type="{}RGBColor"/>
 *         &lt;element name="designation-color" type="{}RGBColor"/>
 *         &lt;element name="symbol-color" type="{}SymbolColor"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DefaultIconColors", propOrder = {
        "backgroundColor",
        "backgroundDarkColor",
        "backgroundLightColor",
        "designationColor",
        "symbolColor"
})
public class DefaultIconColors {

    private final transient ObjectProperty<RGBColor> backgroundColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundDarkColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundLightColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> designationColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<SymbolColor> symbolColorProxy = new SimpleObjectProperty<SymbolColor>();
    @XmlElement(name = "background-color", required = true)
    protected RGBColor backgroundColor;
    @XmlElement(name = "background-dark-color", required = true)
    protected RGBColor backgroundDarkColor;
    @XmlElement(name = "background-light-color", required = true)
    protected RGBColor backgroundLightColor;
    @XmlElement(name = "designation-color", required = true)
    protected RGBColor designationColor;
    @XmlElement(name = "symbol-color", required = true)
    protected SymbolColor symbolColor;

    /**
     * Gets the value of the backgroundColor property.
     */
    public RGBColor getBackgroundColor() {
        if (this.backgroundColorProxy.get() == null) {
            this.backgroundColorProxy.set(backgroundColor);
        }
        return this.backgroundColorProxy.get();
    }

    /**
     * Sets the value of the backgroundColor property.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundColor(RGBColor value) {
        this.backgroundColor = value;
        this.backgroundColorProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<RGBColor> backgroundColorProperty() {
        return this.backgroundColorProxy;
    }

    /**
     * Gets the value of the backgroundDarkColor property.
     */
    public RGBColor getBackgroundDarkColor() {
        if (this.backgroundDarkColorProxy.get() == null) {
            this.backgroundDarkColorProxy.set(backgroundDarkColor);
        }
        return this.backgroundDarkColorProxy.get();
    }

    /**
     * Sets the value of the backgroundDarkColor property.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundDarkColor(RGBColor value) {
        this.backgroundDarkColor = value;
        this.backgroundDarkColorProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<RGBColor> backgroundDarkColorProperty() {
        return this.backgroundDarkColorProxy;
    }

    /**
     * Gets the value of the backgroundLightColor property.
     */
    public RGBColor getBackgroundLightColor() {
        if (this.backgroundLightColorProxy.get() == null) {
            this.backgroundLightColorProxy.set(backgroundLightColor);
        }
        return this.backgroundLightColorProxy.get();
    }

    /**
     * Sets the value of the backgroundLightColor property.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundLightColor(RGBColor value) {
        this.backgroundLightColor = value;
        this.backgroundLightColorProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<RGBColor> backgroundLightColorProperty() {
        return this.backgroundLightColorProxy;
    }

    /**
     * Gets the value of the designationColor property.
     */
    public RGBColor getDesignationColor() {
        if (this.designationColorProxy.get() == null) {
            this.designationColorProxy.set(designationColor);
        }
        return this.designationColorProxy.get();
    }

    /**
     * Sets the value of the designationColor property.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setDesignationColor(RGBColor value) {
        this.designationColor = value;
        this.designationColorProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<RGBColor> designationColorProperty() {
        return this.designationColorProxy;
    }

    /**
     * Gets the value of the symbolColor property.
     */
    public SymbolColor getSymbolColor() {
        if (this.symbolColorProxy.get() == null) {
            this.symbolColorProxy.set(symbolColor);
        }
        return this.symbolColorProxy.get();
    }

    /**
     * Sets the value of the symbolColor property.
     *
     * @param value allowed object is
     *              {@link SymbolColor }
     */
    public void setSymbolColor(SymbolColor value) {
        this.symbolColor = value;
        this.symbolColorProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<SymbolColor> symbolColorProperty() {
        return this.symbolColorProxy;
    }

}
