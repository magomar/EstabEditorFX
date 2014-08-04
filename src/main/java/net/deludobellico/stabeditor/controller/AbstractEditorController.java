package net.deludobellico.stabeditor.controller;

import net.deludobellico.stabeditor.model.EstabReference;

/**
 * Created by Mario on 04/08/2014.
 */
public abstract class AbstractEditorController<T> {
    public abstract void setEstabReference(T estabElement);
}
