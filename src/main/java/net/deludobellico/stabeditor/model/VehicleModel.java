package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.Armament;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.VehicleType;

/**
 * Created by Mario on 26/10/2014.
 */
public class VehicleModel implements PojoJFXModel<Vehicle> {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    //    private final ObjectProperty<Picture> picture = new SimpleObjectProperty<Picture>();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();// I don't think this is necessary here
    //    private final  ObjectProperty<VehicleSize> size = new SimpleObjectProperty<VehicleSize>();
    private final FloatProperty width = new SimpleFloatProperty();
    private final FloatProperty height = new SimpleFloatProperty();
    private final FloatProperty length = new SimpleFloatProperty();
    private final FloatProperty weight = new SimpleFloatProperty();
    /* end VehicleSize */
    private final IntegerProperty crew = new SimpleIntegerProperty();
    private final FloatProperty reliability = new SimpleFloatProperty();
    //    private final ObjectProperty<ArmamentList> armaments = new SimpleObjectProperty<ArmamentList>();
    private final ObservableList<Armament> armaments = FXCollections.observableArrayList();
    private final ObjectProperty<VehicleType> type = new SimpleObjectProperty<VehicleType>();
    private final FloatProperty fuelCapacity = new SimpleFloatProperty();
    //    private final  ObjectProperty<VehicleSpeeds> speed = new SimpleObjectProperty<VehicleSpeeds>();
    private final ObjectProperty<SpeedDataModel> roadSpeed = new SimpleObjectProperty<SpeedDataModel>();
    private final ObjectProperty<SpeedDataModel> crossCountrySpeed = new SimpleObjectProperty<SpeedDataModel>();
    // end VehicleSpeeds
//    private final  ObjectProperty<FuelConsumption> fuelConsumption = new SimpleObjectProperty<FuelConsumption>();
    // fuel consumption moved into SpeedDataModel
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
    //    private final  ObjectProperty<Armor> armour = new SimpleObjectProperty<Armor>();
    private final FloatProperty frontArmor = new SimpleFloatProperty();
    private final FloatProperty sideArmor = new SimpleFloatProperty();
    private final FloatProperty rearArmor = new SimpleFloatProperty();
    private final FloatProperty topArmor = new SimpleFloatProperty();
    // end Armor
    private final IntegerProperty id = new SimpleIntegerProperty();

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

    public ObservableList<Armament> getArmaments() {
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

    public int getId() {
        return id.get();
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public Vehicle getPojo() {
        // TODO convert all properties into a Vehicle pojo
        return null;
    }

    @Override
    public void setPojo(Vehicle pojo) {
        // TODO set all properties of this object taking the appropriate data from the pojo
    }
}
