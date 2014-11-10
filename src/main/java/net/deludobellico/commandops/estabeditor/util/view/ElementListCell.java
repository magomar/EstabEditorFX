package net.deludobellico.commandops.estabeditor.util.view;

import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import net.deludobellico.commandops.estabeditor.controller.EstabController;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.util.Collection;
import java.util.Iterator;

/**
 * Cell factory for the search result lists in {@code EstabController}.
 * Each cell is composed of a {@link CheckBox} and a {@link Label}. Additionally, each cell references an {@link ElementModel}.
 * When the checkbox is selected the element model is added to a collection, and removed when deselected.
 *
 * @see EstabController#searchResultsListView
 */
public class ElementListCell extends HBox {

    private ElementModel elementModel;
    private CheckBox checkBox;
    // Cell text
    private Label label;
    // Used for setting the label style
    private Flag flag;

    public ElementListCell(ElementModel elementModel, Collection<ElementModel> selectedElements) {
        super();
        this.elementModel = elementModel;
        label = createLabel();
        checkBox = createCheckBox(selectedElements);

        this.setOnMouseClicked(createMouseClickedHandler());
        this.getChildren().addAll(checkBox, label);
    }

    /**
     * Selects or deselects the cell checkbox
     *
     * @param b if true, select the checkbox, otherwise deselect
     */
    public void setSelected(boolean b) {
        checkBox.setSelected(b);
    }

    /**
     * Returns the associated element model
     *
     * @return the associated element model
     */
    public ElementModel getElementModel() {
        return elementModel;
    }

    /**
     * Creates a {@code CheckBox} with a listener to add or remove the {@code elementModel} from a collection
     *
     * @param selectedElements collection to add to or remove from
     * @return the new checkbox
     */
    private CheckBox createCheckBox(Collection<ElementModel> selectedElements) {
        CheckBox c = new CheckBox();

        c.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) selectedElements.add(elementModel);
            else selectedElements.remove(elementModel);
        });
        return c;
    }

    /**
     * Creates a {@code Label} with its text style depending on the {@code ElementModel} {@link Flag}.
     * Since an element can contain multiple flags, the priority is New > Copy > Remove.
     *
     * @return the new created label
     */
    @SuppressWarnings("unchecked")
    private Label createLabel() {
        Label l = new Label();
        // Set up the name
        l.textProperty().bind(elementModel.nameProperty());
        // Set up the style
        Iterator<Flag> flagIt = elementModel.getFlags().iterator();
        boolean styleIsSet = false;
        while (!styleIsSet && flagIt.hasNext()) {
            flag = flagIt.next();
            switch (flag) {
                case NEW:
                    l.setStyle(UtilView.TEXT_STYLE_NEW);
                    styleIsSet = true;
                    break;
                case COPY:
                    l.setStyle(UtilView.TEXT_STYLE_COPY);
                    styleIsSet = true;
                    break;
                case REMOVE:
                    l.setStyle(UtilView.TEXT_STYLE_REMOVE);
                    styleIsSet = true;
                    break;
            }
        }
        return l;
    }

    /**
     * Creates an EventHandler to cycle between tags when the user right clicks the cell
     *
     * @return EventHandler to capture mouse clicks
     */
    private EventHandler<? super MouseEvent> createMouseClickedHandler() {
        return event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                if (flag == Flag.COPY) {
                    // Change flag from copy to remove
                    flag = Flag.REMOVE;
                    elementModel.unsetFlag(Flag.COPY);
                    elementModel.setFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_REMOVE);

                } else if (flag == Flag.REMOVE) {
                    // Change flag from remove to none
                    flag = null;
                    elementModel.unsetFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_DEFAULT);

                } else if (flag == Flag.NEW) {
                    // Change flag from new to none
                    flag = null;
                    elementModel.unsetFlag(Flag.NEW);
                    label.setStyle(UtilView.TEXT_STYLE_DEFAULT);

                } else if (flag == null) {
                    // Change flag from none to copy
                    flag = Flag.COPY;
                    elementModel.setFlag(Flag.COPY);
                    label.setStyle(UtilView.TEXT_STYLE_COPY);
                }
            }
        };
    }
}
