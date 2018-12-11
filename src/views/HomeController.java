package views;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import Models.*;

import java.io.IOException;

public class HomeController {
    @FXML private MenuItem newClientMI;
    @FXML private MenuItem updateClientMI;
    @FXML private MenuItem newServiceMI;
    @FXML private MenuItem updateServiceMI;
    @FXML private MenuItem newUserMI;
    @FXML private MenuItem updateUserMI;
    @FXML private GridPane gridPaneHome;

private String currentPane=null;
private Parent newPane;
    private void addPane() throws IOException{
        this.clearHome();
        newPane = FXMLLoader.load(getClass().getResource(currentPane));
        gridPaneHome.add(newPane,0,1);
    }

    private void clearHome(){
        gridPaneHome.getChildren().remove(newPane);
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
}


//content = (gridPaneLogin) FXMLLoader.load("")