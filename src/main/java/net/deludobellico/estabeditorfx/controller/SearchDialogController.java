package net.deludobellico.estabeditorfx.controller;

/**
 * Created by Heine on 11/3/2014.
 */

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.deludobellico.estabeditorfx.model.ElementModel;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.ViewUtil;
import net.deludobellico.estabeditorfx.util.FileIO;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

@SuppressWarnings("unchecked")
public class SearchDialogController implements Initializable {

    /**
     * Top
     */
    @FXML
    private TextField searchType;
    @FXML
    private TextField searchName;

    /**
     * Center
     */
    @FXML
    private TableView<ElementModel> searchTableView;
    @FXML
    private TableColumn<ElementModel, String> typeColumn;
    @FXML
    private TableColumn<ElementModel, String> nameColumn;

    /**
     * Bottom
     */
    @FXML
    private Button addButton;

    /**
     * Other
     */
    private Stage dialog;
    private Parent parent;
    private ElementModel selectedItem;
    private boolean addButtonIsPressed = false;
    private List<ElementModel> items;

    public static SearchDialogController init() {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchDialogController.class.getResource(FileIO.SEARCH_DIALOG_VIEW));
        SearchDialogController searchDialogController = null;
        try {
            Parent parent = fxmlLoader.load();
            searchDialogController = fxmlLoader.getController();
            searchDialogController.setParent(parent);
        } catch (NullPointerException | IOException e) {
            e.printStackTrace();
        }
        return searchDialogController;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage(StageStyle.DECORATED) {

            @Override
            public void hide() {
                if (!addButtonIsPressed) selectedItem = null;
                super.hide();
            }
        };
        dialog.initModality(Modality.WINDOW_MODAL);
        dialog.getIcons().addAll(ViewUtil.ROOT_STAGE.getIcons());
        searchName.textProperty().addListener(event -> searchAction());
        searchType.textProperty().addListener(event -> searchAction());

        typeColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getPojoClass().getSimpleName()));
        nameColumn.setCellValueFactory(param -> param.getValue().nameProperty());
        searchTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.selectedItem = newValue;
            addButton.setDisable(false);
        });

    }

    /**
     * Show the search dialog and wait for it to be closed
     *
     * @return if the dialog was closed with the add button, it'll return the last selected
     * otherwise it returns null
     */
    public ElementModel show() {
        dialog.setScene(new Scene(parent));
        dialog.showAndWait();
        return selectedItem;
    }

    public SearchDialogController setItems(Collection<? extends ElementModel> items) {
        this.items = new ArrayList(items);
        searchTableView.getItems().clear();
        searchTableView.getItems().addAll(items);
        return this;
    }

    public SearchDialogController setTitle(String title) {
        dialog.setTitle(title);
        return this;
    }

    public SearchDialogController setOwner(Stage parent) {
        dialog.initOwner(parent);
        return this;
    }

    void setParent(Parent parent) {
        this.parent = parent;
    }

    @FXML
    private void cancelButtonAction() {
        addButtonIsPressed = false;
        dialog.close();
    }

    @FXML
    private void addButtonAction() {
        if (selectedItem != null) {
            addButtonIsPressed = true;
            dialog.close();
        }
    }

    @FXML
    private void searchAction() {
        String name = searchName.getText().toLowerCase();
        String type = searchType.getText().toLowerCase();
        searchTableView.getItems().clear();
        items.stream()
                .filter(i -> i.toString().toLowerCase().contains(name))
                .filter(i -> i.getClass().getSimpleName().toLowerCase().contains(type))
                .forEach(searchTableView.getItems()::add);
    }
}
