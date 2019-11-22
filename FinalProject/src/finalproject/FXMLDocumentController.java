/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author nihar, Niharika Shetty 500754054
 */
public class FXMLDocumentController {
    
    @FXML
    private Button loginbtn;

    @FXML
    private Label label;

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Label errorlabel;
    
    private String username, password = null;
    private ArrayList<String> customerdetails = new ArrayList<>();
    
    
    public String getUsername() {
        username = usernamefield.getText();
        return username;
    }
    
      public String getPassword() {
        password = passwordfield.getText();
        return password;
    }
      
      public ArrayList<String> getinfo() throws IOException {
          String fileName = getUsername() + ".txt";
          File file = new File(fileName);
          String line = "";
          
          if(file.isFile()) {
              BufferedReader reader = new BufferedReader(new FileReader(fileName));
              while((line= reader.readLine()) != null)
              {
                  customerdetails.add(line);
              }
              
          } else {
              for(int j=0; j< 5; j++)
              {customerdetails.add("null");
          }         
      }return customerdetails; 
      }

          
    @FXML
    void handleLoginAction(ActionEvent event) throws IOException {
         String fileName = getUsername() + ".txt";
            
         if (usernamefield.getText().isEmpty()) {
            errorlabel.setText("Login Error");
            errorlabel.setTextFill(Color.rgb(210, 39, 30));
        }
        
        //displays error if password not provided
        if (passwordfield.getText().isEmpty()) {
            errorlabel.setText("Login Error");
            errorlabel.setTextFill(Color.rgb(210, 39, 30));
        }
        
        
         if (getUsername().equals("admin") && getPassword().equals("manager")) {
                              
            
            FXMLLoader fxml = new FXMLLoader(getClass().getResource("Manager.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage managerpage = new Stage();
            managerpage.setScene(new Scene(root1));
            
            managerpage.show();
            Stage stage = (Stage) loginbtn.getScene().getWindow();
            stage.close();
         
             
             }
        else { 
             File file = new File(fileName);
             getinfo();
             if(file.exists()) {
                 String passwordfield = Files.readAllLines(Paths.get(fileName)).get(1);
                 if(getPassword().equals(passwordfield)) {
                        FXMLLoader fxml = new FXMLLoader(getClass().getResource("CustomerPage.fxml"));
                        Parent root2 = (Parent) fxml.load();
                        Stage customerpage = new Stage();
                        customerpage.setScene(new Scene(root2));
                       
                        customerpage.show();
                        CustomerPageController a = fxml.<CustomerPageController>getController();
                        a.setinfo(customerdetails);
                        Stage stage = (Stage) loginbtn.getScene().getWindow();
                        stage.close();
                       
                 } else {
                     errorlabel.setText("Invalid password");
                     
                 }
             }
             }
    }

    }
        
        
    
         
    

    
    
    
       

