package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.Side;
import net.deludobellico.commandops.estabeditor.model.SideModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class SideProvider extends AbstractModelProvider<SideModel> {

    public SideProvider(Side side) {
        super(new SideModel(side));
    }

}
