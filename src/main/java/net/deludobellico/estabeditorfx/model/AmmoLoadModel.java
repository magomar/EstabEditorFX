package net.deludobellico.estabeditorfx.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import net.deludobellico.estabeditorfx.data.jaxb.AmmoLoad;
import net.deludobellico.estabeditorfx.data.jaxb.AmmoLoad;

/**
 * Model wrapper for the {@code AmmoLoad} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoLoadModel extends AbstractReferenceModel<AmmoModel> implements PojoAdapter<AmmoLoad>  {

    public AmmoLoadModel() {
    }

    public AmmoLoadModel(AmmoLoad pojo) {
        initialize(pojo);
    }

    @Override
    public AmmoLoad getPojo() {
        AmmoLoad ammoLoad = new AmmoLoad();
        ammoLoad.setObjectId(id.get());
        ammoLoad.setName(name.get() != null ? name.get() : "");
        ammoLoad.setLoad(qty.get());
        return ammoLoad;
    }

    @Override
    public void initialize(AmmoLoad pojo) {
        id.set(pojo.getObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getLoad());
    }


    @Override
    public AmmoModel getReferencedElement(EstabModel estab) {
        return estab.getAmmos().get(id);
    }

}
