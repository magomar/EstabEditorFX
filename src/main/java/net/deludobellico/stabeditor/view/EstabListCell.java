package net.deludobellico.stabeditor.view;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import net.deludobellico.stabeditor.model.ElementModel;
import net.deludobellico.stabeditor.model.EstabReference;
import net.deludobellico.stabeditor.util.FileIO;

import java.util.function.Consumer;

/**
 * Created by Heine on 10/30/2014.
 */
public class EstabListCell extends HBox {

    private ElementModel elementModel;
    private Label label = new Label();
    private Pane pane = new Pane();
    private Button button = new Button();

    public EstabListCell(ElementModel elementModel, Consumer<ElementModel> cellButtonAction, BooleanProperty disableButtonProperty, Boolean removeIcon) {
        super();
        label.setText(elementModel.getName());
        pane.setMinWidth(5.0);
        this.elementModel = elementModel;
        button.setGraphic(removeIcon ?
                new ImageView(new Image(EstabListCell.class.getResourceAsStream(FileIO.REMOVE_ICON_RESOURCE)))
                :
                new ImageView(new Image(EstabListCell.class.getResourceAsStream(FileIO.COPY_ICON_RESOURCE))));
        button.disableProperty().bind(disableButtonProperty);
        button.setOnAction(event -> cellButtonAction.accept(elementModel));

        this.getChildren().addAll(button, pane, label);
    }

    public ElementModel getElementModel() {
        return elementModel;
    }

}
