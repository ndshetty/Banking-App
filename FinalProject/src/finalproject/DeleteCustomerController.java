/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nihar, Niharika Shetty 500754054
 */
public class DeleteCustomerController  {

    @FXML
    private TextField usernamefield;

    @FXML
    private Button deletebtn;

    @FXML
    private Button backbtn;
    
    @FXML
    private Label errorlabel;
    
    String username;
    
    
  

  
    @FXML
    void handleBackAction(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("Manager.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage managerpage = new Stage();
            managerpage.setScene(new Scene(root1));
            
            managerpage.show();
            Stage stage = (Stage) backbtn.getScene().getWindow();
            stage.close();
    }
    //BUG: still have not figured out how to do delete customer.
    @FXML
    void handleDeleteAction(ActionEvent event) {

        String fileName = usernamefield + ".txt";
        File file = new File(fileName);

        
        if(usernamefield.getText().isEmpty()) {
            errorlabel.setText("Please enter a Username");
            errorlabel.setTextFill(Color.rgb(210, 39, 30));
        }
         
        if(file.exists()) {
            if(file.delete()){
                errorlabel.setText("Customer Deleted");
                  errorlabel.setTextFill(Color.rgb(210, 39, 30));
            } else {
                errorlabel.setText("Username does not exist");
                  errorlabel.setTextFill(Color.rgb(210, 39, 30));
            }
        }
    }
    
}
