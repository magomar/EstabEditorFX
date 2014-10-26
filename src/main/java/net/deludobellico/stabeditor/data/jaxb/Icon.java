//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 04:36:56 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

import javax.xml.bind.annotation.XmlElement;


/**
 * <p>Java class for Icon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Icon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="background-color" type="{}RGBColor"/>
 *         &lt;element name="background-dark-color" type="{}RGBColor"/>
 *         &lt;element name="background-light-color" type="{}RGBColor"/>
 *         &lt;element name="designation-color" type="{}RGBColor"/>
 *         &lt;element name="symbol-color" type="{}SymbolColor"/>
 *         &lt;element name="military-symbol" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="picture-symbol" type="{}PictureSymbol"/>
 *         &lt;element name="force-size-icon" type="{}ForceSize"/>
 *         &lt;element name="is-hq" type="{}YesNo"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Icon {

    protected RGBColor backgroundColor;
    protected RGBColor backgroundDarkColor;
    protected RGBColor backgroundLightColor;
    protected RGBColor designationColor;
    protected SymbolColor symbolColor;
    protected byte militarySymbol;
    protected PictureSymbol pictureSymbol;
    protected ForceSize forceSizeIcon;
    protected YesNo isHq;
    private final transient ObjectProperty<RGBColor> backgroundColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundDarkColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundLightColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> designationColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<SymbolColor> symbolColorProxy = new SimpleObjectProperty<SymbolColor>();
    private final transient ObjectProperty<Byte> militarySymbolProxy = new SimpleObjectProperty<Byte>();
    private final transient ObjectProperty<PictureSymbol> pictureSymbolProxy = new SimpleObjectProperty<PictureSymbol>();
    private final transient ObjectProperty<ForceSize> forceSizeIconProxy = new SimpleObjectProperty<ForceSize>();
    private final transient ObjectProperty<YesNo> isHqProxy = new SimpleObjectProperty<YesNo>();

    /**
     * Sets the value of the backgroundColor property.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *
     */
    @XmlElement(required = true, name = "background-color")
    public void setBackgroundColor(RGBColor value) {
        this.backgroundColor = value;
        this.backgroundColorProxy.set(value);
    }

    /**
     * Sets the value of the backgroundDarkColor property.
     *
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *
     */
    @XmlElement(required = true, name = "background-dark-color")
    public void setBackgroundDarkColor(RGBColor value) {
        this.backgroundDarkColor = value;
        this.backgroundDarkColorProxy.set(value);
    }

    /**
     * Sets the value of the backgroundLightColor property.
     *
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *
     */
    @XmlElement(required = true, name = "background-light-color")
    public void setBackgroundLightColor(RGBColor value) {
        this.backgroundLightColor = value;
        this.backgroundLightColorProxy.set(value);
    }

    /**
     * Sets the value of the designationColor property.
     *
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *
     */
    @XmlElement(required = true, name = "designation-color")
    public void setDesignationColor(RGBColor value) {
        this.designationColor = value;
        this.designationColorProxy.set(value);
    }

    /**
     * Sets the value of the symbolColor property.
     *
     * @param value
     *     allowed object is
     *     {@link SymbolColor }
     *
     */
    @XmlElement(required = true, name = "symbol-color")
    public void setSymbolColor(SymbolColor value) {
        this.symbolColor = value;
        this.symbolColorProxy.set(value);
    }

    /**
     * Sets the value of the militarySymbol property.
     *
     */
    @XmlElement(name = "military-symbol")
    public void setMilitarySymbol(byte value) {
        this.militarySymbol = value;
        this.militarySymbolProxy.set(value);
    }

    /**
     * Sets the value of the pictureSymbol property.
     *
     * @param value
     *     allowed object is
     *     {@link PictureSymbol }
     *
     */
    @XmlElement(required = true, name = "picture-symbol")
    public void setPictureSymbol(PictureSymbol value) {
        this.pictureSymbol = value;
        this.pictureSymbolProxy.set(value);
    }

    /**
     * Sets the value of the forceSizeIcon property.
     *
     * @param value
     *     allowed object is
     *     {@link ForceSize }
     *
     */
    @XmlElement(required = true, name = "force-size-icon")
    public void setForceSizeIcon(ForceSize value) {
        this.forceSizeIcon = value;
        this.forceSizeIconProxy.set(value);
    }

    /**
     * Sets the value of the isHq property.
     *
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    @XmlElement(required = true, name = "is-hq")
    public void setIsHq(YesNo value) {
        this.isHq = value;
        this.isHqProxy.set(value);
    }

    /**
     * Gets the value of the backgroundColor property.
     * 
     */
    public RGBColor getBackgroundColor() {
        return this.backgroundColorProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RGBColor> backgroundColorProperty() {
        return this.backgroundColorProxy;
    }

    /**
     * Gets the value of the backgroundDarkColor property.
     * 
     */
    public RGBColor getBackgroundDarkColor() {
        return this.backgroundDarkColorProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RGBColor> backgroundDarkColorProperty() {
        return this.backgroundDarkColorProxy;
    }

    /**
     * Gets the value of the backgroundLightColor property.
     * 
     */
    public RGBColor getBackgroundLightColor() {
        return this.backgroundLightColorProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RGBColor> backgroundLightColorProperty() {
        return this.backgroundLightColorProxy;
    }

    /**
     * Gets the value of the designationColor property.
     * 
     */
    public RGBColor getDesignationColor() {
        return this.designationColorProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RGBColor> designationColorProperty() {
        return this.designationColorProxy;
    }

    /**
     * Gets the value of the symbolColor property.
     * 
     */
    public SymbolColor getSymbolColor() {
        return this.symbolColorProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<SymbolColor> symbolColorProperty() {
        return this.symbolColorProxy;
    }

    /**
     * Gets the value of the militarySymbol property.
     * 
     */
    public byte getMilitarySymbol() {
        return this.militarySymbolProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Byte> militarySymbolProperty() {
        return this.militarySymbolProxy;
    }

    /**
     * Gets the value of the pictureSymbol property.
     * 
     */
    public PictureSymbol getPictureSymbol() {
        return this.pictureSymbolProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<PictureSymbol> pictureSymbolProperty() {
        return this.pictureSymbolProxy;
    }

    /**
     * Gets the value of the forceSizeIcon property.
     * 
     */
    public ForceSize getForceSizeIcon() {
        return this.forceSizeIconProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<ForceSize> forceSizeIconProperty() {
        return this.forceSizeIconProxy;
    }

    /**
     * Gets the value of the isHq property.
     * 
     */
    public YesNo getIsHq() {
        return this.isHqProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<YesNo> isHqProperty() {
        return this.isHqProxy;
    }

}
