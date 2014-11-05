package net.deludobellico.commandops.estabeditor.data.jaxb;

import javax.xml.bind.annotation.*;


/**
 * <p>Clase Java para Force complex type.
 * <p>
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;complexType name="Force">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="icon" type="{}Icon"/>
 *         &lt;element name="type" type="{}ForceType"/>
 *         &lt;element name="sub-type" type="{}ForceSubtype"/>
 *         &lt;element name="size" type="{}ForceSize"/>
 *         &lt;element name="combat-class" type="{}CombatClass"/>
 *         &lt;element name="target-class" type="{}TargetClass"/>
 *         &lt;element name="infantry-value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="recon-value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="engineering-value" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="move-type" type="{}MoveType"/>
 *         &lt;element name="pers-qty" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="staff-capacity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="basics-qty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="basics-consumption-rate-modifier" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="commander-rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fuel-qty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fuel-load" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="speed" type="{}SpeedData"/>
 *         &lt;element name="deployment-duration" type="{}DeploymentDuration"/>
 *         &lt;element name="ready-to-fire-duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ready-to-bombard-duration" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="equipment-list" type="{}EquipmentList"/>
 *         &lt;element name="ammo-list" type="{}AmmoList"/>
 *         &lt;element name="can-bombard" type="{}YesNo"/>
 *       &lt;/sequence>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Force", propOrder = {
        "name",
        "description",
        "icon",
        "type",
        "subType",
        "size",
        "combatClass",
        "targetClass",
        "infantryValue",
        "reconValue",
        "engineeringValue",
        "moveType",
        "persQty",
        "staffCapacity",
        "basicsQty",
        "basicsConsumptionRateModifier",
        "commanderRank",
        "fuelQty",
        "fuelLoad",
        "speed",
        "deploymentDuration",
        "readyToFireDuration",
        "readyToBombardDuration",
        "equipmentList",
        "ammoList",
        "canBombard"
})
public class Force {

    @XmlElement(required = true)
    protected String name;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected Icon icon;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ForceType type;
    @XmlElement(name = "sub-type", required = true)
    @XmlSchemaType(name = "string")
    protected ForceSubtype subType;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ForceSize size;
    @XmlElement(name = "combat-class", required = true)
    @XmlSchemaType(name = "string")
    protected CombatClass combatClass;
    @XmlElement(name = "target-class", required = true)
    @XmlSchemaType(name = "string")
    protected TargetClass targetClass;
    @XmlElement(name = "infantry-value")
    protected int infantryValue;
    @XmlElement(name = "recon-value")
    protected int reconValue;
    @XmlElement(name = "engineering-value")
    protected int engineeringValue;
    @XmlElement(name = "move-type", required = true)
    @XmlSchemaType(name = "string")
    protected MoveType moveType;
    @XmlElement(name = "pers-qty")
    protected int persQty;
    @XmlElement(name = "staff-capacity")
    protected int staffCapacity;
    @XmlElement(name = "basics-qty")
    protected double basicsQty;
    @XmlElement(name = "basics-consumption-rate-modifier")
    protected double basicsConsumptionRateModifier;
    @XmlElement(name = "commander-rank")
    protected int commanderRank;
    @XmlElement(name = "fuel-qty")
    protected double fuelQty;
    @XmlElement(name = "fuel-load")
    protected double fuelLoad;
    @XmlElement(required = true)
    protected SpeedData speed;
    @XmlElement(name = "deployment-duration", required = true)
    protected DeploymentDuration deploymentDuration;
    @XmlElement(name = "ready-to-fire-duration", required = true)
    protected String readyToFireDuration;
    @XmlElement(name = "ready-to-bombard-duration", required = true)
    protected String readyToBombardDuration;
    @XmlElement(name = "equipment-list", required = true)
    protected EquipmentList equipmentList;
    @XmlElement(name = "ammo-list", required = true)
    protected AmmoList ammoList;
    @XmlElement(name = "can-bombard", required = true)
    @XmlSchemaType(name = "string")
    protected YesNo canBombard;
    @XmlAttribute(name = "id", required = true)
    protected int id;

    /**
     * Obtiene el valor de la propiedad name.
     *
     * @return possible object is
     * {@link String }
     */
    public String getName() {
        return name;
    }

    /**
     * Define el valor de la propiedad name.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Obtiene el valor de la propiedad description.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDescription() {
        return description;
    }

    /**
     * Define el valor de la propiedad description.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Obtiene el valor de la propiedad icon.
     *
     * @return possible object is
     * {@link Icon }
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Define el valor de la propiedad icon.
     *
     * @param value allowed object is
     *              {@link Icon }
     */
    public void setIcon(Icon value) {
        this.icon = value;
    }

    /**
     * Obtiene el valor de la propiedad type.
     *
     * @return possible object is
     * {@link ForceType }
     */
    public ForceType getType() {
        return type;
    }

    /**
     * Define el valor de la propiedad type.
     *
     * @param value allowed object is
     *              {@link ForceType }
     */
    public void setType(ForceType value) {
        this.type = value;
    }

    /**
     * Obtiene el valor de la propiedad subType.
     *
     * @return possible object is
     * {@link ForceSubtype }
     */
    public ForceSubtype getSubType() {
        return subType;
    }

    /**
     * Define el valor de la propiedad subType.
     *
     * @param value allowed object is
     *              {@link ForceSubtype }
     */
    public void setSubType(ForceSubtype value) {
        this.subType = value;
    }

    /**
     * Obtiene el valor de la propiedad size.
     *
     * @return possible object is
     * {@link ForceSize }
     */
    public ForceSize getSize() {
        return size;
    }

    /**
     * Define el valor de la propiedad size.
     *
     * @param value allowed object is
     *              {@link ForceSize }
     */
    public void setSize(ForceSize value) {
        this.size = value;
    }

    /**
     * Obtiene el valor de la propiedad combatClass.
     *
     * @return possible object is
     * {@link CombatClass }
     */
    public CombatClass getCombatClass() {
        return combatClass;
    }

    /**
     * Define el valor de la propiedad combatClass.
     *
     * @param value allowed object is
     *              {@link CombatClass }
     */
    public void setCombatClass(CombatClass value) {
        this.combatClass = value;
    }

    /**
     * Obtiene el valor de la propiedad targetClass.
     *
     * @return possible object is
     * {@link TargetClass }
     */
    public TargetClass getTargetClass() {
        return targetClass;
    }

    /**
     * Define el valor de la propiedad targetClass.
     *
     * @param value allowed object is
     *              {@link TargetClass }
     */
    public void setTargetClass(TargetClass value) {
        this.targetClass = value;
    }

    /**
     * Obtiene el valor de la propiedad infantryValue.
     */
    public int getInfantryValue() {
        return infantryValue;
    }

    /**
     * Define el valor de la propiedad infantryValue.
     */
    public void setInfantryValue(int value) {
        this.infantryValue = value;
    }

    /**
     * Obtiene el valor de la propiedad reconValue.
     */
    public int getReconValue() {
        return reconValue;
    }

    /**
     * Define el valor de la propiedad reconValue.
     */
    public void setReconValue(int value) {
        this.reconValue = value;
    }

    /**
     * Obtiene el valor de la propiedad engineeringValue.
     */
    public int getEngineeringValue() {
        return engineeringValue;
    }

    /**
     * Define el valor de la propiedad engineeringValue.
     */
    public void setEngineeringValue(int value) {
        this.engineeringValue = value;
    }

    /**
     * Obtiene el valor de la propiedad moveType.
     *
     * @return possible object is
     * {@link MoveType }
     */
    public MoveType getMoveType() {
        return moveType;
    }

    /**
     * Define el valor de la propiedad moveType.
     *
     * @param value allowed object is
     *              {@link MoveType }
     */
    public void setMoveType(MoveType value) {
        this.moveType = value;
    }

    /**
     * Obtiene el valor de la propiedad persQty.
     */
    public int getPersQty() {
        return persQty;
    }

    /**
     * Define el valor de la propiedad persQty.
     */
    public void setPersQty(int value) {
        this.persQty = value;
    }

    /**
     * Obtiene el valor de la propiedad staffCapacity.
     */
    public int getStaffCapacity() {
        return staffCapacity;
    }

    /**
     * Define el valor de la propiedad staffCapacity.
     */
    public void setStaffCapacity(int value) {
        this.staffCapacity = value;
    }

    /**
     * Obtiene el valor de la propiedad basicsQty.
     */
    public double getBasicsQty() {
        return basicsQty;
    }

    /**
     * Define el valor de la propiedad basicsQty.
     */
    public void setBasicsQty(double value) {
        this.basicsQty = value;
    }

    /**
     * Obtiene el valor de la propiedad basicsConsumptionRateModifier.
     */
    public double getBasicsConsumptionRateModifier() {
        return basicsConsumptionRateModifier;
    }

    /**
     * Define el valor de la propiedad basicsConsumptionRateModifier.
     */
    public void setBasicsConsumptionRateModifier(double value) {
        this.basicsConsumptionRateModifier = value;
    }

    /**
     * Obtiene el valor de la propiedad commanderRank.
     */
    public int getCommanderRank() {
        return commanderRank;
    }

    /**
     * Define el valor de la propiedad commanderRank.
     */
    public void setCommanderRank(int value) {
        this.commanderRank = value;
    }

    /**
     * Obtiene el valor de la propiedad fuelQty.
     */
    public double getFuelQty() {
        return fuelQty;
    }

    /**
     * Define el valor de la propiedad fuelQty.
     */
    public void setFuelQty(double value) {
        this.fuelQty = value;
    }

    /**
     * Obtiene el valor de la propiedad fuelLoad.
     */
    public double getFuelLoad() {
        return fuelLoad;
    }

    /**
     * Define el valor de la propiedad fuelLoad.
     */
    public void setFuelLoad(double value) {
        this.fuelLoad = value;
    }

    /**
     * Obtiene el valor de la propiedad speed.
     *
     * @return possible object is
     * {@link SpeedData }
     */
    public SpeedData getSpeed() {
        return speed;
    }

    /**
     * Define el valor de la propiedad speed.
     *
     * @param value allowed object is
     *              {@link SpeedData }
     */
    public void setSpeed(SpeedData value) {
        this.speed = value;
    }

    /**
     * Obtiene el valor de la propiedad deploymentDuration.
     *
     * @return possible object is
     * {@link DeploymentDuration }
     */
    public DeploymentDuration getDeploymentDuration() {
        return deploymentDuration;
    }

    /**
     * Define el valor de la propiedad deploymentDuration.
     *
     * @param value allowed object is
     *              {@link DeploymentDuration }
     */
    public void setDeploymentDuration(DeploymentDuration value) {
        this.deploymentDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad readyToFireDuration.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReadyToFireDuration() {
        return readyToFireDuration;
    }

    /**
     * Define el valor de la propiedad readyToFireDuration.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReadyToFireDuration(String value) {
        this.readyToFireDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad readyToBombardDuration.
     *
     * @return possible object is
     * {@link String }
     */
    public String getReadyToBombardDuration() {
        return readyToBombardDuration;
    }

    /**
     * Define el valor de la propiedad readyToBombardDuration.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setReadyToBombardDuration(String value) {
        this.readyToBombardDuration = value;
    }

    /**
     * Obtiene el valor de la propiedad equipmentList.
     *
     * @return possible object is
     * {@link EquipmentList }
     */
    public EquipmentList getEquipmentList() {
        return equipmentList;
    }

    /**
     * Define el valor de la propiedad equipmentList.
     *
     * @param value allowed object is
     *              {@link EquipmentList }
     */
    public void setEquipmentList(EquipmentList value) {
        this.equipmentList = value;
    }

    /**
     * Obtiene el valor de la propiedad ammoList.
     *
     * @return possible object is
     * {@link AmmoList }
     */
    public AmmoList getAmmoList() {
        return ammoList;
    }

    /**
     * Define el valor de la propiedad ammoList.
     *
     * @param value allowed object is
     *              {@link AmmoList }
     */
    public void setAmmoList(AmmoList value) {
        this.ammoList = value;
    }

    /**
     * Obtiene el valor de la propiedad canBombard.
     *
     * @return possible object is
     * {@link YesNo }
     */
    public YesNo getCanBombard() {
        return canBombard;
    }

    /**
     * Define el valor de la propiedad canBombard.
     *
     * @param value allowed object is
     *              {@link YesNo }
     */
    public void setCanBombard(YesNo value) {
        this.canBombard = value;
    }

    /**
     * Obtiene el valor de la propiedad id.
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     */
    public void setId(int value) {
        this.id = value;
    }

}
