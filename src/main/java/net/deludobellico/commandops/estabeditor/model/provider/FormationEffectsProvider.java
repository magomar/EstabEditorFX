package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.data.jaxb.FormationEffects;
import net.deludobellico.commandops.estabeditor.model.FormationEffectsModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class FormationEffectsProvider extends AbstractModelProvider<FormationEffectsModel> {

    public FormationEffectsProvider(FormationEffects formationEffects) {
        super(new FormationEffectsModel(formationEffects));
    }
}
