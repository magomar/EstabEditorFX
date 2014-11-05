/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.Ammo;
import net.deludobellico.commandops.estabeditor.data.jaxb.Vehicle;
import net.deludobellico.commandops.estabeditor.data.jaxb.Weapon;
import net.deludobellico.commandops.estabeditor.data.jaxb.YesNo;

/**
 * @author Mario
 */
public interface PojoJFXModel<T> {
    public static ElementModel wrapper(Object o) {
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

    public static YesNo booleanToYesNo(boolean cond) {
        return cond ? YesNo.YES : YesNo.NO;
    }

    public static boolean yesNoToBoolean(YesNo cond) {
        return cond.equals(YesNo.YES);
    }

    T getPojo();

    void setPojo(T pojo);
}
