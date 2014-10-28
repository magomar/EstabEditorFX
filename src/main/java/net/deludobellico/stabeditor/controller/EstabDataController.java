package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.ObjectFactory;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;
import net.deludobellico.stabeditor.model.CopyPasteLists;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.model.EstabReference;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private static final String VEHICLE_VIEW = "../view/vehicle-editor.fxml";
    private static final String WEAPON_VIEW = "../view/weapon-editor.fxml";
    private static final String AMMO_VIEW = "../view/ammo-editor.fxml";

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
    private ListView<EstabReference> searchResultsListView;
    private ObservableList<EstabReference> estabReferenceObservableList = FXCollections.observableArrayList();

    @FXML
    private StackPane editorStackPane;

    @FXML
    private TabPane tabPane;

    private EstabDataModel estabDataModel;
    private Class activeElementClass = null;
    private EstabReference activeEstabElement = null;
    private AssetEditorController componentController = null;
    private Map<Class, String> componentEditorViews = new HashMap<>(3);
    private Map<Class, Node> componentEditorNodes = new HashMap<>(3);
    private Map<Class, AssetEditorController> componentEditorControllers = new HashMap<>(3);
    private boolean isEditable = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        searchResultsListView.setItems(estabReferenceObservableList);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) setActiveComponent(newValue);
        });
        searchVehicleTextField.textProperty().addListener((observable, oldValue, newValue) -> searchVehicleAction(null));
        searchWeaponTextField.textProperty().addListener((observable, oldValue, newValue) -> searchWeaponAction(null));
        searchAmmoTextField.textProperty().addListener((observable, oldValue, newValue) -> searchAmmoAction(null));

        tabPane.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && estabDataModel != null) {
                if (newValue.getText().startsWith("V")) searchVehicleAction(null); // Vehicle tab
                else if (newValue.getText().startsWith("W")) searchWeaponAction(null);  //Weapon tab
                else searchAmmoAction(null); //Ammo tab
            }
        });

        componentEditorViews.put(Vehicle.class, VEHICLE_VIEW);
        componentEditorViews.put(Weapon.class, WEAPON_VIEW);
        componentEditorViews.put(Ammo.class, AMMO_VIEW);

    }

    public EstabReference<?> getActiveComponent() {
        return searchResultsListView.getSelectionModel().getSelectedItem();
    }

    public void setActiveComponent(EstabReference<?> estabReference) {
        activeEstabElement = estabReference;
        if (null != estabReference) {
            Class estabClass = estabReference.getElementClass();
            Node editorNode;
            if (null == activeElementClass || !activeElementClass.equals(estabClass)) {
                activeElementClass = estabClass;
                if (componentEditorNodes.containsKey(estabClass)) {
                    editorNode = componentEditorNodes.get(estabClass);
                    componentController = componentEditorControllers.get(estabClass);
                    editorStackPane.getChildren().setAll(editorNode);
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(componentEditorViews.get(estabClass)));
                    try {
                        editorNode = fxmlLoader.load();
                        componentEditorNodes.put(estabClass, editorNode);
                        componentController = fxmlLoader.getController();
                        componentController.setEditable(isEditable);
                        editorStackPane.getChildren().setAll(editorNode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

//        StringWriter sw = FileIO.marshallXML(estabReference.getJaxbElement(), FileIO.MARSHALLER);
//        String result = sw.toString();
//        resultsTextArea.setText(result);
//        System.out.print(result);
            }
            componentController.setEstabElement(estabReference.getElement());
        }
    }

    private void updateStatistics() {
        numImagesTextField.setText(String.valueOf(estabDataModel.getImages().size()));
        numSidesTextField.setText(String.valueOf(estabDataModel.getSides().size()));
        numVehiclesTextField.setText(String.valueOf(estabDataModel.getVehicles().size()));
        numWeaponsTextField.setText(String.valueOf(estabDataModel.getWeapons().size()));
        numAmmosTextField.setText(String.valueOf(estabDataModel.getAmmos().size()));
        String tabName = tabPane.getSelectionModel().selectedItemProperty().getValue().getText();
        if (tabName.startsWith("V")) searchVehicleAction(null);
        else if (tabName.startsWith("W")) searchWeaponAction(null);
        else searchAmmoAction(null);
    }

    public void setTitle(String title) {
        estabDataTitledPane.setText(title);
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public ListView<EstabReference> getSearchResultsListView() {
        return searchResultsListView;
    }

    @FXML
    private void searchVehicleAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchVehicleTextField.getText();
        List<Vehicle> vehicles = estabDataModel.searchVehicle(textToSearch);
        for (Vehicle vehicle : vehicles) {
            estabReferenceObservableList.addAll(new EstabReference(vehicle.getId(), vehicle.getName(), OBJECT_FACTORY.createVehicle(vehicle), Vehicle.class));
        }
    }

    @FXML
    private void searchWeaponAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchWeaponTextField.getText();
        List<Weapon> weapons = estabDataModel.searchWeapon(textToSearch);
        for (Weapon weapon : weapons) {
            estabReferenceObservableList.addAll(new EstabReference(weapon.getId(), weapon.getName(), OBJECT_FACTORY.createWeapon(weapon), Weapon.class));
        }
    }

    @FXML
    private void searchAmmoAction(ActionEvent actionEvent) {
        estabReferenceObservableList.clear();
        String textToSearch = searchAmmoTextField.getText();
        List<Ammo> ammos = estabDataModel.searchAmmo(textToSearch);
        for (Ammo ammo : ammos) {
            estabReferenceObservableList.addAll(new EstabReference(ammo.getId(), ammo.getName(), OBJECT_FACTORY.createAmmo(ammo), Ammo.class));
        }
    }

    public void pasteActiveComponent(CopyPasteLists copyPasteLists) {
        if (!isEditable) return;
        estabDataModel.checkRepeatedElements(copyPasteLists);

        if (copyPasteLists.hasRepeatedElements()) {
            Action answer = UtilView.showWarningDialogRepeatedElement(copyPasteLists);
            estabDataModel.paste(copyPasteLists, answer);
        } else {
            // if there are no repeated element, proceed as if overwriting
            estabDataModel.paste(copyPasteLists, UtilView.DIALOG_OVERWRITE);
        }
        updateStatistics();
    }

    public void saveDataModel(File file) {
        estabDataModel.saveToFile(file);
    }

    public EstabDataModel getEstabDataModel() {
        return estabDataModel;
    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel = estabDataModel;
        updateStatistics();
        searchVehicleButton.setDisable(false);
        searchWeaponButton.setDisable(false);
        searchAmmoButton.setDisable(false);
        searchVehicleTextField.setDisable(false);
        searchWeaponTextField.setDisable(false);
        searchAmmoTextField.setDisable(false);
    }


}


