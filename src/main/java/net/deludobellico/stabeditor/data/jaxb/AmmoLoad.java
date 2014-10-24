//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 02:15:22 AM CEST 
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
 * <p>Java class for AmmoLoad complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AmmoLoad">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="object-id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *       &lt;attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="load" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AmmoLoad")
public class AmmoLoad {

    @XmlAttribute(name = "object-id", required = true)
    protected short objectId;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "load", required = true)
    protected short load;
    private final transient ObjectProperty<Short> objectIdProxy = new SimpleObjectProperty<Short>();
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Short> loadProxy = new SimpleObjectProperty<Short>();

    /**
     * Sets the value of the objectId property.
     * 
     */
    public void setObjectId(short value) {
        this.objectId = value;
        this.objectIdProxy.set(value);
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Sets the value of the load property.
     * 
     */
    public void setLoad(short value) {
        this.load = value;
        this.loadProxy.set(value);
    }

    /**
     * Gets the value of the objectId property.
     * 
     */
    public short getObjectId() {
        if (this.objectIdProxy.get() == null) {
            this.objectIdProxy.set(objectId);
        }
        return this.objectIdProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Short> objectIdProperty() {
        return this.objectIdProxy;
    }

    /**
     * Gets the value of the name property.
     * 
     */
    public String getName() {
        if (this.nameProxy.get() == null) {
            this.nameProxy.set(name);
        }
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
     * Gets the value of the load property.
     * 
     */
    public short getLoad() {
        if (this.loadProxy.get() == null) {
            this.loadProxy.set(load);
        }
        return this.loadProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Short> loadProperty() {
        return this.loadProxy;
    }

}
