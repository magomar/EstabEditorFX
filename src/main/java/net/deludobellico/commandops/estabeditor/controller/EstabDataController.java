package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import net.deludobellico.commandops.estabeditor.data.jaxb.ObjectFactory;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.SavedSearchList;
import net.deludobellico.commandops.estabeditor.util.Util;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;
import net.deludobellico.commandops.estabeditor.util.view.EstabListCell;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabDataController.class.getName());
    private static final ObjectFactory OBJECT_FACTORY = new ObjectFactory();

    @FXML
    private TitledPane estabDataPane;

    @FXML
    private TextField searchTextField;

    @FXML
    private AnchorPane editorPane;

    @FXML
    private Button vehicleButton;

    @FXML
    private Button weaponButton;

    @FXML
    private Button ammoButton;

    @FXML
    private ImageView vehicleButtonImage;

    @FXML
    private ImageView weaponButtonImage;

    @FXML
    private ImageView ammoButtonImage;

    @FXML
    private ListView<EstabListCell> searchResultsListView;

    // Current search list elements class
    private Class activeSearchListClass = VehicleModel.class;
    private BooleanProperty searchDisable = new SimpleBooleanProperty(true);

    private ObservableList<EstabListCell> estabListCells = FXCollections.observableArrayList();

    // Save last search to optimize tab swap
    private Map<Class, SavedSearchList<EstabListCell>> searchLists = new HashMap<Class, SavedSearchList<EstabListCell>>() {{
        for (int i = 0; i < Util.ELEMENT_MODEL_CLASSES.length; i++) {
            put(Util.ELEMENT_MODEL_CLASSES[i], new SavedSearchList<>());
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
    private File activeFile = null;


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


        vehicleButton.disableProperty().bind(searchDisable);
        weaponButton.disableProperty().bind(searchDisable);
        ammoButton.disableProperty().bind(searchDisable);

        vehicleButtonImage.setImage(new Image(FileIO.VEHICLE_ICON_RESOURCE));
        weaponButtonImage.setImage(new Image(FileIO.WEAPON_ICON_RESOURCE));
        ammoButtonImage.setImage(new Image(FileIO.AMMO_ICON_RESOURCE));
    }

    public void update() {
        searchLists.values().stream().forEach(s -> s.setForceSearch(true));
        setTitle();
        if (estabDataModel != null) searchElement(null);
    }

    @FXML
    private void searchVehicle(ActionEvent actionEvent) {
        activeSearchListClass = VehicleModel.class;
        searchElement(null);
    }

    @FXML
    private void searchWeapon(ActionEvent actionEvent) {
        activeSearchListClass = WeaponModel.class;
        searchElement(null);
    }

    @FXML
    private void searchAmmo(ActionEvent actionEvent) {
        activeSearchListClass = AmmoModel.class;
        searchElement(null);
    }
    /**
     * Gets the text from the  search {@link TextField} and searches matching names
     *
     * @param actionEvent
     */
    private void searchElement(ActionEvent actionEvent) {
        SavedSearchList<EstabListCell> savedList = searchLists.get(activeSearchListClass);
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
            List<ElementModel> elements = estabDataModel.searchElement(textToSearch, activeSearchListClass);
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
            Collection selectedItems = new ArrayList<>();
            DialogAction answer = UtilView.showWarningRepeatedElements(relatedElementLists.getRepeatedElements(), selectedItems);
            successPasting = this.estabDataModel.paste(relatedElementLists, answer, selectedItems);
        } else {
            // if there are no repeated elements, proceed as if overwriting
            successPasting = this.estabDataModel.paste(relatedElementLists, DialogAction.OVERWRITE, null);
        }
        if (successPasting) update();
        return successPasting;
    }

    public boolean removeEstabElement(RelatedElementLists relatedElements) {
        List<ElementModel> removeElementList = relatedElements.getAllElements();

        Collection selectedItems = new ArrayList<>();
        DialogAction answer = UtilView.showWarningRemoveElements(removeElementList, selectedItems);
        boolean successRemoving = false;
        if (answer == DialogAction.OK) {
            // clear target editor if the active element is in the list
            successRemoving = estabDataModel.remove(relatedElements);
            clear();
            if (successRemoving) update();

        } else if (answer == DialogAction.REMOVE_SELECTION) {
            successRemoving = estabDataModel.remove(selectedItems);
            clear();
            if (successRemoving) update();
        } else {
            LOG.log(Level.INFO, "Remove canceled");
        }
        return successRemoving;
    }

    public void saveDataModel(File file) {
        estabDataModel.saveToFile(file);
    }

    public void clear() {
        searchResultsListView.getItems().clear();
//        editorPane.setVisible(false);
        setTitle();
        if (elementEditorController != null) elementEditorController.clear();
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
            String filename = activeFile == null ? "" : activeFile.getName();
            title = String.format(title + " %s | %d Sides | %d Images | %d Vehicles | %d Weapons | %d Ammo", filename, sides, images, vehicles, weapons, ammo);
        }
        estabDataPane.setText(title);
    }

    public void setFile(File file) {
        this.activeFile = file;
    }

    public File getActiveFile() {
        return activeFile;
    }

    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    /**
     * File has to be set first in order to display the correct title
     *
     * @param file
     */
    public void setEstabDataModel(File file) {
        setFile(file);
        setEstabDataModel(new EstabDataModel(file));
    }

    public MainController getMainController() {
        return mainController;
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public ElementModel getActiveElement() {
        return activeElement;
    }

    /**
     * Displays an element in the editor pane
     *
     * @param elementModel element to be displayed
     */
    public void setActiveElement(ElementModel elementModel) {
        if (null != elementModel) {
            Class elementClass = elementModel.getClass();
            AnchorPane editorNode = null;
            // If the current element isn't set (null) or it's from other class than the one we want to display
            // then update the editor
            if (activeElement == null || !activeElement.getClass().equals(elementClass)) {
                editorPane.getChildren().clear();
                // if we have saved the controller and editorPane, use them; else load them
                if (elementEditorPanes.containsKey(elementClass) && elementEditorControllers.containsKey(elementClass)) {
                    //TODO: this actually never worked before, because of next TODO down here
                    editorPane = elementEditorPanes.get(elementClass);
                    elementEditorController = elementEditorControllers.get(elementClass);
                } else {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(elementEditorViews.get(elementClass)));
                    try {
                        editorNode = fxmlLoader.load();
                        editorPane.getChildren().addAll(editorNode.getChildren());
                        elementEditorPanes.put(elementClass, editorNode);
                        elementEditorController = fxmlLoader.getController();
                        elementEditorController.setEditable(isEditable);
                        elementEditorController.setEstabDataController(this);
                        // TODO: this line was missing, so only the else block was executing
                        // elementEditorControllers.put(elementClass, elementEditorController);
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

    public EstabDataModel getEstabDataModel() {
        return estabDataModel;
    }

    public void setEstabDataModel(EstabDataModel estabDataModel) {
        this.estabDataModel = estabDataModel;
        searchTextField.setDisable(false);
        update();
    }

    public ListView<EstabListCell> getSearchResultsListView() {
        return searchResultsListView;
    }

    public BooleanProperty searchDisableProperty(){
        return searchDisable;
    }

    public void setSearchDisableProperty(boolean b) {
        this.searchDisable.set(b);
    }
}


