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
    private Button removeSelectedButton;
    @FXML
    private Button copySelectedButton;
    @FXML
    private TreeView<ElementListCell> searchResultsTreeView;

    @FXML
    private ListView<ElementListCell> searchResultsListView;
    private ObservableList<ElementListCell> elementListCells = FXCollections.observableArrayList();
    private ObservableList<ElementModel> selectedListElements = FXCollections.observableArrayList();
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
        selectedListElements.addListener((ListChangeListener<ElementModel>) change -> {
            if (selectedListElements.isEmpty()) {
                copySelectedButton.setDisable(true);
                removeSelectedButton.setDisable(true);
            } else {
                // if this is the source estab AND copy isn't disabled, enable copy. Do the same if this is the target estab.
                if(!isEditable && !mainController.disableCopyProperty().get() || isEditable) copySelectedButton.setDisable(false);
                // Since removeSelectedButton isn't visible in the source estab we don't need conditions
                removeSelectedButton.setDisable(false);
            }
        });

        // Select all items or discard all the selection
        selectAllListCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(true));
            else {
                // It's important to clear the collection first in order to optimize deselecting cells.
                selectedListElements.clear();
                searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
                selectAllListCheckBox.setSelected(false);
            }

        });

        // Hide the root node
        searchResultsTreeView.setShowRoot(false);
        //Since Force is the default class, hide the ListVIew and display the TreeView
        searchResultsTreeView.setVisible(true);
        searchResultsListView.setVisible(false);
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
        });

        ((ImageView) forceButton.getGraphic()).setImage(new Image(FileIO.FORCE_ICON_RESOURCE));
        ((ImageView) vehicleButton.getGraphic()).setImage(new Image(FileIO.VEHICLE_ICON_RESOURCE));
        ((ImageView) weaponButton.getGraphic()).setImage(new Image(FileIO.WEAPON_ICON_RESOURCE));
        ((ImageView) ammoButton.getGraphic()).setImage(new Image(FileIO.AMMO_ICON_RESOURCE));
        ((ImageView) copySelectedButton.getGraphic()).setImage(new Image(FileIO.COPY_ICON_RESOURCE));
        ((ImageView) removeSelectedButton.getGraphic()).setImage(new Image(FileIO.REMOVE_ICON_RESOURCE));
    }

    /**
     * Easy way to set a few initial parameters
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
        selectedListElements.clear();
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
        searchResultsTreeView.setVisible(true);
        searchResultsListView.setVisible(false);
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
        searchResultsTreeView.setVisible(false);
        searchResultsListView.setVisible(true);
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
        searchResultsTreeView.setVisible(false);
        searchResultsListView.setVisible(true);
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
        searchResultsTreeView.setVisible(false);
        searchResultsListView.setVisible(true);
        searchElement();
    }

    /**
     * Searches for elements from the active class matching the name pattern.
     */
    private void searchElement() {
        String query = searchTextField.getText();
        if (activeSearchListClass == ForceModel.class) {
            treeSearch(query);
        } else {
            listSearch(query);
        }
    }

    private void treeSearch(String query) {
        List<ElementModel> elements = estabModel.searchElement(query, activeSearchListClass);
        if (!elements.isEmpty()) {
            Map<Integer, TreeItem<ElementListCell>> sides = new HashMap<>();
            Map<Integer, TreeItem<ElementListCell>> nations = new HashMap<>();
            Map<Integer, TreeItem<ElementListCell>> services = new HashMap<>();

            TreeItem<ElementListCell> root = new TreeItem<ElementListCell>();
            root.setExpanded(true);
            searchResultsTreeView.setRoot(root);

            for (ElementModel element : elements) {
                ElementListCell forceCell = new ElementListCell(element, selectedListElements);
                TreeItem<ElementListCell> forceTreeItem = new TreeItem<>(forceCell);
                ForceModel force = (ForceModel) element;

                // Check if the service node exists
                if (!services.containsKey(force.getService().getId())) {
                    // if it doesn't, check its nation
                    if (!nations.containsKey(force.getService().getNation().getId())) {
                        // same with its side
                        if (!sides.containsKey(force.getService().getNation().getSide().getId())) {
                            ElementModel sideElement = force.getService().getNation().getSide();
                            ElementListCell sideCell = new ElementListCell(sideElement, selectedListElements);
                            TreeItem<ElementListCell> sideTreeItem = new TreeItem<>(sideCell);
                            sideTreeItem.setExpanded(true);
                            
                            // Add the side to the root node
                            sides.put(sideElement.getId(), sideTreeItem);
                            root.getChildren().add(sideTreeItem);
                        }
                        // assert sides.containsKey(force.getService().getNation().getSide().getId());
                        ElementModel nationElement = force.getService().getNation();
                        ElementListCell nationCell = new ElementListCell(nationElement, selectedListElements);
                        TreeItem<ElementListCell> nationTreeItem = new TreeItem<>(nationCell);
                        nationTreeItem.setExpanded(true);

                        // Add the nation to its side
                        nations.put(nationElement.getId(), nationTreeItem);
                        sides.get(force.getService().getNation().getSide().getId()).getChildren().add(
                                nations.get(force.getService().getNation().getId()));
                    }
                    // assert nations.containsKey(force.getService().getNation().getId());
                    ElementModel serviceElement = force.getService();
                    ElementListCell serviceCell = new ElementListCell(serviceElement, selectedListElements);
                    TreeItem<ElementListCell> serviceTreeItem = new TreeItem<>(serviceCell);
                    serviceTreeItem.setExpanded(true);

                    // Add the service to its nation
                    services.put(serviceElement.getId(), serviceTreeItem);
                    nations.get(force.getService().getNation().getId()).getChildren().add(
                            services.get(force.getService().getId())
                    );
                }
                // assert services.containsKey(force.getService().getId());
                services.get(force.getService().getId()).getChildren().add(forceTreeItem);
                }
            }
        }

    private void listSearch(String query) {
        SavedSearchList<ElementListCell> savedList = searchLists.get(activeSearchListClass);
        // Empty the search list
        elementListCells.clear();
        // If the search isn't forced and we have already searched for this text, copy the contents from the saved list
        if (!savedList.isForceSearch() && query.equals(savedList.getLastSearch())) {
            elementListCells.addAll(savedList.getList());
        } else {
            // This is a new search, prepare for it!
            savedList.getList().clear();
            savedList.setForceSearch(false);
            savedList.setLastSearch(query);

            // Get all elements with names matching our texts
            List<ElementModel> elements = estabModel.searchElement(query, activeSearchListClass);
            for (ElementModel element : elements) {
                ElementListCell cell = new ElementListCell(element, selectedListElements);
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
                    estabModel.paste(selectedListElements);
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
        removeRelatedElements(estabModel.getRelatedElements(selectedListElements).getAllElements());
        selectedListElements.clear();
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
            duplicateSelectedElements(selectedListElements);
        } else {
            // Source, copy
            mainController.copyElementsToTarget(selectedListElements);
        }
        selectedListElements.clear();
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


