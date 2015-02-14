package net.deludobellico.commandops.estabeditor.model;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import net.deludobellico.commandops.estabeditor.data.jaxb.EstabData;
import net.deludobellico.commandops.estabeditor.util.FileIO;

import java.io.File;
import java.util.*;
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
    public static final Integer DEFAULT_VERSION = 4;
    public static final String DLB_VERSION = "0.1.2";
    private final Map<Class, Map<Integer, ? extends ElementModel>> allElements;

    private Integer version;
    private String dlbVersion;
    private Boolean edited;
    private GregorianCalendar lastEdit;

    /**
     * Empty model instance
     */
    public EstabModel() {
        this.version = DEFAULT_VERSION;
        this.dlbVersion = DLB_VERSION;
        this.edited = true;
        this.lastEdit = new GregorianCalendar();
        allElements = new HashMap<>();
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

        this.version = estabData.getVersion();
        this.dlbVersion = estabData.getDlbVersion() != null ? estabData.getDlbVersion() : DLB_VERSION;
        this.edited = estabData.isEdited();
        this.lastEdit = (estabData.getLastEdit() != null ? estabData.getLastEdit().toGregorianCalendar() : null);

        // Collect the Estab element lists
        Collection<List<? extends Element>> estabLists = new ArrayList<>();
        estabLists.add(estabData.getImage());
        estabLists.add(estabData.getSide());
        estabLists.add(estabData.getVehicle());
        estabLists.add(estabData.getWeapon());
        estabLists.add(estabData.getAmmo());
        estabLists.add(estabData.getFormationEffects());

        // Create all the element maps
        allElements = new HashMap<>();
        allElements.put(ImageModel.class, new HashMap<>(estabData.getImage().size()));
        allElements.put(SideModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(ForceModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(VehicleModel.class, new HashMap<>(estabData.getVehicle().size()));
        allElements.put(WeaponModel.class, new HashMap<>(estabData.getWeapon().size()));
        allElements.put(AmmoModel.class, new HashMap<>(estabData.getAmmo().size()));
        allElements.put(FormationEffectsModel.class, new HashMap<>(estabData.getFormationEffects().size()));


        // Wrap all the elements to their element model and saves them to their corresponding map
        final int[] maxId = {0};
        for (List<? extends Element> elements : estabLists)
            elements.stream().map(Element::getModel).forEach(e -> {
                ElementModel em = (ElementModel) e;
                if (em.getId() > maxId[0]) maxId[0] = em.getId();
                em.shallowCopyToMap(allElements.get(em.getClass()));
            });
        ElementModelFactory.setMaxId(maxId[0]);

//        // These expensive loops are done in order to have all forces in a separate map
//        Map<Integer, SideModel> sideModelMap = (Map<Integer, SideModel>) allElements.get(SideModel.class);
//        Map<Integer, ForceModel> forceModelMap = (Map<Integer, ForceModel>) allElements.get(ForceModel.class);
//
//        for (SideModel side : sideModelMap.values())
//            for (NationModel nation : side.getNation())
//                for (ServiceModel service : nation.getService())
//                    for (ForceModel force : service.getForce()) forceModelMap.put(force.getId(), force);
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
     * Loops through all map values looking for names that match our query.
     *
     * @param query             text to search
     * @param elementModelClass used to load the corresponding map
     * @return collection with all matching elements
     */
    public List<ElementModel> searchElement(String query, Class elementModelClass) {
        List<ElementModel> elements = new ArrayList<>();
        if (elementModelClass == ForceModel.class) {
            Map<Integer, SideModel> sideModelMap = (Map<Integer, SideModel>) allElements.get(SideModel.class);
            for (SideModel side : sideModelMap.values()) {
                for (NationModel nation : side.getNation())
                    for (ServiceModel service : nation.getService())
                        for (ForceModel force : service.getForce())
                            if (force.getName().toLowerCase().contains(query.toLowerCase())) elements.add(force);
            }
        } else elements = allElements.get(elementModelClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList<ElementModel>::new));
        return elements;
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

    public RelatedElementsLists getRelatedElements(ElementModel elementModel) {
        return getRelatedElements(Arrays.asList(elementModel));
    }


    /**
     * Remove elements from the model
     *
     * @param elements collection of elements to remove
     */
    public void remove(Collection<ElementModel> elements) {
        for (ElementModel element : elements)
            element.removeFromMap(allElements.get(element.getClass()));
    }

    /**
     * Pastes elements into the model
     *
     * @param elements collection of elements to paste
     */
    public void paste(Collection<ElementModel> elements) {

        for (ElementModel element : elements) {
            element.hardCopyToMap(allElements.get(element.getClass()));
        }
    }

    /**
     * Duplicates elements into the model
     *
     * @param elements collection of elements to duplicate
     */
    @SuppressWarnings("unchecked")
    public void duplicate(Collection<ElementModel> elements) {
        for (ElementModel selectedItem : elements)
            selectedItem.cloneToMap(ElementModelFactory.incrementMaxId(), allElements.get(selectedItem.getClass()));
    }

    /**
     * Save the estab model to disk
     *
     * @param file file where the estab will be saved to
     */
    public void saveToFile(File file) {
        EstabData data = new EstabData();
        data.setLastEdit(new XMLGregorianCalendarImpl(new GregorianCalendar()));
        data.setEdited(true);
        data.setVersion(version);
        data.setDlbVersion(dlbVersion);

        // TODO: poly this?
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

        FileIO.saveEstab(data, file);
    }

}
