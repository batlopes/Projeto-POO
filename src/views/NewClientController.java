package views;

import Database.ClienteDAO;
import Models.Cliente;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewClientController {
    @FXML private TextField nomecli;
    @FXML private TextField contatocli;

    public void addclient() {
        Cliente cliente = new Cliente();
        cliente.setNome(nomecli.getText());
        cliente.setContato(contatocli.getText());
        ClienteDAO dao = new ClienteDAO();
        dao.adiciona(cliente);
    }
}
