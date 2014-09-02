package net.deludobellico.stabeditor.controller;

/**
 * Created by Mario on 26/08/2014.
 */
public interface AssetEditorController<T> {
    void setEstabElement(T asset);

    T getEstabElement();

    void setEditable(boolean isEditable);
}
