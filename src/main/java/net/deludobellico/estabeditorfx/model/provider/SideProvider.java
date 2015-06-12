package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.Side;
import net.deludobellico.estabeditorfx.model.SideModel;
import net.deludobellico.estabeditorfx.data.jaxb.Side;
import net.deludobellico.estabeditorfx.model.SideModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class SideProvider extends AbstractModelProvider<SideModel> {

    public SideProvider(Side side) {
        super(new SideModel(side));
    }

}
