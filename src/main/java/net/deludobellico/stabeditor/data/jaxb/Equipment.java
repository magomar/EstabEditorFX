//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 08:01:14 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.xml.bind.annotation.XmlAttribute;


/**
 * <p>Java class for Equipment complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Equipment">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="equipment-object-id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Equipment {

    protected Integer equipmentObjectId;
    protected String name;
    protected Integer qty;
    private final transient IntegerProperty equipmentObjectIdProxy = new SimpleIntegerProperty();
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient IntegerProperty qtyProxy = new SimpleIntegerProperty();

    /**
     * Sets the value of the equipmentObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @XmlAttribute(name = "equipment-object-id")
    public void setEquipmentObjectId(Integer value) {
        this.equipmentObjectId = value;
        this.equipmentObjectIdProxy.set(value);
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlAttribute(name = "name")
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Sets the value of the qty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    @XmlAttribute(name = "qty")
    public void setQty(Integer value) {
        this.qty = value;
        this.qtyProxy.set(value);
    }

    /**
     * Gets the value of the equipmentObjectId property.
     * 
     */
    public Integer getEquipmentObjectId() {
        return this.equipmentObjectIdProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty equipmentObjectIdProperty() {
        return this.equipmentObjectIdProxy;
    }

    /**
     * Gets the value of the name property.
     * 
     */
    public String getName() {
        return this.nameProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty nameProperty() {
        return this.nameProxy;
    }

    /**
     * Gets the value of the qty property.
     * 
     */
    public Integer getQty() {
        return this.qtyProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty qtyProperty() {
        return this.qtyProxy;
    }

}
