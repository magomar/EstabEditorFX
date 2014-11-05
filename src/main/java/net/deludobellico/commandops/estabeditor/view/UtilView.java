package net.deludobellico.commandops.estabeditor.view;

import javafx.stage.Stage;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;

import java.util.Collection;


/**
 * Created by Heine on 10/24/2014.
 */
public class UtilView {

    //TODO: make fxml use these constants
    public static final double MIN_WINDOW_WIDTH = 920.0;
    public static final double MIN_WINDOW_HEIGHT = 640.0;
    public static final String newline = System.getProperty("line.separator");
    public static Stage ROOT_STAGE;

    public static Object showSearchDialog(String title, Collection items) {
        return SearchDialog.init()
                .setOwner(ROOT_STAGE)
                .setTitle(title)
                .setItems(items)
                .show();
    }

    public static DialogAction showWarningRepeatedElements(Collection tableItems, Collection selectedItems) {
        return SelectionListDialog.init()
                .setOwner(ROOT_STAGE)
                .setTitle("Warning - Repeated elements found")
                .setHeadText("The following elements already exist in the target file")
                .setItems(tableItems)
                .setActions(DialogAction.CANCEL, DialogAction.COPY_SELECTION, DialogAction.SKIP_REPEATED, DialogAction.OVERWRITE)
                .show(selectedItems);
    }

    public static DialogAction showWarningRemoveElements(Collection tableItems, Collection selectedItems) {
        return SelectionListDialog.init()
                .setOwner(ROOT_STAGE)
                .setTitle("Warning - Deleting elements")
                .setHeadText("Are you sure you want to remove the following items?")
                .setItems(tableItems)
                .setActions(DialogAction.CANCEL, DialogAction.REMOVE_SELECTION, DialogAction.OK)
                .show(selectedItems);
    }

    public static DialogAction showInfoDialog(String headText, String bodyText, DialogAction... actions) {
        return InfoDialog.init()
                .setOwner(ROOT_STAGE)
                .setTitle("")
                .setHeadText(headText)
                .setBodyText(bodyText)
                .setActions(actions)
                .show();
    }
}