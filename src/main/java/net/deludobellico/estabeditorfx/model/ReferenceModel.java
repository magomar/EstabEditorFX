package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Mario on 17/06/2015.
 */
public interface ReferenceModel<T extends ElementModel> {

    boolean fixReference(EstabModel estab);

    int getId();

    IntegerProperty idProperty();

    void setId(int i);

    String getName();

    StringProperty nameProperty();

    void setName(String name);

    int getQty();

    IntegerProperty qtyProperty();

    void setQty(int qty);

    T getReference();

    ReferenceStatus getReferenceStatus();

    boolean referenceIsOk();

    enum ReferenceStatus {
        REF_OK,
        WRONG_ID,
        NAME_MISSMATCH;
    }
}
