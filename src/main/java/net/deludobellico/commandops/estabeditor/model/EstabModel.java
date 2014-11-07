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
    private Map<Integer, ImageModel> images;
    private Map<Integer, SideModel> sides;
    private Map<Integer, VehicleModel> vehicles;
    private Map<Integer, WeaponModel> weapons;
    private Map<Integer, AmmoModel> ammos;
    private Map<Integer, FormationEffectsModel> formationEffects;
    //TODO radios
    private Map<Class, Map<Integer, ? extends ElementModel>> allElements;

    public EstabModel(File estabFile) {
        this((EstabData) FileIO.loadEstab(estabFile));
    }

    public EstabModel(EstabData estabData) {

        List<Image> estabImages = estabData.getImage();
        List<Side> estabSides = estabData.getSide();
        List<Vehicle> estabVehicles = estabData.getVehicle();
        List<Weapon> estabWeapons = estabData.getWeapon();
        List<Ammo> estabAmmo = estabData.getAmmo();
        List<FormationEffects> estabFormationEffects = estabData.getFormationEffects();

        // Initial size to avoid resizing
        images = new HashMap<>(estabImages.size());
        sides = new HashMap<>(estabSides.size());
        vehicles = new HashMap<>(estabVehicles.size());
        weapons = new HashMap<>(estabWeapons.size());
        ammos = new HashMap<>(estabAmmo.size());
        formationEffects = new HashMap<>(estabFormationEffects.size());

        allElements = new HashMap<>(6);
        allElements.put(ImageModel.class, images);
        allElements.put(SideModel.class, sides);
        allElements.put(VehicleModel.class, vehicles);
        allElements.put(WeaponModel.class, weapons);
        allElements.put(AmmoModel.class, ammos);
        allElements.put(FormationEffectsModel.class, formationEffects);

        int maxID = 0;
        for (Image e : estabImages) {
            ImageModel em = new ImageModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            images.put(em.getId(), em);
        }
        for (Side e : estabSides) {
            SideModel em = new SideModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            sides.put(em.getId(), em);
        }
        for (FormationEffects e : estabFormationEffects) {
            FormationEffectsModel em = new FormationEffectsModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            formationEffects.put(em.getId(), em);
        }
        for (Vehicle e : estabVehicles) {
            VehicleModel em = new VehicleModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            vehicles.put(em.getId(), em);
        }
        for (Weapon e : estabWeapons) {
            WeaponModel em = new WeaponModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            weapons.put(em.getId(), em);
        }
        for (Ammo e : estabAmmo) {
            AmmoModel em = new AmmoModel(e);
            if (em.getId() > maxID) maxID = em.getId();
            ammos.put(em.getId(), em);
        }
        ElementModelFactory.setMaxID(maxID);
    }

    public EstabModel() {
        allElements = new HashMap<>();
    }

    public Map<Integer, ImageModel> getImages() {
        return images;
    }

    public Map<Integer, SideModel> getSides() {
        return sides;
    }

    public Map<Integer, VehicleModel> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Map<Integer, VehicleModel> vmap) {
        this.vehicles = vmap;
        allElements.put(VehicleModel.class, vmap);
    }

    public Map<Integer, WeaponModel> getWeapons() {
        return weapons;
    }

    public void setWeapons(Map<Integer, WeaponModel> wmap) {
        this.weapons = wmap;
        allElements.put(WeaponModel.class, wmap);
    }

    public void setAmmos(Map<Integer, AmmoModel> amap) {
        this.ammos = amap;
        allElements.put(AmmoModel.class, amap);
    }

    public Map<Integer, AmmoModel> getAmmo() {
        return ammos;
    }

    public List<ElementModel> searchElement(String name, Class elementModelClass) {
        String lowerCase = name.toLowerCase();
        return allElements.get(elementModelClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(lowerCase))
                .collect(Collectors.<ElementModel>toList());
    }

    private List<WeaponModel> getWeaponListFromVehicle(VehicleModel vehicle) {
        List<WeaponModel> weaponList = new ArrayList<>();
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
     * {@link #sortRelatedElements} has to be invoked in order to clean NonRepeated lists
     *
     * @param elements
     * @return all the related elements
     */
    public RelatedElementLists getRelatedElements(Collection<ElementModel> elements) {
        return getRelatedElements(elements, null);
    }

    //TODO: change ElementModel to Collection<ElementModel>
    public RelatedElementLists getRelatedElements(Collection<ElementModel> elements, EstabModel targetModel) {

        RelatedElementLists relatedElementLists = new RelatedElementLists();
        for (ElementModel elementModel : elements) {
            if (elementModel.getClass() == VehicleModel.class) {
                relatedElementLists.getAllVehicles().add((VehicleModel) elementModel);
            } else if (elementModel.getClass() == WeaponModel.class) {
                relatedElementLists.getAllWeapons().add((WeaponModel) elementModel);
            } else {
                relatedElementLists.getAllAmmo().add((AmmoModel) elementModel);
            }
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
            sortRelatedElements(relatedElementLists, targetModel);
        }
        return relatedElementLists;
    }

    /**
     * Move all repeated elements from NonRepeated to Repeated
     *
     * @param relatedElementLists
     */
    public void sortRelatedElements(RelatedElementLists relatedElementLists, EstabModel targetModel) {

        relatedElementLists.setSorted(true);
        relatedElementLists.getNonRepeatedVehicles().addAll(relatedElementLists.getAllVehicles());
        relatedElementLists.getNonRepeatedWeapons().addAll(relatedElementLists.getAllWeapons());
        relatedElementLists.getNonRepeatedAmmo().addAll(relatedElementLists.getAllAmmo());

        //Iterators are the only way to safe delete while iterating
        Iterator<VehicleModel> itV = relatedElementLists.getNonRepeatedVehicles().iterator();
        while (itV.hasNext()) {
            VehicleModel v = itV.next();
            if (targetModel.getVehicles().containsKey(v.getId())) {
                relatedElementLists.getRepeatedVehicles().add(v);
                itV.remove();
            }
        }

        Iterator<WeaponModel> itW = relatedElementLists.getNonRepeatedWeapons().iterator();
        while (itW.hasNext()) {
            WeaponModel w = itW.next();
            if (targetModel.getWeapons().containsKey(w.getId())) {
                relatedElementLists.getRepeatedWeapons().add(w);
                itW.remove();
            }
        }

        Iterator<AmmoModel> itA = relatedElementLists.getNonRepeatedAmmo().iterator();
        while (itA.hasNext()) {
            AmmoModel a = itA.next();
            if (targetModel.getAmmo().containsKey(a.getId())) {
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
                logMessage.append("-- ").append(a.print()).append(newLine);
            } else if (selectedItem instanceof WeaponModel) {
                WeaponModel w = (WeaponModel) selectedItem;
                weapons.remove(w.getId());
                logMessage.append("-- ").append(w.print()).append(newLine);
            } else if (selectedItem instanceof VehicleModel) {
                VehicleModel v = (VehicleModel) selectedItem;
                vehicles.remove(v.getId());
                logMessage.append("-- ").append(v.print()).append(newLine);
            }
        }
        LOG.log(Level.INFO, logMessage.toString());
        return true;
    }

    public boolean remove(RelatedElementLists relatedElementLists) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder("Removing elements:" + newLine);

        relatedElementLists.getAllVehicles().stream().forEach(v -> {
            logMessage.append("-- ").append(v.print()).append(newLine);
            vehicles.remove(v.getId());
        });
        relatedElementLists.getAllWeapons().stream().forEach(w -> {
            logMessage.append("-- ").append(w.print()).append(newLine);
            weapons.remove(w.getId());
        });
        relatedElementLists.getAllAmmo().stream().forEach(a -> {
            logMessage.append("-- ").append(a.print()).append(newLine);
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
                v.setFlag(Flag.COPY);
                vehicles.put(v.getId(), v);
                logMessage.append("-- ").append(v.print()).append(newLine);
            }
            for (WeaponModel w : relatedElementLists.getAllWeapons()) {
                w.setFlag(Flag.COPY);
                weapons.put(w.getId(), w);
                logMessage.append("-- ").append(w.print()).append(newLine);
            }
            for (AmmoModel a : relatedElementLists.getAllAmmo()) {
                a.setFlag(Flag.COPY);
                ammos.put(a.getId(), a);
                logMessage.append("-- ").append(a.print()).append(newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else if (answer.equals(DialogAction.SKIP_REPEATED)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Skipping repeated): " + newLine);

            for (VehicleModel v : relatedElementLists.getNonRepeatedVehicles()) {
                v.setFlag(Flag.COPY);
                vehicles.put(v.getId(), v);
                logMessage.append("-- ").append(v.print()).append(newLine);
            }
            for (WeaponModel w : relatedElementLists.getNonRepeatedWeapons()) {
                w.setFlag(Flag.COPY);
                weapons.put(w.getId(), w);
                logMessage.append("-- ").append(w.print()).append(newLine);
            }
            for (AmmoModel a : relatedElementLists.getNonRepeatedAmmo()) {
                a.setFlag(Flag.COPY);
                ammos.put(a.getId(), a);
                logMessage.append("-- ").append(a.print()).append(newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else if (answer.equals(DialogAction.COPY_SELECTION)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Selected only): " + newLine);
            for (Object selectedItem : selectedItems) {
                if (selectedItem instanceof AmmoModel) {
                    AmmoModel a = (AmmoModel) selectedItem;
                    a.setFlag(Flag.COPY);
                    ammos.put(a.getId(), a);
                    logMessage.append("-- ").append(a.print()).append(newLine);
                } else if (selectedItem instanceof WeaponModel) {
                    WeaponModel w = (WeaponModel) selectedItem;
                    w.setFlag(Flag.COPY);
                    weapons.put(w.getId(), w);
                    logMessage.append("-- ").append(w.print()).append(newLine);
                } else if (selectedItem instanceof VehicleModel) {
                    VehicleModel v = (VehicleModel) selectedItem;
                    v.setFlag(Flag.COPY);
                    vehicles.put(v.getId(), v);
                    logMessage.append("-- ").append(v.print()).append(newLine);
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
        // lambdas are beautiful
        images.values().stream().map(ImageModel::getPojo).forEach(data.getImage()::add);
        vehicles.values().stream().map(VehicleModel::getPojo).forEach(data.getVehicle()::add);
        weapons.values().stream().map(WeaponModel::getPojo).forEach(data.getWeapon()::add);
        ammos.values().stream().map(AmmoModel::getPojo).forEach(data.getAmmo()::add);
        formationEffects.values().stream().map(FormationEffectsModel::getPojo).forEach(data.getFormationEffects()::add);
        FileIO.saveEstab(data, file);
    }

}
