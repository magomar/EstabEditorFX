package net.deludobellico.commandops.estabeditor.util;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Heine on 10/27/2014.
 */
public class SavedSearchList<T> {
    private final ObservableList<T> observableList;
    private String lastSearch;
    private boolean forceSearch;


    public SavedSearchList() {
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

    public boolean isForceSearch() {
        return forceSearch;
    }

    public void setForceSearch(boolean forceSearch) {
        this.forceSearch = forceSearch;
    }
}
