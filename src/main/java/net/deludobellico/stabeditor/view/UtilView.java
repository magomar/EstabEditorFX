package net.deludobellico.stabeditor.view;

import net.deludobellico.stabeditor.model.ElementModel;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by Heine on 10/24/2014.
 */
public class UtilView {

    public static final CustomDialogAction DIALOG_OVERWRITE = new CustomDialogAction("Overwrite");
    public static final CustomDialogAction DIALOG_SKIP_REPEATED = new CustomDialogAction("Skip repeated");
    public static final double MIN_WINDOW_WIDTH = 920.0;
    public static final double MIN_WINDOW_HEIGHT = 640.0;
    public static final String newline = System.getProperty("line.separator");

    public static Action showWarningRepeatedElement(Collection<ElementModel> collection) {

        StringBuilder sb = new StringBuilder();
        collection.stream().forEach(element -> sb.append(element.print() + newline));

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
        return showWarningRemoveElement(new ArrayList<>());
    }

    public static Action showWarningRemoveElement(Collection<ElementModel> collection) {
        String plural = "";
        String message;
        if (collection.size() != 1) {
            plural = "s";
        }

        StringBuilder sb = new StringBuilder();
        collection.stream().forEach(element -> sb.append(element.print() + newline));
        message = sb.toString();


        Action response = Dialogs.create()
                .title("Removing element" + plural)
                .masthead("The Following element"+plural+" will be deleted")
                .message(message + newline + "Proceed?")
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
