
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
 *         &lt;element name="crew" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="reliability" type="{}Proportion"/>
 *         &lt;element name="armaments" type="{}ArmamentList"/>
 *         &lt;element name="type" type="{}VehicleType"/>
 *         &lt;element name="fuel-capacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="speed" type="{}VehicleSpeeds"/>
 *         &lt;element name="fuel-consumption" type="{}FuelConsumption"/>
 *         &lt;element name="ronsonability" type="{}Proportion"/>
 *         &lt;element name="max-gradient" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="max-fording-depth" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="max-trench-width" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="towing-capacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="personnel-capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="bulk-fuel-capacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="payload-capacity" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="take-cover-mod" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="has-turret" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="has-open-top" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="battle-weight" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="armour" type="{}Armor"/>
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
    protected int crew;
    protected double reliability;
    @XmlElement(required = true)
    protected ArmamentList armaments;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected VehicleType type;
    @XmlElement(name = "fuel-capacity")
    protected double fuelCapacity;
    @XmlElement(required = true)
    protected VehicleSpeeds speed;
    @XmlElement(name = "fuel-consumption", required = true)
    protected FuelConsumption fuelConsumption;
    protected double ronsonability;
    @XmlElement(name = "max-gradient")
    protected int maxGradient;
    @XmlElement(name = "max-fording-depth")
    protected int maxFordingDepth;
    @XmlElement(name = "max-trench-width")
    protected int maxTrenchWidth;
    @XmlElement(name = "towing-capacity")
    protected double towingCapacity;
    @XmlElement(name = "personnel-capacity")
    protected int personnelCapacity;
    @XmlElement(name = "bulk-fuel-capacity")
    protected double bulkFuelCapacity;
    @XmlElement(name = "payload-capacity")
    protected double payloadCapacity;
    @XmlElement(name = "take-cover-mod")
    protected double takeCoverMod;
    @XmlElement(name = "has-turret", required = true)
    protected String hasTurret;
    @XmlElement(name = "has-open-top", required = true)
    protected String hasOpenTop;
    @XmlElement(name = "battle-weight")
    protected double battleWeight;
    @XmlElement(required = true)
    protected Armor armour;
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
     *     {@link ArmamentList }
     *     
     */
    public ArmamentList getArmaments() {
        return armaments;
    }

    /**
     * Define el valor de la propiedad armaments.
     * 
     * @param value
     *     allowed object is
     *     {@link ArmamentList }
     *     
     */
    public void setArmaments(ArmamentList value) {
        this.armaments = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     * @return
     *     possible object is
     *     {@link VehicleType }
     *     
     */
    public VehicleType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link VehicleType }
     *     
     */
    public void setType(VehicleType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad fuelCapacity.
     * 
     */
    public double getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Define el valor de la propiedad fuelCapacity.
     * 
     */
    public void setFuelCapacity(double value) {
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
     *     {@link FuelConsumption }
     *     
     */
    public FuelConsumption getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Define el valor de la propiedad fuelConsumption.
     * 
     * @param value
     *     allowed object is
     *     {@link FuelConsumption }
     *     
     */
    public void setFuelConsumption(FuelConsumption value) {
        this.fuelConsumption = value;
    }

    /**
     * Obtiene el valor de la propiedad ronsonability.
     * 
     */
    public double getRonsonability() {
        return ronsonability;
    }

    /**
     * Define el valor de la propiedad ronsonability.
     * 
     */
    public void setRonsonability(double value) {
        this.ronsonability = value;
    }

    /**
     * Obtiene el valor de la propiedad maxGradient.
     * 
     */
    public int getMaxGradient() {
        return maxGradient;
    }

    /**
     * Define el valor de la propiedad maxGradient.
     * 
     */
    public void setMaxGradient(int value) {
        this.maxGradient = value;
    }

    /**
     * Obtiene el valor de la propiedad maxFordingDepth.
     * 
     */
    public int getMaxFordingDepth() {
        return maxFordingDepth;
    }

    /**
     * Define el valor de la propiedad maxFordingDepth.
     * 
     */
    public void setMaxFordingDepth(int value) {
        this.maxFordingDepth = value;
    }

    /**
     * Obtiene el valor de la propiedad maxTrenchWidth.
     * 
     */
    public int getMaxTrenchWidth() {
        return maxTrenchWidth;
    }

    /**
     * Define el valor de la propiedad maxTrenchWidth.
     * 
     */
    public void setMaxTrenchWidth(int value) {
        this.maxTrenchWidth = value;
    }

    /**
     * Obtiene el valor de la propiedad towingCapacity.
     * 
     */
    public double getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * Define el valor de la propiedad towingCapacity.
     * 
     */
    public void setTowingCapacity(double value) {
        this.towingCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad personnelCapacity.
     * 
     */
    public int getPersonnelCapacity() {
        return personnelCapacity;
    }

    /**
     * Define el valor de la propiedad personnelCapacity.
     * 
     */
    public void setPersonnelCapacity(int value) {
        this.personnelCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad bulkFuelCapacity.
     * 
     */
    public double getBulkFuelCapacity() {
        return bulkFuelCapacity;
    }

    /**
     * Define el valor de la propiedad bulkFuelCapacity.
     * 
     */
    public void setBulkFuelCapacity(double value) {
        this.bulkFuelCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad payloadCapacity.
     * 
     */
    public double getPayloadCapacity() {
        return payloadCapacity;
    }

    /**
     * Define el valor de la propiedad payloadCapacity.
     * 
     */
    public void setPayloadCapacity(double value) {
        this.payloadCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad takeCoverMod.
     * 
     */
    public double getTakeCoverMod() {
        return takeCoverMod;
    }

    /**
     * Define el valor de la propiedad takeCoverMod.
     * 
     */
    public void setTakeCoverMod(double value) {
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
    public double getBattleWeight() {
        return battleWeight;
    }

    /**
     * Define el valor de la propiedad battleWeight.
     * 
     */
    public void setBattleWeight(double value) {
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
