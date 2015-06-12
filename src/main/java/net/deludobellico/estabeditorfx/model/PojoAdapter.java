/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.YesNo;
import net.deludobellico.estabeditorfx.data.jaxb.YesNo;

/**
 * Interface for all the jaxb package classes
 *
 * @author Mario
 * @author Heine
 */
interface PojoAdapter<T> {

    static YesNo booleanToYesNo(boolean b) {
        return b ? YesNo.YES : YesNo.NO;
    }

    static boolean yesNoToBoolean(YesNo b) {
        return b.equals(YesNo.YES);
    }

    T getPojo();

    void initialize(T pojo);
}
