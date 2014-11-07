package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.VehicleType;

/**
 * Created by Heine on 11/6/2014.
 */
public class ElementModelFactory {
    private static int maxID;

    public static VehicleModel createVehicle() {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(maxID++);
        vehicleModel.setName("New Vehicle");
        vehicleModel.setDescription("");
        vehicleModel.setPictureId(0);
        vehicleModel.setPictureFilename("");
        vehicleModel.setWidth(0.0);
        vehicleModel.setHeight(0.0);
        vehicleModel.setLength(0.0);
        vehicleModel.setWeight(0.0);
        vehicleModel.setCrew(0);
        vehicleModel.setReliability(0.0);
        vehicleModel.setType(VehicleType.CAR);
        vehicleModel.setFuelCapacity(0.0);
        vehicleModel.setMaxRoadSpeed(0.0);
        vehicleModel.setNormalRoadSpeed(0.0);
        vehicleModel.setMaxCrossCountrySpeed(0.0);
        vehicleModel.setNormalCrossCountrySpeed(0.0);
        vehicleModel.setMaxFuelConsumption(0.0);
        vehicleModel.setNormalFuelConsumption(0.0);
        vehicleModel.setRonsonability(0.0);
        vehicleModel.setMaxGradient(0);
        vehicleModel.setMaxFordingDepth(0);
        vehicleModel.setMaxTrenchWidth(0);
        vehicleModel.setTowingCapacity(0.0);
        vehicleModel.setPersonnelCapacity(0);
        vehicleModel.setBulkFuelCapacity(0.0);
        vehicleModel.setPayloadCapacity(0.0);
        vehicleModel.setTakeCoverMod(0.0);
        vehicleModel.setHasTurret(false);
        vehicleModel.setHasOpenTop(false);
        vehicleModel.setBattleWeight(0.0);
        vehicleModel.setFrontArmor(0.0);
        vehicleModel.setSideArmor(0.0);
        vehicleModel.setRearArmor(0.0);
        vehicleModel.setTopArmor(0.0);
        vehicleModel.getFlags().add(Flag.NEW);
        return vehicleModel;
    }

    public static WeaponModel createWeapon() {
        WeaponModel weaponModel = new WeaponModel();
        weaponModel.setId(maxID++);
        weaponModel.setName("New Weapon");
        weaponModel.getFlags().add(Flag.NEW);
        return weaponModel;
    }

    public static AmmoModel createAmmo() {
        AmmoModel ammoModel = new AmmoModel();
        ammoModel.setId(maxID++);
        ammoModel.setName("New Ammo");
        ammoModel.getFlags().add(Flag.NEW);
        return ammoModel;
    }

    public static int getMaxID() {
        return maxID;
    }

    public static void setMaxID(int maxID) {
        ElementModelFactory.maxID = maxID + 1;
    }
}
