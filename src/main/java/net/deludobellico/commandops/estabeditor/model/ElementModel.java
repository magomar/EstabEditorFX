package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.util.Util;

import java.util.List;

/**
 * Created by Heine on 10/30/2014.
 */
public interface ElementModel {

    public int getId();

    public void setId(int i);

    public String getName();

    public void setName(String name);

    public StringProperty nameProperty();

    public IntegerProperty idProperty();

    List<Flag> getFlags();

    default public void setFlag(Flag... f) {
        if(f == null) return;
        for (Flag aF : f) {
            if (!getFlags().contains(aF)) {
                getFlags().add(aF);
            }
        }
    }

    default public void unsetFlag(Flag... f) {
        if(f == null) return;
        for (Flag aF : f) {
            if (getFlags().contains(aF)) {
                getFlags().remove(aF);
            }
        }
    }

    default public void switchFlag(Flag... f) {
        if(f == null) return;
        for (Flag aF : f) {
            if (!getFlags().contains(aF)) {
                getFlags().add(aF);
            } else {
                getFlags().remove(aF);
            }
        }
    }

    default public String print() {
        return String.format(" %s | ID: %d | Name: %s",
                Util.CLASS_MAP_MODEL_TO_POJO.get(getClass()).getSimpleName(),
                getId(), getName());
    }
}
