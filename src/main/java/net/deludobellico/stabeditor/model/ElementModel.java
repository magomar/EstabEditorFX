package net.deludobellico.stabeditor.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Heine on 10/30/2014.
 */
public interface ElementModel {

    public Integer getId();

    public void setId(int i);

    public String getName();

    public void setName(String name);

    public StringProperty nameProperty();

    public IntegerProperty idProperty();

    default public String print() {
        return this.getClass().getSimpleName()
                + " | ID: "
                + getId()
                + " | Name: "
                + getName();
    }
}
