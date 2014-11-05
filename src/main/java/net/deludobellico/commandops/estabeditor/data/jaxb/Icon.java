package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para Icon complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
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
    @XmlSchemaType(name = "string")
    protected SymbolColor symbolColor;
    @XmlElement(name = "military-symbol")
    protected int militarySymbol;
    @XmlElement(name = "picture-symbol", required = true)
    @XmlSchemaType(name = "string")
    protected PictureSymbol pictureSymbol;
    @XmlElement(name = "force-size-icon", required = true)
    @XmlSchemaType(name = "string")
    protected ForceSize forceSizeIcon;
    @XmlElement(name = "is-hq", required = true)
    @XmlSchemaType(name = "string")
    protected YesNo isHq;

    /**
     * Obtiene el valor de la propiedad backgroundColor.
     *
     * @return possible object is
     * {@link RGBColor }
     */
    public RGBColor getBackgroundColor() {
        return backgroundColor;
    }

    /**
     * Define el valor de la propiedad backgroundColor.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundColor(RGBColor value) {
        this.backgroundColor = value;
    }

    /**
     * Obtiene el valor de la propiedad backgroundDarkColor.
     *
     * @return possible object is
     * {@link RGBColor }
     */
    public RGBColor getBackgroundDarkColor() {
        return backgroundDarkColor;
    }

    /**
     * Define el valor de la propiedad backgroundDarkColor.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundDarkColor(RGBColor value) {
        this.backgroundDarkColor = value;
    }

    /**
     * Obtiene el valor de la propiedad backgroundLightColor.
     *
     * @return possible object is
     * {@link RGBColor }
     */
    public RGBColor getBackgroundLightColor() {
        return backgroundLightColor;
    }

    /**
     * Define el valor de la propiedad backgroundLightColor.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setBackgroundLightColor(RGBColor value) {
        this.backgroundLightColor = value;
    }

    /**
     * Obtiene el valor de la propiedad designationColor.
     *
     * @return possible object is
     * {@link RGBColor }
     */
    public RGBColor getDesignationColor() {
        return designationColor;
    }

    /**
     * Define el valor de la propiedad designationColor.
     *
     * @param value allowed object is
     *              {@link RGBColor }
     */
    public void setDesignationColor(RGBColor value) {
        this.designationColor = value;
    }

    /**
     * Obtiene el valor de la propiedad symbolColor.
     *
     * @return possible object is
     * {@link SymbolColor }
     */
    public SymbolColor getSymbolColor() {
        return symbolColor;
    }

    /**
     * Define el valor de la propiedad symbolColor.
     *
     * @param value allowed object is
     *              {@link SymbolColor }
     */
    public void setSymbolColor(SymbolColor value) {
        this.symbolColor = value;
    }

    /**
     * Obtiene el valor de la propiedad militarySymbol.
     */
    public int getMilitarySymbol() {
        return militarySymbol;
    }

    /**
     * Define el valor de la propiedad militarySymbol.
     */
    public void setMilitarySymbol(int value) {
        this.militarySymbol = value;
    }

    /**
     * Obtiene el valor de la propiedad pictureSymbol.
     *
     * @return possible object is
     * {@link PictureSymbol }
     */
    public PictureSymbol getPictureSymbol() {
        return pictureSymbol;
    }

    /**
     * Define el valor de la propiedad pictureSymbol.
     *
     * @param value allowed object is
     *              {@link PictureSymbol }
     */
    public void setPictureSymbol(PictureSymbol value) {
        this.pictureSymbol = value;
    }

    /**
     * Obtiene el valor de la propiedad forceSizeIcon.
     *
     * @return possible object is
     * {@link ForceSize }
     */
    public ForceSize getForceSizeIcon() {
        return forceSizeIcon;
    }

    /**
     * Define el valor de la propiedad forceSizeIcon.
     *
     * @param value allowed object is
     *              {@link ForceSize }
     */
    public void setForceSizeIcon(ForceSize value) {
        this.forceSizeIcon = value;
    }

    /**
     * Obtiene el valor de la propiedad isHq.
     *
     * @return possible object is
     * {@link YesNo }
     */
    public YesNo getIsHq() {
        return isHq;
    }

    /**
     * Define el valor de la propiedad isHq.
     *
     * @param value allowed object is
     *              {@link YesNo }
     */
    public void setIsHq(YesNo value) {
        this.isHq = value;
    }

}
