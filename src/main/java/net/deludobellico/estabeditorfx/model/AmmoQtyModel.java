package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.AmmoQty;

/**
 * Model wrapper for the {@code AmmoQty} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoQtyModel extends AbstractReferenceModel<AmmoModel> implements PojoAdapter<AmmoQty> {

    public AmmoQtyModel(AmmoQty pojo) {
        initialize(pojo);
    }

    public AmmoQtyModel() {
    }

    @Override
    public AmmoQty getPojo() {
        AmmoQty pojo = new AmmoQty();
        pojo.setAmmoObjectId(id.get());
        pojo.setName(name.get());
        pojo.setQty(qty.get());
        return pojo;
    }

    @Override
    public void initialize(AmmoQty pojo) {
        id.set(pojo.getAmmoObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    @Override
    public AmmoModel getReferencedElement(EstabModel estab) {
        return estab.getAmmos().get(id.get());
    }
}
