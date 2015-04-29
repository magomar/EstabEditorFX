package net.deludobellico.commandops.estabeditor.model.provider;

import net.deludobellico.commandops.estabeditor.model.ElementModel;

/**
 * Created by Mario on 29/04/2015.
 */
public class AbstractModelProvider<T extends ElementModel> implements ModelProvider<T> {
    private final T model;

    public AbstractModelProvider(T model) {
        this.model = model;
    }

    @Override
    public T getModel() {
        return model;
    }
}
