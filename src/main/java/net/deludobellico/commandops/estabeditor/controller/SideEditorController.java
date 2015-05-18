package net.deludobellico.commandops.estabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.model.EstabModel;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import net.deludobellico.commandops.estabeditor.model.SideModel;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 18/05/2015.
 */
public class SideEditorController implements Initializable, ElementEditorController<SideModel> {

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
    private TextField consumptionRate;
    @FXML
    private TextField aper;
    @FXML
    private TextField aarm;


    /**
     * Other
     */
    private SideModel activeSide;
    private EstabEditorController estabEditorController;
    @FXML
    private ElementImageController largeInsigniaPanelController;
    @FXML
    private ElementImageController smallInsigniaPanelController;

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
                        activeSide.setLargeInsignia(im.getId());
                        imageModelExists = true;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeSide.setLargeInsignia(imageModel.getId());
                }
            }
        });
        smallInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = estabEditorController.getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        activeSide.setSmallInsignia(im.getId());
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeSide.setSmallInsignia(imageModel.getId());
                }
            }
        });
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     */
    @Override
    public void setEditable(boolean isEditable) {
        consumptionRate.setEditable(isEditable);
        aper.setEditable(isEditable);
        aarm.setEditable(isEditable);
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
    }

    /**
     * @param element The {@link SideModel} to bind
     */
    @Override
    public void bindProperties(SideModel element) {
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        consumptionRate.textProperty().bindBidirectional(element.basicsConsumptionRateProperty(), new NumberStringConverter());
        aper.textProperty().bindBidirectional(element.defaultEnemyAperFpProperty(), new NumberStringConverter());
        aarm.textProperty().bindBidirectional(element.defaultEnemyAarmFpProperty(), new NumberStringConverter());

    }

    /**
     * @param element The {@link SideModel} to unbind
     */
    @Override
    public void unbindProperties(SideModel element) {
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        consumptionRate.textProperty().unbindBidirectional(element.basicsConsumptionRateProperty());
        aper.textProperty().unbindBidirectional(element.defaultEnemyAperFpProperty());
        aarm.textProperty().unbindBidirectional(element.defaultEnemyAarmFpProperty());
    }

    @Override
    public void clear() {
        unbindProperties(activeSide);
        consumptionRate.setText("");
        aper.setText("");
        aarm.setText("");
        name.setText("");
        description.setText("");
    }


    /**
     * @return the active {@link SideModel}
     */
    @Override
    public SideModel getActiveElement() {
        return activeSide;
    }

    /**
     * @param element The {@link SideModel} to be set as active
     */
    @Override
    public void setActiveElement(SideModel element) {
        if (activeSide != null) unbindProperties(activeSide);
        this.activeSide = element;
        bindProperties(activeSide);
    }
}
