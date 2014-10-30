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
     * {@sortRepeatedElements} has to be invoked in order to clean NonRepeated lists
     *
     * @param estabReference
     * @return
     */
    public RelatedElementLists getRelatedElements(EstabReference estabReference) {
        return getRelatedElements(estabReference, true);
    }

    public RelatedElementLists getRelatedElements(EstabReference estabReference, boolean sort) {

        RelatedElementLists relatedElementLists = new RelatedElementLists();

        if (estabReference.getElementClass() == Vehicle.class) {
            VehicleModel v = new VehicleModel((Vehicle) estabReference.getElement());
            relatedElementLists.getAllVehicles().add(v);

        } else if (estabReference.getElementClass() == Weapon.class) {
            WeaponModel w = new WeaponModel((Weapon) estabReference.getElement());
            relatedElementLists.getAllWeapons().add(w);

        } else {
            AmmoModel a = new AmmoModel((Ammo) estabReference.getElement());
            relatedElementLists.getAllAmmo().add(a);
        }

        for (VehicleModel v : relatedElementLists.getAllVehicles()) {
            List<WeaponModel> weapons = getWeaponListFromVehicle(v);
            relatedElementLists.getAllWeapons().addAll(weapons);
        }

        for (WeaponModel w : relatedElementLists.getAllWeapons()) {
            List<AmmoModel> ammo = getAmmoListFromWeapon(w);
            relatedElementLists.getAllAmmo().addAll(ammo);
        }

        if(sort) {
            relatedElementLists.setSorted(sort);
            relatedElementLists.getNonRepeatedVehicles().addAll(relatedElementLists.getAllVehicles());
            relatedElementLists.getNonRepeatedWeapons().addAll(relatedElementLists.getAllWeapons());
            relatedElementLists.getNonRepeatedAmmo().addAll(relatedElementLists.getAllAmmo());
            sortRepeatedElements(relatedElementLists);
        }
        return relatedElementLists;
    }

    /**
     * Move all repeated elements from NonRepeated to Repeated
     *
     * @param relatedElementLists
     */
    public void sortRepeatedElements(RelatedElementLists relatedElementLists) {
        //Iterators are the only way to safe delete while iterating
        Iterator<VehicleModel> itV = relatedElementLists.getNonRepeatedVehicles().iterator();
        while (itV.hasNext()) {
            VehicleModel v = itV.next();
            if (vehicles.containsKey(v.getId())) {
                relatedElementLists.getRepeatedVehicles().add(v);
                itV.remove();
            }
        }

        Iterator<WeaponModel> itW = relatedElementLists.getNonRepeatedWeapons().iterator();
        while (itW.hasNext()) {
            WeaponModel w = itW.next();
            if (weapons.containsKey(w.getId())) {
                relatedElementLists.getRepeatedWeapons().add(w);
                itW.remove();
            }
        }

        Iterator<AmmoModel> itA = relatedElementLists.getNonRepeatedAmmo().iterator();
        while (itA.hasNext()) {
            AmmoModel a = itA.next();
            if (ammos.containsKey(a.getId())) {
                relatedElementLists.getRepeatedAmmo().add(a);
                itA.remove();
            }
        }
    }

    public void remove(RelatedElementLists relatedElementLists) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder("Removing elements:" + newLine);

        relatedElementLists.getAllVehicles().stream().forEach(v -> {
            logMessage.append("-- " + v.print() + newLine);
            vehicles.remove(v.getId());
        });
        relatedElementLists.getAllWeapons().stream().forEach(w -> {
            logMessage.append("-- " + w.print() + newLine);
            weapons.remove(w.getId());
        });
        relatedElementLists.getAllAmmo().stream().forEach(a -> {
            logMessage.append("-- " + a.print() + newLine);
            ammos.remove(a.getId());
        });

        LOG.log(Level.INFO, logMessage.toString());

    }

    public boolean paste(RelatedElementLists relatedElementLists, Action dialogAnswer) {

        String newLine = System.getProperty("line.separator");
        if (dialogAnswer == UtilView.DIALOG_OVERWRITE) {

            StringBuilder logMessage = new StringBuilder("Overwriting repeated elements: "+newLine);

            for (VehicleModel v : relatedElementLists.getRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
                logMessage.append("-- " + v.print() + newLine);
            }
            for (WeaponModel w : relatedElementLists.getRepeatedWeapons()) {
                weapons.put(w.getId(), w);
                logMessage.append("-- " + w.print() + newLine);
            }
            for (AmmoModel a : relatedElementLists.getRepeatedAmmo()) {
                ammos.put(a.getId(), a);
                logMessage.append("-- " + a.print() + newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        }

        if (dialogAnswer == UtilView.DIALOG_SKIP_REPEATED || dialogAnswer == UtilView.DIALOG_OVERWRITE) {
            StringBuilder logMessage = new StringBuilder("Copying non repeated elements");
            logMessage.append(System.getProperty("line.separator"));

            for (VehicleModel v : relatedElementLists.getNonRepeatedVehicles()) {
                vehicles.put(v.getId(), v);
                logMessage.append("-- " + v.print() + newLine);
            }
            for (WeaponModel w : relatedElementLists.getNonRepeatedWeapons()) {
                weapons.put(w.getId(), w);
                logMessage.append("-- " + w.print() + newLine);
            }
            for (AmmoModel a : relatedElementLists.getNonRepeatedAmmo()) {
                ammos.put(a.getId(), a);
                logMessage.append("-- " + a.print() + newLine);
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
