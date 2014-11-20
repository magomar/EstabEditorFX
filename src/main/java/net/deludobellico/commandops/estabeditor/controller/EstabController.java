package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
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
        put(ForceModel.class, FileIO.FORCE_VIEW);
        put(VehicleModel.class, FileIO.VEHICLE_VIEW);
        put(WeaponModel.class, FileIO.WEAPON_VIEW);
        put(AmmoModel.class, FileIO.AMMO_VIEW);
    }});
    // Active element = element currently displayed
    private final ObjectProperty<ElementModel> activeElement = new SimpleObjectProperty<>();
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
    private ToggleButton forceButton;
    @FXML
    private ToggleButton vehicleButton;
    @FXML
    private ToggleButton weaponButton;
    @FXML
    private ToggleButton ammoButton;
    /**
     * Where part or all of the element name is typed to search
     */
    @FXML
    private TextField searchTextField;
    @FXML
    private CheckBox selectAllListCheckBox;
    @FXML
    private CheckBox selectNoneListCheckBox;
    @FXML
    private Button removeSelectedButton;
    @FXML
    private Button copySelectedButton;
    @FXML
    private ListView<ElementListCell> searchResultsListView;
    private ObservableList<ElementListCell> elementListCells = FXCollections.observableArrayList();
    private ObservableList<ElementModel> selectedElements = FXCollections.observableArrayList();
    // Controls when search is enabled
    private BooleanProperty searchDisable = new SimpleBooleanProperty(true);
    // Current search list elements class, Force is the default
    private Class activeSearchListClass = ForceModel.class;
    // Save last search to avoid consuming unnecessary resources
    private Map<Class, SavedSearchList<ElementListCell>> searchLists = new HashMap<Class, SavedSearchList<ElementListCell>>() {{
        for (Class elementModelClass : ELEMENT_EDITOR_VIEWS.keySet()) {
            put(elementModelClass, new SavedSearchList<>());
        }
    }};
    // Save loaded views, controllers and panes (editor panes have to be AnchorPanes)
    private Map<Class, ElementEditorController<ElementModel>> elementEditorControllers = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());
    private Map<Class, Integer> editorPaneChildrenIndex = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());
    // Main controller, current element editor (either vehicle, weapon or ammo) and estab model (source or target)
    private MainController mainController = null;
    private ElementEditorController<ElementModel> elementEditorController = null;
    private EstabModel estabModel;
    // Source estab data isn't editable, target estab data is editable
    private boolean isEditable = false;
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
        searchTextField.textProperty().addListener((observable, oldValue, newValue) -> searchElement());

        // Disable copy and remove buttons if there are no selected items
        selectedElements.addListener((ListChangeListener<ElementModel>) change -> {
            if (selectedElements.isEmpty()) {
                copySelectedButton.setDisable(true);
                removeSelectedButton.setDisable(true);
            } else {
                selectNoneListCheckBox.setSelected(false);
                removeSelectedButton.setDisable(false);
                copySelectedButton.setDisable(false);
            }
        });

        // Select all items or discard all the selection
        selectAllListCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(true));
            selectNoneListCheckBox.setSelected(!newValue);

        });
        selectNoneListCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // It's important to clear the collection first in order to optimize deselecting cells.
                selectedElements.clear();
                searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
                selectAllListCheckBox.setSelected(false);
            }
        });

        // Each cell is associated to an element model
        searchResultsListView.setItems(elementListCells);
        searchResultsListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // If we select and item, display it
            if (newValue != null) setActiveElement(newValue.getElementModel());
        });

        // Disable buttons when search is disabled
        searchDisable.addListener((observable, oldValue, newValue) -> {
            forceButton.setDisable(newValue);
            vehicleButton.setDisable(newValue);
            weaponButton.setDisable(newValue);
            ammoButton.setDisable(newValue);
            searchTextField.setDisable(newValue);
            selectAllListCheckBox.setDisable(newValue);
            selectNoneListCheckBox.setDisable(newValue);
        });

        ((ImageView) forceButton.getGraphic()).setImage(new Image(FileIO.FORCE_ICON_RESOURCE));
        ((ImageView) vehicleButton.getGraphic()).setImage(new Image(FileIO.VEHICLE_ICON_RESOURCE));
        ((ImageView) weaponButton.getGraphic()).setImage(new Image(FileIO.WEAPON_ICON_RESOURCE));
        ((ImageView) ammoButton.getGraphic()).setImage(new Image(FileIO.AMMO_ICON_RESOURCE));
        ((ImageView) copySelectedButton.getGraphic()).setImage(new Image(FileIO.COPY_ICON_RESOURCE));
        ((ImageView) removeSelectedButton.getGraphic()).setImage(new Image(FileIO.REMOVE_ICON_RESOURCE));
    }

    /**
     * Easy way to set a few parameters
     *
     * @param title      title of the estab pane
     * @param isEditable true if the estab is editable, false otherwise
     * @param controller the parent controller
     */
    public void init(String title, boolean isEditable, MainController controller) {
        setTitle(title);
        setEditable(isEditable);
        setMainController(controller);
        if (!isEditable) {
            removeSelectedButton.setVisible(false);
        }
    }

    /**
     * Updates the estab by refreshing the title and forcing searches.
     */
    void update() {
        searchLists.values().stream().forEach(s -> s.setForceSearch(true));
        setTitle();
        if (estabModel != null) searchElement();
    }

    /**
     * Clears the active editor, empties the search list and refreshes the title
     */
    public void clear() {
        selectedElements.clear();
        searchResultsListView.getItems().clear();
        setTitle();
        if (elementEditorController != null) elementEditorController.clear();
    }

    /**
     * Filters the search list with forces only
     */
    @FXML
    private void searchForce() {
        activeSearchListClass = ForceModel.class;
        searchTextField.setPromptText("Search force");
        forceButton.setSelected(true);
        vehicleButton.setSelected(false);
        weaponButton.setSelected(false);
        ammoButton.setSelected(false);
        selectAllListCheckBox.setSelected(false);
        selectNoneListCheckBox.setSelected(false);
        searchElement();
    }

    /**
     * Filters the search list with vehicles only
     */
    @FXML
    private void searchVehicle() {
        activeSearchListClass = VehicleModel.class;
        searchTextField.setPromptText("Search vehicle");
        forceButton.setSelected(false);
        vehicleButton.setSelected(true);
        weaponButton.setSelected(false);
        ammoButton.setSelected(false);
        selectAllListCheckBox.setSelected(false);
        selectNoneListCheckBox.setSelected(false);
        searchElement();
    }

    /**
     * Filters the search list with weapons only
     */
    @FXML
    private void searchWeapon() {
        activeSearchListClass = WeaponModel.class;
        searchTextField.setPromptText("Search weapon");
        vehicleButton.setSelected(false);
        weaponButton.setSelected(true);
        ammoButton.setSelected(false);
        selectAllListCheckBox.setSelected(false);
        selectNoneListCheckBox.setSelected(false);
        searchElement();
    }

    /**
     * Filters the search list with ammo only
     */
    @FXML
    private void searchAmmo() {
        activeSearchListClass = AmmoModel.class;
        searchTextField.setPromptText("Search ammo");
        vehicleButton.setSelected(false);
        weaponButton.setSelected(false);
        ammoButton.setSelected(true);
        selectAllListCheckBox.setSelected(false);
        selectNoneListCheckBox.setSelected(false);
        searchElement();
    }

    /**
     * Searches for elements from the active class matching the name pattern.
     */
    private void searchElement() {
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

            // Get all elements with names matching our texts
            List<ElementModel> elements = estabModel.searchElement(textToSearch, activeSearchListClass);
            for (ElementModel element : elements) {
                ElementListCell cell;
                cell = new ElementListCell(element, selectedElements);
                elementListCells.add(cell);
                savedList.getList().add(cell);
            }
        }
    }

    /**
     * Creates a new elements and displays it in the editor
     *
     * @param newElement instance of the element class to create
     */
    @SuppressWarnings("unchecked")
    public void createNewElement(ElementModel newElement) {
        newElement = (ElementModel) newElement.createNewInMap(estabModel.getAll().get(newElement.getClass()));
        setActiveElement(newElement);
        update();
    }

    /**
     * Copies elements into the model if possible.
     * If there are repeated elements, prompt the user for an action.
     *
     * @param relatedElementsLists the lists containing the elements to copy.
     * @return true if elements were copied, false otherwise.
     * @see RelatedElementsLists
     */
    public boolean copyRelatedElements(RelatedElementsLists relatedElementsLists) {
        if (!isEditable) return false;
        if (!relatedElementsLists.hasRepeatedElements()) {
            // If there are no repeated elements, proceed with the copy
            this.estabModel.paste(relatedElementsLists.getAllElements());

        } else {
            // If there are repeated elements, ask the user for what to do
            // In case the user only wants to select some items, pass this empty collection to save them
            Collection selectedItems = new ArrayList<>();
            DialogAction answer = UtilView.showWarningRepeatedElements(relatedElementsLists.getRepeatedElements(), selectedItems);
            switch (answer) {
                case OVERWRITE:
                    estabModel.paste(relatedElementsLists.getAllElements());
                    break;
                case SKIP_REPEATED:
                    assert relatedElementsLists.isDistributed();
                    estabModel.paste(relatedElementsLists.getNonRepeatedElements());
                    break;
                case COPY_SELECTION:
                    estabModel.paste(selectedElements);
                    break;
                default:
                    return false;
            }

        }
        update();
        return true;
    }

    /**
     * Removes elements from the model if possible.
     * If there are repeated elements, prompt the user for an action.
     *
     * @param elementsToRemove this lists containing the elements to remove.
     * @return true if elements were removed, false otherwise.
     * @see RelatedElementsLists
     */
    public boolean removeRelatedElements(List<ElementModel> elementsToRemove) {

        // In case the user only wants to select some items, pass this empty collection to save them
        Collection<ElementModel> selectedItems = new ArrayList<>();
        // Prompt the user for an action
        DialogAction answer = UtilView.showWarningRemoveElements(elementsToRemove, selectedItems);

        switch (answer) {
            case OK:
                // Remove all elements
                if (elementsToRemove.contains(activeElement.get())) clear();
                estabModel.remove(elementsToRemove);
                break;
            case REMOVE_SELECTION:
                // Remove only selected elements by the user
                if (elementsToRemove.contains(activeElement.get())) clear();
                estabModel.remove(selectedItems);
                break;
            case MARK_SELECTION:
                // Mark the items with the REMOVE flag instead of removing the elements
                selectedItems.stream().forEach(i -> i.setFlag(Flag.REMOVE));
                break;
            default:
                return false;
        }
        update();
        return true;
    }

    /**
     * Removes elements with selected check boxes
     */
    public void removeSelectedItems() {
        removeRelatedElements(estabModel.getRelatedElements(selectedElements).getAllElements());
        selectedElements.clear();
        searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
    }

    /**
     * Duplicates all the elements received in a collection
     *
     * @param selectedItems the collection containing the items to duplicate
     */
    void duplicateSelectedElements(Collection<ElementModel> selectedItems) {
        if (!isEditable) return;
        estabModel.duplicate(selectedItems);
        update();
    }

    /**
     * Copy elements with selected check boxes, or duplicates them if this is the target estab
     */
    public void copySelectedElements() {
        if (isEditable) {
            // Target, duplicate
            duplicateSelectedElements(selectedElements);
        } else {
            // Source, copy
            mainController.copyElementsToTarget(selectedElements);
        }
        selectedElements.clear();
        searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
    }

    /**
     * Saves the estab to disk.
     *
     * @param file where the estab will be saved
     */
    public void saveModel(File file) {
        if (!file.exists()) {
            UtilView.showInfoDialog("File not found", "", file.getName() + " doesn't exist");
            LOG.log(Level.WARNING, "Abort save. File not found " + file.getName());
        } else estabModel.saveToFile(file);
    }

    /**
     * Sets the title depending if this is a source or target estab
     */
    void setTitle() {
        setTitle(isEditable ? "Target Estab" : "Source Estab");
    }

    /**
     * Sets the title with the estab file name and the elements it contains.
     *
     * @param title initial string which will have the info appended
     */
    void setTitle(String title) {
        if (estabModel != null) {
            title = title.split("\\|")[0];
            int sides = estabModel.getSides().size();
            int images = estabModel.getImages().size();
            int vehicles = estabModel.getVehicles().size();
            int weapons = estabModel.getWeapons().size();
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
    void setFile(File file) {
        this.activeFile = file;
    }

    public File getActiveFile() {
        return activeFile;
    }

    /**
     * @param isEditable true true if the estab is editable, false otherwise
     * @see ElementEditorController#setEditable(boolean)
     */
    void setEditable(boolean isEditable) {
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

    void setMainController(MainController mainController) {
        this.mainController = mainController;
    }

    public ObjectProperty<ElementModel> getActiveElement() {
        return activeElement;
    }

    /**
     * Displays an element in the editor pane.
     *
     * @param element element to be displayed
     */
    void setActiveElement(ElementModel element) {
        if (null == element) return;

        Class elementClass = element.getClass();
        // If there's no active element or it's a different element class,
        if (activeElement.get() == null || !activeElement.get().getClass().equals(elementClass)) {
            // Hide the current editor
            hideActiveEditor();
            // If we have already loaded the new editor, show it; else load it
            if (elementEditorControllers.containsKey(elementClass)) {
                showEditor(elementClass);
                elementEditorController = elementEditorControllers.get(elementClass);
            } else loadNewEditor(elementClass);
        }
        elementEditorController.setActiveElement(element);
        activeElement.set(element);
    }

    /**
     * Hides the active editor, if it isn't null
     */
    private void hideActiveEditor() {
        if (!editorPane.getChildren().isEmpty() && activeElement.get() != null) {
            int editorIndex = editorPaneChildrenIndex.get(activeElement.get().getClass());
            assert editorIndex >= 0;
            editorPane.getChildren().get(editorIndex).setVisible(false);
        }
    }

    /**
     * Sets visible an element editor
     *
     * @param elementClass element class of the editor
     */
    private void showEditor(Class elementClass) {
        int editorIndex = editorPaneChildrenIndex.get(elementClass);
        assert editorIndex >= 0;
        editorPane.getChildren().get(editorIndex).setVisible(true);
    }

    /**
     * Loads the element editor FXML view
     *
     * @param elementClass element class of the editor
     */
    private void loadNewEditor(Class elementClass) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ELEMENT_EDITOR_VIEWS.get(elementClass)));
        try {
            // Load the editor pane from the fxml and copy the contents
            AnchorPane editorNode = fxmlLoader.load();
            // Save the index of the editor pane children list
            editorPaneChildrenIndex.put(elementClass, editorPane.getChildren().size());
            editorPane.getChildren().addAll(editorNode.getChildren());
            // Load and save the controller
            elementEditorController = fxmlLoader.getController();
            elementEditorController.setEditable(isEditable);
            elementEditorController.setEstabController(this);
            elementEditorControllers.put(elementClass, elementEditorController);
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
        }
    }

    public EstabModel getEstabModel() {
        return estabModel;
    }

    public void setEstabModel(EstabModel estabModel) {
        this.estabModel = estabModel;
        update();
    }

    public ListView<ElementListCell> getSearchResultsListView() {
        return searchResultsListView;
    }

    public BooleanProperty searchDisableProperty() {
        return searchDisable;
    }


}


