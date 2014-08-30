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
    public void setEstabReference(Vehicle v) {
        this.vehicle = v;
        name.setText(v.getName());
        description.setText(v.getDescription());
        width.setText(String.valueOf(v.getSize().getWidth()));
        height.setText(String.valueOf(v.getSize().getHeight()));
        length.setText(String.valueOf(v.getSize().getLength()));
        weight.setText(String.valueOf(v.getSize().getWeight()));
        battleWeight.setText(String.valueOf(v.getBattleWeight()));
        vehicleType.getSelectionModel().select(v.getType());
        battleWeight.setText(String.valueOf(v.getBattleWeight()));
        bulkFuelCapacity.setText(String.valueOf(v.getBulkFuelCapacity()));
        crew.setText(String.valueOf(v.getCrew()));
        crossCountryMaxSpeed.setText(String.valueOf(v.getSpeed().getCrossCountry().getMax()));
        crossCountryNormalSpeed.setText(String.valueOf(v.getSpeed().getCrossCountry().getNormal()));
        description.setText(v.getDescription());
        frontArmor.setText(String.valueOf(v.getArmour().getFront()));
        fuelCapacity.setText(String.valueOf(v.getFuelCapacity()));
        fuelConsumptionMaxSpeed.setText(String.valueOf(v.getFuelConsumption().getMax()));
        fuelConsumptionNormalSpeed.setText(String.valueOf(v.getFuelConsumption().getNormal()));
        hasOpenTop.setSelected((v.getHasOpenTop().equals("yes") ? true : false));
        hasTurret.setSelected((v.getHasTurret().equals("yes") ? true : false));
        height.setText(String.valueOf(v.getSize().getHeight()));
        length.setText(String.valueOf(v.getSize().getLength()));
        maxFordingDepth.setText(String.valueOf(v.getMaxFordingDepth()));
        maxGradient.setText(String.valueOf(v.getMaxGradient()));
        maxTrenchWidth.setText(String.valueOf(v.getMaxTrenchWidth()));
        name.setText(String.valueOf(v.getName()));
        payloadCapacity.setText(String.valueOf(v.getPayloadCapacity()));
        personnelCapacity.setText(String.valueOf(v.getPersonnelCapacity()));
        rearArmor.setText(String.valueOf(v.getArmour().getRear()));
        reliability.setText(String.valueOf(v.getReliability()));
        roadMaxSpeed.setText(String.valueOf(v.getSpeed().getRoad().getMax()));
        roadNormalSpeed.setText(String.valueOf(v.getSpeed().getRoad().getNormal()));
        ronsonability.setText(String.valueOf(v.getRonsonability()));
        sideArmor.setText(String.valueOf(v.getArmour().getSide()));
        takeCoverMod.setText(String.valueOf(v.getTakeCoverMod()));
        topArmor.setText(String.valueOf(v.getArmour().getTop()));
        towingCapacity.setText(String.valueOf(v.getTowingCapacity()));
        vehicleType.getSelectionModel().select(vehicle.getType());
        weight.setText(String.valueOf(v.getSize().getWeight()));
        width.setText(String.valueOf(v.getSize().getWidth()));
    }


}
