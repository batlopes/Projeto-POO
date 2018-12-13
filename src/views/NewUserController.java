package views;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Models.Usuario;
import Database.UsuarioDAO;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class NewUserController {
    @FXML
    private TextField name;
    @FXML
    private TextField mail;
    @FXML
    private PasswordField pass;

    public void addUser() throws UnsupportedEncodingException, NoSuchAlgorithmException {
        Usuario usuario = new Usuario();
        System.out.println(name.getText());
        usuario.setNome(name.getText());
        usuario.setEmail(mail.getText());
        usuario.setSenha(pass.getText());
        UsuarioDAO dao = new UsuarioDAO();
        dao.adiciona(usuario);

    }

}