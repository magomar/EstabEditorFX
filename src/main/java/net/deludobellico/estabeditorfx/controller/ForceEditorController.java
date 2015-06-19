package net.deludobellico.estabeditorfx.controller;

/**
 * Created by Heine on 11/10/2014.
 */

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.util.converter.IntegerStringConverter;
import net.deludobellico.estabeditorfx.util.ViewUtil;
import net.deludobellico.estabeditorfx.data.jaxb.*;
import net.deludobellico.estabeditorfx.model.*;

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
    private Label equipmentType;
    @FXML
    private Label equipmentName;
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
    private TableColumn<EquipmentQtyModel, EquipmentQtyModel.EquipmentType> equipmentTypeColumn;
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
    private ComboBox<ForceSize> forceSizeSymbol;
    @FXML
    private ImageView militarySymbolView;
    @FXML
    private ImageView pictureSymbolView;
    @FXML
    private ImageView forceSizeSymbolView;

    //Right column
    @FXML
    private ColorPicker backgroundColorChooser;
    @FXML
    private ColorPicker backgroundLightColorChooser;
    @FXML
    private ColorPicker backgroundDarkColorChooser;
    @FXML
    private ColorPicker designationColorChooser;
    @FXML
    private CheckBox usesServiceColors;

    /**
     * Compose tab
     */
    @FXML
    private VBox compositionPane;
    @FXML
    private CheckBox enableComposition;
    @FXML
    private Label subforceName;
    @FXML
    private Label subforceService;
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
                            target.setQty(target.getQty() + equipmentQty.getQty() * qty);
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
                enableComposition.setSelected(isComposed.get());
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
        forceSizeSymbol.getItems().addAll(ForceSize.values());
        militarySymbol.getItems().addAll(IconModel.MilitarySymbol.values());

        name.editableProperty().bind(isEditable);
        id.editableProperty().bind(isEditable);
        forceType.disableProperty().bind(isEditable.not());
        subForceType.disableProperty().bind(isEditable.not());
        combatClass.disableProperty().bind(isEditable.not());
        targetClass.disableProperty().bind(isEditable.not());
        moveClass.disableProperty().bind(isEditable.not());
        forceSize.disableProperty().bind(isEditable.not());
        commanderRank.disableProperty().bind(isEditable.not());

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
        symbolColor.disableProperty().bind(isEditable.not().or(usesServiceColors.selectedProperty()));
        militarySymbol.disableProperty().bind(isEditable.not());
        pictureSymbol.disableProperty().bind(isEditable.not());
        forceSizeSymbol.disableProperty().bind(isEditable.not());
        backgroundColorChooser.disableProperty().bind(isEditable.not().or(usesServiceColors.selectedProperty()));
        backgroundLightColorChooser.disableProperty().bind(isEditable.not().or(usesServiceColors.selectedProperty()));
        backgroundDarkColorChooser.disableProperty().bind(isEditable.not().or(usesServiceColors.selectedProperty()));
        designationColorChooser.disableProperty().bind(isEditable.not().or(usesServiceColors.selectedProperty()));

        subforceQty.editableProperty().bind(isEditable);

        compositionPane.disableProperty().bind(isEditable.not().or(enableComposition.selectedProperty().not()));

        militarySymbol.valueProperty().addListener((observable, oldValue, newValue) -> {
            militarySymbolView.setImage(newValue.getMilitarySymbol());
        });
        pictureSymbol.valueProperty().addListener((observable, oldValue, newValue) -> {
            pictureSymbolView.setImage(IconModel.getPictureSymbol(newValue));
        });
        forceSizeSymbol.valueProperty().addListener((observable, oldValue, newValue) -> {
            forceSizeSymbolView.setImage(IconModel.getForceSizeSymbol(newValue));
        });

        usesServiceColors.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.booleanValue()) {
                getActiveElement().setColorsFromService();
            }
        });
    }

    @FXML
    void equipmentAddAction() {
        if (equipmentName.getText().isEmpty() || equipmentQty.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            ViewUtil.showInfoDialog("Empty fields", "", "Please, fill the empty fields");
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
                model.link(getEstabEditorController().getEstabModel());
                getActiveElement().getEquipmentList().add(model);
            } else {
                ViewUtil.showInfoDialog("Repeated equipment", "", "The selected equipment is already included. Please, select another one.");
            }
        }
    }

    @FXML
    void equipmentSelectAction() {
        List<ElementModel> vehiclesAndWeapons = new ArrayList(getEstabEditorController().getEstabModel().getWeapons().values());
        vehiclesAndWeapons.addAll(getEstabEditorController().getEstabModel().getVehicles().values());
        ElementModel element = (ElementModel) ViewUtil.showSearchDialog("Select element", vehiclesAndWeapons);
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
            ViewUtil.showInfoDialog("Empty fields", "", "Please, fill the empty fields");
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
                ViewUtil.showInfoDialog("Repeated force", "", "The selected force is already included. Please, select another one.");
            }
        }
    }

    @FXML
    void forceSelectAction() {
        List<ElementModel> forces = new ArrayList(getEstabEditorController().getEstabModel().getForces().values());
        ElementModel element = (ElementModel) ViewUtil.showSearchDialog("Select element", forces);
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
        ForceModel force = getActiveElement();
        name.textProperty().bindBidirectional(force.nameProperty());
        id.textProperty().bindBidirectional(force.idProperty(), NUMBER_STRING_CONVERTER);
        forceType.valueProperty().bindBidirectional(force.typeProperty());
        subForceType.valueProperty().bindBidirectional(force.subTypeProperty());
        combatClass.valueProperty().bindBidirectional(force.combatClassProperty());
        targetClass.valueProperty().bindBidirectional(force.targetClassProperty());
        moveClass.valueProperty().bindBidirectional(force.moveTypeProperty());
        forceSize.valueProperty().bindBidirectional(force.sizeProperty());
        if (null == commanderRanks) commanderRanks = new CommanderRanks(getEstabEditorController().getEstabModel());
        commanderRank.setItems(commanderRanks.getServiceRankList(force.getService()));
        commanderRank.getSelectionModel().select(force.getCommanderRank());
        commanderRank.valueProperty().addListener(commanderRankListener);
        personnel.textProperty().bindBidirectional(force.personnelProperty(), NUMBER_STRING_CONVERTER);
        staffCapacity.textProperty().bindBidirectional(force.staffCapacityProperty(), NUMBER_STRING_CONVERTER);
        infantryValue.textProperty().bindBidirectional(force.infantryValueProperty(), NUMBER_STRING_CONVERTER);
        reconValue.textProperty().bindBidirectional(force.reconValueProperty(), NUMBER_STRING_CONVERTER);
        engineerValue.textProperty().bindBidirectional(force.engineeringValueProperty(), NUMBER_STRING_CONVERTER);
        canBombard.selectedProperty().bindBidirectional(force.canBombardProperty());
        normalSpeed.textProperty().bindBidirectional(force.normalSpeedProperty(), NUMBER_STRING_CONVERTER);
        maxSpeed.textProperty().bindBidirectional(force.maxSpeedProperty(), NUMBER_STRING_CONVERTER);
        deployed.textProperty().bindBidirectional(force.deployedProperty(), TIME_STRING_CONVERTER);
        dugIn.textProperty().bindBidirectional(force.dugInProperty(), TIME_STRING_CONVERTER);
        entrenched.textProperty().bindBidirectional(force.entrenchedProperty(), TIME_STRING_CONVERTER);
        fortified.textProperty().bindBidirectional(force.fortifiedProperty(), TIME_STRING_CONVERTER);
        basicConsumptionRate.textProperty().bindBidirectional(force.basicsConsumptionRateModifierProperty(), NUMBER_STRING_CONVERTER);
        fuelLoad.textProperty().bindBidirectional(force.fuelLoadProperty(), NUMBER_STRING_CONVERTER);

        // ICON
        symbolColor.valueProperty().bindBidirectional(force.getIcon().symbolColorProperty());
        militarySymbol.valueProperty().bindBidirectional(force.getIcon().militarySymbolProperty());
        pictureSymbol.valueProperty().bindBidirectional(force.getIcon().pictureSymbolProperty());
        forceSizeSymbol.valueProperty().bindBidirectional(force.getIcon().forceSizeIconProperty());
        backgroundColorChooser.valueProperty().bindBidirectional(force.getIcon().backgroundColorProperty());
        backgroundLightColorChooser.valueProperty().bindBidirectional(force.getIcon().backgroundLightColorProperty());
        backgroundDarkColorChooser.valueProperty().bindBidirectional(force.getIcon().backgroundDarkColorProperty());
        designationColorChooser.valueProperty().bindBidirectional(force.getIcon().designationColorProperty());

        // EQUIPMENT & SUPPLY
//        equipmentTypeColumn.setCellValueFactory(param -> {
//            EquipmentQtyModel.EquipmentType type;
//            if (param.getValue().getEquipmentType() == null) {
//                type = getEstabEditorController().getEstabModel().findEquipmentType(param.getValue());
//                param.getValue().setEquipmentType(type);
//            } else {
//                type = param.getValue().getEquipmentType();
//            }
//            return new SimpleObjectProperty<>(type);
//        });
        equipmentTypeColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getEquipmentType()));
        equipmentNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        equipmentQtyColumn.setCellFactory(TextFieldTableCell.<EquipmentQtyModel, Integer>forTableColumn(new IntegerStringConverter()));
        equipmentQtyColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        equipmentTableView.setItems(force.getEquipmentList());

        // SUBFORCE COMPOSITION
        subforceNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        subforceServiceColumn.setCellValueFactory(param1 -> {
            ForceModel forceModel = getEstabEditorController().getEstabModel().getForces().get(param1.getValue().getId());
            return new SimpleStringProperty(forceModel.getName());
        });
        subforceQtyColumn.setCellFactory(TextFieldTableCell.<ForceQtyModel, Integer>forTableColumn(new IntegerStringConverter()));
        subforceQtyColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        subforceTableView.setItems(force.getForceComposition());

        force.getForceComposition().addListener(forceCompositionListener);
        isComposed.set(!force.getForceComposition().isEmpty());
        enableComposition.setSelected(isComposed.get());
        usesServiceColors.setSelected(force.usesServiceColors());
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

