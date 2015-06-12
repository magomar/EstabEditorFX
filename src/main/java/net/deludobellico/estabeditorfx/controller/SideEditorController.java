package net.deludobellico.estabeditorfx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.estabeditorfx.model.EstabModel;
import net.deludobellico.estabeditorfx.model.ImageModel;
import net.deludobellico.estabeditorfx.model.SideModel;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 18/05/2015.
 */
public class SideEditorController extends AbstractElementEditorController<SideModel> {

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
    private TextField consumptionRate;
    @FXML
    private TextField aper;
    @FXML
    private TextField aarm;

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
            EstabModel estabModel = getEstabEditorController().getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        getActiveElement().setLargeInsignia(im.getId());
                        imageModelExists = true;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    getActiveElement().setLargeInsignia(imageModel.getId());
                }
            }
        });
        smallInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = getEstabEditorController().getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        getActiveElement().setSmallInsignia(im.getId());
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    getActiveElement().setSmallInsignia(imageModel.getId());
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
        name.setEditable(isEditable);
    }

    @Override
    public void bindProperties() {
        SideModel element = getActiveElement();
        name.textProperty().bindBidirectional(element.nameProperty());
        id.textProperty().bindBidirectional(element.idProperty(), NUMBER_STRING_CONVERTER);
        description.textProperty().bindBidirectional(element.descriptionProperty());
        consumptionRate.textProperty().bindBidirectional(element.basicsConsumptionRateProperty(), new NumberStringConverter());
        aper.textProperty().bindBidirectional(element.defaultEnemyAperFpProperty(), new NumberStringConverter());
        aarm.textProperty().bindBidirectional(element.defaultEnemyAarmFpProperty(), new NumberStringConverter());

    }

    @Override
    public void unbindProperties() {
        SideModel element = getActiveElement();
        name.textProperty().unbindBidirectional(element.nameProperty());
        id.textProperty().unbindBidirectional(element.idProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        consumptionRate.textProperty().unbindBidirectional(element.basicsConsumptionRateProperty());
        aper.textProperty().unbindBidirectional(element.defaultEnemyAperFpProperty());
        aarm.textProperty().unbindBidirectional(element.defaultEnemyAarmFpProperty());
    }

}
