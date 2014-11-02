package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.VehicleType;
import net.deludobellico.stabeditor.model.ElementModel;
import net.deludobellico.stabeditor.model.VehicleModel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class VehicleEditorController implements Initializable, ElementEditorController {
    @FXML
    private TextField maxTrenchWidth;

    @FXML
    private TextField width;

    @FXML
    private TextField length;

    @FXML
    private TextField sideArmor;

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

    private VehicleModel vehicle;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for (int i = 0; i < VehicleType.values().length; i++) vehicleType.getItems().add(VehicleType.values()[i]);
        vehicleType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) vehicle.setType(newValue);
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
    public void bindProperties(ElementModel element) {
        battleWeight.textProperty().bindBidirectional(vehicle.battleWeightProperty(), new NumberStringConverter());
        bulkFuelCapacity.textProperty().bindBidirectional(vehicle.bulkFuelCapacityProperty(), new NumberStringConverter());
        crew.textProperty().bindBidirectional(vehicle.crewProperty(), new NumberStringConverter());
        crossCountryMaxSpeed.textProperty().bindBidirectional(vehicle.maxCrossCountrySpeedProperty(), new NumberStringConverter());
        crossCountryNormalSpeed.textProperty().bindBidirectional(vehicle.normalCrossCountrySpeedProperty(), new NumberStringConverter());
        description.textProperty().bindBidirectional(vehicle.descriptionProperty());
        frontArmor.textProperty().bindBidirectional(vehicle.frontArmorProperty(), new NumberStringConverter());
        fuelCapacity.textProperty().bindBidirectional(vehicle.fuelCapacityProperty(), new NumberStringConverter());
        fuelConsumptionMaxSpeed.textProperty().bindBidirectional(vehicle.maxFuelConsumptionProperty(), new NumberStringConverter());
        fuelConsumptionNormalSpeed.textProperty().bindBidirectional(vehicle.normalFuelConsumptionProperty(), new NumberStringConverter());

        hasOpenTop.selectedProperty().bindBidirectional(vehicle.hasOpenTopProperty());
        hasTurret.selectedProperty().bindBidirectional(vehicle.hasTurretProperty());

        height.textProperty().bindBidirectional(vehicle.heightProperty(), new NumberStringConverter());
        length.textProperty().bindBidirectional(vehicle.lengthProperty(), new NumberStringConverter());
        maxFordingDepth.textProperty().bindBidirectional(vehicle.maxFordingDepthProperty(), new NumberStringConverter());
        maxGradient.textProperty().bindBidirectional(vehicle.maxGradientProperty(), new NumberStringConverter());
        maxTrenchWidth.textProperty().bindBidirectional(vehicle.maxTrenchWidthProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(vehicle.nameProperty());
        payloadCapacity.textProperty().bindBidirectional(vehicle.payloadCapacityProperty(), new NumberStringConverter());
        personnelCapacity.textProperty().bindBidirectional(vehicle.personnelCapacityProperty(), new NumberStringConverter());
        rearArmor.textProperty().bindBidirectional(vehicle.rearArmorProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(vehicle.reliabilityProperty(), new NumberStringConverter());
        roadMaxSpeed.textProperty().bindBidirectional(vehicle.maxRoadSpeedProperty(), new NumberStringConverter());
        roadNormalSpeed.textProperty().bindBidirectional(vehicle.normalRoadSpeedProperty(), new NumberStringConverter());
        ronsonability.textProperty().bindBidirectional(vehicle.ronsonabilityProperty(), new NumberStringConverter());
        sideArmor.textProperty().bindBidirectional(vehicle.sideArmorProperty(), new NumberStringConverter());
        takeCoverMod.textProperty().bindBidirectional(vehicle.takeCoverModProperty(), new NumberStringConverter());
        topArmor.textProperty().bindBidirectional(vehicle.topArmorProperty(), new NumberStringConverter());
        towingCapacity.textProperty().bindBidirectional(vehicle.towingCapacityProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(vehicle.weightProperty(), new NumberStringConverter());
        width.textProperty().bindBidirectional(vehicle.widthProperty(), new NumberStringConverter());
        vehicleType.getSelectionModel().select(vehicle.getType());

    }

    @Override
    public void unbindProperties(ElementModel element) {
        battleWeight.textProperty().unbindBidirectional(vehicle.battleWeightProperty());
        bulkFuelCapacity.textProperty().unbindBidirectional(vehicle.bulkFuelCapacityProperty());
        crew.textProperty().unbindBidirectional(vehicle.crewProperty());
        crossCountryMaxSpeed.textProperty().unbindBidirectional(vehicle.maxCrossCountrySpeedProperty());
        crossCountryNormalSpeed.textProperty().unbindBidirectional(vehicle.normalCrossCountrySpeedProperty());
        description.textProperty().unbindBidirectional(vehicle.descriptionProperty());
        frontArmor.textProperty().unbindBidirectional(vehicle.frontArmorProperty());
        fuelCapacity.textProperty().unbindBidirectional(vehicle.fuelCapacityProperty());
        fuelConsumptionMaxSpeed.textProperty().unbindBidirectional(vehicle.maxFuelConsumptionProperty());
        fuelConsumptionNormalSpeed.textProperty().unbindBidirectional(vehicle.normalFuelConsumptionProperty());

        hasOpenTop.selectedProperty().unbindBidirectional(vehicle.hasOpenTopProperty());
        hasTurret.selectedProperty().unbindBidirectional(vehicle.hasTurretProperty());

        height.textProperty().unbindBidirectional(vehicle.heightProperty());
        length.textProperty().unbindBidirectional(vehicle.lengthProperty());
        maxFordingDepth.textProperty().unbindBidirectional(vehicle.maxFordingDepthProperty());
        maxGradient.textProperty().unbindBidirectional(vehicle.maxGradientProperty());
        maxTrenchWidth.textProperty().unbindBidirectional(vehicle.maxTrenchWidthProperty());
        name.textProperty().unbindBidirectional(vehicle.nameProperty());
        payloadCapacity.textProperty().unbindBidirectional(vehicle.payloadCapacityProperty());
        personnelCapacity.textProperty().unbindBidirectional(vehicle.personnelCapacityProperty());
        rearArmor.textProperty().unbindBidirectional(vehicle.rearArmorProperty());
        reliability.textProperty().unbindBidirectional(vehicle.reliabilityProperty());
        roadMaxSpeed.textProperty().unbindBidirectional(vehicle.maxRoadSpeedProperty());
        roadNormalSpeed.textProperty().unbindBidirectional(vehicle.normalRoadSpeedProperty());
        ronsonability.textProperty().unbindBidirectional(vehicle.ronsonabilityProperty());
        sideArmor.textProperty().unbindBidirectional(vehicle.sideArmorProperty());
        takeCoverMod.textProperty().unbindBidirectional(vehicle.takeCoverModProperty());
        topArmor.textProperty().unbindBidirectional(vehicle.topArmorProperty());
        towingCapacity.textProperty().unbindBidirectional(vehicle.towingCapacityProperty());
        weight.textProperty().unbindBidirectional(vehicle.weightProperty());
        width.textProperty().unbindBidirectional(vehicle.widthProperty());

    }

    @Override
    public void clear() {
        unbindProperties(vehicle);
    }

    @Override
    public VehicleModel getEstabElement() {
        return this.vehicle;
    }

    @Override
    public void setEstabElement(ElementModel element) {
        VehicleModel newVehicle = (VehicleModel) element;
        VehicleModel previousVehicle = this.vehicle;
        this.vehicle = newVehicle;

        if (previousVehicle != null) unbindProperties(previousVehicle);
        bindProperties(newVehicle);
    }


}
