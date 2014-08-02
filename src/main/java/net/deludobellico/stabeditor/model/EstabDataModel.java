package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.FileIO;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataModel {
    private List<Image> images;
    private List<Side> sides;
    private List<Vehicle> vehicles;
    private List<Weapon> weapons;
    private List<Ammo> ammos;

    public EstabDataModel(File estabDataFile) {
        this((EstabData) FileIO.unmarshallXML(estabDataFile, FileIO.UNMARSHALLER));
    }

    public EstabDataModel(EstabData estabData) {
        images = estabData.getImage();
        sides = estabData.getSide();
        vehicles = estabData.getVehicle();
        weapons = estabData.getWeapon();
        ammos = estabData.getAmmo();
    }

    public EstabDataModel() {
        images = new ArrayList<>();
        sides = new ArrayList<>();
        vehicles = new ArrayList<>();
        weapons = new ArrayList<>();
        ammos = new ArrayList<>();
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Side> getSides() {
        return sides;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public List<Weapon> getWeapons() {
        return weapons;
    }

    public List<Ammo> getAmmos() {
        return ammos;
    }

//    public EstabReference searchByName(String name) {
//        return null;
//    }

    public List<Vehicle> searchVehicleByName(String name) {
        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().contains(name)) searchResults.add(vehicle);
        }
        return searchResults;
    }

    public Weapon searchWeaponByName(String name) {
        for (Weapon weapon : weapons) {
            if (weapon.getName().contains(name)) return weapon;
        }
        return null;
    }

    public Ammo searchAmmoByName(String name) {
        for (Ammo ammo : ammos) {
            if (ammo.getName().contains(name)) return ammo;
        }
        return null;
    }
}
