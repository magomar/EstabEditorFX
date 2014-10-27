package net.deludobellico.stabeditor.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.converter.NumberStringConverter;
import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.model.WeaponModel;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

/**
 * Created by Mario on 04/08/2014.
 */
public class WeaponEditorController implements Initializable, AssetEditorController<Weapon> {

    @FXML
    private TextField reliability;

    @FXML
    private TextArea description;

    @FXML
    private Button addRange;

    @FXML
    private TextField crew;

    @FXML
    private TextField burstRadius;

    @FXML
    private TextField fireRateNormal;

    @FXML
    private TextField load;

    @FXML
    private CheckBox singleShot;

    @FXML
    private CheckBox mustDeployToFire;

    @FXML
    private Button removeRange;

    @FXML
    private ComboBox<PrimaryRole> weaponPrimaryRole;

    @FXML
    private TextField fireRateSlow;

    @FXML
    private TextField fireRateRapid;

    @FXML
    private TextField tableRange;

    @FXML
    private TextField muzzleVelocity;

    @FXML
    private TextField shellWeight;

    @FXML
    private Label ammoName;

    @FXML
    private TextField tableAccuracy;

    @FXML
    private TextField calibre;

    @FXML
    private TextField weightTextField;

    @FXML
    private TextField name;

    @FXML
    private ComboBox<WeaponType> weaponType;

    @FXML
    private TextField tableArmor;

    @FXML
    private TableView<RangeItem> rangeTable;

    @FXML
    private TextField minRange;

    //TODO: add PerformanceList
    @FXML
    private ListView<FireType> performanceFireTypeList;
    private ObservableList<FireType> fireTypeObservableList = FXCollections.observableArrayList();

    private Weapon weapon;
    private Performance performance;
    private ObservableList<WeaponType> weaponTypeObservableList = FXCollections.observableArrayList();
    private ObservableList<PrimaryRole> weaponPrimaryRoleObservableList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        weapon = new Weapon();


        performanceFireTypeList.setItems(fireTypeObservableList);
        performanceFireTypeList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<FireType>() {
            @Override
            public void changed(ObservableValue<? extends FireType> observable, FireType oldValue, FireType newValue) {
                Performance previousPerformance = performance;
                for (Performance p : WeaponEditorController.this.weapon.getPerformanceList().getPerformance()) {
                    if (p.getFireType().equals(newValue)) {
                        if(oldValue!=null && previousPerformance != null)unbindPerformanceProperties(previousPerformance);
                        bindPerformanceProperties(p);
                        performance = p;
                        break;
                    }
                }
            }
        });

        weaponTypeObservableList.addAll(WeaponType.values());
        weaponType.setItems(weaponTypeObservableList);
        weaponType.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<WeaponType>() {
            @Override
            public void changed(ObservableValue<? extends WeaponType> observable, WeaponType oldValue, WeaponType newValue) {
                if (null != newValue)
                    weapon.setType(newValue);
            }
        });

        weaponPrimaryRoleObservableList.addAll(PrimaryRole.values());
        weaponPrimaryRole.setItems(weaponPrimaryRoleObservableList);
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

    private void unbindPerformanceProperties(Performance p) {
        minRange.textProperty().unbindBidirectional(p.minRangeProperty());
        fireRateSlow.textProperty().unbindBidirectional(p.getRof().slowProperty());
        fireRateNormal.textProperty().unbindBidirectional(p.getRof().normalProperty());
        fireRateRapid.textProperty().unbindBidirectional(p.getRof().rapidProperty());
        burstRadius.textProperty().unbindBidirectional(p.burstRadiusProperty());
        shellWeight.textProperty().unbindBidirectional(p.shellWeightProperty());
        load.textProperty().unbindBidirectional(p.getAmmo().loadProperty());
    }

    private void bindPerformanceProperties(Performance p) {
        minRange.textProperty().bindBidirectional(p.minRangeProperty(), new NumberStringConverter());
        fireRateSlow.textProperty().bindBidirectional(p.getRof().slowProperty(), new NumberStringConverter());
        fireRateNormal.textProperty().bindBidirectional(p.getRof().normalProperty(), new NumberStringConverter());
        fireRateRapid.textProperty().bindBidirectional(p.getRof().rapidProperty(), new NumberStringConverter());
        burstRadius.textProperty().bindBidirectional(p.burstRadiusProperty(), new NumberStringConverter());
        shellWeight.textProperty().bindBidirectional(p.shellWeightProperty(), new NumberStringConverter());
        load.textProperty().bindBidirectional(p.getAmmo().loadProperty(), new NumberStringConverter());
        ammoName.setText(p.getAmmo().getName());
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
        calibre.textProperty().bindBidirectional(weapon.calibreProperty(), new NumberStringConverter());
        muzzleVelocity.textProperty().bindBidirectional(weapon.muzzleVelocityProperty(), new NumberStringConverter());

        weaponType.getSelectionModel().select(weapon.getType());
        weaponPrimaryRole.getSelectionModel().select(weapon.getPrimaryRole());

        singleShot.setSelected((weapon.getSingleShot().equals(YesNo.YES) ? true : false));
        mustDeployToFire.setSelected((weapon.getMustDeployToFire().equals(YesNo.YES) ? true : false));

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

        fireTypeObservableList.clear();

        for (Map.Entry<FireType, Boolean> entry : WeaponModel.getFireTypeMap(this.weapon).entrySet()) {
            if(entry.getValue()) fireTypeObservableList.add(entry.getKey());
        }
    }

    @Override
    public Weapon getEstabElement() {
        return weapon;
    }


}
