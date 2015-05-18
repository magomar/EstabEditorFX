package net.deludobellico.commandops.estabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.model.EstabModel;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import net.deludobellico.commandops.estabeditor.model.NationModel;
import net.deludobellico.commandops.estabeditor.model.SideModel;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 18/05/2015.
 */
public class NationEditorController implements Initializable, ElementEditorController<NationModel> {

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
    private TextField nationality;

    /**
     * Other
     */
    private NationModel activeNation;
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
                        activeNation.setLargeInsignia(im.getId());
                        imageModelExists = true;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeNation.setLargeInsignia(imageModel.getId());
                }
            }
        });
        smallInsigniaPanelController.imageFilenameProperty().addListener((observable, oldValue, newValue) -> {
            EstabModel estabModel = estabEditorController.getEstabModel();
            if (!newValue.equals("")) {
                boolean imageModelExists = false;
                for (ImageModel im : estabModel.getImages().values()) {
                    if (im.getFileId().equals(newValue)) {
                        activeNation.setSmallInsignia(im.getId());
                        imageModelExists = true;
                        break;
                    }
                }
                if (!imageModelExists) {
                    ImageModel imageModel = (new ImageModel()).createNewInMap((Map<Integer, ImageModel>) estabModel.getAll().get(ImageModel.class));
                    imageModel.setName(newValue.substring(0, newValue.lastIndexOf(".")));
                    imageModel.setFileId(newValue);
                    activeNation.setSmallInsignia(imageModel.getId());
                }
            }
        });
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     */
    @Override
    public void setEditable(boolean isEditable) {
        nationality.setEditable(isEditable);
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
    }

    /**
     * @param element The {@link NationModel} to bind
     */
    @Override
    public void bindProperties(NationModel element) {
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
        nationality.textProperty().bindBidirectional(element.nationalityProperty());

    }

    /**
     * @param element The {@link NationModel} to unbind
     */
    @Override
    public void unbindProperties(NationModel element) {
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        nationality.textProperty().unbindBidirectional(element.nationalityProperty());
    }

    @Override
    public void clear() {
        name.setText("");
        description.setText("");
        unbindProperties(activeNation);
        nationality.setText("");
    }


    /**
     * @return the active {@link NationModel}
     */
    @Override
    public NationModel getActiveElement() {
        return activeNation;
    }

    /**
     * @param element The {@link SideModel} to be set as active
     */
    @Override
    public void setActiveElement(NationModel element) {
        if (activeNation != null) unbindProperties(activeNation);
        this.activeNation = element;
        bindProperties(activeNation);
    }
}
