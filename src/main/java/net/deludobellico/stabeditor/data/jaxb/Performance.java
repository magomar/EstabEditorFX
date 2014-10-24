//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 10:33:57 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Performance complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
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
    private final transient ObjectProperty<AmmoLoad> ammoProxy = new SimpleObjectProperty<AmmoLoad>();
    private final transient ObjectProperty<Byte> minRangeProxy = new SimpleObjectProperty<Byte>();
    private final transient ObjectProperty<ROF> rofProxy = new SimpleObjectProperty<ROF>();
    private final transient ObjectProperty<Byte> burstRadiusProxy = new SimpleObjectProperty<Byte>();
    private final transient FloatProperty shellWeightProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<RangeTable> rangeTableProxy = new SimpleObjectProperty<RangeTable>();
    private final transient ObjectProperty<FireType> fireTypeProxy = new SimpleObjectProperty<FireType>();

    /**
     * Sets the value of the ammo property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.AmmoLoad }
     *     
     */
    public void setAmmo(AmmoLoad value) {
        this.ammo = value;
        this.ammoProxy.set(value);
    }

    /**
     * Sets the value of the minRange property.
     * 
     */
    public void setMinRange(byte value) {
        this.minRange = value;
        this.minRangeProxy.set(value);
    }

    /**
     * Sets the value of the rof property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.ROF }
     *     
     */
    public void setRof(ROF value) {
        this.rof = value;
        this.rofProxy.set(value);
    }

    /**
     * Sets the value of the burstRadius property.
     * 
     */
    public void setBurstRadius(byte value) {
        this.burstRadius = value;
        this.burstRadiusProxy.set(value);
    }

    /**
     * Sets the value of the shellWeight property.
     * 
     */
    public void setShellWeight(float value) {
        this.shellWeight = value;
        this.shellWeightProxy.set(value);
    }

    /**
     * Sets the value of the rangeTable property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.RangeTable }
     *     
     */
    public void setRangeTable(RangeTable value) {
        this.rangeTable = value;
        this.rangeTableProxy.set(value);
    }

    /**
     * Sets the value of the fireType property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.FireType }
     *     
     */
    public void setFireType(FireType value) {
        this.fireType = value;
        this.fireTypeProxy.set(value);
    }

    /**
     * Gets the value of the ammo property.
     * 
     */
    public AmmoLoad getAmmo() {
        this.ammoProxy.set(ammo);
        return this.ammoProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<AmmoLoad> ammoProperty() {
        return this.ammoProxy;
    }

    /**
     * Gets the value of the minRange property.
     * 
     */
    public byte getMinRange() {
        this.minRangeProxy.set(minRange);
        return this.minRangeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Byte> minRangeProperty() {
        return this.minRangeProxy;
    }

    /**
     * Gets the value of the rof property.
     * 
     */
    public ROF getRof() {
        this.rofProxy.set(rof);
        return this.rofProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<ROF> rofProperty() {
        return this.rofProxy;
    }

    /**
     * Gets the value of the burstRadius property.
     * 
     */
    public byte getBurstRadius() {
        this.burstRadiusProxy.set(burstRadius);
        return this.burstRadiusProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Byte> burstRadiusProperty() {
        return this.burstRadiusProxy;
    }

    /**
     * Gets the value of the shellWeight property.
     * 
     */
    public float getShellWeight() {
        this.shellWeightProxy.set(shellWeight);
        return this.shellWeightProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty shellWeightProperty() {
        return this.shellWeightProxy;
    }

    /**
     * Gets the value of the rangeTable property.
     * 
     */
    public RangeTable getRangeTable() {
        this.rangeTableProxy.set(rangeTable);
        return this.rangeTableProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RangeTable> rangeTableProperty() {
        return this.rangeTableProxy;
    }

    /**
     * Gets the value of the fireType property.
     * 
     */
    public FireType getFireType() {
        this.fireTypeProxy.set(fireType);
        return this.fireTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FireType> fireTypeProperty() {
        return this.fireTypeProxy;
    }

}
