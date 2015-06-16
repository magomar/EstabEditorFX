
package net.deludobellico.estabeditorfx.data.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="calibre" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="muzzle-velocity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="must-deploy-to-fire" type="{}YesNo"/>
 *         &lt;element name="performance-list" type="{}PerformanceList"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="flags" type="{}FlagList" />
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
    protected double reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected WeaponType type;
    @XmlElement(name = "single-shot", required = true)
    @XmlSchemaType(name = "string")
    protected YesNo singleShot;
    @XmlElement(name = "primary-role", required = true)
    @XmlSchemaType(name = "string")
    protected PrimaryRole primaryRole;
    protected double calibre;
    @XmlElement(name = "muzzle-velocity")
    protected int muzzleVelocity;
    @XmlElement(name = "must-deploy-to-fire", required = true)
    @XmlSchemaType(name = "string")
    protected YesNo mustDeployToFire;
    @XmlElement(name = "performance-list", required = true)
    protected PerformanceList performanceList;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "flags")
    protected List<Flag> flags;

    /**
     * Obtiene el valor de la propiedad name.
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
     * Define el valor de la propiedad name.
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
     * Obtiene el valor de la propiedad description.
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
     * Define el valor de la propiedad description.
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
     * Obtiene el valor de la propiedad picture.
     * 
     * @return
     *     possible object is
     *     {@link Picture }
     *     
     */
    public Picture getPicture() {
        return picture;
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
    }

    /**
     * Obtiene el valor de la propiedad pictureFilename.
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
     * Define el valor de la propiedad pictureFilename.
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
     * Obtiene el valor de la propiedad size.
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
     * Define el valor de la propiedad size.
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
     * Obtiene el valor de la propiedad crew.
     * 
     */
    public int getCrew() {
        return crew;
    }

    /**
     * Define el valor de la propiedad crew.
     * 
     */
    public void setCrew(int value) {
        this.crew = value;
    }

    /**
     * Obtiene el valor de la propiedad reliability.
     * 
     */
    public double getReliability() {
        return reliability;
    }

    /**
     * Define el valor de la propiedad reliability.
     * 
     */
    public void setReliability(double value) {
        this.reliability = value;
    }

    /**
     * Obtiene el valor de la propiedad armaments.
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
     * Define el valor de la propiedad armaments.
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
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link WeaponType }
     *     
     */
    public WeaponType getType() {
        return type;
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
    }

    /**
     * Obtiene el valor de la propiedad singleShot.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getSingleShot() {
        return singleShot;
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
    }

    /**
     * Obtiene el valor de la propiedad primaryRole.
     * 
     * @return
     *     possible object is
     *     {@link PrimaryRole }
     *     
     */
    public PrimaryRole getPrimaryRole() {
        return primaryRole;
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
    }

    /**
     * Obtiene el valor de la propiedad calibre.
     * 
     */
    public double getCalibre() {
        return calibre;
    }

    /**
     * Define el valor de la propiedad calibre.
     * 
     */
    public void setCalibre(double value) {
        this.calibre = value;
    }

    /**
     * Obtiene el valor de la propiedad muzzleVelocity.
     * 
     */
    public int getMuzzleVelocity() {
        return muzzleVelocity;
    }

    /**
     * Define el valor de la propiedad muzzleVelocity.
     * 
     */
    public void setMuzzleVelocity(int value) {
        this.muzzleVelocity = value;
    }

    /**
     * Obtiene el valor de la propiedad mustDeployToFire.
     * 
     * @return
     *     possible object is
     *     {@link YesNo }
     *     
     */
    public YesNo getMustDeployToFire() {
        return mustDeployToFire;
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
    }

    /**
     * Obtiene el valor de la propiedad performanceList.
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
     * Define el valor de la propiedad performanceList.
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
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the flags property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the flags property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFlags().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Flag }
     * 
     * 
     */
    public List<Flag> getFlags() {
        if (flags == null) {
            flags = new ArrayList<Flag>();
        }
        return this.flags;
    }

}
