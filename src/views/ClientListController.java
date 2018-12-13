package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Database.ClienteDAO;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;

//@FXML private gridPane;

public class ClientListController {
    @FXML private static ListView listViewCli;

    public static ObservableList generateObsList() throws SQLException {
        ClienteDAO cli = new ClienteDAO();
        ObservableList<Models.Cliente> listaCli = FXCollections.observableList(cli.getLista());
        return listaCli;

    }
    public static void showList() throws SQLException {
        listViewCli.setItems(generateObsList());

    }
}