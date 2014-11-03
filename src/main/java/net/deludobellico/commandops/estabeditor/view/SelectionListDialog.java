package net.deludobellico.commandops.estabeditor.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.Util;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Heine on 11/3/2014.
 */
public class SelectionListDialog implements Initializable {

    @FXML
    private HBox buttonBox;

    @FXML
    private Label headText;

    @FXML
    private Text bodyText;

    @FXML
    private ImageView image;

    @FXML
    private TableView<ElementModel> tableView;

    @FXML
    private TableColumn<ElementModel, String> tableViewTypeColumn;

    @FXML
    private TableColumn<ElementModel, String> tableViewNameColumn;

    private Stage dialog;
    private Collection items;
    private Parent parent;
    private DialogAction selectedDialogAction = DialogAction.CANCEL;
    private Collection selectedItems = FXCollections.observableArrayList();

    public static SelectionListDialog init() {
        FXMLLoader fxmlLoader = new FXMLLoader(SelectionListDialog.class.getResource(FileIO.SELECTION_DIALOG_VIEW));
        SelectionListDialog selectionListDialog = null;
        try {
            Parent parent = fxmlLoader.load();
            selectionListDialog = fxmlLoader.getController();
            selectionListDialog.setParent(parent);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return selectionListDialog;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.getIcons().addAll(UtilView.ROOT_STAGE.getIcons());
        dialog.setMinHeight(400);
        dialog.setMinWidth(600);

        tableView.getColumns().clear();
        tableViewTypeColumn.setCellValueFactory(param -> new SimpleStringProperty(Util.CLASS_MAP_MODEL_TO_POJO.get(param.getValue().getClass()).getSimpleName()));
        tableViewNameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        tableView.getColumns().add(tableViewTypeColumn);
        tableView.getColumns().add(tableViewNameColumn);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.getSelectionModel().clearSelection();
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedItems.clear();
            selectedItems.addAll(tableView.getSelectionModel().getSelectedItems());
        });

        image.setImage(new Image(SelectionListDialog.class.getResourceAsStream(FileIO.WARNING_ICON_RESOURCE)));
    }

    public SelectionListDialog setTitle(String title) {
        dialog.setTitle(title);
        return this;
    }

    public SelectionListDialog setItems(Collection items) {
        this.items = items;
        tableView.getItems().clear();
        tableView.getItems().addAll(items);
        return this;
    }

    public SelectionListDialog setOwner(Stage owner) {
        dialog.initOwner(owner);
        return this;
    }

    public SelectionListDialog setParent(Parent parent) {
        this.parent = parent;
        return this;
    }

    public SelectionListDialog setHeadText(String text) {
        this.headText.setText(text);
        return this;
    }

    public SelectionListDialog setBodyText(String text) {
        this.bodyText.setText(text);
        return this;
    }

    public DialogAction show(Collection selectedItems) {
        dialog.setScene(new Scene(parent));
        dialog.showAndWait();
        if (selectedDialogAction.equals(DialogAction.COPY_SELECTION) || selectedDialogAction.equals(DialogAction.REMOVE_SELECTION))
            selectedItems.addAll(this.selectedItems);
        return selectedDialogAction;
    }

    public SelectionListDialog setActions(DialogAction... dialogActions) {
        buttonBox.getChildren().clear();
        for (int i = 0; i < dialogActions.length; i++) {
            DialogAction dialogAction = dialogActions[i];
            Button b = new Button(dialogAction.getAction());
            b.setOnAction(event -> {
                this.selectedDialogAction = dialogAction;
                dialog.close();
            });
            b.setMaxHeight(Double.MAX_VALUE);
            b.setMaxWidth(Double.MAX_VALUE);
            b.setUserData(dialogAction);
            HBox.setHgrow(b, Priority.ALWAYS);
            buttonBox.getChildren().add(b);
        }
        return this;
    }
}
