package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.model.ElementModel;

/**
 * Counter part of ElementModel. All classes wrapped by ElementModel implements this interface
 *
 * @param <T> element model class
 * @author Mario
 * @author Heine
 */
public interface ModelProvider<T extends ElementModel> {
    T getModel();
}
