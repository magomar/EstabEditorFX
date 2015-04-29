package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.Ammo;
import net.deludobellico.commandops.estabeditor.model.AmmoModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class AmmoProvider extends AbstractModelProvider<AmmoModel> {

    public AmmoProvider(Ammo ammo) {
        super(new AmmoModel(ammo));
    }
}
