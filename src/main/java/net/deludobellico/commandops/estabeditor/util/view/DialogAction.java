package net.deludobellico.commandops.estabeditor.util.view;

/**
 * Created by Heine on 11/3/2014.
 */
public enum DialogAction {
    OVERWRITE("Overwrite"),
    SKIP_REPEATED("Skip repeated"),
    COPY_SELECTION("Copy selection"),
    REMOVE_SELECTION("Remove selection"),
    CANCEL("Cancel"), OK("OK"), MARK_SELECTION("Mark selection");

    private final String action;

    DialogAction(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public String toString() {
        return action;
    }
}
