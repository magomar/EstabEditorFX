package net.deludobellico.commandops.estabeditor.util.view;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.util.Set;

/**
 * Created by Heine on 10/30/2014.
 */
public class ElementListCell extends HBox {

    private ElementModel elementModel;
    private Label label;
    private Flag flag;
    private CheckBox checkBox;

    public ElementListCell(ElementModel elementModel, Set<ElementModel> selectedElements) {
        super();
        this.elementModel = elementModel;
        label = new Label();
        checkBox = new CheckBox();

        for (Flag f : elementModel.getFlags()) {
            if (f.equals(Flag.COPY)) {
                label.setStyle(UtilView.TEXT_STYLE_COPY);
                flag = Flag.COPY;
                break;
            }
            if (f.equals(Flag.REMOVE)) {
                label.setStyle(UtilView.TEXT_STYLE_REMOVE);
                flag = Flag.REMOVE;
                break;
            }
            if (f.equals(Flag.NEW)) {
                label.setStyle(UtilView.TEXT_STYLE_NEW);
                break;
            }
        }
        label.textProperty().bind(elementModel.nameProperty());

        Pane pane = new Pane();
        pane.setMinWidth(5.0);

        checkBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            Object ignore = newValue ? selectedElements.add(elementModel) : selectedElements.remove(elementModel);
        });
        this.getChildren().addAll(checkBox, pane, label);

        setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                if (flag == null) {
                    flag = Flag.COPY;
                    elementModel.setFlag(Flag.COPY);
                    label.setStyle(UtilView.TEXT_STYLE_COPY);
                } else if (flag.equals(Flag.COPY)) {
                    flag = Flag.REMOVE;
                    elementModel.unsetFlag(Flag.COPY);
                    elementModel.setFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_REMOVE);
                } else if (flag.equals(Flag.REMOVE)) {
                    flag = null;
                    elementModel.unsetFlag(Flag.REMOVE);
                    label.setStyle(UtilView.TEXT_STYLE_DEFAULT);
                }
            }
        });
    }

    public static void select(ElementListCell elementListCell) {
        elementListCell.setSelected(true);
    }

    public static void unselect(ElementListCell elementListCell) {
        elementListCell.setSelected(false);
    }

    public ElementModel getElementModel() {
        return elementModel;
    }

    public void setSelected(boolean b) {
        checkBox.setSelected(b);
    }
}
