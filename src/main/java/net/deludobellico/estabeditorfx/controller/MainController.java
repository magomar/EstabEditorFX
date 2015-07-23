package net.deludobellico.estabeditorfx.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.deludobellico.estabeditorfx.model.*;
import net.deludobellico.estabeditorfx.util.*;

import javax.swing.text.html.*;
import java.io.File;
import java.net.URL;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * EstabEditorFXApp application controller. Manages both source and target Estabs, and components such as the menu bar and tool bar.
 *
 * @author Mario
 * @author Heine
 */
public class MainController implements Initializable {
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
    // View menu
    @FXML
    private RadioMenuItem toolbarRadioItem;
    @FXML
    private RadioMenuItem sourceRadioItem;
    @FXML
    private RadioMenuItem targetRadioItem;
    // Tools menu
    @FXML
    private MenuItem fixReferencesMenuItem;
    @FXML
    private MenuItem listElementsMenuItem;
    // Help menu
    // TODO: Create about info
    @FXML
    private MenuItem aboutMenuItem;
    /**
     * Top region: tool bar
     */
    @FXML
    private ToolBar toolBar;
    @FXML
    private Button newEstabButton;
    @FXML
    private Button openSourceEstabButton;
    @FXML
    private Button openTargetEstabButton;
    @FXML
    private Button saveEstabButton;
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
    private Node sourcePane;
    @FXML
    private Node targetPane;
    @FXML
    private EstabEditorController sourcePaneController;
    @FXML
    private EstabEditorController targetPaneController;
    @FXML
    private BorderPane mainPane;

    /**
     * Other
     */
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());
    // Buttons and other components are enabled/disabled based on these properties
    private final BooleanProperty copyIsDisabled = new SimpleBooleanProperty(true);
    private final BooleanProperty removeIsDisabled = new SimpleBooleanProperty(true);
    private final BooleanProperty sourceIsClosed = new SimpleBooleanProperty(true);
    private final BooleanProperty targetIsClosed = new SimpleBooleanProperty(true);
    // Opened files by estab editors
    private File sourceActiveEstabFile;
    private File targetActiveEstabFile;
    // primary stage
    private Stage primaryStage;


    /**
     * Sets listeners, binds properties and loads user settings
     *
     * @param url View location
     * @param rb  always null
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        primaryStage = ViewUtil.ROOT_STAGE;

        // Configure the controllers, set name, if it's editable, and pass this main controller for future reference
        targetPaneController.init(true, this);
        sourcePaneController.init(false, this);

        bindProperties();
        addListeners();
        setAccelerators();
        // Populate recent opened files
        populateOpenRecentSourceMenu();
        populateOpenRecentTargetMenu();
    }

    private void addListeners() {

        // Enable copy if there's a target file and a selected element on the source search list
        sourcePaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (!targetIsClosed.get() && newValue != null) copyIsDisabled.set(false);
                    else copyIsDisabled.set(true);
                });
        // Enable removal if there's an item selected in the the target search list
        targetPaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) -> {
                    if (targetPaneController.getEstabModel() != null && newValue != null)
                        removeIsDisabled.set(false);
                    else removeIsDisabled.set(true);
                });

        // Enable element comparison when both panes have active elements
//        targetPaneController.getActiveElement().addListener((observable, oldValue, newValue) ->
//                compareElementButton.setDisable(newValue == null || sourcePaneController.getActiveElement().get() == null));
//        sourcePaneController.getActiveElement().addListener((observable, oldValue, newValue) ->
//                compareElementButton.setDisable(newValue == null || targetPaneController.getActiveElement().get() == null));

        sourcePane.visibleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                if (ViewUtil.USES_HORIZONTAL_LAYOUT)
                    primaryStage.setWidth(primaryStage.getWidth() + ViewUtil.ESTAB_EDITOR_WIDTH);
                else primaryStage.setHeight(primaryStage.getHeight() + ViewUtil.ESTAB_EDITOR_HEIGHT);
            } else {
                if (ViewUtil.USES_HORIZONTAL_LAYOUT)
                    primaryStage.setWidth(primaryStage.getWidth() - ViewUtil.ESTAB_EDITOR_WIDTH);
                else primaryStage.setHeight(primaryStage.getHeight() - ViewUtil.ESTAB_EDITOR_HEIGHT);
            }
            LOG.log(Level.INFO, "Windows dimension: " + primaryStage.getWidth() + " x " + primaryStage.getHeight());
        });
        targetPane.visibleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                if (ViewUtil.USES_HORIZONTAL_LAYOUT)
                    primaryStage.setWidth(primaryStage.getWidth() + ViewUtil.ESTAB_EDITOR_WIDTH);
                else primaryStage.setHeight(primaryStage.getHeight() + ViewUtil.ESTAB_EDITOR_HEIGHT);
            } else {
                if (ViewUtil.USES_HORIZONTAL_LAYOUT)
                    primaryStage.setWidth(primaryStage.getWidth() - ViewUtil.ESTAB_EDITOR_WIDTH);
                else primaryStage.setHeight(primaryStage.getHeight() - ViewUtil.ESTAB_EDITOR_HEIGHT);
            }
            LOG.log(Level.INFO, "Windows dimension: " + primaryStage.getWidth() + " x " + primaryStage.getHeight());
        });

        toolBar.visibleProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == true) {
                primaryStage.setHeight(primaryStage.getHeight() + ViewUtil.TOOLBAR_HEIGHT);
            } else {
                primaryStage.setHeight(primaryStage.getHeight() - ViewUtil.TOOLBAR_HEIGHT);
            }
            LOG.log(Level.INFO, "Windows dimension: " + primaryStage.getWidth() + " x " + primaryStage.getHeight());
        });
    }

    private void bindProperties() {
        Settings settings = Settings.getInstance();

        toolbarRadioItem.selectedProperty().bindBidirectional(settings.visibleToolbarProperty());
        sourceRadioItem.selectedProperty().bindBidirectional(settings.visibleSourcePanelProperty());
        targetRadioItem.selectedProperty().bindBidirectional(settings.visibleTargetPanelProperty());
        toolBar.visibleProperty().bindBidirectional(settings.visibleToolbarProperty());
        sourcePane.visibleProperty().bindBidirectional(settings.visibleSourcePanelProperty());
        targetPane.visibleProperty().bindBidirectional(settings.visibleTargetPanelProperty());


        copyMenuItem.disableProperty().bind(copyIsDisabled);
        duplicateMenuItem.disableProperty().bind(removeIsDisabled);
        removeMenuItem.disableProperty().bind(removeIsDisabled);

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

        saveEstabButton.disableProperty().bind(targetIsClosed);

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
        targetSaveAsMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.A, KeyCombination.CONTROL_DOWN));
        targetCloseMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.X, KeyCombination.CONTROL_DOWN));
        targetOpenNewMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));

        copyMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.V, KeyCombination.CONTROL_DOWN));
        duplicateMenuItem.setAccelerator(new KeyCodeCombination(KeyCode.D, KeyCombination.CONTROL_DOWN));
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
     * @param mode     the mode in which the estab should be opened (SOURCE vs TARGET)
     * @return the selected file, otherwise null
     * @see System#getProperty(String)
     */

    private File openFileChooser(boolean isSaving, EstabEditorController.EstabMode mode) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select " + mode.name().toLowerCase() + " estab");

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
            copyIsDisabled.set(false);
        else copyIsDisabled.set(true);

        sourcePane.setVisible(true);
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

        if (sourcePaneController.getActiveElement().get() != null) copyIsDisabled.set(false);
        else copyIsDisabled.set(true);

        targetPane.setVisible(true);
        Settings.getInstance().getTargetRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentTargetMenu();
    }


    public BooleanProperty targetIsClosedProperty() {
        return targetIsClosed;
    }


    @FXML
    private void openSourceAction() {
        File f = openFileChooser(false, EstabEditorController.EstabMode.SOURCE);
        if (f != null) {
            openSource(f);
        }
    }

    @FXML
    private void openTargetAction() {
        File f = openFileChooser(false, EstabEditorController.EstabMode.TARGET);
        if (f != null) {
            openTarget(f);
            fixReferencesAction();
        }
    }

    /**
     * Creates and opens and new estab  file
     *
     * @see FileIO#getNewEstabPath()
     */
    @FXML
    private void newEstabAction() {
        Settings settings = Settings.getInstance();
        DialogAction answer = DialogAction.OK;
        if (settings.getNewFileCreated())
            answer = ViewUtil.showInfoDialog("New file exists", "File already exists. Overwrite?", "", DialogAction.CANCEL, DialogAction.OK);
        if (answer == DialogAction.OK) {
            File f = FileIO.getOrCreateNewEstabFile();
            if (f != null) {
                openTarget(f);
                settings.setNewFileCreated(true);
                settings.setNewFileSaved(false);
            }
        }

    }

    /**
     * Saves the target to disk. If the file is our temp new file,
     * it calls {@link #saveTargetAsAction()} to change the path.
     */
    @FXML
    private void saveTargetAction() {
        if (targetActiveEstabFile.toPath().equals(FileIO.getNewEstabPath())) {
            if (saveTargetAsAction() != null) {
                Settings.getInstance().setNewFileSaved(true);
                Settings.getInstance().setNewFileCreated(false);
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
        File file = openFileChooser(true, EstabEditorController.EstabMode.SOURCE);
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
    private void saveTargetAsAction(ActionEvent actionEvent) {
        saveTargetAsAction();
    }

    private File saveTargetAsAction() {
        File file = openFileChooser(true, EstabEditorController.EstabMode.TARGET);
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
    public void closeSourceAction() {
        LOG.log(Level.INFO, "Closing source file " + sourceActiveEstabFile.getName());

        sourcePaneController.setEstabModel((EstabModel) null);
        sourcePaneController.getActiveElement().set(null);
        sourcePaneController.clear();
        sourceActiveEstabFile = null;

        copyIsDisabled.set(true);
        sourceIsClosed.set(true);
        sourcePane.setVisible(false);
    }

    /**
     * Closes the target estab.
     */
    @FXML
    public void closeTargetAction() {
        LOG.log(Level.INFO, "Closing target file " + targetActiveEstabFile.getName());
        targetPaneController.setEstabModel((EstabModel) null);
        targetPaneController.getActiveElement().set(null);
        targetPaneController.clear();
        targetActiveEstabFile = null;

        copyIsDisabled.set(true);
        removeIsDisabled.set(true);
        targetIsClosed.set(true);
        targetPane.setVisible(false);
    }

    /**
     * Copies all elements (and their related elements) to the target estab.
     *
     * @param elements collection with the elements to copy
     */
    public void copyElementsToTarget(EstabModel sourceModel, Collection<ElementModel> elements) {
        RelatedElementsLists relatedElements = sourceModel.getRelatedElements(elements);
        relatedElements.findRepeatedElementsInTargetModel(targetPaneController.getEstabModel());
        if (!targetPaneController.copyRelatedElements(relatedElements))
            LOG.log(Level.WARNING, "Could not copy all elements");
    }

    @FXML
    private void copyAction() {
        copyElementsToTarget(sourcePaneController.getEstabModel(), Arrays.asList(sourcePaneController.getActiveElement().get()));

    }

    @FXML
    private void duplicateAction() {
        targetPaneController.getEstabModel().duplicate(Arrays.asList(targetPaneController.getActiveElement().get()));
        targetPaneController.update();
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
            alert.setTitle("Information");
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
            alert.setTitle("Information");
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
            alert.setTitle("Information");
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
    private void setTwoEstabsModeAction() {
        sourcePane.setVisible(true);
        targetPane.setVisible(true);
    }

    @FXML
    private void setOneEstabModeAction() {
        sourcePane.setVisible(false);
        targetPane.setVisible(true);
    }

    @FXML
    private void compareElementsAction() {
        if (targetPaneController.getActiveElement().get() != null && sourcePaneController.getActiveElement().get() != null) {
            ViewUtil.showInfoDialog("Element comparison", "",
                    String.format("Source (ID %d) : Target (ID %d)\n%sEQUAL",
                            sourcePaneController.getActiveElement().get().getId(),
                            targetPaneController.getActiveElement().get().getId(),
                            sourcePaneController.getActiveElement().get().compareTo(targetPaneController.getActiveElement().get()) ? "" : "NOT "));

        }
    }

    @FXML
    private void listElementsAction() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("User action required");
        alert.setHeaderText("Choose between source and target estabs");
        alert.setContentText("Please select an estab to list its elements");

        ButtonType buttonTypeSource = new ButtonType("Source");
        ButtonType buttonTypeTarget = new ButtonType("Target");
        ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonBar.ButtonData.CANCEL_CLOSE);

        alert.getButtonTypes().setAll(buttonTypeSource, buttonTypeTarget, buttonTypeCancel);

        Optional<ButtonType> result = alert.showAndWait();
        List<ElementModel> allElements;
        if (result.get() == buttonTypeSource) {
            allElements = Tools.getAllElements(sourcePaneController.getEstabModel());
        } else if (result.get() == buttonTypeTarget) {
            allElements = Tools.getAllElements(targetPaneController.getEstabModel());
        } else return;
        ViewUtil.showSearchDialog("List of elements", allElements);
    }

    @FXML
    private void fixReferencesAction() {
        EstabModel estab = targetPaneController.getEstabModel();
        List<ReferenceModel> referencesToFix = Tools.getReferencesToFix(estab);
        List<ReferenceModel> brokenReferences = new ArrayList<>();
        if (referencesToFix.isEmpty()) return;
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning !");
        alert.setHeaderText(referencesToFix.size() + " reference problems have been found !");
        // TODO show list of problems in dialog
//        ListView<ReferenceModel> referencesListView = new ListView<>();
//        referencesListView.setItems(FXCollections.observableList(referencesToFix));
//        alert.getDialogPane().getChildren().add(referencesListView);
        alert.setContentText("¿Would you like to fix them?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            brokenReferences.addAll(referencesToFix.stream().filter(reference -> !reference.fixReference(estab)).collect(Collectors.toList()));
            if (!brokenReferences.isEmpty()) {
                alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning !");
                alert.setHeaderText("Broken references");
                alert.setContentText(brokenReferences.size() + " broken references have been found.");
                alert.showAndWait();
                LOG.log(Level.WARNING, "Broken references: " + brokenReferences);
            }
        } else {
            // ... user chose CANCEL or closed the dialog
            alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning !");
            alert.setHeaderText("References need to be fixed");
            alert.setContentText("Please remember to fix reference problems");
            alert.showAndWait();
        }
    }

    @FXML
    private void  compactIdsAction() {
        Tools.compactIds(targetPaneController.getEstabModel());
    }


}
