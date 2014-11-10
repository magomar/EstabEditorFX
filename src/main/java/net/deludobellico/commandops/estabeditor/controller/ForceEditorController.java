package net.deludobellico.commandops.estabeditor.controller;

/**
 * Created by Heine on 11/10/2014.
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.model.ForceModel;

import java.net.URL;
import java.util.ResourceBundle;

public class ForceEditorController implements Initializable, ElementEditorController<ForceModel> {

    /**
     * Root pane
     */
    @FXML
    private TextField name;

    /**
     * General tab
     */
    // Left column
    @FXML
    private ComboBox<ForceType> forceType;
    @FXML
    private ComboBox<ForceSubtype> subForceType;
    @FXML
    private ComboBox<CombatClass> combatClass;
    @FXML
    private ComboBox<TargetClass> targetClass;
    @FXML
    private ComboBox<MoveType> moveClass;
    @FXML
    private ComboBox<ForceSize> forceSize;
    @FXML
    private ComboBox<Integer> commanderRank;

    // Right column
    @FXML
    private TextField personnel;
    @FXML
    private TextField staffCapacity;
    @FXML
    private TextField infantryValue;
    @FXML
    private TextField reconValue;
    @FXML
    private TextField engineerValue;

    @FXML
    private CheckBox canBombard;
    // Bottom region
    @FXML
    private TextField normalSpeed;
    @FXML
    private TextField maxSpeed;
    @FXML
    private TextField deployed;
    @FXML
    private TextField dugIn;
    @FXML
    private TextField entrenched;

    @FXML
    private TextField fortified;
    /**
     * Equipment/Supply tab
     */
    // Top region
    @FXML
    private TextField basicConsumptionRate;
    @FXML
    private TextField fuelLoad;
    @FXML
    private TextField equipmentType;
    @FXML
    private TextField equipmentName;
    @FXML
    private TextField equipmentQty;
    @FXML
    private Button equipmentSelectButton;
    @FXML
    private Button equipmentRemoveButton;
    @FXML
    private Button equipmentAddButton;

    // Table
    @FXML
    private TableColumn<?, ?> equipmentTypeColumn;
    @FXML
    private TableColumn<?, ?> equipmentNameColumn;
    @FXML
    private TableColumn<?, ?> equipmentQtyColumn;

    /**
     * Icon tab
     */
    @FXML
    private ColorPicker symbolColorChooser;
    @FXML
    private ComboBox<PictureSymbol> pictureSymbol;

    @FXML
    private ColorPicker backgroundColorChooser;

    @FXML
    private ColorPicker backgroundLightColorChooser;


    @FXML
    private ColorPicker backgroundDarkColorChooser;

    @FXML
    private ColorPicker designationColorChooser;

    @FXML
    private ComboBox<?> forceSizeIcon;

    @FXML
    private TableView<?> equipmentTableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    void equipmentAddAction(ActionEvent event) {

    }

    @FXML
    void equipmentRemoveAction(ActionEvent event) {

    }

    @FXML
    void equipmentSelectAction(ActionEvent event) {

    }

    @Override
    public ForceModel getActiveElement() {
        return null;
    }

    @Override
    public void setActiveElement(ForceModel element) {

    }

    @Override
    public void setEditable(boolean isEditable) {

    }

    @Override
    public void setEstabController(EstabController estabController) {

    }

    @Override
    public void bindProperties(ForceModel element) {

    }

    @Override
    public void unbindProperties(ForceModel element) {

    }

    @Override
    public void clear() {

    }
}

