package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.*;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.view.UtilView;
import org.controlsfx.control.action.Action;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabDataModel {
    private static final Logger LOG = Logger.getLogger(EstabDataModel.class.getName());
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

    public List<ElementModel> searchElement(String name, Class elementClass) {
        String lowerCase = name.toLowerCase();
        return (List<ElementModel>) allElements.get(elementClass).values().parallelStream()
                .filter(element -> ((ElementModel) element).getName().toLowerCase().contains(lowerCase))
                .collect(Collectors.<ElementModel>toList());
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

    /**
     * All elements are first saved to "NonRepeated" lists, which might confuse until {@sortRepeatedElements} is invoked
     *
     * @param estabReference
     * @return
     */
    public CopyPasteLists getElementsToCopy(EstabReference estabReference) {
        CopyPasteLists copyPasteLists = new CopyPasteLists();
        if (estabReference.getElementClass() == Vehicle.class) {
            copyPasteLists.getNonRepeatedVehicles().add(new VehicleModel((Vehicle) estabReference.getElement()));
        } else if (estabReference.getElementClass() == Weapon.class) {
            copyPasteLists.getNonRepeatedWeapons().add(new WeaponModel((Weapon) estabReference.getElement()));
        } else if (estabReference.getElementClass() == Ammo.class) {
            copyPasteLists.getNonRepeatedAmmo().add(new AmmoModel((Ammo) estabReference.getElement()));
        }

        for (VehicleModel v : copyPasteLists.getNonRepeatedVehicles()) {
            copyPasteLists.getNonRepeatedWeapons().addAll(getWeaponListFromVehicle(v));
        }

        for (WeaponModel w : copyPasteLists.getNonRepeatedWeapons()) {
            copyPasteLists.getNonRepeatedAmmo().addAll(getAmmoListFromWeapon(w));
        }
        sortRepeatedElements(copyPasteLists);
        return copyPasteLists;
    }

    /**
     * Move all repeated elements from NonRepeated to Repeated
     *
     * @param copyPasteLists
     */
    public void sortRepeatedElements(CopyPasteLists copyPasteLists) {
        //Iterators are the only way to safe delete while iterating
        Iterator<VehicleModel> itV = copyPasteLists.getNonRepeatedVehicles().iterator();
        while (itV.hasNext()) {
            VehicleModel v = itV.next();
            if (vehicles.containsKey(v.getId())) {
                copyPasteLists.getRepeatedVehicles().add(v);
                itV.remove();
            }
        }

        Iterator<WeaponModel> itW = copyPasteLists.getNonRepeatedWeapons().iterator();
        while (itW.hasNext()) {
            WeaponModel w = itW.next();
            if (weapons.containsKey(w.getId())) {
                copyPasteLists.getRepeatedWeapons().add(w);
                itW.remove();
            }
        }

        Iterator<AmmoModel> itA = copyPasteLists.getNonRepeatedAmmo().iterator();
        while (itA.hasNext()) {
            AmmoModel a = itA.next();
            if (ammos.containsKey(a.getId())) {
                copyPasteLists.getRepeatedAmmo().add(a);
                itA.remove();
            }
        }
    }


    public boolean paste(CopyPasteLists copyPasteLists, Action dialogAnswer) {

        if (dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            StringBuilder logMessage = new StringBuilder("Overwriting repeated elements: ");
            logMessage.append(System.getProperty("line.separator"));

            for (VehicleModel v : copyPasteLists.getRepeatedVehicles()) {
                vehicles.put(v.getId(), v);

                logMessage.append("-- ");
                logMessage.append(v.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            for (WeaponModel w : copyPasteLists.getRepeatedWeapons()) {
                weapons.put(w.getId(), w);

                logMessage.append("-- ");
                logMessage.append(w.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            for (AmmoModel a : copyPasteLists.getRepeatedAmmo()) {
                ammos.put(a.getId(), a);

                logMessage.append("-- ");
                logMessage.append(a.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            LOG.log(Level.INFO, logMessage.toString());
        }

        if (dialogAnswer == UtilView.DIALOG_SKIP_REPEATED || dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            StringBuilder logMessage = new StringBuilder("Copying non repeated elements");
            logMessage.append(System.getProperty("line.separator"));

            for (VehicleModel v : copyPasteLists.getNonRepeatedVehicles()) {
                vehicles.put(v.getId(), v);

                logMessage.append("-- ");
                logMessage.append(v.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            for (WeaponModel w : copyPasteLists.getNonRepeatedWeapons()) {
                weapons.put(w.getId(), w);

                logMessage.append("-- ");
                logMessage.append(w.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            for (AmmoModel a : copyPasteLists.getNonRepeatedAmmo()) {
                ammos.put(a.getId(), a);

                logMessage.append("-- ");
                logMessage.append(a.getName());
                logMessage.append(System.getProperty("line.separator"));
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else {
            LOG.log(Level.INFO, "Copy canceled");
            return false;
        }
        return true;
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
