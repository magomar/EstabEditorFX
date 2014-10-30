package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Heine on 10/27/2014.
 */
public class CopyPasteLists {
    private List<VehicleModel> nonRepeatedVehicles;
    private List<WeaponModel> nonRepeatedWeapons;
    private List<AmmoModel> nonRepeatedAmmo;

    private List<VehicleModel> repeatedVehicles;
    private List<WeaponModel> repeatedWeapons;
    private List<AmmoModel> repeatedAmmo;

    private Map<ElementModel, Class> repeatedElements;

    public CopyPasteLists() {
        this.nonRepeatedVehicles = new ArrayList<>();
        this.nonRepeatedWeapons = new ArrayList<>();
        this.nonRepeatedAmmo = new ArrayList<>();
        this.repeatedVehicles = new ArrayList<>();
        this.repeatedWeapons = new ArrayList<>();
        this.repeatedAmmo = new ArrayList<>();
        this.repeatedElements = new HashMap<>();
    }

    public boolean hasRepeatedElements() {
        return !repeatedAmmo.isEmpty() || !repeatedVehicles.isEmpty() || !repeatedWeapons.isEmpty();
    }

    public List<VehicleModel> getNonRepeatedVehicles() {
        return nonRepeatedVehicles;
    }

    public void setNonRepeatedVehicles(List<VehicleModel> nonRepeatedVehicles) {
        this.nonRepeatedVehicles = nonRepeatedVehicles;
    }

    public List<WeaponModel> getNonRepeatedWeapons() {
        return nonRepeatedWeapons;
    }

    public void setNonRepeatedWeapons(List<WeaponModel> nonRepeatedWeapons) {
        this.nonRepeatedWeapons = nonRepeatedWeapons;
    }

    public List<AmmoModel> getNonRepeatedAmmo() {
        return nonRepeatedAmmo;
    }

    public void setNonRepeatedAmmo(List<AmmoModel> nonRepeatedAmmo) {
        this.nonRepeatedAmmo = nonRepeatedAmmo;
    }

    public List<VehicleModel> getRepeatedVehicles() {
        return repeatedVehicles;
    }

    public void setRepeatedVehicles(List<VehicleModel> repeatedVehicles) {
        this.repeatedVehicles = repeatedVehicles;
    }

    public List<WeaponModel> getRepeatedWeapons() {
        return repeatedWeapons;
    }

    public void setRepeatedWeapons(List<WeaponModel> repeatedWeapons) {
        this.repeatedWeapons = repeatedWeapons;
    }

    public List<AmmoModel> getRepeatedAmmo() {
        return repeatedAmmo;
    }

    public void setRepeatedAmmo(List<AmmoModel> repeatedAmmo) {
        this.repeatedAmmo = repeatedAmmo;
    }

    public Map<ElementModel, Class> getRepeatedElements() {
        this.repeatedElements = new HashMap<>();
        for (VehicleModel v : getRepeatedVehicles()) {
            repeatedElements.put((ElementModel) v, Vehicle.class);
        }
        for (WeaponModel w : getRepeatedWeapons()) {
            repeatedElements.put((ElementModel) w, Weapon.class);
        }
        for (AmmoModel a : getRepeatedAmmo()) {
            repeatedElements.put((ElementModel) a, Ammo.class);
        }
        return repeatedElements;
    }
}
