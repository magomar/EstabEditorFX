
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para DefaultIconColors complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
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
 * 
 * 
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

    /**
     * Obtiene el valor de la propiedad backgroundColor.
     * 
     * @return
     *     possible object is
     *     {@link RGBColor }
     *     
     */
    public RGBColor getBackgroundColor() {
        return backgroundColor;
    }

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
    }

    /**
     * Obtiene el valor de la propiedad backgroundDarkColor.
     * 
     * @return
     *     possible object is
     *     {@link RGBColor }
     *     
     */
    public RGBColor getBackgroundDarkColor() {
        return backgroundDarkColor;
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
    }

    /**
     * Obtiene el valor de la propiedad backgroundLightColor.
     * 
     * @return
     *     possible object is
     *     {@link RGBColor }
     *     
     */
    public RGBColor getBackgroundLightColor() {
        return backgroundLightColor;
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
    }

    /**
     * Obtiene el valor de la propiedad designationColor.
     * 
     * @return
     *     possible object is
     *     {@link RGBColor }
     *     
     */
    public RGBColor getDesignationColor() {
        return designationColor;
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
    }

    /**
     * Obtiene el valor de la propiedad symbolColor.
     * 
     * @return
     *     possible object is
     *     {@link SymbolColor }
     *     
     */
    public SymbolColor getSymbolColor() {
        return symbolColor;
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
    }

}
