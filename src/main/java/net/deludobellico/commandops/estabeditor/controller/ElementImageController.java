package net.deludobellico.commandops.estabeditor.controller;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.model.GraphicalElementModel;
import net.deludobellico.commandops.estabeditor.model.ImageModel;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.UtilView;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This controller manages the weapon editor view and model.
 *
 * @author Mario
 * @see EstabEditorController
 */
public class ElementImageController implements Initializable {

    @FXML
    private TextField imageFilename;

    @FXML
    private Button openImageButton;

    @FXML
    private ImageView imageView;

    @FXML
    private CheckBox noImageCheckbox;

    private EstabEditorController estabEditorController;
    private ElementModel activeElement;
    private final static String NO_IMAGE_FILENAME = "no-image.bmp";

    /**
     * Adds listeners to components and sets the initial item collections.
     *
     * @param location  is not used
     * @param resources is not used
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public StringProperty imageFilenameProperty() {
        return imageFilename.textProperty();
    }

    @FXML
    private void selectImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(String.format("Select image depicting %s", activeElement.getName()));
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                //"Image files", ImageIO.getReaderFileSuffixes());
                "Image files", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);

        File initialDirectory = FileIO.getDatasetImageFolder(estabEditorController.getActiveFile());
        fileChooser.setInitialDirectory(initialDirectory);
        File imageFile = fileChooser.showOpenDialog(UtilView.ROOT_STAGE);
        if (null != imageFile) {
            imageFilename.setText(imageFile.getName());
            Image image = new Image(imageFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    @FXML
    private void removeImage(ActionEvent event) {
        if (noImageCheckbox.isSelected()) {
            setNoImage();
        }
    }

    private void setNoImage() {
        Image image = FileIO.getDatasetImage(estabEditorController.getActiveFile(), NO_IMAGE_FILENAME);
        imageView.setImage(image);
        imageFilename.setText("");
        imageFilename.setText(NO_IMAGE_FILENAME);
        noImageCheckbox.setSelected(true);
    }

    public void setEditable(boolean isEditable) {
        openImageButton.setDisable(!isEditable);
    }

    public void setActiveElement(GraphicalElementModel element) {
        if (activeElement != null) {
            imageView.setImage(null);
        }
        this.activeElement = element;
        ImageModel imageModel = estabEditorController.getEstabModel().getImages().get(element.getPictureId());
        if (imageModel != null ) {
            imageView.setImage(FileIO.getDatasetImage(estabEditorController.getActiveFile(), imageModel.getFileId()));
            noImageCheckbox.setSelected(imageModel.getFileId().equals(NO_IMAGE_FILENAME) ? true : false);
        } else {
            setNoImage();
        }
    }

    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
    }
}
