package net.deludobellico.stabeditor.model;

import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.JFXModelUtil;

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
    private final ObjectProperty<SpeedDataModel> roadSpeed = new SimpleObjectProperty<>();
    private final ObjectProperty<SpeedDataModel> crossCountrySpeed = new SimpleObjectProperty<>();
    private final ObjectProperty<FuelConsumptionModel> fuelConsumption = new SimpleObjectProperty<>();
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
        vehicle.setArmaments(new ArmamentList());
        armaments.stream().forEach(armamentModel -> vehicle.getArmaments().getArmament().add(armamentModel.getPojo()));
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
        vehicle.setHasOpenTop(JFXModelUtil.booleanToYesNo(hasOpenTop.get()).value());
        vehicle.setHasTurret(JFXModelUtil.booleanToYesNo(hasTurret.get()).value());
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
        pojo.getArmaments().getArmament().stream().map(armament -> new ArmamentModel(armament)).forEach(armamentModel -> armaments.add(armamentModel));
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
        hasOpenTop.set(pojo.getHasOpenTop().equals(YesNo.YES.value()));
        hasTurret.set(pojo.getHasTurret().equals(YesNo.YES.value()));
        battleWeight.set(pojo.getBattleWeight());
        frontArmor.set(pojo.getArmour().getFront());
        sideArmor.set(pojo.getArmour().getSide());
        rearArmor.set(pojo.getArmour().getRear());
        topArmor.set(pojo.getArmour().getTop());
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

    public SpeedDataModel getRoadSpeed() {
        return roadSpeed.get();
    }

    public void setRoadSpeed(SpeedDataModel roadSpeed) {
        this.roadSpeed.set(roadSpeed);
    }

    public ObjectProperty<SpeedDataModel> roadSpeedProperty() {
        return roadSpeed;
    }

    public SpeedDataModel getCrossCountrySpeed() {
        return crossCountrySpeed.get();
    }

    public void setCrossCountrySpeed(SpeedDataModel crossCountrySpeed) {
        this.crossCountrySpeed.set(crossCountrySpeed);
    }

    public ObjectProperty<SpeedDataModel> crossCountrySpeedProperty() {
        return crossCountrySpeed;
    }

    public FuelConsumptionModel getFuelConsumption() {
        return fuelConsumption.get();
    }

    public void setFuelConsumption(FuelConsumptionModel fuelConsumption) {
        this.fuelConsumption.set(fuelConsumption);
    }

    public ObjectProperty<FuelConsumptionModel> fuelConsumptionProperty() {
        return fuelConsumption;
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
}
