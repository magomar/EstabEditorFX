package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Mario on 17/06/2015.
 */
public abstract class AbstractReferenceModel<T extends ElementModel> implements ReferenceModel<T>{
    protected final IntegerProperty id = new SimpleIntegerProperty();
    protected final StringProperty name = new SimpleStringProperty();
    protected final IntegerProperty qty = new SimpleIntegerProperty();


    @Override
    public ReferenceStatus getReferenceStatus(EstabModel estab) {
        T model = getReferencedElement(estab);
        if (null == model) return ReferenceStatus.WRONG_ID;
        if (!name.get().equals(model.getName())) return ReferenceStatus.NAME_MISSMATCH;
        return ReferenceStatus.REF_OK;
    }

    @Override
    public boolean referenceIsOk(EstabModel estab) {
        return getReferenceStatus(estab) == ReferenceStatus.REF_OK;
    }

    @Override
    public boolean fixReference(EstabModel estab) {
        T reference = getReferencedElement(estab);
        ReferenceStatus status = getReferenceStatus(estab);
        if (status == ReferenceStatus.WRONG_ID) return false;
        if (status == ReferenceStatus.NAME_MISSMATCH) {
            name.set(reference.getName());
        }
        return true;
    }

    @Override
    public int getId() {
        return id.get();
    }

    @Override
    public void setId(int id) {
        this.setId(id);
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
}
