package net.deludobellico.estabeditorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.Settings;
import net.deludobellico.estabeditorfx.util.ViewUtil;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstabEditorFXApp extends Application {
    private static final Logger LOG = Logger.getLogger(EstabEditorFXApp.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewUtil.ROOT_STAGE = primaryStage;
        Settings.getInstance().load();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource(FileIO.MAIN_VIEW));
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Estab Editor FX");
//        primaryStage.initStyle(StageStyle.UNDECORATED);
        //size of the screen
        Dimension screenSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize();
        LOG.log(Level.INFO, "Screen size: " + screenSize.getWidth() + " x " + screenSize.getHeight());
//        if (screenSize.getHeight() >= ViewUtil.VERT_HEIGHT) {
//            // Vertical layout (preferred)
//            primaryStage.setMinWidth(ViewUtil.VERT_WIDTH);
//            ViewUtil.USES_HORIZONTAL_LAYOUT = false;
//        } else {
//            primaryStage.setMinWidth(ViewUtil.HORIZ_WIDTH);
//            primaryStage.setMaxHeight(ViewUtil.HORIZ_HEIGHT);
//            ViewUtil.USES_HORIZONTAL_LAYOUT = true;
//        }
        primaryStage.setMinWidth(ViewUtil.HORIZ_WIDTH);
        primaryStage.setMaxHeight(ViewUtil.HORIZ_HEIGHT);
        ViewUtil.USES_HORIZONTAL_LAYOUT = true;
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(FileIO.getImageFromFile("app-icon.png"));
        primaryStage.setOnCloseRequest(event -> {
            if (Settings.getInstance().getNewFileCreated() && !Settings.getInstance().getNewFileSaved()) {
                DialogAction answer = ViewUtil.showInfoDialog("Unsaved new file detected", "", "If you close you will lose the changes. Continue?", DialogAction.CANCEL, DialogAction.OK);
                if (answer != DialogAction.OK) {
                    event.consume();
                }
            }
        });
        primaryStage.show();
        LOG.log(Level.INFO, "Windows dimension: " + primaryStage.getWidth() + " x " + primaryStage.getHeight());
        LOG.log(Level.INFO, "Scene dimension: " + scene.getWidth() + " x " + scene.getHeight());
    }


    @Override
    public void stop() {
        // If a new file was created, delete it.
        //noinspection ResultOfMethodCallIgnored
        FileIO.getNewEstabPath().toFile().delete();
        Settings.getInstance().save();
    }
}