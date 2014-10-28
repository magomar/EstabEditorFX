package net.deludobellico.stabeditor.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.YesNo;
import net.deludobellico.stabeditor.model.PerformanceModel;

/**
 * Created by Mario on 28/10/2014.
 */
public class JFXModelUtil {
    public static YesNo booleanToYesNo(boolean b) {
        if (b) return YesNo.YES;
        else  return YesNo.NO;
    }

    public static boolean yesNoToBoolean(YesNo yesNo) {
        if (yesNo == YesNo.YES) return true;
        else return false;
    }

}
