package net.deludobellico.stabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.ObjectFactory;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;
import net.deludobellico.stabeditor.model.*;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Pair;
import net.deludobellico.stabeditor.view.EstabListCell;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.function.Consumer;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();
    private static final Class[] ELEMENT_MODEL_CLASSES = {VehicleModel.class, WeaponModel.class, AmmoModel.class};
    private static final Class[] ELEMENT_CLASSES = {Vehicle.class, Weapon.class, Ammo.class};

    @FXML
    private TitledPane estabDataPane;

    @FXML
    private ComboBox<Pair<Class, String>> elementClassComboBox;

    @FXML
    private Button searchButton;

    @FXML
    private TextField searchTextField;

    @FXML
    private AnchorPane editorPane;

    @FXML
    private ListView<EstabListCell> searchResultsListView;

    private ObservableList<EstabListCell> estabListCells = FXCollections.observableArrayList();
    // Save last search to optimize tab swap
    private Map<Class, SavedSearchList<EstabListCell>> searchLists = new HashMap<Class, SavedSearchList<EstabListCell>>() {{
        for (int i = 0; i < ELEMENT_MODEL_CLASSES.length; i++) {
            put(ELEMENT_MODEL_CLASSES[i], new SavedSearchList<>());
        }
    }};

    // Save loaded views, controllers and panes (element panes have to be AnchorPanes)
    private MainController mainController = null;
    private Map<Class, ElementEditorController> elementEditorControllers = new HashMap<>(3);
    private Map<Class, AnchorPane> elementEditorPanes = new HashMap<>(3);
    private Map<Class, String> elementEditorViews = new HashMap<Class, String>() {{
        put(VehicleModel.class, FileIO.VEHICLE_VIEW);
        put(WeaponModel.class, FileIO.WEAPON_VIEW);
        put(AmmoModel.class, FileIO.AMMO_VIEW);
    }};

    // Current element editor (either vehicle, weapon or ammo) and estab data model (source or target)
    private ElementEditorController elementEditorController = null;
    private EstabDataModel estabDataModel;

    // Source estab data isn't editable, target estab data is editable
    private boolean isEditable = false;

    // Active element = element currently displayed
    private ElementModel activeElement = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Listen to changes in the search text and search matching elements name
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> searchElement(null));

        // Cells have icons and are associated to a estab reference object
        searchResultsListView.setItems(estabListCells);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // if we select and item, display it
            if (newValue != null) setActiveElement(newValue.getElementModel());
        });


        for (int i = 0; i < ELEMENT_MODEL_CLASSES.length; i++)
            elementClassComboBox.getItems().add(new Pair<>(ELEMENT_MODEL_CLASSES[i], ELEMENT_CLASSES[i].getSimpleName(), false));
        elementClassComboBox.getSelectionModel().selectFirst();
        // Update the list when choosing a new element class from the choice box
        elementClassComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null && estabDataModel != null) searchElement(null);
        });
    }

    public void update() {
        searchLists.values().stream().forEach(s -> s.setForceSearch(true));
        setTitle();
        searchElement(null);
    }

    /**
     * Gets the text from the {@link TextField} and searches matching names
     *
     * @param actionEvent
     */
    public void searchElement(ActionEvent actionEvent) {
        Class elementModelClass = elementClassComboBox.getSelectionModel().getSelectedItem().getKey();
        SavedSearchList<EstabListCell> savedList = searchLists.get(elementModelClass);
        String textToSearch = searchTextField.getText();

        estabListCells.clear();
        // If this isn't a forced search and the last search text is the same we want now, load the saved list
        if (!savedList.isForceSearch() && textToSearch.equals(savedList.getLastSearch())) {
            estabListCells.addAll(savedList.getList());
        } else {
            savedList.getList().clear();
            savedList.setForceSearch(false);
            savedList.setLastSearch(textToSearch);


            // This passes the method to invoke when pressing a button from the search list
            Consumer<ElementModel> buttonAction;
            BooleanProperty buttonDisableProperty;

            if (isEditable) {
                // if it's the target pane, buttons will call the remove method and they'll be always enabled
                buttonAction = mainController::removeEstabElementFromCellList;
                buttonDisableProperty = new SimpleBooleanProperty(false);
            } else {
                // if it's the source pane, buttons will call the copy method and they are enabled when the main controllers says so
                buttonAction = mainController::copyEstabElementFromCellList;
                buttonDisableProperty = mainController.getDisableCopyProperty();
            }
            // Get al elements with name watching the seatch text
            List<ElementModel> elements = estabDataModel.searchElement(textToSearch, elementModelClass);
            for (ElementModel element : elements) {
                EstabListCell cell;
                cell = new EstabListCell(element, buttonAction, buttonDisableProperty, isEditable);
                estabListCells.add(cell);
                savedList.getList().add(cell);
            }
        }
    }

    public boolean copyEstabElement(RelatedElementLists relatedElementLists) {
        if (!isEditable) return false;
        boolean successPasting = false;
        if (relatedElementLists.hasRepeatedElements()) {
            Action answer = UtilView.showWarningRepeatedElement(relatedElementLists.getRepeatedElements());
            successPasting = this.estabDataModel.paste(relatedElementLists, answer);
        } else {
            // if there are no repeated elements, proceed as if overwriting
            successPasting = this.estabDataModel.paste(relatedElementLists, UtilView.DIALOG_OVERWRITE);
        }
        if (successPasting) update();
        return successPasting;
    }

    public boolean removeEstabElement(RelatedElementLists relatedElements) {
        List<ElementModel> removeElementList = relatedElements.getAllElements();
        Action answer = UtilView.showWarningRemoveElement(removeElementList);
        boolean successRemoving = false;
        if (answer == Dialog.ACTION_OK) {
            // clear target editor if the active element is in the list
            successRemoving = estabDataModel.remove(relatedElements);
            clear();
            if (successRemoving) update();

        }
        return successRemoving;
    }

    public void saveDataModel(File file) {
        estabDataModel.saveToFile(file);
    }

    public void clear() {
        searchResultsListView.getItems().clear();
        editorPane.setVisible(false);
        setTitle();
        if (elementEditorController != null) elementEditorController.clear();
    }

    /**
     * Displays an element using its associated {@link EstabReference}
     *
     * @param elementModel
     */
    public void setActiveElement(ElementModel elementModel) {
        if (null != elementModel) {
            Class elementClass = elementModel.getClass();
            AnchorPane editorNode;
            // If the current element isn't set (null) or it's from other class than the one we want to display
            // then update the editor
            if ((activeElement == null) || !(activeElement.getClass() == elementClass)) {
                // if we have saved the controller and editorPane, use them; else load them
                if (elementEditorPanes.containsKey(elementClass) && elementEditorControllers.containsKey(elementClass)) {
                    editorPane = elementEditorPanes.get(elementClass);
                    elementEditorController = elementEditorControllers.get(elementClass);
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(elementEditorViews.get(elementClass)));
                    try {
                        editorPane.getChildren().clear();
                        editorNode = fxmlLoader.load();
                        editorPane.getChildren().addAll(editorNode.getChildren());
                        elementEditorPanes.put(elementClass, editorNode);
                        elementEditorController = fxmlLoader.getController();
                        elementEditorController.setEditable(isEditable);
                        elementEditorControllers.put(elementClass, elementEditorController);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
            elementEditorController.setEstabElement(elementModel);
            activeElement = elementModel;
        }
    }


    public void set(String title, boolean isEditable, MainController editorController) {
        setTitle(title);
        setEditable(isEditable);
        setMainController(editorController);
    }

    public void setTitle() {
        setTitle(isEditable ? "Target Estab" : "Source Estab");
    }

    public void setTitle(String title) {
        if (estabDataModel != null) {
            title = title.split("\\|")[0];
            int sides = estabDataModel.getSides().size();
            int images = estabDataModel.getImages().size();
            int vehicles = estabDataModel.getVehicles().size();
            int weapons = estabDataModel.getVehicles().size();
            int ammo = estabDataModel.getAmmo().size();
            title = String.format(title + " | %d Sides | %d Images | %d Vehicles | %d Weapons | %d Ammo", sides, images, vehicles, weapons, ammo);
        }
        estabDataPane.setText(title);
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel = estabDataModel;
        searchButton.setDisable(false);
        searchTextField.setDisable(false);
        if (estabDataModel != null) update();
    }

    public MainController getMainController() {
        return mainController;
    }


    public ElementModel getActiveElement() {
        // TODO: check this later, why not return just the activElement field
        if (!searchResultsListView.getSelectionModel().getSelectedItems().isEmpty()) {
            return searchResultsListView.getSelectionModel().getSelectedItem().getElementModel();
        }
        return null;
    }

    public EstabDataModel getEstabDataModel() {
        return estabDataModel;
    }

    public ListView<EstabListCell> getSearchResultsListView() {
        return searchResultsListView;
    }
}


