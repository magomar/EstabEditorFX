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
 * Manages all elements in the Estab.
 *
 * @author Mario
 * @author Heine
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
        ElementModelFactory.setMaxId(maxID);
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

    public Map<Class, Map<Integer, ? extends ElementModel>> getAllElements() {
        return allElements;
    }

    public List<ElementModel> searchElement(String name, Class elementModelClass) {
        return allElements.get(elementModelClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.<ElementModel>toList());
    }

    private List<WeaponModel> getWeaponListFromVehicle(VehicleModel vehicle) {
        List<WeaponModel> weaponList = new ArrayList<>(vehicle.getArmaments().size());
        for (ArmamentModel armament : vehicle.getArmaments()) {
            WeaponModel weapon = weapons.get(armament.getEquipmentObjectId());
            if (weapon != null) weaponList.add(weapon);
        }
        return weaponList;
    }

    private List<AmmoModel> getAmmoListFromWeapon(WeaponModel weapon) {
        List<AmmoModel> ammoList = new ArrayList<>(weapon.getPerformances().size());

        for (PerformanceModel performance : weapon.getPerformances()) {
            AmmoModel ammo = ammos.get(performance.getAmmoLoad().getId());
            if (ammo != null) {
                ammoList.add(ammo);
            }
        }
        return ammoList;
    }

    /**
     * Searches for all the related elements. For example, all weapons used by a vehicle,
     * or all ammo used by a collection of weapons.
     *
     * {@link #sortRelatedElements} has to be invoked in order to clean NonRepeated lists
     *
     * @param elements
     * @return all the related elements
     */
    public RelatedElementLists getRelatedElements(Collection<ElementModel> elements) {
        return getRelatedElements(elements, null);
    }

    public RelatedElementLists getRelatedElements(Collection<ElementModel> elements, EstabModel targetModel) {

        RelatedElementLists relatedElementLists = new RelatedElementLists();
        for (ElementModel elementModel : elements)
            elementModel.insertInToCollection(relatedElementLists.getAll(elementModel.getClass()));

        for (ElementModel v : relatedElementLists.getAll(VehicleModel.class)) {
            List<WeaponModel> weapons = getWeaponListFromVehicle((VehicleModel) v);
            relatedElementLists.getAll(WeaponModel.class).addAll(weapons);
        }

        for (ElementModel w : relatedElementLists.getAll(WeaponModel.class)) {
            List<AmmoModel> ammo = getAmmoListFromWeapon((WeaponModel) w);
            relatedElementLists.getAll(AmmoModel.class).addAll(ammo);
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

        for (Class modelClass : ElementModel.ELEMENT_MODEL_CLASSES) {
            for (ElementModel e : relatedElementLists.getAll(modelClass)) {
                if (targetModel.getAllElements().get(modelClass).containsKey(e.getId()))
                     relatedElementLists.getRepeated(modelClass).add(e);
                else relatedElementLists.getNonRepeated(modelClass).add(e);
            }
        }
        relatedElementLists.setSorted(true);
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

        relatedElementLists.getAll(VehicleModel.class).stream().forEach(v -> {
            logMessage.append("-- ").append(v.print()).append(newLine);
            vehicles.remove(v.getId());
        });
        relatedElementLists.getAll(WeaponModel.class).stream().forEach(w -> {
            logMessage.append("-- ").append(w.print()).append(newLine);
            weapons.remove(w.getId());
        });
        relatedElementLists.getAll(AmmoModel.class).stream().forEach(a -> {
            logMessage.append("-- ").append(a.print()).append(newLine);
            ammos.remove(a.getId());
        });

        LOG.log(Level.INFO, logMessage.toString());
        return true;

    }

    public boolean paste(RelatedElementLists relatedElementLists, DialogAction answer, Collection<ElementModel> selectedItems) {

        String newLine = System.getProperty("line.separator");
        if (answer.equals(DialogAction.OVERWRITE)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Overwriting repeated): " + newLine);

            for (ElementModel v : relatedElementLists.getAll(VehicleModel.class)) {
                v.setFlag(Flag.COPY);
                vehicles.put(v.getId(), (VehicleModel) v);
                logMessage.append("-- ").append(v.print()).append(newLine);
            }
            for (ElementModel w : relatedElementLists.getAll(WeaponModel.class)) {
                w.setFlag(Flag.COPY);
                weapons.put(w.getId(), (WeaponModel) w);
                logMessage.append("-- ").append(w.print()).append(newLine);
            }
            for (ElementModel a : relatedElementLists.getAll(AmmoModel.class)) {
                a.setFlag(Flag.COPY);
                ammos.put(a.getId(), (AmmoModel) a);
                logMessage.append("-- ").append(a.print()).append(newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else if (answer.equals(DialogAction.SKIP_REPEATED)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Skipping repeated): " + newLine);

            for (ElementModel v : relatedElementLists.getNonRepeated(VehicleModel.class)) {
                v.setFlag(Flag.COPY);
                vehicles.put(v.getId(), (VehicleModel) v);
                logMessage.append("-- ").append(v.print()).append(newLine);
            }
            for (ElementModel w : relatedElementLists.getNonRepeated(WeaponModel.class)) {
                w.setFlag(Flag.COPY);
                weapons.put(w.getId(), (WeaponModel) w);
                logMessage.append("-- ").append(w.print()).append(newLine);
            }
            for (ElementModel a : relatedElementLists.getNonRepeated(AmmoModel.class)) {
                a.setFlag(Flag.COPY);
                ammos.put(a.getId(), (AmmoModel) a);
                logMessage.append("-- ").append(a.print()).append(newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else if (answer.equals(DialogAction.COPY_SELECTION)) {
            StringBuilder logMessage = new StringBuilder("Copying elements (Selected only): " + newLine);
            for (ElementModel selectedItem : selectedItems) {
                selectedItem.copyToMap(allElements.get(selectedItem.getClass()));
                logMessage.append("-- ").append(selectedItem.print()).append(newLine);
            }
            LOG.log(Level.INFO, logMessage.toString());
        } else {
            LOG.log(Level.INFO, "Copy canceled");
            return false;
        }
        return true;
    }

    // TODO: implement hard copy
    @SuppressWarnings("unchecked")
    public void duplicate(Collection<ElementModel> selectedItems) {
        for (ElementModel selectedItem : selectedItems)
            selectedItem.cloneToMap(ElementModelFactory.incrementMaxId(), allElements.get(selectedItem.getClass()));
    }

    public void saveToFile(File file) {
        EstabData data = new EstabData();
        images.values().parallelStream().map(ImageModel::getPojo).forEach(data.getImage()::add);
        vehicles.values().parallelStream().map(VehicleModel::getPojo).forEach(data.getVehicle()::add);
        weapons.values().parallelStream().map(WeaponModel::getPojo).forEach(data.getWeapon()::add);
        ammos.values().parallelStream().map(AmmoModel::getPojo).forEach(data.getAmmo()::add);
        formationEffects.values().parallelStream().map(FormationEffectsModel::getPojo).forEach(data.getFormationEffects()::add);
        FileIO.saveEstab(data, file);
    }

}
