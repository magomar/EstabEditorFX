package net.deludobellico.commandops.estabeditor.controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.DialogAction;
import net.deludobellico.commandops.estabeditor.util.UtilView;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This controller manages the weapon editor view and model.
 *
 * @author Mario
 * @author Heine
 * @see EstabEditorController
 */
public class WeaponEditorController implements Initializable, ElementEditorController<WeaponModel> {

    private static final StringConverter<Number> NUMBER_STRING_CONVERTER = new NumberStringConverter(Locale.ENGLISH);
    /**
     * Root node
     */
    @FXML
    private TextField name;

    /**
     * General tab
     */
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<WeaponType> weaponType;
    @FXML
    private ComboBox<PrimaryRole> weaponPrimaryRole;
    @FXML
    private CheckBox singleShot;
    @FXML
    private CheckBox mustDeployToFire;


    /**
     * Performance tab
     */
    // Top region
    @FXML
    private TextField calibre;
    @FXML
    private TextField muzzleVelocity;
    @FXML
    private TextField crew;
    @FXML
    private TextField reliability;
    @FXML
    private TextField weight;

    // Left region
    @FXML
    private ListView<FireType> performanceFireTypeList;
    @FXML
    private ComboBox<FireType> performanceFireTypeComboBox;
    @FXML
    private Button performanceFireTypeAddButton;
    @FXML
    private Button performanceFireTypeRemoveButton;

    // Center region
    @FXML
    private Label ammoNameLabel;
    @FXML
    private TextField load;
    @FXML
    private TextField minRange;
    @FXML
    private TextField fireRateSlow;
    @FXML
    private TextField fireRateNormal;
    @FXML
    private TextField fireRateRapid;
    @FXML
    private TextField burstRadius;
    @FXML
    private TextField shellWeight;

    // Range table
    @FXML
    private TableView<RangeItemModel> rangeItemTableView;
    @FXML
    private TableColumn<RangeItemModel, Integer> rangeTableRangeColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableAccuracyColumn;
    @FXML
    private TableColumn<RangeItemModel, Double> rangeTableArmorColumn;

    // Range table text fields
    @FXML
    private TextField tableNewRangeValue;
    @FXML
    private TextField tableNewAccuracyValue;
    @FXML
    private TextField tableNewArmorPenetrationValue;

    // Range table buttons
    @FXML
    private Button addRangeButton;
    @FXML
    private Button removeRangeButton;

    /**
     * Other
     */
    // Last bind weapon
    private WeaponModel activeWeapon;
    // Last bind weapon performance
    private PerformanceModel activePerformance;
    // Weapon performance by fire type map
    private Map<FireType, PerformanceModel> performanceFireTypeMap = new HashMap<>();
    // Parent controller
    private EstabEditorController estabEditorController;
    @FXML
    private ElementImageController imagePanelController;

    /**
     * Adds listeners to components and sets the initial item collections.
     *
     * @param location  is not used
     * @param resources is not used
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Bind selected performance and unbind the previous active performance
        performanceFireTypeList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                if (activePerformance != null) unbindPerformanceProperties(activePerformance);
                this.activePerformance = performanceFireTypeMap.get(newValue);
                bindPerformanceProperties(activePerformance);
            }
        });

        // Populate the weaponType combobox with all the weapon types
        weaponType.setItems(FXCollections.observableArrayList(WeaponType.values()));
        // Set the activeWeapon type with the one selected in the combobox

        // Populate the weaponPrimaryRole combobox with all the primary roles
        weaponPrimaryRole.setItems(FXCollections.observableArrayList(PrimaryRole.values()));
        // Set the activeWeapon primary role with the one selected in the combobox

        description.setWrapText(true);

        imagePanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = estabEditorController.getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        activeWeapon.setPictureId(im.getId());
                        activeWeapon.setPictureFilename(newValue);
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeWeapon.setPictureId(imageModel.getId());
                    activeWeapon.setPictureFilename(newValue);
                }
            }
        });
    }

    /**
     * Removes a range from the performance.
     * This method should be called when the {@link #addRangeButton} button is pressed.
     * It creates a new range item with the text fields values and adds it
     * to the {@link #rangeItemTableView} item collection and the {@link #activePerformance} ranges collection.
     *
     * @param actionEvent is not used
     * @see RangeItemModel
     */
    @FXML
    protected void addRangeToTable(ActionEvent actionEvent) {
        if (tableNewRangeValue.getText().isEmpty() || tableNewAccuracyValue.getText().isEmpty() || tableNewArmorPenetrationValue.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            UtilView.showInfoDialog("Empty fields", "Please, fill the empty fields", "", DialogAction.OK);
        } else {
            // Prepare the new RangeItemModel
            RangeItemModel rangeItem = new RangeItemModel();
            // Set its attributes with the text fields value
            rangeItem.setRange(Integer.valueOf(tableNewRangeValue.getText()));
            rangeItem.setAccuracy(Double.valueOf(tableNewAccuracyValue.getText()));
            rangeItem.setArmourPenetration(Double.valueOf(tableNewArmorPenetrationValue.getText()));
            // Add the new range to the active performance and the table
            activePerformance.getRanges().add(rangeItem);
            rangeItemTableView.getItems().add(rangeItem);
        }
    }

    /**
     * Removes a range from the performance.
     * This method should be called when the {@link #removeRangeButton} button is pressed.
     * It removes the selected range from the {@link #rangeItemTableView} and the {@link #activePerformance} ranges collection.
     *
     * @param actionEvent is not used
     * @see RangeItemModel
     */
    @FXML
    protected void removeRangeFromTable(ActionEvent actionEvent) {
        if (!rangeItemTableView.getSelectionModel().getSelectedItems().isEmpty()) {
            DialogAction response = UtilView.showInfoDialog("Removing Range", "", "Are you sure you want to delete this range?", DialogAction.CANCEL, DialogAction.OK);
            if (response == DialogAction.OK) {
                // Remove range from table and performance if the user said OK
                RangeItemModel r = rangeItemTableView.getItems().remove(rangeItemTableView.getSelectionModel().getSelectedIndex());
                activePerformance.getRanges().remove(r);
            }
        }
    }

    /**
     * Adds a performance to the weapon.
     * This method should be called when the {@link #performanceFireTypeAddButton} button is pressed.
     * It creates a new performance with the selected ammo by the user.
     * The new performance attributes will have the default value (other than the ammo id and name, that is).
     *
     * @param actionEvent is not used
     * @see PerformanceModel
     */
    @FXML
    protected void performanceAddFireType(ActionEvent actionEvent) {
        if (performanceFireTypeComboBox.getSelectionModel().getSelectedItem() != null) {
            AmmoModel selectedAmmo = (AmmoModel) UtilView.showSearchDialog("Select ammo", estabEditorController.getEstabModel().getAmmo().values());
            // If the user didn't select any ammo, abort
            if (selectedAmmo != null) {
                // Create new AmmoLoad with the ammo name and id
                AmmoLoad ammoLoad = new AmmoLoad();
                ammoLoad.setObjectId(selectedAmmo.getId());
                ammoLoad.setName(selectedAmmo.getName());
                ammoLoad.setLoad(0);

                // Set Rate of Fire values to zero
                ROF rof = new ROF();
                rof.setNormal(0.0);
                rof.setRapid(0.0);
                rof.setSlow(0.0);

                // Create an empty range table
                RangeTable rangeTable = new RangeTable();

                // Create a Performance POJO and get the PerformanceModel
                Performance p = new Performance();
                p.setAmmo(ammoLoad);
                p.setRof(rof);
                p.setRangeTable(rangeTable);
                PerformanceModel pModel = new PerformanceModel(p);

                FireType newFireType = performanceFireTypeComboBox.getSelectionModel().getSelectedItem();
                // Update the performance with selected fire type
                pModel.setFireType(newFireType);
                // Add the fire type to the map, the list, and remove it from the combobox
                performanceFireTypeMap.put(newFireType, pModel);
                performanceFireTypeList.getItems().add(newFireType);
                performanceFireTypeComboBox.getItems().remove(performanceFireTypeComboBox.getSelectionModel().getSelectedIndex());
                // Finally, add the performance to the active weapon
                activeWeapon.getPerformances().add(pModel);
            }
        }
    }

    /**
     * Removes a performance from the weapon.
     * This method should be called when the {@link #performanceFireTypeRemoveButton} button is pressed.
     * It removes the performance associated with the selected fire type in the {@link #performanceFireTypeList} list
     * from said list and the {@link #activeWeapon} performances collection.
     *
     * @param actionEvent is not used
     */
    @FXML
    protected void performanceRemoveFireType(ActionEvent actionEvent) {
        if (!performanceFireTypeList.getSelectionModel().getSelectedItems().isEmpty()) {
            activeWeapon.getPerformances().remove(activePerformance);
            performanceFireTypeList.getItems().remove(performanceFireTypeList.getSelectionModel().getSelectedItem());
        }
    }

    /**
     * Unbinds a performance properties from the view properties.
     * It's similar to {@link #unbindProperties(WeaponModel)}
     *
     * @param p the {@link PerformanceModel} to unbind
     */
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

    /**
     * Binds a performance properties with the view properties.
     * It's similar to {@link #bindProperties(WeaponModel)}
     * <p>Also, it prepares the {@link #rangeItemTableView} columns to be editable and filled with custom values</p>
     *
     * @param p the {@link PerformanceModel} to unbind
     */
    private void bindPerformanceProperties(PerformanceModel p) {
        minRange.textProperty().bindBidirectional(p.minRangeProperty(), NUMBER_STRING_CONVERTER);
        fireRateSlow.textProperty().bindBidirectional(p.slowROFProperty(), NUMBER_STRING_CONVERTER);
        fireRateNormal.textProperty().bindBidirectional(p.normalROFProperty(), NUMBER_STRING_CONVERTER);
        fireRateRapid.textProperty().bindBidirectional(p.rapidROFProperty(), NUMBER_STRING_CONVERTER);
        burstRadius.textProperty().bindBidirectional(p.burstRadiusProperty(), NUMBER_STRING_CONVERTER);
        shellWeight.textProperty().bindBidirectional(p.shellWeightProperty(), NUMBER_STRING_CONVERTER);
        load.textProperty().bindBidirectional(p.getAmmoLoad().loadProperty(), NUMBER_STRING_CONVERTER);

        ammoNameLabel.setText(p.getAmmoLoad().getName());

        // Make cells editable
        rangeTableRangeColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Integer>forTableColumn(new IntegerStringConverter()));
        rangeTableAccuracyColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Double>forTableColumn(new DoubleStringConverter()));
        rangeTableArmorColumn.setCellFactory(TextFieldTableCell.<RangeItemModel, Double>forTableColumn(new DoubleStringConverter()));

        // Tell the columns where to extract the values from. Here param.getValue() returns a RangeItemModel
        rangeTableRangeColumn.setCellValueFactory(param -> param.getValue().rangeProperty().asObject());
        rangeTableAccuracyColumn.setCellValueFactory(param -> param.getValue().accuracyProperty().asObject());
        rangeTableArmorColumn.setCellValueFactory(param -> param.getValue().armourPenetrationProperty().asObject());

        rangeItemTableView.getColumns().clear();
        rangeItemTableView.getColumns().add(rangeTableRangeColumn);
        rangeItemTableView.getColumns().add(rangeTableAccuracyColumn);
        rangeItemTableView.getColumns().add(rangeTableArmorColumn);
        rangeItemTableView.getItems().addAll(p.getRanges());
    }

    /**
     * Shows a dialog where the user can selects the desired ammo for the weapon.
     *
     * @param actionEvent is not used
     * @see AmmoModel
     * @see SearchDialogController
     */
    @FXML
    private void ammoSelectAction(ActionEvent actionEvent) {
        AmmoModel ammo = (AmmoModel) UtilView.showSearchDialog("Select ammo",
                estabEditorController.getEstabModel().getAmmo().values());
        if (ammo != null) {
            AmmoLoadModel ammoLoadModel = activePerformance.getAmmoLoad();
            ammoLoadModel.setId(ammo.getId());
            ammoLoadModel.setName(ammo.getName());
            ammoNameLabel.setText(ammo.getName());
        }
    }


    @Override
    public void setEditable(boolean isEditable) {
        weight.setEditable(isEditable);
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
        addRangeButton.setDisable(!isEditable);
        removeRangeButton.setDisable(!isEditable);
    }

    @Override
    public void bindProperties(WeaponModel element) {
        weight.textProperty().bindBidirectional(element.weightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        crew.textProperty().bindBidirectional(element.crewProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(element.reliabilityProperty(), new NumberStringConverter());
        calibre.textProperty().bindBidirectional(element.calibreProperty(), new NumberStringConverter());
        muzzleVelocity.textProperty().bindBidirectional(element.muzzleVelocityProperty(), new NumberStringConverter());

        weaponType.valueProperty().bindBidirectional(element.typeProperty());
        weaponPrimaryRole.valueProperty().bindBidirectional(element.primaryRoleProperty());

        singleShot.selectedProperty().bindBidirectional(element.singleShotProperty());
        mustDeployToFire.selectedProperty().bindBidirectional(element.mustDeployToFireProperty());
    }

    @Override
    public void unbindProperties(WeaponModel element) {
        if (activePerformance != null) unbindPerformanceProperties(activePerformance);
        weight.textProperty().unbindBidirectional(element.weightProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        crew.textProperty().unbindBidirectional(element.crewProperty());
        reliability.textProperty().unbindBidirectional(element.reliabilityProperty());
        calibre.textProperty().unbindBidirectional(element.calibreProperty());
        muzzleVelocity.textProperty().unbindBidirectional(element.muzzleVelocityProperty());
        weaponType.valueProperty().unbindBidirectional(element.typeProperty());
        weaponPrimaryRole.valueProperty().unbindBidirectional(element.primaryRoleProperty());
    }

    @Override
    public void clear() {
        if (activeWeapon != null) unbindProperties(activeWeapon);
        if (activePerformance != null) unbindPerformanceProperties(activePerformance);

        weight.setText("");
        name.setText("");
        description.setText("");
        crew.setText("");
        reliability.setText("");
        calibre.setText("");
        muzzleVelocity.setText("");

        weaponType.getSelectionModel().clearSelection();
        weaponPrimaryRole.getSelectionModel().clearSelection();

        singleShot.setSelected(false);
        mustDeployToFire.setSelected(false);

        minRange.setText("");
        fireRateSlow.setText("");
        fireRateNormal.setText("");
        fireRateRapid.setText("");
        burstRadius.setText("");
        shellWeight.setText("");
        load.setText("");

        ammoNameLabel.setText("");
        rangeItemTableView.getItems().clear();
    }

    @Override
    public WeaponModel getActiveElement() {
        return activeWeapon;
    }

    @Override
    public void setActiveElement(WeaponModel element) {
        if (activeWeapon != null) {
            unbindProperties(activeWeapon);
        }
        this.activeWeapon = element;
        imagePanelController.setActiveElement(element);
        bindProperties(activeWeapon);

        performanceFireTypeList.getItems().clear();
        performanceFireTypeComboBox.getItems().clear();
        performanceFireTypeMap = WeaponModel.getFireTypeMap(this.activeWeapon);
        for (Map.Entry<FireType, PerformanceModel> entry : performanceFireTypeMap.entrySet()) {
            if (entry.getValue() != null) {
                // Fill FireTypeList with this activePerformance fire types
                performanceFireTypeList.getItems().add(entry.getKey());
            } else {
                // Fill combo box with the excluded fire types
                performanceFireTypeComboBox.getItems().add(entry.getKey());
            }
        }
        performanceFireTypeList.getSelectionModel().selectFirst();
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
        imagePanelController.setEstabEditorController(estabEditorController);
    }
}
