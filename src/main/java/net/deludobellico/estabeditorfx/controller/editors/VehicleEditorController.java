package net.deludobellico.estabeditorfx.controller.editors;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;
import net.deludobellico.estabeditorfx.controller.EstabEditorController;
import net.deludobellico.estabeditorfx.controller.customdialogs.SearchDialogController;
import net.deludobellico.estabeditorfx.data.jaxb.Armament;
import net.deludobellico.estabeditorfx.data.jaxb.VehicleType;
import net.deludobellico.estabeditorfx.model.*;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.ViewUtil;

import java.net.URL;
import java.util.*;

/**
 * This controller manages the weapon editor view and model.
 *
 * @author Mario
 * @author Heine
 * @see EstabEditorController
 */
public class VehicleEditorController extends AbstractElementEditorController<VehicleModel> {

    /**
     * Root node components
     */
    @FXML
    private TextField name;
    @FXML
    private TextField id;

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
    private Label armamentName;
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

        vehicleType.getItems().addAll(VehicleType.values());

        imagePanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = getEstabEditorController().getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileName().equals(newValue)) {
                        getActiveElement().setPictureId(im.getId());
                        getActiveElement().setPictureFilename(newValue);
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileName(newValue);
                    getActiveElement().setPictureId(imageModel.getId());
                    getActiveElement().setPictureFilename(newValue);
                }
            }
        });

    }

    /**
     * Adds a new armament to the vehicle.
     * <p>This method should be called when the {@link #armamentAddButton} button is pressed.
     * It creates a new armament with the text fields values and adds it
     * to the {@link #armamentTableView} item collection and the {@link #activeElement} armaments collection.</p>
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     */
    @FXML
    private void armamentAddAction(ActionEvent actionEvent) {

        if (armamentName.getText().isEmpty() || armamentQty.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            ViewUtil.showInfoDialog("Empty fields", "", "Please, fill the empty fields", DialogAction.OK);
        } else {
            // Extract the WeaponModel we set when we selected the armament
            WeaponModel weapon = (WeaponModel) armamentName.getUserData();
            if (weapon == null) return;
            // Search for repeated weapons
            boolean repeatedWeapon = false;
            for (ArmamentModel am : getActiveElement().getArmaments())
                if (am.getName().equals(weapon.getName())) {
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
                getActiveElement().getArmaments().add(aModel);
            } else {
                ViewUtil.showInfoDialog("Repeated weapon", "", "The selected weapon is already included. Please, select another one.");
            }
        }
    }

    /**
     * Shows a dialog where the user can selects the desired weapon for the new armament.
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     * @see SearchDialogController
     */
    @FXML
    private void armamentSelectAction(ActionEvent actionEvent) {
        WeaponModel weapon = (WeaponModel) ViewUtil.showSearchDialog("Select weapon", getEstabEditorController().getEstabModel().getWeapons().values());
        if (weapon != null) {
            armamentName.setUserData(weapon);
            armamentName.setText(weapon.getName());
            armamentQty.setText("1");
        }
    }

    /**
     * Removes an armament from the vehicle.
     * <p>This method should be called when the {@link #armamentRemoveButton} button is pressed.
     * It removes the selected range from the {@link #armamentTableView} and the {@link #activeElement} armaments collection.</p>
     *
     * @param actionEvent is not used
     * @see ArmamentModel
     */
    @FXML
    private void armamentRemoveAction(ActionEvent actionEvent) {
        if (!armamentTableView.getSelectionModel().getSelectedItems().isEmpty()) {
            getActiveElement().getArmaments().remove(armamentTableView.getSelectionModel().getSelectedItem());
        }
    }

    @Override
    public void bindProperties() {
        VehicleModel element = getActiveElement();
        imagePanelController.setActiveElement(element, element.getPictureId());

        name.textProperty().bindBidirectional(element.nameProperty());
        id.textProperty().bindBidirectional(element.idProperty(), NUMBER_STRING_CONVERTER);
        hasTurret.selectedProperty().bindBidirectional(element.hasTurretProperty());
        hasOpenTop.selectedProperty().bindBidirectional(element.hasOpenTopProperty());

        vehicleType.valueProperty().bindBidirectional(element.typeProperty());
        width.textProperty().bindBidirectional(element.widthProperty(), NUMBER_STRING_CONVERTER);
        height.textProperty().bindBidirectional(element.heightProperty(), NUMBER_STRING_CONVERTER);

        battleWeight.textProperty().bindBidirectional(element.battleWeightProperty(), NUMBER_STRING_CONVERTER);
        bulkFuelCapacity.textProperty().bindBidirectional(element.bulkFuelCapacityProperty(), NUMBER_STRING_CONVERTER);
        crew.textProperty().bindBidirectional(element.crewProperty(), NUMBER_STRING_CONVERTER);
        crossCountryMaxSpeed.textProperty().bindBidirectional(element.maxCrossCountrySpeedProperty(), NUMBER_STRING_CONVERTER);
        crossCountryNormalSpeed.textProperty().bindBidirectional(element.normalCrossCountrySpeedProperty(), NUMBER_STRING_CONVERTER);
        description.textProperty().bindBidirectional(element.descriptionProperty());
        frontArmor.textProperty().bindBidirectional(element.frontArmorProperty(), NUMBER_STRING_CONVERTER);
        fuelCapacity.textProperty().bindBidirectional(element.fuelCapacityProperty(), NUMBER_STRING_CONVERTER);
        fuelConsumptionMaxSpeed.textProperty().bindBidirectional(element.maxFuelConsumptionProperty(), NUMBER_STRING_CONVERTER);
        fuelConsumptionNormalSpeed.textProperty().bindBidirectional(element.normalFuelConsumptionProperty(), NUMBER_STRING_CONVERTER);


        length.textProperty().bindBidirectional(element.lengthProperty(), NUMBER_STRING_CONVERTER);
        maxFordingDepth.textProperty().bindBidirectional(element.maxFordingDepthProperty(), NUMBER_STRING_CONVERTER);
        maxGradient.textProperty().bindBidirectional(element.maxGradientProperty(), NUMBER_STRING_CONVERTER);
        maxTrenchWidth.textProperty().bindBidirectional(element.maxTrenchWidthProperty(), NUMBER_STRING_CONVERTER);

        payloadCapacity.textProperty().bindBidirectional(element.payloadCapacityProperty(), NUMBER_STRING_CONVERTER);
        personnelCapacity.textProperty().bindBidirectional(element.personnelCapacityProperty(), NUMBER_STRING_CONVERTER);
        rearArmor.textProperty().bindBidirectional(element.rearArmorProperty(), NUMBER_STRING_CONVERTER);
        reliability.textProperty().bindBidirectional(element.reliabilityProperty(), NUMBER_STRING_CONVERTER);
        roadMaxSpeed.textProperty().bindBidirectional(element.maxRoadSpeedProperty(), NUMBER_STRING_CONVERTER);
        roadNormalSpeed.textProperty().bindBidirectional(element.normalRoadSpeedProperty(), NUMBER_STRING_CONVERTER);
        ronsonability.textProperty().bindBidirectional(element.ronsonabilityProperty(), NUMBER_STRING_CONVERTER);
        sideArmor.textProperty().bindBidirectional(element.sideArmorProperty(), NUMBER_STRING_CONVERTER);
        takeCoverMod.textProperty().bindBidirectional(element.takeCoverModProperty(), NUMBER_STRING_CONVERTER);
        topArmor.textProperty().bindBidirectional(element.topArmorProperty(), NUMBER_STRING_CONVERTER);
        towingCapacity.textProperty().bindBidirectional(element.towingCapacityProperty(), NUMBER_STRING_CONVERTER);
        weight.textProperty().bindBidirectional(element.weightProperty(), NUMBER_STRING_CONVERTER);

        armamentTypeColumn.setCellValueFactory(param -> new SimpleStringProperty("Weapon"));
        armamentNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        armamentQuantityColumn.setCellFactory(TextFieldTableCell.<ArmamentModel, Integer>forTableColumn(INTEGER_STRING_CONVERTER));
        armamentQuantityColumn.setCellValueFactory(param -> param.getValue().qtyProperty().asObject());
        armamentTableView.setItems(element.getArmaments());
    }

    @Override
    public void unbindProperties() {
        VehicleModel element = getActiveElement();

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
        id.textProperty().unbindBidirectional(element.idProperty());
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

        armamentTableView.setItems(null);
        imagePanelController.clear();

    }

    @Override
    public void setEditable(boolean isEditable) {
        ViewUtil.setEditable(editorPane, isEditable);
        imagePanelController.setEditable(isEditable);
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        super.setEstabEditorController(estabEditorController);
        imagePanelController.setEstabEditorController(estabEditorController);
    }
}
