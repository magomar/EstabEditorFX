package net.deludobellico.commandops.estabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;
import net.deludobellico.commandops.estabeditor.model.EstabModel;
import net.deludobellico.commandops.estabeditor.model.ImageModel;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * This controller manages the ammo editor view and model
 *
 * @author Mario
 * @author Heine
 * @see EstabEditorController
 */
public class AmmoEditorController extends AbstractElementEditorController<AmmoModel> {

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
    private TextField quantity;
    @FXML
    private TextField weight;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        description.setWrapText(true);
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface not editable
     */
    @Override
    public void setEditable(boolean isEditable) {
        quantity.setEditable(isEditable);
        weight.setEditable(isEditable);
    }


    @Override
    public void bindProperties() {
        AmmoModel element = getActiveElement();
        quantity.textProperty().bindBidirectional(element.minOrderQtyProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(element.minOrderWeightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
    }

    @Override
    public void unbindProperties() {
        AmmoModel element = getActiveElement();
        quantity.textProperty().unbindBidirectional(element.minOrderQtyProperty());
        weight.textProperty().unbindBidirectional(element.minOrderWeightProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
    }

    @Override
    public void clear() {
        super.clear();

        quantity.setText("");
        weight.setText("");
        name.setText("");
        description.setText("");
    }


}
