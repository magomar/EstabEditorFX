package net.deludobellico.estabeditorfx.model;

/**
 * Created by Heine on 12/1/2014.
 */
public abstract class AbstractElementModel<T> implements ElementModel<T>{


    @Override
    public String toString() {
        return getName();
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
