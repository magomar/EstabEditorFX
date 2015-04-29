package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.Weapon;
import net.deludobellico.commandops.estabeditor.model.WeaponModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class WeaponProvider extends AbstractModelProvider<WeaponModel> {

    public WeaponProvider(Weapon weapon) {
        super(new WeaponModel(weapon));
    }
}
