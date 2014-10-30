package net.deludobellico.stabeditor.controller;

import net.deludobellico.stabeditor.model.ElementModel;

/**
 * Created by Mario on 26/08/2014.
 */
public interface ElementEditorController {
    ElementModel getEstabElement();

    void setEstabElement(ElementModel element);

    void setEditable(boolean isEditable);

    void bindProperties(ElementModel element);

    void unbindProperties(ElementModel element);

    void clear();
}
