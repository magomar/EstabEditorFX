package net.deludobellico.stabeditor.controller;

import net.deludobellico.stabeditor.data.jaxb.Vehicle;

/**
 * Created by Mario on 26/08/2014.
 */
public interface AssetEditorController<T> {
    void setEstabReference(T asset);
    void setReadOnly(boolean isReadOnly);
}
