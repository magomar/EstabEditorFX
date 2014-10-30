package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.util.converter.IntegerStringConverter;
import net.deludobellico.stabeditor.data.jaxb.*;

/**
 * Created by Mario on 26/10/2014.
 */
public class VehicleModel implements AssetModel, PojoJFXModel<Vehicle> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();
    /* */
    private final FloatProperty width = new SimpleFloatProperty();
    private final FloatProperty height = new SimpleFloatProperty();
    private final FloatProperty length = new SimpleFloatProperty();
    private final FloatProperty weight = new SimpleFloatProperty();
    /* end VehicleSize */
    private final IntegerProperty crew = new SimpleIntegerProperty();
    private final FloatProperty reliability = new SimpleFloatProperty();
    private final ObservableList<ArmamentModel> armaments = FXCollections.observableArrayList();
    private final ObjectProperty<VehicleType> type = new SimpleObjectProperty<>();
    private final FloatProperty fuelCapacity = new SimpleFloatProperty();
    private final ObjectProperty<SpeedDataModel> roadSpeed = new SimpleObjectProperty<>();
    private final ObjectProperty<SpeedDataModel> crossCountrySpeed = new SimpleObjectProperty<>();
    private final ObjectProperty<FuelConsumptionModel> fuelConsumption = new SimpleObjectProperty<>();
    // end VehicleSpeeds
    private final FloatProperty ronsonability = new SimpleFloatProperty();
    private final IntegerProperty maxGradient = new SimpleIntegerProperty();
    private final IntegerProperty maxFordingDepth = new SimpleIntegerProperty();
    private final IntegerProperty maxTrenchWidth = new SimpleIntegerProperty();
    private final FloatProperty towingCapacity = new SimpleFloatProperty();
    private final IntegerProperty personnelCapacity = new SimpleIntegerProperty();
    private final FloatProperty bulkFuelCapacity = new SimpleFloatProperty();
    private final FloatProperty payloadCapacity = new SimpleFloatProperty();
    private final FloatProperty takeCoverMod = new SimpleFloatProperty();
    private final BooleanProperty hasTurret = new SimpleBooleanProperty();
    private final BooleanProperty hasOpenTop = new SimpleBooleanProperty();
    private final FloatProperty battleWeight = new SimpleFloatProperty();
    private final FloatProperty frontArmor = new SimpleFloatProperty();
    private final FloatProperty sideArmor = new SimpleFloatProperty();
    private final FloatProperty rearArmor = new SimpleFloatProperty();
    private final FloatProperty topArmor = new SimpleFloatProperty();

    public VehicleModel(Vehicle vehicle) {
        setPojo(vehicle);
    }
    // end Armor

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
        ArmamentList al = new ArmamentList();
        armaments.stream().forEach(armamentModel -> al.getArmament().add(armamentModel.getPojo()));
        vehicle.setType(type.get());
        vehicle.setFuelCapacity(fuelCapacity.get());
        SpeedData rs = new SpeedData();
        rs.setMax(roadSpeed.get().getMax());
        rs.setNormal(roadSpeed.get().getNormal());
        SpeedData cs = new SpeedData();
        cs.setMax(crossCountrySpeed.get().getMax());
        cs.setNormal(crossCountrySpeed.get().getNormal());
        VehicleSpeeds vss = new VehicleSpeeds();
        vss.setRoad(rs);
        vss.setCrossCountry(cs);
        vehicle.setSpeed(vss);
        FuelConsumption fc = new FuelConsumption();
        fc.setMax(fuelConsumption.get().getMax());
        fc.setNormal(fuelConsumption.get().getNormal());
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
        vehicle.setHasOpenTop(PojoJFXModel.boolToYesNo(hasOpenTop.get()));
        vehicle.setHasTurret(PojoJFXModel.boolToYesNo(hasTurret.get()));
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
        // Random null pointer exception here
        if (pojo.getArmaments() != null){
            if (pojo.getArmaments().getArmament() != null) {
                pojo.getArmaments().getArmament().stream().map(armament -> new ArmamentModel(armament)).forEach(armamentModel -> armaments.add(armamentModel));
            }
        }

        type.set(pojo.getType());
        fuelCapacity.set(pojo.getFuelCapacity());
        SpeedDataModel csd = new SpeedDataModel(pojo.getSpeed().getCrossCountry().getMax(), pojo.getSpeed().getCrossCountry().getNormal());
        SpeedDataModel rsd = new SpeedDataModel(pojo.getSpeed().getRoad().getMax(), pojo.getSpeed().getRoad().getNormal());
        crossCountrySpeed.set(csd);
        roadSpeed.set(rsd);
        fuelConsumption.set(new FuelConsumptionModel(pojo.getFuelConsumption()));
        ronsonability.set(pojo.getRonsonability());
        maxGradient.set(pojo.getMaxGradient());
        maxFordingDepth.set(pojo.getMaxFordingDepth());
        maxTrenchWidth.set(pojo.getMaxTrenchWidth());
        towingCapacity.set(pojo.getTowingCapacity());
        bulkFuelCapacity.set(pojo.getBulkFuelCapacity());
        payloadCapacity.set(pojo.getPayloadCapacity());
        takeCoverMod.set(pojo.getTakeCoverMod());
        hasOpenTop.set(PojoJFXModel.yesNoToBool(pojo.getHasOpenTop()));
        hasTurret.set(PojoJFXModel.yesNoToBool(pojo.getHasTurret()));
        battleWeight.set(pojo.getBattleWeight());
        frontArmor.set(pojo.getArmour().getFront());
        sideArmor.set(pojo.getArmour().getSide());
        rearArmor.set(pojo.getArmour().getRear());
        topArmor.set(pojo.getArmour().getTop());
    }

    public Integer getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public int getPictureId() {
        return pictureId.get();
    }

    public IntegerProperty pictureIdProperty() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId.set(pictureId);
    }

    public String getPictureFilename() {
        return pictureFilename.get();
    }

    public StringProperty pictureFilenameProperty() {
        return pictureFilename;
    }

    public void setPictureFilename(String pictureFilename) {
        this.pictureFilename.set(pictureFilename);
    }

    public float getWidth() {
        return width.get();
    }

    public FloatProperty widthProperty() {
        return width;
    }

    public void setWidth(float width) {
        this.width.set(width);
    }

    public float getHeight() {
        return height.get();
    }

    public FloatProperty heightProperty() {
        return height;
    }

    public void setHeight(float height) {
        this.height.set(height);
    }

    public float getLength() {
        return length.get();
    }

    public FloatProperty lengthProperty() {
        return length;
    }

    public void setLength(float length) {
        this.length.set(length);
    }

    public float getWeight() {
        return weight.get();
    }

    public FloatProperty weightProperty() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight.set(weight);
    }

    public int getCrew() {
        return crew.get();
    }

    public IntegerProperty crewProperty() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew.set(crew);
    }

    public float getReliability() {
        return reliability.get();
    }

    public FloatProperty reliabilityProperty() {
        return reliability;
    }

    public void setReliability(float reliability) {
        this.reliability.set(reliability);
    }

    public ObservableList<ArmamentModel> getArmaments() {
        return armaments;
    }

    public VehicleType getType() {
        return type.get();
    }

    public ObjectProperty<VehicleType> typeProperty() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type.set(type);
    }

    public float getFuelCapacity() {
        return fuelCapacity.get();
    }

    public FloatProperty fuelCapacityProperty() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity.set(fuelCapacity);
    }

    public SpeedDataModel getRoadSpeed() {
        return roadSpeed.get();
    }

    public ObjectProperty<SpeedDataModel> roadSpeedProperty() {
        return roadSpeed;
    }

    public void setRoadSpeed(SpeedDataModel roadSpeed) {
        this.roadSpeed.set(roadSpeed);
    }

    public SpeedDataModel getCrossCountrySpeed() {
        return crossCountrySpeed.get();
    }

    public ObjectProperty<SpeedDataModel> crossCountrySpeedProperty() {
        return crossCountrySpeed;
    }

    public void setCrossCountrySpeed(SpeedDataModel crossCountrySpeed) {
        this.crossCountrySpeed.set(crossCountrySpeed);
    }

    public FuelConsumptionModel getFuelConsumption() {
        return fuelConsumption.get();
    }

    public ObjectProperty<FuelConsumptionModel> fuelConsumptionProperty() {
        return fuelConsumption;
    }

    public void setFuelConsumption(FuelConsumptionModel fuelConsumption) {
        this.fuelConsumption.set(fuelConsumption);
    }

    public float getRonsonability() {
        return ronsonability.get();
    }

    public FloatProperty ronsonabilityProperty() {
        return ronsonability;
    }

    public void setRonsonability(float ronsonability) {
        this.ronsonability.set(ronsonability);
    }

    public int getMaxGradient() {
        return maxGradient.get();
    }

    public IntegerProperty maxGradientProperty() {
        return maxGradient;
    }

    public void setMaxGradient(int maxGradient) {
        this.maxGradient.set(maxGradient);
    }

    public int getMaxFordingDepth() {
        return maxFordingDepth.get();
    }

    public IntegerProperty maxFordingDepthProperty() {
        return maxFordingDepth;
    }

    public void setMaxFordingDepth(int maxFordingDepth) {
        this.maxFordingDepth.set(maxFordingDepth);
    }

    public int getMaxTrenchWidth() {
        return maxTrenchWidth.get();
    }

    public IntegerProperty maxTrenchWidthProperty() {
        return maxTrenchWidth;
    }

    public void setMaxTrenchWidth(int maxTrenchWidth) {
        this.maxTrenchWidth.set(maxTrenchWidth);
    }

    public float getTowingCapacity() {
        return towingCapacity.get();
    }

    public FloatProperty towingCapacityProperty() {
        return towingCapacity;
    }

    public void setTowingCapacity(float towingCapacity) {
        this.towingCapacity.set(towingCapacity);
    }

    public int getPersonnelCapacity() {
        return personnelCapacity.get();
    }

    public IntegerProperty personnelCapacityProperty() {
        return personnelCapacity;
    }

    public void setPersonnelCapacity(int personnelCapacity) {
        this.personnelCapacity.set(personnelCapacity);
    }

    public float getBulkFuelCapacity() {
        return bulkFuelCapacity.get();
    }

    public FloatProperty bulkFuelCapacityProperty() {
        return bulkFuelCapacity;
    }

    public void setBulkFuelCapacity(float bulkFuelCapacity) {
        this.bulkFuelCapacity.set(bulkFuelCapacity);
    }

    public float getPayloadCapacity() {
        return payloadCapacity.get();
    }

    public FloatProperty payloadCapacityProperty() {
        return payloadCapacity;
    }

    public void setPayloadCapacity(float payloadCapacity) {
        this.payloadCapacity.set(payloadCapacity);
    }

    public float getTakeCoverMod() {
        return takeCoverMod.get();
    }

    public FloatProperty takeCoverModProperty() {
        return takeCoverMod;
    }

    public void setTakeCoverMod(float takeCoverMod) {
        this.takeCoverMod.set(takeCoverMod);
    }

    public boolean getHasTurret() {
        return hasTurret.get();
    }

    public BooleanProperty hasTurretProperty() {
        return hasTurret;
    }

    public void setHasTurret(boolean hasTurret) {
        this.hasTurret.set(hasTurret);
    }

    public boolean getHasOpenTop() {
        return hasOpenTop.get();
    }

    public BooleanProperty hasOpenTopProperty() {
        return hasOpenTop;
    }

    public void setHasOpenTop(boolean hasOpenTop) {
        this.hasOpenTop.set(hasOpenTop);
    }

    public float getBattleWeight() {
        return battleWeight.get();
    }

    public FloatProperty battleWeightProperty() {
        return battleWeight;
    }

    public void setBattleWeight(float battleWeight) {
        this.battleWeight.set(battleWeight);
    }

    public float getFrontArmor() {
        return frontArmor.get();
    }

    public FloatProperty frontArmorProperty() {
        return frontArmor;
    }

    public void setFrontArmor(float frontArmor) {
        this.frontArmor.set(frontArmor);
    }

    public float getSideArmor() {
        return sideArmor.get();
    }

    public FloatProperty sideArmorProperty() {
        return sideArmor;
    }

    public void setSideArmor(float sideArmor) {
        this.sideArmor.set(sideArmor);
    }

    public float getRearArmor() {
        return rearArmor.get();
    }

    public FloatProperty rearArmorProperty() {
        return rearArmor;
    }

    public void setRearArmor(float rearArmor) {
        this.rearArmor.set(rearArmor);
    }

    public float getTopArmor() {
        return topArmor.get();
    }

    public FloatProperty topArmorProperty() {
        return topArmor;
    }

    public void setTopArmor(float topArmor) {
        this.topArmor.set(topArmor);
    }
}
