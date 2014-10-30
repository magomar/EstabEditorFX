package net.deludobellico.stabeditor.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import net.deludobellico.stabeditor.data.jaxb.Asset;
import net.deludobellico.stabeditor.model.EstabReference;

/**
 * Created by Heine on 10/27/2014.
 */
public class SearchList {
    private Boolean isFullSearch;
    private String lastSearch;
    private ObservableList<EstabReference> estabReferenceObservableList;


    public SearchList() {
        lastSearch = null;
        isFullSearch = false;
        estabReferenceObservableList  = FXCollections.observableArrayList();
    }

    public Boolean getIsFullSearch() {
        return lastSearch.equals("");
    }

    public String getLastSearch() {
        return lastSearch;
    }

    public void setLastSearch(String search) {
        this.lastSearch = search;
    }

    public ObservableList<EstabReference> getList() {
        return estabReferenceObservableList;
    }
}
