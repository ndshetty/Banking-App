/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nihar, Niharika Shetty, 500754054
 */
public class CustomerPageController  {

    @FXML
    private Button depositbtn;
    @FXML
    private Button withdrawbtn;
    @FXML
    private Button opbtn;
    @FXML
    private Button logoutbtn;
    @FXML
    private TextField amountfield;
    @FXML
    private Label amountlabel;
    @FXML
    private Label secondlabel;
    
    private String userName= null;
    private String passWord = null;
    private final String role = "customer";
    private double app = 100.0;
    private Level lev;
    private ArrayList<String> customerdetails;
    
    public void setinfo(ArrayList<String> info) {
        customerdetails = info;
    }
    
     public void setapp (double bank) throws IOException {
        app = bank;
        customerdetails.set(2, Double.toString(app));
        String fileName = getusername() + ".txt";
        FileWriter file = new FileWriter(fileName);
            file.write(getusername());
            file.write(System.getProperty("line.separator"));
            file.write(getpassword());
            file.write(System.getProperty("line.separator"));
            file.write(Double.toString(app));
            file.write(System.getProperty("line.separator"));
            file.write(getlvl().toString());
            file.write(System.getProperty("line.separator"));
            file.write("customer");
            file.close();
            
    }
        public String getusername() throws IOException { //easier implementation
        userName = customerdetails.get(0);
        return userName;
    }
    
    public String getpassword() throws IOException { //easier implementation
        passWord = customerdetails.get(1);
        return passWord;
    }
    
    public double getapp() throws IOException{ //gets bank balance from .txt file
        app = Double.parseDouble(customerdetails.get(2));
        return app;
    }
        
   
    public Level getlvl() throws IOException { //gets level by looking at the respective files       
            String t= customerdetails.get(3);
            
        switch(t)
        {
            case "Silver" :
                lev = new Silver();
                    break;
            case "Gold":
                lev = new Gold();
                    break;
            case "Platinum":
                lev = new Platinum();
                    break;
            default:
                break;
                    
        }
        return lev;
    }
    
    public void setlvl(Level l) throws IOException {
        lev = l;
        customerdetails.set(3, lev.toString());
       String fileName = null;
        FileWriter file = new FileWriter(fileName);
            file.write(getusername());
            file.write(System.getProperty("line.separator"));
            file.write(getpassword());
            file.write(System.getProperty("line.separator"));
            file.write(Double.toString(getapp()));
            file.write(System.getProperty("line.separator"));
            file.write(lev.toString());
            file.write(System.getProperty("line.separator"));
            file.write("customer");
            file.close();
        
    }
    
    public void OPurchase (double cost) {
     //   app.OPurchase(this, cost);
    }
        public double getamt() {
        
    
    try {
            double amt = Double.parseDouble(amountfield.getText());
            return amt; 
        }
        catch(NumberFormatException e) {
            amountlabel.setText("Enter a valid number");
            secondlabel.setText("");
             return 0;
        }
    }
 
    void getbal() throws IOException {
        amountlabel.setText("Balance: " + getapp());
            secondlabel.setText("Level: " + getlvl().toString());
      
    }

    
    

    @FXML
    private void handleDepositAction(ActionEvent event) throws IOException {
       try {
            double tot = getapp();
            tot += getamt();
            setapp(tot);
            getbal();
            
        }
        catch (NumberFormatException e) {
            amountlabel.setText("Enter a valid number");
            secondlabel.setText("");
            
    }
    }

    @FXML
    private void handleWithdrawAction(ActionEvent event) throws IOException {
        try {
            double worth = getapp() - getamt();
            if(worth >= 0) {
                setapp(worth);
                getbal();
            } else {
                amountlabel.setText("You dont have enough funds!");
                secondlabel.setText("");
            }
            
        }
        catch (NumberFormatException e) {
            amountlabel.setText("Enter a valid number");
            secondlabel.setText("");
        }
    }



    @FXML
    private void handleLogoutAction(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage logout = new Stage();
            logout.setScene(new Scene(root1));
            
            logout.show();
            Stage stage = (Stage) logoutbtn.getScene().getWindow();
            stage.close();
    }
    
    
    //BUG: Could not get ONLINE PURCHASE function to work. 
     @FXML
void handleOPAction(ActionEvent event) throws IOException{
    FXMLLoader fxml = new FXMLLoader(getClass().getResource("OPurchase.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage logout = new Stage();
            logout.setScene(new Scene(root1));
            
            logout.show();
            Stage stage = (Stage) opbtn.getScene().getWindow();
            stage.close();
    
        
        
    }
    
}



    
    



