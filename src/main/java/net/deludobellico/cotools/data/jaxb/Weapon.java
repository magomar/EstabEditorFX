
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="picture" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}WeaponSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="single-shot" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="primary-role" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="calibre" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="muzzle-velocity" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="must-deploy-to-fire" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="performance-list" type="{}PerformanceList"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}short" />
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
    protected String picture;
    @XmlElement(name = "picture-filename", required = true)
    protected String pictureFilename;
    @XmlElement(required = true)
    protected WeaponSize size;
    protected byte crew;
    protected float reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(name = "single-shot", required = true)
    protected String singleShot;
    @XmlElement(name = "primary-role", required = true)
    protected String primaryRole;
    protected float calibre;
    @XmlElement(name = "muzzle-velocity")
    protected short muzzleVelocity;
    @XmlElement(name = "must-deploy-to-fire", required = true)
    protected String mustDeployToFire;
    @XmlElement(name = "performance-list", required = true)
    protected PerformanceList performanceList;
    @XmlAttribute(name = "id")
    protected Short id;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
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
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
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
    }

    /**
     * Gets the value of the picture property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the value of the picture property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPicture(String value) {
        this.picture = value;
    }

    /**
     * Gets the value of the pictureFilename property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPictureFilename() {
        return pictureFilename;
    }

    /**
     * Sets the value of the pictureFilename property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
    }

    /**
     * Gets the value of the size property.
     * 
     * @return
     *     possible object is
     *     {@link WeaponSize }
     *     
     */
    public WeaponSize getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeaponSize }
     *     
     */
    public void setSize(WeaponSize value) {
        this.size = value;
    }

    /**
     * Gets the value of the crew property.
     * 
     */
    public byte getCrew() {
        return crew;
    }

    /**
     * Sets the value of the crew property.
     * 
     */
    public void setCrew(byte value) {
        this.crew = value;
    }

    /**
     * Gets the value of the reliability property.
     * 
     */
    public float getReliability() {
        return reliability;
    }

    /**
     * Sets the value of the reliability property.
     * 
     */
    public void setReliability(float value) {
        this.reliability = value;
    }

    /**
     * Gets the value of the armaments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getArmaments() {
        return armaments;
    }

    /**
     * Sets the value of the armaments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setArmaments(String value) {
        this.armaments = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the singleShot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSingleShot() {
        return singleShot;
    }

    /**
     * Sets the value of the singleShot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSingleShot(String value) {
        this.singleShot = value;
    }

    /**
     * Gets the value of the primaryRole property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryRole() {
        return primaryRole;
    }

    /**
     * Sets the value of the primaryRole property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryRole(String value) {
        this.primaryRole = value;
    }

    /**
     * Gets the value of the calibre property.
     * 
     */
    public float getCalibre() {
        return calibre;
    }

    /**
     * Sets the value of the calibre property.
     * 
     */
    public void setCalibre(float value) {
        this.calibre = value;
    }

    /**
     * Gets the value of the muzzleVelocity property.
     * 
     */
    public short getMuzzleVelocity() {
        return muzzleVelocity;
    }

    /**
     * Sets the value of the muzzleVelocity property.
     * 
     */
    public void setMuzzleVelocity(short value) {
        this.muzzleVelocity = value;
    }

    /**
     * Gets the value of the mustDeployToFire property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMustDeployToFire() {
        return mustDeployToFire;
    }

    /**
     * Sets the value of the mustDeployToFire property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMustDeployToFire(String value) {
        this.mustDeployToFire = value;
    }

    /**
     * Gets the value of the performanceList property.
     * 
     * @return
     *     possible object is
     *     {@link PerformanceList }
     *     
     */
    public PerformanceList getPerformanceList() {
        return performanceList;
    }

    /**
     * Sets the value of the performanceList property.
     * 
     * @param value
     *     allowed object is
     *     {@link PerformanceList }
     *     
     */
    public void setPerformanceList(PerformanceList value) {
        this.performanceList = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setId(Short value) {
        this.id = value;
    }

}
