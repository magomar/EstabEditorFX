package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Util;
import net.deludobellico.stabeditor.view.CustomAction;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.DialogAction;

import java.io.File;
import java.util.*;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataModel {
    private Map<Integer, Image> images;
    private Map<Integer, Side> sides;
    private Map<Integer, Vehicle> vehicles;
    private Map<Integer, Weapon> weapons;
    private Map<Integer, Ammo> ammos;
    private Map<Integer, FormationEffects> formationEffects;
    //TODO radios
    private Map<Class, Map> allElements;

    public EstabDataModel(File estabDataFile) {
        this((EstabData) FileIO.unmarshallXML(estabDataFile));
    }

    public EstabDataModel(EstabData estabData) {
        this();
        List<Image> imageList = estabData.getImage();
        for (Image image : imageList) {
            images.put(Integer.valueOf(image.getId()), image);
        }
        List<Side> sideList = estabData.getSide();
        for (Side side : sideList) {
            sides.put(Integer.valueOf(side.getId()), side);
        }

        List<Vehicle> vehicleList = estabData.getVehicle();
        for (Vehicle vehicle : vehicleList) {
            vehicles.put(Integer.valueOf(vehicle.getId()), vehicle);
        }

        List<Weapon> weaponList = estabData.getWeapon();
        for (Weapon weapon : weaponList) {
            weapons.put(Integer.valueOf(weapon.getId()), weapon);
        }

        List<Ammo> ammoList = estabData.getAmmo();
        for (Ammo ammo : ammoList) {
            ammos.put(Integer.valueOf(ammo.getId()), ammo);
        }

        List<FormationEffects> formationEffectsList = estabData.getFormationEffects();
        for (FormationEffects effects : formationEffectsList) {
            formationEffects.put(Integer.valueOf(effects.getId()), effects);
        }

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
        allElements.put(Vehicle.class, vehicles);
        allElements.put(Weapon.class, weapons);
        allElements.put(Ammo.class, ammos);
        allElements.put(FormationEffects.class, formationEffects);
    }

    public Map<Integer, Image> getImages() {
        return images;
    }

    public Map<Integer, Side> getSides() {
        return sides;
    }

    public Map<Integer, Vehicle> getVehicles() {
        return vehicles;
    }

    public Map<Integer, Weapon> getWeapons() {
        return weapons;
    }

    public Map<Integer, Ammo> getAmmos() {
        return ammos;
    }

    public List<Vehicle> searchVehicle(String name) {
        String lowerCase = name.toLowerCase();
        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicles.values()) {
            if (vehicle.getName().toLowerCase().contains(lowerCase)) searchResults.add(vehicle);
        }
        return searchResults;
    }

    public List<Weapon> searchWeapon(String name) {
        String lowerCase = name.toLowerCase();
        List<Weapon> searchResults = new ArrayList<>();
        for (Weapon weapon : weapons.values()) {
            if (weapon.getName().toLowerCase().contains(lowerCase)) searchResults.add(weapon);
        }
        return searchResults;
    }

    public List<Ammo> searchAmmo(String name) {
        String lowerCase = name.toLowerCase();
        List<Ammo> searchResults = new ArrayList<>();
        for (Ammo ammo : ammos.values()) {
            if (ammo.getName().toLowerCase().contains(lowerCase)) searchResults.add(ammo);
        }
        return searchResults;
    }

    public boolean hasRepeatedElements(EstabReference estabReference) {
        Map elementMap = allElements.get(estabReference.getElementClass());
        return elementMap.containsKey(estabReference.getId());
    }

    public void checkRepeatedElements(CopyPasteLists copyPasteLists) {

        Iterator<Vehicle> itV = copyPasteLists.getNonRepeatedVehicles().iterator();
        while(itV.hasNext()){
            Vehicle v = itV.next();
            if (vehicles.containsKey(v.getId())) {
                copyPasteLists.getRepeatedVehicles().add(v);
                itV.remove();
            }
        }

        Iterator<Weapon> itW = copyPasteLists.getNonRepeatedWeapons().iterator();
        while (itW.hasNext()) {
            Weapon w = itW.next();
            if (weapons.containsKey(w.getId())) {
                copyPasteLists.getRepeatedWeapons().add(w);
                itW.remove();
            }
        }

        Iterator<Ammo> itA = copyPasteLists.getNonRepeatedAmmo().iterator();
        while (itA.hasNext()) {
            Ammo a = itA.next();
            if (ammos.containsKey(a.getId())) {
                copyPasteLists.getRepeatedAmmo().add(a);
                itA.remove();
            }
        }
    }

    private List<Weapon> getWeaponListFromVehicle(Vehicle vehicle) {
        List<Weapon> weaponList = new ArrayList<>();
        for (Armament armament : vehicle.getArmaments().getArmament()) {
            Weapon weapon = weapons.get(armament.getEquipmentObjectId());
            if (weapon != null) {
                weaponList.add(weapon);
            }
        }

        return weaponList;
    }

    private List<Ammo> getAmmoListFromWeapon(Weapon weapon) {
        List<Ammo> ammoList = new ArrayList<>();

        for(Performance performance : weapon.getPerformanceList().getPerformance()) {
            Ammo ammo = ammos.get(performance.getAmmo().getObjectId());
            if(ammo != null) {
                ammoList.add(ammo);
            }
        }
        return ammoList;
    }

    public CopyPasteLists getElementsToCopy(EstabReference estabReference) {
        CopyPasteLists copyPasteLists = new CopyPasteLists();
        if (estabReference.getElementClass() == Vehicle.class) {
            Vehicle vehicle = (Vehicle) estabReference.getElement();
            copyPasteLists.getNonRepeatedVehicles().add(vehicle);
        } else if (estabReference.getElementClass() == Weapon.class) {
            Weapon weapon = (Weapon) estabReference.getElement();
            copyPasteLists.getNonRepeatedWeapons().add(weapon);
        } else if (estabReference.getElementClass() == Ammo.class) {
            Ammo ammo = (Ammo) estabReference.getElement();
            copyPasteLists.getNonRepeatedAmmo().add(ammo);
        }

        for (Vehicle v : copyPasteLists.getNonRepeatedVehicles()) {
            copyPasteLists.getNonRepeatedWeapons().addAll(getWeaponListFromVehicle(v));
        }

        for (Weapon w : copyPasteLists.getNonRepeatedWeapons()) {
            copyPasteLists.getNonRepeatedAmmo().addAll(getAmmoListFromWeapon(w));
        }
        return copyPasteLists;
    }

    public void paste(CopyPasteLists copyPasteLists, Action dialogAnswer) {

        if (dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            for (Vehicle v : copyPasteLists.getRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
            }
            for (Weapon w : copyPasteLists.getRepeatedWeapons()) {
                weapons.put(w.getId(), w);
            }
            for (Ammo a : copyPasteLists.getRepeatedAmmo()) {
                ammos.put(a.getId(), a);
            }
        }

        if (dialogAnswer == UtilView.DIALOG_SKIP_REPEATED || dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            for (Vehicle v : copyPasteLists.getNonRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
            }
            for (Weapon w : copyPasteLists.getNonRepeatedWeapons()) {
                weapons.put(w.getId(), w);
            }
            for (Ammo a : copyPasteLists.getNonRepeatedAmmo()) {
                ammos.put(a.getId(), a);
            }
        } else {
        }
    }

    public void saveToFile(File file) {
        EstabData data = new EstabData();
        data.getImage().addAll(images.values());
        data.getVehicle().addAll(vehicles.values());
        data.getAmmo().addAll(ammos.values());
        data.getFormationEffects().addAll(formationEffects.values());
        data.getSide().addAll(sides.values());
        data.getWeapon().addAll(weapons.values());
        FileIO.marshallXML(data, file);
    }

}
