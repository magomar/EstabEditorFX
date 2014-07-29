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
import net.deludobellico.stabeditor.data.jaxb.*;
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
    private ListView listEstabFilesView;
    private ObservableList<File> listEstabFilesModel = FXCollections.observableArrayList();
    @FXML
    private Button addEstabButton;
    @FXML
    private Button removeEstabButton;

    @FXML
    private TextField numImagesTextField;
    @FXML
    private TextField numSidesTextField;
    @FXML
    private TextField numVehiclesTextField;
    @FXML
    private TextField numWeaponsTextField;
    @FXML
    private TextField numAmmosTextField;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        List<File> files = FileIO.listFiles(initialDirectory, XML_FILTER, false);
        listEstabFilesModel.addAll(files);
        listEstabFilesView.setItems(listEstabFilesModel);
        addEstabButton.setDisable(false);
        removeEstabButton.setDisable(true);
        listEstabFilesView.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean aBoolean2) {
                if (listEstabFilesView.isFocused()) {
                    removeEstabButton.setDisable(false);
                } else {
                    removeEstabButton.setDisable(true);
                }
            }
        });
    }

    @FXML
    private void addEstabAction(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        Path examplesPath = FileSystems.getDefault().getPath(System.getProperty("user.dir"), "/src/main/resources/", ESTAB_DATA_FOLDER);
        File initialDirectory = examplesPath.toFile();
        fileChooser.setInitialDirectory(initialDirectory);
        File file = fileChooser.showOpenDialog(null);
        if (null != file) {
            listEstabFilesModel.add(file);
            LOG.warning("New Estab included: " + file);
        }
        LOG.info("Estabs included: " + listEstabFilesModel);
        System.out.println("Estabs included: " + listEstabFilesModel);
    }

    @FXML
    private void removeEstabAction(ActionEvent action) {
        int selectedItem = listEstabFilesView.getSelectionModel().getSelectedIndex();
        if (selectedItem != -1) {
            listEstabFilesModel.remove(selectedItem);
        }
    }

    @FXML
    private void loadEstabAction(ActionEvent action) {
        int selectedItem = listEstabFilesView.getSelectionModel().getSelectedIndex();
        if (selectedItem == -1) return;
        EstabData data = (EstabData) FileIO.unmarshallXML(listEstabFilesModel.get(selectedItem), FileIO.UNMARSHALLER);
        List<Image> images = data.getImage();
        List<Side> sides = data.getSide();
        List<Vehicle> vehicles = data.getVehicle();
        List<Weapon> weapons = data.getWeapon();
        List<Ammo> ammos = data.getAmmo();
        numImagesTextField.setText(String.valueOf(images.size()));
        numSidesTextField.setText(String.valueOf(sides.size()));
        numVehiclesTextField.setText(String.valueOf(vehicles.size()));
        numWeaponsTextField.setText(String.valueOf(weapons.size()));
        numAmmosTextField.setText(String.valueOf(ammos.size()));
    }
}
