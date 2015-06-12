package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.model.ElementModel;
import net.deludobellico.estabeditorfx.model.ElementModel;

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
