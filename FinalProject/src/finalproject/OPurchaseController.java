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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nihar, Niharika Shetty 500754054
 */
public class OPurchaseController  {

    @FXML
    private TextField amountfield;

    @FXML
    private Label purchaselabel;

    @FXML
    private Button purchasebtn;

    @FXML
    private Button backbtn;
    
    @FXML
            private Button calcbtn;
    
    CustomerPageController c;
    boolean at = false;
    double fee=0;

    @FXML
    void handleBackAction(ActionEvent event) throws IOException {
FXMLLoader fxml = new FXMLLoader(getClass().getResource("CustomerPage.fxml"));
            Parent root1 = (Parent) fxml.load();
            Stage managerpage = new Stage();
            managerpage.setScene(new Scene(root1));
            managerpage.show();
            Stage stage = (Stage) backbtn.getScene().getWindow();
            stage.close();
    }
    public void initiald(CustomerPageController c) throws IOException {
        this.c = c;
        if(c.getlvl().equals("Silver")) {
            fee=20;
        } else if(c.getlvl().equals("Gold")) {
            fee= 10;
        }
    }
    
    @FXML
    void handleCalculateAction (ActionEvent event) {
        if(amountfield.getText().isEmpty()){
            purchaselabel.setText("Error");
        }
        
        try {
            double amt= Double.parseDouble(amountfield.getText());
                    
            purchaselabel.setText("$"+(fee+amt));
            at = true;
        } catch(NumberFormatException ex) {
            purchaselabel.setText("Error");
        }
    }
    @FXML
    void handlePurchaseAction(ActionEvent event) {
            try {
                if(at) {
                    double amt = Double.parseDouble(amountfield.getText());
                    double tot = amt + fee;
                    c.OPurchase(tot);
                    purchaselabel.setText("Purchase Successful");
                } else {
                    purchaselabel.setText("Calculate Cost First");
                } } catch(IllegalArgumentException e) {
                        purchaselabel.setText("Not allowed");
                        }
                
            }
    } 
    

