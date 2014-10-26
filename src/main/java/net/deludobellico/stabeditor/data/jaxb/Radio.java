//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.10.26 at 08:01:14 PM CET 
//


package net.deludobellico.stabeditor.data.jaxb;

import javafx.beans.property.*;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;


/**
 * <p>Java class for Radio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Radio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}RadioSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="net-type" type="{}NetType"/>
 *         &lt;element name="freq-type" type="{}FreqType"/>
 *         &lt;element name="max-range" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="gain" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Radio {

    protected String name;
    protected String description;
    protected String picture;
    protected String pictureFilename;
    protected RadioSize size;
    protected String crew;
    protected float reliability;
    protected String armaments;
    protected NetType netType;
    protected FreqType freqType;
    protected int maxRange;
    protected float gain;
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient StringProperty pictureProxy = new SimpleStringProperty();
    private final transient StringProperty pictureFilenameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<RadioSize> sizeProxy = new SimpleObjectProperty<RadioSize>();
    private final transient StringProperty crewProxy = new SimpleStringProperty();
    private final transient FloatProperty reliabilityProxy = new SimpleFloatProperty();
    private final transient StringProperty armamentsProxy = new SimpleStringProperty();
    private final transient ObjectProperty<NetType> netTypeProxy = new SimpleObjectProperty<NetType>();
    private final transient ObjectProperty<FreqType> freqTypeProxy = new SimpleObjectProperty<FreqType>();
    private final transient IntegerProperty maxRangeProxy = new SimpleIntegerProperty();
    private final transient FloatProperty gainProxy = new SimpleFloatProperty();
    private final transient IntegerProperty idProxy = new SimpleIntegerProperty();

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
     * Sets the value of the picture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlElement(required = true)
    public void setPicture(String value) {
        this.picture = value;
        this.pictureProxy.set(value);
    }

    /**
     * Sets the value of the pictureFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @XmlElement(required = true, name = "picture-filename")
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
        this.pictureFilenameProxy.set(value);
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link RadioSize }
     *
     */
    @XmlElement(required = true)
    public void setSize(RadioSize value) {
        this.size = value;
        this.sizeProxy.set(value);
    }

    /**
     * Sets the value of the crew property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlElement(required = true)
    public void setCrew(String value) {
        this.crew = value;
        this.crewProxy.set(value);
    }

    /**
     * Sets the value of the reliability property.
     *
     */
    public void setReliability(float value) {
        this.reliability = value;
        this.reliabilityProxy.set(value);
    }

    /**
     * Sets the value of the armaments property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    @XmlElement(required = true)
    public void setArmaments(String value) {
        this.armaments = value;
        this.armamentsProxy.set(value);
    }

    /**
     * Sets the value of the netType property.
     *
     * @param value
     *     allowed object is
     *     {@link NetType }
     *
     */
    @XmlElement(required = true, name = "net-type")
    public void setNetType(NetType value) {
        this.netType = value;
        this.netTypeProxy.set(value);
    }

    /**
     * Sets the value of the freqType property.
     *
     * @param value
     *     allowed object is
     *     {@link FreqType }
     *     
     */
    @XmlElement(required = true, name = "freq-type")
    public void setFreqType(FreqType value) {
        this.freqType = value;
        this.freqTypeProxy.set(value);
    }

    /**
     * Sets the value of the maxRange property.
     * 
     */
    @XmlElement(name = "max-range")
    public void setMaxRange(int value) {
        this.maxRange = value;
        this.maxRangeProxy.set(value);
    }

    /**
     * Sets the value of the gain property.
     * 
     */
    public void setGain(float value) {
        this.gain = value;
        this.gainProxy.set(value);
    }

    /**
     * Sets the value of the id property.
     * 
     */
    @XmlAttribute(required = true, name = "id")
    public void setId(int value) {
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
     * Gets the value of the picture property.
     * 
     */
    public String getPicture() {
        return this.pictureProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty pictureProperty() {
        return this.pictureProxy;
    }

    /**
     * Gets the value of the pictureFilename property.
     * 
     */
    public String getPictureFilename() {
        return this.pictureFilenameProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty pictureFilenameProperty() {
        return this.pictureFilenameProxy;
    }

    /**
     * Gets the value of the size property.
     * 
     */
    public RadioSize getSize() {
        return this.sizeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<RadioSize> sizeProperty() {
        return this.sizeProxy;
    }

    /**
     * Gets the value of the crew property.
     * 
     */
    public String getCrew() {
        return this.crewProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty crewProperty() {
        return this.crewProxy;
    }

    /**
     * Gets the value of the reliability property.
     * 
     */
    public float getReliability() {
        return this.reliabilityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty reliabilityProperty() {
        return this.reliabilityProxy;
    }

    /**
     * Gets the value of the armaments property.
     * 
     */
    public String getArmaments() {
        return this.armamentsProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty armamentsProperty() {
        return this.armamentsProxy;
    }

    /**
     * Gets the value of the netType property.
     * 
     */
    public NetType getNetType() {
        return this.netTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<NetType> netTypeProperty() {
        return this.netTypeProxy;
    }

    /**
     * Gets the value of the freqType property.
     * 
     */
    public FreqType getFreqType() {
        return this.freqTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<FreqType> freqTypeProperty() {
        return this.freqTypeProxy;
    }

    /**
     * Gets the value of the maxRange property.
     * 
     */
    public int getMaxRange() {
        return this.maxRangeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty maxRangeProperty() {
        return this.maxRangeProxy;
    }

    /**
     * Gets the value of the gain property.
     * 
     */
    public float getGain() {
        return this.gainProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty gainProperty() {
        return this.gainProxy;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return this.idProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty idProperty() {
        return this.idProxy;
    }

}
