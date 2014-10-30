package net.deludobellico.stabeditor.view;

import javafx.beans.property.BooleanProperty;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import net.deludobellico.stabeditor.model.EstabReference;
import net.deludobellico.stabeditor.util.FileIO;

import java.util.function.Consumer;

/**
 * Created by Heine on 10/30/2014.
 */
public class EstabListCell extends HBox {

    private EstabReference estabReference;
    private Label label = new Label();
    private Pane pane = new Pane();
    private Button button = new Button();

    public EstabListCell(EstabReference estabReference, Consumer<EstabReference> cellButtonAction, BooleanProperty disableButtonProperty, Boolean isEditable) {
        super();
        label.setText(estabReference.getName());
        pane.setMinWidth(5.0);
        this.estabReference = estabReference;
        button.setGraphic(isEditable ?
                new ImageView(new Image(EstabListCell.class.getResourceAsStream(FileIO.REMOVE_ICON_RESOURCE)))
                :
                new ImageView(new Image(EstabListCell.class.getResourceAsStream(FileIO.COPY_ICON_RESOURCE))));
        button.disableProperty().bind(disableButtonProperty);
        button.setOnAction(event -> cellButtonAction.accept(estabReference));

        this.getChildren().addAll(button, pane, label);
    }

    public EstabReference getEstabReference() {
        return estabReference;
    }

}
