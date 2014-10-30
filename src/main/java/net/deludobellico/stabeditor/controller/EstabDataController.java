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
import net.deludobellico.stabeditor.model.*;
import net.deludobellico.stabeditor.view.EstabListCell;
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
    private ListView<EstabListCell> searchResultsListView;
    private ObservableList<EstabListCell> estabReferenceObservableList = FXCollections.observableArrayList();
    // Optimize tab swap
    private Map<Class, SearchList<EstabListCell>> searchLists = new HashMap<Class, SearchList<EstabListCell>>() {{
        put(VehicleModel.class, new SearchList());
        put(WeaponModel.class, new SearchList());
        put(AmmoModel.class, new SearchList());
    }};

    @FXML
    private StackPane editorStackPane;

    @FXML
    private TabPane tabPane;

    private EstabDataModel estabDataModel;
    private Class activeElementClass = null;
    private EstabReference activeEstabElement = null;
    private ElementEditorController elementController = null;
    private Map<Class, String> elementEditorViews = new HashMap<>(3);
    private Map<Class, Node> elementEditorNodes = new HashMap<>(3);
    private Map<Class, ElementEditorController> elementEditorControllers = new HashMap<>(3);
    private boolean isEditable = false;
    private EstabEditorController editorController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        searchResultsListView.setItems(estabReferenceObservableList);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) setActiveElement(newValue.getEstabReference());
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

        elementEditorViews.put(Vehicle.class, VEHICLE_VIEW);
        elementEditorViews.put(Weapon.class, WEAPON_VIEW);
        elementEditorViews.put(Ammo.class, AMMO_VIEW);

    }

    public EstabReference<?> getActiveElement() {
        return searchResultsListView.getSelectionModel().getSelectedItem().getEstabReference();
    }

    public void setActiveElement(EstabReference<?> estabReference) {
        activeEstabElement = estabReference;
        if (null != estabReference) {
            Class estabClass = estabReference.getElementClass();
            Node editorNode;
            if (null == activeElementClass || !activeElementClass.equals(estabClass)) {
                activeElementClass = estabClass;
                if (elementEditorNodes.containsKey(estabClass)) {
                    editorNode = elementEditorNodes.get(estabClass);
                    elementController = elementEditorControllers.get(estabClass);
                    editorStackPane.getChildren().setAll(editorNode);
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(elementEditorViews.get(estabClass)));
                    try {
                        editorNode = fxmlLoader.load();
                        elementEditorNodes.put(estabClass, editorNode);
                        elementController = fxmlLoader.getController();
                        elementController.setEditable(isEditable);
                        editorStackPane.getChildren().setAll(editorNode);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            // TODO: fix null pointer exception around here
            //System.out.println(estabReference+" "+elementController+" "+activeElementClass);
            elementController.setEstabElement((ElementModel) PojoJFXModel.wrapper(estabReference.getElement()));

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

    public ListView<EstabListCell> getSearchResultsListView() {
        return searchResultsListView;
    }


    private void searchElement(TextField textField, Class elementClass) {
        SearchList<EstabListCell> savedList = searchLists.get(elementClass);
        String textToSearch = textField.getText();

        estabReferenceObservableList.clear();
        if (textToSearch.equals(savedList.getLastSearch())) {
            estabReferenceObservableList.addAll(savedList.getList());
        } else {
            savedList.getList().clear();
            savedList.setLastSearch(textToSearch);
            List<ElementModel> elements = estabDataModel.searchElement(textToSearch, elementClass);
            for (ElementModel element : elements) {
                EstabReference es;
                if (elementClass.equals(VehicleModel.class)) {
                    es = new EstabReference(element.getId(), element.getName(), OBJECT_FACTORY.createVehicle(((VehicleModel) element).getPojo()), Vehicle.class);
                } else if (elementClass.equals(WeaponModel.class)) {
                    es = new EstabReference(element.getId(), element.getName(), OBJECT_FACTORY.createWeapon(((WeaponModel) element).getPojo()), Weapon.class);
                } else {
                    es = new EstabReference(element.getId(), element.getName(), OBJECT_FACTORY.createAmmo(((AmmoModel) element).getPojo()), Ammo.class);
                }
                EstabListCell cell = new EstabListCell(es, editorController::copyEstabElementFromCellList, editorController.getCopyElementButton().disableProperty(), isEditable);
                estabReferenceObservableList.add(cell);
                savedList.getList().add(cell);
            }
        }
    }

    @FXML
    private void searchVehicleAction(ActionEvent actionEvent) {
        searchElement(searchVehicleTextField, VehicleModel.class);
    }


    @FXML
    private void searchWeaponAction(ActionEvent actionEvent) {
        searchElement(searchWeaponTextField, WeaponModel.class);
    }

    @FXML
    private void searchAmmoAction(ActionEvent actionEvent) {
        searchElement(searchAmmoTextField, AmmoModel.class);
    }


    public void copyEstabElement(EstabReference elementToCopy, CopyPasteLists copyPasteLists) {
        if (!isEditable) return;
        boolean successPasting = false;
        if (copyPasteLists.hasRepeatedElements()) {
            Action answer = UtilView.showWarningDialogRepeatedElement(copyPasteLists);
            successPasting = estabDataModel.paste(copyPasteLists, answer);
        } else {
            // if there are no repeated elements, proceed as if overwriting
            successPasting = estabDataModel.paste(copyPasteLists, UtilView.DIALOG_OVERWRITE);
        }
        if(successPasting){
            setActiveElement(elementToCopy);
            updateStatistics();
        }
    }

    public void saveDataModel(File file) {
        estabDataModel.saveToFile(file);
    }

    public EstabDataModel getEstabDataModel() {
        return estabDataModel;
    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel = estabDataModel;
        editorStackPane.setVisible(true);
        updateStatistics();
        searchVehicleButton.setDisable(false);
        searchWeaponButton.setDisable(false);
        searchAmmoButton.setDisable(false);
        searchVehicleTextField.setDisable(false);
        searchWeaponTextField.setDisable(false);
        searchAmmoTextField.setDisable(false);
    }


    public void clear() {
        searchResultsListView.getItems().clear();
        searchWeaponTextField.clear();
        searchAmmoTextField.clear();
        searchVehicleTextField.clear();
        numAmmosTextField.clear();
        numImagesTextField.clear();
        numSidesTextField.clear();
        numVehiclesTextField.clear();
        numWeaponsTextField.clear();
        setTitle("");
        editorStackPane.setVisible(false);
    }

    public void set(String title, boolean isEditable, EstabEditorController editorController) {
        setTitle(title);
        setEditable(isEditable);
        setEditorController(editorController);
    }

    public void setEditorController(EstabEditorController editorController) {
        this.editorController = editorController;
    }

    public EstabEditorController getEditorController() {
        return editorController;
    }

    /**
     * I need a better name
     * @param title
     * @param isEditable
     * @param cellButtonAction
     * @param disableButtonProperty
     */
//    public void set(String title, boolean isEditable, Consumer<EstabReference> cellButtonAction, BooleanProperty disableButtonProperty) {
//        setTitle(title);
//        setEditable(isEditable);
//        searchResultsListView.setCellFactory(param -> new IconListCell(isEditable, cellButtonAction, disableButtonProperty));
//    }


}


