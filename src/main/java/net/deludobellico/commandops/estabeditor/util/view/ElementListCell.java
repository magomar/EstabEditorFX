package net.deludobellico.commandops.estabeditor.util.view;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import net.deludobellico.commandops.estabeditor.data.jaxb.Flag;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.view.UtilView;

import java.util.function.Consumer;

/**
 * Created by Heine on 10/30/2014.
 */
public class ElementListCell extends HBox {

    private ElementModel elementModel;
    private Label label = new Label();
    private Pane pane = new Pane();
    private Button button = new Button();
    private Flag flag;

    public ElementListCell(ElementModel elementModel, Consumer<ElementModel> cellButtonAction, BooleanProperty disableButtonProperty, Boolean removeIcon) {
        super();
        this.elementModel = elementModel;
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

        pane.setMinWidth(5.0);
        button.setGraphic(removeIcon ?
                new ImageView(new Image(ElementListCell.class.getResourceAsStream(FileIO.REMOVE_ICON_RESOURCE)))
                :
                new ImageView(new Image(ElementListCell.class.getResourceAsStream(FileIO.COPY_ICON_RESOURCE))));
        button.disableProperty().bind(disableButtonProperty);
        button.setOnAction(event -> cellButtonAction.accept(elementModel));

        this.getChildren().addAll(button, pane, label);

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

    public ElementModel getElementModel() {
        return elementModel;
    }

    public Label getLabel() {
        return label;
    }

}
