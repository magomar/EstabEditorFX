package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import net.deludobellico.estabeditorfx.data.jaxb.Flag;

import java.util.List;

/**
 * Created by Heine on 12/1/2014.
 */
public abstract class AbstractElementModel<T> implements ElementModel<T>{
    protected final IntegerProperty id = new SimpleIntegerProperty();
    protected final StringProperty name = new SimpleStringProperty();
    protected final StringProperty description = new SimpleStringProperty();
    protected final List<Flag> flags = FXCollections.observableArrayList();

    @Override
    public int getId() {
        return id.get();
    }

    @Override
    public void setId(int id) {
        this.id.set(id);
    }

    @Override
    public String getName() {
        return name.get();
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public StringProperty nameProperty() {
        return name;
    }

    @Override
    public IntegerProperty idProperty() {
        return id;
    }

    @Override
    public List<Flag> getFlags() {
        return flags;
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String description) {
        this.description.set(description);
    }

    public StringProperty descriptionProperty() {
        return description;
    }

    @Override
    public String toString() {
        return name.get() + "(" + id.get() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElementModel that = (ElementModel) o;
        return that.getId() == getId();
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
