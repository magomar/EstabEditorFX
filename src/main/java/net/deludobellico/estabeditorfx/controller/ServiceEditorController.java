package net.deludobellico.estabeditorfx.controller;

import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import net.deludobellico.estabeditorfx.data.jaxb.SymbolColor;
import net.deludobellico.estabeditorfx.model.*;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.ViewUtil;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 18/05/2015.
 */
public class ServiceEditorController extends AbstractElementEditorController<ServiceModel> {

    /**
     * Root node
     */
    @FXML
    private TextField name;
    @FXML
    private TextField id;
    /**
     * General tab
     */
    @FXML
    private TextArea description;
    @FXML
    private ListView<RankModel> rankListView;
    @FXML
    private ColorPicker backgroundColorPicker;
    @FXML
    private ColorPicker darkBackgColorPicker;
    @FXML
    private ColorPicker lightBackgColorPicker;
    @FXML
    private ColorPicker designationColorPicker;
    @FXML
    private ComboBox<SymbolColor> symbolColorComboBox;
    @FXML
    private Button applyServiceColors;
    @FXML
    private TextField shortName;
    @FXML
    private TextField fullName;
    @FXML
    private ElementImageController largeInsigniaPanelController;
    @FXML
    private ElementImageController smallInsigniaPanelController;


    private ObservableList<RankModel> rankModels = FXCollections.observableArrayList();

    /**
     * Adds listeners to components and sets the initial item collections.
     *
     * @param location  is not used
     * @param resources is not used
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        description.setWrapText(true);
        largeInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = getEstabEditorController().getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileName().equals(newValue)) {
                        getActiveElement().setLargeInsignia(im.getId());
                        imageModelExists = true;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileName(newValue);
                    getActiveElement().setLargeInsignia(imageModel.getId());
                }
            }
        });
        smallInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = getEstabEditorController().getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileName().equals(newValue)) {
                        getActiveElement().setSmallInsignia(im.getId());
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileName(newValue);
                    getActiveElement().setSmallInsignia(imageModel.getId());
                }
            }
        });


        ChangeListener<? super Color> colorChangeListener = (observable, oldValue, newValue) -> {
            applyServiceColors.setDisable(!newValue.equals(oldValue));
        };
        backgroundColorPicker.valueProperty().addListener(colorChangeListener);
        darkBackgColorPicker.valueProperty().addListener(colorChangeListener);
        lightBackgColorPicker.valueProperty().addListener(colorChangeListener);
        designationColorPicker.valueProperty().addListener(colorChangeListener);

    }

    @FXML
    void applyColorToForces() {
        for (ForceModel force : getActiveElement().getForce()) {
            force.setColorsFromService();
        }
        applyServiceColors.setDisable(true);
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     */
    @Override
    public void setEditable(boolean isEditable) {
        ViewUtil.setEditable(editorPane, isEditable);
        smallInsigniaPanelController.setEditable(isEditable);
        largeInsigniaPanelController.setEditable(isEditable);

    }

    @Override
    public void bindProperties() {
        ServiceModel element = getActiveElement();
        largeInsigniaPanelController.setActiveElement(element, element.getLargeInsignia());
        smallInsigniaPanelController.setActiveElement(element, element.getSmallInsignia());
        name.textProperty().bindBidirectional(element.nameProperty());
        id.textProperty().bindBidirectional(element.idProperty(), NUMBER_STRING_CONVERTER);
        description.textProperty().bindBidirectional(element.descriptionProperty());
        backgroundColorPicker.valueProperty().bindBidirectional(element.backgroundColorProperty());
        darkBackgColorPicker.valueProperty().bindBidirectional(element.backgroundDarkColorProperty());
        lightBackgColorPicker.valueProperty().bindBidirectional(element.backgroundLightColorProperty());
        designationColorPicker.valueProperty().bindBidirectional(element.designationColorProperty());
        symbolColorComboBox.valueProperty().bindBidirectional(element.symbolColorProperty());
        rankModels.addAll(element.getRankList());
        rankListView.setItems(rankModels);
        boolean allForcesUseServiceColors = true;
        for (ForceModel force : element.getForce()) {
            if (!force.usesServiceColors()) {
                allForcesUseServiceColors = false;
                break;
            }
        }
        applyServiceColors.setDisable(allForcesUseServiceColors);
    }

    @Override
    public void unbindProperties() {
        ServiceModel element = getActiveElement();
        name.textProperty().unbindBidirectional(element.nameProperty());
        id.textProperty().unbindBidirectional(element.idProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        backgroundColorPicker.valueProperty().unbindBidirectional(element.backgroundColorProperty());
        darkBackgColorPicker.valueProperty().unbindBidirectional(element.backgroundDarkColorProperty());
        lightBackgColorPicker.valueProperty().unbindBidirectional(element.backgroundLightColorProperty());
        designationColorPicker.valueProperty().unbindBidirectional(element.designationColorProperty());
        symbolColorComboBox.valueProperty().unbindBidirectional(element.symbolColorProperty());
        rankModels.clear();
    }

    @FXML
    private void addRankAction(ActionEvent actionEvent) {

        if (shortName.getText().isEmpty() || fullName.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            ViewUtil.showInfoDialog("Empty fields", "", "Please, fill the empty fields", DialogAction.OK);
        } else {
            boolean repeatedRank = false;
            for (RankModel rankModel : getActiveElement().getRankList())
                if (rankModel.getShortName().equals(shortName.getText())) {
                    repeatedRank = true;
                    break;
                }
            if (!repeatedRank) {
                RankModel rankModel = new RankModel();
                rankModel.setShortName(shortName.getText());
                rankModel.setFullName(fullName.getText());
                rankModel.setIndex(rankModels.size());
                rankModels.add(rankModel);
            } else {
                ViewUtil.showInfoDialog("Repeated rank", "", "The entered rank is already included. Please, enter another one.");
            }
        }
    }

    @FXML
    private void removeRankAction(ActionEvent actionEvent) {
        if (!rankListView.getSelectionModel().getSelectedItems().isEmpty()) {
            RankModel rankModel = rankListView.getSelectionModel().getSelectedItem();
            rankModels.remove(rankModel);
        }
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        super.setEstabEditorController(estabEditorController);
        largeInsigniaPanelController.setEstabEditorController(estabEditorController);
        smallInsigniaPanelController.setEstabEditorController(estabEditorController);
    }
}
