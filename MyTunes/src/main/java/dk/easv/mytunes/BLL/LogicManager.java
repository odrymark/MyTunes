package dk.easv.mytunes.BLL;

import dk.easv.mytunes.Main;
import dk.easv.mytunes.PL.controllers.ImportController;
import dk.easv.mytunes.PL.controllers.TunesController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;

import java.io.IOException;

public class LogicManager
{
    private ImportController importController;
    private TunesController tunesController;

    public LogicManager(Stage stage) throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("MainScene.fxml"));

        tunesController = new TunesController(this);
        fxmlLoader.setController(tunesController);

        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MyTunes");
        stage.setScene(scene);
        stage.show();
    }

    public void addSong(String details)
    {
        tunesController.addSong(details);
    }

    public void importWindow() throws IOException
    {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SongImportScene.fxml"));

        importController = new ImportController(this);
        fxmlLoader.setController(importController);

        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Import Song");
        stage.show();
    }
}
