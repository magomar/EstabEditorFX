package net.deludobellico.stabeditor.view;

/**
 * Created by Heine on 11/3/2014.
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.deludobellico.stabeditor.model.AmmoModel;
import net.deludobellico.stabeditor.util.FileIO;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class SearchDialog implements Initializable {

    @FXML
    private ListView<Object> searchListView;

    @FXML
    private TextField searchTextField;

    private Stage dialog;

    private FXMLLoader fxmlLoader;

    private Pane pane;

    private boolean closeWithAdd = false;

    private Object selectedItem;

    private List items;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dialog = new Stage(StageStyle.DECORATED) {

            @Override
            public void hide() {
                if (!closeWithAdd) selectedItem = null;
                super.hide();
            }
        };
        dialog.initModality(Modality.WINDOW_MODAL);

        searchTextField.textProperty().addListener(event -> searchAction(null));

        searchListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            this.selectedItem = newValue;
        });

    }


    public static SearchDialog init(Stage parent, String title, Collection items) {
        FXMLLoader fxmlLoader = new FXMLLoader(SearchDialog.class.getResource(FileIO.SEARCH_DIALOG_VIEW));
        SearchDialog searchDialog = null;
        try {
            Pane pane = fxmlLoader.load();
            searchDialog = fxmlLoader.getController();
            searchDialog.setTitle(title);
            searchDialog.setItems(items);
            searchDialog.setOwner(parent);
            searchDialog.setPane(pane);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searchDialog;
    }

    /**
     * Show the search dialog and wait for it to be closed
     * @return if the dialog was closed with the add button, it'll return the last selected
     *         otherwise it returns null
     */
    public Object show() {
        dialog.setScene(new Scene(pane));
        dialog.showAndWait();
        return selectedItem;
    }

    public void setItems(Collection items) {
        this.items = new ArrayList(items);
        searchListView.getItems().clear();
        searchListView.getItems().addAll(items);
    }

    public void setTitle(String title) {
        dialog.setTitle(title);
    }

    public void setOwner(Stage parent) {
        dialog.initOwner(parent);
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    @FXML
    private void cancelButtonAction(ActionEvent actionEvent) {
        closeWithAdd = false;
        dialog.close();
    }

    @FXML
    private void addButtonAction(ActionEvent actionEvent) {
        if (!searchListView.getSelectionModel().getSelectedItems().isEmpty()) {
            closeWithAdd = true;
            dialog.close();
        }
    }

    @FXML
    private void searchAction(ActionEvent actionEvent) {
        String textToSearch = searchTextField.getText().toLowerCase();
        searchListView.getItems().clear();
        for (int i = 0; i < items.size(); i++) {
            Object o = items.get(i);
            if (o.toString().toLowerCase().contains(textToSearch)) {
                searchListView.getItems().add(o);
            }
        }
    }
}
