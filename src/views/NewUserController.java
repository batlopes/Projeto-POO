package views;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Models.Usuario;

public class NewUserController {
    @FXML private TextField nameUser;
    @FXML private TextField mailUser;
    @FXML private PasswordField passUser;

    public void addUser(){
        Usuario usuario = new Usuario();
        usuario.setNome(nameUser.);


    }

}