//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Icon complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
 *         &lt;element name="military-symbol" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Icon", propOrder = {
    "backgroundColor",
    "backgroundDarkColor",
    "backgroundLightColor",
    "designationColor",
    "symbolColor",
    "militarySymbol",
    "pictureSymbol",
    "forceSizeIcon",
    "isHq"
})
public class Icon {

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
    @XmlElement(name = "military-symbol")
    protected int militarySymbol;
    @XmlElement(name = "picture-symbol", required = true)
    protected PictureSymbol pictureSymbol;
    @XmlElement(name = "force-size-icon", required = true)
    protected ForceSize forceSizeIcon;
    @XmlElement(name = "is-hq", required = true)
    protected YesNo isHq;
    private final transient ObjectProperty<RGBColor> backgroundColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundDarkColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> backgroundLightColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<RGBColor> designationColorProxy = new SimpleObjectProperty<RGBColor>();
    private final transient ObjectProperty<SymbolColor> symbolColorProxy = new SimpleObjectProperty<SymbolColor>();
    private final transient IntegerProperty militarySymbolProxy = new SimpleIntegerProperty();
    private final transient ObjectProperty<PictureSymbol> pictureSymbolProxy = new SimpleObjectProperty<PictureSymbol>();
    private final transient ObjectProperty<ForceSize> forceSizeIconProxy = new SimpleObjectProperty<ForceSize>();
    private final transient ObjectProperty<YesNo> isHqProxy = new SimpleObjectProperty<YesNo>();

    /**
     * Define el valor de la propiedad backgroundColor.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *     
     */
    public void setBackgroundColor(RGBColor value) {
        this.backgroundColor = value;
        this.backgroundColorProxy.set(value);
    }

    /**
     * Define el valor de la propiedad backgroundDarkColor.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *     
     */
    public void setBackgroundDarkColor(RGBColor value) {
        this.backgroundDarkColor = value;
        this.backgroundDarkColorProxy.set(value);
    }

    /**
     * Define el valor de la propiedad backgroundLightColor.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *     
     */
    public void setBackgroundLightColor(RGBColor value) {
        this.backgroundLightColor = value;
        this.backgroundLightColorProxy.set(value);
    }

    /**
     * Define el valor de la propiedad designationColor.
     * 
     * @param value
     *     allowed object is
     *     {@link RGBColor }
     *     
     */
    public void setDesignationColor(RGBColor value) {
        this.designationColor = value;
        this.designationColorProxy.set(value);
    }

    /**
     * Define el valor de la propiedad symbolColor.
     * 
     * @param value
     *     allowed object is
     *     {@link SymbolColor }
     *     
     */
    public void setSymbolColor(SymbolColor value) {
        this.symbolColor = value;
        this.symbolColorProxy.set(value);
    }

    /**
     * Define el valor de la propiedad militarySymbol.
     * 
     */
    public void setMilitarySymbol(int value) {
        this.militarySymbol = value;
        this.militarySymbolProxy.set(value);
    }

    /**
     * Define el valor de la propiedad pictureSymbol.
     * 
     * @param value
     *     allowed object is
     *     {@link PictureSymbol }
     *     
     */
    public void setPictureSymbol(PictureSymbol value) {
        this.pictureSymbol = value;
        this.pictureSymbolProxy.set(value);
    }

    /**
     * Define el valor de la propiedad forceSizeIcon.
     * 
     * @param value
     *     allowed object is
     *     {@link ForceSize }
     *     
     */
    public void setForceSizeIcon(ForceSize value) {
        this.forceSizeIcon = value;
        this.forceSizeIconProxy.set(value);
    }

    /**
     * Define el valor de la propiedad isHq.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setIsHq(YesNo value) {
        this.isHq = value;
        this.isHqProxy.set(value);
    }

    /**
     * Obtiene el valor de la propiedad backgroundColor.
     * 
     */
    public RGBColor getBackgroundColor() {
        if (this.backgroundColorProxy.get() == null) {
            this.backgroundColorProxy.set(backgroundColor);
        }
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
     * Obtiene el valor de la propiedad backgroundDarkColor.
     * 
     */
    public RGBColor getBackgroundDarkColor() {
        if (this.backgroundDarkColorProxy.get() == null) {
            this.backgroundDarkColorProxy.set(backgroundDarkColor);
        }
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
     * Obtiene el valor de la propiedad backgroundLightColor.
     * 
     */
    public RGBColor getBackgroundLightColor() {
        if (this.backgroundLightColorProxy.get() == null) {
            this.backgroundLightColorProxy.set(backgroundLightColor);
        }
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
     * Obtiene el valor de la propiedad designationColor.
     * 
     */
    public RGBColor getDesignationColor() {
        if (this.designationColorProxy.get() == null) {
            this.designationColorProxy.set(designationColor);
        }
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
     * Obtiene el valor de la propiedad symbolColor.
     * 
     */
    public SymbolColor getSymbolColor() {
        if (this.symbolColorProxy.get() == null) {
            this.symbolColorProxy.set(symbolColor);
        }
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
     * Obtiene el valor de la propiedad militarySymbol.
     * 
     */
    public int getMilitarySymbol() {
        return this.militarySymbolProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty militarySymbolProperty() {
        return this.militarySymbolProxy;
    }

    /**
     * Obtiene el valor de la propiedad pictureSymbol.
     * 
     */
    public PictureSymbol getPictureSymbol() {
        if (this.pictureSymbolProxy.get() == null) {
            this.pictureSymbolProxy.set(pictureSymbol);
        }
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
     * Obtiene el valor de la propiedad forceSizeIcon.
     * 
     */
    public ForceSize getForceSizeIcon() {
        if (this.forceSizeIconProxy.get() == null) {
            this.forceSizeIconProxy.set(forceSizeIcon);
        }
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
     * Obtiene el valor de la propiedad isHq.
     * 
     */
    public YesNo getIsHq() {
        if (this.isHqProxy.get() == null) {
            this.isHqProxy.set(isHq);
        }
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
