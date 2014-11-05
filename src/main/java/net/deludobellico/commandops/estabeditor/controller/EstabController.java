package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.SavedSearchList;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;
import net.deludobellico.commandops.estabeditor.util.view.ElementListCell;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This controller manages the elements searches and invokes the editors when one is selected.
 * Estabs are either loaded as source (read only mode) or target (write mode), which is defined by {@link #isEditable}
 *
 * @author Mario
 * @author Heine
 */
public class EstabController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabController.class.getName());
    private static final Map<Class, String> ELEMENT_EDITOR_VIEWS = Collections.unmodifiableMap(new HashMap<Class, String>() {{
        put(VehicleModel.class, FileIO.VEHICLE_VIEW);
        put(WeaponModel.class, FileIO.WEAPON_VIEW);
        put(AmmoModel.class, FileIO.AMMO_VIEW);
    }});

    @FXML
    private TitledPane estabPane;
    /**
     * Where the element editors are loaded
     */
    @FXML
    private AnchorPane editorPane;

    /**
     * Buttons filter searches by element
     */
    @FXML
    private ToggleButton vehicleButton;
    @FXML
    private ToggleButton weaponButton;
    @FXML
    private ToggleButton ammoButton;
    @FXML
    private ImageView vehicleButtonImageView;
    @FXML
    private ImageView weaponButtonImageView;
    @FXML
    private ImageView ammoButtonImageView;

    /**
     * Where part or all of the element name is typed to search
     */
    @FXML
    private TextField searchTextField;

    @FXML
    private ListView<ElementListCell> searchResultsListView;

    private ObservableList<ElementListCell> elementListCells = FXCollections.observableArrayList();

    // Controls when search is enabled
    private BooleanProperty searchDisable = new SimpleBooleanProperty(true);
    // Current search list elements class, Vehicle is the default
    private Class activeSearchListClass = VehicleModel.class;
    // Save last search to avoid consuming unnecessary resources
    private Map<Class, SavedSearchList<ElementListCell>> searchLists = new HashMap<Class, SavedSearchList<ElementListCell>>() {{
        for (Class elementModelClass : ELEMENT_EDITOR_VIEWS.keySet()) {
            put(elementModelClass, new SavedSearchList<>());
        }
    }};

    // Save loaded views, controllers and panes (editor panes have to be AnchorPanes)
    private Map<Class, ElementEditorController> elementEditorControllers = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());
    private Map<Class, AnchorPane> elementEditorPanes = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());

    // Main controller, current element editor (either vehicle, weapon or ammo) and estab model (source or target)
    private MainController mainController = null;
    private ElementEditorController elementEditorController = null;
    private EstabModel estabModel;

    // Source estab data isn't editable, target estab data is editable
    private boolean isEditable = false;

    // Active element = element currently displayed
    private ElementModel activeElement = null;
    private File activeFile = null;

    /**
     * Adds listeners to components and sets the initial item collections.
     *
     * @param url            is not used
     * @param resourceBundle is not used
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Listen to changes in the search text and search matching elements name
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> searchElement(null));

        // Each cell has a button (to copy or remove), and are associated to an element
        searchResultsListView.setItems(elementListCells);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // If we select and item, display it
            if (newValue != null) setActiveElement(newValue.getElementModel());
        });

        // Disable buttons when search is disabled
        vehicleButton.disableProperty().bind(searchDisable);
        weaponButton.disableProperty().bind(searchDisable);
        ammoButton.disableProperty().bind(searchDisable);

        vehicleButtonImageView.setImage(new Image(FileIO.VEHICLE_ICON_RESOURCE));
        weaponButtonImageView.setImage(new Image(FileIO.WEAPON_ICON_RESOURCE));
        ammoButtonImageView.setImage(new Image(FileIO.AMMO_ICON_RESOURCE));
    }

    /**
     * Easy way to set a few parameters
     *
     * @param title
     * @param isEditable
     * @param controller
     */
    public void init(String title, boolean isEditable, MainController controller) {
        setTitle(title);
        setEditable(isEditable);
        setMainController(controller);
    }

    /**
     * Updates the estab by refreshing the title and forcing searches.
     */
    public void update() {
        searchLists.values().stream().forEach(s -> s.setForceSearch(true));
        setTitle();
        if (estabModel != null) searchElement(null);
    }

    /**
     * Clears the active editor, empties the search list and refreshes the title
     */
    public void clear() {
        searchResultsListView.getItems().clear();
        setTitle();
        if (elementEditorController != null) elementEditorController.clear();
    }

    /**
     * Filters the search list with vehicles only
     *
     * @param actionEvent is not used
     */
    @FXML
    private void searchVehicle(ActionEvent actionEvent) {
        activeSearchListClass = VehicleModel.class;
        searchTextField.setPromptText("Search vehicle");
        vehicleButton.setSelected(true);
        weaponButton.setSelected(false);
        ammoButton.setSelected(false);
        searchElement(null);
    }

    /**
     * Filters the search list with weapons only
     *
     * @param actionEvent is not used
     */
    @FXML
    private void searchWeapon(ActionEvent actionEvent) {
        activeSearchListClass = WeaponModel.class;
        searchTextField.setPromptText("Search weapon");
        vehicleButton.setSelected(false);
        weaponButton.setSelected(true);
        ammoButton.setSelected(false);
        searchElement(null);
    }

    /**
     * Filters the search list with ammo only
     *
     * @param actionEvent is not used
     */
    @FXML
    private void searchAmmo(ActionEvent actionEvent) {
        activeSearchListClass = AmmoModel.class;
        searchTextField.setPromptText("Search ammo");
        vehicleButton.setSelected(false);
        weaponButton.setSelected(false);
        ammoButton.setSelected(true);
        searchElement(null);
    }

    /**
     * Searches for elements from the active class matching the name pattern.
     *
     * @param actionEvent is not used
     */
    private void searchElement(ActionEvent actionEvent) {
        SavedSearchList<ElementListCell> savedList = searchLists.get(activeSearchListClass);
        String textToSearch = searchTextField.getText();

        // Empty the search list
        elementListCells.clear();
        // If the search isn't forced and we have already searched for this text, copy the contents from the saved list
        if (!savedList.isForceSearch() && textToSearch.equals(savedList.getLastSearch())) {
            elementListCells.addAll(savedList.getList());
        } else {
            // This is a new search, prepare for it!
            savedList.getList().clear();
            savedList.setForceSearch(false);
            savedList.setLastSearch(textToSearch);

            // This passes the method to invoke when pressing a button from the search list
            Consumer<ElementModel> buttonAction;
            // This property handles when buttons should be disabled
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
            // Get all elements with names matching our texts
            List<ElementModel> elements = estabModel.searchElement(textToSearch, activeSearchListClass);
            for (ElementModel element : elements) {
                ElementListCell cell;
                cell = new ElementListCell(element, buttonAction, buttonDisableProperty, isEditable);
                elementListCells.add(cell);
                savedList.getList().add(cell);
            }
        }
    }

    /**
     * Copies elements into the model if possible.
     * If there are repated elements, promt the user for an action.
     *
     * @param relatedElementLists the lists containing the elements to copy.
     * @return true if elements were copied, false otherwise.
     * @see RelatedElementLists
     */
    public boolean copyRelatedElements(RelatedElementLists relatedElementLists) {
        if (!isEditable) return false;
        boolean successPasting;
        if (relatedElementLists.hasRepeatedElements()) {
            // if there are repeated elements, ask the user for what to do
            // In case the user only wants to select some items, pass this empty collection to save them
            Collection selectedItems = new ArrayList<>();
            DialogAction answer = UtilView.showWarningRepeatedElements(relatedElementLists.getRepeatedElements(), selectedItems);
            successPasting = this.estabModel.paste(relatedElementLists, answer, selectedItems);
        } else {
            // if there are no repeated elements, proceed as if overwriting
            successPasting = this.estabModel.paste(relatedElementLists, DialogAction.OVERWRITE, null);
        }
        if (successPasting) update();
        return successPasting;
    }

    /**
     * Removes elements from the model if possible.
     * If there are repated elements, promt the user for an action.
     *
     * @param relatedElements this lists containing the elements to remove.
     * @return true if elements were removed, false otherwise.
     * @see RelatedElementLists
     */
    public boolean removeRelatedElements(RelatedElementLists relatedElements) {
        List<ElementModel> elementsToRemoveList = relatedElements.getAllElements();

        // In case the user only wants to select some items, pass this empty collection to save them
        Collection selectedItems = new ArrayList<>();
        DialogAction answer = UtilView.showWarningRemoveElements(elementsToRemoveList, selectedItems);
        boolean successRemoving;
        if (answer == DialogAction.OK) {
            // Remove all elements
            // In case the removed element is active in the editor
            // TODO: decide if this condition should be checked in the model
            for (ElementModel e : elementsToRemoveList)
                if (activeElement !=null && e.getId() == activeElement.getId()) {
                    clear();
                    break;
                }
            successRemoving = estabModel.remove(relatedElements);
        } else if (answer == DialogAction.REMOVE_SELECTION) {
            // Remove only selected elements by the user
            // In case the removed element is active in the editor
            for (ElementModel e : elementsToRemoveList)
                if (activeElement !=null && e.getId() == activeElement.getId()) {
                    clear();
                    break;
                }
            successRemoving = estabModel.remove(selectedItems);
        } else if (answer == DialogAction.MARK_SELECTION) {
            // Mark the items with the REMOVE flag instead of removing the elements
            LOG.log(Level.INFO, "Remove canceled, elements were marked for removal");
            selectedItems.stream().forEach(i -> ((ElementModel) i).setFlag(Flag.REMOVE));
            successRemoving = false;
            update();
        } else {
            LOG.log(Level.INFO, "Remove canceled");
            return false;
        }
        if (successRemoving) update();
        return successRemoving;
    }

    /**
     * Saves the estab to disk.
     *
     * @param file where the estab will be saved
     */
    public void saveModel(File file) {
        estabModel.saveToFile(file);
    }

    /**
     * Sets the title depending if this is a source or target estab
     */
    public void setTitle() {
        setTitle(isEditable ? "Target Estab" : "Source Estab");
    }

    /**
     * Sets the title with the estab file name and the elements it contains.
     *
     * @param title initial string which will have the info appended
     */
    public void setTitle(String title) {
        if (estabModel != null) {
            title = title.split("\\|")[0];
            int sides = estabModel.getSides().size();
            int images = estabModel.getImages().size();
            int vehicles = estabModel.getVehicles().size();
            int weapons = estabModel.getVehicles().size();
            int ammo = estabModel.getAmmo().size();
            String filename = activeFile == null ? "" : activeFile.getName();
            title = String.format(title + " %s | %d Sides | %d Images | %d Vehicles | %d Weapons | %d Ammo", filename, sides, images, vehicles, weapons, ammo);
        }
        estabPane.setText(title);
    }

    /**
     * Sets the estab file.
     *
     * @param file estab file
     */
    public void setFile(File file) {
        this.activeFile = file;
    }

    public File getActiveFile() {
        return activeFile;
    }

    /**
     * @param isEditable
     * @see ElementEditorController#setEditable(boolean)
     */
    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
    }

    /**
     * Loads an estab model from disk.
     *
     * @param file where the estab is saved
     */
    public void setEstabModel(File file) {
        // File has to be set first in order to display the correct title
        setFile(file);
        setEstabModel(new EstabModel(file));
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
     * Displays an element in the editor pane.
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
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ELEMENT_EDITOR_VIEWS.get(elementClass)));
                    try {
                        // Load the editor pane from the fxml and copy the contents
                        editorNode = fxmlLoader.load();
                        editorPane.getChildren().addAll(editorNode.getChildren());

                        elementEditorPanes.put(elementClass, editorNode);
                        elementEditorController = fxmlLoader.getController();
                        elementEditorController.setEditable(isEditable);
                        elementEditorController.setEstabController(this);
                        // TODO: this line was missing, so only the else block was executing
                        // elementEditorControllers.put(elementClass, elementEditorController);
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NullPointerException e) {
                        e.printStackTrace();
                    }
                }
            }
            elementEditorController.setActiveElement(elementModel);
            activeElement = elementModel;
        }
    }

    public EstabModel getEstabModel() {
        return estabModel;
    }

    public void setEstabModel(EstabModel estabModel) {
        this.estabModel = estabModel;
        searchTextField.setDisable(false);
        update();
    }

    public ListView<ElementListCell> getSearchResultsListView() {
        return searchResultsListView;
    }

    public BooleanProperty searchDisableProperty() {
        return searchDisable;
    }

    public void setSearchDisableProperty(boolean b) {
        this.searchDisable.set(b);
    }
}


