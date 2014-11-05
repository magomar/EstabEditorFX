package net.deludobellico.commandops.estabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * This controller manages the ammo editor view and model
 *
 * @author Mario
 * @author Heine
 * @see EstabController
 */
public class AmmoEditorController implements Initializable, ElementEditorController<AmmoModel> {

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

    /**
     * Other
     */
    // Last binded ammo
    private AmmoModel activeAmmo;
    private EstabController estabController;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    /**
     * @param isEditable if true the controller sets the interface as editable, if false it sets the interface uneditable
     */
    @Override
    public void setEditable(boolean isEditable) {
        quantity.setEditable(isEditable);
        weight.setEditable(isEditable);
    }

    @Override
    public EstabController getEstabController() {
        return estabController;
    }

    @Override
    public void setEstabController(EstabController estabController) {
        this.estabController = estabController;
    }

    /**
     * @param element The {@link AmmoModel} to be binded
     */
    @Override
    public void bindProperties(AmmoModel element) {
        quantity.textProperty().bindBidirectional(element.minOrderQtyProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(element.minOrderWeightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
    }

    /**
     * @param element The {@link AmmoModel} to be unbinded
     */
    @Override
    public void unbindProperties(AmmoModel element) {
        quantity.textProperty().unbindBidirectional(element.minOrderQtyProperty());
        weight.textProperty().unbindBidirectional(element.minOrderWeightProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
    }

    @Override
    public void clear() {
        unbindProperties(activeAmmo);

        quantity.setText("");
        weight.setText("");
        name.setText("");
        description.setText("");
    }


    /**
     * @return the active {@link AmmoModel}
     */
    @Override
    public AmmoModel getActiveElement() {
        return activeAmmo;
    }

    /**
     * @param element The {@link AmmoModel} to be set as active
     */
    @Override
    public void setActiveElement(AmmoModel element) {
        if (activeAmmo != null) unbindProperties(activeAmmo);
        this.activeAmmo = element;
        bindProperties(activeAmmo);
    }


}
