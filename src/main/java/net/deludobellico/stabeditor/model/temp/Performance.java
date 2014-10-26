//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
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
    protected int minRange;
    @XmlElement(required = true)
    protected ROF rof;
    @XmlElement(name = "burst-radius")
    protected int burstRadius;
    @XmlElement(name = "shell-weight")
    protected float shellWeight;
    @XmlElement(name = "range-table", required = true)
    protected RangeTable rangeTable;
    @XmlAttribute(name = "fire-type")
    protected FireType fireType;
    private final transient ObjectProperty<AmmoLoad> ammoProxy = new SimpleObjectProperty<AmmoLoad>();
    private final transient IntegerProperty minRangeProxy = new SimpleIntegerProperty();
    private final transient ObjectProperty<ROF> rofProxy = new SimpleObjectProperty<ROF>();
    private final transient IntegerProperty burstRadiusProxy = new SimpleIntegerProperty();
    private final transient FloatProperty shellWeightProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<RangeTable> rangeTableProxy = new SimpleObjectProperty<RangeTable>();
    private final transient ObjectProperty<FireType> fireTypeProxy = new SimpleObjectProperty<FireType>();

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
        this.ammoProxy.set(value);
    }

    /**
     * Define el valor de la propiedad minRange.
     * 
     */
    public void setMinRange(int value) {
        this.minRange = value;
        this.minRangeProxy.set(value);
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
        this.rofProxy.set(value);
    }

    /**
     * Define el valor de la propiedad burstRadius.
     * 
     */
    public void setBurstRadius(int value) {
        this.burstRadius = value;
        this.burstRadiusProxy.set(value);
    }

    /**
     * Define el valor de la propiedad shellWeight.
     * 
     */
    public void setShellWeight(float value) {
        this.shellWeight = value;
        this.shellWeightProxy.set(value);
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
        this.rangeTableProxy.set(value);
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
        this.fireTypeProxy.set(value);
    }

    /**
     * Obtiene el valor de la propiedad ammo.
     * 
     */
    public AmmoLoad getAmmo() {
        if (this.ammoProxy.get() == null) {
            this.ammoProxy.set(ammo);
        }
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
     * Obtiene el valor de la propiedad minRange.
     * 
     */
    public int getMinRange() {
        return this.minRangeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty minRangeProperty() {
        return this.minRangeProxy;
    }

    /**
     * Obtiene el valor de la propiedad rof.
     * 
     */
    public ROF getRof() {
        if (this.rofProxy.get() == null) {
            this.rofProxy.set(rof);
        }
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
     * Obtiene el valor de la propiedad burstRadius.
     * 
     */
    public int getBurstRadius() {
        return this.burstRadiusProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty burstRadiusProperty() {
        return this.burstRadiusProxy;
    }

    /**
     * Obtiene el valor de la propiedad shellWeight.
     * 
     */
    public float getShellWeight() {
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
     * Obtiene el valor de la propiedad rangeTable.
     * 
     */
    public RangeTable getRangeTable() {
        if (this.rangeTableProxy.get() == null) {
            this.rangeTableProxy.set(rangeTable);
        }
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
     * Obtiene el valor de la propiedad fireType.
     * 
     */
    public FireType getFireType() {
        if (this.fireTypeProxy.get() == null) {
            this.fireTypeProxy.set(fireType);
        }
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
