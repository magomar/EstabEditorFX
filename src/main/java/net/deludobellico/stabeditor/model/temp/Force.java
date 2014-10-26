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
import net.deludobellico.stabeditor.model.SpeedDataModel;
import net.deludobellico.stabeditor.model.SpeedDataModel;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para Force complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
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
 *         &lt;element name="basics-qty" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="basics-consumption-rate-modifier" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="commander-rank" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="fuel-qty" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="fuel-load" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
 * 
 * 
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
    protected ForceType type;
    @XmlElement(name = "sub-type", required = true)
    protected ForceSubtype subType;
    @XmlElement(required = true)
    protected ForceSize size;
    @XmlElement(name = "combat-class", required = true)
    protected CombatClass combatClass;
    @XmlElement(name = "target-class", required = true)
    protected TargetClass targetClass;
    @XmlElement(name = "infantry-value")
    protected int infantryValue;
    @XmlElement(name = "recon-value")
    protected int reconValue;
    @XmlElement(name = "engineering-value")
    protected int engineeringValue;
    @XmlElement(name = "move-type", required = true)
    protected MoveType moveType;
    @XmlElement(name = "pers-qty")
    protected int persQty;
    @XmlElement(name = "staff-capacity")
    protected int staffCapacity;
    @XmlElement(name = "basics-qty")
    protected float basicsQty;
    @XmlElement(name = "basics-consumption-rate-modifier")
    protected float basicsConsumptionRateModifier;
    @XmlElement(name = "commander-rank")
    protected int commanderRank;
    @XmlElement(name = "fuel-qty")
    protected float fuelQty;
    @XmlElement(name = "fuel-load")
    protected float fuelLoad;
    @XmlElement(required = true)
    protected SpeedDataModel speed;
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
    protected YesNo canBombard;
    @XmlAttribute(name = "id", required = true)
    protected int id;
    private final transient StringProperty nameProxy = new SimpleStringProperty();
    private final transient StringProperty descriptionProxy = new SimpleStringProperty();
    private final transient ObjectProperty<Icon> iconProxy = new SimpleObjectProperty<Icon>();
    private final transient ObjectProperty<ForceType> typeProxy = new SimpleObjectProperty<ForceType>();
    private final transient ObjectProperty<ForceSubtype> subTypeProxy = new SimpleObjectProperty<ForceSubtype>();
    private final transient ObjectProperty<ForceSize> sizeProxy = new SimpleObjectProperty<ForceSize>();
    private final transient ObjectProperty<CombatClass> combatClassProxy = new SimpleObjectProperty<CombatClass>();
    private final transient ObjectProperty<TargetClass> targetClassProxy = new SimpleObjectProperty<TargetClass>();
    private final transient IntegerProperty infantryValueProxy = new SimpleIntegerProperty();
    private final transient IntegerProperty reconValueProxy = new SimpleIntegerProperty();
    private final transient IntegerProperty engineeringValueProxy = new SimpleIntegerProperty();
    private final transient ObjectProperty<MoveType> moveTypeProxy = new SimpleObjectProperty<MoveType>();
    private final transient IntegerProperty persQtyProxy = new SimpleIntegerProperty();
    private final transient IntegerProperty staffCapacityProxy = new SimpleIntegerProperty();
    private final transient FloatProperty basicsQtyProxy = new SimpleFloatProperty();
    private final transient FloatProperty basicsConsumptionRateModifierProxy = new SimpleFloatProperty();
    private final transient IntegerProperty commanderRankProxy = new SimpleIntegerProperty();
    private final transient FloatProperty fuelQtyProxy = new SimpleFloatProperty();
    private final transient FloatProperty fuelLoadProxy = new SimpleFloatProperty();
    private final transient ObjectProperty<SpeedDataModel> speedProxy = new SimpleObjectProperty<SpeedDataModel>();
    private final transient ObjectProperty<DeploymentDuration> deploymentDurationProxy = new SimpleObjectProperty<DeploymentDuration>();
    private final transient StringProperty readyToFireDurationProxy = new SimpleStringProperty();
    private final transient StringProperty readyToBombardDurationProxy = new SimpleStringProperty();
    private final transient ObjectProperty<EquipmentList> equipmentListProxy = new SimpleObjectProperty<EquipmentList>();
    private final transient ObjectProperty<AmmoList> ammoListProxy = new SimpleObjectProperty<AmmoList>();
    private final transient ObjectProperty<YesNo> canBombardProxy = new SimpleObjectProperty<YesNo>();
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
     * Define el valor de la propiedad icon.
     * 
     * @param value
     *     allowed object is
     *     {@link Icon }
     *     
     */
    public void setIcon(Icon value) {
        this.icon = value;
        this.iconProxy.set(value);
    }

    /**
     * Define el valor de la propiedad type.
     * 
     * @param value
     *     allowed object is
     *     {@link ForceType }
     *     
     */
    public void setType(ForceType value) {
        this.type = value;
        this.typeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad subType.
     * 
     * @param value
     *     allowed object is
     *     {@link ForceSubtype }
     *     
     */
    public void setSubType(ForceSubtype value) {
        this.subType = value;
        this.subTypeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad size.
     * 
     * @param value
     *     allowed object is
     *     {@link ForceSize }
     *     
     */
    public void setSize(ForceSize value) {
        this.size = value;
        this.sizeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad combatClass.
     * 
     * @param value
     *     allowed object is
     *     {@link CombatClass }
     *     
     */
    public void setCombatClass(CombatClass value) {
        this.combatClass = value;
        this.combatClassProxy.set(value);
    }

    /**
     * Define el valor de la propiedad targetClass.
     * 
     * @param value
     *     allowed object is
     *     {@link TargetClass }
     *     
     */
    public void setTargetClass(TargetClass value) {
        this.targetClass = value;
        this.targetClassProxy.set(value);
    }

    /**
     * Define el valor de la propiedad infantryValue.
     * 
     */
    public void setInfantryValue(int value) {
        this.infantryValue = value;
        this.infantryValueProxy.set(value);
    }

    /**
     * Define el valor de la propiedad reconValue.
     * 
     */
    public void setReconValue(int value) {
        this.reconValue = value;
        this.reconValueProxy.set(value);
    }

    /**
     * Define el valor de la propiedad engineeringValue.
     * 
     */
    public void setEngineeringValue(int value) {
        this.engineeringValue = value;
        this.engineeringValueProxy.set(value);
    }

    /**
     * Define el valor de la propiedad moveType.
     * 
     * @param value
     *     allowed object is
     *     {@link MoveType }
     *     
     */
    public void setMoveType(MoveType value) {
        this.moveType = value;
        this.moveTypeProxy.set(value);
    }

    /**
     * Define el valor de la propiedad persQty.
     * 
     */
    public void setPersQty(int value) {
        this.persQty = value;
        this.persQtyProxy.set(value);
    }

    /**
     * Define el valor de la propiedad staffCapacity.
     * 
     */
    public void setStaffCapacity(int value) {
        this.staffCapacity = value;
        this.staffCapacityProxy.set(value);
    }

    /**
     * Define el valor de la propiedad basicsQty.
     * 
     */
    public void setBasicsQty(float value) {
        this.basicsQty = value;
        this.basicsQtyProxy.set(value);
    }

    /**
     * Define el valor de la propiedad basicsConsumptionRateModifier.
     * 
     */
    public void setBasicsConsumptionRateModifier(float value) {
        this.basicsConsumptionRateModifier = value;
        this.basicsConsumptionRateModifierProxy.set(value);
    }

    /**
     * Define el valor de la propiedad commanderRank.
     * 
     */
    public void setCommanderRank(int value) {
        this.commanderRank = value;
        this.commanderRankProxy.set(value);
    }

    /**
     * Define el valor de la propiedad fuelQty.
     * 
     */
    public void setFuelQty(float value) {
        this.fuelQty = value;
        this.fuelQtyProxy.set(value);
    }

    /**
     * Define el valor de la propiedad fuelLoad.
     * 
     */
    public void setFuelLoad(float value) {
        this.fuelLoad = value;
        this.fuelLoadProxy.set(value);
    }

    /**
     * Define el valor de la propiedad speed.
     * 
     * @param value
     *     allowed object is
     *     {@link net.deludobellico.stabeditor.model.SpeedDataModel }
     *     
     */
    public void setSpeed(SpeedDataModel value) {
        this.speed = value;
        this.speedProxy.set(value);
    }

    /**
     * Define el valor de la propiedad deploymentDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link DeploymentDuration }
     *     
     */
    public void setDeploymentDuration(DeploymentDuration value) {
        this.deploymentDuration = value;
        this.deploymentDurationProxy.set(value);
    }

    /**
     * Define el valor de la propiedad readyToFireDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyToFireDuration(String value) {
        this.readyToFireDuration = value;
        this.readyToFireDurationProxy.set(value);
    }

    /**
     * Define el valor de la propiedad readyToBombardDuration.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReadyToBombardDuration(String value) {
        this.readyToBombardDuration = value;
        this.readyToBombardDurationProxy.set(value);
    }

    /**
     * Define el valor de la propiedad equipmentList.
     * 
     * @param value
     *     allowed object is
     *     {@link EquipmentList }
     *     
     */
    public void setEquipmentList(EquipmentList value) {
        this.equipmentList = value;
        this.equipmentListProxy.set(value);
    }

    /**
     * Define el valor de la propiedad ammoList.
     * 
     * @param value
     *     allowed object is
     *     {@link AmmoList }
     *     
     */
    public void setAmmoList(AmmoList value) {
        this.ammoList = value;
        this.ammoListProxy.set(value);
    }

    /**
     * Define el valor de la propiedad canBombard.
     * 
     * @param value
     *     allowed object is
     *     {@link YesNo }
     *     
     */
    public void setCanBombard(YesNo value) {
        this.canBombard = value;
        this.canBombardProxy.set(value);
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
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
     * Obtiene el valor de la propiedad icon.
     * 
     */
    public Icon getIcon() {
        if (this.iconProxy.get() == null) {
            this.iconProxy.set(icon);
        }
        return this.iconProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<Icon> iconProperty() {
        return this.iconProxy;
    }

    /**
     * Obtiene el valor de la propiedad type.
     * 
     */
    public ForceType getType() {
        if (this.typeProxy.get() == null) {
            this.typeProxy.set(type);
        }
        return this.typeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<ForceType> typeProperty() {
        return this.typeProxy;
    }

    /**
     * Obtiene el valor de la propiedad subType.
     * 
     */
    public ForceSubtype getSubType() {
        if (this.subTypeProxy.get() == null) {
            this.subTypeProxy.set(subType);
        }
        return this.subTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<ForceSubtype> subTypeProperty() {
        return this.subTypeProxy;
    }

    /**
     * Obtiene el valor de la propiedad size.
     * 
     */
    public ForceSize getSize() {
        if (this.sizeProxy.get() == null) {
            this.sizeProxy.set(size);
        }
        return this.sizeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<ForceSize> sizeProperty() {
        return this.sizeProxy;
    }

    /**
     * Obtiene el valor de la propiedad combatClass.
     * 
     */
    public CombatClass getCombatClass() {
        if (this.combatClassProxy.get() == null) {
            this.combatClassProxy.set(combatClass);
        }
        return this.combatClassProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<CombatClass> combatClassProperty() {
        return this.combatClassProxy;
    }

    /**
     * Obtiene el valor de la propiedad targetClass.
     * 
     */
    public TargetClass getTargetClass() {
        if (this.targetClassProxy.get() == null) {
            this.targetClassProxy.set(targetClass);
        }
        return this.targetClassProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<TargetClass> targetClassProperty() {
        return this.targetClassProxy;
    }

    /**
     * Obtiene el valor de la propiedad infantryValue.
     * 
     */
    public int getInfantryValue() {
        return this.infantryValueProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty infantryValueProperty() {
        return this.infantryValueProxy;
    }

    /**
     * Obtiene el valor de la propiedad reconValue.
     * 
     */
    public int getReconValue() {
        return this.reconValueProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty reconValueProperty() {
        return this.reconValueProxy;
    }

    /**
     * Obtiene el valor de la propiedad engineeringValue.
     * 
     */
    public int getEngineeringValue() {
        return this.engineeringValueProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty engineeringValueProperty() {
        return this.engineeringValueProxy;
    }

    /**
     * Obtiene el valor de la propiedad moveType.
     * 
     */
    public MoveType getMoveType() {
        if (this.moveTypeProxy.get() == null) {
            this.moveTypeProxy.set(moveType);
        }
        return this.moveTypeProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<MoveType> moveTypeProperty() {
        return this.moveTypeProxy;
    }

    /**
     * Obtiene el valor de la propiedad persQty.
     * 
     */
    public int getPersQty() {
        return this.persQtyProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty persQtyProperty() {
        return this.persQtyProxy;
    }

    /**
     * Obtiene el valor de la propiedad staffCapacity.
     * 
     */
    public int getStaffCapacity() {
        return this.staffCapacityProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty staffCapacityProperty() {
        return this.staffCapacityProxy;
    }

    /**
     * Obtiene el valor de la propiedad basicsQty.
     * 
     */
    public float getBasicsQty() {
        return this.basicsQtyProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty basicsQtyProperty() {
        return this.basicsQtyProxy;
    }

    /**
     * Obtiene el valor de la propiedad basicsConsumptionRateModifier.
     * 
     */
    public float getBasicsConsumptionRateModifier() {
        return this.basicsConsumptionRateModifierProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty basicsConsumptionRateModifierProperty() {
        return this.basicsConsumptionRateModifierProxy;
    }

    /**
     * Obtiene el valor de la propiedad commanderRank.
     * 
     */
    public int getCommanderRank() {
        return this.commanderRankProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public IntegerProperty commanderRankProperty() {
        return this.commanderRankProxy;
    }

    /**
     * Obtiene el valor de la propiedad fuelQty.
     * 
     */
    public float getFuelQty() {
        return this.fuelQtyProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty fuelQtyProperty() {
        return this.fuelQtyProxy;
    }

    /**
     * Obtiene el valor de la propiedad fuelLoad.
     * 
     */
    public float getFuelLoad() {
        return this.fuelLoadProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public FloatProperty fuelLoadProperty() {
        return this.fuelLoadProxy;
    }

    /**
     * Obtiene el valor de la propiedad speed.
     * 
     */
    public SpeedDataModel getSpeed() {
        if (this.speedProxy.get() == null) {
            this.speedProxy.set(speed);
        }
        return this.speedProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<SpeedDataModel> speedProperty() {
        return this.speedProxy;
    }

    /**
     * Obtiene el valor de la propiedad deploymentDuration.
     * 
     */
    public DeploymentDuration getDeploymentDuration() {
        if (this.deploymentDurationProxy.get() == null) {
            this.deploymentDurationProxy.set(deploymentDuration);
        }
        return this.deploymentDurationProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<DeploymentDuration> deploymentDurationProperty() {
        return this.deploymentDurationProxy;
    }

    /**
     * Obtiene el valor de la propiedad readyToFireDuration.
     * 
     */
    public String getReadyToFireDuration() {
        if (this.readyToFireDurationProxy.get() == null) {
            this.readyToFireDurationProxy.set(readyToFireDuration);
        }
        return this.readyToFireDurationProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty readyToFireDurationProperty() {
        return this.readyToFireDurationProxy;
    }

    /**
     * Obtiene el valor de la propiedad readyToBombardDuration.
     * 
     */
    public String getReadyToBombardDuration() {
        if (this.readyToBombardDurationProxy.get() == null) {
            this.readyToBombardDurationProxy.set(readyToBombardDuration);
        }
        return this.readyToBombardDurationProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public StringProperty readyToBombardDurationProperty() {
        return this.readyToBombardDurationProxy;
    }

    /**
     * Obtiene el valor de la propiedad equipmentList.
     * 
     */
    public EquipmentList getEquipmentList() {
        if (this.equipmentListProxy.get() == null) {
            this.equipmentListProxy.set(equipmentList);
        }
        return this.equipmentListProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<EquipmentList> equipmentListProperty() {
        return this.equipmentListProxy;
    }

    /**
     * Obtiene el valor de la propiedad ammoList.
     * 
     */
    public AmmoList getAmmoList() {
        if (this.ammoListProxy.get() == null) {
            this.ammoListProxy.set(ammoList);
        }
        return this.ammoListProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<AmmoList> ammoListProperty() {
        return this.ammoListProxy;
    }

    /**
     * Obtiene el valor de la propiedad canBombard.
     * 
     */
    public YesNo getCanBombard() {
        if (this.canBombardProxy.get() == null) {
            this.canBombardProxy.set(canBombard);
        }
        return this.canBombardProxy.get();
    }

    /**
     * Generated by FXBeanPropertyXJCPlugin.
     * 
     */
    public ObjectProperty<YesNo> canBombardProperty() {
        return this.canBombardProxy;
    }

    /**
     * Obtiene el valor de la propiedad id.
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
