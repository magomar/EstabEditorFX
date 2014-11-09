package net.deludobellico.commandops.estabeditor.model;

/**
 * Counter part of ElementModel. All classes wrapped by ElementModel implements this interface
 *
 * @param <T> element model class
 * @author Mario
 * @author Heine
 */
public interface Element<T extends ElementModel> {
    T getModel();
}
