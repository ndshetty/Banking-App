/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nihar, Niharika Shetty 500754054
 */
public class ManagerController  {

   @FXML
    private Button addbtn;

    @FXML
    private Button logoutbtn;

    @FXML
    private Button deletebtn;

    @FXML
    void handleAddAction(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("AddCustomer.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage addcust = new Stage();
            addcust.setScene(new Scene(root1));
            
            addcust.show();
            Stage stage = (Stage) addbtn.getScene().getWindow();
            stage.close();
    }

    @FXML
    void handleDeleteAction(ActionEvent event) throws IOException{
FXMLLoader fxml = new FXMLLoader(getClass().getResource("DeleteCustomer.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage delcust = new Stage();
            delcust.setScene(new Scene(root1));
           
            delcust.show();
            Stage stage = (Stage) deletebtn.getScene().getWindow();
            stage.close();
    }

    @FXML
    void handleLogoutAction(ActionEvent event) throws IOException{
FXMLLoader fxml = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage logout = new Stage();
            logout.setScene(new Scene(root1));
            
            logout.show();
            Stage stage = (Stage) logoutbtn.getScene().getWindow();
            stage.close();
    }
    
}
