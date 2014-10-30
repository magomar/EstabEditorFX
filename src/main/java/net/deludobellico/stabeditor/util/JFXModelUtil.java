package net.deludobellico.stabeditor.util;

import net.deludobellico.stabeditor.data.jaxb.YesNo;

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