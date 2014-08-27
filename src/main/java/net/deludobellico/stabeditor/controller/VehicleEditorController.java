package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private TextField nameTextField;

    @FXML
    private TextArea descriptionTextArea;

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private ComboBox<VehicleType> vehicleTypeComboBox;

    @FXML
    private TextField weightText;

    @FXML
    private TextField battleWeightTextField;

    private Vehicle vehicle;
    private ObservableList<VehicleType> vehicleTypeObservableList = FXCollections.observableArrayList();
    private boolean isReadOnly = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicle = new Vehicle();
        vehicleTypeObservableList.addAll(VehicleType.values());
        vehicleTypeComboBox.setItems(vehicleTypeObservableList);
        vehicleTypeComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<VehicleType>() {
            @Override
            public void changed(ObservableValue<? extends VehicleType> observable, VehicleType oldValue, VehicleType newValue) {
                if (null != newValue)
                    vehicle.setType(newValue);
            }
        });
    }

    @Override
    public void setReadOnly(boolean isReadOnly) {
        if (isReadOnly) {
            nameTextField.setEditable(false);
            descriptionTextArea.setEditable(false);
        }
    }

    @Override
    public void setEstabReference(Vehicle vehicle) {
        this.vehicle = vehicle;
        nameTextField.setText(vehicle.getName());
        descriptionTextArea.setText(vehicle.getDescription());
        widthTextField.setText(String.valueOf(vehicle.getSize().getWidth()));
        heightTextField.setText(String.valueOf(vehicle.getSize().getHeight()));
        lengthTextField.setText(String.valueOf(vehicle.getSize().getLength()));
        weightText.setText(String.valueOf(vehicle.getSize().getWeight()));
        battleWeightTextField.setText(String.valueOf(vehicle.getBattleWeight()));
        vehicleTypeComboBox.getSelectionModel().select(vehicle.getType());
    }


}
