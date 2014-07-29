
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Performance complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Performance">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ammo" type="{}AmmoLoad"/>
 *         &lt;element name="min-range" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="rof" type="{}ROF"/>
 *         &lt;element name="burst-radius" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="shell-weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="range-table" type="{}RangeTable"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fire-type" type="{}FireType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
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
    protected byte minRange;
    @XmlElement(required = true)
    protected ROF rof;
    @XmlElement(name = "burst-radius")
    protected byte burstRadius;
    @XmlElement(name = "shell-weight")
    protected float shellWeight;
    @XmlElement(name = "range-table", required = true)
    protected RangeTable rangeTable;
    @XmlAttribute(name = "fire-type")
    protected FireType fireType;

    /**
     * Gets the value of the ammo property.
     *
     * @return possible object is
     * {@link AmmoLoad }
     */
    public AmmoLoad getAmmo() {
        return ammo;
    }

    /**
     * Sets the value of the ammo property.
     *
     * @param value allowed object is
     *              {@link AmmoLoad }
     */
    public void setAmmo(AmmoLoad value) {
        this.ammo = value;
    }

    /**
     * Gets the value of the minRange property.
     */
    public byte getMinRange() {
        return minRange;
    }

    /**
     * Sets the value of the minRange property.
     */
    public void setMinRange(byte value) {
        this.minRange = value;
    }

    /**
     * Gets the value of the rof property.
     *
     * @return possible object is
     * {@link ROF }
     */
    public ROF getRof() {
        return rof;
    }

    /**
     * Sets the value of the rof property.
     *
     * @param value allowed object is
     *              {@link ROF }
     */
    public void setRof(ROF value) {
        this.rof = value;
    }

    /**
     * Gets the value of the burstRadius property.
     */
    public byte getBurstRadius() {
        return burstRadius;
    }

    /**
     * Sets the value of the burstRadius property.
     */
    public void setBurstRadius(byte value) {
        this.burstRadius = value;
    }

    /**
     * Gets the value of the shellWeight property.
     */
    public float getShellWeight() {
        return shellWeight;
    }

    /**
     * Sets the value of the shellWeight property.
     */
    public void setShellWeight(float value) {
        this.shellWeight = value;
    }

    /**
     * Gets the value of the rangeTable property.
     *
     * @return possible object is
     * {@link RangeTable }
     */
    public RangeTable getRangeTable() {
        return rangeTable;
    }

    /**
     * Sets the value of the rangeTable property.
     *
     * @param value allowed object is
     *              {@link RangeTable }
     */
    public void setRangeTable(RangeTable value) {
        this.rangeTable = value;
    }

    /**
     * Gets the value of the fireType property.
     *
     * @return possible object is
     * {@link FireType }
     */
    public FireType getFireType() {
        return fireType;
    }

    /**
     * Sets the value of the fireType property.
     *
     * @param value allowed object is
     *              {@link FireType }
     */
    public void setFireType(FireType value) {
        this.fireType = value;
    }

}
