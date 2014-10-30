package net.deludobellico.stabeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.deludobellico.stabeditor.util.FileIO;
import net.deludobellico.stabeditor.util.Settings;

import java.io.File;
import java.util.prefs.Preferences;

public class Main extends Application {

    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Settings.load();
        Parent root = FXMLLoader.load(getClass().getResource(FileIO.ESTAB_EDITOR_VIEW));

        this.primaryStage = primaryStage;
        primaryStage.setTitle("ESTAB Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        primaryStage.setHeight(Settings.getInstance().getWindowHeight());
        primaryStage.setWidth(Settings.getInstance().getWindowWidth());
    }

    @Override
    public void stop() {
        Settings.getInstance().setWindowWidth(primaryStage.getWidth());
        Settings.getInstance().setWindowHeight(primaryStage.getHeight());
        Settings.save();
    }

    /**
     * Returns the source estab file preference, i.e. the estab file that was last opened
     * as a source to copy estab data.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getSourceEstabFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String sourceFilePath = prefs.get("sourceEstabFilePath", null);
        if (sourceFilePath != null) {
            return new File(sourceFilePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the source estab file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setSourceEstabFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("sourceEstabFilePath", file.getPath());
        } else {
            prefs.remove("sourceEstabFilePath");
        }
    }

    /**
     * Returns the target estab file preference, i.e. the estab file that was last opened
     * as a target to edit estab data.
     * The preference is read from the OS specific registry. If no such
     * preference can be found, null is returned.
     *
     * @return
     */
    public File getTargetEstabFilePath() {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        String sourceFilePath = prefs.get("targetEstabFilePath", null);
        if (sourceFilePath != null) {
            return new File(sourceFilePath);
        } else {
            return null;
        }
    }

    /**
     * Sets the source estab file path of the currently loaded file. The path is persisted in
     * the OS specific registry.
     *
     * @param file the file or null to remove the path
     */
    public void setTargetEstabFilePath(File file) {
        Preferences prefs = Preferences.userNodeForPackage(Main.class);
        if (file != null) {
            prefs.put("targetEstabFilePath", file.getPath());
        } else {
            prefs.remove("targetEstabFilePath");
        }
    }
}