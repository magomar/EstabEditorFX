package net.deludobellico.commandops.estabeditor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.deludobellico.commandops.estabeditor.util.FileIO;
import net.deludobellico.commandops.estabeditor.util.Settings;
import net.deludobellico.commandops.estabeditor.util.view.DialogAction;
import net.deludobellico.commandops.estabeditor.util.UtilView;

public class EstabEditorApp extends Application {

    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Settings.load();
        Parent root = FXMLLoader.load(getClass().getResource(FileIO.ESTAB_EDITOR_VIEW));

        this.primaryStage = primaryStage;
        UtilView.ROOT_STAGE = primaryStage;
        primaryStage.setTitle("ESTAB Editor");
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(UtilView.MIN_WINDOW_WIDTH);
        primaryStage.setMinHeight(UtilView.MIN_WINDOW_HEIGHT);
        primaryStage.getIcons().add(new Image(FileIO.APP_ICON));
        try {
            primaryStage.setHeight(Settings.getInstance().getWindowHeight());
            primaryStage.setWidth(Settings.getInstance().getWindowWidth());
        } catch (NullPointerException ignored) {

        }
        primaryStage.setOnCloseRequest(event -> {
            if (Settings.isNewFileCreated() && !Settings.isNewFileSaved()) {
                DialogAction answer = UtilView.showInfoDialog("Unsaved new file detected", "", "If you close you will lose the changes. Continue?", DialogAction.CANCEL, DialogAction.OK);
                if (answer != DialogAction.OK) {
                    event.consume();
                }
            }
        });
        primaryStage.show();
    }

    @Override
    public void stop() {
        // If a new file was created, delete it.
        //noinspection ResultOfMethodCallIgnored
        FileIO.getNewEstabPath().toFile().delete();
        Settings.getInstance().setWindowWidth(primaryStage.getWidth());
        Settings.getInstance().setWindowHeight(primaryStage.getHeight());
        Settings.save();
    }
}