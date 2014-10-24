//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 10:33:57 PM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FormationSecurity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FormationSecurity">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="front" type="{}Security"/>
 *         &lt;element name="left" type="{}Security"/>
 *         &lt;element name="right" type="{}Security"/>
 *         &lt;element name="rear" type="{}Security"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FormationSecurity", propOrder = {
    "front",
    "left",
    "right",
    "rear"
})
public class FormationSecurity {

    @XmlElement(required = true)
    protected Security front;
    @XmlElement(required = true)
    protected Security left;
    @XmlElement(required = true)
    protected Security right;
    @XmlElement(required = true)
    protected Security rear;
    private final transient ObjectProperty<Security> frontProxy = new SimpleObjectProperty<Security>();
    private final transient ObjectProperty<Security> leftProxy = new SimpleObjectProperty<Security>();
    private final transient ObjectProperty<Security> rightProxy = new SimpleObjectProperty<Security>();
    private final transient ObjectProperty<Security> rearProxy = new SimpleObjectProperty<Security>();

    /**
     * Sets the value of the front property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.Security }
     *     
     */
    public void setFront(Security value) {
        this.front = value;
        this.frontProxy.set(value);
    }

    /**
     * Sets the value of the left property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.Security }
     *     
     */
    public void setLeft(Security value) {
        this.left = value;
        this.leftProxy.set(value);
    }

    /**
     * Sets the value of the right property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.Security }
     *     
     */
    public void setRight(Security value) {
        this.right = value;
        this.rightProxy.set(value);
    }

    /**
     * Sets the value of the rear property.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.data.jaxb.Security }
     *     
     */
    public void setRear(Security value) {
        this.rear = value;
        this.rearProxy.set(value);
    }

    /**
     * Gets the value of the front property.
     * 
     */
    public Security getFront() {
        this.frontProxy.set(front);
        return this.frontProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Security> frontProperty() {
        return this.frontProxy;
    }

    /**
     * Gets the value of the left property.
     * 
     */
    public Security getLeft() {
        this.leftProxy.set(left);
        return this.leftProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Security> leftProperty() {
        return this.leftProxy;
    }

    /**
     * Gets the value of the right property.
     * 
     */
    public Security getRight() {
        this.rightProxy.set(right);
        return this.rightProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Security> rightProperty() {
        return this.rightProxy;
    }

    /**
     * Gets the value of the rear property.
     * 
     */
    public Security getRear() {
        this.rearProxy.set(rear);
        return this.rearProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Security> rearProperty() {
        return this.rearProxy;
    }

}
