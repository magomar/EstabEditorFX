package net.deludobellico.stabeditor.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import net.deludobellico.stabeditor.data.jaxb.EstabData;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.util.FileIO;

import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable  {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private EstabDataModel estabDataModel;

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
    private TextArea textArea;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchVehicleButton.setDisable(true);
        searchWeaponButton.setDisable(true);
        searchAmmoButton.setDisable(true);
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
        Vehicle element = estabDataModel.searchVehicleByName(searchVehicleTextField.getText());
        if (null == element) return;
        EstabData rootElement = new EstabData();
        rootElement.getVehicle().add(element);
        StringWriter sw = FileIO.marshallXML(rootElement, FileIO.MARSHALLER);
        String result = sw.toString();
        textArea.setText(result);
    }

    @FXML
    private void searchWeaponAction(ActionEvent actionEvent) {

    }

    @FXML
    private void searchAmmoAction(ActionEvent actionEvent) {

    }


}


