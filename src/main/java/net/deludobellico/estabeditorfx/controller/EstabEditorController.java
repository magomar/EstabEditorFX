package net.deludobellico.estabeditorfx.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;
import net.deludobellico.estabeditorfx.model.*;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.SavedSearchList;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.ViewUtil;

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
public class EstabEditorController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabEditorController.class.getName());
    private static final Map<Class, String> ELEMENT_EDITOR_VIEWS = Collections.unmodifiableMap(new HashMap<Class, String>() {{
        put(ForceModel.class, FileIO.FORCE_VIEW);
        put(VehicleModel.class, FileIO.VEHICLE_VIEW);
        put(WeaponModel.class, FileIO.WEAPON_VIEW);
        put(AmmoModel.class, FileIO.AMMO_VIEW);
        put(SideModel.class, FileIO.SIDE_VIEW);
        put(NationModel.class, FileIO.NATION_VIEW);
        put(ServiceModel.class, FileIO.SERVICE_VIEW);
    }});

    @FXML
    private Label estabInfo;

    /**
     * Where the element editors are loaded
     */
    @FXML
    private AnchorPane editorPaneHook;
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
    private ObservableList<ElementModel> selectedElements = FXCollections.observableArrayList();
    // Controls when search is enabled
    private BooleanProperty searchDisable = new SimpleBooleanProperty(true);
    // Current search list elements class, Force is the default
    private Class activeSearchClass = ForceModel.class;
    // Save last search to avoid consuming unnecessary resources
    private Map<Class, SavedSearchList<ElementListCell>> searchLists = new HashMap<Class, SavedSearchList<ElementListCell>>() {{
        for (Class elementModelClass : ELEMENT_EDITOR_VIEWS.keySet()) {
            put(elementModelClass, new SavedSearchList<>());
        }
    }};
    // Active element = element currently displayed
    private final ObjectProperty<ElementModel> activeElement = new SimpleObjectProperty<>();
    // Save loaded views, controllers and panes (editor panes have to be AnchorPanes)
    private Map<Class, ElementEditorController<ElementModel>> elementEditorControllers = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());
    private Map<Class, Integer> editorPaneChildrenIndex = new HashMap<>(ELEMENT_EDITOR_VIEWS.size());
    // Main controller
    private MainController mainController = null;
    // current element editor (either vehicle, weapon or ammo)
    private ElementEditorController<ElementModel> elementEditorController = null;
    // estab model (source or target)
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
                // if this is the source estab AND there is an open target, enable copy. Do the same if this is the target estab.
                if (!isEditable && !mainController.targetIsClosedProperty().get() || isEditable)
                    copySelectedButton.setDisable(false);
                // Since removeSelectedButton isn't visible in the source estab we don't need conditions
                removeSelectedButton.setDisable(false);
            }
        });

        // Select all items or discard all the selection
        selectAllListCheckBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                // If it's the search list, select all the cells
                if (activeSearchClass != ForceModel.class) {
                    searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(true));
                    // If it's the tree search, then select root children (and let the cascade selection begin)
                } else if (!searchResultsTreeView.getRoot().getChildren().isEmpty())
                    for (TreeItem<ElementListCell> treeItem : searchResultsTreeView.getRoot().getChildren())
                        treeItem.getValue().selectedProperty().setValue(true);
            } else {
                // It's important to clear the collection first in order to optimize deselecting cells.
                selectedElements.clear();
                if (activeSearchClass != ForceModel.class) {
                    searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
                } else if (!searchResultsTreeView.getRoot().getChildren().isEmpty())
                    for (TreeItem<ElementListCell> treeItem : searchResultsTreeView.getRoot().getChildren())
                        treeItem.getValue().selectedProperty().setValue(false);
            }
//                selectAllListCheckBox.setSelected(false);
        });

        // Hide the root tree node
        searchResultsTreeView.setShowRoot(false);
        searchResultsTreeView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TreeItem<ElementListCell>>() {
            @Override
            public void changed(ObservableValue<? extends TreeItem<ElementListCell>> observable, TreeItem<ElementListCell> oldValue, TreeItem<ElementListCell> newValue) {
                if(newValue != null) setActiveElement(newValue.getValue().getElementModel());
            }
        });

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
    public void update() {
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
        searchResultsTreeView.getRoot().getChildren().clear();
        setTitle();
        if (elementEditorController != null) elementEditorController.clear();
    }

    /**
     * Filters the search list with forces only
     */
    @FXML
    private void searchForce() {
        activeSearchClass = ForceModel.class;
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
        activeSearchClass = VehicleModel.class;
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
        activeSearchClass = WeaponModel.class;
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
        activeSearchClass = AmmoModel.class;
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
     * Searches for elements from the active class with names matching the user query
     */
    private void searchElement() {
        String query = searchTextField.getText();
        // If we're looking for forces, display the results in a tree view. Otherwise, use a list view
        if (activeSearchClass == ForceModel.class) {
            treeSearch(query);
        } else {
            listSearch(query);
        }
    }

    /**
     * Display search results in a list view
     *
     * @param query string to look for in elements names
     */
    private void listSearch(String query) {
        SavedSearchList<ElementListCell> savedList = searchLists.get(activeSearchClass);
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

            // Get all elements with names matching our query
            List<ElementModel> elements = estabModel.searchElement(query, activeSearchClass);
            for (ElementModel element : elements) {
                ElementListCell cell = new ElementListCell(element, selectedElements);
                elementListCells.add(cell);
                savedList.getList().add(cell);
            }
        }
    }

    /**
     * Display search results in a tree view (Forces/Services/Nations/Sides)
     *
     * @param query string to look for in elements names
     */
    private void treeSearch(String query) {
        List<ElementModel> matchedQueryElements = estabModel.searchElement(query, activeSearchClass);
        TreeItem<ElementListCell> rootNode = new TreeItem<>();
        rootNode.setExpanded(true);
        searchResultsTreeView.setRoot(rootNode);
        if (!matchedQueryElements.isEmpty()) {
            Map<Integer, TreeItem<ElementListCell>> sidesMap = new HashMap<>(); // Could be all in the same map, since IDs are unique
            Map<Integer, TreeItem<ElementListCell>> nationsMap = new HashMap<>();
            Map<Integer, TreeItem<ElementListCell>> servicesMap = new HashMap<>();

            for (ElementModel element : matchedQueryElements) {
                ElementListCell forceCell = new ElementListCell(element, selectedElements);
                TreeItem<ElementListCell> forceTreeItem = new TreeItem<>(forceCell);
                ForceModel force = (ForceModel) element;

                // make sure this force's side, nation and service exist
                updateServicesMap(force, sidesMap, nationsMap, servicesMap, rootNode);
                // assert services.containsKey(force.getService().getId());
                servicesMap.get(force.getService().getId()).getChildren().add(forceTreeItem);
            }
        }
    }

    /**
     * Adds a listener to a TreeItem<ElementListCell> which spreads the checkbox status to its children
     *
     * @param treeItem where we'll add the listener
     */
    private void cascadeBind(TreeItem<ElementListCell> treeItem){
        treeItem.getValue().selectedProperty().addListener((observable, oldValue, newValue) -> {
            for (TreeItem<ElementListCell> child : treeItem.getChildren()) {
                child.getValue().selectedProperty().setValue(treeItem.getValue().selectedProperty().getValue());
            }
        });
    }

    /**
     * Adds a TreeItem Side to a Map if it doesn't exist already
     *
     * @param force
     * @param sidesMap
     * @param root
     */
    private void updateSidesMap(ForceModel force, Map<Integer, TreeItem<ElementListCell>> sidesMap, TreeItem<ElementListCell> root) {
        if (!sidesMap.containsKey(force.getService().getNation().getSide().getId())) {
            ElementModel sideElement = force.getService().getNation().getSide();
            ElementListCell sideCell = new ElementListCell(sideElement, selectedElements);
            TreeItem<ElementListCell> sideTreeItem = new TreeItem<>(sideCell);
            sideTreeItem.setExpanded(true);

            // Add the side to the root node
            sidesMap.put(sideElement.getId(), sideTreeItem);
            root.getChildren().add(sideTreeItem);

            // Bind the checkbox for cascade selection
            cascadeBind(sideTreeItem);
        }
    }

    /**
     * Adds a TreeItem Nation to a Map if it doesn't exist already
     *
     * @param force
     * @param nationsMap
     * @param sidesMap
     * @param rootNode
     */
    private void updateNationsMap(ForceModel force, Map<Integer, TreeItem<ElementListCell>> nationsMap, Map<Integer, TreeItem<ElementListCell>> sidesMap, TreeItem<ElementListCell> rootNode){
        if (!nationsMap.containsKey(force.getService().getNation().getId())) {
            // make sure this nation's side exist
            updateSidesMap(force, sidesMap, rootNode);
            // assert sides.containsKey(force.getService().getNation().getSide().getId());

            ElementModel nationElement = force.getService().getNation();
            ElementListCell nationCell = new ElementListCell(nationElement, selectedElements);
            TreeItem<ElementListCell> nationTreeItem = new TreeItem<>(nationCell);
            nationTreeItem.setExpanded(true);

            // Add the nation to its side
            nationsMap.put(nationElement.getId(), nationTreeItem);
            TreeItem<ElementListCell> sideTreeItem = sidesMap.get(force.getService().getNation().getSide().getId());
            sideTreeItem.getChildren().add(nationsMap.get(force.getService().getNation().getId()));

            // Bind the checkbox for cascade selection
            cascadeBind(nationTreeItem);
        }
    }

    /**
     * Adds a TreeItem Service to a Map if it doesn't exist already
     *
     * @param force
     * @param sidesMap
     * @param nationsMap
     * @param servicesMap
     * @param rootNode
     */
    private void updateServicesMap(ForceModel force, Map<Integer, TreeItem<ElementListCell>> sidesMap, Map<Integer, TreeItem<ElementListCell>> nationsMap, Map<Integer, TreeItem<ElementListCell>> servicesMap, TreeItem<ElementListCell> rootNode){
        if (!servicesMap.containsKey(force.getService().getId())) {
            // if it doesn't, check its nation
            updateNationsMap(force, nationsMap, sidesMap, rootNode);
            // assert nations.containsKey(force.getService().getNation().getId());
            ElementModel serviceElement = force.getService();
            ElementListCell serviceCell = new ElementListCell(serviceElement, selectedElements);
            TreeItem<ElementListCell> serviceTreeItem = new TreeItem<>(serviceCell);
            serviceTreeItem.setExpanded(true);

            // Add the service to its nation
            servicesMap.put(serviceElement.getId(), serviceTreeItem);
            TreeItem<ElementListCell> nationTreeItem = nationsMap.get(force.getService().getNation().getId());
            nationTreeItem.getChildren().add(servicesMap.get(force.getService().getId()));

            // Bind the checkbox for cascade selection
            cascadeBind(serviceTreeItem);
        }
    }
    /**
     * Creates a new elements and displays it in the editor
     *
     * @param newElement instance of the element class to create
     */
    @SuppressWarnings("unchecked")
    public ElementModel createNewElement(ElementModel newElement) {
        newElement = (ElementModel) newElement.createNewInMap(estabModel.getAll().get(newElement.getClass()));
        setActiveElement(newElement);
        update();
        return newElement;
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
            DialogAction answer = ViewUtil.showWarningRepeatedElements(relatedElementsLists.getRepeatedElements(), selectedItems);
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
        DialogAction answer = ViewUtil.showWarningRemoveElements(elementsToRemove, selectedItems);

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
    @FXML
    private void removeSelectedItems() {
        removeRelatedElements(estabModel.getRelatedElements(selectedElements).getAllElements());
        selectedElements.clear();
        searchResultsListView.getItems().stream().forEach(cell -> cell.setSelected(false));
    }

    /**
     * Copy elements with selected check boxes, or duplicates them if this is the target estab
     */
    @FXML
    private void copySelectedElements() {
        if (isEditable) {
            // Target -> duplicate
            estabModel.duplicate(selectedElements);
            update();
        } else {
            // Source -> copy
            mainController.copyElementsToTarget(estabModel, selectedElements);
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
            ViewUtil.showInfoDialog("File not found", "", file.getName() + " doesn't exist");
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
        estabInfo.setText(title);
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
        if (!editorPaneHook.getChildren().isEmpty() && activeElement.get() != null) {
            int editorIndex = editorPaneChildrenIndex.get(activeElement.get().getClass());
            assert editorIndex >= 0;
            editorPaneHook.getChildren().get(editorIndex).setVisible(false);
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
        editorPaneHook.getChildren().get(editorIndex).setVisible(true);
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
            editorPaneChildrenIndex.put(elementClass, editorPaneHook.getChildren().size());
            editorPaneHook.getChildren().addAll(editorNode.getChildren());
            // Load and save the controller
            elementEditorController = fxmlLoader.getController();
            elementEditorController.setEditable(isEditable);
            elementEditorController.setEstabEditorController(this);
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

    public AnchorPane getEditorPaneHook() {
        return editorPaneHook;
    }

    public class ElementListCell extends HBox {

        private ElementModel elementModel;
        private CheckBox checkBox;
        // Cell text
        private Label label;
        // Used for setting the label style
        private Flag flag;

        public ElementListCell(ElementModel elementModel, Collection<ElementModel> selectedElements) {
            super();
            this.elementModel = elementModel;
            label = createLabel();
            checkBox = createCheckBox(selectedElements);

            this.setOnMouseClicked(createMouseClickedHandler());
            this.getChildren().addAll(checkBox, label);
        }

        /**
         * Selects or deselects the cell checkbox
         *
         * @param b if true, select the checkbox, otherwise deselect
         */
        public void setSelected(boolean b) {
            checkBox.setSelected(b);
        }

        /**
         * Returns the checkbox selected property
         *
         * @return the checkbox selected property
         */
        public BooleanProperty selectedProperty(){
            return checkBox.selectedProperty();
        }
        /**
         * Returns the associated element model
         *
         * @return the associated element model
         */
        public ElementModel getElementModel() {
            return elementModel;
        }

        /**
         * Creates a {@code CheckBox} with a listener to add or remove the {@code elementModel} from a collection
         *
         * @param selectedElements collection to add to or remove from
         * @return the new checkbox
         */
        private CheckBox createCheckBox(Collection<ElementModel> selectedElements) {
            CheckBox c = new CheckBox();
            c.selectedProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue) selectedElements.add(elementModel);
                else selectedElements.remove(elementModel);
            });
            return c;
        }

        /**
         * Creates a {@code Label} with its text style depending on the {@code ElementModel} {@link Flag}.
         * Since an element can contain multiple flags, the priority is New > Copy > Remove.
         *
         * @return the new created label
         */
        @SuppressWarnings("unchecked")
        private Label createLabel() {
            Label l = new Label();
            // Set up the name
            l.textProperty().bind(elementModel.nameProperty());
            // Set up the style
            Iterator<Flag> flagIt = elementModel.getFlags().iterator();
            boolean styleIsSet = false;
            while (!styleIsSet && flagIt.hasNext()) {
                flag = flagIt.next();
                switch (flag) {
                    case NEW:
                        l.setStyle(ViewUtil.TEXT_STYLE_NEW);
                        styleIsSet = true;
                        break;
                    case COPY:
                        l.setStyle(ViewUtil.TEXT_STYLE_COPY);
                        styleIsSet = true;
                        break;
                    case REMOVE:
                        l.setStyle(ViewUtil.TEXT_STYLE_REMOVE);
                        styleIsSet = true;
                        break;
                }
            }
            return l;
        }

        /**
         * Creates an EventHandler to cycle between tags when the user right clicks the cell
         *
         * @return EventHandler to capture mouse clicks
         */
        private EventHandler<? super MouseEvent> createMouseClickedHandler() {
            return event -> {
                if (event.getButton() == MouseButton.SECONDARY) {
                    if (flag == Flag.COPY) {
                        // Change flag from copy to remove
                        flag = Flag.REMOVE;
                        elementModel.unsetFlag(Flag.COPY);
                        elementModel.setFlag(Flag.REMOVE);
                        label.setStyle(ViewUtil.TEXT_STYLE_REMOVE);

                    } else if (flag == Flag.REMOVE) {
                        // Change flag from remove to none
                        flag = null;
                        elementModel.unsetFlag(Flag.REMOVE);
                        label.setStyle(ViewUtil.TEXT_STYLE_DEFAULT);

                    } else if (flag == Flag.NEW) {
                        // Change flag from new to none
                        flag = null;
                        elementModel.unsetFlag(Flag.NEW);
                        label.setStyle(ViewUtil.TEXT_STYLE_DEFAULT);

                    } else if (flag == null) {
                        // Change flag from none to copy
                        flag = Flag.COPY;
                        elementModel.setFlag(Flag.COPY);
                        label.setStyle(ViewUtil.TEXT_STYLE_COPY);
                    }
                }
            };
        }
    }

}


