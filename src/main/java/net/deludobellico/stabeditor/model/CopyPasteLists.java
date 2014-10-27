package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.Asset;
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
    private List<Vehicle> nonRepeatedVehicles;
    private List<Weapon> nonRepeatedWeapons;
    private List<Ammo> nonRepeatedAmmo;

    private List<Vehicle> repeatedVehicles;
    private List<Weapon> repeatedWeapons;
    private List<Ammo> repeatedAmmo;

    private Map<Asset, Class> repeatedAssets;

    public boolean hasRepeatedElements() {
        return !repeatedAmmo.isEmpty() || !repeatedVehicles.isEmpty() || !repeatedWeapons.isEmpty();
    }

    public CopyPasteLists() {
        this.nonRepeatedVehicles = new ArrayList<>();
        this.nonRepeatedWeapons = new ArrayList<>();
        this.nonRepeatedAmmo = new ArrayList<>();
        this.repeatedVehicles = new ArrayList<>();
        this.repeatedWeapons = new ArrayList<>();
        this.repeatedAmmo = new ArrayList<>();
        this.repeatedAssets = new HashMap<>();
    }

    public List<Vehicle> getNonRepeatedVehicles() {
        return nonRepeatedVehicles;
    }

    public void setNonRepeatedVehicles(List<Vehicle> nonRepeatedVehicles) {
        this.nonRepeatedVehicles = nonRepeatedVehicles;
    }

    public List<Weapon> getNonRepeatedWeapons() {
        return nonRepeatedWeapons;
    }

    public void setNonRepeatedWeapons(List<Weapon> nonRepeatedWeapons) {
        this.nonRepeatedWeapons = nonRepeatedWeapons;
    }

    public List<Ammo> getNonRepeatedAmmo() {
        return nonRepeatedAmmo;
    }

    public void setNonRepeatedAmmo(List<Ammo> nonRepeatedAmmo) {
        this.nonRepeatedAmmo = nonRepeatedAmmo;
    }

    public List<Vehicle> getRepeatedVehicles() {
        return repeatedVehicles;
    }

    public void setRepeatedVehicles(List<Vehicle> repeatedVehicles) {
        this.repeatedVehicles = repeatedVehicles;
    }

    public List<Weapon> getRepeatedWeapons() {
        return repeatedWeapons;
    }

    public void setRepeatedWeapons(List<Weapon> repeatedWeapons) {
        this.repeatedWeapons = repeatedWeapons;
    }

    public List<Ammo> getRepeatedAmmo() {
        return repeatedAmmo;
    }

    public void setRepeatedAmmo(List<Ammo> repeatedAmmo) {
        this.repeatedAmmo = repeatedAmmo;
    }

    public Map<Asset, Class> getRepeatedAssets() {
        this.repeatedAssets = new HashMap<>();
        for (Vehicle v : getRepeatedVehicles()) {
            repeatedAssets.put((Asset) v, Vehicle.class);
        }
        for (Weapon w : getRepeatedWeapons()) {
            repeatedAssets.put((Asset) w, Weapon.class);
        }
        for (Ammo a : getRepeatedAmmo()) {
            repeatedAssets.put((Asset) a, Ammo.class);
        }
        return repeatedAssets;
    }
}
