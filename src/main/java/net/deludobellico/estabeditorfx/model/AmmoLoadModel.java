package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.AmmoLoad;

/**
 * Model wrapper for the {@code AmmoLoad} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoLoadModel extends AbstractReferenceModel<AmmoModel> implements PojoAdapter<AmmoLoad> {

    public AmmoLoadModel() {
        super(AmmoModel.class);
    }

    public AmmoLoadModel(AmmoLoad pojo) {
        super(AmmoModel.class);
        initialize(pojo);
    }

    @Override
    public AmmoLoad getPojo() {
        AmmoLoad ammoLoad = new AmmoLoad();
        ammoLoad.setObjectId(getId());
        ammoLoad.setName(getName() != null ? getName() : "");
        ammoLoad.setLoad(getQty());
        return ammoLoad;
    }

    @Override
    public void initialize(AmmoLoad pojo) {
        setId(pojo.getObjectId());
        if (null != pojo.getName()) {
            setName(pojo.getName());
        } else {
            setName("");
        }
        setQty(pojo.getLoad());
    }


    @Override
    public AmmoModel getReferenceById(EstabModel estab) {
        return estab.getAmmos().get(getId());
    }

}
