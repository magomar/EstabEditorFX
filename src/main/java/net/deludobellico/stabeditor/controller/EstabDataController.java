package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.ObjectFactory;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.model.EstabReference;
import net.deludobellico.stabeditor.util.Util;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private EstabDataModel estabDataModel;
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private static final String VEHICLE_VIEW = "../view/vehicle-editor.fxml";
    private static final String WEAPON_VIEW = "../view/weapon-editor.fxml";
    private static final String AMMO_VIEW = "../view/ammo-editor.fxml";
    private String currentView = "";

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

//    @FXML
//    private VehicleEditorController vehicleEditorController;
//
//    @FXML
//    private WeaponEditorController weaponEditorController;
//
//    @FXML
//    private AmmoEditorController ammoEditorController;

    @FXML
    private ListView<EstabReference> searchResultsListView;
    private ObservableList<EstabReference> estabReferenceObservableList = FXCollections.observableArrayList();

    @FXML
    private StackPane editorStackPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchResultsListView.setItems(estabReferenceObservableList);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if (null != newValue)
                    loadEditor((EstabReference) newValue);
            }
        });
        searchVehicleTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchVehicleAction(null);
            }
        });
        searchWeaponTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchWeaponAction(null);
            }
        });
        searchAmmoTextField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                searchAmmoAction(null);
            }
        });
    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel = estabDataModel;
        numImagesTextField.setText(String.valueOf(estabDataModel.getImages().size()));
        numSidesTextField.setText(String.valueOf(estabDataModel.getSides().size()));
        numVehiclesTextField.setText(String.valueOf(estabDataModel.getVehicles().size()));
        numWeaponsTextField.setText(String.valueOf(estabDataModel.getWeapons().size()));
        numAmmosTextField.setText(String.valueOf(estabDataModel.getAmmos().size()));
        searchVehicleButton.setDisable(false);
        searchWeaponButton.setDisable(false);
        searchAmmoButton.setDisable(false);
        searchVehicleTextField.setDisable(false);
        searchWeaponTextField.setDisable(false);
        searchAmmoTextField.setDisable(false);
    }

    public void setTitle(String title) {
        estabDataTitledPane.setText(title);
    }

    @FXML
    private void searchVehicleAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchVehicleTextField.getText();
        List<Vehicle> vehicles = estabDataModel.searchVehicleByName(textToSearch);
        if (Util.isInteger(textToSearch)) {
            Vehicle vehicle = estabDataModel.searchVehicleById(Integer.parseInt(textToSearch));
            if (null != vehicle) vehicles.add(vehicle);
        }
        for (Vehicle vehicle : vehicles) {
            estabReferenceObservableList.addAll(new EstabReference(vehicle.getId(), vehicle.getName(), OBJECT_FACTORY.createVehicle(vehicle), Vehicle.class));
        }
    }

    @FXML
    private void searchWeaponAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchWeaponTextField.getText();
        List<Weapon> weapons = estabDataModel.searchWeaponByName(textToSearch);
        if (Util.isInteger(textToSearch)) {
            Weapon weapon = estabDataModel.searchWeaponById(Integer.parseInt(textToSearch));
            if (null != weapon) weapons.add(weapon);
        }
        for (Weapon weapon : weapons) {
            estabReferenceObservableList.addAll(new EstabReference(weapon.getId(), weapon.getName(), OBJECT_FACTORY.createWeapon(weapon), Weapon.class));
        }
    }

    @FXML
    private void searchAmmoAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchAmmoTextField.getText();
        List<Ammo> ammos = estabDataModel.searchAmmoByName(textToSearch);
        if (Util.isInteger(textToSearch)) {
            Ammo ammo = estabDataModel.searchAmmoById(Integer.parseInt(textToSearch));
            if (null != ammo) ammos.add(ammo);
        }
        for (Ammo ammo : ammos) {
            estabReferenceObservableList.addAll(new EstabReference(ammo.getId(), ammo.getName(), OBJECT_FACTORY.createAmmo(ammo), Ammo.class));
        }
    }

    private void loadEditor(EstabReference<?> estabReference) {
        Class estabClass = estabReference.getElementClass();
        String editorView = VEHICLE_VIEW;
        if (estabClass.equals(Weapon.class)) {
            editorView = WEAPON_VIEW;
        } else if (estabClass.equals(Ammo.class)) {
            editorView = AMMO_VIEW;
        }
        if (!currentView.equals(editorView))
            try {
                editorStackPane.getChildren().setAll((Node) FXMLLoader.load(EstabDataController.class.getResource(editorView)));
//                switch (editorView) {
//                    case VEHICLE_VIEW: vehicleEditorController.setEstabReference((Vehicle) estabReference.getElement());
//                        break;
//                    case WEAPON_VIEW: weaponEditorController.setEstabReference((Weapon) estabReference.getElement());
//                        break;
//                    case AMMO_VIEW: ammoEditorController.setEstabReference((Ammo) estabReference.getElement());
//                        break;
//                }
            } catch (IOException e) {
                //e.printStackTrace();
            }

//        StringWriter sw = FileIO.marshallXML(estabReference.getJaxbElement(), FileIO.MARSHALLER);
//        String result = sw.toString();
//        resultsTextArea.setText(result);
//        System.out.print(result);
    }
}


