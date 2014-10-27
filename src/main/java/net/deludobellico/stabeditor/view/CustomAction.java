package net.deludobellico.stabeditor.view;

import javafx.beans.NamedArg;
import org.controlsfx.dialog.DialogAction;

/**
 * Created by Heine on 10/27/2014.
 */
public class CustomAction extends DialogAction {
    public CustomAction(@NamedArg("text") String text) {
        super(text);
    }
}
