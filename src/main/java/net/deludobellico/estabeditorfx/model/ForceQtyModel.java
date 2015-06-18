package net.deludobellico.estabeditorfx.model;

import net.deludobellico.estabeditorfx.data.jaxb.ForceQty;

/**
 * Created by Mario on 06/06/2015.
 */
public class ForceQtyModel extends AbstractReferenceModel<ForceModel> implements PojoAdapter<ForceQty> {

    public ForceQtyModel(ForceQty pojo) {
        initialize(pojo);
    }

    public ForceQtyModel() {
    }

    @Override
    public ForceQty getPojo() {
        ForceQty pojo = new ForceQty();
        pojo.setForceObjectId(id.get());
        pojo.setName(name.get());
        pojo.setQty(qty.get());
        return pojo;
    }

    @Override
    public void initialize(ForceQty pojo) {
        id.set(pojo.getForceObjectId());
        name.set(pojo.getName());
        qty.set(pojo.getQty());
    }

    @Override
    public ForceModel getReferencedElement(EstabModel estab) {
        return estab.getForces().get(id.get());
    }
}
