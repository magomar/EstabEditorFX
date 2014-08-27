package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.deludobellico.stabeditor.data.jaxb.Ammo;

/**
 * Created by Mario on 04/08/2014.
 */
public class AmmoEditorController implements AssetEditorController<Ammo> {
    @FXML
    private TextField quantityTextField;

    @FXML
    private TextField weightTextField;

    @Override
    public void setEstabReference(Ammo ammo) {

    }

    @Override
    public void setEditable(boolean isEditable) {

    }
}
