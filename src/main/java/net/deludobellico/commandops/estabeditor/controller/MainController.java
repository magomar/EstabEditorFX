package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.DialogAction;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.Settings;
import net.deludobellico.commandops.estabeditor.util.ViewUtil;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * EstabEditorApp application controller. Manages both source and target Estabs, and components such as the menu bar and tool bar.
 *
 * @author Mario
 * @author Heine
 */
public class MainController implements Initializable {
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());
    // Buttons and other components are enabled/disabled based on these properties
    private final BooleanProperty disableCopy = new SimpleBooleanProperty(true);
    private final BooleanProperty sourceIsClosed = new SimpleBooleanProperty(true);
    private final BooleanProperty targetIsClosed = new SimpleBooleanProperty(true);
    private final ObjectProperty<ServiceModel> serviceModel = new SimpleObjectProperty<>();

    /**
     * Top region: Menu bar
     */
    // Source menu
    @FXML
    public MenuItem sourceOpenMenuItem;
    @FXML
    private Menu sourceOpenRecentMenuList;
    @FXML
    private MenuItem sourceSaveAsMenuItem;
    @FXML
    private MenuItem sourceCloseMenuItem;
    // Target menu
    @FXML
    private MenuItem targetOpenNewMenuItem;
    @FXML
    private MenuItem targetOpenMenuItem;
    @FXML
    private Menu targetOpenRecentMenuList;
    @FXML
    private MenuItem targetSaveMenuItem;
    @FXML
    private MenuItem targetSaveAsMenuItem;
    @FXML
    private MenuItem targetCloseMenuItem;
    // Edit menu
    @FXML
    private MenuItem copyMenuItem;
    @FXML
    private MenuItem duplicateMenuItem;
    @FXML
    private MenuItem removeMenuItem;
    // New menu
    @FXML
    private MenuItem createNewForceMenuItem;
    @FXML
    private MenuItem createNewVehicleMenuItem;
    @FXML
    private MenuItem createNewWeaponMenuItem;
    @FXML
    private MenuItem createNewAmmoMenuItem;
    @FXML
    private MenuItem createNewServiceMenuItem;
    @FXML
    private MenuItem createNewNationMenuItem;
    @FXML
    private MenuItem createNewSideMenuItem;
    // View
    @FXML
    private RadioMenuItem toolbarRadioItem;
    @FXML
    private RadioMenuItem sourceRadioItem;
    @FXML
    private RadioMenuItem targetRadioItem;
    // About
    // TODO: Create about info
    @FXML
    private MenuItem aboutMenuItem;
    /**
     * Top region: tool bar
     */
    @FXML
    private ToolBar toolBar;
    @FXML
    private Button copyElementButton;
    @FXML
    private Button removeElementButton;
    @FXML
    private Button saveDataButton;
    @FXML
    private Button createNewForceButton;
    @FXML
    private Button createNewVehicleButton;
    @FXML
    private Button createNewWeaponButton;
    @FXML
    private Button createNewAmmoButton;
    @FXML
    private Button compareElementButton;
    /**
     * Center region
     */
    @FXML
    private ScrollPane estabsContainer;
    @FXML
    private TitledPane sourcePane;
    @FXML
    private TitledPane targetPane;
    @FXML
    private EstabEditorController sourcePaneController;
    @FXML
    private EstabEditorController targetPaneController;
    /**
     * Other
     */
    // Opened files by estab editors
    private File sourceActiveEstabFile;
    private File targetActiveEstabFile;

    /**
     * Sets listeners, binds properties and loads user settings
     *
     * @param url View location
     * @param rb  always null
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // The scroll pane will fit all the rootPane
        estabsContainer.setFitToWidth(true);

        // Configure the controllers, set name, if it's editable, and pass this main controller for future reference
        targetPaneController.init("Target Estab", true, this);
        sourcePaneController.init("Source Estab", false, this);

        addListeners();
        loadSettings();
        bindProperties();
        setAccelerators();
        // Populate recent opened files
        populateOpenRecentSourceMenu();
        populateOpenRecentTargetMenu();
    }

    private void addListeners() {

        // Enable copy if there's a target file and a selected element on the source search list
        sourcePaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (!targetIsClosed.get() && newValue != null) disableCopy.set(false);
                    else disableCopy.set(true);
                });
        // Enable removal if there's an item selected in the the target search list
        targetPaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (targetPaneController.getEstabModel() != null && newValue != null)
                        removeElementButton.setDisable(false);
                });

        // Enable element comparison when both panes have active elements
        targetPaneController.getActiveElement().addListener((observable, oldValue, newValue) ->
                compareElementButton.setDisable(newValue == null || sourcePaneController.getActiveElement().get() == null));
        sourcePaneController.getActiveElement().addListener((observable, oldValue, newValue) ->
                compareElementButton.setDisable(newValue == null || targetPaneController.getActiveElement().get() == null));

        // Save the panes status in the settings
        sourcePane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedSourcePane(sourcePane.isExpanded()));
        targetPane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedTargetPane(targetPane.isExpanded()));


    }

    private void loadSettings() {
        // If settings were loaded, set them
        toolBar.setVisible(Settings.getInstance().getVisibleToolbar());
        sourcePane.setVisible(Settings.getInstance().getVisibleSourcePanel());
        targetPane.setVisible(Settings.getInstance().getVisibleTargetPanel());

        toolbarRadioItem.setSelected(Settings.getInstance().getVisibleToolbar());
        sourceRadioItem.setSelected(Settings.getInstance().getVisibleSourcePanel());
        targetRadioItem.setSelected(Settings.getInstance().getVisibleTargetPanel());
        sourcePane.expandedProperty().set(Settings.getInstance().getExpandedSourcePane());
        targetPane.expandedProperty().set(Settings.getInstance().getExpandedTargetPane());
        if (!Settings.getInstance().getVerticalPanes()) togglePanesContainer();
    }

    private void bindProperties() {

        copyElementButton.disableProperty().bindBidirectional(disableCopy);
        copyMenuItem.disableProperty().bindBidirectional(disableCopy);
        removeMenuItem.disableProperty().bindBidirectional(removeElementButton.disableProperty());

        sourceSaveAsMenuItem.disableProperty().bind(sourceIsClosed);
        sourceCloseMenuItem.disableProperty().bind(sourceIsClosed);
        sourcePaneController.searchDisableProperty().bind(sourceIsClosed);

        targetSaveMenuItem.disableProperty().bind(targetIsClosed);
        targetSaveAsMenuItem.disableProperty().bind(targetIsClosed);
        targetCloseMenuItem.disableProperty().bind(targetIsClosed);
        targetPaneController.searchDisableProperty().bind(targetIsClosed);

        createNewForceButton.disableProperty().bind(targetIsClosed);
        createNewForceMenuItem.disableProperty().bind(targetIsClosed);

        createNewVehicleButton.disableProperty().bind(targetIsClosed);
        createNewVehicleMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        createNewWeaponButton.disableProperty().bind(targetIsClosed);
        createNewWeaponMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        createNewAmmoButton.disableProperty().bind(targetIsClosed);
        createNewAmmoMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        createNewServiceMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        createNewNationMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        createNewSideMenuItem.disableProperty().bindBidirectional(targetIsClosed);

        saveDataButton.disableProperty().bind(targetIsClosed);

        // Hide components if they are set invisible
        toolBar.managedProperty().bind(toolBar.visibleProperty());
        sourcePane.managedProperty().bind(sourcePane.visibleProperty());
        targetPane.managedProperty().bind(targetPane.visibleProperty());

    }

    public void setAccelerators() {
        sourceOpenMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.ALT_DOWN));
        sourceSaveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.ALT_DOWN));
        sourceCloseMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.ALT_DOWN));

        targetOpenMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        targetSaveMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        targetSaveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        targetCloseMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        targetOpenNewMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        removeMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.DELETE, KeyCombination.CONTROL_DOWN));

    }

    /**
     * Creates menu items based on the last opened files.
     */
    private void populateOpenRecentTargetMenu() {
        targetOpenRecentMenuList.getItems().clear();
        for (String targetFile : Settings.getInstance().getTargetRecentFiles()) {
            File file = new File(targetFile);
            if (file.exists()) {
                MenuItem recentTargetMenuItem = new MenuItem(file.getName());
                recentTargetMenuItem.setOnAction(event -> {
                    if (file.exists()) openTarget(file);
                    else targetOpenRecentMenuList.getItems().remove(recentTargetMenuItem);
                });
                targetOpenRecentMenuList.getItems().add(recentTargetMenuItem);
            }
        }
    }

    /**
     * Creates menu items based on the last opened files.
     */
    private void populateOpenRecentSourceMenu() {
        sourceOpenRecentMenuList.getItems().clear();
        for (String sourceFile : Settings.getInstance().getSourceRecentFiles()) {
            File file = new File(sourceFile);
            if (file.exists()) {
                MenuItem recentSourceMenuItem = new MenuItem(file.getName());
                recentSourceMenuItem.setOnAction(event -> {
                    if (file.exists()) openSource(file);
                    else sourceOpenRecentMenuList.getItems().remove(recentSourceMenuItem);
                });
                sourceOpenRecentMenuList.getItems().add(recentSourceMenuItem);
            }
        }
    }

    /**
     * Displays a file chooser to open or save files. Sets the initial directory with the last opened folder if possible,
     * otherwise the initial directory is set to {@code user.dir}.
     * Files are filtered with {@link FileIO#EXTENSION_FILTERS}
     *
     * @param isSaving true if the file chooser is open for saving, false if it's for opening
     * @param isSource
     * @return the selected file, otherwise null
     * @see System#getProperty(String)
     */

    private File openFileChooser(boolean isSaving, boolean isSource) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(String.format("Select %s ESTAB", isSource ? "Source" : "Target"));

        File initialDirectory = null;
        if (Settings.getInstance().getLastOpenedFolder() != null)
            initialDirectory = new File(Settings.getInstance().getLastOpenedFolder());
        if (initialDirectory == null || !initialDirectory.exists())
            initialDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(initialDirectory);


        fileChooser.getExtensionFilters().addAll(FileIO.EXTENSION_FILTERS);
        File selectedFile = isSaving ? fileChooser.showSaveDialog(ViewUtil.ROOT_STAGE) : fileChooser.showOpenDialog(ViewUtil.ROOT_STAGE);
        if (selectedFile != null)
            Settings.getInstance().setLastOpenedFolder(selectedFile.getParentFile().getAbsolutePath());
        return selectedFile;
    }

    /**
     * Displays a directory chooser. Sets the initial directory with the last opened folder if possible,
     * otherwise the initial directory is set to {@code user.dir}.
     *
     * @return the selected folder, otherwise null
     * @see System#getProperty(String)
     */
    private File openDirectoryChooser() {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        directoryChooser.setTitle("Select folder");
        File initialDirectory = null;
        if (Settings.getInstance().getLastOpenedFolder() != null)
            initialDirectory = new File(Settings.getInstance().getLastOpenedFolder());
        if (initialDirectory == null || !initialDirectory.exists())
            initialDirectory = new File(System.getProperty("user.dir"));
        directoryChooser.setInitialDirectory(initialDirectory);
        return directoryChooser.showDialog(ViewUtil.ROOT_STAGE);
    }

    /**
     *
     */
    /**
     * Opens a file as a source estab.
     *
     * @param file source file to open
     */
    private void openSource(File file) {
        LOG.log(Level.INFO, "Opening source file: " + file.getName());
        if (targetActiveEstabFile != null && targetActiveEstabFile.getPath().equals(file.getPath()))
            ViewUtil.showInfoDialog("Warning", "This file is open for edition", file.getName() + " is being edited, inconsistencies may happen.");
        sourceActiveEstabFile = file;
        sourceIsClosed.set(false);
        sourcePaneController.setEstabModel(sourceActiveEstabFile);

        if (targetPaneController.getActiveElement().get() != null
                && !sourcePaneController.getSearchResultsListView().getSelectionModel().getSelectedItems().isEmpty())
            disableCopy.set(false);
        else disableCopy.set(true);

        sourcePane.expandedProperty().set(true);
        Settings.getInstance().getSourceRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentSourceMenu();
    }

    /**
     * Opens a file as a target estab.
     *
     * @param file target file to open
     */
    // TODO: check target has correct xml syntax
    private void openTarget(File file) {
        LOG.log(Level.INFO, "Opening target file: " + file.getName());
        targetActiveEstabFile = file;
        if (sourceActiveEstabFile != null && sourceActiveEstabFile.getPath().equals(file.getPath()))
            ViewUtil.showInfoDialog("Warning", "File is already open", "Changes in " + file.getName() + " might be lost.");
        targetIsClosed.set(false);
        targetPaneController.setEstabModel(targetActiveEstabFile);

        if (sourcePaneController.getActiveElement().get() != null) disableCopy.set(false);
        else disableCopy.set(true);

        targetPane.expandedProperty().set(true);
        Settings.getInstance().getTargetRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentTargetMenu();
    }

    /**
     * Handles menu items for opening files. Displays the file chooser and opens the selected file,
     * unless it's a new file, which will be opened without asking.
     *
     * @param actionEvent used to extract the parent Menu name (Source or Target)
     * @see FileIO#getNewEstabPath()
     */
    @FXML
    public void openFileAction(ActionEvent actionEvent) {
        boolean isSource = ((MenuItem) actionEvent.getSource()).getParentMenu().getText().toLowerCase().contains("source");
        boolean isNew = ((MenuItem) actionEvent.getSource()).getText().toLowerCase().contains("new");
        if (isNew) {
            DialogAction answer = DialogAction.OK;
            if (Settings.getNewFileCreated())
                answer = ViewUtil.showInfoDialog("New file exists", "Another new file has been found. Overwrite?", "", DialogAction.CANCEL, DialogAction.OK);
            if (answer == DialogAction.OK) {
                File f = FileIO.getOrCreateNewEstabFile();
                if (f != null) {
                    openTarget(f);
                    Settings.setNewFileCreated(true);
                    Settings.setNewFileSaved(false);
                }
            }
        } else {
            File f = openFileChooser(false, isSource);
            if (f != null) {
                if (isSource) openSource(f);
                else openTarget(f);
            }
        }
    }

    /**
     * Saves the target to disk. If the file is our temp new file,
     * it calls {@link #saveTargetAsAction()} to change the path.
     */
    @FXML
    public void saveTargetAction() {
        if (targetActiveEstabFile.toPath().equals(FileIO.getNewEstabPath())) {
            if (saveTargetAsAction() != null) {
                Settings.setNewFileSaved(true);
                Settings.setNewFileCreated(false);
            }

        } else {
            LOG.log(Level.INFO, "Saving target file: " + targetActiveEstabFile.getName());
        }
        targetPaneController.saveModel(targetActiveEstabFile);
    }

    /**
     * Displays a file chooser and copies the current source file to the new destination.
     */
    @FXML
    public void saveSourceAsAction(ActionEvent actionEvent) {
        saveSourceAsAction();
    }

    private File saveSourceAsAction() {
        File file = openFileChooser(true, true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving source file " + sourceActiveEstabFile.getName() + " as " + file.getName());
            FileIO.copy(sourceActiveEstabFile, file);
            openSource(file);
        }
        return file;
    }

    /**
     * Displays a file chooser and copies the current target file to the new destination.
     */
    @FXML
    public void saveTargetAsAction(ActionEvent actionEvent) {
        saveTargetAsAction();
    }

    private File saveTargetAsAction() {
        File file = openFileChooser(true, true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving target file " + targetActiveEstabFile.getName() + " as " + file.getName());
            FileIO.copy(targetActiveEstabFile, file);
            openTarget(file);
        }
        return file;
    }

    /**
     * Closes the source estab.
     */
    @FXML
    public void sourceCloseAction() {
        LOG.log(Level.INFO, "Closing source file " + sourceActiveEstabFile.getName());

        sourcePaneController.setEstabModel((EstabModel) null);
        sourcePaneController.getActiveElement().set(null);
        sourcePaneController.clear();
        sourceActiveEstabFile = null;

        disableCopy.set(true);
        sourceIsClosed.set(true);
        sourcePane.expandedProperty().set(false);
    }

    /**
     * Closes the target estab.
     */
    @FXML
    public void targetCloseAction() {
        LOG.log(Level.INFO, "Closing target file " + targetActiveEstabFile.getName());
        targetPaneController.setEstabModel((EstabModel) null);
        targetPaneController.getActiveElement().set(null);
        targetPaneController.clear();
        targetActiveEstabFile = null;


        disableCopy.set(true);
        targetIsClosed.set(true);
        targetPane.expandedProperty().set(false);
        removeElementButton.setDisable(true);
    }

    @FXML
    public void toggleToolBarVisibility() {
        boolean isVisible = !toolBar.isVisible();
        toolBar.setVisible(isVisible);
        Settings.getInstance().setVisibleToolbar(isVisible);
    }

    @FXML
    public void toggleSourcePaneVisibility() {
        boolean isVisible = !sourcePane.isVisible();
        sourcePane.setVisible(isVisible);
        Settings.getInstance().setVisibleSourcePanel(isVisible);
    }

    @FXML
    public void toggleTargetPaneVisibility() {
        boolean isVisible = !targetPane.isVisible();
        targetPane.setVisible(isVisible);
        Settings.getInstance().setVisibleTargetPanel(isVisible);
    }

    /**
     * Swaps the estab panes orientation from Horizontal (left-to-right) to Vertical (top-to-bottom)
     */
    public void togglePanesContainer() {
        if (estabsContainer.getContent() instanceof FlowPane) {
            FlowPane flowPane = (FlowPane) estabsContainer.getContent();
            if (flowPane.getOrientation() == Orientation.HORIZONTAL) {
                flowPane.setOrientation(Orientation.VERTICAL);
                Settings.getInstance().setVerticalPanes(true);
            } else {
                flowPane.setOrientation(Orientation.HORIZONTAL);
                Settings.getInstance().setVerticalPanes(false);
            }
        }
    }

    /**
     * Copies all elements (and their related elements) to the target estab.
     *
     * @param elements collection with the elements to copy
     */
    public void copyElementsToTarget(Collection<ElementModel> elements) {
        RelatedElementsLists relatedElements = sourcePaneController.getEstabModel().getRelatedElements(elements);
        relatedElements.findRepeatedElementsInTargetModel(targetPaneController.getEstabModel());
        if (!targetPaneController.copyRelatedElements(relatedElements))
            LOG.log(Level.WARNING, "Could not copy all elements");
    }

    void copyElementsToTarget(ElementModel element) {
        copyElementsToTarget(Arrays.asList(element));
    }

    @FXML
    private void copyAction() {
        copyElementsToTarget(sourcePaneController.getActiveElement().get());
    }

    @FXML
    private void removeAction() {
        List<ElementModel> elementsToRemove = targetPaneController.getEstabModel().getRelatedElements(
                targetPaneController.getActiveElement().get()).getAllElements();
        targetPaneController.removeRelatedElements(elementsToRemove);
    }

    @FXML
    private void createNewForceAction() {
        ForceModel forceModel = new ForceModel();
        ServiceModel serviceModel = (ServiceModel) ViewUtil.showSearchDialog("Selected service", targetPaneController.getEstabModel().getServices().values());
        if (serviceModel != null) {
            forceModel.setService(serviceModel);
            serviceModel.getForce().add((ForceModel) targetPaneController.createNewElement(forceModel));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("A Force should be created inside a Service");
            alert.setContentText("Please select a Service to create a Force");
            alert.showAndWait();
        }
    }

    @FXML
    private void createNewServiceAction() {
        ServiceModel serviceModel = new ServiceModel();
        NationModel nationModel = (NationModel) ViewUtil.showSearchDialog("Select nation", targetPaneController.getEstabModel().getNations().values());
        if (nationModel != null) {
            serviceModel.setNation(nationModel);
            nationModel.getService().add((ServiceModel) targetPaneController.createNewElement(serviceModel));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("A Service should be created inside a Nation");
            alert.setContentText("Please select a Nation to create a Service");
            alert.showAndWait();
        }
    }

    @FXML
    private void createNewNationAction() {
        NationModel nationModel = new NationModel();
        SideModel sideModel = (SideModel) ViewUtil.showSearchDialog("Select side", targetPaneController.getEstabModel().getSides().values());
        if (sideModel != null) {
            nationModel.setSide(sideModel);
            sideModel.getNation().add((NationModel) targetPaneController.createNewElement(nationModel));
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText("A Nation should be created inside a Side");
            alert.setContentText("Please select a Side to create a Nation");
            alert.showAndWait();
        }
    }

    @FXML
    private void createNewSideAction() {
        targetPaneController.createNewElement(new SideModel());
    }

    @FXML
    private void createNewVehicleAction() {
        targetPaneController.createNewElement(new VehicleModel());
    }

    @FXML
    private void createNewWeaponAction() {
        targetPaneController.createNewElement(new WeaponModel());
    }

    @FXML
    private void createNewAmmoAction() {
        targetPaneController.createNewElement(new AmmoModel());
    }

    @FXML
    private void compareElementButtonAction() {
        if (targetPaneController.getActiveElement().get() != null && sourcePaneController.getActiveElement().get() != null) {
            ViewUtil.showInfoDialog("Element comparison", "",
                    String.format("Source (ID %d) : Target (ID %d)\n%sEQUAL",
                            sourcePaneController.getActiveElement().get().getId(),
                            targetPaneController.getActiveElement().get().getId(),
                            sourcePaneController.getActiveElement().get().compareTo(targetPaneController.getActiveElement().get()) ? "" : "NOT "));

        }
    }

    public BooleanProperty targetIsClosedProperty() {
        return targetIsClosed;
    }

}
