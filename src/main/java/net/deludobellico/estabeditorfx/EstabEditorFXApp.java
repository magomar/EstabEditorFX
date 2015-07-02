package net.deludobellico.estabeditorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import net.deludobellico.estabeditorfx.controller.MainController;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.Settings;
import net.deludobellico.estabeditorfx.util.ViewUtil;

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
        primaryStage.setMinWidth(ViewUtil.MAIN_VIEW_WIDTH);
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
        LOG.log(Level.INFO, "Scene dimension: " + scene.getWidth() + " x " +  scene.getHeight());
    }


    @Override
    public void stop() {
        // If a new file was created, delete it.
        //noinspection ResultOfMethodCallIgnored
        FileIO.getNewEstabPath().toFile().delete();
        Settings.getInstance().save();
    }
}