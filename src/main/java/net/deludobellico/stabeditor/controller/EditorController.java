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

public class EditorController implements Initializable {
    private static final Logger LOG = Logger.getLogger(EditorController.class.getName());
    private static final String ESTAB_DATA_FOLDER = "examples";
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
    private ListView estabsListView;
    private ObservableList<File> estabsListModel = FXCollections.observableArrayList();

    @FXML
    private Button addEstabButton;

    @FXML
    private Button removeEstabButton;

    @FXML
    private EstabDataController sourceEstabDataController;

    @FXML
    private EstabDataController targetEstabDataController;

    @FXML
    private TextField targetEstabTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        List<File> files = FileIO.listFiles(initialDirectory, XML_FILTER, false);
        estabsListModel.addAll(files);
        estabsListView.setItems(estabsListModel);
        addEstabButton.setDisable(false);
        removeEstabButton.setDisable(true);
        estabsListView.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean aBoolean2) {
                if (estabsListView.isFocused()) {
                    removeEstabButton.setDisable(false);
                } else {
                    removeEstabButton.setDisable(true);
                }
            }
        });
        sourceEstabDataController.setTitle("Source Estab Data:");
        targetEstabDataController.setTitle("Target Estab Data: ");
    }

    @FXML
    private void addEstabAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showOpenDialog(null);
        if (null != file) {
            estabsListModel.add(file);
            LOG.info("New Estab included: " + file);
        }
    }

    @FXML
    private void removeEstabAction(ActionEvent actionEvent) {
        int selectedItem = estabsListView.getSelectionModel().getSelectedIndex();
        if (selectedItem != -1) {
            estabsListModel.remove(selectedItem);
        }
    }

    @FXML
    private void loadEstabAction(ActionEvent actionEvent) {
        int selectedItem = estabsListView.getSelectionModel().getSelectedIndex();
        if (selectedItem == -1) return;
        File file = estabsListModel.get(selectedItem);
        sourceEstabDataController.setTitle("Source Estab: " + file.getName());
        sourceEstabDataController.setEstabDataModel(new EstabDataModel(file));
    }

    @FXML
    private void openEstabAction(ActionEvent actionEvent) {
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showOpenDialog(null);
        if (null != file) {
            targetEstabTextField.setText(file.getName());
            targetEstabDataController.setEstabDataModel(new EstabDataModel(file));
            targetEstabDataController.setTitle("Target Estab: " + file.getName());
        }
    }

    @FXML
    private void newEstabAction(ActionEvent actionEvent) {
//        FileChooser fileChooser = new FileChooser();
//        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
//        File initialDirectory = examplesPath.toFile();
//        fileChooser.setInitialDirectory(initialDirectory);
//        File file = fileChooser.showSaveDialog(null);
//        if (null != file) {
            targetEstabTextField.setText("NewStab.xml");
            targetEstabDataController.setEstabDataModel(new EstabDataModel());
            targetEstabDataController.setTitle("Target Estab: NewStab.xml");
//        }
    }
}
