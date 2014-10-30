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
public class AmmoEditorController implements Initializable, ElementEditorController {
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
    public void bindProperties(ElementModel element) {
        quantity.textProperty().bindBidirectional(ammo.minOrderQtyProperty(), new NumberStringConverter());
        weight.textProperty().bindBidirectional(ammo.minOrderWeightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(ammo.nameProperty());
        description.textProperty().bindBidirectional(ammo.descriptionProperty());
    }

    @Override
    public void unbindProperties(ElementModel element) {
        quantity.textProperty().unbindBidirectional(ammo.minOrderQtyProperty());
        weight.textProperty().unbindBidirectional(ammo.minOrderWeightProperty());
        name.textProperty().unbindBidirectional(ammo.nameProperty());
        description.textProperty().unbindBidirectional(ammo.descriptionProperty());
    }


    @Override
    public AmmoModel getEstabElement() {
        return ammo;
    }

    @Override
    public void setEstabElement(ElementModel element) {
        AmmoModel newAmmo = (AmmoModel) element;
        AmmoModel previousAmmo = this.ammo;
        this.ammo = newAmmo;

        if (previousAmmo != null) unbindProperties(previousAmmo);
        bindProperties(newAmmo);
    }


}
