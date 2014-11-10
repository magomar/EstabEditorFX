package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.util.converter.IntegerStringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.data.jaxb.Armament;
import net.deludobellico.commandops.estabeditor.data.jaxb.VehicleType;
import net.deludobellico.commandops.estabeditor.model.ArmamentModel;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;
import net.deludobellico.commandops.estabeditor.model.WeaponModel;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;
import net.deludobellico.commandops.estabeditor.view.ElementSearchDialog;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This controller manages the weapon editor view and model.
 *
 * @author Mario
 * @author Heine
 * @see EstabController
 */
public class VehicleEditorController implements Initializable, ElementEditorController<VehicleModel> {

    /**
     * Root node components
     */
    @FXML
    private TextField name;

    /**
     * General tab components
     */
    @FXML
    private TextArea description;
    @FXML
    private ComboBox<VehicleType> vehicleType;
    @FXML
    private CheckBox hasTurret;
    @FXML
    private CheckBox hasOpenTop;
    @FXML
    private TextField width;
    @FXML
    private TextField height;
    @FXML
    private TextField length;
    @FXML
    private TextField battleWeight;
    @FXML
    private TextField weight;
    @FXML
    private ImageView vehicleImageView;

    /**
     * Performance tab components
     */
    // Left column
    @FXML
    private TextField crew;
    @FXML
    private TextField personnelCapacity;
    @FXML
    private TextField fuelCapacity;
    @FXML
    private TextField bulkFuelCapacity;
    @FXML
    private TextField payloadCapacity;
    @FXML
    private TextField towingCapacity;
    // Right column
    @FXML
    private TextField reliability;
    @FXML
    private TextField takeCoverMod;
    @FXML
    private TextField ronsonability;
    @FXML
    private TextField maxGradient;
    @FXML
    private TextField maxFordingDepth;
    @FXML
    private TextField maxTrenchWidth;

    // Bottom region
    @FXML
    private TextField roadNormalSpeed;
    @FXML
    private TextField roadMaxSpeed;
    @FXML
    private TextField crossCountryNormalSpeed;
    @FXML
    private TextField crossCountryMaxSpeed;
    @FXML
    private TextField fuelConsumptionNormalSpeed;
    @FXML
    private TextField fuelConsumptionMaxSpeed;

    @FXML
    private TextField sideArmor;
    @FXML
    private TextField frontArmor;
    @FXML
    private TextField rearArmor;
    @FXML
    private TextField topArmor;

    /**
     * Armaments tab
     */
    @FXML
    private TextField armamentName;
    @FXML
    private TextField armamentQty;
    @FXML
    private Button armamentSelectButton;
    @FXML
    private Button armamentAddButton;
    @FXML
    private Button armamentRemoveButton;
    // Armaments table
    @FXML
    private TableView<ArmamentModel> armamentTableView;
    @FXML
    private TableColumn<ArmamentModel, String> armamentTypeColumn;
    @FXML
    private TableColumn<ArmamentModel, String> armamentNameColumn;
    @FXML
    private TableColumn<ArmamentModel, Integer> armamentQuantityColumn;

    /**
     * Other
     */
    private VehicleModel activeVehicle;
    private EstabController estabController;

    /**
     * Adds listeners to components and sets the initial item collections.
     *
     * @param location  is not used
     * @param resources is not used
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        vehicleType.getItems().addAll(VehicleType.values());
        description.setWrapText(true);
    }

    /**
     * Adds a new armament to the vehicle.
     * <p>This method should be called when the {@link #armamentAddButton} button is pressed.
     * It creates a new armament with the text fields values and adds it
     * to the {@link #armamentTableView} item collection and the {@link #activeVehicle} armaments collection.</p>
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     */
    @FXML
    private void armamentAddAction(ActionEvent actionEvent) {

        if (armamentName.getText().isEmpty() || armamentQty.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            UtilView.showInfoDialog("Empty fields","", "Please, fill the empty fields", DialogAction.OK);
        } else {
            // Extract the WeaponModel we set when we selected the armament
            WeaponModel weapon = (WeaponModel) armamentName.getUserData();
            if(weapon == null) return;
            // Search for repeated weapons
            boolean repeatedWeapon = false;
            for (ArmamentModel am : activeVehicle.getArmaments())
                if (am.getEquipmentName().equals(weapon.getName())) {
                    repeatedWeapon = true;
                    break;
                }
            // If the weapon wasn't repeated, create a new armament and add it to the table and vehicle armaments collection
            if (!repeatedWeapon) {
                Armament newArmament = new Armament();
                newArmament.setEquipmentObjectId(weapon.getId());
                newArmament.setEquipmentName(weapon.getName());
                newArmament.setQty(Integer.valueOf(armamentQty.getText()));

                ArmamentModel aModel = new ArmamentModel(newArmament);
                armamentTableView.getItems().add(aModel);
                activeVehicle.getArmaments().add(aModel);
            } else {
                UtilView.showInfoDialog("Repeated weapon","", "The selected weapon is already included. Please, select another one.");
            }
        }
    }

    /**
     * Shows a dialog where the user can selects the desired weapon for the new armament.
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     * @see ElementSearchDialog
     */
    @FXML
    private void armamentSelectAction(ActionEvent actionEvent) {
        WeaponModel weapon = (WeaponModel) UtilView.showSearchDialog("Select weapon", estabController.getEstabModel().getWeapons().values());
        if (weapon != null) {
            armamentName.setUserData(weapon);
            armamentName.setText(weapon.getName());
        }
    }

    /**
     * Removes an armament from the vehicle.
     * <p>This method should be called when the {@link #armamentRemoveButton} button is pressed.
     * It removes the selected range from the {@link #armamentTableView} and the {@link #activeVehicle} armaments collection.</p>
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     */
    @FXML
    private void armamentRemoveAction(ActionEvent actionEvent) {
        if (!armamentTableView.getSelectionModel().getSelectedItems().isEmpty()) {
            activeVehicle.getArmaments().remove(armamentTableView.getSelectionModel().getSelectedItem());
            armamentTableView.getItems().remove(armamentTableView.getSelectionModel().getSelectedItem());
        }
    }


    @Override
    public void setEditable(boolean isEditable) {
        battleWeight.setEditable(isEditable);
        bulkFuelCapacity.setEditable(isEditable);
        crew.setEditable(isEditable);
        crossCountryMaxSpeed.setEditable(isEditable);
        crossCountryNormalSpeed.setEditable(isEditable);
        description.setEditable(isEditable);
        frontArmor.setEditable(isEditable);
        fuelCapacity.setEditable(isEditable);
        fuelConsumptionMaxSpeed.setEditable(isEditable);
        fuelConsumptionNormalSpeed.setEditable(isEditable);
        height.setEditable(isEditable);
        hasOpenTop.setDisable(!isEditable);
        hasOpenTop.setStyle("-fx-opacity: 1");
        hasTurret.setDisable(!isEditable);
        hasTurret.setStyle("-fx-opacity: 1");
        height.setEditable(isEditable);
        length.setEditable(isEditable);
        maxFordingDepth.setEditable(isEditable);
        maxGradient.setEditable(isEditable);
        maxTrenchWidth.setEditable(isEditable);
        name.setEditable(isEditable);
        payloadCapacity.setEditable(isEditable);
        personnelCapacity.setEditable(isEditable);
        rearArmor.setEditable(isEditable);
        reliability.setEditable(isEditable);
        roadMaxSpeed.setEditable(isEditable);
        roadNormalSpeed.setEditable(isEditable);
        ronsonability.setEditable(isEditable);
        sideArmor.setEditable(isEditable);
        takeCoverMod.setEditable(isEditable);
        topArmor.setEditable(isEditable);
        towingCapacity.setEditable(isEditable);
        vehicleType.setDisable(!isEditable);
        vehicleType.setStyle("-fx-opacity: 1");
        weight.setEditable(isEditable);
        width.setEditable(isEditable);
        armamentQty.setEditable(isEditable);
        armamentAddButton.setDisable(!isEditable);
        armamentRemoveButton.setDisable(!isEditable);
        armamentSelectButton.setDisable(!isEditable);
        armamentTableView.setEditable(isEditable);
    }

    @Override
    public void bindProperties(VehicleModel element) {
        battleWeight.textProperty().bindBidirectional(element.battleWeightProperty(), new NumberStringConverter());
        bulkFuelCapacity.textProperty().bindBidirectional(element.bulkFuelCapacityProperty(), new NumberStringConverter());
        crew.textProperty().bindBidirectional(element.crewProperty(), new NumberStringConverter());
        crossCountryMaxSpeed.textProperty().bindBidirectional(element.maxCrossCountrySpeedProperty(), new NumberStringConverter());
        crossCountryNormalSpeed.textProperty().bindBidirectional(element.normalCrossCountrySpeedProperty(), new NumberStringConverter());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        frontArmor.textProperty().bindBidirectional(element.frontArmorProperty(), new NumberStringConverter());
        fuelCapacity.textProperty().bindBidirectional(element.fuelCapacityProperty(), new NumberStringConverter());
        fuelConsumptionMaxSpeed.textProperty().bindBidirectional(element.maxFuelConsumptionProperty(), new NumberStringConverter());
        fuelConsumptionNormalSpeed.textProperty().bindBidirectional(element.normalFuelConsumptionProperty(), new NumberStringConverter());

        hasOpenTop.selectedProperty().bindBidirectional(element.hasOpenTopProperty());
        hasTurret.selectedProperty().bindBidirectional(element.hasTurretProperty());

        height.textProperty().bindBidirectional(element.heightProperty(), new NumberStringConverter());
        length.textProperty().bindBidirectional(element.lengthProperty(), new NumberStringConverter());
        maxFordingDepth.textProperty().bindBidirectional(element.maxFordingDepthProperty(), new NumberStringConverter());
        maxGradient.textProperty().bindBidirectional(element.maxGradientProperty(), new NumberStringConverter());
        maxTrenchWidth.textProperty().bindBidirectional(element.maxTrenchWidthProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        payloadCapacity.textProperty().bindBidirectional(element.payloadCapacityProperty(), new NumberStringConverter());
        personnelCapacity.textProperty().bindBidirectional(element.personnelCapacityProperty(), new NumberStringConverter());
        rearArmor.textProperty().bindBidirectional(element.rearArmorProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(element.reliabilityProperty(), new NumberStringConverter());
        roadMaxSpeed.textProperty().bindBidirectional(element.maxRoadSpeedProperty(), new NumberStringConverter());
        roadNormalSpeed.textProperty().bindBidirectional(element.normalRoadSpeedProperty(), new NumberStringConverter());
        ronsonability.textProperty().bindBidirectional(element.ronsonabilityProperty(), new NumberStringConverter());
        sideArmor.textProperty().bindBidirectional(element.sideArmorProperty(), new NumberStringConverter());
        takeCoverMod.textProperty().bindBidirectional(element.takeCoverModProperty(), new NumberStringConverter());
        topArmor.textProperty().bindBidirectional(element.topArmorProperty(), new NumberStringConverter());
        towingCapacity.textProperty().bindBidirectional(element.towingCapacityProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(element.weightProperty(), new NumberStringConverter());
        width.textProperty().bindBidirectional(element.widthProperty(), new NumberStringConverter());
        vehicleType.valueProperty().bindBidirectional(element.typeProperty());

        armamentTableView.getColumns().clear();
        armamentTypeColumn.setCellValueFactory(param -> new SimpleStringProperty("Weapon"));
        armamentNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getEquipmentName()));
        armamentQuantityColumn.setCellFactory(TextFieldTableCell.<ArmamentModel, Integer>forTableColumn(new IntegerStringConverter()));
        armamentQuantityColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        armamentTableView.getColumns().add(armamentTypeColumn);
        armamentTableView.getColumns().add(armamentNameColumn);
        armamentTableView.getColumns().add(armamentQuantityColumn);
        armamentTableView.getItems().addAll(element.getArmaments());
    }

    @Override
    public void unbindProperties(VehicleModel element) {
        battleWeight.textProperty().unbindBidirectional(element.battleWeightProperty());
        bulkFuelCapacity.textProperty().unbindBidirectional(element.bulkFuelCapacityProperty());
        crew.textProperty().unbindBidirectional(element.crewProperty());
        crossCountryMaxSpeed.textProperty().unbindBidirectional(element.maxCrossCountrySpeedProperty());
        crossCountryNormalSpeed.textProperty().unbindBidirectional(element.normalCrossCountrySpeedProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        frontArmor.textProperty().unbindBidirectional(element.frontArmorProperty());
        fuelCapacity.textProperty().unbindBidirectional(element.fuelCapacityProperty());
        fuelConsumptionMaxSpeed.textProperty().unbindBidirectional(element.maxFuelConsumptionProperty());
        fuelConsumptionNormalSpeed.textProperty().unbindBidirectional(element.normalFuelConsumptionProperty());

        hasOpenTop.selectedProperty().unbindBidirectional(element.hasOpenTopProperty());
        hasTurret.selectedProperty().unbindBidirectional(element.hasTurretProperty());

        height.textProperty().unbindBidirectional(element.heightProperty());
        length.textProperty().unbindBidirectional(element.lengthProperty());
        maxFordingDepth.textProperty().unbindBidirectional(element.maxFordingDepthProperty());
        maxGradient.textProperty().unbindBidirectional(element.maxGradientProperty());
        maxTrenchWidth.textProperty().unbindBidirectional(element.maxTrenchWidthProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        payloadCapacity.textProperty().unbindBidirectional(element.payloadCapacityProperty());
        personnelCapacity.textProperty().unbindBidirectional(element.personnelCapacityProperty());
        rearArmor.textProperty().unbindBidirectional(element.rearArmorProperty());
        reliability.textProperty().unbindBidirectional(element.reliabilityProperty());
        roadMaxSpeed.textProperty().unbindBidirectional(element.maxRoadSpeedProperty());
        roadNormalSpeed.textProperty().unbindBidirectional(element.normalRoadSpeedProperty());
        ronsonability.textProperty().unbindBidirectional(element.ronsonabilityProperty());
        sideArmor.textProperty().unbindBidirectional(element.sideArmorProperty());
        takeCoverMod.textProperty().unbindBidirectional(element.takeCoverModProperty());
        topArmor.textProperty().unbindBidirectional(element.topArmorProperty());
        towingCapacity.textProperty().unbindBidirectional(element.towingCapacityProperty());
        weight.textProperty().unbindBidirectional(element.weightProperty());
        width.textProperty().unbindBidirectional(element.widthProperty());
        vehicleType.valueProperty().unbindBidirectional(element.typeProperty());

        armamentTableView.getItems().clear();
        vehicleImageView.setImage(null);

    }

    @Override
    public void clear() {
        unbindProperties(activeVehicle);

        battleWeight.setText("");
        bulkFuelCapacity.setText("");
        crew.setText("");
        crossCountryMaxSpeed.setText("");
        crossCountryNormalSpeed.setText("");
        description.setText("");
        frontArmor.setText("");
        fuelCapacity.setText("");
        fuelConsumptionMaxSpeed.setText("");
        fuelConsumptionNormalSpeed.setText("");

        hasOpenTop.setSelected(false);
        hasTurret.setSelected(false);

        height.setText("");
        length.setText("");
        maxFordingDepth.setText("");
        maxGradient.setText("");
        maxTrenchWidth.setText("");
        name.setText("");
        payloadCapacity.setText("");
        personnelCapacity.setText("");
        rearArmor.setText("");
        reliability.setText("");
        roadMaxSpeed.setText("");
        roadNormalSpeed.setText("");
        ronsonability.setText("");
        sideArmor.setText("");
        takeCoverMod.setText("");
        topArmor.setText("");
        towingCapacity.setText("");
        weight.setText("");
        width.setText("");
        vehicleType.getSelectionModel().clearSelection();

    }

    @Override
    public VehicleModel getActiveElement() {
        return this.activeVehicle;
    }

    @Override
    public void setActiveElement(VehicleModel element) {
        if (activeVehicle != null) {
            unbindProperties(activeVehicle);
            vehicleImageView.setImage(null);
        }
        this.activeVehicle = element;
        bindProperties(activeVehicle);

        ImageModel image = estabController.getEstabModel().getImages().get(element.getPictureId());
        if (image != null)
            vehicleImageView.setImage(FileIO.getDatasetImage(estabController.getActiveFile(), image.getFileId()));
    }

    @Override
    public void setEstabController(EstabController estabController) {
        this.estabController = estabController;
    }
}
