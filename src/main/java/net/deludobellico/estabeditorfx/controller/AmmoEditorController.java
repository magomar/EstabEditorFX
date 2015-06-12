package net.deludobellico.estabeditorfx.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.estabeditorfx.model.AmmoModel;
import net.deludobellico.estabeditorfx.model.EstabModel;
import net.deludobellico.estabeditorfx.model.ImageModel;

import java.net.URL;
import java.util.Locale;
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
    @FXML
    private TextField id;

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
        description.setEditable(isEditable);
        quantity.setEditable(isEditable);
        weight.setEditable(isEditable);
    }


    @Override
    public void bindProperties() {
        AmmoModel element = getActiveElement();
        name.textProperty().bindBidirectional(element.nameProperty());
        id.textProperty().bindBidirectional(element.idProperty(), NUMBER_STRING_CONVERTER);
        description.textProperty().bindBidirectional(element.descriptionProperty());
        quantity.textProperty().bindBidirectional(element.minOrderQtyProperty(), NUMBER_STRING_CONVERTER);
        weight.textProperty().bindBidirectional(element.minOrderWeightProperty(), NUMBER_STRING_CONVERTER);
    }

    @Override
    public void unbindProperties() {
        AmmoModel element = getActiveElement();
        name.textProperty().unbindBidirectional(element.nameProperty());
        id.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
        quantity.textProperty().unbindBidirectional(element.minOrderQtyProperty());
        weight.textProperty().unbindBidirectional(element.minOrderWeightProperty());
    }

    @Override
    public void clear() {
        super.clear();
        name.setText("");
        id.setText("");
        description.setText("");
        quantity.setText("");
        weight.setText("");
    }


}
