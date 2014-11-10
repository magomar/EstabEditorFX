/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.deludobellico.commandops.estabeditor.model;

import net.deludobellico.commandops.estabeditor.data.jaxb.YesNo;

/**
 * Interface for all the jaxb package classes
 *
 * @author Mario
 * @author Heine
 */
interface PojoJFXModel<T> {

    public static YesNo booleanToYesNo(boolean b) {
        return b ? YesNo.YES : YesNo.NO;
    }

    public static boolean yesNoToBoolean(YesNo b) {
        return b.equals(YesNo.YES);
    }

    T getPojo();

    void setPojo(T pojo);
}
