package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.model.EstabReference;

/**
 * Created by Heine on 10/27/2014.
 */
public class SearchList<T> {
    private String lastSearch;
    private ObservableList<T> observableList;


    public SearchList() {
        lastSearch = null;
        observableList = FXCollections.observableArrayList();
    }

    public String getLastSearch() {
        return lastSearch;
    }

    public void setLastSearch(String search) {
        this.lastSearch = search;
    }

    public ObservableList<T> getList() {
        return observableList;
    }
}
