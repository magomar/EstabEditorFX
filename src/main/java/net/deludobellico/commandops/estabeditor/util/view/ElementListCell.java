package net.deludobellico.commandops.estabeditor.util.view;

import javafx.event.EventHandler;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Heine on 10/30/2014.
 */
public class ElementListCell extends HBox {

    private ElementModel elementModel;
    private Label label;
    private Flag flag;
    private CheckBox checkBox;

    public ElementListCell(ElementModel elementModel, Collection<ElementModel> selectedElements) {
        super();
        this.elementModel = elementModel;
        label = createLabel();
        checkBox = createCheckBox(selectedElements);
        Pane pane = createPane();

        this.setOnMouseClicked(createMouseClickedHandler());
        this.getChildren().addAll(checkBox, pane, label);
    }

    public static void select(ElementListCell elementListCell) {
        elementListCell.setSelected(true);
    }

    public static void deselect(ElementListCell elementListCell) {
        elementListCell.setSelected(false);
    }

    private Pane createPane() {
        Pane pane = new Pane();
        pane.setMinWidth(5.0);
        return pane;
    }

    private CheckBox createCheckBox(Collection<ElementModel> selectedElements) {
        CheckBox c = new CheckBox();

        c.selectedProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) selectedElements.add(elementModel);
            else selectedElements.remove(elementModel);
        });
        return c;
    }

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

    private EventHandler<? super MouseEvent> createMouseClickedHandler() {
        return event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                if (flag == Flag.COPY) {
                    flag = Flag.REMOVE;
                    elementModel.unsetFlag(Flag.COPY);
                    elementModel.setFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_REMOVE);

                } else if (flag == Flag.REMOVE) {
                    flag = null;
                    elementModel.unsetFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_DEFAULT);

                } else if (flag == Flag.NEW) {
                    flag = null;
                    elementModel.unsetFlag(Flag.NEW);
                    label.setStyle(UtilView.TEXT_STYLE_DEFAULT);

                } else if (flag == null) {
                    flag = Flag.COPY;
                    elementModel.setFlag(Flag.COPY);
                    label.setStyle(UtilView.TEXT_STYLE_COPY);

                }
            }

        };
    }

    public ElementModel getElementModel() {
        return elementModel;
    }

    public void setSelected(boolean b) {
        checkBox.setSelected(b);
    }

}
