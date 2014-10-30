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
    private List<VehicleModel> allVehicles;
    private List<WeaponModel> allWeapons;
    private List<AmmoModel> allAmmo;

    private List<VehicleModel> repeatedVehicles;
    private List<WeaponModel> repeatedWeapons;
    private List<AmmoModel> repeatedAmmo;

    private Map<AssetModel, Class> repeatedAssets;

    public CopyPasteLists() {
        this.allVehicles = new ArrayList<>();
        this.allWeapons = new ArrayList<>();
        this.allAmmo = new ArrayList<>();
        this.repeatedVehicles = new ArrayList<>();
        this.repeatedWeapons = new ArrayList<>();
        this.repeatedAmmo = new ArrayList<>();
        this.repeatedAssets = new HashMap<>();
    }

    public boolean hasRepeatedElements() {
        return !repeatedAmmo.isEmpty() || !repeatedVehicles.isEmpty() || !repeatedWeapons.isEmpty();
    }

    public List<VehicleModel> getAllVehicles() {
        return allVehicles;
    }

    public void setAllVehicles(List<VehicleModel> allVehicles) {
        this.allVehicles = allVehicles;
    }

    public List<WeaponModel> getAllWeapons() {
        return allWeapons;
    }

    public void setAllWeapons(List<WeaponModel> allWeapons) {
        this.allWeapons = allWeapons;
    }

    public List<AmmoModel> getAllAmmo() {
        return allAmmo;
    }

    public void setAllAmmo(List<AmmoModel> allAmmo) {
        this.allAmmo = allAmmo;
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

    public Map<AssetModel, Class> getRepeatedAssets() {
        this.repeatedAssets = new HashMap<>();
        for (VehicleModel v : getRepeatedVehicles()) {
            repeatedAssets.put((AssetModel) v, Vehicle.class);
        }
        for (WeaponModel w : getRepeatedWeapons()) {
            repeatedAssets.put((AssetModel) w, Weapon.class);
        }
        for (AmmoModel a : getRepeatedAmmo()) {
            repeatedAssets.put((AssetModel) a, Ammo.class);
        }
        return repeatedAssets;
    }
}
