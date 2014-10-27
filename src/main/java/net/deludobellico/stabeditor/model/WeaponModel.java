package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.FireType;
import net.deludobellico.stabeditor.data.jaxb.Performance;
import net.deludobellico.stabeditor.data.jaxb.Weapon;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heine on 10/27/2014.
 */


public class WeaponModel {
    private Weapon weapon;
    private Map<FireType, Boolean> fireTypeMap;

    public WeaponModel(Weapon weapon) {
        this.weapon = weapon;
        fireTypeMap = new HashMap<>();
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public boolean hasFireType(FireType fireType) {
        return fireTypeMap.get(fireType);
    }

    public static Map<FireType, Boolean> getFireTypeMap(Weapon weapon) {
        Map<FireType, Boolean> fireTypeMap = new HashMap<>();
        if (fireTypeMap.isEmpty()) {
            for (FireType f : FireType.values()) {
                fireTypeMap.put(f, false);
            }
            for (Performance p : weapon.getPerformanceList().getPerformance()) {
                fireTypeMap.put(p.getFireType(), true);
            }
        }
        return fireTypeMap;
    }
}
