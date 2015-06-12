package net.deludobellico.estabeditorfx.model.provider;

import net.deludobellico.estabeditorfx.model.ElementModel;
import net.deludobellico.estabeditorfx.model.ElementModel;

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
