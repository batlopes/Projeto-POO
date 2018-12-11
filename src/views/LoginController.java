package views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Models.Usuario;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField usertf;
    @FXML
    private TextField passtf;
    @FXML
    private GridPane gridPaneLogin;

    public void checkLogin() throws IOException, SQLException, NoSuchAlgorithmException {
        Label alert = new Label();
        alert.setStyle("-fx-text-fill: rgba(232,20,24,1); -fx-font-weight: bold");

        if(usertf.getText().equals("") || passtf.getText().equals("")){
            alert.setText("Preencha os campos primeiro!");
            gridPaneLogin.add(alert,2,0);
        }
        else if(Usuario.login(usertf.getText(),passtf.getText())==null){
            alert.setText("Login ou senha Incorreto!");
            gridPaneLogin.add(alert,2,0);
            passtf.setText("");
            usertf.setText("");
        }
        else{
            Stage stage = (Stage) gridPaneLogin.getScene().getWindow();
            stage.close();
            this.entry(stage);

        }

    }
    private void entry(Stage stage) throws IOException {
        Parent home = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Scene scene = new Scene(home);
        scene.getStylesheets().add("styles/material-fx-v0_3.css");
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setMinWidth(400);
        stage.setMinHeight(250);
        stage.show();
    }
}
