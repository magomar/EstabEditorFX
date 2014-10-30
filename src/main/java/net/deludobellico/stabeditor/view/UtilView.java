package net.deludobellico.stabeditor.view;

import net.deludobellico.stabeditor.model.AssetModel;
import net.deludobellico.stabeditor.model.CopyPasteLists;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.DialogAction;
import org.controlsfx.dialog.Dialogs;

import java.io.File;
import java.util.Map;


/**
 * Created by Heine on 10/24/2014.
 */
public class UtilView {

    public static final CustomAction DIALOG_OVERWRITE = new CustomAction("Overwrite");
    public static final CustomAction DIALOG_SKIP_REPEATED = new CustomAction("Skip repeated");

    public static Action showWarningDialogRepeatedElement(CopyPasteLists copyPasteLists) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        for (AssetModel asset : copyPasteLists.getRepeatedAssets().keySet()) {
            sb.append(asset.print());
            sb.append(System.getProperty("line.separator"));
        }

        Action response = Dialogs.create()
                .title("Repeated elements found")
                .masthead("The following elements already exist in the target file")
                .message(sb.toString())
                .actions(Dialog.ACTION_CANCEL, DIALOG_OVERWRITE, DIALOG_SKIP_REPEATED)
                .showWarning();

        return response;
    }

    public static void showErrorEmptyFields() {
        Dialogs.create()
                .title("Missing fields")
                .masthead(null)
                .message("There are empty fields. Please fill them before proceeding.")
                .showError();
    }

    public static Action showWarningRemoveElement() {
        Action response = Dialogs.create()
                .title("Deleting element")
                .masthead(null)
                .message("You are deleting an element. Proceed?")
                .actions(Dialog.ACTION_CANCEL, Dialog.ACTION_OK)
                .showWarning();
        return response;
    }

    public static Action showWarningFileExists(File file) {
        Action response = Dialogs.create()
                .title("File already exists")
                .masthead(null)
                .message("Do you want to overwrite the following file?" + System.getProperty("line.separator") + file.getAbsolutePath())
                .actions(Dialog.ACTION_CANCEL, Dialog.ACTION_OK)
                .showWarning();

        return response;
    }
}
