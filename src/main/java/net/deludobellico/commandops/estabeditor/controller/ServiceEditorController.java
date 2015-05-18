package net.deludobellico.commandops.estabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import net.deludobellico.commandops.estabeditor.data.jaxb.Armament;
import net.deludobellico.commandops.estabeditor.data.jaxb.SymbolColor;
import net.deludobellico.commandops.estabeditor.model.*;
import net.deludobellico.commandops.estabeditor.util.DialogAction;
import net.deludobellico.commandops.estabeditor.util.UtilView;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 18/05/2015.
 */
public class ServiceEditorController implements Initializable, ElementEditorController<ServiceModel> {

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
    private TextField shortName;
    @FXML
    private TextField fullName;
    @FXML
    private ElementImageController largeInsigniaPanelController;
    @FXML
    private ElementImageController smallInsigniaPanelController;

    /**
     * Other
     */
    // Last bind service
    private ServiceModel activeService;
    private EstabEditorController estabEditorController;
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
            EstabModel estabModel = estabEditorController.getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        activeService.setLargeInsignia(im.getId());
                        imageModelExists = true;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeService.setLargeInsignia(imageModel.getId());
                }
            }
        });
        smallInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = estabEditorController.getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        activeService.setSmallInsignia(im.getId());
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeService.setSmallInsignia(imageModel.getId());
                }
            }
        });
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     */
    @Override
    public void setEditable(boolean isEditable) {
        backgroundColorPicker.setEditable(isEditable);
        darkBackgColorPicker.setEditable(isEditable);
        lightBackgColorPicker.setEditable(isEditable);
        designationColorPicker.setEditable(isEditable);
        symbolColorComboBox.setEditable(isEditable);
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
    }

    /**
     * @param element The {@link ServiceModel} to bind
     */
    @Override
    public void bindProperties(ServiceModel element) {
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        backgroundColorPicker.valueProperty().bindBidirectional(element.backgroundColorProperty());
        darkBackgColorPicker.valueProperty().bindBidirectional(element.backgroundDarkColorProperty());
        lightBackgColorPicker.valueProperty().bindBidirectional(element.backgroundLightColorProperty());
        designationColorPicker.valueProperty().bindBidirectional(element.designationColorProperty());
        symbolColorComboBox.valueProperty().bindBidirectional(element.symbolColorProperty());
        rankModels.addAll(element.getRankList());
        rankListView.setItems(rankModels);
    }

    /**
     * @param element The {@link ServiceModel} to unbind
     */
    @Override
    public void unbindProperties(ServiceModel element) {
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        backgroundColorPicker.valueProperty().unbindBidirectional(element.backgroundColorProperty());
        darkBackgColorPicker.valueProperty().unbindBidirectional(element.backgroundDarkColorProperty());
        lightBackgColorPicker.valueProperty().unbindBidirectional(element.backgroundLightColorProperty());
        designationColorPicker.valueProperty().unbindBidirectional(element.designationColorProperty());
        symbolColorComboBox.valueProperty().unbindBidirectional(element.symbolColorProperty());
        rankModels.clear();
    }

    @Override
    public void clear() {
        name.setText("");
        description.setText("");
        unbindProperties(activeService);
        shortName.setText("");
        fullName.setText("");
    }


    /**
     * @return the active {@link ServiceModel}
     */
    @Override
    public ServiceModel getActiveElement() {
        return activeService;
    }

    /**
     * @param element The {@link SideModel} to be set as active
     */
    @Override
    public void setActiveElement(ServiceModel element) {
        if (activeService != null) unbindProperties(activeService);
        this.activeService = element;
        bindProperties(activeService);
    }

    @FXML
    private void addRankAction(ActionEvent actionEvent) {

        if (shortName.getText().isEmpty() || fullName.getText().isEmpty()) {
            // If one text field is empty, show dialog and abort
            UtilView.showInfoDialog("Empty fields", "", "Please, fill the empty fields", DialogAction.OK);
        } else {
            boolean repeatedRank = false;
            for (RankModel rankModel : activeService.getRankList())
                if (rankModel.getShortName().equals(shortName.getText())) {
                    repeatedRank = true;
                    break;
                }
            if (!repeatedRank) {
                RankModel rankModel = new RankModel();
                rankModel.setShortName(shortName.getText());
                rankModel.setFullName(fullName.getText());
                rankModel.setIndex(rankModels.size());
//                activeService.getRankList().add(rankModel);
                rankModels.add(rankModel);
            } else {
                UtilView.showInfoDialog("Repeated rank", "", "The entered rank is already included. Please, enter another one.");
            }
        }
    }

    @FXML
    private void removeRankAction(ActionEvent actionEvent) {
        if (!rankListView.getSelectionModel().getSelectedItems().isEmpty()) {
            RankModel rankModel = rankListView.getSelectionModel().getSelectedItem();
//            activeService.getRankList().remove(rankModel);
//            rankListView.getItems().remove(rankModel);
            rankModels.remove(rankModel);
        }
    }
}
