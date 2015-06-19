package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

/**
 * Created by Mario on 17/06/2015.
 */
public abstract class AbstractReferenceModel<T extends ElementModel> implements ReferenceModel<T> {
    private final IntegerProperty id = new SimpleIntegerProperty();
    private final StringProperty name = new SimpleStringProperty();
    private final IntegerProperty qty = new SimpleIntegerProperty();
    private Class<T> referenceClass;

    protected AbstractReferenceModel(Class<T> referenceClass) {
        this.referenceClass = referenceClass;
    }


    @Override
    public ReferenceStatus getReferenceStatus(EstabModel estab) {
        T model = getReferenceById(estab);
        if (null == model) {
            return ReferenceStatus.WRONG_ID;
        }
        if (!name.get().equals(model.getName())) {
            return ReferenceStatus.NAME_MISSMATCH;
        }
        return ReferenceStatus.REF_OK;
    }

    @Override
    public boolean referenceIsOk(EstabModel estab) {
        return getReferenceStatus(estab) == ReferenceStatus.REF_OK;
    }

    @Override
    public boolean fixReference(EstabModel estab) {
        T reference;
        ReferenceStatus status = getReferenceStatus(estab);
        if (status == ReferenceStatus.WRONG_ID) {
            // tries to find an element having the name of this reference
            reference = getReferenceByName(estab);
            if (null != reference) id.set(reference.getId());
            else return false;
        }
        if (status == ReferenceStatus.NAME_MISSMATCH) {
            // fixes name using the name of the object with the id of this reference
            reference = getReferenceById(estab);
            name.set(reference.getName());
        }
        return true;
    }

    @Override
    public T getReferenceById(EstabModel estab) {
        return (T) estab.getAll().get(referenceClass).get(id);
    }


    @Override
    public T getReferenceByName(EstabModel estab) {
        List<ElementModel> models = estab.searchElement(name.get(), referenceClass);
        if (models.isEmpty()) return null;
        return (T) models.get(0);
    }

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
    public int getQty() {
        return qty.get();
    }

    @Override
    public IntegerProperty qtyProperty() {
        return qty;
    }

    @Override
    public void setQty(int qty) {
        this.qty.set(qty);
    }

    public Class<T> getReferenceClass() {
        return referenceClass;
    }

    public void setReferenceClass(Class<T> referenceClass) {
        this.referenceClass = referenceClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractReferenceModel<?> that = (AbstractReferenceModel<?>) o;

        return id.equals(that.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return name.get() + '(' + id.get() + "): " + qty.get() + '[' + referenceClass.getSimpleName() +
                '}';
    }
}
