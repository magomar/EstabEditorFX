package net.deludobellico.stabeditor.model;

/**
 * Created by Heine on 10/30/2014.
 */
public interface AssetModel {

    public Integer getId();

    public String getName();

    default public String print() {
        return this.getClass().getSimpleName()
                + " | ID: "
                + getId()
                + " | Name: "
                + getName();
    }
}
