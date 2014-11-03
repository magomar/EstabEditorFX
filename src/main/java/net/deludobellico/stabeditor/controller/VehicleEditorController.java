package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.VehicleType;
import net.deludobellico.stabeditor.model.VehicleModel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class VehicleEditorController implements Initializable, ElementEditorController<VehicleModel> {
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
    private EstabDataController estabDataController;


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
    public void bindProperties(VehicleModel element) {
        battleWeight.textProperty().bindBidirectional(element.battleWeightProperty(), new NumberStringConverter());
        bulkFuelCapacity.textProperty().bindBidirectional(element.bulkFuelCapacityProperty(), new NumberStringConverter());
        crew.textProperty().bindBidirectional(element.crewProperty(), new NumberStringConverter());
        crossCountryMaxSpeed.textProperty().bindBidirectional(element.maxCrossCountrySpeedProperty(), new NumberStringConverter());
        crossCountryNormalSpeed.textProperty().bindBidirectional(element.normalCrossCountrySpeedProperty(), new NumberStringConverter());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        frontArmor.textProperty().bindBidirectional(element.frontArmorProperty(), new NumberStringConverter());
        fuelCapacity.textProperty().bindBidirectional(element.fuelCapacityProperty(), new NumberStringConverter());
        fuelConsumptionMaxSpeed.textProperty().bindBidirectional(element.maxFuelConsumptionProperty(), new NumberStringConverter());
        fuelConsumptionNormalSpeed.textProperty().bindBidirectional(element.normalFuelConsumptionProperty(), new NumberStringConverter());

        hasOpenTop.selectedProperty().bindBidirectional(element.hasOpenTopProperty());
        hasTurret.selectedProperty().bindBidirectional(element.hasTurretProperty());

        height.textProperty().bindBidirectional(element.heightProperty(), new NumberStringConverter());
        length.textProperty().bindBidirectional(element.lengthProperty(), new NumberStringConverter());
        maxFordingDepth.textProperty().bindBidirectional(element.maxFordingDepthProperty(), new NumberStringConverter());
        maxGradient.textProperty().bindBidirectional(element.maxGradientProperty(), new NumberStringConverter());
        maxTrenchWidth.textProperty().bindBidirectional(element.maxTrenchWidthProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        payloadCapacity.textProperty().bindBidirectional(element.payloadCapacityProperty(), new NumberStringConverter());
        personnelCapacity.textProperty().bindBidirectional(element.personnelCapacityProperty(), new NumberStringConverter());
        rearArmor.textProperty().bindBidirectional(element.rearArmorProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(element.reliabilityProperty(), new NumberStringConverter());
        roadMaxSpeed.textProperty().bindBidirectional(element.maxRoadSpeedProperty(), new NumberStringConverter());
        roadNormalSpeed.textProperty().bindBidirectional(element.normalRoadSpeedProperty(), new NumberStringConverter());
        ronsonability.textProperty().bindBidirectional(element.ronsonabilityProperty(), new NumberStringConverter());
        sideArmor.textProperty().bindBidirectional(element.sideArmorProperty(), new NumberStringConverter());
        takeCoverMod.textProperty().bindBidirectional(element.takeCoverModProperty(), new NumberStringConverter());
        topArmor.textProperty().bindBidirectional(element.topArmorProperty(), new NumberStringConverter());
        towingCapacity.textProperty().bindBidirectional(element.towingCapacityProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(element.weightProperty(), new NumberStringConverter());
        width.textProperty().bindBidirectional(element.widthProperty(), new NumberStringConverter());
        vehicleType.getSelectionModel().select(element.getType());

    }

    @Override
    public void unbindProperties(VehicleModel element) {
        battleWeight.textProperty().unbindBidirectional(element.battleWeightProperty());
        bulkFuelCapacity.textProperty().unbindBidirectional(element.bulkFuelCapacityProperty());
        crew.textProperty().unbindBidirectional(element.crewProperty());
        crossCountryMaxSpeed.textProperty().unbindBidirectional(element.maxCrossCountrySpeedProperty());
        crossCountryNormalSpeed.textProperty().unbindBidirectional(element.normalCrossCountrySpeedProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        frontArmor.textProperty().unbindBidirectional(element.frontArmorProperty());
        fuelCapacity.textProperty().unbindBidirectional(element.fuelCapacityProperty());
        fuelConsumptionMaxSpeed.textProperty().unbindBidirectional(element.maxFuelConsumptionProperty());
        fuelConsumptionNormalSpeed.textProperty().unbindBidirectional(element.normalFuelConsumptionProperty());

        hasOpenTop.selectedProperty().unbindBidirectional(element.hasOpenTopProperty());
        hasTurret.selectedProperty().unbindBidirectional(element.hasTurretProperty());

        height.textProperty().unbindBidirectional(element.heightProperty());
        length.textProperty().unbindBidirectional(element.lengthProperty());
        maxFordingDepth.textProperty().unbindBidirectional(element.maxFordingDepthProperty());
        maxGradient.textProperty().unbindBidirectional(element.maxGradientProperty());
        maxTrenchWidth.textProperty().unbindBidirectional(element.maxTrenchWidthProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        payloadCapacity.textProperty().unbindBidirectional(element.payloadCapacityProperty());
        personnelCapacity.textProperty().unbindBidirectional(element.personnelCapacityProperty());
        rearArmor.textProperty().unbindBidirectional(element.rearArmorProperty());
        reliability.textProperty().unbindBidirectional(element.reliabilityProperty());
        roadMaxSpeed.textProperty().unbindBidirectional(element.maxRoadSpeedProperty());
        roadNormalSpeed.textProperty().unbindBidirectional(element.normalRoadSpeedProperty());
        ronsonability.textProperty().unbindBidirectional(element.ronsonabilityProperty());
        sideArmor.textProperty().unbindBidirectional(element.sideArmorProperty());
        takeCoverMod.textProperty().unbindBidirectional(element.takeCoverModProperty());
        topArmor.textProperty().unbindBidirectional(element.topArmorProperty());
        towingCapacity.textProperty().unbindBidirectional(element.towingCapacityProperty());
        weight.textProperty().unbindBidirectional(element.weightProperty());
        width.textProperty().unbindBidirectional(element.widthProperty());

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
    public void setEstabElement(VehicleModel element) {
        if (vehicle != null) unbindProperties(vehicle);
        this.vehicle = element;
        bindProperties(vehicle);
    }

    @Override
    public EstabDataController getEstabDataController() {
        return estabDataController;
    }

    @Override
    public void setEstabDataController(EstabDataController estabDataController) {
        this.estabDataController = estabDataController;
    }
}
