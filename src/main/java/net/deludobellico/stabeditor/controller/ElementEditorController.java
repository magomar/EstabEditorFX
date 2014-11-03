package net.deludobellico.stabeditor.controller;

import net.deludobellico.stabeditor.model.ElementModel;

/**
 * Created by Mario on 26/08/2014.
 */
public interface ElementEditorController<T extends ElementModel> {

    T getEstabElement();

    void setEstabElement(T t);

    void setEditable(boolean isEditable);

    void setEstabDataController(EstabDataController mainController);

    EstabDataController getEstabDataController();

    void bindProperties(T t);

    void unbindProperties(T t);

    void clear();
}
