package net.deludobellico.stabeditor.view;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * Created by htron on 10/24/2014.
 */
public class UtilView {
    public Action showWarningDialogRepeatedElement(){
        Action response = Dialogs.create()
                .title("Warning - Element already exists")
                .masthead("The element you are trying to copy already exists in the target file.")
                .message( "Do you want to overwrite it?")
                .actions(Dialog.ACTION_OK, Dialog.ACTION_CANCEL)
                .showConfirm();
        return response;
    }
}
