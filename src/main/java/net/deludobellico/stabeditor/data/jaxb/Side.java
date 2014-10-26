//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 04:36:56 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.*;
import javafx.collections.FXCollections;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for Side complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Side">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="basics-consumption-rate" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="default-enemy-aper-fp" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="default-enemy-aarm-fp" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="nation" type="{}Nation" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}byte" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Side {

    protected String name;
    protected String description;
    protected Insignia largeInsignia;
    protected Insignia smallInsignia;
    protected float basicsConsumptionRate;
    protected byte defaultEnemyAperFp;
    protected byte defaultEnemyAarmFp;
    protected List<Nation> nation;
    protected byte id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Insignia> largeInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient ObjectProperty<Insignia> smallInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient FloatProperty basicsConsumptionRateProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<Byte> defaultEnemyAperFpProxy = new SimpleObjectProperty<Byte>();
    private final transient ObjectProperty<Byte> defaultEnemyAarmFpProxy = new SimpleObjectProperty<Byte>();
    private final transient ObjectProperty<Byte> idProxy = new SimpleObjectProperty<Byte>();

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlElement(required = true)
    public void setName(String value) {
        this.name = value;
        this.nameProxy.set(value);
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlElement(required = true)
    public void setDescription(String value) {
        this.description = value;
        this.descriptionProxy.set(value);
    }

    /**
     * Sets the value of the largeInsignia property.
     * 
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *
     */
    @XmlElement(required = true, name = "large-insignia")
    public void setLargeInsignia(Insignia value) {
        this.largeInsignia = value;
        this.largeInsigniaProxy.set(value);
    }

    /**
     * Sets the value of the smallInsignia property.
     *
     * @param value
     *     allowed object is
     *     {@link Insignia }
     *
     */
    @XmlElement(required = true, name = "small-insignia")
    public void setSmallInsignia(Insignia value) {
        this.smallInsignia = value;
        this.smallInsigniaProxy.set(value);
    }

    /**
     * Sets the value of the basicsConsumptionRate property.
     *
     */
    @XmlElement(name = "basics-consumption-rate")
    public void setBasicsConsumptionRate(float value) {
        this.basicsConsumptionRate = value;
        this.basicsConsumptionRateProxy.set(value);
    }

    /**
     * Sets the value of the defaultEnemyAperFp property.
     *
     */
    @XmlElement(name = "default-enemy-aper-fp")
    public void setDefaultEnemyAperFp(byte value) {
        this.defaultEnemyAperFp = value;
        this.defaultEnemyAperFpProxy.set(value);
    }

    /**
     * Sets the value of the defaultEnemyAarmFp property.
     *
     */
    @XmlElement(name = "default-enemy-aarm-fp")
    public void setDefaultEnemyAarmFp(byte value) {
        this.defaultEnemyAarmFp = value;
        this.defaultEnemyAarmFpProxy.set(value);
    }

    /**
     * Sets the value of the id property.
     *
     */
    @XmlAttribute(required = true, name = "id")
    public void setId(byte value) {
        this.id = value;
        this.idProxy.set(value);
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
     * Gets the value of the description property.
     *
     */
    public String getDescription() {
        return this.descriptionProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public StringProperty descriptionProperty() {
        return this.descriptionProxy;
    }

    /**
     * Gets the value of the largeInsignia property.
     *
     */
    public Insignia getLargeInsignia() {
        return this.largeInsigniaProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public ObjectProperty<Insignia> largeInsigniaProperty() {
        return this.largeInsigniaProxy;
    }

    /**
     * Gets the value of the smallInsignia property.
     *
     */
    public Insignia getSmallInsignia() {
        return this.smallInsigniaProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public ObjectProperty<Insignia> smallInsigniaProperty() {
        return this.smallInsigniaProxy;
    }

    /**
     * Gets the value of the basicsConsumptionRate property.
     *
     */
    public float getBasicsConsumptionRate() {
        return this.basicsConsumptionRateProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public FloatProperty basicsConsumptionRateProperty() {
        return this.basicsConsumptionRateProxy;
    }

    /**
     * Gets the value of the defaultEnemyAperFp property.
     *
     */
    public byte getDefaultEnemyAperFp() {
        return this.defaultEnemyAperFpProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public ObjectProperty<Byte> defaultEnemyAperFpProperty() {
        return this.defaultEnemyAperFpProxy;
    }

    /**
     * Gets the value of the defaultEnemyAarmFp property.
     *
     */
    public byte getDefaultEnemyAarmFp() {
        return this.defaultEnemyAarmFpProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     *
     */
    public ObjectProperty<Byte> defaultEnemyAarmFpProperty() {
        return this.defaultEnemyAarmFpProxy;
    }

    /**
     * Gets the value of the nation property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the nation property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNation().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Nation }
     * 
     * 
     */
    public List<Nation> getNation() {
        if (nation == null) {
            List backingList = new ArrayList<Nation>();
            nation = new SimpleListProperty<Nation>(FXCollections.observableArrayList(backingList));
        }
        SimpleListProperty<Nation> nationWrapper = ((SimpleListProperty<Nation> ) this.nation);
        return nationWrapper.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ListProperty<Nation> nationProperty() {
        return ((ListProperty<Nation> ) this.nation);
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public byte getId() {
        return this.idProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Byte> idProperty() {
        return this.idProxy;
    }

}
