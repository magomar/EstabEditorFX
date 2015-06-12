package net.deludobellico.commandops.estabeditor.util;

import javafx.stage.Stage;
import net.deludobellico.commandops.estabeditor.model.ElementModel;
import net.deludobellico.commandops.estabeditor.controller.CopyRemoveDialogController;
import net.deludobellico.commandops.estabeditor.controller.InfoDialogController;
import net.deludobellico.commandops.estabeditor.controller.SearchDialogController;

import java.util.Collection;


/**
 * Created by Heine on 10/24/2014.
 */
public class ViewUtil {

    public static final double WINDOW_WIDTH = 880;
    public static final double WINDOW_HEIGHT = 960;
    public static final String TEXT_STYLE_COPY = "-fx-text-fill: blue;";
    public static final String TEXT_STYLE_REMOVE = "-fx-text-fill: red;";
    public static final String TEXT_STYLE_NEW = "-fx-text-fill: green;";
    public static final String TEXT_STYLE_DEFAULT = "-fx-text-fill: black;";
    public static Stage ROOT_STAGE;

    public static Object showSearchDialog(String title, Collection<? extends ElementModel> items) {
        return SearchDialogController.init()
                .setOwner(ROOT_STAGE)
                .setTitle(title)
                .setItems(items)
                .show();
    }

    public static DialogAction showWarningRepeatedElements(Collection tableItems, Collection selectedItems) {
        return CopyRemoveDialogController.init()
                .setOwner(ROOT_STAGE)
                .setTitle("Warning - Repeated elements found")
                .setHeadText("The following elements already exist in the target file")
                .setItems(tableItems)
                .setActions(DialogAction.CANCEL, DialogAction.COPY_SELECTION, DialogAction.SKIP_REPEATED, DialogAction.OVERWRITE)
                .show(selectedItems);
    }

    public static DialogAction showWarningRemoveElements(Collection tableItems, Collection selectedItems) {
        return CopyRemoveDialogController.init()
                .setOwner(ROOT_STAGE)
                .setTitle("Warning - Deleting elements")
                .setHeadText("Are you sure you want to remove the following items?")
                .setItems(tableItems)
                .setActions(DialogAction.CANCEL, DialogAction.REMOVE_SELECTION, DialogAction.MARK_SELECTION, DialogAction.OK)
                .show(selectedItems);
    }

    public static DialogAction showInfoDialog(String title, String headText, String bodyText, DialogAction... actions) {
        return InfoDialogController.init()
                .setOwner(ROOT_STAGE)
                .setTitle(title)
                .setHeadText(headText)
                .setBodyText(bodyText)
                .setActions(actions)
                .show();
    }
}