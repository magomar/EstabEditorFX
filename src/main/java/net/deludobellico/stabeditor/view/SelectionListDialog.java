package net.deludobellico.stabeditor.view;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
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
import net.deludobellico.stabeditor.model.ElementModel;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Util;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    private Action selectedAction;
    private Collection selectedItems = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
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

    public static SelectionListDialog init() {
        FXMLLoader fxmlLoader = new FXMLLoader(SelectionListDialog.class.getResource(FileIO.CHECKLIST_DIALOG_VIEW));
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

    public Action show(Collection selectedItems) {
        dialog.setScene(new Scene(parent));
        dialog.showAndWait();
        if (selectedAction.equals(Action.COPY_SELECTION) || selectedAction.equals(Action.REMOVE_SELECTION))
            selectedItems.addAll(this.selectedItems);
        return selectedAction;
    }

    public SelectionListDialog setActions(Action... actions) {
        buttonBox.getChildren().clear();
        for (int i = 0; i < actions.length; i++) {
            Action action = actions[i];
            Button b = new Button(action.getAction());
            b.setOnAction(event -> {
                this.selectedAction = action;
                dialog.close();
            });
            b.setMaxHeight(Double.MAX_VALUE);
            b.setMaxWidth(Double.MAX_VALUE);
            b.setUserData(action);
            HBox.setHgrow(b, Priority.ALWAYS);
            buttonBox.getChildren().add(b);
        }
        return this;
    }

    public static enum Action {
        OVERWRITE("Overwrite"),
        SKIP_REPEATED("Skip repeated"),
        COPY_SELECTION("Copy selection"),
        REMOVE_SELECTION("Remove selection"),
        CANCEL("Cancel");

        private final String action;

        Action(String action) {
            this.action = action;
        }

        public String getAction() {
            return action;
        }

        public String toString() {
            return action;
        }
    }
}
