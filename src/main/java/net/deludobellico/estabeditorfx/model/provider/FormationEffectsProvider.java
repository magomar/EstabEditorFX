package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.data.jaxb.FormationEffects;
import net.deludobellico.estabeditorfx.model.FormationEffectsModel;
import net.deludobellico.estabeditorfx.data.jaxb.FormationEffects;

/**
 * Created by Mario on 29/04/2015.
 */
public class FormationEffectsProvider extends AbstractModelProvider<FormationEffectsModel> {

    public FormationEffectsProvider(FormationEffects formationEffects) {
        super(new FormationEffectsModel(formationEffects));
    }
}
