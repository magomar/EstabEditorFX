package net.deludobellico.commandops.estabeditor.controller;

import javafx.fxml.Initializable;
import net.deludobellico.commandops.estabeditor.model.CommanderRanks;
import net.deludobellico.commandops.estabeditor.model.ElementModel;

/**
 * Created by Mario on 19/05/2015.
 */
public abstract class AbstractElementEditorController<T extends ElementModel> implements ElementEditorController<T>, Initializable {
    private EstabEditorController estabEditorController;
    private T activeElement;

    @Override
    public T getActiveElement() {
        return activeElement;
    }

    @Override
    public void setActiveElement(T element) {
        if (activeElement != null) unbindProperties();
        activeElement = element;
        bindProperties();
    }

    @Override
    public void setEstabEditorController(EstabEditorController estabEditorController) {
        this.estabEditorController = estabEditorController;
    }
    @Override
    public EstabEditorController getEstabEditorController() {
        return estabEditorController;
    }


    @Override
    public void clear() {
        if (null != activeElement) unbindProperties();
    }
}
