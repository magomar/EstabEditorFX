package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataModel {
    private Map<Integer, Image> images;
    private Map<Integer, Side> sides;
    private Map<Integer, VehicleModel> vehicles;
    private Map<Integer, WeaponModel> weapons;
    private Map<Integer, AmmoModel> ammos;
    private Map<Integer, FormationEffects> formationEffects;
    //TODO radios
    private Map<Class, Map> allElements;

    public EstabDataModel(File estabDataFile) {
        this((EstabData) FileIO.unmarshallXML(estabDataFile));
    }

    public EstabDataModel(EstabData estabData) {
        this();

        estabData.getImage().stream().forEach(image -> images.put(Integer.valueOf(image.getId()), image));
        estabData.getSide().stream().forEach(side -> sides.put(Integer.valueOf(side.getId()), side));
        estabData.getFormationEffects().stream().forEach(effects -> formationEffects.put(Integer.valueOf(effects.getId()), effects));

        estabData.getVehicle().stream()
                .map(vehicle -> new VehicleModel(vehicle))
                .forEach(vehicleModel -> vehicles.put(vehicleModel.getId(), vehicleModel));

        estabData.getWeapon().stream()
                .map(weapon -> new WeaponModel(weapon))
                .forEach(weaponModel -> weapons.put(weaponModel.getId(), weaponModel));

        estabData.getAmmo().stream()
                .map(ammo -> new AmmoModel(ammo))
                .forEach(ammoModel -> ammos.put(ammoModel.getId(), ammoModel));
    }

    public EstabDataModel() {
        images = new HashMap<>();
        sides = new HashMap<>();
        vehicles = new HashMap<>();
        weapons = new HashMap<>();
        ammos = new HashMap<>();
        formationEffects = new HashMap<>();
        allElements = new HashMap<>();
        allElements.put(Image.class, images);
        allElements.put(Side.class, sides);
        allElements.put(VehicleModel.class, vehicles);
        allElements.put(WeaponModel.class, weapons);
        allElements.put(AmmoModel.class, ammos);
        allElements.put(FormationEffects.class, formationEffects);
    }

    public Map<Integer, Image> getImages() {
        return images;
    }

    public Map<Integer, Side> getSides() {
        return sides;
    }

    public Map<Integer, VehicleModel> getVehicles() {
        return vehicles;
    }

    public Map<Integer, WeaponModel> getWeapons() {
        return weapons;
    }

    public Map<Integer, AmmoModel> getAmmos() {
        return ammos;
    }

    public List<AssetModel> searchAsset(String name, Class assetClass) {
        String lowerCase = name.toLowerCase();
        return (List<AssetModel>) allElements.get(assetClass).values().parallelStream()
                .filter(asset -> ((AssetModel) asset).getName().toLowerCase().contains(lowerCase))
                .collect(Collectors.<AssetModel>toList());
    }

    public boolean hasRepeatedElements(EstabReference estabReference) {
        Map elementMap = allElements.get(estabReference.getElementClass());
        return elementMap.containsKey(estabReference.getId());
    }

    public void checkRepeatedElements(CopyPasteLists copyPasteLists) {

        copyPasteLists.getNonRepeatedVehicles().stream()
                .filter(vehicle -> vehicles.containsKey(vehicle.getId()))
                .forEach(vehicle -> {
                    copyPasteLists.getRepeatedVehicles().add(vehicle);
                    copyPasteLists.getNonRepeatedVehicles().remove(vehicle);
                });

        copyPasteLists.getNonRepeatedWeapons().stream()
                .filter(weapon -> weapons.containsKey(weapon.getId()))
                .forEach(weapon -> {
                    copyPasteLists.getRepeatedWeapons().add(weapon);
                    copyPasteLists.getNonRepeatedWeapons().remove(weapon);
                });

        copyPasteLists.getNonRepeatedAmmo().stream()
                .filter(ammo -> ammos.containsKey(ammo.getId()))
                .forEach(ammo -> {
                    copyPasteLists.getRepeatedAmmo().add(ammo);
                    copyPasteLists.getNonRepeatedAmmo().remove(ammo);
                });
    }

    private List<WeaponModel> getWeaponListFromVehicle(VehicleModel vehicle) {
        List<WeaponModel> weaponList = new ArrayList<>();
//        Not this time, lambda
//        vehicle.getArmaments().stream()
//                .filter(armament -> weapons.get(armament.getEquipmentObjectId()) != null)
//                .forEach(armament -> weaponList.add(weapons.get(armament.getEquipmentObjectId())));
        for (ArmamentModel armament : vehicle.getArmaments()) {
            WeaponModel weapon = weapons.get(armament.getEquipmentObjectId());
            if (weapon != null) {
                weaponList.add(weapon);
            }
        }
        return weaponList;
    }

    private List<AmmoModel> getAmmoListFromWeapon(WeaponModel weapon) {
        List<AmmoModel> ammoList = new ArrayList<>();

        for (PerformanceModel performance : weapon.getPerformances()) {
            AmmoModel ammo = ammos.get(performance.getAmmoLoad().getObjectId());
            if (ammo != null) {
                ammoList.add(ammo);
            }
        }
        return ammoList;
    }

    public CopyPasteLists getElementsToCopy(EstabReference estabReference) {
        CopyPasteLists copyPasteLists = new CopyPasteLists();
        if (estabReference.getElementClass() == Vehicle.class) {
            VehicleModel vehicle = (VehicleModel) estabReference.getElement();
            copyPasteLists.getNonRepeatedVehicles().add(vehicle);
        } else if (estabReference.getElementClass() == Weapon.class) {
            WeaponModel weapon = (WeaponModel) estabReference.getElement();
            copyPasteLists.getNonRepeatedWeapons().add(weapon);
        } else if (estabReference.getElementClass() == Ammo.class) {
            AmmoModel ammo = (AmmoModel) estabReference.getElement();
            copyPasteLists.getNonRepeatedAmmo().add(ammo);
        }

        for (VehicleModel v : copyPasteLists.getNonRepeatedVehicles()) {
            copyPasteLists.getNonRepeatedWeapons().addAll(getWeaponListFromVehicle(v));
        }

        for (WeaponModel w : copyPasteLists.getNonRepeatedWeapons()) {
            copyPasteLists.getNonRepeatedAmmo().addAll(getAmmoListFromWeapon(w));
        }
        return copyPasteLists;
    }

    public void paste(CopyPasteLists copyPasteLists, Action dialogAnswer) {

        if (dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            for (VehicleModel v : copyPasteLists.getRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
            }
            for (WeaponModel w : copyPasteLists.getRepeatedWeapons()) {
                weapons.put(w.getId(), w);
            }
            for (AmmoModel a : copyPasteLists.getRepeatedAmmo()) {
                ammos.put(a.getId(), a);
            }
        }

        if (dialogAnswer == UtilView.DIALOG_SKIP_REPEATED || dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            for (VehicleModel v : copyPasteLists.getNonRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
            }
            for (WeaponModel w : copyPasteLists.getNonRepeatedWeapons()) {
                weapons.put(w.getId(), w);
            }
            for (AmmoModel a : copyPasteLists.getNonRepeatedAmmo()) {
                ammos.put(a.getId(), a);
            }
        } else {
        }
    }

    public void saveToFile(File file) {
        EstabData data = new EstabData();
        data.getImage().addAll(images.values());
        // lambdas are beautiful
        data.getVehicle().addAll(vehicles.values().stream().map(VehicleModel::getPojo).collect(Collectors.toList()));
        data.getAmmo().addAll(ammos.values().stream().map(AmmoModel::getPojo).collect(Collectors.toList()));
        data.getFormationEffects().addAll(formationEffects.values());
        data.getSide().addAll(sides.values());
        data.getWeapon().addAll(weapons.values().stream().map(WeaponModel::getPojo).collect(Collectors.toList()));
        FileIO.marshallXML(data, file);
    }

}
