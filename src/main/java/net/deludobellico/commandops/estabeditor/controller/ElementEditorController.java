package net.deludobellico.commandops.estabeditor.controller;

import net.deludobellico.commandops.estabeditor.model.ElementModel;

/**
 * Created by Mario on 26/08/2014.
 */
public interface ElementEditorController<T extends ElementModel> {

    T getEstabElement();

    void setEstabElement(T t);

    void setEditable(boolean isEditable);

    EstabDataController getEstabDataController();

    void setEstabDataController(EstabDataController mainController);

    void bindProperties(T t);

    void unbindProperties(T t);

    void clear();
}
