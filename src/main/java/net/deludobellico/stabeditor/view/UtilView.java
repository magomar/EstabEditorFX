package net.deludobellico.stabeditor.view;

import net.deludobellico.stabeditor.data.jaxb.Asset;
import net.deludobellico.stabeditor.model.CopyPasteLists;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

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
        for (Map.Entry<Asset, Class> entry : copyPasteLists.getRepeatedAssets().entrySet()) {
            //TODO: override toString in Asset class
            sb.append(entry.getValue().getSimpleName());
            sb.append(" | ID: ");
            sb.append(entry.getKey().getId());
            sb.append(" | Name: ");
            sb.append(entry.getKey().getName());
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

    public static void showWarningEmptyFields() {
        Dialogs.create()
                .title("Missing fields")
                .masthead(null)
                .message("There are empty fields. Please fill them before proceeding.")
                .showWarning();
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
}
