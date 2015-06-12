package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.Rank;

/**
 * Model wrapper for the {@code Rank} class
 *
 * @author Mario
 * @author Heine
 */
public class RankModel implements PojoAdapter<Rank> {
    private final StringProperty shortName = new SimpleStringProperty();
    private final StringProperty fullName = new SimpleStringProperty();
    private final IntegerProperty index = new SimpleIntegerProperty(0);

    public RankModel(Rank rank) {
        initialize(rank);
    }

    public RankModel() {

    }

    @Override
    public Rank getPojo() {
        Rank rank = new Rank();
        rank.setShortName(shortName.getValue());
        rank.setFullName(fullName.getValue());
        return rank;
    }

    @Override
    public void initialize(Rank pojo) {
        shortName.set(pojo.getShortName());
        fullName.set(pojo.getFullName());
    }

    public int getIndex() {
        return index.get();
    }

    public IntegerProperty indexProperty() {
        return index;
    }

    public void setIndex(int index) {
        this.index.set(index);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RankModel)) return false;

        RankModel rankModel = (RankModel) o;

        if (getFullName() != null ? !getFullName().equals(rankModel.getFullName()) : rankModel.getFullName() != null)
            return false;
        if (getShortName() != null ? !getShortName().equals(rankModel.getShortName()) : rankModel.getShortName() != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = getShortName() != null ? getShortName().hashCode() : 0;
        result = 31 * result + (getFullName() != null ? getFullName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return fullName.get();
    }
}
