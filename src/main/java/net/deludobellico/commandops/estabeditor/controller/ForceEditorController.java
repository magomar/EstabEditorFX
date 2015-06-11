package net.deludobellico.commandops.estabeditor.controller;

/**
 * Created by Heine on 11/10/2014.
 */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.UtilView;

import java.net.URL;
import java.util.*;

public class ForceEditorController extends AbstractElementEditorController<ForceModel> {

    /**
     * Root pane
     */
    @FXML
    private TextField name;
    @FXML
    private TextField id;

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
    private ComboBox<RankModel> commanderRank;

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
    private TableView<EquipmentQtyModel> equipmentTableView;
    @FXML
    private TableColumn<EquipmentQtyModel, String> equipmentTypeColumn;
    @FXML
    private TableColumn<EquipmentQtyModel, String> equipmentNameColumn;
    @FXML
    private TableColumn<EquipmentQtyModel, Integer> equipmentQtyColumn;

    /**
     * Icon tab
     */
    // Left column
    @FXML
    private ComboBox<SymbolColor> symbolColor;
    @FXML
    private ComboBox<IconModel.MilitarySymbol> militarySymbol;
    @FXML
    private ComboBox<PictureSymbol> pictureSymbol;
    @FXML
    private ComboBox<ForceSize> forceSizeIcon;

    //Right column
    @FXML
    private ColorPicker backgroundColorChooser;
    @FXML
    private ColorPicker backgroundLightColorChooser;
    @FXML
    private ColorPicker backgroundDarkColorChooser;
    @FXML
    private ColorPicker designationColorChooser;

    /**
     * Compose tab
     */
    @FXML
    private TextField subforceName;
    @FXML
    private TextField subforceService;
    @FXML
    private TextField subforceQty;
    // Table
    @FXML
    private TableView<ForceQtyModel> subforceTableView;
    @FXML
    private TableColumn<ForceQtyModel, String> subforceNameColumn;
    @FXML
    private TableColumn<ForceQtyModel, String> subforceServiceColumn;
    @FXML
    private TableColumn<ForceQtyModel, Integer> subforceQtyColumn;

    /**
     * Other
     */
    private CommanderRanks commanderRanks;

    private BooleanProperty isComposed = new SimpleBooleanProperty(false);

    private BooleanProperty isEditable = new SimpleBooleanProperty(false);

    private final ChangeListener<RankModel> commanderRankListener = (observable, oldValue, newValue) -> {
        if (newValue != null)
            getActiveElement().setCommanderRank(newValue.getIndex());
    };

    private final ListChangeListener forceCompositionListener = new ListChangeListener<ForceQtyModel>() {
        @Override
        public void onChanged(Change<? extends ForceQtyModel> c) {
            ForceModel activeForce = getActiveElement();
            boolean needsUpdate = false;
            while (c.next()) if (c.wasAdded() || c.wasRemoved() || c.wasUpdated()) {
                needsUpdate = true;
                break;
            }
            if (needsUpdate) {
                int pers = 0;
                int staff = 0;
                int infantry = 0;
                int recon = 0;
                int engineer = 0;
                Map<Integer, EquipmentQtyModel> equipmentQties = new HashMap<>();
                for (ForceQtyModel forceQtyModel : activeForce.getForceComposition()) {
                    ForceModel forceModel = getEstabEditorController().getEstabModel().getForces().get(forceQtyModel.getId());
                    int qty = forceQtyModel.getQty();
                    pers += forceModel.getPersonnel() * qty;
                    staff = Math.max(staff, forceModel.getStaffCapacity());
                    infantry += forceModel.getInfantryValue() * qty;
                    recon += forceModel.getReconValue() * qty;
                    engineer += forceModel.getEngineeringValue() * qty;
                    for (EquipmentQtyModel equipmentQty : forceModel.getEquipmentList()) {
                        if (equipmentQties.containsKey(equipmentQty.getId())) {
                            EquipmentQtyModel target = equipmentQties.get(equipmentQty.getId());
                            target.setQty(target.getQty() + equipmentQty.getQty()*qty);
                        } else {
                            EquipmentQtyModel target = new EquipmentQtyModel();
                            target.setId(equipmentQty.getId());
                            target.setName(equipmentQty.getName());
                            target.setQty(equipmentQty.getQty() * qty);
                            equipmentQties.put(target.getId(), target);
                        }
                    }
                }
                activeForce.setPersonnel(pers);
                activeForce.setStaffCapacity(staff);
                activeForce.setInfantryValue(infantry);
                activeForce.setReconValue(recon);
                activeForce.setEngineeringValue(engineer);
                activeForce.getEquipmentList().clear();
                activeForce.getEquipmentList().addAll(equipmentQties.values());
                isComposed.set(!activeForce.getForceComposition().isEmpty());
            }
        }
    };

    /**
     * @param location
     * @param resources
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        forceType.getItems().addAll(ForceType.values());
        subForceType.getItems().addAll(ForceSubtype.values());
        combatClass.getItems().addAll(CombatClass.values());
        targetClass.getItems().addAll(TargetClass.values());
        moveClass.getItems().addAll(MoveType.values());
        forceSize.getItems().addAll(ForceSize.values());
        symbolColor.getItems().addAll(SymbolColor.values());
        pictureSymbol.getItems().addAll(PictureSymbol.values());
        forceSizeIcon.getItems().addAll(ForceSize.values());
        militarySymbol.getItems().addAll(IconModel.MilitarySymbol.values());

        name.editableProperty().bind(isEditable);
        id.editableProperty().bind(isEditable);
        forceType.editableProperty().bind(isEditable);
        subForceType.editableProperty().bind(isEditable);
        combatClass.editableProperty().bind(isEditable);
        targetClass.editableProperty().bind(isEditable);
        moveClass.editableProperty().bind(isEditable);
        forceSize.editableProperty().bind(isEditable);
        commanderRank.editableProperty().bind(isEditable);

        personnel.editableProperty().bind(isEditable.and(isComposed.not()));
        infantryValue.editableProperty().bind(isEditable.and(isComposed.not()));
        staffCapacity.editableProperty().bind(isEditable.and(isComposed.not()));
        reconValue.editableProperty().bind(isEditable.and(isComposed.not()));
        engineerValue.editableProperty().bind(isEditable.and(isComposed.not()));

        normalSpeed.editableProperty().bind(isEditable);
        maxSpeed.editableProperty().bind(isEditable);
        deployed.editableProperty().bind(isEditable);
        dugIn.editableProperty().bind(isEditable);
        entrenched.editableProperty().bind(isEditable);
        fortified.editableProperty().bind(isEditable);
        basicConsumptionRate.editableProperty().bind(isEditable);
        fuelLoad.editableProperty().bind(isEditable);
        equipmentQty.editableProperty().bind(isEditable.and(isComposed.not()));
        equipmentSelectButton.disableProperty().bind(isEditable.not().or(isComposed));
        equipmentRemoveButton.disableProperty().bind(isEditable.not().or(isComposed));
        equipmentAddButton.disableProperty().bind(isEditable.not().or(isComposed));
        equipmentTableView.editableProperty().bind(isEditable.and(isComposed.not()));
        symbolColor.editableProperty().bind(isEditable);
        militarySymbol.editableProperty().bind(isEditable);
        pictureSymbol.editableProperty().bind(isEditable);
        forceSizeIcon.editableProperty().bind(isEditable);
        backgroundColorChooser.editableProperty().bind(isEditable);
        backgroundLightColorChooser.editableProperty().bind(isEditable);
        backgroundDarkColorChooser.editableProperty().bind(isEditable);
        designationColorChooser.editableProperty().bind(isEditable);
        subforceQty.editableProperty().bind(isEditable);
    }

    @FXML
    void equipmentAddAction() {
        if (equipmentName.getText().isEmpty() || equipmentQty.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            UtilView.showInfoDialog("Empty fields", "", "Please, fill the empty fields");
        } else {
            ElementModel element = (ElementModel) equipmentName.getUserData();
            if (element == null) return;
            // Search for repeated equipment
            boolean repeatedEquipment = false;
            for (EquipmentQtyModel equipment : getActiveElement().getEquipmentList()) {
                if (equipment.getId() == element.getId()) {
                    repeatedEquipment = true;
                    break;
                }
            }
            if (!repeatedEquipment) {
                EquipmentQtyModel model = new EquipmentQtyModel();
                model.setId(element.getId());
                model.setName(element.getName());
                model.setQty(Integer.valueOf(equipmentQty.getText()));
                model.setEquipmentClass(element.getPojoClass());
//                equipmentTableView.getItems().add(model);
                getActiveElement().getEquipmentList().add(model);
            } else {
                UtilView.showInfoDialog("Repeated equipment", "", "The selected equipment is already included. Please, select another one.");
            }
        }
    }

    @FXML
    void equipmentSelectAction() {
        List<ElementModel> vehiclesAndWeapons = new ArrayList(getEstabEditorController().getEstabModel().getWeapons().values());
        vehiclesAndWeapons.addAll(getEstabEditorController().getEstabModel().getVehicles().values());
        ElementModel element = (ElementModel) UtilView.showSearchDialog("Select element", vehiclesAndWeapons);
        if (element != null) {
            equipmentName.setUserData(element);
            equipmentName.setText(element.getName());
            equipmentType.setText(element.getPojoClass().getSimpleName());
            equipmentQty.setText("1");
        }
    }

    @FXML
    void equipmentRemoveAction() {
        if (!equipmentTableView.getSelectionModel().getSelectedItems().isEmpty()) {
            getActiveElement().getEquipmentList().remove(equipmentTableView.getSelectionModel().getSelectedItem());
        }
    }

    @FXML
    void forceAddAction() {
        if (subforceName.getText().isEmpty() || subforceQty.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            UtilView.showInfoDialog("Empty fields", "", "Please, fill the empty fields");
        } else {
            ElementModel element = (ElementModel) subforceName.getUserData();
            if (element == null) return;
            // Search for repeated equipment
            boolean repeatedForce = false;
            for (ForceQtyModel subforce : getActiveElement().getForceComposition()) {
                if (subforce.getId() == element.getId()) {
                    repeatedForce = true;
                    break;
                }
            }
            if (!repeatedForce) {
                ForceQtyModel model = new ForceQtyModel();
                model.setId(element.getId());
                model.setName(element.getName());
                model.setQty(Integer.valueOf(subforceQty.getText()));
                getActiveElement().getForceComposition().add(model);
            } else {
                UtilView.showInfoDialog("Repeated force", "", "The selected force is already included. Please, select another one.");
            }
        }
    }

    @FXML
    void forceSelectAction() {
        List<ElementModel> forces = new ArrayList(getEstabEditorController().getEstabModel().getForces().values());
        ElementModel element = (ElementModel) UtilView.showSearchDialog("Select element", forces);
        if (element != null) {
            subforceName.setUserData(element);
            subforceName.setText(element.getName());
            ForceModel forceModel = getEstabEditorController().getEstabModel().getForces().get(element.getId());
            subforceService.setText(forceModel.getService().getName());
            subforceQty.setText("1");
        }
    }

    @FXML
    void forceRemoveAction() {
        if (!subforceTableView.getSelectionModel().getSelectedItems().isEmpty()) {
            getActiveElement().getForceComposition().remove(subforceTableView.getSelectionModel().getSelectedItem());
        }
    }

    @Override
    public void setEditable(boolean isEditable) {

        this.isEditable.set(isEditable);


    }

    @Override
    public void bindProperties() {
        ForceModel element = getActiveElement();
        name.textProperty().bindBidirectional(element.nameProperty());
        id.textProperty().bindBidirectional(element.idProperty(), NUMBER_STRING_CONVERTER);
        forceType.valueProperty().bindBidirectional(element.typeProperty());
        subForceType.valueProperty().bindBidirectional(element.subTypeProperty());
        combatClass.valueProperty().bindBidirectional(element.combatClassProperty());
        targetClass.valueProperty().bindBidirectional(element.targetClassProperty());
        moveClass.valueProperty().bindBidirectional(element.moveTypeProperty());
        forceSize.valueProperty().bindBidirectional(element.sizeProperty());
        if (null == commanderRanks) commanderRanks = new CommanderRanks(getEstabEditorController().getEstabModel());
        commanderRank.setItems(commanderRanks.getServiceRankList(element.getService()));
        commanderRank.getSelectionModel().select(element.getCommanderRank());
        commanderRank.valueProperty().addListener(commanderRankListener);
        personnel.textProperty().bindBidirectional(element.personnelProperty(), NUMBER_STRING_CONVERTER);
        staffCapacity.textProperty().bindBidirectional(element.staffCapacityProperty(), NUMBER_STRING_CONVERTER);
        infantryValue.textProperty().bindBidirectional(element.infantryValueProperty(), NUMBER_STRING_CONVERTER);
        reconValue.textProperty().bindBidirectional(element.reconValueProperty(), NUMBER_STRING_CONVERTER);
        engineerValue.textProperty().bindBidirectional(element.engineeringValueProperty(), NUMBER_STRING_CONVERTER);
        canBombard.selectedProperty().bindBidirectional(element.canBombardProperty());
        normalSpeed.textProperty().bindBidirectional(element.normalSpeedProperty(), NUMBER_STRING_CONVERTER);
        maxSpeed.textProperty().bindBidirectional(element.maxSpeedProperty(), NUMBER_STRING_CONVERTER);
        deployed.textProperty().bindBidirectional(element.deployedProperty(), TIME_STRING_CONVERTER);
        dugIn.textProperty().bindBidirectional(element.dugInProperty(), TIME_STRING_CONVERTER);
        entrenched.textProperty().bindBidirectional(element.entrenchedProperty(), TIME_STRING_CONVERTER);
        fortified.textProperty().bindBidirectional(element.fortifiedProperty(), TIME_STRING_CONVERTER);
        basicConsumptionRate.textProperty().bindBidirectional(element.basicsConsumptionRateModifierProperty(), NUMBER_STRING_CONVERTER);
        fuelLoad.textProperty().bindBidirectional(element.fuelLoadProperty(), NUMBER_STRING_CONVERTER);

        // ICON
        symbolColor.valueProperty().bindBidirectional(element.getIcon().symbolColorProperty());
        militarySymbol.valueProperty().bindBidirectional(element.getIcon().militarySymbolProperty());
        pictureSymbol.valueProperty().bindBidirectional(element.getIcon().pictureSymbolProperty());
        forceSizeIcon.valueProperty().bindBidirectional(element.getIcon().forceSizeIconProperty());
        backgroundColorChooser.valueProperty().bindBidirectional(element.getIcon().backgroundColorProperty());
        backgroundLightColorChooser.valueProperty().bindBidirectional(element.getIcon().backgroundLightColorProperty());
        backgroundDarkColorChooser.valueProperty().bindBidirectional(element.getIcon().backgroundDarkColorProperty());
        designationColorChooser.valueProperty().bindBidirectional(element.getIcon().designationColorProperty());

        // EQUIPMENT & SUPPLY
//        equipmentTableView.getColumns().clear();
        equipmentTypeColumn.setCellValueFactory(param -> {
            String type = "";
            if (param.getValue().getEquipmentClass() == null) {
                for (Map modelMap : getEstabEditorController().getEstabModel().getAll().values()) {
                    ElementModel elementModel = (ElementModel) modelMap.get(param.getValue().getId());
                    if (elementModel != null) {
                        param.getValue().setEquipmentClass(elementModel.getPojoClass());
                        type = element.getPojoClass().getSimpleName();
                        break;
                    }
                }
            } else {
                type = param.getValue().getEquipmentClass().getSimpleName();
            }
            return new SimpleStringProperty(type);
        });
        equipmentNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        equipmentQtyColumn.setCellFactory(TextFieldTableCell.<EquipmentQtyModel, Integer>forTableColumn(new IntegerStringConverter()));
        equipmentQtyColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        equipmentTableView.setItems(element.getEquipmentList());

        // SUBFORCE COMPOSITION
        subforceNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        subforceServiceColumn.setCellValueFactory(param1 -> {
            ForceModel forceModel = getEstabEditorController().getEstabModel().getForces().get(param1.getValue().getId());
            return new SimpleStringProperty(forceModel.getName());
        });
        subforceQtyColumn.setCellFactory(TextFieldTableCell.<ForceQtyModel, Integer>forTableColumn(new IntegerStringConverter()));
        subforceQtyColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        subforceTableView.setItems(element.getForceComposition());

        getActiveElement().getForceComposition().addListener(forceCompositionListener);
        isComposed.set(!getActiveElement().getForceComposition().isEmpty());
    }


    @Override
    public void unbindProperties() {
        ForceModel element = getActiveElement();
        name.textProperty().unbindBidirectional(element.nameProperty());
        id.textProperty().unbindBidirectional(element.idProperty());

        forceType.valueProperty().unbindBidirectional(element.typeProperty());
        subForceType.valueProperty().unbindBidirectional(element.subTypeProperty());
        combatClass.valueProperty().unbindBidirectional(element.combatClassProperty());
        targetClass.valueProperty().unbindBidirectional(element.targetClassProperty());
        moveClass.valueProperty().unbindBidirectional(element.moveTypeProperty());
        forceSize.valueProperty().unbindBidirectional(element.sizeProperty());
        commanderRank.valueProperty().removeListener(commanderRankListener);
        personnel.textProperty().unbindBidirectional(element.personnelProperty());
        staffCapacity.textProperty().unbindBidirectional(element.staffCapacityProperty());
        infantryValue.textProperty().unbindBidirectional(element.infantryValueProperty());
        reconValue.textProperty().unbindBidirectional(element.reconValueProperty());
        engineerValue.textProperty().unbindBidirectional(element.engineeringValueProperty());
        canBombard.selectedProperty().unbindBidirectional(element.canBombardProperty());

        normalSpeed.textProperty().unbindBidirectional(element.normalSpeedProperty());
        maxSpeed.textProperty().unbindBidirectional(element.maxSpeedProperty());

        deployed.textProperty().unbindBidirectional(element.deployedProperty());
        dugIn.textProperty().unbindBidirectional(element.dugInProperty());
        entrenched.textProperty().unbindBidirectional(element.entrenchedProperty());
        fortified.textProperty().unbindBidirectional(element.fortifiedProperty());

        militarySymbol.valueProperty().unbindBidirectional(element.getIcon().militarySymbolProperty());
        pictureSymbol.valueProperty().unbindBidirectional(element.getIcon().pictureSymbolProperty());
        forceSize.valueProperty().unbindBidirectional(element.sizeProperty());
        backgroundColorChooser.valueProperty().unbindBidirectional(element.getIcon().backgroundColorProperty());
        backgroundLightColorChooser.valueProperty().unbindBidirectional(element.getIcon().backgroundLightColorProperty());
        backgroundDarkColorChooser.valueProperty().unbindBidirectional(element.getIcon().backgroundDarkColorProperty());
        designationColorChooser.valueProperty().unbindBidirectional(element.getIcon().designationColorProperty());

        basicConsumptionRate.textProperty().unbindBidirectional(element.basicsConsumptionRateModifierProperty());
        fuelLoad.textProperty().unbindBidirectional(element.fuelLoadProperty());
        symbolColor.valueProperty().unbindBidirectional(element.getIcon().symbolColorProperty());

        equipmentTableView.setItems(null);

        subforceTableView.setItems(null);

        getActiveElement().getForceComposition().removeListener(forceCompositionListener);
    }

}

