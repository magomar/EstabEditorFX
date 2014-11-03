package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.model.AmmoModel;
import net.deludobellico.stabeditor.model.PerformanceModel;
import net.deludobellico.stabeditor.model.RangeItemModel;
import net.deludobellico.stabeditor.model.WeaponModel;
import net.deludobellico.stabeditor.view.SearchDialog;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class WeaponEditorController implements Initializable, ElementEditorController<WeaponModel> {

    @FXML
    private TextField reliability;

    @FXML
    private TextArea description;

    @FXML
    private Button addRangeButton;

    @FXML
    private TextField crew;

    @FXML
    private TextField burstRadius;

    @FXML
    private TextField fireRateNormal;

    @FXML
    private TextField load;

    @FXML
    private CheckBox singleShot;

    @FXML
    private CheckBox mustDeployToFire;

    @FXML
    private Button removeRangeButton;

    @FXML
    private ComboBox<PrimaryRole> weaponPrimaryRole;

    @FXML
    private TextField fireRateSlow;

    @FXML
    private TextField fireRateRapid;

    @FXML
    private TextField tableNewRangeValue;

    @FXML
    private TextField muzzleVelocity;

    @FXML
    private TextField shellWeight;

    @FXML
    private Label ammoNameLabel;

    @FXML
    private TextField tableNewAccuracyValue;

    @FXML
    private TextField calibre;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField name;

    @FXML
    private ComboBox<WeaponType> weaponType;

    @FXML
    private TextField tableNewArmorPenetrationValue;

    @FXML
    private TextField minRange;

    @FXML
    private ListView<FireType> performanceFireTypeList;

    @FXML
    private ComboBox<FireType> performanceFireTypeComboBox;

    @FXML
    private Button performanceFireTypeAddButton;

    @FXML
    private Button performanceFireTypeRemoveButton;

    @FXML
    private TableView<RangeItemModel> rangeItemTableView;
    @FXML
    private TableColumn<RangeItemModel, Integer> rangeTableRangeColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableAccuracyColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableArmorColumn;

    private WeaponModel weapon;
    private PerformanceModel performance;
    private Map<FireType, PerformanceModel> performanceFireTypeMap = new HashMap<>();

    private EstabDataController estabDataController;

    private boolean isEditable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rangeItemTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            removeRangeButton.setDisable(false);
        });

        //performanceFireTypeList.setItems(fireTypeObservableList);
        performanceFireTypeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (performance != null) unbindPerformanceProperties(performance);
                this.performance = performanceFireTypeMap.get(newValue);
                bindPerformanceProperties(performance);
                addRangeButton.setDisable(!isEditable);
                removeRangeButton.setDisable(true);
            }
        });

        weaponType.setItems(FXCollections.observableArrayList(WeaponType.values()));
        weaponType.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) weapon.setType(newValue);
        });

        weaponPrimaryRole.setItems(FXCollections.observableArrayList(PrimaryRole.values()));
        weaponPrimaryRole.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) weapon.setPrimaryRole(newValue);
        });

        singleShot.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) weapon.setSingleShot(newValue);
        });

        mustDeployToFire.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (null != newValue) weapon.setMustDeployToFire(newValue);
        });

    }

    @FXML
    protected void addRangeToTable(ActionEvent event) {

        if (tableNewRangeValue.getText().isEmpty() || tableNewAccuracyValue.getText().isEmpty() || tableNewArmorPenetrationValue.getText().isEmpty()) {
            UtilView.showErrorEmptyFields();
        } else {
            RangeItemModel rangeItem = new RangeItemModel();
            rangeItem.setRange(Integer.valueOf(tableNewRangeValue.getText()));
            rangeItem.setAccuracy(Double.valueOf(tableNewAccuracyValue.getText()));
            rangeItem.setArmourPenetration(Double.valueOf(tableNewArmorPenetrationValue.getText()));
            performance.getRanges().add(rangeItem);
            rangeItemTableView.getItems().add(rangeItem);
        }
    }

    @FXML
    protected void removeRangeFromTable(ActionEvent event) {
        Action response = UtilView.showWarningRemoveElement();
        if (response == Dialog.ACTION_OK) {
            RangeItemModel r = rangeItemTableView.getItems().remove(rangeItemTableView.getSelectionModel().getSelectedIndex());
            performance.getRanges().remove(r);
        }
    }

    @FXML
    protected void performanceAddFireType(ActionEvent actionEvent) {
        if (performanceFireTypeComboBox.getSelectionModel().getSelectedItem() != null) {
            AmmoModel ammo = (AmmoModel) SearchDialog.init(getEstabDataController().getMainController().getStage(), "Select ammo", getEstabDataController().getEstabDataModel().getAmmo().values()).show();

            AmmoLoad ammoLoad = new AmmoLoad();
            ammoLoad.setObjectId(ammo.getId());
            ammoLoad.setName(ammo.getName());

            ROF rof = new ROF();
            rof.setNormal(0.0);
            rof.setRapid(0.0);
            rof.setSlow(0.0);

            RangeTable rangeTable = new RangeTable();

            Performance p = new Performance();
            p.setAmmo(ammoLoad);
            p.setRof(rof);
            p.setRangeTable(rangeTable);

            PerformanceModel pModel = new PerformanceModel(p);

            FireType newFireType = performanceFireTypeComboBox.getSelectionModel().getSelectedItem();
            pModel.setFireType(newFireType);
            performanceFireTypeMap.put(newFireType, pModel);
            performanceFireTypeList.getItems().add(newFireType);
            performanceFireTypeComboBox.getItems().remove(performanceFireTypeComboBox.getSelectionModel().getSelectedIndex());
            weapon.getPerformances().add(pModel);
        }
    }

    @FXML
    protected void performanceRemoveFireType(ActionEvent actionEvent) {
        if (!performanceFireTypeList.getSelectionModel().getSelectedItems().isEmpty()) {
            performanceFireTypeList.getItems().remove(performanceFireTypeList.getSelectionModel().getSelectedItem());
        }
    }

    private void unbindPerformanceProperties(PerformanceModel p) {
        minRange.textProperty().unbindBidirectional(p.minRangeProperty());
        fireRateSlow.textProperty().unbindBidirectional(p.slowROFProperty());
        fireRateNormal.textProperty().unbindBidirectional(p.normalROFProperty());
        fireRateRapid.textProperty().unbindBidirectional(p.rapidROFProperty());
        burstRadius.textProperty().unbindBidirectional(p.burstRadiusProperty());
        shellWeight.textProperty().unbindBidirectional(p.shellWeightProperty());
        load.textProperty().unbindBidirectional(p.ammoLoadProperty());
        rangeItemTableView.getItems().clear();

    }

    private void bindPerformanceProperties(PerformanceModel p) {
        minRange.textProperty().bindBidirectional(p.minRangeProperty(), new NumberStringConverter());
        fireRateSlow.textProperty().bindBidirectional(p.slowROFProperty(), new NumberStringConverter());
        fireRateNormal.textProperty().bindBidirectional(p.normalROFProperty(), new NumberStringConverter());
        fireRateRapid.textProperty().bindBidirectional(p.rapidROFProperty(), new NumberStringConverter());
        burstRadius.textProperty().bindBidirectional(p.burstRadiusProperty(), new NumberStringConverter());
        shellWeight.textProperty().bindBidirectional(p.shellWeightProperty(), new NumberStringConverter());
        load.textProperty().bindBidirectional(p.getAmmoLoad().loadProperty(), new NumberStringConverter());

        ammoNameLabel.setText(p.getAmmoLoad().getName());

        rangeTableRangeColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Integer>forTableColumn(new IntegerStringConverter()));
        rangeTableRangeColumn.setCellValueFactory(param -> param.getValue().rangeProperty().asObject());

        rangeTableAccuracyColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Double>forTableColumn(new DoubleStringConverter()));
        rangeTableAccuracyColumn.setCellValueFactory(param -> param.getValue().accuracyProperty().asObject());

        rangeTableArmorColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Double>forTableColumn(new DoubleStringConverter()));
        rangeTableArmorColumn.setCellValueFactory(param -> param.getValue().armourPenetrationProperty().asObject());
        rangeItemTableView.getColumns().clear();
        rangeItemTableView.getColumns().add(rangeTableRangeColumn);
        rangeItemTableView.getColumns().add(rangeTableAccuracyColumn);
        rangeItemTableView.getColumns().add(rangeTableArmorColumn);
        rangeItemTableView.getItems().addAll(p.getRanges());
    }

    @Override
    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
        weightTextField.setEditable(isEditable);
        name.setEditable(isEditable);
        description.setEditable(isEditable);
        crew.setEditable(isEditable);
        reliability.setEditable(isEditable);
        weaponPrimaryRole.setDisable(!isEditable);
        weaponType.setDisable(!isEditable);
        singleShot.setDisable(!isEditable);
        mustDeployToFire.setDisable(!isEditable);
        calibre.setEditable(isEditable);
        muzzleVelocity.setEditable(isEditable);
        minRange.setEditable(isEditable);
        fireRateSlow.setEditable(isEditable);
        fireRateNormal.setEditable(isEditable);
        fireRateRapid.setEditable(isEditable);
        burstRadius.setEditable(isEditable);
        shellWeight.setEditable(isEditable);
        load.setEditable(isEditable);
        rangeItemTableView.setEditable(isEditable);
        tableNewRangeValue.setEditable(isEditable);
        tableNewAccuracyValue.setEditable(isEditable);
        tableNewArmorPenetrationValue.setEditable(isEditable);
    }

    @Override
    public void bindProperties(WeaponModel element) {
        weightTextField.textProperty().bindBidirectional(element.weightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        crew.textProperty().bindBidirectional(element.crewProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(element.reliabilityProperty(), new NumberStringConverter());
        calibre.textProperty().bindBidirectional(element.calibreProperty(), new NumberStringConverter());
        muzzleVelocity.textProperty().bindBidirectional(element.muzzleVelocityProperty(), new NumberStringConverter());

        weaponType.getSelectionModel().select(element.getType());
        weaponPrimaryRole.getSelectionModel().select(element.getPrimaryRole());

        singleShot.setSelected(element.getSingleShot());
        mustDeployToFire.setSelected(element.getMustDeployToFire());

    }

    @Override
    public void unbindProperties(WeaponModel element) {
        weightTextField.textProperty().unbindBidirectional(element.weightProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        crew.textProperty().unbindBidirectional(element.crewProperty());
        reliability.textProperty().unbindBidirectional(element.reliabilityProperty());
        calibre.textProperty().unbindBidirectional(element.calibreProperty());
        muzzleVelocity.textProperty().unbindBidirectional(element.muzzleVelocityProperty());
    }

    @Override
    public void clear() {
        unbindProperties(weapon);
    }

    @Override
    public WeaponModel getEstabElement() {
        return weapon;
    }

    @Override
    public void setEstabElement(WeaponModel element) {
        if (weapon != null) unbindProperties(weapon);
        this.weapon = element;
        bindProperties(weapon);

        performanceFireTypeList.getItems().clear();
        performanceFireTypeComboBox.getItems().clear();
        performanceFireTypeMap = WeaponModel.getFireTypeMap(this.weapon);
        for (Map.Entry<FireType, PerformanceModel> entry : performanceFireTypeMap.entrySet()) {
            if (entry.getValue() != null) {
                // Fill FireTypeList with this performance fire types
                performanceFireTypeList.getItems().add(entry.getKey());
            } else {
                // Fill combo box with the excluded fire types
                performanceFireTypeComboBox.getItems().add(entry.getKey());
            }
        }

        //WeaponModel.getFireTypeMap(this.weapon).entrySet().stream().filter(entry -> entry.getValue()).forEach(entry -> fireTypeObservableList.add(entry.getKey()));
        performanceFireTypeList.getSelectionModel().clearSelection();
    }

    @Override
    public EstabDataController getEstabDataController() {
        return estabDataController;
    }

    @Override
    public void setEstabDataController(EstabDataController estabDataController) {
        this.estabDataController = estabDataController;
    }
}
