package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.*;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Created by mario on 30-Jul-14.
 */
public class EstabModel {
    private static final Logger LOG = Logger.getLogger(EstabModel.class.getName());
    private Map<Integer, Image> images;
    private Map<Integer, Side> sides;
    private Map<Integer, VehicleModel> vehicles;
    private Map<Integer, WeaponModel> weapons;
    private Map<Integer, AmmoModel> ammos;
    private Map<Integer, FormationEffects> formationEffects;
    //TODO radios
    private Map<Class, Map> allElements;

    public EstabModel(File estabFile) {
        this((EstabData) FileIO.loadEstab(estabFile));
    }

    public EstabModel(EstabData estabData) {

        List<Image> estabImage = estabData.getImage();
        List<Side> estabSides = estabData.getSide();
        List<Vehicle> estabVehicles = estabData.getVehicle();
        List<Weapon> estabWeapons = estabData.getWeapon();
        List<Ammo> estabAmmo = estabData.getAmmo();
        List<FormationEffects> estabFormationEffects = estabData.getFormationEffects();

        // Initial size to avoid resizing
        images = new HashMap<>(estabImage.size());
        sides = new HashMap<>(estabSides.size());
        vehicles = new HashMap<>(estabVehicles.size());
        weapons = new HashMap<>(estabWeapons.size());
        ammos = new HashMap<>(estabAmmo.size());
        formationEffects = new HashMap<>(estabFormationEffects.size());

        allElements = new HashMap<>(6);
        allElements.put(Image.class, images);
        allElements.put(SideModel.class, sides);
        allElements.put(VehicleModel.class, vehicles);
        allElements.put(WeaponModel.class, weapons);
        allElements.put(AmmoModel.class, ammos);
        allElements.put(FormationEffects.class, formationEffects);

        estabImage.stream().forEach(image -> images.put(Integer.valueOf(image.getId()), image));
        estabSides.stream().forEach(side -> sides.put(Integer.valueOf(side.getId()), side));
        estabFormationEffects.stream().forEach(effects -> formationEffects.put(Integer.valueOf(effects.getId()), effects));

        estabVehicles.stream()
                .map(VehicleModel::new)
                .forEach(vehicleModel -> vehicles.put(vehicleModel.getId(), vehicleModel));

        estabData.getWeapon().stream()
                .map(WeaponModel::new)
                .forEach(weaponModel -> weapons.put(weaponModel.getId(), weaponModel));

        estabData.getAmmo().stream()
                .map(AmmoModel::new)
                .forEach(ammoModel -> ammos.put(ammoModel.getId(), ammoModel));
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

    public Map<Integer, AmmoModel> getAmmo() {
        return ammos;
    }

    public List<ElementModel> searchElement(String name, Class elementModelClass) {
        String lowerCase = name.toLowerCase();
        return (List<ElementModel>) allElements.get(elementModelClass).values().parallelStream()
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
            AmmoModel ammo = ammos.get(performance.getAmmoLoad().getId());
            if (ammo != null) {
                ammoList.add(ammo);
            }
        }
        return ammoList;
    }

    /**
     * {@sortRepeatedElements} has to be invoked in order to clean NonRepeated lists
     *
     * @param
     * @return
     */
    public RelatedElementLists getRelatedElements(ElementModel elementModel) {
        return getRelatedElements(elementModel, null);
    }

    //TODO: change ElementModel to Collection<ElementModel>
    public RelatedElementLists getRelatedElements(ElementModel elementModel, EstabModel targetModel) {

        RelatedElementLists relatedElementLists = new RelatedElementLists();

        if (elementModel.getClass() == VehicleModel.class) {
            relatedElementLists.getAllVehicles().add((VehicleModel) elementModel);
        } else if (elementModel.getClass() == WeaponModel.class) {
            relatedElementLists.getAllWeapons().add((WeaponModel) elementModel);
        } else {
            relatedElementLists.getAllAmmo().add((AmmoModel) elementModel);
        }

        for (VehicleModel v : relatedElementLists.getAllVehicles()) {
            List<WeaponModel> weapons = getWeaponListFromVehicle(v);
            relatedElementLists.getAllWeapons().addAll(weapons);
        }

        for (WeaponModel w : relatedElementLists.getAllWeapons()) {
            List<AmmoModel> ammo = getAmmoListFromWeapon(w);
            relatedElementLists.getAllAmmo().addAll(ammo);
        }

        if (targetModel != null) {
            sortRelatedElements(relatedElementLists);
        }
        return relatedElementLists;
    }

    /**
     * Move all repeated elements from NonRepeated to Repeated
     *
     * @param relatedElementLists
     */
    public void sortRelatedElements(RelatedElementLists relatedElementLists) {

        relatedElementLists.setSorted(true);
        relatedElementLists.getNonRepeatedVehicles().addAll(relatedElementLists.getAllVehicles());
        relatedElementLists.getNonRepeatedWeapons().addAll(relatedElementLists.getAllWeapons());
        relatedElementLists.getNonRepeatedAmmo().addAll(relatedElementLists.getAllAmmo());

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

    public boolean remove(Collection selectedItems) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder("Removing elements (Selected only): " + newLine);
        for (Object selectedItem : selectedItems) {
            if (selectedItem instanceof AmmoModel) {
                AmmoModel a = (AmmoModel) selectedItem;
                ammos.remove(a.getId());
                logMessage.append("-- " + a.print() + newLine);
            } else if (selectedItem instanceof WeaponModel) {
                WeaponModel w = (WeaponModel) selectedItem;
                weapons.remove(w.getId());
                logMessage.append("-- " + w.print() + newLine);
            } else if (selectedItem instanceof VehicleModel) {
                VehicleModel v = (VehicleModel) selectedItem;
                vehicles.remove(v.getId());
                logMessage.append("-- " + v.print() + newLine);
            }
        }
        LOG.log(Level.INFO, logMessage.toString());
        return true;
    }

    public boolean remove(RelatedElementLists relatedElementLists) {

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
        return true;

    }

    public boolean paste(RelatedElementLists relatedElementLists, DialogAction answer, Collection selectedItems) {

        String newLine = System.getProperty("line.separator");
        if (answer.equals(DialogAction.OVERWRITE)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Overwriting repeated): " + newLine);

            for (VehicleModel v : relatedElementLists.getAllVehicles()) {
                vehicles.put(v.getId(), v);
                logMessage.append("-- " + v.print() + newLine);
            }
            for (WeaponModel w : relatedElementLists.getAllWeapons()) {
                weapons.put(w.getId(), w);
                logMessage.append("-- " + w.print() + newLine);
            }
            for (AmmoModel a : relatedElementLists.getAllAmmo()) {
                ammos.put(a.getId(), a);
                logMessage.append("-- " + a.print() + newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else if (answer.equals(DialogAction.SKIP_REPEATED)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Skipping repeated): " + newLine);

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
        } else if (answer.equals(DialogAction.COPY_SELECTION)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Selected only): " + newLine);
            for (Object selectedItem : selectedItems) {
                if (selectedItem instanceof AmmoModel) {
                    AmmoModel a = (AmmoModel) selectedItem;
                    ammos.put(a.getId(), a);
                    logMessage.append("-- " + a.print() + newLine);
                } else if (selectedItem instanceof WeaponModel) {
                    WeaponModel w = (WeaponModel) selectedItem;
                    weapons.put(w.getId(), w);
                    logMessage.append("-- " + w.print() + newLine);
                } else if (selectedItem instanceof VehicleModel) {
                    VehicleModel v = (VehicleModel) selectedItem;
                    vehicles.put(v.getId(), v);
                    logMessage.append("-- " + v.print() + newLine);
                }
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
        FileIO.saveEstab(data, file);
    }
}