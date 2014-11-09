package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Orientation;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import net.deludobellico.commandops.estabeditor.Main;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.Settings;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.io.File;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main application controller. Manages both source and target Estabs, and components such as the menu bar and tool bar.
 *
 * @author Mario
 * @author Heine
 */
public class MainController implements Initializable {
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());

    /**
     * Top region: Menu bar
     */
    // Source menu
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
    private EstabController sourcePaneController;
    @FXML
    private EstabController targetPaneController;

    /**
     * Other
     */
    // Opened files by estab editors
    private File sourceActiveEstabFile;
    private File targetActiveEstabFile;
    // Buttons and other components are enabled/disabled based on these properties
    private BooleanProperty disableCopy = new SimpleBooleanProperty(true);
    private BooleanProperty sourceIsClosed = new SimpleBooleanProperty(true);
    private BooleanProperty targetIsClosed = new SimpleBooleanProperty(true);

    /**
     * Sets listeners, binds properties and loads user settings
     *
     * @param url View location
     * @param rb  always null
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // Configure the controllers, set name, if it's editable, and pass this main controller for future reference
        targetPaneController.init("Target Estab", true, this);
        sourcePaneController.init("Source Estab", false, this);

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

        // Hide components if they are set invisible
        toolBar.managedProperty().bind(toolBar.visibleProperty());
        sourcePane.managedProperty().bind(sourcePane.visibleProperty());
        targetPane.managedProperty().bind(targetPane.visibleProperty());
        // Save the panes status in the settings
        sourcePane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedSourcePane(sourcePane.isExpanded()));
        targetPane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedTargetPane(targetPane.isExpanded()));

        // The scroll pane will fit all the rootPane
        estabsContainer.setFitToWidth(true);
        try {
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
        } catch (NullPointerException ignored) {
            // It's ok if settings had some null pointers. The settings file will be overwritten on exit.
        }

        // Bind properties
        copyElementButton.disableProperty().bindBidirectional(disableCopy);
        sourceSaveAsMenuItem.disableProperty().bind(sourceIsClosed);
        sourceCloseMenuItem.disableProperty().bind(sourceIsClosed);
        sourcePaneController.searchDisableProperty().bind(sourceIsClosed);

        targetSaveMenuItem.disableProperty().bind(targetIsClosed);
        targetSaveAsMenuItem.disableProperty().bind(targetIsClosed);
        targetCloseMenuItem.disableProperty().bind(targetIsClosed);
        targetPaneController.searchDisableProperty().bind(targetIsClosed);
        saveDataButton.disableProperty().bind(targetIsClosed);
        createNewVehicleButton.disableProperty().bind(targetIsClosed);
        createNewWeaponButton.disableProperty().bind(targetIsClosed);
        createNewAmmoButton.disableProperty().bind(targetIsClosed);

        // Populate recent opened files
        populateOpenRecentSourceMenu();
        populateOpenRecentTargetMenu();
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
     * Files are filtered with {@link FileIO#FILECHOOSER_FILTERS}
     *
     * @param isSaving true if the file chooser is open for saving, false if it's for opening
     * @return the selected file, otherwise null
     * @see System#getProperty(String)
     */

    private File openFileChooser(boolean isSaving) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select ESTAB");

        File initialDirectory = null;
        if (Settings.getInstance().getLastOpenedFolder() != null)
            initialDirectory = new File(Settings.getInstance().getLastOpenedFolder());
        if (initialDirectory == null || !initialDirectory.exists())
            initialDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(initialDirectory);


        fileChooser.getExtensionFilters().addAll(FileIO.FILECHOOSER_FILTERS);
        File selectedFile = isSaving ? fileChooser.showSaveDialog(UtilView.ROOT_STAGE) : fileChooser.showOpenDialog(UtilView.ROOT_STAGE);
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
        return directoryChooser.showDialog(UtilView.ROOT_STAGE);
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
        sourceActiveEstabFile = file;
        sourceIsClosed.set(false);
        sourcePaneController.setEstabModel(sourceActiveEstabFile);

        if (targetPaneController.getActiveElement().get() != null) disableCopy.set(false);
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
        targetIsClosed.set(false);
        targetPaneController.setEstabModel(targetActiveEstabFile);


        // TODO: simplify, add listener to active element to disable or enable copy
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
                answer = UtilView.showInfoDialog("New file exists", "Another new file has been found. Overwrite?", DialogAction.CANCEL, DialogAction.OK);
            if (answer == DialogAction.OK) {
                Settings.setNewFileCreated(true);
                openTarget(FileIO.getOrCreateNewEstabFile());
            }
        } else {
            File file = openFileChooser(false);
            if (null != file) {
                if (isSource) openSource(file);
                else openTarget(file);
            }
        }
    }

    /**
     * Saves the target to disk. If the file is our temp new file,
     * it calls {@link #saveTargetAsAction()} to change the path.
     *
     * @see Main#stop()
     */
    @FXML
    public void saveTargetAction() {
        if (targetActiveEstabFile.toPath().equals(FileIO.getNewEstabPath())) {
            saveTargetAsAction();
            Settings.setNewFileSaved(true);
        } else {
            LOG.log(Level.INFO, "Saving target file: " + targetActiveEstabFile.getName());
        }
        targetPaneController.saveModel(targetActiveEstabFile);
    }

    /**
     * Displays a file chooser and copies the current source file to the new destination.
     */
    @FXML
    public void saveSourceAsAction() {
        File file = openFileChooser(true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving source file " + sourceActiveEstabFile.getName() + " as " + file.getName());
            FileIO.copy(sourceActiveEstabFile, file);
            openSource(file);
        }
    }

    /**
     * Displays a file chooser and copies the current target file to the new destination.
     */
    @FXML
    public void saveTargetAsAction() {
        File file = openFileChooser(true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving target file " + targetActiveEstabFile.getName() + " as " + file.getName());
            FileIO.copy(targetActiveEstabFile, file);
            openTarget(file);
        }
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
     * Installs the selected dataset to disk.
     *
     * @param actionEvent used to extract the dataset name
     * @see FileIO#installDataset(String, File)
     */
    @FXML
    private void installDataset(ActionEvent actionEvent) {
        String datasetName = ((MenuItem) actionEvent.getSource()).getText();
        File folder = openDirectoryChooser();
        if (folder != null) {
            File installedDataset = FileIO.installDataset(datasetName, folder);
            if (installedDataset != null) {
                openSource(installedDataset);
            } else {
                UtilView.showInfoDialog("Dataset already exists", "Aborting installation");
            }
        }
    }

    /**
     * Copies all elements (and their related elements) to the target estab.
     *
     * @param elements collection with the elements to copy
     */
    public void copyElementsToTarget(Collection<ElementModel> elements) {
        RelatedElementLists relatedElements = sourcePaneController.getEstabModel().getRelatedElements(elements, targetPaneController.getEstabModel());
        assert relatedElements.isSorted();
        if (!targetPaneController.copyRelatedElements(relatedElements))
            LOG.log(Level.WARNING, "Could not copy all elements");
    }

    @FXML
    private void copyToolbarButtonAction() {
        copyElementsToTarget(Collections.singleton(sourcePaneController.getActiveElement().get()));
    }

    @FXML
    private void removeToolbarButtonAction() {
        Collection<ElementModel> elementToRemove = Collections.singleton(targetPaneController.getActiveElement().get());
        targetPaneController.removeRelatedElements(targetPaneController.getEstabModel().getRelatedElements(elementToRemove));
    }

    public void createNewVehicleButtonAction() {
        targetPaneController.createNewElement(new VehicleModel());
    }

    public void createNewWeaponButtonAction() {
        targetPaneController.createNewElement(new WeaponModel());
    }

    public void createNewAmmoButtonAction() {
        targetPaneController.createNewElement(new AmmoModel());
    }

    public void compareElementButtonAction() {
        if (targetPaneController.getActiveElement().get() != null && sourcePaneController.getActiveElement().get() != null) {
            UtilView.showInfoDialog("Element comparison",
                    String.format("Source (ID %d) : Target (ID %d)\n%sEQUAL",
                            sourcePaneController.getActiveElement().get().getId(),
                            targetPaneController.getActiveElement().get().getId(),
                            sourcePaneController.getActiveElement().get().equals(targetPaneController.getActiveElement().get()) ? "" : "NOT "));

        }
    }
}
