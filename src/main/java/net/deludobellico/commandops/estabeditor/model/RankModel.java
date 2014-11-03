package net.deludobellico.commandops.estabeditor.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.commandops.estabeditor.data.jaxb.Rank;

/**
 * Created by Mario on 29/10/2014.
 */
public class RankModel implements PojoJFXModel<Rank> {
    private final StringProperty shortName = new SimpleStringProperty();
    private final StringProperty fullName = new SimpleStringProperty();

    @Override
    public Rank getPojo() {
        Rank rank = new Rank();
        rank.setShortName(shortName.getValue());
        rank.setFullName(fullName.getValue());
        return rank;
    }

    @Override
    public void setPojo(Rank pojo) {
        shortName.set(pojo.getShortName());
        fullName.set(pojo.getFullName());
    }

    public String getShortName() {
        return shortName.get();
    }

    public void setShortName(String shortName) {
        this.shortName.set(shortName);
    }

    public StringProperty shortNameProperty() {
        return shortName;
    }

    public String getFullName() {
        return fullName.get();
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }
}
