package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.data.jaxb.VehicleType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates new element models and keeps track of the maximum ID
 *
 * @author Mario
 * @author Heine
 */
public final class ElementModelFactory {
    private static Integer maxId = 3611;

    private ElementModelFactory() {
    }

    /**
     * Auto-increment of the maximum ID in use.
     * This method is synchronized to prevent inconsistencies.
     *
     * @return the maximum id in use
     */
    public static synchronized int incrementMaxId() {
        return ++maxId;
    }

    /**
     * Sets the maximum ID in use.
     * This method is synchronized to prevent inconsistencies.
     *
     * @param maxId id to set if it's greater than the current max ID.
     */
    public static synchronized void setMaxId(int maxId) {
        if (ElementModelFactory.maxId < maxId)
            ElementModelFactory.maxId = ++maxId;
    }

    /**
     * New created elements append their ID inside parentheses to their name.
     * In order to avoid having multiple IDs in the name, this method strips the last ID and appends the new one.
     *
     * @param name  string to format
     * @param newId to append
     * @return formatted name with the id inside parentheses
     */
    public static String formatName(String name, int newId) {
        Pattern p = Pattern.compile(" (\\#\\d+)");
        Matcher m = p.matcher(name);
        String oldId = "";
        while (m.find()) oldId = m.group();
        return String.format("%s #%d", name.replace(oldId, ""), newId);
    }

    /**
     * Creates a new VehicleModel instance.
     *
     * @return new vehicle model
     */
    public static VehicleModel createVehicle() {
        VehicleModel vehicleModel = new VehicleModel();
        vehicleModel.setId(++maxId);
        vehicleModel.setName(ElementModelFactory.formatName("New Vehicle", vehicleModel.getId()));
        vehicleModel.setDescription("");
        vehicleModel.setPictureFilename("");
        vehicleModel.setType(VehicleType.CAR);
        vehicleModel.getFlags().add(Flag.NEW);
        return vehicleModel;
    }

    /**
     * Creates a new WeaponModel instance.
     *
     * @return new weapon model
     */
    public static WeaponModel createWeapon() {
        WeaponModel weaponModel = new WeaponModel();
        weaponModel.setId(++maxId);
        weaponModel.setName(ElementModelFactory.formatName("New Weapon", weaponModel.getId()));
        weaponModel.getFlags().add(Flag.NEW);
        return weaponModel;
    }

    /**
     * Creates a new AmmoModel instance.
     *
     * @return new ammo model
     */
    public static AmmoModel createAmmo() {
        AmmoModel ammoModel = new AmmoModel();
        ammoModel.setId(++maxId);
        ammoModel.setName(ElementModelFactory.formatName("New Ammo", ammoModel.getId()));
        ammoModel.getFlags().add(Flag.NEW);
        return ammoModel;
    }

    /**
     * Creates a new ImageModel instance.
     *
     * @return new image model
     */
    public static ImageModel createImage() {
        ImageModel imageModel = new ImageModel();
        imageModel.setId(++maxId);
        imageModel.setName(ElementModelFactory.formatName("New Image", imageModel.getId()));
        imageModel.getFlags().add(Flag.NEW);
        return imageModel;
    }

    // TODO createForceModel()
}
