package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.Ammo;
import net.deludobellico.estabeditorfx.model.AmmoModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class AmmoProvider extends AbstractModelProvider<AmmoModel> {

    public AmmoProvider(Ammo ammo) {
        super(new AmmoModel(ammo));
    }
}
