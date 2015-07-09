package net.deludobellico.estabeditorfx.util;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.deludobellico.estabeditorfx.controller.customdialogs.CopyRemoveDialogController;
import net.deludobellico.estabeditorfx.controller.customdialogs.InfoDialogController;
import net.deludobellico.estabeditorfx.controller.customdialogs.SearchDialogController;
import net.deludobellico.estabeditorfx.model.ElementModel;

import java.util.*;


/**
 * Created by Heine on 10/24/2014.
 */
public class ViewUtil {
//    public static final double MAX_WIDTH = 1366;
//    public static final double MAX_HEIGHT = 768;
    public static final double VERT_WIDTH = 691;
    public static final double VERT_HEIGHT = 980;
    public static final double HORIZ_WIDTH = 1366;
    public static final double HORIZ_HEIGHT = 508;
    public static final double ESTAB_EDITOR_WIDTH = 675;
    public static final double ESTAB_EDITOR_HEIGHT = 433;
    public static final double TOOLBAR_HEIGHT = 50;

    public static final Set<Class> editableControls = new HashSet<>();
    public static final Set<Class> nonEditableControls = new HashSet<>();

    static {
        editableControls.addAll(Arrays.asList(TextField.class, TextArea.class));
        nonEditableControls.addAll(Arrays.asList(ComboBox.class, Button.class, CheckBox.class, ColorPicker.class));
    }

    public static final String TEXT_STYLE_COPY = "-fx-text-fill: blue;";
    public static final String TEXT_STYLE_REMOVE = "-fx-text-fill: red;";
    public static final String TEXT_STYLE_NEW = "-fx-text-fill: green;";
    public static final String TEXT_STYLE_DEFAULT = "-fx-text-fill: black;";
    public static Stage ROOT_STAGE;
    public static boolean USES_HORIZONTAL_LAYOUT = false;

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

    public static void setEditable(Parent root, boolean isEditable) {
        List<Node> nodes = new ArrayList<Node>();
        addAllDescendents(root, nodes);
        for (Node node : nodes) {
            if (editableControls.contains(node.getClass())) {
                ((TextInputControl) node).setEditable(isEditable);
            } else if (nonEditableControls.contains(node.getClass())) {
                node.setDisable(!isEditable);
                node.setOpacity(1);
            }
//            if (node instanceof Control) {
//                if (node instanceof TextField || node instanceof TextArea) {
//                    ((TextInputControl) node).setEditable(isEditable);
//                } else {
//                    node.setDisable(!isEditable);
//                    node.setOpacity(1);
//                }
//            }

        }
    }

    private static void addAllDescendents(Parent parent, List<Node> nodes) {
        for (Node node : parent.getChildrenUnmodifiable()) {
            nodes.add(node);
            if (node instanceof TabPane) {
                ((TabPane) node).getTabs().stream().forEach(tab -> addAllDescendents((Parent) tab.getContent(), nodes));
            } else if (node instanceof Parent) {
                addAllDescendents((Parent) node, nodes);
            }
        }
    }
}
