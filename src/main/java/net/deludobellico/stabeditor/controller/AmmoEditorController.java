package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.model.AmmoModel;
import net.deludobellico.stabeditor.model.ElementModel;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class AmmoEditorController implements Initializable, ElementEditorController<AmmoModel> {
    @FXML
    private TextField quantity;

    @FXML
    private TextField weight;

    @FXML
    private TextField name;

    @FXML
    private TextArea description;

    private AmmoModel ammo;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    @Override
    public void setEditable(boolean isEditable) {
        quantity.setEditable(isEditable);
        weight.setEditable(isEditable);
    }

    @Override
    public void bindProperties(AmmoModel element) {
        quantity.textProperty().bindBidirectional(element.minOrderQtyProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(element.minOrderWeightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(element.nameProperty());
        description.textProperty().bindBidirectional(element.descriptionProperty());
    }

    @Override
    public void unbindProperties(AmmoModel element) {
        quantity.textProperty().unbindBidirectional(element.minOrderQtyProperty());
        weight.textProperty().unbindBidirectional(element.minOrderWeightProperty());
        name.textProperty().unbindBidirectional(element.nameProperty());
        description.textProperty().unbindBidirectional(element.descriptionProperty());
    }

    @Override
    public void clear() {
        unbindProperties(ammo);
    }


    @Override
    public AmmoModel getEstabElement() {
        return ammo;
    }

    @Override
    public void setEstabElement(AmmoModel element) {
        if (ammo != null) unbindProperties(ammo);
        this.ammo = element;
        bindProperties(ammo);
    }


}
