package net.deludobellico.stabeditor.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.deludobellico.stabeditor.model.CopyPasteLists;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Settings;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstabEditorController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabEditorController.class.getName());

    @FXML
    private AnchorPane rootPane;

    @FXML
    private ScrollPane estabDataContainer;

    @FXML
    private TitledPane sourcePane;

    @FXML
    private TitledPane targetPane;

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private Menu sourceOpenRecentMenuList;

    @FXML
    private MenuItem sourceSaveAsMenuItem;

    @FXML
    private MenuItem sourceCloseMenuItem;

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

    @FXML
    private RadioMenuItem toolbarRadioItem;

    @FXML
    private RadioMenuItem sourceRadioItem;

    @FXML
    private RadioMenuItem targetRadioItem;

    // TODO: Create about info
    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private ToolBar toolBar;

    @FXML
    private Button copyElementButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private EstabDataController sourcePaneController;

    @FXML
    private EstabDataController targetPaneController;

    private File sourceEstabFile;
    private File targetEstabFile;

    private Stage stage;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sourcePaneController.setTitle("Source Estab Data:");
        targetPaneController.setTitle("Target Estab Data: ");
        sourcePaneController.setEditable(false);
        targetPaneController.setEditable(true);
        sourcePaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Only enable the copy button if there's a target file and a selected element
            if (targetPaneController.getEstabDataModel() != null && newValue != null)
                copyElementButton.setDisable(false);
            else copyElementButton.setDisable(true);
        });

        populateOpenRecentSourceMenu();
        populateOpenRecentTargetMenu();

        toolBar.managedProperty().bind(toolBar.visibleProperty());
        sourcePane.managedProperty().bind(sourcePane.visibleProperty());
        targetPane.managedProperty().bind(targetPane.visibleProperty());

        toolBar.setVisible(Settings.getInstance().getVisibleToolbar());
        sourcePane.setVisible(Settings.getInstance().getVisibleSourcePanel());
        targetPane.setVisible(Settings.getInstance().getVisibleTargetPanel());

        toolbarRadioItem.setSelected(Settings.getInstance().getVisibleToolbar());
        sourceRadioItem.setSelected(Settings.getInstance().getVisibleSourcePanel());
        targetRadioItem.setSelected(Settings.getInstance().getVisibleTargetPanel());
        estabDataContainer.setFitToWidth(true);
    }

    private void populateOpenRecentTargetMenu() {
        targetOpenRecentMenuList.getItems().clear();
        for (String targetFile : Settings.getInstance().getTargetRecentFiles()) {
            File file = new File(targetFile);
            MenuItem recentTargetMenuItem = new MenuItem(file.getName());
            recentTargetMenuItem.setOnAction(event -> {
                openTarget(file);
            });
            targetOpenRecentMenuList.getItems().add(recentTargetMenuItem);
        }
    }

    private void populateOpenRecentSourceMenu() {
        sourceOpenRecentMenuList.getItems().clear();
        for (String sourceFile : Settings.getInstance().getSourceRecentFiles()) {
            File file = new File(sourceFile);
            MenuItem recentSourceMenuItem = new MenuItem(file.getName());
            recentSourceMenuItem.setOnAction(event -> {
                openSource(file);
            });
            sourceOpenRecentMenuList.getItems().add(recentSourceMenuItem);
        }
    }

    private File openFileChooser(boolean isSaving) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Opening ESTAB File");
        fileChooser.setInitialDirectory(FileIO.getDatasetsPath().toFile());
        fileChooser.getExtensionFilters().addAll(FileIO.FILECHOOSER_FILTERS);

        return isSaving ? fileChooser.showSaveDialog(getStage()) : fileChooser.showOpenDialog(getStage());
    }


//  Careful, no file == null check on both openSource and openTarget

    private void openSource(File file) {
        LOG.log(Level.INFO, "Opening source file: " + file.getName());

        sourceEstabFile = file;
        sourcePaneController.setTitle("Source Estab: " + file.getName());
        sourcePaneController.setEstabDataModel(new EstabDataModel(sourceEstabFile));

        sourceSaveAsMenuItem.setDisable(false);

        Settings.getInstance().getSourceRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentSourceMenu();
    }

    // TODO: check target has correct xml syntax
    private void openTarget(File file) {
        LOG.log(Level.INFO, "Opening target file: " + file.getName());

        targetEstabFile = file;
        targetPaneController.setTitle("Target Estab: " + targetEstabFile.getName());
        targetPaneController.setEstabDataModel(new EstabDataModel(targetEstabFile));

        saveDataButton.setDisable(false);
        targetSaveMenuItem.setDisable(false);
        targetSaveAsMenuItem.setDisable(false);

        if (targetPaneController.getEstabDataModel() != null && sourcePaneController.getActiveComponent() != null)
            copyElementButton.setDisable(false);

        Settings.getInstance().getTargetRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentTargetMenu();
    }

    @FXML
    public void openSourceAction(ActionEvent actionEvent) {
        File file = openFileChooser(false);
        if (null != file) openSource(file);
    }

    @FXML
    public void openTargetAction(ActionEvent actionEvent) {
        File file = openFileChooser(false);
        if (file != null) openTarget(file);
    }

    @FXML
    public void openNewTarget(ActionEvent actionEvent) {
        openTarget(FileIO.getNewEstabFile());
    }

    @FXML
    public void copyElementAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        targetPaneController.setActiveComponent(sourcePaneController.getActiveComponent());
        // All the assets/elements that we are going to copy
        CopyPasteLists copyPasteElementLists = sourcePaneController.getEstabDataModel().getElementsToCopy(sourcePaneController.getActiveComponent());
        targetPaneController.pasteActiveComponent(copyPasteElementLists);
    }

    @FXML
    public void saveTargetAction(ActionEvent actionEvent) {
        if (targetEstabFile.toPath().equals(FileIO.getNewEstabPath())) {
            saveTargetAsAction(actionEvent);
        } else {
            LOG.log(Level.INFO, "Saving target file: " + targetEstabFile.getName());
        }
        targetPaneController.saveDataModel(targetEstabFile);
    }

    @FXML
    public void saveTargetAsAction(ActionEvent actionEvent) {
        File file = openFileChooser(true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving target file " + targetEstabFile.getName() + " as " + file.getName());
            FileIO.copy(targetEstabFile, file);
            openTarget(file);
        }
    }

    @FXML
    public void saveSouceAsAction(ActionEvent actionEvent) {
        File file = openFileChooser(true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving source file " + targetEstabFile.getName() + " as " + file.getName());
            FileIO.copy(sourceEstabFile, file);
            openSource(file);
        }
    }

    @FXML
    public void toggleToolBarVisibility(ActionEvent actionEvent) {
        boolean isVisible = !toolBar.isVisible();
        toolBar.setVisible(isVisible);
        Settings.getInstance().setVisibleToolbar(isVisible);
    }

    @FXML
    public void toggleSourcePaneVisibility(ActionEvent actionEvent) {
        boolean isVisible = !sourcePane.isVisible();
        sourcePane.setVisible(isVisible);
        Settings.getInstance().setVisibleSourcePanel(isVisible);
    }

    @FXML
    public void toggleTargetPaneVisibility(ActionEvent actionEvent) {
        boolean isVisible = !targetPane.isVisible();
        targetPane.setVisible(isVisible);
        Settings.getInstance().setVisibleTargetPanel(isVisible);
    }

    @FXML
    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    private Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    public void togglePanesContainer(ActionEvent actionEvent) {
        Pane container;
        if (estabDataContainer.getContent() instanceof VBox) {
            container = new HBox();
        } else if (estabDataContainer.getContent() instanceof HBox) {
            container = new VBox();
        } else return;

        container.getChildren().addAll(((Pane) estabDataContainer.getContent()).getChildren());
        estabDataContainer.setContent(container);
    }
}
