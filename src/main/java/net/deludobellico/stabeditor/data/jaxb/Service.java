//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.24 at 02:15:22 AM CEST 
//


package net.deludobellico.stabeditor.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.ListProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Service complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Service">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="large-insignia" type="{}Insignia"/>
 *         &lt;element name="small-insignia" type="{}Insignia"/>
 *         &lt;element name="rank-list" type="{}RankList"/>
 *         &lt;element name="default-icon-colors" type="{}DefaultIconColors"/>
 *         &lt;element name="force" type="{}Force" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Service", propOrder = {
    "name",
    "description",
    "largeInsignia",
    "smallInsignia",
    "rankList",
    "defaultIconColors",
    "force"
})
public class Service {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(name = "large-insignia", required = true)
    protected Insignia largeInsignia;
    @XmlElement(name = "small-insignia", required = true)
    protected Insignia smallInsignia;
    @XmlElement(name = "rank-list", required = true)
    protected RankList rankList;
    @XmlElement(name = "default-icon-colors", required = true)
    protected DefaultIconColors defaultIconColors;
    protected List<Force> force;
    @XmlAttribute(name = "id", required = true)
    protected short id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Insignia> largeInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient ObjectProperty<Insignia> smallInsigniaProxy = new SimpleObjectProperty<Insignia>();
    private final transient ObjectProperty<RankList> rankListProxy = new SimpleObjectProperty<RankList>();
    private final transient ObjectProperty<DefaultIconColors> defaultIconColorsProxy = new SimpleObjectProperty<DefaultIconColors>();
    private final transient ObjectProperty<Short> idProxy = new SimpleObjectProperty<Short>();

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
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
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
    public void setSmallInsignia(Insignia value) {
        this.smallInsignia = value;
        this.smallInsigniaProxy.set(value);
    }

    /**
     * Sets the value of the rankList property.
     * 
     * @param value
     *     allowed object is
     *     {@link RankList }
     *     
     */
    public void setRankList(RankList value) {
        this.rankList = value;
        this.rankListProxy.set(value);
    }

    /**
     * Sets the value of the defaultIconColors property.
     * 
     * @param value
     *     allowed object is
     *     {@link DefaultIconColors }
     *     
     */
    public void setDefaultIconColors(DefaultIconColors value) {
        this.defaultIconColors = value;
        this.defaultIconColorsProxy.set(value);
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(short value) {
        this.id = value;
        this.idProxy.set(value);
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
     * Gets the value of the description property.
     * 
     */
    public String getDescription() {
        if (this.descriptionProxy.get() == null) {
            this.descriptionProxy.set(description);
        }
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
        if (this.largeInsigniaProxy.get() == null) {
            this.largeInsigniaProxy.set(largeInsignia);
        }
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
        if (this.smallInsigniaProxy.get() == null) {
            this.smallInsigniaProxy.set(smallInsignia);
        }
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
     * Gets the value of the rankList property.
     * 
     */
    public RankList getRankList() {
        if (this.rankListProxy.get() == null) {
            this.rankListProxy.set(rankList);
        }
        return this.rankListProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RankList> rankListProperty() {
        return this.rankListProxy;
    }

    /**
     * Gets the value of the defaultIconColors property.
     * 
     */
    public DefaultIconColors getDefaultIconColors() {
        if (this.defaultIconColorsProxy.get() == null) {
            this.defaultIconColorsProxy.set(defaultIconColors);
        }
        return this.defaultIconColorsProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<DefaultIconColors> defaultIconColorsProperty() {
        return this.defaultIconColorsProxy;
    }

    /**
     * Gets the value of the force property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the force property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getForce().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Force }
     * 
     * 
     */
    public List<Force> getForce() {
        if (force == null) {
            List backingList = new ArrayList<Force>();
            force = new SimpleListProperty<Force>(FXCollections.observableArrayList(backingList));
        }
        SimpleListProperty<Force> forceWrapper = ((SimpleListProperty<Force> ) this.force);
        return forceWrapper.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ListProperty<Force> forceProperty() {
        return ((ListProperty<Force> ) this.force);
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public short getId() {
        if (this.idProxy.get() == null) {
            this.idProxy.set(id);
        }
        return this.idProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Short> idProperty() {
        return this.idProxy;
    }

}
