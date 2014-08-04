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

    public List<Vehicle> searchVehicleByName(String name) {
        String lcName = name.toLowerCase();
        List<Vehicle> searchResults = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getName().toLowerCase().contains(lcName)) searchResults.add(vehicle);
        }
        return searchResults;
    }

    public Vehicle searchVehicleById(int id) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getId() == id) {
                return vehicle;
            }
        }
        return null;
    }

    public List<Weapon> searchWeaponByName(String name) {
        String lcName = name.toLowerCase();
        List<Weapon> searchResults = new ArrayList<>();
        for (Weapon weapon : weapons) {
            if (weapon.getName().toLowerCase().contains(lcName)) searchResults.add(weapon);
        }
        return searchResults;
    }
    public Weapon searchWeaponById(int id) {
        for (Weapon weapon : weapons) {
            if (weapon.getId() == id) {
                return weapon;
            }
        }
        return null;
    }
    public List<Ammo> searchAmmoByName(String name) {
        String lcName = name.toLowerCase();
        List<Ammo> searchResults = new ArrayList<>();
        for (Ammo ammo : ammos) {
            if (ammo.getName().toLowerCase().contains(lcName)) searchResults.add(ammo);
        }
        return searchResults;
    }
    public Ammo searchAmmoById(int id) {
        for (Ammo ammo : ammos) {
            if (ammo.getId() == id) {
                return ammo;
            }
        }
        return null;
    }

}
