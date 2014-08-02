
package net.deludobellico.stabeditor.data.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Vehicle complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="Vehicle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{}Picture"/>
 *         &lt;element name="picture-filename" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="size" type="{}VehicleSize"/>
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="fuel-capacity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="speed" type="{}VehicleSpeeds"/>
 *         &lt;element name="fuel-consumption" type="{}SpeedData"/>
 *         &lt;element name="ronsonability" type="{}Proportion"/>
 *         &lt;element name="max-gradient" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="max-fording-depth" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="max-trench-width" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="towing-capacity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="personnel-capacity" type="{http://www.w3.org/2001/XMLSchema}byte"/>
 *         &lt;element name="bulk-fuel-capacity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="payload-capacity" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="take-cover-mod" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="has-turret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="has-open-top" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="battle-weight" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="armour" type="{}Armor"/>
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
@XmlType(name = "Vehicle", propOrder = {
    "name",
    "description",
    "picture",
    "pictureFilename",
    "size",
    "crew",
    "reliability",
    "armaments",
    "type",
    "fuelCapacity",
    "speed",
    "fuelConsumption",
    "ronsonability",
    "maxGradient",
    "maxFordingDepth",
    "maxTrenchWidth",
    "towingCapacity",
    "personnelCapacity",
    "bulkFuelCapacity",
    "payloadCapacity",
    "takeCoverMod",
    "hasTurret",
    "hasOpenTop",
    "battleWeight",
    "armour"
})
public class Vehicle {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Picture picture;
    @XmlElement(name = "picture-filename", required = true)
    protected String pictureFilename;
    @XmlElement(required = true)
    protected VehicleSize size;
    protected byte crew;
    protected float reliability;
    @XmlElement(required = true)
    protected String armaments;
    @XmlElement(required = true)
    protected String type;
    @XmlElement(name = "fuel-capacity")
    protected float fuelCapacity;
    @XmlElement(required = true)
    protected VehicleSpeeds speed;
    @XmlElement(name = "fuel-consumption", required = true)
    protected SpeedData fuelConsumption;
    protected float ronsonability;
    @XmlElement(name = "max-gradient")
    protected byte maxGradient;
    @XmlElement(name = "max-fording-depth")
    protected byte maxFordingDepth;
    @XmlElement(name = "max-trench-width")
    protected byte maxTrenchWidth;
    @XmlElement(name = "towing-capacity")
    protected float towingCapacity;
    @XmlElement(name = "personnel-capacity")
    protected byte personnelCapacity;
    @XmlElement(name = "bulk-fuel-capacity")
    protected float bulkFuelCapacity;
    @XmlElement(name = "payload-capacity")
    protected float payloadCapacity;
    @XmlElement(name = "take-cover-mod")
    protected float takeCoverMod;
    @XmlElement(name = "has-turret", required = true)
    protected String hasTurret;
    @XmlElement(name = "has-open-top", required = true)
    protected String hasOpenTop;
    @XmlElement(name = "battle-weight")
    protected float battleWeight;
    @XmlElement(required = true)
    protected Armor armour;
    @XmlAttribute(name = "id", required = true)
    protected short id;

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
     *     {@link VehicleSize }
     *     
     */
    public VehicleSize getSize() {
        return size;
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleSize }
     *     
     */
    public void setSize(VehicleSize value) {
        this.size = value;
    }

    /**
     * Obtiene el valor de la propiedad crew.
     * 
     */
    public byte getCrew() {
        return crew;
    }

    /**
     * Define el valor de la propiedad crew.
     * 
     */
    public void setCrew(byte value) {
        this.crew = value;
    }

    /**
     * Obtiene el valor de la propiedad reliability.
     * 
     */
    public float getReliability() {
        return reliability;
    }

    /**
     * Define el valor de la propiedad reliability.
     * 
     */
    public void setReliability(float value) {
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
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
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
     * Obtiene el valor de la propiedad fuelCapacity.
     * 
     */
    public float getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Define el valor de la propiedad fuelCapacity.
     * 
     */
    public void setFuelCapacity(float value) {
        this.fuelCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad speed.
     * 
     * @return
     *     possible object is
     *     {@link VehicleSpeeds }
     *     
     */
    public VehicleSpeeds getSpeed() {
        return speed;
    }

    /**
     * Define el valor de la propiedad speed.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleSpeeds }
     *     
     */
    public void setSpeed(VehicleSpeeds value) {
        this.speed = value;
    }

    /**
     * Obtiene el valor de la propiedad fuelConsumption.
     * 
     * @return
     *     possible object is
     *     {@link SpeedData }
     *     
     */
    public SpeedData getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Define el valor de la propiedad fuelConsumption.
     * 
     * @param value
     *     allowed object is
     *     {@link SpeedData }
     *     
     */
    public void setFuelConsumption(SpeedData value) {
        this.fuelConsumption = value;
    }

    /**
     * Obtiene el valor de la propiedad ronsonability.
     * 
     */
    public float getRonsonability() {
        return ronsonability;
    }

    /**
     * Define el valor de la propiedad ronsonability.
     * 
     */
    public void setRonsonability(float value) {
        this.ronsonability = value;
    }

    /**
     * Obtiene el valor de la propiedad maxGradient.
     * 
     */
    public byte getMaxGradient() {
        return maxGradient;
    }

    /**
     * Define el valor de la propiedad maxGradient.
     * 
     */
    public void setMaxGradient(byte value) {
        this.maxGradient = value;
    }

    /**
     * Obtiene el valor de la propiedad maxFordingDepth.
     * 
     */
    public byte getMaxFordingDepth() {
        return maxFordingDepth;
    }

    /**
     * Define el valor de la propiedad maxFordingDepth.
     * 
     */
    public void setMaxFordingDepth(byte value) {
        this.maxFordingDepth = value;
    }

    /**
     * Obtiene el valor de la propiedad maxTrenchWidth.
     * 
     */
    public byte getMaxTrenchWidth() {
        return maxTrenchWidth;
    }

    /**
     * Define el valor de la propiedad maxTrenchWidth.
     * 
     */
    public void setMaxTrenchWidth(byte value) {
        this.maxTrenchWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad towingCapacity.
     * 
     */
    public float getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * Define el valor de la propiedad towingCapacity.
     * 
     */
    public void setTowingCapacity(float value) {
        this.towingCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad personnelCapacity.
     * 
     */
    public byte getPersonnelCapacity() {
        return personnelCapacity;
    }

    /**
     * Define el valor de la propiedad personnelCapacity.
     * 
     */
    public void setPersonnelCapacity(byte value) {
        this.personnelCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad bulkFuelCapacity.
     * 
     */
    public float getBulkFuelCapacity() {
        return bulkFuelCapacity;
    }

    /**
     * Define el valor de la propiedad bulkFuelCapacity.
     * 
     */
    public void setBulkFuelCapacity(float value) {
        this.bulkFuelCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad payloadCapacity.
     * 
     */
    public float getPayloadCapacity() {
        return payloadCapacity;
    }

    /**
     * Define el valor de la propiedad payloadCapacity.
     * 
     */
    public void setPayloadCapacity(float value) {
        this.payloadCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad takeCoverMod.
     * 
     */
    public float getTakeCoverMod() {
        return takeCoverMod;
    }

    /**
     * Define el valor de la propiedad takeCoverMod.
     * 
     */
    public void setTakeCoverMod(float value) {
        this.takeCoverMod = value;
    }

    /**
     * Obtiene el valor de la propiedad hasTurret.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasTurret() {
        return hasTurret;
    }

    /**
     * Define el valor de la propiedad hasTurret.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasTurret(String value) {
        this.hasTurret = value;
    }

    /**
     * Obtiene el valor de la propiedad hasOpenTop.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasOpenTop() {
        return hasOpenTop;
    }

    /**
     * Define el valor de la propiedad hasOpenTop.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasOpenTop(String value) {
        this.hasOpenTop = value;
    }

    /**
     * Obtiene el valor de la propiedad battleWeight.
     * 
     */
    public float getBattleWeight() {
        return battleWeight;
    }

    /**
     * Define el valor de la propiedad battleWeight.
     * 
     */
    public void setBattleWeight(float value) {
        this.battleWeight = value;
    }

    /**
     * Obtiene el valor de la propiedad armour.
     * 
     * @return
     *     possible object is
     *     {@link Armor }
     *     
     */
    public Armor getArmour() {
        return armour;
    }

    /**
     * Define el valor de la propiedad armour.
     * 
     * @param value
     *     allowed object is
     *     {@link Armor }
     *     
     */
    public void setArmour(Armor value) {
        this.armour = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public short getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(short value) {
        this.id = value;
    }

}
