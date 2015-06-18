package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Mario on 17/06/2015.
 */
public interface ReferenceModel<T extends ElementModel> {

    int getId();

    void setId(int i);

    String getName();

    void setName(String name);

    StringProperty nameProperty();

    IntegerProperty idProperty();

    T getReferencedElement(EstabModel estab);

    ReferenceStatus getReferenceStatus(EstabModel estab);

    int getQty();

    IntegerProperty qtyProperty();

    void setQty(int qty);

    enum ReferenceStatus {
        REF_OK,
        WRONG_ID,
        NAME_MISSMATCH;
    }
}
