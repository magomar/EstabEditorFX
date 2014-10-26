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
 * <p>Java class for AmmoQty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmmoQty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="ammo-object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="qty" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class AmmoQty {

    protected int ammoObjectId;
    protected String name;
    protected int qty;
    private final transient IntegerProperty ammoObjectIdProxy = new SimpleIntegerProperty();
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient IntegerProperty qtyProxy = new SimpleIntegerProperty();

    /**
     * Sets the value of the ammoObjectId property.
     * 
     */
    @XmlAttribute(required = true, name = "ammo-object-id")
    public void setAmmoObjectId(int value) {
        this.ammoObjectId = value;
        this.ammoObjectIdProxy.set(value);
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlAttribute(required = true, name = "name")
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Sets the value of the qty property.
     * 
     */
    @XmlAttribute(required = true, name = "qty")
    public void setQty(int value) {
        this.qty = value;
        this.qtyProxy.set(value);
    }

    /**
     * Gets the value of the ammoObjectId property.
     * 
     */
    public int getAmmoObjectId() {
        return this.ammoObjectIdProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty ammoObjectIdProperty() {
        return this.ammoObjectIdProxy;
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
    public int getQty() {
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
