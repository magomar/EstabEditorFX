package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.deludobellico.stabeditor.data.jaxb.Weapon;

/**
 * Created by Mario on 04/08/2014.
 */
public class WeaponEditorController implements AssetEditorController<Weapon> {
    @FXML
    private TextField widthTextField;

    @FXML
    private TextField lengthTextField;

    @FXML
    private TextField heightTextField;

    @FXML
    private TextField weightTextField;

    private Weapon weapon;

    @Override
    public void setEstabReference(Weapon weapon) {
        this.weapon = weapon;
        widthTextField.setText(String.valueOf(weapon.getSize().getWidth()));
        heightTextField.setText(String.valueOf(weapon.getSize().getHeight()));
        lengthTextField.setText(String.valueOf(weapon.getSize().getLength()));
        weightTextField.setText(String.valueOf(weapon.getSize().getWeight()));
    }

    @Override
    public void setEditable(boolean isReadOnly) {

    }
}
