/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nihar, Niharika Shetty 500754054
 * 
 * 
 * 
 */


/* This class is reponsible for adding a new customer. In this class, the manager
can input the username and password of each customer and set a level as well as the 
mininum amount in their respective bank account. A new customer txt file is created for each 
customer and saved within the project folder. This is a mutable class whose state 
can be modified after it is created as we can modify the status and the balance of each
customer bank account


AF(c) = a Add Customer Controller ac, such that 
        c.username=ac.username, c.password = ac.password
RI(c) = c.username != null && c.password != null

*/ 
public class AddCustomerController  {

    @FXML
    private TextField usernamefield;

    @FXML
    private PasswordField passwordfield;

    @FXML
    private Button addbutton;

    @FXML
    private Button backbtn;
    
    @FXML
    private Label errorlabel;
    
    String username, password;
    
/*Effects: Returns username
Modifies: usernamefield to username 
*/

    /**
     *
     * @return
     */

    public String getUsername() {
        username = usernamefield.getText();
        return username;
    }
/*Effects: Returns password
Modifies: passwordfield to password 
*/

    /**
     *
     * @return
     */

    public String getPassword() {
        password = passwordfield.getText();
        return password;
    }
    
/*Effects: creates a txt file with each customer username and password added. it creates a new customer
    txt file with the username, password, amount, level and user type (i.e customer).
    for the value that is typed in the TextField usernamefield 
  Requires: getUsername() and getPassword(), ActionEvent( Add Button Click)
*/
    @FXML
    void handleAddAction(ActionEvent event) throws IOException {
        
        if (getUsername().equals("admin")) {
            errorlabel.setText("Admin is taken");
        }
        else {
            String fileName = getUsername() + ".txt";
            FileWriter file = new FileWriter(fileName);
            file.write(getUsername());
            file.write(System.getProperty("line.separator"));
            file.write(getPassword());
            file.write(System.getProperty("line.separator"));
            file.write("100.0");
            file.write(System.getProperty("line.separator"));
            file.write("Silver");
            file.write(System.getProperty("line.separator"));
            file.write("customer");
            file.close();
            errorlabel.setText("Customer " + getUsername() + " created.");
        

        }
    }
/*Effects: Button that goes back to the previous Manager page where the manager can choose to perform another function
    Requires: ActionEvent(Back Button click)
*/
    @FXML
    void handleBackAction(ActionEvent event)throws IOException{
FXMLLoader fxml = new FXMLLoader(getClass().getResource("Manager.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage managerpage = new Stage();
            managerpage.setScene(new Scene(root1));
            managerpage.show();
            Stage stage = (Stage) backbtn.getScene().getWindow();
            stage.close();
    }
   //AF(c) implemented
    @Override
    public String toString() {
       
           return "username: " + getUsername() + "password: " + getPassword();
       
           
       }
    
    //RepOk() implemented

    /**
     *
     * @return
     */
    public boolean repOk() {
        boolean b = false;
        if(getUsername() != null && getPassword() != null) {
        b = true;
    }
    return b;
    }
    
}
