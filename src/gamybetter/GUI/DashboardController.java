/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try{
            Parent root =FXMLLoader.load(getClass().getResource("DefaultBackOffice.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }    


    @FXML
    private void btnLogOut(ActionEvent event) {
    }

    @FXML
    private void UsersOnAction(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("Inscription.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void HomePage(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("Home.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void Services(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("Services.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void Sessions(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("SessionFXML.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }
    @FXML
    private void Cours(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("CoursFXML.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void Events(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("GestionTournois.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void Blog(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("Publication.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }

    @FXML
    private void Match(ActionEvent event) {
        try{
            Parent root =FXMLLoader.load(getClass().getResource("Match.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
        
    }
    
}
