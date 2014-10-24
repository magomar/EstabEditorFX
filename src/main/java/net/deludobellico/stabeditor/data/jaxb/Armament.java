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
 * <p>Java class for Armament complex type.
 * <p>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;complexType name="Armament">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="equipment-object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="equipment-name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" use="required" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Armament")
public class Armament {

    private final transient ObjectProperty<Short> equipmentObjectIdProxy = new SimpleObjectProperty<Short>();
    private final transient StringProperty equipmentNameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Byte> qtyProxy = new SimpleObjectProperty<Byte>();
    @XmlAttribute(name = "equipment-object-id", required = true)
    protected short equipmentObjectId;
    @XmlAttribute(name = "equipment-name", required = true)
    protected String equipmentName;
    @XmlAttribute(name = "qty", required = true)
    protected byte qty;

    /**
     * Gets the value of the equipmentObjectId property.
     */
    public short getEquipmentObjectId() {
        if (this.equipmentObjectIdProxy.get() == null) {
            this.equipmentObjectIdProxy.set(equipmentObjectId);
        }
        return this.equipmentObjectIdProxy.get();
    }

    /**
     * Sets the value of the equipmentObjectId property.
     */
    public void setEquipmentObjectId(short value) {
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
     * Gets the value of the equipmentName property.
     */
    public String getEquipmentName() {
        if (this.equipmentNameProxy.get() == null) {
            this.equipmentNameProxy.set(equipmentName);
        }
        return this.equipmentNameProxy.get();
    }

    /**
     * Sets the value of the equipmentName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEquipmentName(String value) {
        this.equipmentName = value;
        this.equipmentNameProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public StringProperty equipmentNameProperty() {
        return this.equipmentNameProxy;
    }

    /**
     * Gets the value of the qty property.
     */
    public byte getQty() {
        if (this.qtyProxy.get() == null) {
            this.qtyProxy.set(qty);
        }
        return this.qtyProxy.get();
    }

    /**
     * Sets the value of the qty property.
     */
    public void setQty(byte value) {
        this.qty = value;
        this.qtyProxy.set(value);
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     */
    public ObjectProperty<Byte> qtyProperty() {
        return this.qtyProxy;
    }

}
