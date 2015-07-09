package net.deludobellico.estabeditorfx.controller.editors;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import net.deludobellico.estabeditorfx.controller.EstabEditorController;
import net.deludobellico.estabeditorfx.model.ElementModel;

/**
 * Created by Mario on 19/05/2015.
 */
public abstract class AbstractElementEditorController<T extends ElementModel> implements ElementEditorController<T>, Initializable {
    private EstabEditorController estabEditorController;
    private T activeElement;
    @FXML
    protected Parent editorPane;

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
