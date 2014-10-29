package net.deludobellico.stabeditor.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.stabeditor.data.jaxb.Rank;

/**
 * Created by Mario on 29/10/2014.
 */
public class RankModel implements PojoJFXModel<Rank> {
    private final StringProperty shortName = new SimpleStringProperty();
    private final StringProperty fullName = new SimpleStringProperty();

    // TODO getters & setters, but first do the pojo methods

    @Override
    public Rank getPojo() {
        // TODO
        return null;
    }

    @Override
    public void setPojo(Rank pojo) {
        // TODO
    }
}
