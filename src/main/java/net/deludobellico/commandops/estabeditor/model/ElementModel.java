package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.*;

import java.util.*;

/**
 * Wrapper for all JAXB important POJOs (Forces, Nations, Vehicles, Weapons, Ammo, etc.)
 * <p>Model classes should override their {@code equals} and {@code hashcode}.
 * Even if IDs are unique, sometimes in-depth comparison is needed.
 *
 * @author Mario
 * @author Heine
 */
public interface ElementModel<T> {

    /**
     * Map to convert from pojo classes to model classes and vice versa (Vehicle -> VehicleModel, WeaponModel -> Weapon...)
     */
    // Needless to say it's important both arrays have the same order and the same length
    public static final Class[] ELEMENT_MODEL_CLASSES = {VehicleModel.class, WeaponModel.class, AmmoModel.class};
    public static final Class[] ELEMENT_POJO_CLASSES = {Vehicle.class, Weapon.class, Ammo.class};
    public static final Class[] ELEMENT_MODEL_CLASSES_NOT_IMPLEMENTED = {ImageModel.class, SideModel.class, FormationEffectsModel.class};
    public static final Class[] ELEMENT_POJO_CLASSES_NOT_IMPLEMENTED = {Image.class, Side.class, FormationEffects.class};
    public static final Map<Class, Class> CLASS_MAP = Collections.unmodifiableMap(new HashMap<Class, Class>(ELEMENT_MODEL_CLASSES.length) {{
        for (int i = 0; i < ELEMENT_MODEL_CLASSES.length; i++) {
            put(ELEMENT_MODEL_CLASSES[i], ELEMENT_POJO_CLASSES[i]);
            put(ELEMENT_POJO_CLASSES[i], ELEMENT_MODEL_CLASSES[i]);
        }
        // --
        for (int i = 0; i < ELEMENT_MODEL_CLASSES_NOT_IMPLEMENTED.length; i++) {
            put(ELEMENT_MODEL_CLASSES_NOT_IMPLEMENTED[i], ELEMENT_POJO_CLASSES_NOT_IMPLEMENTED[i]);
            put(ELEMENT_POJO_CLASSES_NOT_IMPLEMENTED[i], ELEMENT_MODEL_CLASSES_NOT_IMPLEMENTED[i]);

        }
    }});

    int getId();

    void setId(int i);

    String getName();

    void setName(String name);

    StringProperty nameProperty();

    IntegerProperty idProperty();

    /**
     * Puts a hard copy in a map with a new Id
     *
     * @param newId new element id
     * @param map   target map
     */
    void cloneToMap(int newId, Map<Integer, T> map);

    /**
     * Puts a hard copy in a the map
     *
     * @param map target map
     */
    void copyToMap(Map<Integer, T> map);

    /**
     * Puts a shallow copy in the map
     *
     * @param map target map
     */
    void insertInToMap(Map<Integer, T> map);

    /**
     * Puts a shallow copy in the collection
     *
     * @param collection target collection
     */
    void insertInToCollection(Collection<T> collection);

    /**
     * Puts a new element in the map
     *
     * @param map target map
     * @return the newly created element
     * @see ElementModelFactory
     */
    T createNewInMap(Map<Integer, T> map);

    /**
     * Removes this element from the map
     * @param map target map
     */
    void removeFromMap(Map<Integer, T> map);

    /**
     * Equivalent to a set. Flags are true if they are included in the list, false otherwise.
     *
     * @return flag list
     */
    List<Flag> getFlags();

    /**
     * Set flags to true (i.e. add flags to the list), ignores repeated flags
     *
     * @param f flag array to set
     */
    default void setFlag(Flag... f) {
        if (f == null) return;
        for (Flag aF : f) {
            if (!getFlags().contains(aF)) {
                getFlags().add(aF);
            }
        }
    }

    /**
     * Sets flags to false (i.e. remove flags from the list), ignores repeated flags
     *
     * @param f flag array to unset
     */
    default void unsetFlag(Flag... f) {
        if (f == null) return;
        for (Flag aF : f) {
            if (getFlags().contains(aF)) {
                getFlags().remove(aF);
            }
        }
    }

    /**
     * Flips flags state, like doing {@code xor true}
     *
     * @param f flag array to switch
     */
    default void switchFlag(Flag... f) {
        if (f == null) return;
        for (Flag aF : f) {
            if (!getFlags().contains(aF)) {
                getFlags().add(aF);
            } else {
                getFlags().remove(aF);
            }
        }
    }

    default String print() {
        return String.format(" %s | ID: %d | Name: %s",
                CLASS_MAP.get(getClass()).getSimpleName(),
                getId(), getName());
    }
}
