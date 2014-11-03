package net.deludobellico.commandops.estabeditor.util;

import net.deludobellico.commandops.estabeditor.data.jaxb.Ammo;
import net.deludobellico.commandops.estabeditor.data.jaxb.Vehicle;
import net.deludobellico.commandops.estabeditor.data.jaxb.Weapon;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;
import net.deludobellico.commandops.estabeditor.model.VehicleModel;
import net.deludobellico.commandops.estabeditor.model.WeaponModel;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mario on 04/08/2014.
 */
public class Util {
    // Needless to say it's important both arrays have the same order and the same length
    public static final Class[] ELEMENT_MODEL_CLASSES = {VehicleModel.class, WeaponModel.class, AmmoModel.class};
    public static final Class[] ELEMENT_POJO_CLASSES = {Vehicle.class, Weapon.class, Ammo.class};
    public static final Map<Class, Class> CLASS_MAP_MODEL_TO_POJO = Collections.unmodifiableMap(new HashMap<Class, Class>(ELEMENT_MODEL_CLASSES.length) {{
        for (int i = 0; i < ELEMENT_MODEL_CLASSES.length; i++) put(ELEMENT_MODEL_CLASSES[i], ELEMENT_POJO_CLASSES[i]);
    }});
    public static final Map<Class, Class> CLASS_MAP_POJO_TO_MODEL = Collections.unmodifiableMap(new HashMap<Class, Class>(ELEMENT_MODEL_CLASSES.length) {{
        for (int i = 0; i < ELEMENT_MODEL_CLASSES.length; i++) put(ELEMENT_POJO_CLASSES[i], ELEMENT_MODEL_CLASSES[i]);
    }});


    /**
     * Check if provided string is an Integer
     *
     * @param s the string to check
     * @return whether {@code} s is an Integer or not
     */
    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
}
