package net.deludobellico.stabeditor.controller;

import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.deludobellico.stabeditor.model.ElementModel;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.model.EstabReference;
import net.deludobellico.stabeditor.model.RelatedElementLists;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Settings;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainController implements Initializable {
    private static final Logger LOG = Logger.getLogger(MainController.class.getName());

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
    private Button removeElementButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private EstabDataController sourcePaneController;

    @FXML
    private EstabDataController targetPaneController;

    private File sourceEstabFile;
    private File targetEstabFile;

    private Stage stage;
    private BooleanProperty disableCopy = new SimpleBooleanProperty(true);

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        targetPaneController.set("Target Estab", true, this);
        sourcePaneController.set("Source Estab", false, this);

        sourcePaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            // Only enable the paste button if there's a target file and a selected element
            if (targetPaneController.getEstabDataModel() != null && newValue != null)
                copyElementButton.setDisable(false);
            else copyElementButton.setDisable(true);
        });

        targetPaneController.getSearchResultsListView().getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (targetPaneController.getEstabDataModel() != null && newValue != null) {
                removeElementButton.setDisable(false);
            }
        });

        toolBar.managedProperty().bind(toolBar.visibleProperty());
        sourcePane.managedProperty().bind(sourcePane.visibleProperty());
        targetPane.managedProperty().bind(targetPane.visibleProperty());
        sourcePane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedSourcePane(sourcePane.isExpanded()));
        targetPane.expandedProperty().addListener(e -> Settings.getInstance().setExpandedTargetPane(targetPane.isExpanded()));

        estabDataContainer.setFitToWidth(true);
        try {
            toolBar.setVisible(Settings.getInstance().getVisibleToolbar());
            sourcePane.setVisible(Settings.getInstance().getVisibleSourcePanel());
            targetPane.setVisible(Settings.getInstance().getVisibleTargetPanel());

            toolbarRadioItem.setSelected(Settings.getInstance().getVisibleToolbar());
            sourceRadioItem.setSelected(Settings.getInstance().getVisibleSourcePanel());
            targetRadioItem.setSelected(Settings.getInstance().getVisibleTargetPanel());
            sourcePane.expandedProperty().set(Settings.getInstance().getExpandedSourcePane());
            targetPane.expandedProperty().set(Settings.getInstance().getExpandedTargetPane());

            if (!Settings.getInstance().getVerticalPanes()) togglePanesContainer(null);
        } catch (NullPointerException e) {
        }

        populateOpenRecentSourceMenu();
        populateOpenRecentTargetMenu();
    }

    private void populateOpenRecentTargetMenu() {
        targetOpenRecentMenuList.getItems().clear();
        for (String targetFile : Settings.getInstance().getTargetRecentFiles()) {
            File file = new File(targetFile);
            if (file.exists()){
                MenuItem recentTargetMenuItem = new MenuItem(file.getName());
                recentTargetMenuItem.setOnAction(event -> openTarget(file));
                targetOpenRecentMenuList.getItems().add(recentTargetMenuItem);
            }
        }
    }

    private void populateOpenRecentSourceMenu() {
        sourceOpenRecentMenuList.getItems().clear();
        for (String sourceFile : Settings.getInstance().getSourceRecentFiles()) {
            File file = new File(sourceFile);
            if (file.exists()) {
                MenuItem recentSourceMenuItem = new MenuItem(file.getName());
                recentSourceMenuItem.setOnAction(event -> openSource(file));
                sourceOpenRecentMenuList.getItems().add(recentSourceMenuItem);
            }
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
        sourcePaneController.setEstabDataModel(sourceEstabFile);
        sourceSaveAsMenuItem.setDisable(false);
        sourceCloseMenuItem.setDisable(false);
        Settings.getInstance().getSourceRecentFiles().add(file.getAbsolutePath());
        populateOpenRecentSourceMenu();
        sourcePane.expandedProperty().set(true);
        if (targetPaneController.getEstabDataModel() != null) disableCopy.set(false);
    }

    // TODO: check target has correct xml syntax
    private void openTarget(File file) {
        LOG.log(Level.INFO, "Opening target file: " + file.getName());
        disableCopy.set(true);
        targetEstabFile = file;
        targetPaneController.setEstabDataModel(targetEstabFile);
        saveDataButton.setDisable(false);
        targetSaveMenuItem.setDisable(false);
        targetSaveAsMenuItem.setDisable(false);
        targetCloseMenuItem.setDisable(false);
        if (targetPaneController.getEstabDataModel() != null) {
            disableCopy.set(false);
            if (sourcePaneController.getActiveElement() != null) {
                copyElementButton.setDisable(false);
            }
        }

        targetPane.expandedProperty().set(true);
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
    public void saveSourceAsAction(ActionEvent actionEvent) {
        File file = openFileChooser(true);
        if (file != null) {
            LOG.log(Level.INFO, "Saving source file " + targetEstabFile.getName() + " as " + file.getName());
            FileIO.copy(sourceEstabFile, file);
            openSource(file);
        }
    }

    @FXML
    public void sourceCloseAction(ActionEvent actionEvent) {
        disableCopy.set(true);
        getDisableCopyProperty().set(true);
        sourceCloseMenuItem.setDisable(true);
        sourcePane.expandedProperty().set(false);
        EstabDataModel edm = null;
        sourcePaneController.setEstabDataModel(edm);
        sourcePaneController.clear();
    }

    @FXML
    public void targetCloseAction(ActionEvent actionEvent) {
        disableCopy.set(true);
        getDisableCopyProperty().set(true);
        getDisableRemoveProperty().set(true);
        getDisableSaveProperty().set(true);
        targetCloseMenuItem.setDisable(true);
        targetPane.expandedProperty().set(false);
        EstabDataModel edm = null;
        targetPaneController.setEstabDataModel(edm);
        targetPaneController.clear();
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
    public void togglePanesContainer(ActionEvent actionEvent) {
        Pane container;
        boolean verticalPanes;
        if (estabDataContainer.getContent() instanceof VBox) {
            container = new HBox();
            verticalPanes = false;
        } else if (estabDataContainer.getContent() instanceof HBox) {
            container = new VBox();
            verticalPanes = true;
        } else return;

        container.getChildren().addAll(((Pane) estabDataContainer.getContent()).getChildren());
        estabDataContainer.setContent(container);
        Settings.getInstance().setVerticalPanes(verticalPanes);
    }

    @FXML
    private void copyToolbarButtonAction(ActionEvent actionEvent) {
        copyEstabElementFromCellList(sourcePaneController.getActiveElement());
    }

    @FXML
    private void removeToolbarButtonAction(ActionEvent actionEvent) {
        LOG.log(Level.INFO, "Removing estab element " + targetPaneController.getActiveElement().getName());
        targetPaneController.removeEstabElement(targetPaneController.getEstabDataModel().getRelatedElements(targetPaneController.getActiveElement()));
    }

    public void copyEstabElementFromCellList(ElementModel elementModel) {
        LOG.log(Level.INFO, "Copying estab element " + elementModel.getName());
        RelatedElementLists relatedElements = sourcePaneController.getEstabDataModel().getRelatedElements(elementModel);
        targetPaneController.getEstabDataModel().sortRelatedElements(relatedElements);
        if (targetPaneController.copyEstabElement(relatedElements)) {
            targetPaneController.setActiveElement(elementModel);
        }
    }

    public void removeEstabElementFromCellList(ElementModel elementModel) {
        LOG.log(Level.INFO, "Removing estab element " + elementModel.getName());
        targetPaneController.setActiveElement(elementModel);
        targetPaneController.removeEstabElement(targetPaneController.getEstabDataModel().getRelatedElements(elementModel));
    }

    @FXML
    public void exitApplication(ActionEvent actionEvent) {
        Platform.exit();
    }

    public Stage getStage() {
        return (Stage) rootPane.getScene().getWindow();
    }

    public Button getCopyElementButton() {
        return copyElementButton;
    }

    public Button getRemoveElementButton() {
        return removeElementButton;
    }

    public EstabDataController getSourceEditor() {
        return sourcePaneController;
    }

    public BooleanProperty getDisableCopyProperty() {
        return disableCopy;
    }

    public BooleanProperty getDisableRemoveProperty() {
        return removeElementButton.disableProperty();
    }

    public BooleanProperty getDisableSaveProperty() {
        return saveDataButton.disableProperty();
    }
}
