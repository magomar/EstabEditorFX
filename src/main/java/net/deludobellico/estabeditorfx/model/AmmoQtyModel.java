package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.AmmoQty;

/**
 * Model wrapper for the {@code AmmoQty} class
 *
 * @author Mario
 * @author Heine
 */
public class AmmoQtyModel extends AbstractReferenceModel<AmmoModel> implements PojoAdapter<AmmoQty> {


    public AmmoQtyModel() {
        super(AmmoModel.class);
    }


    public AmmoQtyModel(AmmoQty pojo) {
        super(AmmoModel.class);
        initialize(pojo);
    }

    @Override
    public AmmoQty getPojo() {
        AmmoQty pojo = new AmmoQty();
        pojo.setAmmoObjectId(getId());
        pojo.setName(getName());
        pojo.setQty(getQty());
        return pojo;
    }

    @Override
    public void initialize(AmmoQty pojo) {
        setId(pojo.getAmmoObjectId());
        setName(pojo.getName());
        setQty(pojo.getQty());
    }

    @Override
    public AmmoModel getReferenceById(EstabModel estab) {
        return estab.getAmmos().get(getId());
    }
}
