package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by Mario on 29/10/2014.
 */
public class ForceModel implements ElementModel, PojoJFXModel<Force> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<IconModel> icon = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceType> type = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSubtype> subType = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSize> size = new SimpleObjectProperty<ForceSize>();
    private final ObjectProperty<CombatClass> combatClass = new SimpleObjectProperty<CombatClass>();
    private final ObjectProperty<TargetClass> targetClass = new SimpleObjectProperty<TargetClass>();
    private final IntegerProperty infantryValue = new SimpleIntegerProperty();
    private final IntegerProperty reconValue = new SimpleIntegerProperty();
    private final IntegerProperty engineeringValue = new SimpleIntegerProperty();
    private final ObjectProperty<MoveType> moveType = new SimpleObjectProperty<MoveType>();
    private final IntegerProperty persQty = new SimpleIntegerProperty();
    private final IntegerProperty staffCapacity = new SimpleIntegerProperty();
    private final DoubleProperty basicsQty = new SimpleDoubleProperty();
    private final DoubleProperty basicsConsumptionRateModifier = new SimpleDoubleProperty();
    private final IntegerProperty commanderRank = new SimpleIntegerProperty();
    private final DoubleProperty fuelQty = new SimpleDoubleProperty();
    private final DoubleProperty fuelLoad = new SimpleDoubleProperty();
    private final DoubleProperty maxSpeed = new SimpleDoubleProperty();
    private final DoubleProperty normalSpeed = new SimpleDoubleProperty();

    private final ObjectProperty<XMLGregorianCalendar> deployed = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> dugIn = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> entrenched = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final ObjectProperty<XMLGregorianCalendar> fortified = new SimpleObjectProperty<XMLGregorianCalendar>();
    private final StringProperty readyToFireDuration = new SimpleStringProperty();
    private final StringProperty readyToBombardDuration = new SimpleStringProperty();
    private final ObservableList<EquipmentModel> equipmentList = FXCollections.observableArrayList();
    private final ObservableList<AmmoQtyModel> ammoList = FXCollections.observableArrayList();
    private final BooleanProperty canBombard = new SimpleBooleanProperty();

    public ForceModel(Force force) {
        setPojo(force);
    }

    /**
     * NOTES
     * <p>
     * the xsd defines ammoList as an objet of type AmmmoList, which is a list of AmmoQty,
     * but the content of AmmoQty looks the same of AmmoLoad, so it seems a duplication
     * Have a look, but I think we can use a single model for both elements, the AmmoLoadModel
     * However, a conversion would be needed in the pojo methods
     * <p>
     * EquipmentModel and ArmamentModel look the same, they have the same attributes, but semantically there
     * is a difference: Armament refers only to weapons, while equipment may refer to weapons as well as vehicles
     */

    @Override
    public Force getPojo() {
        Force force = new Force();
        force.setId(id.get());
        force.setName(name.get());
        force.setDescription(description.get());
        force.setIcon(icon.get().getPojo());
        force.setType(type.get());
        force.setSubType(subType.get());
        force.setSize(size.get());
        force.setCombatClass(combatClass.get());
        force.setTargetClass(targetClass.get());
        force.setInfantryValue(infantryValue.get());
        force.setReconValue(reconValue.get());
        force.setEngineeringValue(engineeringValue.get());
        force.setMoveType(moveType.get());
        force.setPersQty(persQty.get());
        force.setMoveType(moveType.get());
        force.setStaffCapacity(staffCapacity.get());
        force.setBasicsQty(basicsQty.get());
        force.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier.get());
        force.setCommanderRank(commanderRank.get());
        force.setFuelQty(fuelQty.get());
        force.setFuelLoad(fuelLoad.get());
        SpeedData speedData = new SpeedData();
        speedData.setMax(maxSpeed.get());
        speedData.setNormal(normalSpeed.get());
        force.setSpeed(speedData);
        DeploymentDuration deploymentDuration = new DeploymentDuration();
        deploymentDuration.setDeployed(deployed.get());
        deploymentDuration.setDugIn(dugIn.get());
        deploymentDuration.setEntrenched(entrenched.get());
        deploymentDuration.setFortified(fortified.get());
        force.setDeploymentDuration(deploymentDuration);
        force.setReadyToFireDuration(readyToFireDuration.get());
        force.setReadyToBombardDuration(readyToBombardDuration.get());
        equipmentList.stream().map(EquipmentModel::getPojo).forEach(e -> force.getEquipmentList().getEquipment().add(e));
        ammoList.stream().map(AmmoQtyModel::getPojo).forEach(a -> force.getAmmoList().getAmmo().add(a));
        force.setCanBombard(PojoJFXModel.booleanToYesNo(canBombard.get()));
        return force;
    }

    @Override
    public void setPojo(Force pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        icon.set(new IconModel(pojo.getIcon()));
        type.set(pojo.getType());
        subType.set(pojo.getSubType());
        size.set(pojo.getSize());
        combatClass.set(pojo.getCombatClass());
        targetClass.set(pojo.getTargetClass());
        infantryValue.set(pojo.getInfantryValue());
        reconValue.set(pojo.getReconValue());
        engineeringValue.set(pojo.getEngineeringValue());
        moveType.set(pojo.getMoveType());
        persQty.set(pojo.getPersQty());
        staffCapacity.set(pojo.getStaffCapacity());
        basicsQty.set(pojo.getBasicsQty());
        basicsConsumptionRateModifier.set(pojo.getBasicsConsumptionRateModifier());
        commanderRank.set(pojo.getCommanderRank());
        fuelQty.set(pojo.getFuelQty());
        fuelLoad.set(pojo.getFuelLoad());
        maxSpeed.set(pojo.getSpeed().getMax());
        normalSpeed.set(pojo.getSpeed().getNormal());
        deployed.set(pojo.getDeploymentDuration().getDeployed());
        dugIn.set(pojo.getDeploymentDuration().getDugIn());
        entrenched.set(pojo.getDeploymentDuration().getEntrenched());
        fortified.set(pojo.getDeploymentDuration().getFortified());
        readyToBombardDuration.set(pojo.getReadyToBombardDuration());
        readyToFireDuration.set(pojo.getReadyToFireDuration());
        pojo.getEquipmentList().getEquipment().stream().map(EquipmentModel::new).forEach(equipmentModel -> equipmentList.add(equipmentModel));
        pojo.getAmmoList().getAmmo().stream().map(AmmoQtyModel::new).forEach(ammoQtyModel -> ammoList.add(ammoQtyModel));
        canBombard.set(PojoJFXModel.yesNoToBoolean(pojo.getCanBombard()));
    }

    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public IconModel getIcon() {
        return icon.get();
    }

    public void setIcon(IconModel icon) {
        this.icon.set(icon);
    }

    public ObjectProperty<IconModel> iconProperty() {
        return icon;
    }

    public ForceType getType() {
        return type.get();
    }

    public void setType(ForceType type) {
        this.type.set(type);
    }

    public ObjectProperty<ForceType> typeProperty() {
        return type;
    }

    public ForceSubtype getSubType() {
        return subType.get();
    }

    public void setSubType(ForceSubtype subType) {
        this.subType.set(subType);
    }

    public ObjectProperty<ForceSubtype> subTypeProperty() {
        return subType;
    }

    public ForceSize getSize() {
        return size.get();
    }

    public void setSize(ForceSize size) {
        this.size.set(size);
    }

    public ObjectProperty<ForceSize> sizeProperty() {
        return size;
    }

    public CombatClass getCombatClass() {
        return combatClass.get();
    }

    public void setCombatClass(CombatClass combatClass) {
        this.combatClass.set(combatClass);
    }

    public ObjectProperty<CombatClass> combatClassProperty() {
        return combatClass;
    }

    public TargetClass getTargetClass() {
        return targetClass.get();
    }

    public void setTargetClass(TargetClass targetClass) {
        this.targetClass.set(targetClass);
    }

    public ObjectProperty<TargetClass> targetClassProperty() {
        return targetClass;
    }

    public int getInfantryValue() {
        return infantryValue.get();
    }

    public void setInfantryValue(int infantryValue) {
        this.infantryValue.set(infantryValue);
    }

    public IntegerProperty infantryValueProperty() {
        return infantryValue;
    }

    public int getReconValue() {
        return reconValue.get();
    }

    public void setReconValue(int reconValue) {
        this.reconValue.set(reconValue);
    }

    public IntegerProperty reconValueProperty() {
        return reconValue;
    }

    public int getEngineeringValue() {
        return engineeringValue.get();
    }

    public void setEngineeringValue(int engineeringValue) {
        this.engineeringValue.set(engineeringValue);
    }

    public IntegerProperty engineeringValueProperty() {
        return engineeringValue;
    }

    public MoveType getMoveType() {
        return moveType.get();
    }

    public void setMoveType(MoveType moveType) {
        this.moveType.set(moveType);
    }

    public ObjectProperty<MoveType> moveTypeProperty() {
        return moveType;
    }

    public int getPersQty() {
        return persQty.get();
    }

    public void setPersQty(int persQty) {
        this.persQty.set(persQty);
    }

    public IntegerProperty persQtyProperty() {
        return persQty;
    }

    public int getStaffCapacity() {
        return staffCapacity.get();
    }

    public void setStaffCapacity(int staffCapacity) {
        this.staffCapacity.set(staffCapacity);
    }

    public IntegerProperty staffCapacityProperty() {
        return staffCapacity;
    }

    public double getBasicsQty() {
        return basicsQty.get();
    }

    public void setBasicsQty(double basicsQty) {
        this.basicsQty.set(basicsQty);
    }

    public DoubleProperty basicsQtyProperty() {
        return basicsQty;
    }

    public double getBasicsConsumptionRateModifier() {
        return basicsConsumptionRateModifier.get();
    }

    public void setBasicsConsumptionRateModifier(double basicsConsumptionRateModifier) {
        this.basicsConsumptionRateModifier.set(basicsConsumptionRateModifier);
    }

    public DoubleProperty basicsConsumptionRateModifierProperty() {
        return basicsConsumptionRateModifier;
    }

    public int getCommanderRank() {
        return commanderRank.get();
    }

    public void setCommanderRank(int commanderRank) {
        this.commanderRank.set(commanderRank);
    }

    public IntegerProperty commanderRankProperty() {
        return commanderRank;
    }

    public double getFuelQty() {
        return fuelQty.get();
    }

    public void setFuelQty(double fuelQty) {
        this.fuelQty.set(fuelQty);
    }

    public DoubleProperty fuelQtyProperty() {
        return fuelQty;
    }

    public double getFuelLoad() {
        return fuelLoad.get();
    }

    public void setFuelLoad(double fuelLoad) {
        this.fuelLoad.set(fuelLoad);
    }

    public DoubleProperty fuelLoadProperty() {
        return fuelLoad;
    }

    public double getMaxSpeed() {
        return maxSpeed.get();
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed.set(maxSpeed);
    }

    public DoubleProperty maxSpeedProperty() {
        return maxSpeed;
    }

    public double getNormalSpeed() {
        return normalSpeed.get();
    }

    public void setNormalSpeed(double normalSpeed) {
        this.normalSpeed.set(normalSpeed);
    }

    public DoubleProperty normalSpeedProperty() {
        return normalSpeed;
    }

    public XMLGregorianCalendar getDeployed() {
        return deployed.get();
    }

    public void setDeployed(XMLGregorianCalendar deployed) {
        this.deployed.set(deployed);
    }

    public ObjectProperty<XMLGregorianCalendar> deployedProperty() {
        return deployed;
    }

    public XMLGregorianCalendar getDugIn() {
        return dugIn.get();
    }

    public void setDugIn(XMLGregorianCalendar dugIn) {
        this.dugIn.set(dugIn);
    }

    public ObjectProperty<XMLGregorianCalendar> dugInProperty() {
        return dugIn;
    }

    public XMLGregorianCalendar getEntrenched() {
        return entrenched.get();
    }

    public void setEntrenched(XMLGregorianCalendar entrenched) {
        this.entrenched.set(entrenched);
    }

    public ObjectProperty<XMLGregorianCalendar> entrenchedProperty() {
        return entrenched;
    }

    public XMLGregorianCalendar getFortified() {
        return fortified.get();
    }

    public void setFortified(XMLGregorianCalendar fortified) {
        this.fortified.set(fortified);
    }

    public ObjectProperty<XMLGregorianCalendar> fortifiedProperty() {
        return fortified;
    }

    public String getReadyToFireDuration() {
        return readyToFireDuration.get();
    }

    public void setReadyToFireDuration(String readyToFireDuration) {
        this.readyToFireDuration.set(readyToFireDuration);
    }

    public StringProperty readyToFireDurationProperty() {
        return readyToFireDuration;
    }

    public String getReadyToBombardDuration() {
        return readyToBombardDuration.get();
    }

    public void setReadyToBombardDuration(String readyToBombardDuration) {
        this.readyToBombardDuration.set(readyToBombardDuration);
    }

    public StringProperty readyToBombardDurationProperty() {
        return readyToBombardDuration;
    }

    public ObservableList<EquipmentModel> getEquipmentList() {
        return equipmentList;
    }

    public ObservableList<AmmoQtyModel> getAmmoList() {
        return ammoList;
    }

    public boolean getCanBombard() {
        return canBombard.get();
    }

    public void setCanBombard(boolean canBombard) {
        this.canBombard.set(canBombard);
    }

    public BooleanProperty canBombardProperty() {
        return canBombard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForceModel)) return false;

        ForceModel that = (ForceModel) o;

        if (ammoList != null ? !ammoList.equals(that.ammoList) : that.ammoList != null) return false;
        if (basicsConsumptionRateModifier != null ? !basicsConsumptionRateModifier.equals(that.basicsConsumptionRateModifier) : that.basicsConsumptionRateModifier != null)
            return false;
        if (basicsQty != null ? !basicsQty.equals(that.basicsQty) : that.basicsQty != null) return false;
        if (canBombard != null ? !canBombard.equals(that.canBombard) : that.canBombard != null) return false;
        if (combatClass != null ? !combatClass.equals(that.combatClass) : that.combatClass != null) return false;
        if (commanderRank != null ? !commanderRank.equals(that.commanderRank) : that.commanderRank != null)
            return false;
        if (deployed != null ? !deployed.equals(that.deployed) : that.deployed != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (dugIn != null ? !dugIn.equals(that.dugIn) : that.dugIn != null) return false;
        if (engineeringValue != null ? !engineeringValue.equals(that.engineeringValue) : that.engineeringValue != null)
            return false;
        if (entrenched != null ? !entrenched.equals(that.entrenched) : that.entrenched != null) return false;
        if (equipmentList != null ? !equipmentList.equals(that.equipmentList) : that.equipmentList != null)
            return false;
        if (fortified != null ? !fortified.equals(that.fortified) : that.fortified != null) return false;
        if (fuelLoad != null ? !fuelLoad.equals(that.fuelLoad) : that.fuelLoad != null) return false;
        if (fuelQty != null ? !fuelQty.equals(that.fuelQty) : that.fuelQty != null) return false;
        if (icon != null ? !icon.equals(that.icon) : that.icon != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (infantryValue != null ? !infantryValue.equals(that.infantryValue) : that.infantryValue != null)
            return false;
        if (maxSpeed != null ? !maxSpeed.equals(that.maxSpeed) : that.maxSpeed != null) return false;
        if (moveType != null ? !moveType.equals(that.moveType) : that.moveType != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (normalSpeed != null ? !normalSpeed.equals(that.normalSpeed) : that.normalSpeed != null) return false;
        if (persQty != null ? !persQty.equals(that.persQty) : that.persQty != null) return false;
        if (readyToBombardDuration != null ? !readyToBombardDuration.equals(that.readyToBombardDuration) : that.readyToBombardDuration != null)
            return false;
        if (readyToFireDuration != null ? !readyToFireDuration.equals(that.readyToFireDuration) : that.readyToFireDuration != null)
            return false;
        if (reconValue != null ? !reconValue.equals(that.reconValue) : that.reconValue != null) return false;
        if (size != null ? !size.equals(that.size) : that.size != null) return false;
        if (staffCapacity != null ? !staffCapacity.equals(that.staffCapacity) : that.staffCapacity != null)
            return false;
        if (subType != null ? !subType.equals(that.subType) : that.subType != null) return false;
        if (targetClass != null ? !targetClass.equals(that.targetClass) : that.targetClass != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (subType != null ? subType.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (combatClass != null ? combatClass.hashCode() : 0);
        result = 31 * result + (targetClass != null ? targetClass.hashCode() : 0);
        result = 31 * result + (infantryValue != null ? infantryValue.hashCode() : 0);
        result = 31 * result + (reconValue != null ? reconValue.hashCode() : 0);
        result = 31 * result + (engineeringValue != null ? engineeringValue.hashCode() : 0);
        result = 31 * result + (moveType != null ? moveType.hashCode() : 0);
        result = 31 * result + (persQty != null ? persQty.hashCode() : 0);
        result = 31 * result + (staffCapacity != null ? staffCapacity.hashCode() : 0);
        result = 31 * result + (basicsQty != null ? basicsQty.hashCode() : 0);
        result = 31 * result + (basicsConsumptionRateModifier != null ? basicsConsumptionRateModifier.hashCode() : 0);
        result = 31 * result + (commanderRank != null ? commanderRank.hashCode() : 0);
        result = 31 * result + (fuelQty != null ? fuelQty.hashCode() : 0);
        result = 31 * result + (fuelLoad != null ? fuelLoad.hashCode() : 0);
        result = 31 * result + (maxSpeed != null ? maxSpeed.hashCode() : 0);
        result = 31 * result + (normalSpeed != null ? normalSpeed.hashCode() : 0);
        result = 31 * result + (deployed != null ? deployed.hashCode() : 0);
        result = 31 * result + (dugIn != null ? dugIn.hashCode() : 0);
        result = 31 * result + (entrenched != null ? entrenched.hashCode() : 0);
        result = 31 * result + (fortified != null ? fortified.hashCode() : 0);
        result = 31 * result + (readyToFireDuration != null ? readyToFireDuration.hashCode() : 0);
        result = 31 * result + (readyToBombardDuration != null ? readyToBombardDuration.hashCode() : 0);
        result = 31 * result + (equipmentList != null ? equipmentList.hashCode() : 0);
        result = 31 * result + (ammoList != null ? ammoList.hashCode() : 0);
        result = 31 * result + (canBombard != null ? canBombard.hashCode() : 0);
        return result;
    }
}
