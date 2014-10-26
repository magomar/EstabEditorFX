package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import net.deludobellico.stabeditor.model.EstabDataModel;
import net.deludobellico.stabeditor.util.FileIO;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Logger;

public class EstabEditorController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EstabEditorController.class.getName());
    private static final String ESTAB_DATA_FOLDER = "datasets";
    private static final FilenameFilter XML_FILTER = new FilenameFilter() {
        public boolean accept(File dir, String name) {
            String lowercaseName = name.toLowerCase();
            if (lowercaseName.endsWith(".xml")) {
                return true;
            } else {
                return false;
            }
        }
    };

    @FXML
    private ListView<File> estabFileListView;

    @FXML
    private Button addEstabButton;

    @FXML
    private Button openSourceEstabButton;

    @FXML
    private Button openTargetEstabButton;

    @FXML
    private Button copyElementButton;

    @FXML
    private Button saveDataButton;

    @FXML
    private Button removeEstabButton;

    @FXML
    private EstabDataController sourceEstabDataController;

    @FXML
    private EstabDataController targetEstabDataController;

    @FXML
    private TextField targetEstabFileTextField;


    private ObservableList<File> estabFileObservableList = FXCollections.observableArrayList();
    private File targetEstabFile;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        List<File> files = FileIO.listFiles(initialDirectory, XML_FILTER, false);
        estabFileObservableList.addAll(files);
        estabFileListView.setItems(estabFileObservableList);
        addEstabButton.setDisable(false);
        removeEstabButton.setDisable(true);
        openSourceEstabButton.setDisable(true);
        openTargetEstabButton.setDisable(true);
        copyElementButton.setDisable(true);
        saveDataButton.setDisable(true);
        estabFileListView.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean aBoolean2) {
                boolean estabsListViewFocused = estabFileListView.isFocused();
                removeEstabButton.setDisable(!estabsListViewFocused);
                openSourceEstabButton.setDisable(false);
                openTargetEstabButton.setDisable(false);
            }
        });
        sourceEstabDataController.setTitle("Source Estab Data:");
        targetEstabDataController.setTitle("Target Estab Data: ");
        sourceEstabDataController.setEditable(false);
        targetEstabDataController.setEditable(true);
        sourceEstabDataController.getSearchResultsListView().getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                // Only enable the copy button if there's a target and a selected element

                if (targetEstabDataController.getEstabDataModel() != null && newValue != null) {
                    copyElementButton.setDisable(false);
                } else {
                    copyElementButton.setDisable(true);
                }
            }
        });
    }

    @FXML
    private void copyElementAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        targetEstabDataController.setActiveComponent(sourceEstabDataController.getActiveComponent());
        targetEstabDataController.pasteActiveComponent();
    }

    @FXML
    private void saveEstabDataAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
//        saveDataButton.setDisable(true);
        targetEstabDataController.saveDataModel(targetEstabFile);
    }

    @FXML
    private void addEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showOpenDialog(null);
        if (null != file) {
            estabFileObservableList.add(file);
            LOG.info("New Estab included: " + file);
        }
    }

    @FXML
    private void removeEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        int selectedItem = estabFileListView.getSelectionModel().getSelectedIndex();
        if (selectedItem != -1) {
            estabFileObservableList.remove(selectedItem);
        }
    }

    @FXML
    private void openSourceEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        int selectedItem = estabFileListView.getSelectionModel().getSelectedIndex();
        if (selectedItem == -1) return;
        File file = estabFileObservableList.get(selectedItem);
        sourceEstabDataController.setTitle("Source Estab: " + file.getName());
        sourceEstabDataController.setEstabDataModel(new EstabDataModel(file));
    }

    @FXML
    private void openTargetEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        targetEstabFile = estabFileListView.getSelectionModel().getSelectedItem();
        if (null == targetEstabFile) return;
        targetEstabFileTextField.setText(targetEstabFile.getName());
        targetEstabDataController.setTitle("Target Estab: " + targetEstabFile.getName());
        targetEstabDataController.setEstabDataModel(new EstabDataModel(targetEstabFile));
        saveDataButton.setDisable(false);

    }

    @FXML
    private void openEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showOpenDialog(null);
        if (null != file) {
            targetEstabFileTextField.setText(file.getName());
            targetEstabDataController.setEstabDataModel(new EstabDataModel(file));
            targetEstabDataController.setTitle("Target Estab: " + file.getName());
        }
    }

    @FXML
    private void newEstabAction(ActionEvent actionEvent) {
        LOG.info(actionEvent.toString());
//        FileChooser fileChooser = new FileChooser();
//        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
//        File initialDirectory = examplesPath.toFile();
//        fileChooser.setInitialDirectory(initialDirectory);
//        File file = fileChooser.showSaveDialog(null);
//        if (null != file) {
//        }
        targetEstabFileTextField.setText("NewStab.xml");
        targetEstabDataController.setEstabDataModel(new EstabDataModel());
        targetEstabDataController.setTitle("Target Estab: NewStab.xml");
    }
}
