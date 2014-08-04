package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.VehicleType;
import net.deludobellico.stabeditor.model.EstabReference;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class VehicleEditorController extends AbstractEditorController<Vehicle> implements Initializable {

    @FXML
    private TextField widthTextField;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private ComboBox<VehicleType> vehicleTypeComboBox;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField battleWeightTextField;

    private Vehicle vehicle;
    private ObservableList<VehicleType> vehicleTypeObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleTypeObservableList.addAll(VehicleType.values());
        vehicleTypeComboBox.setItems(vehicleTypeObservableList);
    }

    @Override
    public void setEstabReference(Vehicle vehicle) {
        this.vehicle = vehicle;
        widthTextField.setText(String.valueOf(vehicle.getSize().getWidth()));
        heightTextField.setText(String.valueOf(vehicle.getSize().getHeight()));
        lengthTextField.setText(String.valueOf(vehicle.getSize().getLength()));
        weightTextField.setText(String.valueOf(vehicle.getSize().getWeight()));
        battleWeightTextField.setText(String.valueOf(vehicle.getBattleWeight()));

    }


}
