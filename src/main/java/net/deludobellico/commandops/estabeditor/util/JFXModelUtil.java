package net.deludobellico.commandops.estabeditor.util;

import net.deludobellico.commandops.estabeditor.data.jaxb.YesNo;

/**
 * Created by Mario on 28/10/2014.
 */
public class JFXModelUtil {
    public static YesNo booleanToYesNo(boolean cond) {
        return cond ? YesNo.YES : YesNo.NO;
    }

    public static boolean yesNoToBoolean(YesNo cond) {
        return cond.equals(YesNo.YES);
    }
}