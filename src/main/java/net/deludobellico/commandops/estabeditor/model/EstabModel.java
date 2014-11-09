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
 * Manages all elements in the Estab.
 *
 * @author Mario
 * @author Heine
 */
public class EstabModel {
    private static final Logger LOG = Logger.getLogger(EstabModel.class.getName());
    private final Map<Class, Map<Integer, ? extends ElementModel>> allElements;

    public EstabModel(File estabFile) {
        this((EstabData) FileIO.loadEstab(estabFile));
    }

    public EstabModel(EstabData estabData) {
        Collection<List<? extends Element>> estabLists = new ArrayList<>();
        estabLists.add(estabData.getImage());
        estabLists.add(estabData.getSide());
        estabLists.add(estabData.getVehicle());
        estabLists.add(estabData.getWeapon());
        estabLists.add(estabData.getAmmo());
        estabLists.add(estabData.getFormationEffects());

        allElements = new HashMap<>(ElementModel.CLASS_MAP.size()/2);
        allElements.put(ImageModel.class, new HashMap<>(estabData.getImage().size()));
        allElements.put(SideModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(VehicleModel.class, new HashMap<>(estabData.getVehicle().size()));
        allElements.put(WeaponModel.class, new HashMap<>(estabData.getWeapon().size()));
        allElements.put(AmmoModel.class, new HashMap<>(estabData.getAmmo().size()));
        allElements.put(FormationEffectsModel.class, new HashMap<>(estabData.getFormationEffects().size()));

        for (List<? extends Element> elements : estabLists)
            elements.stream().map(Element::getModel).forEach(e -> ((ElementModel) e).insertInToMap(allElements.get(e.getClass())));
    }

    public EstabModel() {
        allElements = new HashMap<>(ElementModel.CLASS_MAP.size()/2);
        allElements.put(ImageModel.class, new HashMap<>());
        allElements.put(SideModel.class, new HashMap<>());
        allElements.put(VehicleModel.class, new HashMap<>());
        allElements.put(WeaponModel.class, new HashMap<>());
        allElements.put(AmmoModel.class, new HashMap<>());
        allElements.put(FormationEffectsModel.class, new HashMap<>());
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

    public List<ElementModel> searchElement(String name, Class elementModelClass) {
        return allElements.get(elementModelClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.<ElementModel>toList());
    }

    private List<WeaponModel> getWeaponListFromVehicle(VehicleModel vehicle) {
        List<WeaponModel> weaponList = new ArrayList<>(vehicle.getArmaments().size());
        for (ArmamentModel armament : vehicle.getArmaments()) {
            WeaponModel weapon = getWeapons().get(armament.getEquipmentObjectId());
            if (weapon != null) weaponList.add(weapon);
        }
        return weaponList;
    }

    private List<AmmoModel> getAmmoListFromWeapon(WeaponModel weapon) {
        List<AmmoModel> ammoList = new ArrayList<>(weapon.getPerformances().size());

        for (PerformanceModel performance : weapon.getPerformances()) {
            AmmoModel ammo = getAmmo().get(performance.getAmmoLoad().getId());
            if (ammo != null) {
                ammoList.add(ammo);
            }
        }
        return ammoList;
    }

    /**
     * Searches for all the related elements. For example, all weapons used by a vehicle,
     * or all ammo used by a collection of weapons.
     * <p>
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
        assert !relatedElementLists.isSorted();
        for (Class modelClass : ElementModel.ELEMENT_MODEL_CLASSES) {
            for (ElementModel e : relatedElementLists.getAll(modelClass)) {
                if (targetModel.getAll().get(modelClass).containsKey(e.getId()))
                    relatedElementLists.getRepeated(modelClass).add(e);
                else relatedElementLists.getNonRepeated(modelClass).add(e);
            }
        }
        relatedElementLists.setSorted(true);
    }

    public boolean remove(Collection<ElementModel> selectedItems) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder("Removing elements (Selected only): " + newLine);
        for (ElementModel selectedItem : selectedItems) {
            logMessage.append("-- ").append(selectedItem.print()).append(newLine);
            selectedItem.removeFromMap(allElements.get(selectedItem.getClass()));
        }
        LOG.log(Level.INFO, logMessage.toString());
        return true;
    }

    public boolean remove(RelatedElementLists relatedElementLists) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder("Removing elements:" + newLine);

        for (ElementModel elementModel : relatedElementLists.getAllElements()) {
            logMessage.append("-- ").append(elementModel.print()).append(newLine);
            elementModel.removeFromMap(allElements.get(elementModel.getClass()));
        }
        LOG.log(Level.INFO, logMessage.toString());
        return true;

    }

    public boolean paste(RelatedElementLists relatedElementLists, DialogAction answer, Collection<ElementModel> selectedItems) {

        String newLine = System.getProperty("line.separator");
        StringBuilder logMessage = new StringBuilder();
        if (answer.equals(DialogAction.OVERWRITE)) {
             logMessage = new StringBuilder("Copying all elements (Overwriting repeated): " + newLine);
            for (ElementModel elementModel : relatedElementLists.getAllElements()) {
                logMessage.append("-- ").append(elementModel.print()).append(newLine);
                elementModel.setFlag(Flag.COPY);
                elementModel.insertInToMap(allElements.get(elementModel.getClass()));
            }
        } else if (answer.equals(DialogAction.SKIP_REPEATED)) {
            assert relatedElementLists.isSorted();
            logMessage = new StringBuilder("Copying elements (Skipping repeated): " + newLine);
            for (ElementModel elementModel : relatedElementLists.getNonRepeatedElements()) {
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
