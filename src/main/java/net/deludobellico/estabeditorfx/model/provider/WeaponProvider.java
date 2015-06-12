package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.Weapon;
import net.deludobellico.estabeditorfx.model.WeaponModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class WeaponProvider extends AbstractModelProvider<WeaponModel> {

    public WeaponProvider(Weapon weapon) {
        super(new WeaponModel(weapon));
    }
}
