package net.deludobellico.estabeditorfx.controller;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.fxml.Initializable;
import net.deludobellico.estabeditorfx.model.CommanderRanks;
import net.deludobellico.estabeditorfx.model.ElementModel;
import net.deludobellico.estabeditorfx.model.ElementModel;

/**
 * Created by Mario on 19/05/2015.
 */
public abstract class AbstractElementEditorController<T extends ElementModel> implements ElementEditorController<T>, Initializable {
    private EstabEditorController estabEditorController;
    private T activeElement;
    private BooleanProperty isEditable = new SimpleBooleanProperty(false);

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
    public void setEditable(boolean isEditable) {
        this.isEditable.set(isEditable);
    }

    @Override
    public void clear() {
        if (null != activeElement) unbindProperties();
    }

    public boolean getIsEditable() {
        return isEditable.get();
    }

    public BooleanProperty isEditableProperty() {
        return isEditable;
    }
}
