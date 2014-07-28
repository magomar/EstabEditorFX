
package net.deludobellico.cotools.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for Vehicle complex type.
 * <p/>
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p/>
 * <pre>
 * &lt;complexType name="Vehicle">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="picture" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    protected String picture;
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
     * Gets the value of the name property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the description property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the picture property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPicture() {
        return picture;
    }

    /**
     * Sets the value of the picture property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPicture(String value) {
        this.picture = value;
    }

    /**
     * Gets the value of the pictureFilename property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPictureFilename() {
        return pictureFilename;
    }

    /**
     * Sets the value of the pictureFilename property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPictureFilename(String value) {
        this.pictureFilename = value;
    }

    /**
     * Gets the value of the size property.
     *
     * @return possible object is
     * {@link VehicleSize }
     */
    public VehicleSize getSize() {
        return size;
    }

    /**
     * Sets the value of the size property.
     *
     * @param value allowed object is
     *              {@link VehicleSize }
     */
    public void setSize(VehicleSize value) {
        this.size = value;
    }

    /**
     * Gets the value of the crew property.
     */
    public byte getCrew() {
        return crew;
    }

    /**
     * Sets the value of the crew property.
     */
    public void setCrew(byte value) {
        this.crew = value;
    }

    /**
     * Gets the value of the reliability property.
     */
    public float getReliability() {
        return reliability;
    }

    /**
     * Sets the value of the reliability property.
     */
    public void setReliability(float value) {
        this.reliability = value;
    }

    /**
     * Gets the value of the armaments property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getArmaments() {
        return armaments;
    }

    /**
     * Sets the value of the armaments property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setArmaments(String value) {
        this.armaments = value;
    }

    /**
     * Gets the value of the type property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the fuelCapacity property.
     */
    public float getFuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets the value of the fuelCapacity property.
     */
    public void setFuelCapacity(float value) {
        this.fuelCapacity = value;
    }

    /**
     * Gets the value of the speed property.
     *
     * @return possible object is
     * {@link VehicleSpeeds }
     */
    public VehicleSpeeds getSpeed() {
        return speed;
    }

    /**
     * Sets the value of the speed property.
     *
     * @param value allowed object is
     *              {@link VehicleSpeeds }
     */
    public void setSpeed(VehicleSpeeds value) {
        this.speed = value;
    }

    /**
     * Gets the value of the fuelConsumption property.
     *
     * @return possible object is
     * {@link SpeedData }
     */
    public SpeedData getFuelConsumption() {
        return fuelConsumption;
    }

    /**
     * Sets the value of the fuelConsumption property.
     *
     * @param value allowed object is
     *              {@link SpeedData }
     */
    public void setFuelConsumption(SpeedData value) {
        this.fuelConsumption = value;
    }

    /**
     * Gets the value of the ronsonability property.
     */
    public float getRonsonability() {
        return ronsonability;
    }

    /**
     * Sets the value of the ronsonability property.
     */
    public void setRonsonability(float value) {
        this.ronsonability = value;
    }

    /**
     * Gets the value of the maxGradient property.
     */
    public byte getMaxGradient() {
        return maxGradient;
    }

    /**
     * Sets the value of the maxGradient property.
     */
    public void setMaxGradient(byte value) {
        this.maxGradient = value;
    }

    /**
     * Gets the value of the maxFordingDepth property.
     */
    public byte getMaxFordingDepth() {
        return maxFordingDepth;
    }

    /**
     * Sets the value of the maxFordingDepth property.
     */
    public void setMaxFordingDepth(byte value) {
        this.maxFordingDepth = value;
    }

    /**
     * Gets the value of the maxTrenchWidth property.
     */
    public byte getMaxTrenchWidth() {
        return maxTrenchWidth;
    }

    /**
     * Sets the value of the maxTrenchWidth property.
     */
    public void setMaxTrenchWidth(byte value) {
        this.maxTrenchWidth = value;
    }

    /**
     * Gets the value of the towingCapacity property.
     */
    public float getTowingCapacity() {
        return towingCapacity;
    }

    /**
     * Sets the value of the towingCapacity property.
     */
    public void setTowingCapacity(float value) {
        this.towingCapacity = value;
    }

    /**
     * Gets the value of the personnelCapacity property.
     */
    public byte getPersonnelCapacity() {
        return personnelCapacity;
    }

    /**
     * Sets the value of the personnelCapacity property.
     */
    public void setPersonnelCapacity(byte value) {
        this.personnelCapacity = value;
    }

    /**
     * Gets the value of the bulkFuelCapacity property.
     */
    public float getBulkFuelCapacity() {
        return bulkFuelCapacity;
    }

    /**
     * Sets the value of the bulkFuelCapacity property.
     */
    public void setBulkFuelCapacity(float value) {
        this.bulkFuelCapacity = value;
    }

    /**
     * Gets the value of the payloadCapacity property.
     */
    public float getPayloadCapacity() {
        return payloadCapacity;
    }

    /**
     * Sets the value of the payloadCapacity property.
     */
    public void setPayloadCapacity(float value) {
        this.payloadCapacity = value;
    }

    /**
     * Gets the value of the takeCoverMod property.
     */
    public float getTakeCoverMod() {
        return takeCoverMod;
    }

    /**
     * Sets the value of the takeCoverMod property.
     */
    public void setTakeCoverMod(float value) {
        this.takeCoverMod = value;
    }

    /**
     * Gets the value of the hasTurret property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHasTurret() {
        return hasTurret;
    }

    /**
     * Sets the value of the hasTurret property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHasTurret(String value) {
        this.hasTurret = value;
    }

    /**
     * Gets the value of the hasOpenTop property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getHasOpenTop() {
        return hasOpenTop;
    }

    /**
     * Sets the value of the hasOpenTop property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setHasOpenTop(String value) {
        this.hasOpenTop = value;
    }

    /**
     * Gets the value of the battleWeight property.
     */
    public float getBattleWeight() {
        return battleWeight;
    }

    /**
     * Sets the value of the battleWeight property.
     */
    public void setBattleWeight(float value) {
        this.battleWeight = value;
    }

    /**
     * Gets the value of the armour property.
     *
     * @return possible object is
     * {@link Armor }
     */
    public Armor getArmour() {
        return armour;
    }

    /**
     * Sets the value of the armour property.
     *
     * @param value allowed object is
     *              {@link Armor }
     */
    public void setArmour(Armor value) {
        this.armour = value;
    }

    /**
     * Gets the value of the id property.
     */
    public short getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     */
    public void setId(short value) {
        this.id = value;
    }

}
