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
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty description = new SimpleStringProperty();
    private final IntegerProperty pictureId = new SimpleIntegerProperty();
    private final StringProperty pictureFilename = new SimpleStringProperty();
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
    private final ObjectProperty<VehicleType> type = new SimpleObjectProperty<>();
    private final FloatProperty fuelCapacity = new SimpleFloatProperty();
    //    private final  ObjectProperty<VehicleSpeeds> speed = new SimpleObjectProperty<VehicleSpeeds>();
    private final ObjectProperty<SpeedDataModel> roadSpeed = new SimpleObjectProperty<>();
    private final ObjectProperty<SpeedDataModel> crossCountrySpeed = new SimpleObjectProperty<>();
     private final ObjectProperty<FuelConsumptionModel> roadFuelConsumption = new SimpleObjectProperty<>();
    private final ObjectProperty<FuelConsumptionModel> crossCountryFuelConsumption = new SimpleObjectProperty<>();
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

    @Override
    public Vehicle getPojo() {
        // TODO convert all properties into a Vehicle pojo
        return null;
    }

    @Override
    public void setPojo(Vehicle pojo) {
        // TODO set all properties of this object taking the appropriate data from the pojo
    }
    
       // TODO getters and setters
}
