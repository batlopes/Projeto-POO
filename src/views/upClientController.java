package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import Database.ClienteDAO;
import javafx.fxml.FXML;

import java.sql.SQLException;

//@FXML private gridPane;

public class upClientController {
    public ObservableList generateObsList() throws SQLException {
        ClienteDAO cli = new ClienteDAO();
        return FXCollections.observableList(cli.getLista());

    }
    public void showList(){

    }
}