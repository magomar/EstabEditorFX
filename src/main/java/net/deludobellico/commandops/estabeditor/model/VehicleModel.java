package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;

/**
 * Created by Mario on 26/10/2014.
 */
public class VehicleModel implements ElementModel, PojoJFXModel<Vehicle> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();
    /* */
    private final DoubleProperty width = new SimpleDoubleProperty();
    private final DoubleProperty height = new SimpleDoubleProperty();
    private final DoubleProperty length = new SimpleDoubleProperty();
    private final DoubleProperty weight = new SimpleDoubleProperty();
    /* end VehicleSize */
    private final IntegerProperty crew = new SimpleIntegerProperty();
    private final DoubleProperty reliability = new SimpleDoubleProperty();
    private final ObservableList<ArmamentModel> armaments = FXCollections.observableArrayList();
    private final ObjectProperty<VehicleType> type = new SimpleObjectProperty<>();
    private final DoubleProperty fuelCapacity = new SimpleDoubleProperty();
    private final DoubleProperty maxRoadSpeed = new SimpleDoubleProperty();
    private final DoubleProperty normalRoadSpeed = new SimpleDoubleProperty();
    private final DoubleProperty maxCrossCountrySpeed = new SimpleDoubleProperty();
    private final DoubleProperty normalCrossCountrySpeed = new SimpleDoubleProperty();
    private final DoubleProperty maxFuelConsumption = new SimpleDoubleProperty();
    private final DoubleProperty normalFuelConsumption = new SimpleDoubleProperty();
    // end VehicleSpeeds
    private final DoubleProperty ronsonability = new SimpleDoubleProperty();
    private final IntegerProperty maxGradient = new SimpleIntegerProperty();
    private final IntegerProperty maxFordingDepth = new SimpleIntegerProperty();
    private final IntegerProperty maxTrenchWidth = new SimpleIntegerProperty();
    private final DoubleProperty towingCapacity = new SimpleDoubleProperty();
    private final IntegerProperty personnelCapacity = new SimpleIntegerProperty();
    private final DoubleProperty bulkFuelCapacity = new SimpleDoubleProperty();
    private final DoubleProperty payloadCapacity = new SimpleDoubleProperty();
    private final DoubleProperty takeCoverMod = new SimpleDoubleProperty();
    private final BooleanProperty hasTurret = new SimpleBooleanProperty();
    private final BooleanProperty hasOpenTop = new SimpleBooleanProperty();
    private final DoubleProperty battleWeight = new SimpleDoubleProperty();
    private final DoubleProperty frontArmor = new SimpleDoubleProperty();
    private final DoubleProperty sideArmor = new SimpleDoubleProperty();
    private final DoubleProperty rearArmor = new SimpleDoubleProperty();
    private final DoubleProperty topArmor = new SimpleDoubleProperty();

    public VehicleModel(Vehicle vehicle) {
        setPojo(vehicle);
    }

    @Override
    public Vehicle getPojo() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id.get());
        vehicle.setName(name.get());
        vehicle.setDescription(description.get());
        Picture p = new Picture();
        p.setId(pictureId.get());
        vehicle.setPicture(p);
        VehicleSize vs = new VehicleSize();
        vs.setHeight(height.get());
        vs.setLength(length.get());
        vs.setWeight(weight.get());
        vs.setWidth(width.get());
        vehicle.setSize(vs);
        vehicle.setCrew(crew.get());
        vehicle.setReliability(reliability.get());
        vehicle.setArmaments(new ArmamentList());
        armaments.stream().map(ArmamentModel::getPojo).forEach(a -> vehicle.getArmaments().getArmament().add(a));
        vehicle.setType(type.get());
        vehicle.setFuelCapacity(fuelCapacity.get());
        SpeedData rs = new SpeedData();
        SpeedData cs = new SpeedData();
        rs.setMax(maxRoadSpeed.get());
        rs.setNormal(normalRoadSpeed.get());
        cs.setMax(maxCrossCountrySpeed.get());
        cs.setNormal(normalCrossCountrySpeed.get());
        VehicleSpeeds vss = new VehicleSpeeds();
        vss.setRoad(rs);
        vss.setCrossCountry(cs);
        vehicle.setSpeed(vss);
        FuelConsumption fc = new FuelConsumption();
        fc.setMax(maxFuelConsumption.get());
        fc.setNormal(normalFuelConsumption.get());
        vehicle.setFuelConsumption(fc);
        vehicle.setRonsonability(ronsonability.get());
        vehicle.setMaxGradient(maxGradient.get());
        vehicle.setMaxFordingDepth(maxFordingDepth.get());
        vehicle.setMaxTrenchWidth(maxTrenchWidth.get());
        vehicle.setTowingCapacity(towingCapacity.get());
        vehicle.setPersonnelCapacity(personnelCapacity.get());
        vehicle.setBulkFuelCapacity(bulkFuelCapacity.get());
        vehicle.setPayloadCapacity(payloadCapacity.get());
        vehicle.setTakeCoverMod(takeCoverMod.get());
        vehicle.setHasOpenTop(PojoJFXModel.booleanToYesNo(hasOpenTop.get()).value());
        vehicle.setHasTurret(PojoJFXModel.booleanToYesNo(hasTurret.get()).value());
        vehicle.setBattleWeight(battleWeight.get());
        Armor a = new Armor();
        a.setFront(frontArmor.get());
        a.setSide(sideArmor.get());
        a.setRear(rearArmor.get());
        a.setTop(topArmor.get());
        vehicle.setArmour(a);
        return vehicle;
    }

    @Override
    public void setPojo(Vehicle pojo) {
        id.set(pojo.getId());
        name.set(pojo.getName());
        description.set(pojo.getDescription());
        pictureId.set(pojo.getPicture().getId());
        height.set(pojo.getSize().getHeight());
        length.set(pojo.getSize().getLength());
        weight.set(pojo.getSize().getWeight());
        width.set(pojo.getSize().getWeight());
        crew.set(pojo.getCrew());
        reliability.set(pojo.getReliability());
        pojo.getArmaments().getArmament().stream().map(ArmamentModel::new).forEach(armamentModel -> armaments.add(armamentModel));
        type.set(pojo.getType());
        fuelCapacity.set(pojo.getFuelCapacity());
        maxCrossCountrySpeed.set(pojo.getSpeed().getCrossCountry().getMax());
        normalCrossCountrySpeed.set(pojo.getSpeed().getCrossCountry().getNormal());
        maxRoadSpeed.set(pojo.getSpeed().getRoad().getMax());
        normalRoadSpeed.set(pojo.getSpeed().getRoad().getNormal());
        maxFuelConsumption.set(pojo.getFuelConsumption().getMax());
        normalFuelConsumption.set(pojo.getFuelConsumption().getNormal());
        ronsonability.set(pojo.getRonsonability());
        maxGradient.set(pojo.getMaxGradient());
        maxFordingDepth.set(pojo.getMaxFordingDepth());
        maxTrenchWidth.set(pojo.getMaxTrenchWidth());
        towingCapacity.set(pojo.getTowingCapacity());
        bulkFuelCapacity.set(pojo.getBulkFuelCapacity());
        payloadCapacity.set(pojo.getPayloadCapacity());
        takeCoverMod.set(pojo.getTakeCoverMod());
        hasOpenTop.set(pojo.getHasOpenTop().equals(YesNo.YES.value()));
        hasTurret.set(pojo.getHasTurret().equals(YesNo.YES.value()));
        battleWeight.set(pojo.getBattleWeight());
        frontArmor.set(pojo.getArmour().getFront());
        sideArmor.set(pojo.getArmour().getSide());
        rearArmor.set(pojo.getArmour().getRear());
        topArmor.set(pojo.getArmour().getTop());
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

    public int getPictureId() {
        return pictureId.get();
    }

    public void setPictureId(int pictureId) {
        this.pictureId.set(pictureId);
    }

    public IntegerProperty pictureIdProperty() {
        return pictureId;
    }

    public String getPictureFilename() {
        return pictureFilename.get();
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename.set(pictureFilename);
    }

    public StringProperty pictureFilenameProperty() {
        return pictureFilename;
    }

    public double getWidth() {
        return width.get();
    }

    public void setWidth(double width) {
        this.width.set(width);
    }

    public DoubleProperty widthProperty() {
        return width;
    }

    public double getHeight() {
        return height.get();
    }

    public void setHeight(double height) {
        this.height.set(height);
    }

    public DoubleProperty heightProperty() {
        return height;
    }

    public double getLength() {
        return length.get();
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public DoubleProperty lengthProperty() {
        return length;
    }

    public double getWeight() {
        return weight.get();
    }

    public void setWeight(double weight) {
        this.weight.set(weight);
    }

    public DoubleProperty weightProperty() {
        return weight;
    }

    public int getCrew() {
        return crew.get();
    }

    public void setCrew(int crew) {
        this.crew.set(crew);
    }

    public IntegerProperty crewProperty() {
        return crew;
    }

    public double getReliability() {
        return reliability.get();
    }

    public void setReliability(double reliability) {
        this.reliability.set(reliability);
    }

    public DoubleProperty reliabilityProperty() {
        return reliability;
    }

    public ObservableList<ArmamentModel> getArmaments() {
        return armaments;
    }

    public VehicleType getType() {
        return type.get();
    }

    public void setType(VehicleType type) {
        this.type.set(type);
    }

    public ObjectProperty<VehicleType> typeProperty() {
        return type;
    }

    public double getFuelCapacity() {
        return fuelCapacity.get();
    }

    public void setFuelCapacity(double fuelCapacity) {
        this.fuelCapacity.set(fuelCapacity);
    }

    public DoubleProperty fuelCapacityProperty() {
        return fuelCapacity;
    }

    public double getMaxRoadSpeed() {
        return maxRoadSpeed.get();
    }

    public void setMaxRoadSpeed(double maxRoadSpeed) {
        this.maxRoadSpeed.set(maxRoadSpeed);
    }

    public DoubleProperty maxRoadSpeedProperty() {
        return maxRoadSpeed;
    }

    public double getNormalRoadSpeed() {
        return normalRoadSpeed.get();
    }

    public void setNormalRoadSpeed(double normalRoadSpeed) {
        this.normalRoadSpeed.set(normalRoadSpeed);
    }

    public DoubleProperty normalRoadSpeedProperty() {
        return normalRoadSpeed;
    }

    public double getMaxCrossCountrySpeed() {
        return maxCrossCountrySpeed.get();
    }

    public void setMaxCrossCountrySpeed(double maxCrossCountrySpeed) {
        this.maxCrossCountrySpeed.set(maxCrossCountrySpeed);
    }

    public DoubleProperty maxCrossCountrySpeedProperty() {
        return maxCrossCountrySpeed;
    }

    public double getNormalCrossCountrySpeed() {
        return normalCrossCountrySpeed.get();
    }

    public void setNormalCrossCountrySpeed(double normalCrossCountrySpeed) {
        this.normalCrossCountrySpeed.set(normalCrossCountrySpeed);
    }

    public DoubleProperty normalCrossCountrySpeedProperty() {
        return normalCrossCountrySpeed;
    }

    public double getMaxFuelConsumption() {
        return maxFuelConsumption.get();
    }

    public void setMaxFuelConsumption(double maxFuelConsumption) {
        this.maxFuelConsumption.set(maxFuelConsumption);
    }

    public DoubleProperty maxFuelConsumptionProperty() {
        return maxFuelConsumption;
    }

    public double getNormalFuelConsumption() {
        return normalFuelConsumption.get();
    }

    public void setNormalFuelConsumption(double normalFuelConsumption) {
        this.normalFuelConsumption.set(normalFuelConsumption);
    }

    public DoubleProperty normalFuelConsumptionProperty() {
        return normalFuelConsumption;
    }

    public double getRonsonability() {
        return ronsonability.get();
    }

    public void setRonsonability(double ronsonability) {
        this.ronsonability.set(ronsonability);
    }

    public DoubleProperty ronsonabilityProperty() {
        return ronsonability;
    }

    public int getMaxGradient() {
        return maxGradient.get();
    }

    public void setMaxGradient(int maxGradient) {
        this.maxGradient.set(maxGradient);
    }

    public IntegerProperty maxGradientProperty() {
        return maxGradient;
    }

    public int getMaxFordingDepth() {
        return maxFordingDepth.get();
    }

    public void setMaxFordingDepth(int maxFordingDepth) {
        this.maxFordingDepth.set(maxFordingDepth);
    }

    public IntegerProperty maxFordingDepthProperty() {
        return maxFordingDepth;
    }

    public int getMaxTrenchWidth() {
        return maxTrenchWidth.get();
    }

    public void setMaxTrenchWidth(int maxTrenchWidth) {
        this.maxTrenchWidth.set(maxTrenchWidth);
    }

    public IntegerProperty maxTrenchWidthProperty() {
        return maxTrenchWidth;
    }

    public double getTowingCapacity() {
        return towingCapacity.get();
    }

    public void setTowingCapacity(double towingCapacity) {
        this.towingCapacity.set(towingCapacity);
    }

    public DoubleProperty towingCapacityProperty() {
        return towingCapacity;
    }

    public int getPersonnelCapacity() {
        return personnelCapacity.get();
    }

    public void setPersonnelCapacity(int personnelCapacity) {
        this.personnelCapacity.set(personnelCapacity);
    }

    public IntegerProperty personnelCapacityProperty() {
        return personnelCapacity;
    }

    public double getBulkFuelCapacity() {
        return bulkFuelCapacity.get();
    }

    public void setBulkFuelCapacity(double bulkFuelCapacity) {
        this.bulkFuelCapacity.set(bulkFuelCapacity);
    }

    public DoubleProperty bulkFuelCapacityProperty() {
        return bulkFuelCapacity;
    }

    public double getPayloadCapacity() {
        return payloadCapacity.get();
    }

    public void setPayloadCapacity(double payloadCapacity) {
        this.payloadCapacity.set(payloadCapacity);
    }

    public DoubleProperty payloadCapacityProperty() {
        return payloadCapacity;
    }

    public double getTakeCoverMod() {
        return takeCoverMod.get();
    }

    public void setTakeCoverMod(double takeCoverMod) {
        this.takeCoverMod.set(takeCoverMod);
    }

    public DoubleProperty takeCoverModProperty() {
        return takeCoverMod;
    }

    public boolean getHasTurret() {
        return hasTurret.get();
    }

    public void setHasTurret(boolean hasTurret) {
        this.hasTurret.set(hasTurret);
    }

    public BooleanProperty hasTurretProperty() {
        return hasTurret;
    }

    public boolean getHasOpenTop() {
        return hasOpenTop.get();
    }

    public void setHasOpenTop(boolean hasOpenTop) {
        this.hasOpenTop.set(hasOpenTop);
    }

    public BooleanProperty hasOpenTopProperty() {
        return hasOpenTop;
    }

    public double getBattleWeight() {
        return battleWeight.get();
    }

    public void setBattleWeight(double battleWeight) {
        this.battleWeight.set(battleWeight);
    }

    public DoubleProperty battleWeightProperty() {
        return battleWeight;
    }

    public double getFrontArmor() {
        return frontArmor.get();
    }

    public void setFrontArmor(double frontArmor) {
        this.frontArmor.set(frontArmor);
    }

    public DoubleProperty frontArmorProperty() {
        return frontArmor;
    }

    public double getSideArmor() {
        return sideArmor.get();
    }

    public void setSideArmor(double sideArmor) {
        this.sideArmor.set(sideArmor);
    }

    public DoubleProperty sideArmorProperty() {
        return sideArmor;
    }

    public double getRearArmor() {
        return rearArmor.get();
    }

    public void setRearArmor(double rearArmor) {
        this.rearArmor.set(rearArmor);
    }

    public DoubleProperty rearArmorProperty() {
        return rearArmor;
    }

    public double getTopArmor() {
        return topArmor.get();
    }

    public void setTopArmor(double topArmor) {
        this.topArmor.set(topArmor);
    }

    public DoubleProperty topArmorProperty() {
        return topArmor;
    }

    @Override
    public String toString() {
        return name.get();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VehicleModel that = (VehicleModel) o;

        if (armaments != null ? !armaments.equals(that.armaments) : that.armaments != null) return false;
        if (battleWeight != null ? !battleWeight.equals(that.battleWeight) : that.battleWeight != null) return false;
        if (bulkFuelCapacity != null ? !bulkFuelCapacity.equals(that.bulkFuelCapacity) : that.bulkFuelCapacity != null)
            return false;
        if (crew != null ? !crew.equals(that.crew) : that.crew != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (frontArmor != null ? !frontArmor.equals(that.frontArmor) : that.frontArmor != null) return false;
        if (fuelCapacity != null ? !fuelCapacity.equals(that.fuelCapacity) : that.fuelCapacity != null) return false;
        if (hasOpenTop != null ? !hasOpenTop.equals(that.hasOpenTop) : that.hasOpenTop != null) return false;
        if (hasTurret != null ? !hasTurret.equals(that.hasTurret) : that.hasTurret != null) return false;
        if (height != null ? !height.equals(that.height) : that.height != null) return false;
        if (length != null ? !length.equals(that.length) : that.length != null) return false;
        if (maxCrossCountrySpeed != null ? !maxCrossCountrySpeed.equals(that.maxCrossCountrySpeed) : that.maxCrossCountrySpeed != null)
            return false;
        if (maxFordingDepth != null ? !maxFordingDepth.equals(that.maxFordingDepth) : that.maxFordingDepth != null)
            return false;
        if (maxFuelConsumption != null ? !maxFuelConsumption.equals(that.maxFuelConsumption) : that.maxFuelConsumption != null)
            return false;
        if (maxGradient != null ? !maxGradient.equals(that.maxGradient) : that.maxGradient != null) return false;
        if (maxRoadSpeed != null ? !maxRoadSpeed.equals(that.maxRoadSpeed) : that.maxRoadSpeed != null) return false;
        if (maxTrenchWidth != null ? !maxTrenchWidth.equals(that.maxTrenchWidth) : that.maxTrenchWidth != null)
            return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (normalCrossCountrySpeed != null ? !normalCrossCountrySpeed.equals(that.normalCrossCountrySpeed) : that.normalCrossCountrySpeed != null)
            return false;
        if (normalFuelConsumption != null ? !normalFuelConsumption.equals(that.normalFuelConsumption) : that.normalFuelConsumption != null)
            return false;
        if (normalRoadSpeed != null ? !normalRoadSpeed.equals(that.normalRoadSpeed) : that.normalRoadSpeed != null)
            return false;
        if (payloadCapacity != null ? !payloadCapacity.equals(that.payloadCapacity) : that.payloadCapacity != null)
            return false;
        if (personnelCapacity != null ? !personnelCapacity.equals(that.personnelCapacity) : that.personnelCapacity != null)
            return false;
        if (pictureFilename != null ? !pictureFilename.equals(that.pictureFilename) : that.pictureFilename != null)
            return false;
        if (pictureId != null ? !pictureId.equals(that.pictureId) : that.pictureId != null) return false;
        if (rearArmor != null ? !rearArmor.equals(that.rearArmor) : that.rearArmor != null) return false;
        if (reliability != null ? !reliability.equals(that.reliability) : that.reliability != null) return false;
        if (ronsonability != null ? !ronsonability.equals(that.ronsonability) : that.ronsonability != null)
            return false;
        if (sideArmor != null ? !sideArmor.equals(that.sideArmor) : that.sideArmor != null) return false;
        if (takeCoverMod != null ? !takeCoverMod.equals(that.takeCoverMod) : that.takeCoverMod != null) return false;
        if (topArmor != null ? !topArmor.equals(that.topArmor) : that.topArmor != null) return false;
        if (towingCapacity != null ? !towingCapacity.equals(that.towingCapacity) : that.towingCapacity != null)
            return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (weight != null ? !weight.equals(that.weight) : that.weight != null) return false;
        if (width != null ? !width.equals(that.width) : that.width != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (pictureId != null ? pictureId.hashCode() : 0);
        result = 31 * result + (pictureFilename != null ? pictureFilename.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (length != null ? length.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (crew != null ? crew.hashCode() : 0);
        result = 31 * result + (reliability != null ? reliability.hashCode() : 0);
        result = 31 * result + (armaments != null ? armaments.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (fuelCapacity != null ? fuelCapacity.hashCode() : 0);
        result = 31 * result + (maxRoadSpeed != null ? maxRoadSpeed.hashCode() : 0);
        result = 31 * result + (normalRoadSpeed != null ? normalRoadSpeed.hashCode() : 0);
        result = 31 * result + (maxCrossCountrySpeed != null ? maxCrossCountrySpeed.hashCode() : 0);
        result = 31 * result + (normalCrossCountrySpeed != null ? normalCrossCountrySpeed.hashCode() : 0);
        result = 31 * result + (maxFuelConsumption != null ? maxFuelConsumption.hashCode() : 0);
        result = 31 * result + (normalFuelConsumption != null ? normalFuelConsumption.hashCode() : 0);
        result = 31 * result + (ronsonability != null ? ronsonability.hashCode() : 0);
        result = 31 * result + (maxGradient != null ? maxGradient.hashCode() : 0);
        result = 31 * result + (maxFordingDepth != null ? maxFordingDepth.hashCode() : 0);
        result = 31 * result + (maxTrenchWidth != null ? maxTrenchWidth.hashCode() : 0);
        result = 31 * result + (towingCapacity != null ? towingCapacity.hashCode() : 0);
        result = 31 * result + (personnelCapacity != null ? personnelCapacity.hashCode() : 0);
        result = 31 * result + (bulkFuelCapacity != null ? bulkFuelCapacity.hashCode() : 0);
        result = 31 * result + (payloadCapacity != null ? payloadCapacity.hashCode() : 0);
        result = 31 * result + (takeCoverMod != null ? takeCoverMod.hashCode() : 0);
        result = 31 * result + (hasTurret != null ? hasTurret.hashCode() : 0);
        result = 31 * result + (hasOpenTop != null ? hasOpenTop.hashCode() : 0);
        result = 31 * result + (battleWeight != null ? battleWeight.hashCode() : 0);
        result = 31 * result + (frontArmor != null ? frontArmor.hashCode() : 0);
        result = 31 * result + (sideArmor != null ? sideArmor.hashCode() : 0);
        result = 31 * result + (rearArmor != null ? rearArmor.hashCode() : 0);
        result = 31 * result + (topArmor != null ? topArmor.hashCode() : 0);
        return result;
    }
}
