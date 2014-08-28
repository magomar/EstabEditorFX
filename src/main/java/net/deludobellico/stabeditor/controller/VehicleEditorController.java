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
    private TextField bulkFuel;

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
    private TextField crewTF;

    @FXML
    private TextField roadMaxSpeedTF;

    @FXML
    private TextField roadNormalSpeedTF;

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
        if (!isEditable) {
            name.setEditable(false);
            description.setEditable(false);
            vehicleType.setEditable(false);
            hasTurret.setDisable(true);
            hasOpenTop.setDisable(true);
            width.setEditable(false);
            height.setEditable(false);
            length.setEditable(false);
            weight.setEditable(false);
            battleWeight.setEditable(false);

        }
    }

    @Override
    public void setEstabReference(Vehicle vehicle) {
        this.vehicle = vehicle;
        name.setText(vehicle.getName());
        description.setText(vehicle.getDescription());
        width.setText(String.valueOf(vehicle.getSize().getWidth()));
        height.setText(String.valueOf(vehicle.getSize().getHeight()));
        length.setText(String.valueOf(vehicle.getSize().getLength()));
        weight.setText(String.valueOf(vehicle.getSize().getWeight()));
        battleWeight.setText(String.valueOf(vehicle.getBattleWeight()));
        vehicleType.getSelectionModel().select(vehicle.getType());
    }


}
