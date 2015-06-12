package net.deludobellico.commandops.estabeditor.controller;

/**
 * Created by Heine on 11/3/2014.
 */

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.ViewUtil;
import net.deludobellico.commandops.estabeditor.util.DialogAction;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

//TODO: make the view prettier
public class InfoDialogController implements Initializable {

    @FXML
    private ImageView image;

    @FXML
    private Label headText;

    @FXML
    private Text bodyText;

    @FXML
    private HBox buttonBox;

    private Stage dialog;

    private Parent parent;

    private DialogAction selectedAction;

    public static InfoDialogController init() {
        FXMLLoader fxmlLoader = new FXMLLoader(InfoDialogController.class.getResource(FileIO.INFO_DIALOG_VIEW));
        InfoDialogController infoDialogController = null;
        try {
            Parent parent = fxmlLoader.load();
            infoDialogController = fxmlLoader.getController();
            infoDialogController.setParent(parent);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return infoDialogController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage(StageStyle.DECORATED);
        dialog.getIcons().addAll(ViewUtil.ROOT_STAGE.getIcons());
        dialog.initModality(Modality.WINDOW_MODAL);
        buttonBox.getChildren().stream().forEach(b -> ((Button) b).setOnAction(event -> dialog.close()));
        image.setImage(new Image(InfoDialogController.class.getResourceAsStream(FileIO.INFO_ICON_RESOURCE)));

    }

    public InfoDialogController setTitle(String title) {
        dialog.setTitle(title);
        return this;
    }

    public InfoDialogController setOwner(Stage parent) {
        dialog.initOwner(parent);
        return this;
    }

    void setParent(Parent parent) {
        this.parent = parent;
    }


    public InfoDialogController setHeadText(String text) {
        this.headText.setText(text);
        return this;
    }

    public InfoDialogController setBodyText(String text) {
        this.bodyText.setText(text);
        return this;
    }

    public InfoDialogController setActions(DialogAction... actions) {
        if (actions.length > 1) {
            buttonBox.getChildren().clear();
            for (DialogAction dialogAction : actions) {
                Button b = new Button(dialogAction.getAction());
                b.setOnAction(event -> {
                    this.selectedAction = dialogAction;
                    dialog.close();
                });
                b.setMaxHeight(Double.MAX_VALUE);
                b.setMaxWidth(Double.MAX_VALUE);
                b.setUserData(dialogAction);
                HBox.setHgrow(b, Priority.ALWAYS);
                buttonBox.getChildren().add(b);
            }
        } else if (actions.length == 1) {
            Button b = (Button) buttonBox.getChildren().get(0);
            b.setText(actions[0].getAction());
            b.setOnAction(event -> {
                this.selectedAction = actions[0];
                dialog.close();
            });
        }
        return this;
    }

    public DialogAction show() {
        dialog.setScene(new Scene(parent));
        dialog.showAndWait();
        return selectedAction;
    }


}
