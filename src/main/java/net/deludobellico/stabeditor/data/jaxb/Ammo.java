//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 04:24:04 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.*;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Ammo complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Ammo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="min-order-qty" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="min-order-weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Ammo", propOrder = {
        "name",
        "description",
        "minOrderQty",
        "minOrderWeight"
})
public class Ammo {

    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Short> minOrderQtyProxy = new SimpleObjectProperty<Short>();
    private final transient FloatProperty minOrderWeightProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<Short> idProxy = new SimpleObjectProperty<Short>();
    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "min-order-qty")
    protected short minOrderQty;
    @XmlElement(name = "min-order-weight")
    protected float minOrderWeight;
    @XmlAttribute(name = "id", required = true)
    protected short id;

    /**
     * Gets the value of the name property.
     */
    public String getName() {
        if (this.nameProxy.get() == null) {
            this.nameProxy.set(name);
        }
        return this.nameProxy.get();
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public StringProperty nameProperty() {
        return this.nameProxy;
    }

    /**
     * Gets the value of the description property.
     */
    public String getDescription() {
        if (this.descriptionProxy.get() == null) {
            this.descriptionProxy.set(description);
        }
        return this.descriptionProxy.get();
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
        this.descriptionProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public StringProperty descriptionProperty() {
        return this.descriptionProxy;
    }

    /**
     * Gets the value of the minOrderQty property.
     */
    public short getMinOrderQty() {
        if (this.minOrderQtyProxy.get() == null) {
            this.minOrderQtyProxy.set(minOrderQty);
        }
        return this.minOrderQtyProxy.get();
    }

    /**
     * Sets the value of the minOrderQty property.
     */
    public void setMinOrderQty(short value) {
        this.minOrderQty = value;
        this.minOrderQtyProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Short> minOrderQtyProperty() {
        return this.minOrderQtyProxy;
    }

    /**
     * Gets the value of the minOrderWeight property.
     */
    public float getMinOrderWeight() {
        if (this.minOrderWeightProxy.get() == 0) {
            this.minOrderWeightProxy.set(minOrderWeight);
        }
        return this.minOrderWeightProxy.get();
    }

    /**
     * Sets the value of the minOrderWeight property.
     */
    public void setMinOrderWeight(float value) {
        this.minOrderWeight = value;
        this.minOrderWeightProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public FloatProperty minOrderWeightProperty() {
        return this.minOrderWeightProxy;
    }

    /**
     * Gets the value of the id property.
     */
    public short getId() {
        if (this.idProxy.get() == null) {
            this.idProxy.set(id);
        }
        return this.idProxy.get();
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(short value) {
        this.id = value;
        this.idProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Short> idProperty() {
        return this.idProxy;
    }

}
