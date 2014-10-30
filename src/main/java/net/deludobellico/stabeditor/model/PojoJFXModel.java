/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;
import net.deludobellico.stabeditor.data.jaxb.YesNo;

/**
 *
 * @author Mario
 */
public interface PojoJFXModel<T> {
    T getPojo();
    void setPojo(T pojo);

    public static String boolToYesNo(boolean cond) {
        return cond ? YesNo.YES.value() : YesNo.NO.value();
    }

    public static boolean yesNoToBool(String cond) {
        return cond.equals(YesNo.YES);
    }

    public static AssetModel wrapper(Object o) {
        if (o != null) {
            if (o instanceof Weapon) {
                Weapon w = (Weapon) o;
                return new WeaponModel(w);
            } else if (o instanceof Vehicle) {
                Vehicle v = (Vehicle) o;
                return new VehicleModel(v);
            } else if (o instanceof Ammo) {
                Ammo a = (Ammo) o;
                return new AmmoModel(a);
            }
        }
        return null;
    }
    public static WeaponModel wrapper(Weapon weapon) {
        return new WeaponModel(weapon);
    }

    public static VehicleModel wrapper(Vehicle vehicle) {
        return new VehicleModel(vehicle);
    }

    public static AmmoModel wrapper(Ammo ammo) {
        return new AmmoModel(ammo);
    }
}
