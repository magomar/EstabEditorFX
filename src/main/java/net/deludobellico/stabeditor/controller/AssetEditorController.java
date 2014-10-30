package net.deludobellico.stabeditor.controller;

import net.deludobellico.stabeditor.model.AssetModel;
import net.deludobellico.stabeditor.model.WeaponModel;

/**
 * Created by Mario on 26/08/2014.
 */
public interface AssetEditorController {
    AssetModel getEstabElement();

    void setEstabElement(AssetModel asset);

    void setEditable(boolean isEditable);

    void bindProperties(AssetModel asset);

    void unbindProperties(AssetModel asset);
}
