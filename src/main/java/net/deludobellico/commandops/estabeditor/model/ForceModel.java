package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.util.JFXModelUtil;

import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Created by Mario on 29/10/2014.
 */
public class ForceModel implements ElementModel, PojoJFXModel<Force> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final ObjectProperty<IconModel> icon = new SimpleObjectProperty<>();
    private final ObjectProperty<ForceType> type = new SimpleObjectProperty<ForceType>();
    private final ObjectProperty<ForceSubtype> subType = new SimpleObjectProperty<ForceSubtype>();
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
        SpeedData sd = new SpeedData();
        sd.setMax(maxSpeed.get());
        sd.setNormal(normalSpeed.get());
        force.setSpeed(sd);
        DeploymentDuration dd = new DeploymentDuration();
        dd.setDeployed(deployed.get());
        dd.setDugIn(dugIn.get());
        dd.setEntrenched(entrenched.get());
        dd.setFortified(fortified.get());
        force.setDeploymentDuration(dd);
        force.setReadyToFireDuration(readyToFireDuration.get());
        force.setReadyToBombardDuration(readyToBombardDuration.get());
        equipmentList.stream().map(EquipmentModel::getPojo).forEach(e -> force.getEquipmentList().getEquipment().add(e));
        ammoList.stream().map(AmmoQtyModel::getPojo).forEach(a -> force.getAmmoList().getAmmo().add(a));
        force.setCanBombard(JFXModelUtil.booleanToYesNo(canBombard.get()));
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
        pojo.getEquipmentList().getEquipment().stream().map(EquipmentModel::new).forEach(e -> equipmentList.add(e));
        pojo.getAmmoList().getAmmo().stream().map(AmmoQtyModel::new).forEach(a -> ammoList.add(a));
        canBombard.set(JFXModelUtil.yesNoToBoolean(pojo.getCanBombard()));
    }

    public Integer getId() {
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
}
