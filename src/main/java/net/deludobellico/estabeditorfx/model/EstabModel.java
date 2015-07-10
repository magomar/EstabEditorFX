package net.deludobellico.estabeditorfx.model;

import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import net.deludobellico.estabeditorfx.data.jaxb.*;
import net.deludobellico.estabeditorfx.model.provider.ModelProvider;
import net.deludobellico.estabeditorfx.model.provider.ModelProviderFactory;
import net.deludobellico.estabeditorfx.util.FileIO;

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
    public static final String DLB_VERSION = "1.2";
    // TODO: use set<element> (sort by id) instead of map<int, element>
    private final Map<Class, Map<Integer, ? extends ElementModel>> allElements;
    private IntegerProperty numForces = new SimpleIntegerProperty(0);
    private IntegerProperty numVehicles = new SimpleIntegerProperty(0);
    private IntegerProperty numWeapons = new SimpleIntegerProperty(0);
    private IntegerProperty numAmmos = new SimpleIntegerProperty(0);
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
        Collection<List<? extends ModelProvider>> estabLists = new ArrayList<>();
        estabLists.add(ModelProviderFactory.getProviders(estabData.getImage(), Image.class));
        estabLists.add(ModelProviderFactory.getProviders(estabData.getSide(), Side.class));
        estabLists.add(ModelProviderFactory.getProviders(estabData.getVehicle(), Vehicle.class));
        estabLists.add(ModelProviderFactory.getProviders(estabData.getWeapon(), Weapon.class));
        estabLists.add(ModelProviderFactory.getProviders(estabData.getAmmo(), Ammo.class));
        estabLists.add(ModelProviderFactory.getProviders(estabData.getFormationEffects(), FormationEffects.class));

        // Create all the element maps
        allElements = new HashMap<>();
        allElements.put(ImageModel.class, new HashMap<>(estabData.getImage().size()));
        allElements.put(SideModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(NationModel.class, new HashMap<>());
        allElements.put(ServiceModel.class, new HashMap<>());
        allElements.put(ForceModel.class, new HashMap<>(estabData.getSide().size()));
        allElements.put(VehicleModel.class, new HashMap<>(estabData.getVehicle().size()));
        allElements.put(WeaponModel.class, new HashMap<>(estabData.getWeapon().size()));
        allElements.put(AmmoModel.class, new HashMap<>(estabData.getAmmo().size()));
        allElements.put(FormationEffectsModel.class, new HashMap<>(estabData.getFormationEffects().size()));

        // Wrap all the elements to their models and save them to their corresponding map
        final int[] maxId = {0};
        for (List<? extends ModelProvider> elements : estabLists)
            elements.stream().map(ModelProvider::getModel).forEach(element -> {
                int id = element.getId();
                if (id > maxId[0]) maxId[0] = id;
                element.shallowCopyToMap(allElements.get(element.getClass()));
            });

        Map<Integer, SideModel> sides = (Map<Integer, SideModel>) allElements.get(SideModel.class);
        Map<Integer, NationModel> nations = (Map<Integer, NationModel>) allElements.get(NationModel.class);
        Map<Integer, ServiceModel> services = (Map<Integer, ServiceModel>) allElements.get(ServiceModel.class);
        Map<Integer, ForceModel> forces = (Map<Integer, ForceModel>) allElements.get(ForceModel.class);

        for (SideModel side : sides.values()) {
            // sides are already included
            for (NationModel nation : side.getNation()) {
                nations.put(nation.getId(), nation);
                if (nation.getId() > maxId[0]) maxId[0] = nation.getId();

                for (ServiceModel service : nation.getService()) {
                    services.put(service.getId(), service);
                    if (service.getId() > maxId[0]) maxId[0] = service.getId();

                    for (ForceModel force : service.getForce()) {
                        if (force.getId() > maxId[0]) maxId[0] = force.getId();
                        forces.put(force.getId(), force);
                    }
                }
            }
        }
        ElementModelFactory.setMaxId(maxId[0]);

        // Link all references to its referred elements
        getWeapons().values().stream().forEach(weapon -> weapon.getPerformances().stream().forEach(performance -> performance.getAmmoLoad().link(this)));
        getVehicles().values().stream().forEach(vehicle -> vehicle.getArmaments().forEach(armament -> armament.link(this)));
        getForces().values().stream().forEach(force -> {
            force.getEquipmentList().forEach(equipmentQty -> equipmentQty.link(this));
            force.getForceComposition().forEach(forceQty -> forceQty.link(this));
        });

        // save number of elements of each class in a property
        numForces.set(getForces().size());
        numVehicles.set(getVehicles().size());
        numWeapons.set(getWeapons().size());
        numAmmos.set(getAmmos().size());
    }

    public Map<Integer, ImageModel> getImages() {
        return (Map<Integer, ImageModel>) allElements.get(ImageModel.class);
    }

    public Map<Integer, SideModel> getSides() {
        return (Map<Integer, SideModel>) allElements.get(SideModel.class);
    }

    public Map<Integer, NationModel> getNations() {
        return (Map<Integer, NationModel>) allElements.get(NationModel.class);
    }

    public Map<Integer, ServiceModel> getServices() {
        return (Map<Integer, ServiceModel>) allElements.get(ServiceModel.class);
    }

    public Map<Integer, ForceModel> getForces() {
        return (Map<Integer, ForceModel>) allElements.get(ForceModel.class);
    }

    public Map<Integer, VehicleModel> getVehicles() {
        return (Map<Integer, VehicleModel>) allElements.get(VehicleModel.class);
    }

    public Map<Integer, WeaponModel> getWeapons() {
        return (Map<Integer, WeaponModel>) allElements.get(WeaponModel.class);
    }

    public Map<Integer, AmmoModel> getAmmos() {
        return (Map<Integer, AmmoModel>) allElements.get(AmmoModel.class);
    }

    public Map<Class, Map<Integer, ? extends ElementModel>> getAll() {
        return allElements;
    }

    /**
     * Return a list of elements of the given class (@{code elementClass}) whose name contains the query
     *
     * @param query        text to search
     * @param elementClass used to load the corresponding map
     * @return collection with all matching elements
     */
    public List<ElementModel> searchElement(String query, Class<? extends ElementModel> elementClass) {
        return allElements.get(elementClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
    }


    /**
     * Return a list of elements of the given class ({@code elementClass}) whose name matches exactly the provided {@code query}.
     *
     * @param query        text to search
     * @param elementClass used to load the corresponding map
     * @return collection with all matching elements
     */
    public List<ElementModel> searchExactElement(String query, Class<? extends ElementModel> elementClass) {
        return allElements.get(elementClass).values().parallelStream()
                .filter(element -> element.getName().toLowerCase().equals(query.toLowerCase()))
                .collect(Collectors.toCollection(ArrayList::new));
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
            WeaponModel weapon = getWeapons().get(armament.getId());
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
            AmmoModel ammo = getAmmos().get(performance.getAmmoLoad().getId());
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
            if (elementModel.getClass() != SideModel.class
                    && elementModel.getClass() != NationModel.class
                    && elementModel.getClass() != ServiceModel.class)
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
        for (ElementModel element : elements) {
            if (element.getClass() == ServiceModel.class) {
                ((ServiceModel) element).getNation().getService().remove(element);
            } else if (element.getClass() == NationModel.class) {
                ((NationModel) element).getSide().getNation().remove(element);
            } else if (element.getClass() == ForceModel.class) {
                ((ForceModel) element).getService().getForce().remove(element);
            }
            element.removeFromMap(allElements.get(element.getClass()));
        }
    }

    /**
     * Pastes elements into the model
     *
     * @param elements collection of elements to paste
     */
    public void paste(Collection<ElementModel> elements) {

        for (ElementModel element : elements) {
            element.hardCopyToMap(allElements.get(element.getClass()));

            // Make sure all forces have the corresponding hierarchy
            if (element.getClass() == ForceModel.class) {

                ForceModel force = (ForceModel) element;
                ServiceModel service = force.getService();
                // Add this service to the target model if it doesn't exist
                if (!allElements.get(ServiceModel.class).containsKey(service.getId())) {
                    service.getForce().clear();
                    ((ElementModel) service).hardCopyToMap(allElements.get(ServiceModel.class));

                    NationModel nation = force.getService().getNation();
                    // Add this nation to the target model if it doesn't exist
                    if (!allElements.get(NationModel.class).containsKey(nation.getId())) {
                        nation.getService().clear();
                        ((ElementModel) nation).hardCopyToMap(allElements.get(NationModel.class));

                        SideModel side = force.getService().getNation().getSide();
                        // Add this side to the target model if it doesn't exist
                        if (!allElements.get(SideModel.class).containsKey(side.getId())) {
                            side.getNation().clear();
                            ((ElementModel) side).hardCopyToMap(allElements.get(SideModel.class));
                        }

                        // Add this nation to the target side
                        ((SideModel) allElements.get(SideModel.class).get(side.getId())).getNation().add(
                                (NationModel) allElements.get(NationModel.class).get(nation.getId()));
                        ((NationModel) allElements.get(NationModel.class).get(nation.getId())).setSide(
                                (SideModel) allElements.get(SideModel.class).get(side.getId()));

                    }

                    // Add this service to the target nation
                    ((NationModel) allElements.get(NationModel.class).get(nation.getId())).getService().add(
                            (ServiceModel) allElements.get(ServiceModel.class).get(service.getId()));
                    ((ServiceModel) allElements.get(ServiceModel.class).get(service.getId())).setNation(
                            (NationModel) allElements.get(NationModel.class).get(nation.getId()));
                }

                // Add this force to the target service
                ((ServiceModel) allElements.get(ServiceModel.class).get(service.getId())).getForce().add(
                        (ForceModel) allElements.get(ForceModel.class).get(force.getId()));
                ((ForceModel) allElements.get(ForceModel.class).get(force.getId())).setService(
                        (ServiceModel) allElements.get(ServiceModel.class).get(service.getId()));
            }
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

        Map<Integer, SideModel> sides = (Map<Integer, SideModel>) allElements.get(SideModel.class);
        Map<Integer, ImageModel> images = (Map<Integer, ImageModel>) allElements.get(ImageModel.class);
        Map<Integer, VehicleModel> vehicles = (Map<Integer, VehicleModel>) allElements.get(VehicleModel.class);
        Map<Integer, WeaponModel> weapons = (Map<Integer, WeaponModel>) allElements.get(WeaponModel.class);
        Map<Integer, AmmoModel> ammos = (Map<Integer, AmmoModel>) allElements.get(AmmoModel.class);
        Map<Integer, FormationEffectsModel> formationEffects = (Map<Integer, FormationEffectsModel>) allElements.get(FormationEffectsModel.class);

        sides.values().stream().map(SideModel::getPojo).forEach(data.getSide()::add);
        images.values().stream().map(ImageModel::getPojo).forEach(data.getImage()::add);
        vehicles.values().stream().map(VehicleModel::getPojo).forEach(data.getVehicle()::add);
        weapons.values().stream().map(WeaponModel::getPojo).forEach(data.getWeapon()::add);
        ammos.values().stream().map(AmmoModel::getPojo).forEach(data.getAmmo()::add);
        formationEffects.values().stream().map(FormationEffectsModel::getPojo).forEach(data.getFormationEffects()::add);

        FileIO.saveEstab(data, file);
    }

    public int getNumForces() {
        return numForces.get();
    }

    public IntegerProperty numForcesProperty() {
        return numForces;
    }

    public int getNumVehicles() {
        return numVehicles.get();
    }

    public IntegerProperty numVehiclesProperty() {
        return numVehicles;
    }

    public int getNumWeapons() {
        return numWeapons.get();
    }

    public IntegerProperty numWeaponsProperty() {
        return numWeapons;
    }

    public int getNumAmmos() {
        return numAmmos.get();
    }

    public IntegerProperty numAmmosProperty() {
        return numAmmos;
    }
}
