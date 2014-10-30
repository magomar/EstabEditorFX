package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.FireType;
import net.deludobellico.stabeditor.data.jaxb.PrimaryRole;
import net.deludobellico.stabeditor.data.jaxb.WeaponType;
import net.deludobellico.stabeditor.model.AssetModel;
import net.deludobellico.stabeditor.model.PerformanceModel;
import net.deludobellico.stabeditor.model.RangeItemModel;
import net.deludobellico.stabeditor.model.WeaponModel;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class WeaponEditorController implements Initializable, AssetEditorController {

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
    private Label fireTypeLabel;

    @FXML
    private TextField minRange;

    @FXML
    private ListView<FireType> performanceFireTypeList;
    private ObservableList<FireType> fireTypeObservableList = FXCollections.observableArrayList();

    @FXML
    private TableView<RangeItemModel> rangeItemTableView;
    @FXML
    private TableColumn<RangeItemModel, Integer> rangeTableRangeColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableAccuracyColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableArmorColumn;
    private ObservableList<RangeItemModel> rangeItemObservableList = FXCollections.observableArrayList();

    private WeaponModel weapon;
    private PerformanceModel performance;

    private boolean isEditable;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rangeItemTableView.setItems(rangeItemObservableList);
        rangeItemTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            removeRangeButton.setDisable(false);
        });

        performanceFireTypeList.setItems(fireTypeObservableList);
        performanceFireTypeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            PerformanceModel previousPerformance = performance;
            List<PerformanceModel> performanceList = WeaponEditorController.this.weapon.getPerformances();

            performanceList.stream()
                    .filter(p -> p.getFireType().equals(newValue))
                    .forEach(r -> {
                        if (oldValue != null && previousPerformance != null) unbindPerformanceProperties(r);
                        bindPerformanceProperties(r);
                        performance = r;
                    });

            addRangeButton.setDisable(!isEditable);
            removeRangeButton.setDisable(true);
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
    void addRangeToTable(ActionEvent event) {

        if (tableNewRangeValue.getText().isEmpty() || tableNewAccuracyValue.getText().isEmpty() || tableNewArmorPenetrationValue.getText().isEmpty()) {
            UtilView.showErrorEmptyFields();
        } else {
            RangeItemModel rangeItem = new RangeItemModel();
            rangeItem.setRange(Integer.valueOf(tableNewRangeValue.getText()));
            rangeItem.setAccuracy(Double.valueOf(tableNewAccuracyValue.getText()));
            rangeItem.setArmourPenetration(Double.valueOf(tableNewArmorPenetrationValue.getText()));
            performance.getRanges().add(rangeItem);
            rangeItemObservableList.add(rangeItem);
        }


    }

    @FXML
    void removeRangeFromTable(ActionEvent event) {
        Action response = UtilView.showWarningRemoveElement();
        if (response == Dialog.ACTION_OK) {
            RangeItemModel r = rangeItemObservableList.remove(rangeItemTableView.getSelectionModel().getSelectedIndex());
            performance.getRanges().remove(r);
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
        rangeItemObservableList.clear();

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
        fireTypeLabel.setText(p.getFireType().value());
        // Fill Range Items

        rangeItemObservableList.addAll(p.getRanges());
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
        //rangeItemObservableList.clear();
        //rangeItemObservableList.addAll(p.getRangeTable().rangeItemProperty());
    }

    @Override
    public void setEditable(boolean isEditable) {
        this.isEditable = isEditable;
        weightTextField.setEditable(isEditable);
        name.setEditable(isEditable);
        description.setEditable(isEditable);
        crew.setEditable(isEditable);
        reliability.setEditable(isEditable);
        weaponPrimaryRole.setEditable(isEditable);
        weaponType.setEditable(isEditable);
        singleShot.setDisable(!isEditable);
        singleShot.setStyle("-fx-opacity: 1");
        mustDeployToFire.setDisable(!isEditable);
        mustDeployToFire.setStyle("-fx-opacity: 1");
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
    public void bindProperties(AssetModel asset) {
        weightTextField.textProperty().bindBidirectional(weapon.weightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(weapon.nameProperty());
        description.textProperty().bindBidirectional(weapon.descriptionProperty());
        crew.textProperty().bindBidirectional(weapon.crewProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(weapon.reliabilityProperty(), new NumberStringConverter());
        calibre.textProperty().bindBidirectional(weapon.calibreProperty(), new NumberStringConverter());
        muzzleVelocity.textProperty().bindBidirectional(weapon.muzzleVelocityProperty(), new NumberStringConverter());

        weaponType.getSelectionModel().select(weapon.getType());
        weaponPrimaryRole.getSelectionModel().select(weapon.getPrimaryRole());

        singleShot.setSelected(weapon.getSingleShot());
        mustDeployToFire.setSelected(weapon.getMustDeployToFire());

    }

    @Override
    public void unbindProperties(AssetModel asset) {
        weightTextField.textProperty().unbindBidirectional(weapon.weightProperty());
        name.textProperty().unbindBidirectional(weapon.nameProperty());
        description.textProperty().unbindBidirectional(weapon.descriptionProperty());
        crew.textProperty().unbindBidirectional(weapon.crewProperty());
        reliability.textProperty().unbindBidirectional(weapon.reliabilityProperty());
        calibre.textProperty().unbindBidirectional(weapon.calibreProperty());
        muzzleVelocity.textProperty().unbindBidirectional(weapon.muzzleVelocityProperty());
    }

    @Override
    public WeaponModel getEstabElement() {
        return weapon;
    }

    @Override
    public void setEstabElement(AssetModel asset) {
        WeaponModel newWeapon = (WeaponModel) asset;
        WeaponModel previousWeapon = this.weapon;
        this.weapon = newWeapon;

        if (previousWeapon != null) unbindProperties(previousWeapon);
        bindProperties(newWeapon);

        fireTypeObservableList.clear();
        // Fill Fire Type list
        WeaponModel.getFireTypeMap(this.weapon).entrySet().stream().filter(entry -> entry.getValue()).forEach(entry -> fireTypeObservableList.add(entry.getKey()));
        performanceFireTypeList.getSelectionModel().clearSelection();
    }


}
