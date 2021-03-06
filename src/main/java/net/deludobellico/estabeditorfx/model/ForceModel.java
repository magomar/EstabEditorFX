package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.estabeditorfx.util.DateTimeUtils;
import net.deludobellico.estabeditorfx.data.jaxb.*;

import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Model wrapper for the {@code Force} class
 *
 * @author Mario
 * @author Heine
 */
public class ForceModel extends AbstractElementModel<ForceModel> implements PojoAdapter<Force> {

    // General
    private final ObjectProperty<ForceType> type = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSubtype> subType = new SimpleObjectProperty<>();
    private final ObjectProperty<CombatClass> combatClass = new SimpleObjectProperty<>();
    private final ObjectProperty<TargetClass> targetClass = new SimpleObjectProperty<>();
    private final ObjectProperty<MoveType> moveType = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceSize> size = new SimpleObjectProperty<>();
    private final IntegerProperty commanderRank = new SimpleIntegerProperty();

    private final DoubleProperty maxSpeed = new SimpleDoubleProperty();
    private final DoubleProperty normalSpeed = new SimpleDoubleProperty();

    private final IntegerProperty personnel = new SimpleIntegerProperty();
    private final IntegerProperty staffCapacity = new SimpleIntegerProperty();
    private final IntegerProperty infantryValue = new SimpleIntegerProperty();
    private final IntegerProperty reconValue = new SimpleIntegerProperty();
    private final IntegerProperty engineeringValue = new SimpleIntegerProperty();
    private final BooleanProperty canBombard = new SimpleBooleanProperty();

    private final DoubleProperty basicsQty = new SimpleDoubleProperty();
    private final DoubleProperty basicsConsumptionRateModifier = new SimpleDoubleProperty();

    private final ObjectProperty<LocalTime> deployed = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalTime> dugIn = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalTime> entrenched = new SimpleObjectProperty<>();
    private final ObjectProperty<LocalTime> fortified = new SimpleObjectProperty<>();

    private final ObjectProperty<LocalTime> readyToFireDuration = new SimpleObjectProperty();
    private final ObjectProperty<LocalTime> readyToBombardDuration = new SimpleObjectProperty();

    private final DoubleProperty fuelQty = new SimpleDoubleProperty();
    private final DoubleProperty fuelLoad = new SimpleDoubleProperty();

    private final ObservableList<EquipmentQtyModel> equipmentList = FXCollections.observableArrayList();
    private final ObservableList<AmmoQtyModel> ammoList = FXCollections.observableArrayList();

    private final ObjectProperty<IconModel> icon = new SimpleObjectProperty<>();

    private final ObjectProperty<ServiceModel> service = new SimpleObjectProperty<>();

    private final ObservableList<ForceQtyModel> forceComposition = FXCollections.observableArrayList();

    public ForceModel(Force force) {
        initialize(force);
    }

    public ForceModel() {

    }

    /**
     * NOTES
     * <p>
     * the xsd defines ammoList as an object of type AmmoList, which is a list of AmmoQty,
     * but the content of AmmoQty looks the same of AmmoLoad, so it seems a duplication
     * Have a look, but I think we can use a single model for both elements, the AmmoLoadModel
     * However, a conversion would be needed in the pojo methods
     * <p>
     * EquipmentQtyModel and ArmamentModel look the same, they have the same attributes, but semantically there
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
        force.setPersQty(personnel.get());
        force.setMoveType(moveType.get());
        force.setStaffCapacity(staffCapacity.get());
        force.setBasicsQty(basicsQty.get());
        force.setBasicsConsumptionRateModifier(basicsConsumptionRateModifier.get());
        force.setCommanderRank(commanderRank.get());
        force.setFuelQty(fuelQty.get());
        force.setFuelLoad(fuelLoad.get());
        Speed speed = new Speed();
        speed.setMax(maxSpeed.get());
        speed.setNormal(normalSpeed.get());
        force.setSpeed(speed);
        DeploymentDuration deploymentDuration = new DeploymentDuration();
        deploymentDuration.setDeployed(DateTimeUtils.format(deployed.get()));
        deploymentDuration.setDugIn(DateTimeUtils.format(dugIn.get()));
        deploymentDuration.setEntrenched(DateTimeUtils.format(entrenched.get()));
        deploymentDuration.setFortified(DateTimeUtils.format(fortified.get()));
        force.setDeploymentDuration(deploymentDuration);
        force.setReadyToFireDuration(DateTimeUtils.format(readyToFireDuration.get()));
        force.setReadyToBombardDuration(DateTimeUtils.format(readyToBombardDuration.get()));
        force.setEquipmentList(new EquipmentList());
        force.setAmmoList(new AmmoList());
        equipmentList.stream().map(EquipmentQtyModel::getPojo).forEach(force.getEquipmentList().getEquipment()::add);
        ammoList.stream().map(AmmoQtyModel::getPojo).forEach(force.getAmmoList().getAmmo()::add);
        force.setCanBombard(PojoAdapter.booleanToYesNo(canBombard.get()));
        force.getFlags().addAll(flags);
        if (forceComposition.size() > 0) {
            if (null == force.getForceComposition()) force.setForceComposition(new ForceComposition());
            forceComposition.stream().map(ForceQtyModel::getPojo).forEach(force.getForceComposition().getSubforce()::add);
        }
        return force;
    }

    @Override
    public void initialize(Force pojo) {
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
        personnel.set(pojo.getPersQty());
        staffCapacity.set(pojo.getStaffCapacity());
        basicsQty.set(pojo.getBasicsQty());
        basicsConsumptionRateModifier.set(pojo.getBasicsConsumptionRateModifier());
        commanderRank.set(pojo.getCommanderRank());
        fuelQty.set(pojo.getFuelQty());
        fuelLoad.set(pojo.getFuelLoad());
        maxSpeed.set(pojo.getSpeed().getMax());
        normalSpeed.set(pojo.getSpeed().getNormal());
        deployed.set(DateTimeUtils.parseTime(pojo.getDeploymentDuration().getDeployed()));
        dugIn.set(DateTimeUtils.parseTime(pojo.getDeploymentDuration().getDugIn()));
        entrenched.set(DateTimeUtils.parseTime(pojo.getDeploymentDuration().getEntrenched()));
        fortified.set(DateTimeUtils.parseTime(pojo.getDeploymentDuration().getFortified()));
        readyToBombardDuration.set(DateTimeUtils.parseTime(pojo.getReadyToBombardDuration()));
        readyToFireDuration.set(DateTimeUtils.parseTime(pojo.getReadyToFireDuration()));
        pojo.getEquipmentList().getEquipment().stream().map(EquipmentQtyModel::new).forEach(equipmentList::add);
        pojo.getAmmoList().getAmmo().stream().map(AmmoQtyModel::new).forEach(ammoList::add);
        flags.addAll(pojo.getFlags());
        canBombard.set(PojoAdapter.yesNoToBoolean(pojo.getCanBombard()));
        if (null != pojo.getForceComposition())
            pojo.getForceComposition().getSubforce().stream().map(ForceQtyModel::new).forEach(forceComposition::add);
    }

    public void setColorsFromService() {
        IconModel i = icon.get();
        ServiceModel s = service.get();
        i.setSymbolColor(s.getSymbolColor());
        i.setBackgroundColor(s.getBackgroundColor());
        i.setBackgroundDarkColor(s.getBackgroundDarkColor());
        i.setBackgroundLightColor(s.getBackgroundLightColor());
        i.setDesignationColor(s.getDesignationColor());
    }

    public boolean usesServiceColors() {
        IconModel i = icon.get();
        ServiceModel s = service.get();
        return i.getSymbolColor().equals(s.getSymbolColor())
                && i.getBackgroundColor().equals(s.getBackgroundColor())
                && i.getBackgroundDarkColor().equals(s.getBackgroundDarkColor())
                && i.getBackgroundLightColor().equals(s.getBackgroundLightColor())
                && i.getDesignationColor().equals(s.getDesignationColor());
    }

    @Override
    public void cloneToMap(int newId, Map<Integer, ForceModel> map) {
        Force copy = getPojo();
        copy.setId(newId);
        copy.setName(ElementModelFactory.formatName(copy.getName(), copy.getId()));
        copy.getFlags().add(Flag.NEW);
        ForceModel copyModel = new ForceModel(copy);
        copyModel.setService(getService());
        getService().getForce().add(copyModel);
        map.put(copy.getId(), copyModel);
    }

    @Override
    public void hardCopyToMap(Map<Integer, ForceModel> map) {
        Force copy = getPojo();
        copy.getFlags().add((Flag.COPY));
        map.put(copy.getId(), new ForceModel(copy));
    }

    @Override
    public void shallowCopyToMap(Map<Integer, ForceModel> map) {
        map.put(getId(), this);
    }

    @Override
    public void insertInToCollection(Collection<ForceModel> collection) {
        collection.add(this);
    }

    @Override
    public ForceModel createNewInMap(Map<Integer, ForceModel> map) {
        ForceModel newElement = ElementModelFactory.createForce(service.get());
        map.put(newElement.getId(), newElement);
        return newElement;
    }

    @Override
    public void removeFromMap(Map<Integer, ForceModel> map) {
        map.remove(getId());
    }


    @Override
    public Class getPojoClass() {
        return Force.class;
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

    public int getPersonnel() {
        return personnel.get();
    }

    public void setPersonnel(int personnel) {
        this.personnel.set(personnel);
    }

    public IntegerProperty personnelProperty() {
        return personnel;
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

    public LocalTime getDeployed() {
        return deployed.get();
    }

    public void setDeployed(LocalTime deployed) {
        this.deployed.set(deployed);
    }

    public ObjectProperty<LocalTime> deployedProperty() {
        return deployed;
    }

    public LocalTime getDugIn() {
        return dugIn.get();
    }

    public void setDugIn(LocalTime dugIn) {
        this.dugIn.set(dugIn);
    }

    public ObjectProperty<LocalTime> dugInProperty() {
        return dugIn;
    }

    public LocalTime getEntrenched() {
        return entrenched.get();
    }

    public void setEntrenched(LocalTime entrenched) {
        this.entrenched.set(entrenched);
    }

    public ObjectProperty<LocalTime> entrenchedProperty() {
        return entrenched;
    }

    public LocalTime getFortified() {
        return fortified.get();
    }

    public void setFortified(LocalTime fortified) {
        this.fortified.set(fortified);
    }

    public ObjectProperty<LocalTime> fortifiedProperty() {
        return fortified;
    }

    public LocalTime getReadyToFireDuration() {
        return readyToFireDuration.get();
    }

    public void setReadyToFireDuration(LocalTime readyToFireDuration) {
        this.readyToFireDuration.set(readyToFireDuration);
    }

    public ObjectProperty<LocalTime> readyToFireDurationProperty() {
        return readyToFireDuration;
    }

    public LocalTime getReadyToBombardDuration() {
        return readyToBombardDuration.get();
    }

    public void setReadyToBombardDuration(LocalTime readyToBombardDuration) {
        this.readyToBombardDuration.set(readyToBombardDuration);
    }

    public ObjectProperty<LocalTime> readyToBombardDurationProperty() {
        return readyToBombardDuration;
    }

    public ObservableList<EquipmentQtyModel> getEquipmentList() {
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

    public void setService(ServiceModel service) {
        this.service.setValue(service);
    }

    public ServiceModel getService() {
        return service.get();
    }

    public ObjectProperty<ServiceModel> serviceProperty() {
        return service;
    }

    public ObservableList<ForceQtyModel> getForceComposition() {
        return forceComposition;
    }

    @Override
    public boolean compareTo(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForceModel that = (ForceModel) o;


        if (that.getAmmoList().size() != ammoList.size() || !ammoList.containsAll(that.getAmmoList()))
            return false;

        if (getBasicsConsumptionRateModifier() != that.getBasicsConsumptionRateModifier()) return false;
        if (getBasicsQty() != that.getBasicsQty()) return false;
        if (getCanBombard() != that.getCanBombard()) return false;
        if (getCombatClass() != null ? !getCombatClass().equals(that.getCombatClass()) : that.getCombatClass() != null)
            return false;
        if (getCommanderRank() != that.getCommanderRank()) return false;
        if (getDeployed() != null ? !getDeployed().equals(that.getDeployed()) : that.getDeployed() != null)
            return false;
        if (getDescription() != null ? !getDescription().equals(that.getDescription()) : that.getDescription() != null)
            return false;
        if (getDugIn() != null ? !getDugIn().equals(that.getDugIn()) : that.getDugIn() != null) return false;
        if (getEngineeringValue() != that.getEngineeringValue()) return false;
        if (getEntrenched() != null ? !getEntrenched().equals(that.getEntrenched()) : that.getEntrenched() != null)
            return false;
        if (that.getEquipmentList().size() != equipmentList.size() || !equipmentList.containsAll(that.getEquipmentList()))
            return false;
        if (getFortified() != null ? !getFortified().equals(that.getFortified()) : that.getFortified() != null)
            return false;
        if (getFuelLoad() != that.getFuelLoad()) return false;
        if (getFuelQty() != that.getFuelQty()) return false;
        if (getIcon() != null ? !getIcon().equals(that.getIcon()) : that.getIcon() != null) return false;
//        if (getId() != (that.getId())) return false;
        if (getInfantryValue() != (that.getInfantryValue())) return false;
        if (getMaxSpeed() != (that.getMaxSpeed())) return false;
        if (getMoveType() != null ? !getMoveType().equals(that.getMoveType()) : that.getMoveType() != null)
            return false;
        if (getName() != null ? !getName().equals(that.getName()) : that.getName() != null) return false;
        if (getNormalSpeed() != (that.getNormalSpeed())) return false;
        if (getPersonnel() != (that.getPersonnel())) return false;
        if (getReadyToBombardDuration() != null ? !getReadyToBombardDuration().equals(that.getReadyToBombardDuration()) : that.getReadyToBombardDuration() != null)
            return false;
        if (getReadyToFireDuration() != null ? !getReadyToFireDuration().equals(that.getReadyToFireDuration()) : that.getReadyToFireDuration() != null)
            return false;
        if (getReconValue() != (that.getReconValue())) return false;
        if (getSize() != null ? !getSize().equals(that.getSize()) : that.getSize() != null) return false;
        if (getStaffCapacity() != (that.getStaffCapacity())) return false;
        if (getSubType() != null ? !getSubType().equals(that.getSubType()) : that.getSubType() != null) return false;
        if (getTargetClass() != null ? !getTargetClass().equals(that.getTargetClass()) : that.getTargetClass() != null)
            return false;
        if (getType() != null ? !getType().equals(that.getType()) : that.getType() != null) return false;
        return true;
    }
}
