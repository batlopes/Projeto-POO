package views;

import Database.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Models.*;
import views.ClientListController;

import javax.print.DocFlavor;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    @FXML private MenuItem newClientMI;
    @FXML private MenuItem updateClientMI;
    @FXML private MenuItem newServiceMI;
    @FXML private MenuItem updateServiceMI;
    @FXML private MenuItem newUserMI;
    @FXML private MenuItem updateUserMI;
    @FXML private GridPane gridPaneHome;
    @FXML private ListView listCliName;
    @FXML private ListView listCliContato;
    @FXML private GridPane gridpaneLists;

private String currentPane=null;
private static Parent newPane=null;
    public void addPane() throws IOException{
        this.clearHome();
        newPane = FXMLLoader.load(getClass().getResource(currentPane));
        gridPaneHome.add(newPane,0,1);
    }

    private void clearHome(){
        if(newPane == null){
            gridPaneHome.getChildren().remove(gridpaneLists);
        }
        else {gridPaneHome.getChildren().remove(newPane);}
    }

    public void addClient(){
        this.clearHome();
        currentPane="NewClient.fxml";
        try {
            this.addPane();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addService(){
        this.clearHome();
        currentPane="NewService.fxml";

        try{
            this.addPane();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addUser(){
        this.clearHome();
        currentPane="NewUser.fxml";
        try{
            this.addPane();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    private void showListCLient() throws IOException, SQLException {
//        System.out.println("Chegou ai");
//        //ClientListController.showList();
//        System.out.println("Chegou ai1");
//        newPane = FXMLLoader.load(HomeController.class.getResource("ClientList.fxml"));
//        gridPaneHome.add(newPane,0,1);
//
//    }

    public void showListClient() throws SQLException {
        ClienteDAO cli = new ClienteDAO();
        List<Cliente> listCli = cli.getLista();
        //ObservableList<Models.Cliente> listaCli = FXCollections.observableList(cli.getLista());
        List<String> listaCliName = new ArrayList<>();
        List<String> listaCliContat = new ArrayList<>();
        for(int i=0;i<listCli.size();i++){
            listaCliName.add(listCli.get(i).getNome());
            System.out.println(listCli.get(i).getContato());
            listaCliContat.add(listCli.get(i).getContato());
        }
        ObservableList<String> listaClinome = FXCollections.observableList(listaCliName);
        ObservableList<String> listaClicontato = FXCollections.observableList(listaCliContat);
        listCliName.setItems(listaClinome);
        listCliContato.setItems(listaClicontato);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            showListClient();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


//content = (gridPaneLogin) FXMLLoader.load("")