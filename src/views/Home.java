package views;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class Home extends Application{
    @Override
    public void start(Stage stage) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(home);
        scene.getStylesheets().add("styles/material-fx-v0_3.css");
        stage.setScene(scene);
        stage.setMinWidth(400);
        stage.setMinHeight(450);
        stage.show();

    }
}
