package net.deludobellico.stabeditor.view;

import net.deludobellico.stabeditor.model.ElementModel;
import net.deludobellico.stabeditor.model.CopyPasteLists;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import java.io.File;


/**
 * Created by Heine on 10/24/2014.
 */
public class UtilView {

    public static final CustomDialogAction DIALOG_OVERWRITE = new CustomDialogAction("Overwrite");
    public static final CustomDialogAction DIALOG_SKIP_REPEATED = new CustomDialogAction("Skip repeated");
    public static final double MIN_WINDOW_WIDTH = 920.0;
    public static final double MIN_WINDOW_HEIGHT = 640.0;

    public static Action showWarningDialogRepeatedElement(CopyPasteLists copyPasteLists) {
        StringBuilder sb = new StringBuilder();
        sb.append(System.getProperty("line.separator"));
        for (ElementModel element : copyPasteLists.getRepeatedElements().keySet()) {
            sb.append(element.print());
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
