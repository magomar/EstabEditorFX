package net.deludobellico.estabeditorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.deludobellico.estabeditorfx.util.DialogAction;
import net.deludobellico.estabeditorfx.util.FileIO;
import net.deludobellico.estabeditorfx.util.Settings;
import net.deludobellico.estabeditorfx.util.ViewUtil;

public class EstabEditorFXApp extends Application {

//    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        this.primaryStage = primaryStage;
        ViewUtil.ROOT_STAGE = primaryStage;
        Settings.getInstance().load();
        FXMLLoader fxmlLoader = new FXMLLoader();
        Parent root = fxmlLoader.load(getClass().getResource(FileIO.MAIN_VIEW));
        primaryStage.setTitle("Estab Editor FX");
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.getIcons().add(new Image(FileIO.APP_ICON));
        primaryStage.setOnCloseRequest(event -> {
            if (Settings.getInstance().getNewFileCreated() && !Settings.getInstance().getNewFileSaved()) {
                DialogAction answer = ViewUtil.showInfoDialog("Unsaved new file detected", "", "If you close you will lose the changes. Continue?", DialogAction.CANCEL, DialogAction.OK);
                if (answer != DialogAction.OK) {
                    event.consume();
                }
            }
        });
        primaryStage.show();
        System.out.println("Window width: " + primaryStage.getWidth());
        System.out.println("Window height: " + primaryStage.getHeight());

    }


    @Override
    public void stop() {
        // If a new file was created, delete it.
        //noinspection ResultOfMethodCallIgnored
        FileIO.getNewEstabPath().toFile().delete();
        Settings.getInstance().save();
    }
}