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
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

/**
 * Created by Heine on 11/3/2014.
 */
@SuppressWarnings("unchecked")
public class CopyRemoveDialog implements Initializable {

    private final Collection selectedItems = FXCollections.observableArrayList();
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
    private Parent parent;
    private DialogAction selectedDialogAction = DialogAction.CANCEL;

    public static CopyRemoveDialog init() {
        FXMLLoader fxmlLoader = new FXMLLoader(CopyRemoveDialog.class.getResource(FileIO.SELECTION_DIALOG_VIEW));
        CopyRemoveDialog copyRemoveDialog = null;
        try {
            Parent parent = fxmlLoader.load();
            copyRemoveDialog = fxmlLoader.getController();
            copyRemoveDialog.setParent(parent);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return copyRemoveDialog;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage();
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.getIcons().addAll(UtilView.ROOT_STAGE.getIcons());
        dialog.setMinHeight(400);
        dialog.setMinWidth(600);

        tableView.getColumns().clear();
        tableViewTypeColumn.setCellValueFactory(param -> new SimpleStringProperty(ElementModel.CLASS_MAP.get(param.getValue().getClass()).getSimpleName()));
        tableViewNameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        tableView.getColumns().add(tableViewTypeColumn);
        tableView.getColumns().add(tableViewNameColumn);

        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tableView.getSelectionModel().clearSelection();
        tableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedItems.clear();
            selectedItems.addAll(tableView.getSelectionModel().getSelectedItems());
        });

        image.setImage(new Image(CopyRemoveDialog.class.getResourceAsStream(FileIO.WARNING_ICON_RESOURCE)));
    }

    public CopyRemoveDialog setTitle(String title) {
        dialog.setTitle(title);
        return this;
    }

    public CopyRemoveDialog setItems(Collection items) {
        tableView.getItems().clear();
        tableView.getItems().addAll(items);
        return this;
    }

    public CopyRemoveDialog setOwner(Stage owner) {
        dialog.initOwner(owner);
        return this;
    }

    void setParent(Parent parent) {
        this.parent = parent;
    }

    public CopyRemoveDialog setHeadText(String text) {
        this.headText.setText(text);
        return this;
    }

    public CopyRemoveDialog setBodyText(String text) {
        this.bodyText.setText(text);
        return this;
    }

    public DialogAction show(Collection collection) {
        dialog.setScene(new Scene(parent));
        dialog.showAndWait();
        if (selectedDialogAction.equals(DialogAction.COPY_SELECTION)
                || selectedDialogAction.equals(DialogAction.REMOVE_SELECTION)
                || selectedDialogAction.equals(DialogAction.MARK_SELECTION))
            collection.addAll(this.selectedItems);
        return selectedDialogAction;
    }

    public CopyRemoveDialog setActions(DialogAction... dialogActions) {
        buttonBox.getChildren().clear();
        for (DialogAction dialogAction : dialogActions) {
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
