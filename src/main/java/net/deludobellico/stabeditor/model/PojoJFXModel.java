/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.deludobellico.stabeditor.model;

import net.deludobellico.stabeditor.data.jaxb.Ammo;
import net.deludobellico.stabeditor.data.jaxb.Vehicle;
import net.deludobellico.stabeditor.data.jaxb.Weapon;

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

    T getPojo();

    void setPojo(T pojo);
}
