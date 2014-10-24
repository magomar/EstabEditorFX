//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 04:24:04 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Equipment complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Equipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="equipment-object-id" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Equipment")
public class Equipment {

    private final transient ObjectProperty<Short> equipmentObjectIdProxy = new SimpleObjectProperty<Short>();
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Short> qtyProxy = new SimpleObjectProperty<Short>();
    @XmlAttribute(name = "equipment-object-id")
    protected Short equipmentObjectId;
    @XmlAttribute(name = "name")
    protected String name;
    @XmlAttribute(name = "qty")
    protected Short qty;

    /**
     * Gets the value of the equipmentObjectId property.
     */
    public Short getEquipmentObjectId() {
        if (this.equipmentObjectIdProxy.get() == null) {
            this.equipmentObjectIdProxy.set(equipmentObjectId);
        }
        return this.equipmentObjectIdProxy.get();
    }

    /**
     * Sets the value of the equipmentObjectId property.
     *
     * @param value allowed object is
     *              {@link Short }
     */
    public void setEquipmentObjectId(Short value) {
        this.equipmentObjectId = value;
        this.equipmentObjectIdProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Short> equipmentObjectIdProperty() {
        return this.equipmentObjectIdProxy;
    }

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
     * Gets the value of the qty property.
     */
    public Short getQty() {
        if (this.qtyProxy.get() == null) {
            this.qtyProxy.set(qty);
        }
        return this.qtyProxy.get();
    }

    /**
     * Sets the value of the qty property.
     *
     * @param value allowed object is
     *              {@link Short }
     */
    public void setQty(Short value) {
        this.qty = value;
        this.qtyProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Short> qtyProperty() {
        return this.qtyProxy;
    }

}
