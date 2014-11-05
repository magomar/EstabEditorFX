package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;

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

    default public void setFlags(Flag... f) {
        for (int i = 0; i < f.length; i++) {
            setFlag(f[i]);
        }
    }

    default public void setFlag(Flag f) {
        if (!getFlags().contains(f)) {
            getFlags().add(f);
        }
    }

    default public void unsetFlag(Flag f) {
        if (getFlags().contains(f)) {
            getFlags().remove(f);
        }
    }

    default public void unsetFlags(Flag... f) {
        for (int i = 0; i < f.length; i++) {
            unsetFlag(f[i]);

        }
    }

    default public void switchFlag(Flag f) {
        if (!getFlags().contains(f)) {
            getFlags().add(f);
        } else {
            getFlags().remove(f);
        }
    }

    default public String print() {
        return this.getClass().getSimpleName()
                + " | ID: "
                + getId()
                + " | Name: "
                + getName();
    }
}
