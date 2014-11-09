package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.EstabData;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.Stopwatch;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;

import java.io.File;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Manages all elements in the Estab using a map for each class implementing {@code Element Model}.
 *
 * @author Mario
 * @author Heine
 * @see ElementModel
 */
@SuppressWarnings("unchecked")
public class EstabModel {
    private static final Logger LOG = Logger.getLogger(EstabModel.class.getName());
    private final Map<Class, Map<Integer, ? extends ElementModel>> allElements;

    /**
     * Empty model instance
     */
    public EstabModel() {
        allElements = new HashMap<>(ElementModel.CLASS_MAP.size() / 2);
        allElements.put(ImageModel.class, new HashMap<>());
        allElements.put(SideModel.class, new HashMap<>());
        allElements.put(VehicleModel.class, new HashMap<>());
        allElements.put(WeaponModel.class, new HashMap<>());
        allElements.put(AmmoModel.class, new HashMap<>());
        allElements.put(FormationEffectsModel.class, new HashMap<>());
    }

    /**
     * Loads the model from a estab file
     *
     * @param estabFile estab file with the {@code EstabData}
     * @see EstabData
     */
    public EstabModel(File estabFile) {
        this((EstabData) FileIO.loadEstab(estabFile));
    }

    /**
     * Loads the model from a {@code EstabData} instance
     *
     * @param estabData estab data
     * @see EstabData
     */
    public EstabModel(EstabData estabData) {

        // Collect the Estab element lists
        Collection<List<? extends Element>> estabLists = new ArrayList<>(ElementModel.CLASS_MAP.size() / 2);
        estabLists.add(estabData.getImage());
        estabLists.add(estabData.getSide());
        estabLists.add(estabData.getVehicle());
        estabLists.add(estabData.getWeapon());
        estabLists.add(estabData.getAmmo());
        estabLists.add(estabData.getFormationEffects());

        // Create all the element maps
        allElements = new HashMap<>(ElementModel.CLASS_MAP.size() / 2);
        allElements.put(ImageModel.class, new HashMap<>(estabData.getImage().size()));
        allElements.put(SideModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(VehicleModel.class, new HashMap<>(estabData.getVehicle().size()));
        allElements.put(WeaponModel.class, new HashMap<>(estabData.getWeapon().size()));
        allElements.put(AmmoModel.class, new HashMap<>(estabData.getAmmo().size()));
        allElements.put(FormationEffectsModel.class, new HashMap<>(estabData.getFormationEffects().size()));

        // Wrap all the elements to their element model and saves them to their corresponding map
        for (List<? extends Element> elements : estabLists)
            elements.stream().map(Element::getModel).forEach(e -> ((ElementModel) e).insertInToMap(allElements.get(e.getClass())));
    }

    public Map<Integer, ImageModel> getImages() {
        return (Map<Integer, ImageModel>) allElements.get(ImageModel.class);
    }

    public Map<Integer, SideModel> getSides() {
        return (Map<Integer, SideModel>) allElements.get(SideModel.class);
    }

    public Map<Integer, VehicleModel> getVehicles() {
        return (Map<Integer, VehicleModel>) allElements.get(VehicleModel.class);
    }

    public Map<Integer, WeaponModel> getWeapons() {
        return (Map<Integer, WeaponModel>) allElements.get(WeaponModel.class);
    }

    public Map<Integer, AmmoModel> getAmmo() {
        return (Map<Integer, AmmoModel>) allElements.get(AmmoModel.class);
    }

    public Map<Class, Map<Integer, ? extends ElementModel>> getAll() {
        return allElements;
    }

    /**
     * Loops though all map values looking for elements names that match our search text.
     *
     * @param name              text to search
     * @param elementModelClass used to load the corresponding map
     * @return collection with all matching elements
     */
    public List<ElementModel> searchElement(String name, Class elementModelClass) {
        return allElements.get(elementModelClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList<ElementModel>::new));
    }

    /**
     * Gets all weapons used by a vehicle
     *
     * @param vehicle VehicleModel to search
     * @return collection with all the weapons
     */
    private List<WeaponModel> getWeaponListFromVehicle(VehicleModel vehicle) {
        // Weapons are stored in vehicle armaments
        List<WeaponModel> weaponList = new ArrayList<>(vehicle.getArmaments().size());
        for (ArmamentModel armament : vehicle.getArmaments()) {
            WeaponModel weapon = getWeapons().get(armament.getEquipmentObjectId());
            if (weapon != null) weaponList.add(weapon);
        }
        return weaponList;
    }

    /**
     * Gets all ammo used by a weapon
     *
     * @param weapon WeaponModel to search
     * @return collection with all the ammo
     */
    private List<AmmoModel> getAmmoListFromWeapon(WeaponModel weapon) {
        // Ammo are stored in weapon performances

        List<AmmoModel> ammoList = new ArrayList<>(weapon.getPerformances().size());
        for (PerformanceModel performance : weapon.getPerformances()) {
            AmmoModel ammo = getAmmo().get(performance.getAmmoLoad().getId());
            if (ammo != null) ammoList.add(ammo);
        }
        return ammoList;
    }

    public RelatedElementsLists getRelatedElements(ElementModel elementModel) {
        List<ElementModel> singleElement = new ArrayList<>();
        singleElement.add(elementModel);
        return getRelatedElements(singleElement);
    }

    /**
     * Searches for all the related elements in the elements maps. For example, all weapons used by a vehicle,
     * or all ammo used by a collection of weapons.
     * <p>
     * This is a recursive search, meaning a vehicle will return both its weapons and ammo.
     * It's presupposed that an element is related to itself, so it'll be included in the returned collection.
     *
     * @param elements collection of elements to look for related items
     * @return {@link RelatedElementsLists} containing all the related elements in this model
     * @see RelatedElementsLists#findRepeatedElementsInTargetModel
     */
    public RelatedElementsLists getRelatedElements(Collection<ElementModel> elements) {

        RelatedElementsLists relatedElementsLists = new RelatedElementsLists();
        for (ElementModel elementModel : elements)
            elementModel.insertInToCollection(relatedElementsLists.getAll(elementModel.getClass()));

        for (ElementModel v : relatedElementsLists.getAll(VehicleModel.class)) {
            List<WeaponModel> weapons = getWeaponListFromVehicle((VehicleModel) v);
            relatedElementsLists.getAll(WeaponModel.class).addAll(weapons);
        }

        for (ElementModel w : relatedElementsLists.getAll(WeaponModel.class)) {
            List<AmmoModel> ammo = getAmmoListFromWeapon((WeaponModel) w);
            relatedElementsLists.getAll(AmmoModel.class).addAll(ammo);
        }

        return relatedElementsLists;
    }

    /**
     * Remove elements from
     *
     * @param elements
     * @return
     */
    public boolean remove(Collection<ElementModel> elements) {
        for (ElementModel selectedItem : elements)
            selectedItem.removeFromMap(allElements.get(selectedItem.getClass()));
        return true;
    }

    public boolean paste(RelatedElementsLists relatedElementsLists, DialogAction answer, Collection<ElementModel> selectedItems) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder();
        if (answer.equals(DialogAction.OVERWRITE)) {
            logMessage = new StringBuilder("Copying all elements (Overwriting repeated): " + newLine);
            for (ElementModel elementModel : relatedElementsLists.getAllElements()) {
                logMessage.append("-- ").append(elementModel.print()).append(newLine);
                elementModel.setFlag(Flag.COPY);
                elementModel.insertInToMap(allElements.get(elementModel.getClass()));
            }
        } else if (answer.equals(DialogAction.SKIP_REPEATED)) {
            assert relatedElementsLists.isDistributed();
            logMessage = new StringBuilder("Copying elements (Skipping repeated): " + newLine);
            for (ElementModel elementModel : relatedElementsLists.getNonRepeatedElements()) {
                logMessage.append("-- ").append(elementModel.print()).append(newLine);
                elementModel.setFlag(Flag.COPY);
                elementModel.insertInToMap(allElements.get(elementModel.getClass()));
            }
        } else if (answer.equals(DialogAction.COPY_SELECTION)) {
            logMessage = new StringBuilder("Copying elements (Selected only): " + newLine);
            for (ElementModel selectedItem : selectedItems) {
                logMessage.append("-- ").append(selectedItem.print()).append(newLine);
                selectedItem.setFlag(Flag.COPY);
                selectedItem.copyToMap(allElements.get(selectedItem.getClass()));
            }
        } else {
            LOG.log(Level.INFO, "Copy canceled");
            return false;
        }
        LOG.log(Level.INFO, logMessage.toString());
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
        Stopwatch s = new Stopwatch();
        s.start();
        // TODO: poly this
        Map<Integer, ImageModel> images = (Map<Integer, ImageModel>) allElements.get(ImageModel.class);
        Map<Integer, VehicleModel> vehicles = (Map<Integer, VehicleModel>) allElements.get(VehicleModel.class);
        Map<Integer, WeaponModel> weapons = (Map<Integer, WeaponModel>) allElements.get(WeaponModel.class);
        Map<Integer, AmmoModel> ammos = (Map<Integer, AmmoModel>) allElements.get(AmmoModel.class);
        Map<Integer, FormationEffectsModel> formationEffects = (Map<Integer, FormationEffectsModel>) allElements.get(FormationEffectsModel.class);
        images.values().stream().map(ImageModel::getPojo).forEach(data.getImage()::add);
        vehicles.values().stream().map(VehicleModel::getPojo).forEach(data.getVehicle()::add);
        weapons.values().stream().map(WeaponModel::getPojo).forEach(data.getWeapon()::add);
        ammos.values().stream().map(AmmoModel::getPojo).forEach(data.getAmmo()::add);
        formationEffects.values().stream().map(FormationEffectsModel::getPojo).forEach(data.getFormationEffects()::add);
        s.stop();
        System.out.println("Saved: " + s.getTotalTime());
        FileIO.saveEstab(data, file);
    }

}
