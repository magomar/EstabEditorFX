package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.PrimaryRole;
import net.deludobellico.stabeditor.data.jaxb.Weapon;
import net.deludobellico.stabeditor.data.jaxb.WeaponType;
import net.deludobellico.stabeditor.data.jaxb.YesNo;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class WeaponEditorController implements Initializable, AssetEditorController<Weapon> {

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField name;

    @FXML
    private TextArea description;

    @FXML
    private TextField crew;

    @FXML
    private TextField reliability;

    @FXML
    private ComboBox<WeaponType> weaponType;

    @FXML
    private CheckBox singleShot;

    @FXML
    private ComboBox<PrimaryRole> weaponPrimaryRole;

    @FXML
    private TextField calibre;

    @FXML
    private TextField muzzleVelocity;

    @FXML
    private CheckBox mustDeployToFire;

    //TODO: add PerformanceList


    private Weapon weapon;
    private ObservableList<WeaponType> weaponTypeObservableList = FXCollections.observableArrayList();
    private ObservableList<PrimaryRole> weaponPrimaryRoleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        weapon = new Weapon();

        weaponTypeObservableList.addAll(WeaponType.values());
        weaponPrimaryRoleObservableList.addAll(PrimaryRole.values());

        weaponType.setItems(weaponTypeObservableList);
        weaponPrimaryRole.setItems(weaponPrimaryRoleObservableList);

        weaponType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WeaponType>() {
            @Override
            public void changed(ObservableValue<? extends WeaponType> observable, WeaponType oldValue, WeaponType newValue) {
                if (null != newValue)
                    weapon.setType(newValue);
            }
        });

        weaponPrimaryRole.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<PrimaryRole>() {
            @Override
            public void changed(ObservableValue<? extends PrimaryRole> observable, PrimaryRole oldValue, PrimaryRole newValue) {
                if (null != newValue) {
                    weapon.setPrimaryRole(newValue);
                }
            }
        });

        singleShot.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (null != newValue) {
                    weapon.setSingleShot((newValue == true) ? YesNo.YES : YesNo.NO);
                }
            }
        });

        mustDeployToFire.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (null != newValue) {
                    weapon.setMustDeployToFire((newValue == true) ? YesNo.YES : YesNo.NO);
                }
            }
        });

    }

    @Override
    public void setEditable(boolean isEditable) {
        weightTextField.setEditable(isEditable);
        name.setEditable(isEditable);
        description.setEditable(isEditable);
        crew.setEditable(isEditable);
        reliability.setEditable(isEditable);
        weaponPrimaryRole.setEditable(isEditable);
        weaponType.setEditable(isEditable);
        singleShot.setDisable(!isEditable);
        singleShot.setStyle("-fx-opacity: 1");
        mustDeployToFire.setDisable(!isEditable);
        mustDeployToFire.setStyle("-fx-opacity: 1");
        calibre.setEditable(isEditable);
        muzzleVelocity.setEditable(isEditable);
    }

    @Override
    public void bindProperties(Weapon weapon) {
        weightTextField.textProperty().bindBidirectional(weapon.getSize().weightProperty(), new NumberStringConverter());
        name.textProperty().bindBidirectional(weapon.nameProperty());
        description.textProperty().bindBidirectional(weapon.descriptionProperty());
        crew.textProperty().bindBidirectional(weapon.crewProperty(), new NumberStringConverter());
        reliability.textProperty().bindBidirectional(weapon.reliabilityProperty(), new NumberStringConverter());

        //TODO: fix combo box property
        weaponType.getSelectionModel().select(weapon.getType());
        weaponPrimaryRole.getSelectionModel().select(weapon.getPrimaryRole());

        //TODO: fix boolean properties
        singleShot.setSelected((weapon.getSingleShot().equals(YesNo.YES) ? true : false));
        mustDeployToFire.setSelected((weapon.getMustDeployToFire().equals(YesNo.YES) ? true : false));


        calibre.textProperty().bindBidirectional(weapon.calibreProperty(), new NumberStringConverter());
        muzzleVelocity.textProperty().bindBidirectional(weapon.muzzleVelocityProperty(), new NumberStringConverter());
    }

    @Override
    public void unbindProperties(Weapon w) {
        weightTextField.textProperty().unbindBidirectional(weapon.getSize().weightProperty());
        name.textProperty().unbindBidirectional(weapon.nameProperty());
        description.textProperty().unbindBidirectional(weapon.descriptionProperty());
        crew.textProperty().unbindBidirectional(weapon.crewProperty());
        reliability.textProperty().unbindBidirectional(weapon.reliabilityProperty());

        //TODO: fix combo box property
//        weaponType.getSelectionModel().select(weapon.getType());
//        weaponPrimaryRole.getSelectionModel().select(weapon.getPrimaryRole());

        //TODO: fix boolean properties
//        singleShot.setSelected((weapon.getSingleShot().equals("yes") ? true : false));
//        mustDeployToFire.setSelected((weapon.getMustDeployToFire().equals("yes") ? true : false));


        calibre.textProperty().unbindBidirectional(weapon.calibreProperty());
        muzzleVelocity.textProperty().unbindBidirectional(weapon.muzzleVelocityProperty());
        
    }

    @Override
    public void setEstabElement(Weapon newWeapon) {
        Weapon previousWeapon = this.weapon;
        this.weapon = newWeapon;

        if (previousWeapon.getName() != null) unbindProperties(previousWeapon);
        bindProperties(newWeapon);

    }

    @Override
    public Weapon getEstabElement() {
        return weapon;
    }


}
