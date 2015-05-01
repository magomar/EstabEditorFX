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
import net.deludobellico.commandops.estabeditor.util.Settings;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import javax.imageio.ImageIO;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This controller manages the weapon editor view and model.
 *
 * @author Mario
 * @see EstabController
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

    private EstabController estabController;
    private ElementModel activeElement;

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
    public void selectImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(String.format("Select image depicting %s", activeElement.getName()));
        FileChooser.ExtensionFilter imageFilter = new FileChooser.ExtensionFilter(
                //"Image files", ImageIO.getReaderFileSuffixes());
                "Image files", "*.bmp");
        fileChooser.getExtensionFilters().add(imageFilter);
        File initialDirectory = null;
        if (Settings.getInstance().getLastOpenedFolder() != null)
            initialDirectory = new File(Settings.getInstance().getLastOpenedFolder());
        if (initialDirectory == null || !initialDirectory.exists())
            initialDirectory = new File(System.getProperty("user.dir"));
        fileChooser.setInitialDirectory(initialDirectory);
        File imageFile = fileChooser.showOpenDialog(UtilView.ROOT_STAGE);
        if (null != imageFile) {
            imageFilename.setText(imageFile.getName());
            Image image = new Image(imageFile.toURI().toString());
            imageView.setImage(image);
        }
    }

    @FXML
    public void removeImage(ActionEvent event) {

    }

    public void setEditable(boolean isEditable) {
        openImageButton.setDisable(!isEditable);
    }

    public void setActiveElement(GraphicalElementModel element) {
        if (activeElement != null) {
            imageView.setImage(null);
        }
        this.activeElement = element;
        ImageModel image = estabController.getEstabModel().getImages().get(element.getPictureId());
        if (image != null) {
            imageView.setImage(FileIO.getDatasetImage(estabController.getActiveFile(), image.getFileId()));
        }
    }

    public void setEstabController(EstabController estabController) {
        this.estabController = estabController;
    }
}
