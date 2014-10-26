package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.VehicleType;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class VehicleEditorController implements Initializable, AssetEditorController<Vehicle> {
    @FXML
    private TextField maxTrenchWidth;

    @FXML
    private TextField width;

    @FXML
    private TextField length;

    @FXML
    private TextField sideArmor;

//    @FXML
//    private StackPane vehicleEditor;

    @FXML
    private TextField fuelCapacity;

    @FXML
    private TextField bulkFuelCapacity;

    @FXML
    private TextField reliability;

    @FXML
    private TextField maxFordingDepth;

    @FXML
    private TextField crossCountryMaxSpeed;

    @FXML
    private TextField crossCountryNormalSpeed;

    @FXML
    private TextField maxGradient;

    @FXML
    private TextField battleWeight;

    @FXML
    private TextField frontArmor;

    @FXML
    private CheckBox hasOpenTop;

    @FXML
    private TextField fuelConsumptionNormalSpeed;

    @FXML
    private TextField height;

    @FXML
    private TextField rearArmor;

    @FXML
    private TextField towingCapacity;

    @FXML
    private TextField fuelConsumptionMaxSpeed;

    @FXML
    private TextField name;

    @FXML
    private TextField ronsonability;

    @FXML
    private TextArea description;

    @FXML
    private TextField payloadCapacity;

    @FXML
    private ComboBox<VehicleType> vehicleType;

    @FXML
    private TextField weight;

    @FXML
    private TextField topArmor;

    @FXML
    private CheckBox hasTurret;

    @FXML
    private TextField crew;

    @FXML
    private TextField roadMaxSpeed;

    @FXML
    private TextField roadNormalSpeed;

    @FXML
    private TextField personnelCapacity;

    @FXML
    private TextField takeCoverMod;

    private Vehicle vehicle;
    private ObservableList<VehicleType> vehicleTypeObservableList = FXCollections.observableArrayList();
    private boolean isReadOnly = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicle = new Vehicle();
        vehicleTypeObservableList.addAll(VehicleType.values());
        vehicleType.setItems(vehicleTypeObservableList);
        vehicleType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VehicleType>() {
            @Override
            public void changed(ObservableValue<? extends VehicleType> observable, VehicleType oldValue, VehicleType newValue) {
                if (null != newValue)
                    vehicle.setType(newValue);
            }
        });
    }

    @Override
    public void setEditable(boolean isEditable) {
        battleWeight.setEditable(isEditable);
        bulkFuelCapacity.setEditable(isEditable);
        crew.setEditable(isEditable);
        crossCountryMaxSpeed.setEditable(isEditable);
        crossCountryNormalSpeed.setEditable(isEditable);
        description.setEditable(isEditable);
        frontArmor.setEditable(isEditable);
        fuelCapacity.setEditable(isEditable);
        fuelConsumptionMaxSpeed.setEditable(isEditable);
        fuelConsumptionNormalSpeed.setEditable(isEditable);
        height.setEditable(isEditable);
        hasOpenTop.setDisable(!isEditable);
        hasOpenTop.setStyle("-fx-opacity: 1");
        hasTurret.setDisable(!isEditable);
        hasTurret.setStyle("-fx-opacity: 1");
        height.setEditable(isEditable);
        length.setEditable(isEditable);
        maxFordingDepth.setEditable(isEditable);
        maxGradient.setEditable(isEditable);
        maxTrenchWidth.setEditable(isEditable);
        name.setEditable(isEditable);
        payloadCapacity.setEditable(isEditable);
        personnelCapacity.setEditable(isEditable);
        rearArmor.setEditable(isEditable);
        reliability.setEditable(isEditable);
        roadMaxSpeed.setEditable(isEditable);
        roadNormalSpeed.setEditable(isEditable);
        ronsonability.setEditable(isEditable);
        sideArmor.setEditable(isEditable);
        takeCoverMod.setEditable(isEditable);
        topArmor.setEditable(isEditable);
        towingCapacity.setEditable(isEditable);
        vehicleType.setDisable(!isEditable);
        vehicleType.setStyle("-fx-opacity: 1");
        weight.setEditable(isEditable);
        width.setEditable(isEditable);
    }

    @Override
    public void bindProperties(Vehicle vehicle) {
        
        battleWeight.textProperty().bindBidirectional(vehicle.battleWeightProperty(), new NumberStringConverter());
        bulkFuelCapacity.textProperty().bindBidirectional(vehicle.bulkFuelCapacityProperty(), new NumberStringConverter());
        crew.textProperty().bindBidirectional(vehicle.crewProperty(), new NumberStringConverter());
        crossCountryMaxSpeed.textProperty().bindBidirectional(vehicle.getSpeed().getCrossCountry().maxProperty(), new NumberStringConverter());
        crossCountryNormalSpeed.textProperty().bindBidirectional(vehicle.getSpeed().getCrossCountry().normalProperty(), new NumberStringConverter());
        description.textProperty().bindBidirectional(vehicle.descriptionProperty());
        frontArmor.textProperty().bindBidirectional(vehicle.getArmour().frontProperty(), new NumberStringConverter());
        fuelCapacity.textProperty().bindBidirectional(vehicle.fuelCapacityProperty(), new NumberStringConverter());
        fuelConsumptionMaxSpeed.textProperty().bindBidirectional(vehicle.getFuelConsumption().maxProperty(), new NumberStringConverter());
        fuelConsumptionNormalSpeed.textProperty().bindBidirectional(vehicle.getFuelConsumption().normalProperty(), new NumberStringConverter());

        //TODO: fix boolean properties
        hasOpenTop.setSelected((vehicle.getHasOpenTop().equals("yes") ? true : false));
        hasTurret.setSelected((vehicle.getHasTurret().equals("yes") ? true : false));

        height.textProperty().bindBidirectional(vehicle.getSize().heightProperty(), new NumberStringConverter());
        length.textProperty().bindBidirectional(vehicle.getSize().lengthProperty(), new NumberStringConverter());
        maxFordingDepth.textProperty().bindBidirectional(vehicle.maxFordingDepthProperty(), new NumberStringConverter());
        maxGradient.textProperty().bindBidirectional(vehicle.maxGradientProperty(), new NumberStringConverter());
        maxTrenchWidth.textProperty().bindBidirectional(vehicle.maxTrenchWidthProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(vehicle.nameProperty());
        payloadCapacity.textProperty().bindBidirectional(vehicle.payloadCapacityProperty(), new NumberStringConverter());
        personnelCapacity.textProperty().bindBidirectional(vehicle.personnelCapacityProperty(), new NumberStringConverter());
        rearArmor.textProperty().bindBidirectional(vehicle.getArmour().rearProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(vehicle.reliabilityProperty(), new NumberStringConverter());
        roadMaxSpeed.textProperty().bindBidirectional(vehicle.getSpeed().getRoad().maxProperty(), new NumberStringConverter());
        roadNormalSpeed.textProperty().bindBidirectional(vehicle.getSpeed().getRoad().maxProperty(), new NumberStringConverter());
        ronsonability.textProperty().bindBidirectional(vehicle.ronsonabilityProperty(), new NumberStringConverter());
        sideArmor.textProperty().bindBidirectional(vehicle.getArmour().sideProperty(), new NumberStringConverter());
        takeCoverMod.textProperty().bindBidirectional(vehicle.takeCoverModProperty(), new NumberStringConverter());
        topArmor.textProperty().bindBidirectional(vehicle.getArmour().topProperty(), new NumberStringConverter());
        towingCapacity.textProperty().bindBidirectional(vehicle.towingCapacityProperty(), new NumberStringConverter());

        //TODO: fix combo box property
        vehicleType.getSelectionModel().select(vehicle.getType());

        weight.textProperty().bindBidirectional(vehicle.getSize().weightProperty(), new NumberStringConverter());
        width.textProperty().bindBidirectional(vehicle.getSize().widthProperty(), new NumberStringConverter());

    }

    @Override
    public void unbindProperties(Vehicle vehicle) {
        
        battleWeight.textProperty().unbindBidirectional(vehicle.battleWeightProperty());
        bulkFuelCapacity.textProperty().unbindBidirectional(vehicle.bulkFuelCapacityProperty());
        crew.textProperty().unbindBidirectional(vehicle.crewProperty());
        crossCountryMaxSpeed.textProperty().unbindBidirectional(vehicle.getSpeed().getCrossCountry().maxProperty());
        crossCountryNormalSpeed.textProperty().unbindBidirectional(vehicle.getSpeed().getCrossCountry().normalProperty());
        description.textProperty().unbindBidirectional(vehicle.descriptionProperty());
        frontArmor.textProperty().unbindBidirectional(vehicle.getArmour().frontProperty());
        fuelCapacity.textProperty().unbindBidirectional(vehicle.fuelCapacityProperty());
        fuelConsumptionMaxSpeed.textProperty().unbindBidirectional(vehicle.getFuelConsumption().maxProperty());
        fuelConsumptionNormalSpeed.textProperty().unbindBidirectional(vehicle.getFuelConsumption().normalProperty());


        //hasOpenTop.setSelected((vehicle.getHasOpenTop().equals("yes") ? true : false));
        //hasTurret.setSelected((vehicle.getHasTurret().equals("yes") ? true : false));

        height.textProperty().unbindBidirectional(vehicle.getSize().heightProperty());
        length.textProperty().unbindBidirectional(vehicle.getSize().lengthProperty());
        maxFordingDepth.textProperty().unbindBidirectional(vehicle.maxFordingDepthProperty());
        maxGradient.textProperty().unbindBidirectional(vehicle.maxGradientProperty());
        maxTrenchWidth.textProperty().unbindBidirectional(vehicle.maxTrenchWidthProperty());
        name.textProperty().unbindBidirectional(vehicle.nameProperty());
        payloadCapacity.textProperty().unbindBidirectional(vehicle.payloadCapacityProperty());
        personnelCapacity.textProperty().unbindBidirectional(vehicle.personnelCapacityProperty());
        rearArmor.textProperty().unbindBidirectional(vehicle.getArmour().rearProperty());
        reliability.textProperty().unbindBidirectional(vehicle.reliabilityProperty());
        roadMaxSpeed.textProperty().unbindBidirectional(vehicle.getSpeed().getRoad().maxProperty());
        roadNormalSpeed.textProperty().unbindBidirectional(vehicle.getSpeed().getRoad().maxProperty());
        ronsonability.textProperty().unbindBidirectional(vehicle.ronsonabilityProperty());
        sideArmor.textProperty().unbindBidirectional(vehicle.getArmour().sideProperty());
        takeCoverMod.textProperty().unbindBidirectional(vehicle.takeCoverModProperty());
        topArmor.textProperty().unbindBidirectional(vehicle.getArmour().topProperty());
        towingCapacity.textProperty().unbindBidirectional(vehicle.towingCapacityProperty());


        //vehicleType.getSelectionModel().select(vehicle.getType());

        weight.textProperty().unbindBidirectional(vehicle.getSize().weightProperty());
        width.textProperty().unbindBidirectional(vehicle.getSize().widthProperty());
    }

    @Override
    public Vehicle getEstabElement() {
        return this.vehicle;
    }

    @Override
    public void setEstabElement(Vehicle newVehicle) {
        Vehicle previousVehicle = this.vehicle;
        this.vehicle =  newVehicle;

        if(previousVehicle.getName() != null) unbindProperties(previousVehicle);
        bindProperties(newVehicle);
    }


}
