package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.deludobellico.stabeditor.data.jaxb.ObjectFactory;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.util.FileIO;

import javax.xml.bind.JAXBElement;
import java.io.File;
import java.io.StringWriter;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable  {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private EstabDataModel estabDataModel;
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @FXML
    private Button searchAmmoButton;

    @FXML
    private TitledPane estabDataTitledPane;

    @FXML
    private TextField numAmmosTextField;

    @FXML
    private Button searchVehicleButton;

    @FXML
    private TextField searchAmmoTextField;

    @FXML
    private TextField numImagesTextField;

    @FXML
    private TextField searchVehicleTextField;

    @FXML
    private TextField numVehiclesTextField;

    @FXML
    private Button searchWeaponButton;

    @FXML
    private TextField numSidesTextField;

    @FXML
    private TextField searchWeaponTextField;

    @FXML
    private TextField numWeaponsTextField;

    @FXML
    private ListView searchResultsListView;
    private ObservableList<JAXBElement> searchResultsListModel = FXCollections.observableArrayList();

    @FXML
    private TextArea resultsTextArea;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchVehicleButton.setDisable(true);
        searchWeaponButton.setDisable(true);
        searchAmmoButton.setDisable(true);
        searchResultsListView.setItems(searchResultsListModel);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                StringWriter sw = FileIO.marshallXML(newValue, FileIO.MARSHALLER);
                String result = sw.toString();
                resultsTextArea.setText(result);
            }
        });


    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel =  estabDataModel;
        numImagesTextField.setText(String.valueOf(estabDataModel.getImages().size()));
        numSidesTextField.setText(String.valueOf(estabDataModel.getSides().size()));
        numVehiclesTextField.setText(String.valueOf(estabDataModel.getVehicles().size()));
        numWeaponsTextField.setText(String.valueOf(estabDataModel.getWeapons().size()));
        numAmmosTextField.setText(String.valueOf(estabDataModel.getAmmos().size()));
        searchVehicleButton.setDisable(false);
        searchWeaponButton.setDisable(false);
        searchAmmoButton.setDisable(false);
    }

    public void setTitle(String title) {
        estabDataTitledPane.setText(title);
    }

    @FXML
    private void searchVehicleAction(ActionEvent actionEvent) {
        searchResultsListModel.clear();
        List<Vehicle> vehicles = estabDataModel.searchVehicleByName(searchVehicleTextField.getText());
        if (vehicles.isEmpty()) return;
        for (Vehicle vehicle : vehicles) {
            searchResultsListModel.addAll(OBJECT_FACTORY.createVehicle(vehicle));
        }

//        StringWriter sw = FileIO.marshallXML(jaxbElement, FileIO.MARSHALLER);
//        String result = sw.toString();
//        resultsTextArea.setText(result);
    }

    @FXML
    private void searchWeaponAction(ActionEvent actionEvent) {

    }

    @FXML
    private void searchAmmoAction(ActionEvent actionEvent) {

    }


}


