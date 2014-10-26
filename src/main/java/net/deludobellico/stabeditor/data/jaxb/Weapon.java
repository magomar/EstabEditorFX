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
 * <p>Java class for Weapon complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Weapon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{}Picture"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}WeaponSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{}WeaponType"/>
 *         &lt;element name="single-shot" type="{}YesNo"/>
 *         &lt;element name="primary-role" type="{}PrimaryRole"/>
 *         &lt;element name="calibre" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="muzzle-velocity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="must-deploy-to-fire" type="{}YesNo"/>
 *         &lt;element name="performance-list" type="{}PerformanceList"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public class Weapon {

    protected String name;
    protected String description;
    protected Picture picture;
    protected String pictureFilename;
    protected WeaponSize size;
    protected int crew;
    protected float reliability;
    protected String armaments;
    protected WeaponType type;
    protected YesNo singleShot;
    protected PrimaryRole primaryRole;
    protected float calibre;
    protected int muzzleVelocity;
    protected YesNo mustDeployToFire;
    protected PerformanceList performanceList;
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Picture> pictureProxy = new SimpleObjectProperty<Picture>();
    private final transient StringProperty pictureFilenameProxy = new SimpleStringProperty();
    private final transient ObjectProperty<WeaponSize> sizeProxy = new SimpleObjectProperty<WeaponSize>();
    private final transient IntegerProperty crewProxy = new SimpleIntegerProperty();
    private final transient FloatProperty reliabilityProxy = new SimpleFloatProperty();
    private final transient StringProperty armamentsProxy = new SimpleStringProperty();
    private final transient ObjectProperty<WeaponType> typeProxy = new SimpleObjectProperty<WeaponType>();
    private final transient ObjectProperty<YesNo> singleShotProxy = new SimpleObjectProperty<YesNo>();
    private final transient ObjectProperty<PrimaryRole> primaryRoleProxy = new SimpleObjectProperty<PrimaryRole>();
    private final transient FloatProperty calibreProxy = new SimpleFloatProperty();
    private final transient IntegerProperty muzzleVelocityProxy = new SimpleIntegerProperty();
    private final transient ObjectProperty<YesNo> mustDeployToFireProxy = new SimpleObjectProperty<YesNo>();
    private final transient ObjectProperty<PerformanceList> performanceListProxy = new SimpleObjectProperty<PerformanceList>();
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
     *     {@link Picture }
     *
     */
    @XmlElement(required = true)
    public void setPicture(Picture value) {
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
     *     {@link WeaponSize }
     *
     */
    @XmlElement(required = true)
    public void setSize(WeaponSize value) {
        this.size = value;
        this.sizeProxy.set(value);
    }

    /**
     * Sets the value of the crew property.
     *
     */
    public void setCrew(int value) {
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
     * Sets the value of the type property.
     *
     * @param value
     *     allowed object is
     *     {@link WeaponType }
     *
     */
    @XmlElement(required = true)
    public void setType(WeaponType value) {
        this.type = value;
        this.typeProxy.set(value);
    }

    /**
     * Sets the value of the singleShot property.
     *
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *
     */
    @XmlElement(required = true, name = "single-shot")
    public void setSingleShot(YesNo value) {
        this.singleShot = value;
        this.singleShotProxy.set(value);
    }

    /**
     * Sets the value of the primaryRole property.
     *
     * @param value
     *     allowed object is
     *     {@link PrimaryRole }
     *
     */
    @XmlElement(required = true, name = "primary-role")
    public void setPrimaryRole(PrimaryRole value) {
        this.primaryRole = value;
        this.primaryRoleProxy.set(value);
    }

    /**
     * Sets the value of the calibre property.
     *
     */
    public void setCalibre(float value) {
        this.calibre = value;
        this.calibreProxy.set(value);
    }

    /**
     * Sets the value of the muzzleVelocity property.
     *
     */
    @XmlElement(name = "muzzle-velocity")
    public void setMuzzleVelocity(int value) {
        this.muzzleVelocity = value;
        this.muzzleVelocityProxy.set(value);
    }

    /**
     * Sets the value of the mustDeployToFire property.
     *
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *
     */
    @XmlElement(required = true, name = "must-deploy-to-fire")
    public void setMustDeployToFire(YesNo value) {
        this.mustDeployToFire = value;
        this.mustDeployToFireProxy.set(value);
    }

    /**
     * Sets the value of the performanceList property.
     *
     * @param value
     *     allowed object is
     *     {@link PerformanceList }
     *     
     */
    @XmlElement(required = true, name = "performance-list")
    public void setPerformanceList(PerformanceList value) {
        this.performanceList = value;
        this.performanceListProxy.set(value);
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
    public Picture getPicture() {
        return this.pictureProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Picture> pictureProperty() {
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
    public WeaponSize getSize() {
        return this.sizeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<WeaponSize> sizeProperty() {
        return this.sizeProxy;
    }

    /**
     * Gets the value of the crew property.
     * 
     */
    public int getCrew() {
        return this.crewProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty crewProperty() {
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
     * Gets the value of the type property.
     * 
     */
    public WeaponType getType() {
        return this.typeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<WeaponType> typeProperty() {
        return this.typeProxy;
    }

    /**
     * Gets the value of the singleShot property.
     * 
     */
    public YesNo getSingleShot() {
        return this.singleShotProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<YesNo> singleShotProperty() {
        return this.singleShotProxy;
    }

    /**
     * Gets the value of the primaryRole property.
     * 
     */
    public PrimaryRole getPrimaryRole() {
        return this.primaryRoleProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<PrimaryRole> primaryRoleProperty() {
        return this.primaryRoleProxy;
    }

    /**
     * Gets the value of the calibre property.
     * 
     */
    public float getCalibre() {
        return this.calibreProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty calibreProperty() {
        return this.calibreProxy;
    }

    /**
     * Gets the value of the muzzleVelocity property.
     * 
     */
    public int getMuzzleVelocity() {
        return this.muzzleVelocityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty muzzleVelocityProperty() {
        return this.muzzleVelocityProxy;
    }

    /**
     * Gets the value of the mustDeployToFire property.
     * 
     */
    public YesNo getMustDeployToFire() {
        return this.mustDeployToFireProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<YesNo> mustDeployToFireProperty() {
        return this.mustDeployToFireProxy;
    }

    /**
     * Gets the value of the performanceList property.
     * 
     */
    public PerformanceList getPerformanceList() {
        return this.performanceListProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<PerformanceList> performanceListProperty() {
        return this.performanceListProxy;
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
