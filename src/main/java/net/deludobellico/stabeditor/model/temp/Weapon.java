//
// Este archivo ha sido generado por la arquitectura JavaTM para la implantación de la referencia de enlace (JAXB) XML v2.2.7 
// Visite <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas las modificaciones realizadas en este archivo se perderán si se vuelve a compilar el esquema de origen. 
// Generado el: 2014.10.26 a las 10:08:24 AM CET 
//


package net.deludobellico.stabeditor.model.temp;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Weapon complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
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
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Weapon", propOrder = {
    "name",
    "description",
    "picture",
    "pictureFilename",
    "size",
    "crew",
    "reliability",
    "armaments",
    "type",
    "singleShot",
    "primaryRole",
    "calibre",
    "muzzleVelocity",
    "mustDeployToFire",
    "performanceList"
})
public class Weapon {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Picture picture;
    @XmlElement(name = "picture-filename", required = true)
    protected String pictureFilename;
    @XmlElement(required = true)
    protected WeaponSize size;
    protected int crew;
    protected float reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(required = true)
    protected WeaponType type;
    @XmlElement(name = "single-shot", required = true)
    protected YesNo singleShot;
    @XmlElement(name = "primary-role", required = true)
    protected PrimaryRole primaryRole;
    protected float calibre;
    @XmlElement(name = "muzzle-velocity")
    protected int muzzleVelocity;
    @XmlElement(name = "must-deploy-to-fire", required = true)
    protected YesNo mustDeployToFire;
    @XmlElement(name = "performance-list", required = true)
    protected PerformanceList performanceList;
    @XmlAttribute(name = "id")
    protected Integer id;
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
     * Define el valor de la propiedad name.
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
     * Define el valor de la propiedad description.
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
     * Define el valor de la propiedad picture.
     * 
     * @param value
     *     allowed object is
     *     {@link Picture }
     *     
     */
    public void setPicture(Picture value) {
        this.picture = value;
        this.pictureProxy.set(value);
    }

    /**
     * Define el valor de la propiedad pictureFilename.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
        this.pictureFilenameProxy.set(value);
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaponSize }
     *     
     */
    public void setSize(WeaponSize value) {
        this.size = value;
        this.sizeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad crew.
     * 
     */
    public void setCrew(int value) {
        this.crew = value;
        this.crewProxy.set(value);
    }

    /**
     * Define el valor de la propiedad reliability.
     * 
     */
    public void setReliability(float value) {
        this.reliability = value;
        this.reliabilityProxy.set(value);
    }

    /**
     * Define el valor de la propiedad armaments.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArmaments(String value) {
        this.armaments = value;
        this.armamentsProxy.set(value);
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaponType }
     *     
     */
    public void setType(WeaponType value) {
        this.type = value;
        this.typeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad singleShot.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setSingleShot(YesNo value) {
        this.singleShot = value;
        this.singleShotProxy.set(value);
    }

    /**
     * Define el valor de la propiedad primaryRole.
     * 
     * @param value
     *     allowed object is
     *     {@link PrimaryRole }
     *     
     */
    public void setPrimaryRole(PrimaryRole value) {
        this.primaryRole = value;
        this.primaryRoleProxy.set(value);
    }

    /**
     * Define el valor de la propiedad calibre.
     * 
     */
    public void setCalibre(float value) {
        this.calibre = value;
        this.calibreProxy.set(value);
    }

    /**
     * Define el valor de la propiedad muzzleVelocity.
     * 
     */
    public void setMuzzleVelocity(int value) {
        this.muzzleVelocity = value;
        this.muzzleVelocityProxy.set(value);
    }

    /**
     * Define el valor de la propiedad mustDeployToFire.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setMustDeployToFire(YesNo value) {
        this.mustDeployToFire = value;
        this.mustDeployToFireProxy.set(value);
    }

    /**
     * Define el valor de la propiedad performanceList.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceList }
     *     
     */
    public void setPerformanceList(PerformanceList value) {
        this.performanceList = value;
        this.performanceListProxy.set(value);
    }

    /**
     * Define el valor de la propiedad id.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
        this.idProxy.set(value);
    }

    /**
     * Obtiene el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad description.
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
     * Obtiene el valor de la propiedad picture.
     * 
     */
    public Picture getPicture() {
        if (this.pictureProxy.get() == null) {
            this.pictureProxy.set(picture);
        }
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
     * Obtiene el valor de la propiedad pictureFilename.
     * 
     */
    public String getPictureFilename() {
        if (this.pictureFilenameProxy.get() == null) {
            this.pictureFilenameProxy.set(pictureFilename);
        }
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
     * Obtiene el valor de la propiedad size.
     * 
     */
    public WeaponSize getSize() {
        if (this.sizeProxy.get() == null) {
            this.sizeProxy.set(size);
        }
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
     * Obtiene el valor de la propiedad crew.
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
     * Obtiene el valor de la propiedad reliability.
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
     * Obtiene el valor de la propiedad armaments.
     * 
     */
    public String getArmaments() {
        if (this.armamentsProxy.get() == null) {
            this.armamentsProxy.set(armaments);
        }
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
     * Obtiene el valor de la propiedad type.
     * 
     */
    public WeaponType getType() {
        if (this.typeProxy.get() == null) {
            this.typeProxy.set(type);
        }
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
     * Obtiene el valor de la propiedad singleShot.
     * 
     */
    public YesNo getSingleShot() {
        if (this.singleShotProxy.get() == null) {
            this.singleShotProxy.set(singleShot);
        }
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
     * Obtiene el valor de la propiedad primaryRole.
     * 
     */
    public PrimaryRole getPrimaryRole() {
        if (this.primaryRoleProxy.get() == null) {
            this.primaryRoleProxy.set(primaryRole);
        }
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
     * Obtiene el valor de la propiedad calibre.
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
     * Obtiene el valor de la propiedad muzzleVelocity.
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
     * Obtiene el valor de la propiedad mustDeployToFire.
     * 
     */
    public YesNo getMustDeployToFire() {
        if (this.mustDeployToFireProxy.get() == null) {
            this.mustDeployToFireProxy.set(mustDeployToFire);
        }
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
     * Obtiene el valor de la propiedad performanceList.
     * 
     */
    public PerformanceList getPerformanceList() {
        if (this.performanceListProxy.get() == null) {
            this.performanceListProxy.set(performanceList);
        }
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
     * Obtiene el valor de la propiedad id.
     * 
     */
    public Integer getId() {
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
