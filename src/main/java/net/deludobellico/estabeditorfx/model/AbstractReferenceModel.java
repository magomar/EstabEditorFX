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
    private ReferenceStatus referenceStatus;
    private T reference;

    protected AbstractReferenceModel(Class<T> referenceClass) {
        this.referenceClass = referenceClass;
    }

    public boolean link(EstabModel estab) {
        reference = getReferenceById(estab);

        if (null == reference) {
            referenceStatus = ReferenceStatus.WRONG_ID;
            return false;
        }
        if (name.get().equals(reference.getName())) {
            referenceStatus = ReferenceStatus.REF_OK;
            return true;
        } else {
            referenceStatus = ReferenceStatus.NAME_MISSMATCH;
            return false;
        }
    }


        @Override
    public T getReference() {
        return reference;
    }

    public T getReferenceById(EstabModel estab) {
        return (T) estab.getAll().get(referenceClass).get(id);
    }


    public T getReferenceByName(EstabModel estab) {
        List<ElementModel> models = estab.searchElement(name.get(), referenceClass);
        if (models.isEmpty()) return null;
        // TODO if size > 0 let the user select one (or none at all, but let the user decide)
        return (T) models.get(0);
    }

    @Override
    public boolean fixReference(EstabModel estab) {
        T reference;
        if (referenceStatus == ReferenceStatus.WRONG_ID) {
            // tries to find an element having the name of this reference
            reference = getReferenceByName(estab);
            if (null != reference) id.set(reference.getId());
            else return false;
        }
        if (referenceStatus == ReferenceStatus.NAME_MISSMATCH) {
            // fixes name using the name of the object with the id of this reference
            reference = getReferenceById(estab);
            name.set(reference.getName());
        }
        return true;
    }


    @Override
    public ReferenceStatus getReferenceStatus() {
        return referenceStatus;
    }

    @Override
    public boolean referenceIsOk() {
        return referenceStatus == ReferenceStatus.REF_OK;
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

    protected Class<T> getReferenceClass() {
        return referenceClass;
    }

    protected void setReferenceClass(Class<T> referenceClass) {
        this.referenceClass = referenceClass;
    }

    protected void setReferenceStatus(ReferenceStatus referenceStatus) {
        this.referenceStatus = referenceStatus;
    }

    protected void setReference(T reference) {
        this.reference = reference;
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
