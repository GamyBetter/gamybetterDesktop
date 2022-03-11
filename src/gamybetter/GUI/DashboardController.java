/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
<<<<<<< Updated upstream
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
=======
import gamybetter.Models.Panier;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
>>>>>>> Stashed changes
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class DashboardController implements Initializable {

    @FXML
    private AnchorPane root1;
    @FXML
    private Pane context;
    @FXML
    private JFXButton dtnDashBoard;

    /**
     * Initializes the controller class.
<<<<<<< Updated upstream
=======
     * @param url
     * @param rb
>>>>>>> Stashed changes
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
<<<<<<< Updated upstream
=======
        try{
            Parent root =FXMLLoader.load(getClass().getResource("ProductForm.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
>>>>>>> Stashed changes
    }    

    @FXML
    private void DashBoardOnAction(ActionEvent event) {
<<<<<<< Updated upstream
=======
         try{
            Parent root =FXMLLoader.load(getClass().getResource("market.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
>>>>>>> Stashed changes
    }

    @FXML
    private void btnAddCashier(ActionEvent event) {
<<<<<<< Updated upstream
=======
        
>>>>>>> Stashed changes
    }

    @FXML
    private void btnReportOnAction(ActionEvent event) {
    }

    @FXML
    private void btnAddCustomer(ActionEvent event) {
    }

    @FXML
    private void AddItemOnAction(ActionEvent event) {
    }

    @FXML
    private void btnSuplayerOnAction(ActionEvent event) {
    }

    @FXML
    private void btnLogOut(ActionEvent event) {
    }
    
}
