
package net.deludobellico.estabeditorfx.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Performance complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Performance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ammo" type="{}AmmoLoad"/>
 *         &lt;element name="min-range" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="rof" type="{}ROF"/>
 *         &lt;element name="burst-radius" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="shell-weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="range-table" type="{}RangeTable"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fire-type" use="required" type="{}FireType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Performance", propOrder = {
    "ammo",
    "minRange",
    "rof",
    "burstRadius",
    "shellWeight",
    "rangeTable"
})
public class Performance {

    @XmlElement(required = true)
    protected AmmoLoad ammo;
    @XmlElement(name = "min-range")
    protected int minRange;
    @XmlElement(required = true)
    protected ROF rof;
    @XmlElement(name = "burst-radius")
    protected int burstRadius;
    @XmlElement(name = "shell-weight")
    protected double shellWeight;
    @XmlElement(name = "range-table", required = true)
    protected RangeTable rangeTable;
    @XmlAttribute(name = "fire-type", required = true)
    protected FireType fireType;

    /**
     * Obtiene el valor de la propiedad ammo.
     * 
     * @return
     *     possible object is
     *     {@link AmmoLoad }
     *     
     */
    public AmmoLoad getAmmo() {
        return ammo;
    }

    /**
     * Define el valor de la propiedad ammo.
     * 
     * @param value
     *     allowed object is
     *     {@link AmmoLoad }
     *     
     */
    public void setAmmo(AmmoLoad value) {
        this.ammo = value;
    }

    /**
     * Obtiene el valor de la propiedad minRange.
     * 
     */
    public int getMinRange() {
        return minRange;
    }

    /**
     * Define el valor de la propiedad minRange.
     * 
     */
    public void setMinRange(int value) {
        this.minRange = value;
    }

    /**
     * Obtiene el valor de la propiedad rof.
     * 
     * @return
     *     possible object is
     *     {@link ROF }
     *     
     */
    public ROF getRof() {
        return rof;
    }

    /**
     * Define el valor de la propiedad rof.
     * 
     * @param value
     *     allowed object is
     *     {@link ROF }
     *     
     */
    public void setRof(ROF value) {
        this.rof = value;
    }

    /**
     * Obtiene el valor de la propiedad burstRadius.
     * 
     */
    public int getBurstRadius() {
        return burstRadius;
    }

    /**
     * Define el valor de la propiedad burstRadius.
     * 
     */
    public void setBurstRadius(int value) {
        this.burstRadius = value;
    }

    /**
     * Obtiene el valor de la propiedad shellWeight.
     * 
     */
    public double getShellWeight() {
        return shellWeight;
    }

    /**
     * Define el valor de la propiedad shellWeight.
     * 
     */
    public void setShellWeight(double value) {
        this.shellWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad rangeTable.
     * 
     * @return
     *     possible object is
     *     {@link RangeTable }
     *     
     */
    public RangeTable getRangeTable() {
        return rangeTable;
    }

    /**
     * Define el valor de la propiedad rangeTable.
     * 
     * @param value
     *     allowed object is
     *     {@link RangeTable }
     *     
     */
    public void setRangeTable(RangeTable value) {
        this.rangeTable = value;
    }

    /**
     * Obtiene el valor de la propiedad fireType.
     * 
     * @return
     *     possible object is
     *     {@link FireType }
     *     
     */
    public FireType getFireType() {
        return fireType;
    }

    /**
     * Define el valor de la propiedad fireType.
     * 
     * @param value
     *     allowed object is
     *     {@link FireType }
     *     
     */
    public void setFireType(FireType value) {
        this.fireType = value;
    }

}
