package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.ForceQty;

/**
 * Created by Mario on 06/06/2015.
 */
public class ForceQtyModel extends AbstractReferenceModel<ForceModel> implements PojoAdapter<ForceQty> {

    public ForceQtyModel() {
        super(ForceModel.class);
    }

    public ForceQtyModel(ForceQty pojo) {
        super(ForceModel.class);
        initialize(pojo);
    }

    @Override
    public ForceQty getPojo() {
        ForceQty pojo = new ForceQty();
        pojo.setForceObjectId(getId());
        pojo.setName(getName());
        pojo.setQty(getQty());
        return pojo;
    }

    @Override
    public void initialize(ForceQty pojo) {
        setId(pojo.getForceObjectId());
        setName(pojo.getName());
        setQty(pojo.getQty());
    }

    @Override
    public ForceModel getReferenceById(EstabModel estab) {
        return estab.getForces().get(getId());
    }
}
