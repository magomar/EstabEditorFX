package net.deludobellico.stabeditor.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
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
    public void setEditable(boolean isEditable) {
        widthTextField.setEditable(isEditable);
        heightTextField.setEditable(isEditable);
        lengthTextField.setEditable(isEditable);
        weightTextField.setEditable(isEditable);
    }

    @Override
    public void bindProperties(Weapon weapon) {
        widthTextField.textProperty().bindBidirectional(weapon.getSize().widthProperty(), new NumberStringConverter());
        heightTextField.textProperty().bindBidirectional(weapon.getSize().heightProperty(), new NumberStringConverter());
        lengthTextField.textProperty().bindBidirectional(weapon.getSize().lengthProperty(), new NumberStringConverter());
        weightTextField.textProperty().bindBidirectional(weapon.getSize().weightProperty(), new NumberStringConverter());
    }

    @Override
    public void unbindProperties(Weapon w) {
        widthTextField.textProperty().unbindBidirectional(weapon.getSize().widthProperty());
        heightTextField.textProperty().unbindBidirectional(weapon.getSize().heightProperty());
        lengthTextField.textProperty().unbindBidirectional(weapon.getSize().lengthProperty());
        weightTextField.textProperty().unbindBidirectional(weapon.getSize().weightProperty());
    }

    @Override
    public Weapon getEstabElement() {
        return weapon;
    }

    @Override
    public void setEstabElement(Weapon newWeapon) {
        Weapon previousWeapon = this.weapon;
        this.weapon = newWeapon;

        if(previousWeapon.getName() != null) unbindProperties(previousWeapon);
        bindProperties(newWeapon);

    }
}
