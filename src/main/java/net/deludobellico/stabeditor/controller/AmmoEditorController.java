package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.Ammo;

/**
 * Created by Mario on 04/08/2014.
 */
public class AmmoEditorController implements AssetEditorController<Ammo> {
    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField weightTextField;

    private Ammo ammo;

    @Override
    public void setEditable(boolean isEditable) {
        quantityTextField.setEditable(isEditable);
        weightTextField.setEditable(isEditable);
    }

    @Override
    public void bindProperties(Ammo ammo) {
        quantityTextField.textProperty().bindBidirectional(ammo.minOrderQtyProperty(), new NumberStringConverter());
        weightTextField.textProperty().bindBidirectional(ammo.minOrderWeightProperty(), new NumberStringConverter());
    }

    @Override
    public void unbindProperties(Ammo ammo) {
        quantityTextField.textProperty().unbindBidirectional(ammo.minOrderQtyProperty());
        weightTextField.textProperty().unbindBidirectional(ammo.minOrderWeightProperty());
    }

    @Override
    public Ammo getEstabElement() {
        return ammo;
    }

    @Override
    public void setEstabElement(Ammo newAmmo) {
        Ammo previousAmmo = this.ammo;
        this.ammo = newAmmo;

        if(previousAmmo.getName() != null) unbindProperties(previousAmmo);
        bindProperties(newAmmo);
    }
}
