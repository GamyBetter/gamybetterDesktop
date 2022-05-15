/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import animatefx.animation.FadeIn;
import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    private ImageView logo;
    @FXML
    private JFXButton commandeonACtion;
    @FXML
    private JFXButton EventonAction;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        Image imabak=new Image("/gamybetter/Ressources/gamybetterlogo.png");
       logo.setImage(imabak);
        try{
            Parent root =FXMLLoader.load(getClass().getResource("DefaultBackOffice.fxml"));
            context.getChildren().removeAll();
            context.getChildren().setAll(root);
        } catch (IOException ex) {
           ex.getMessage();
        }
    }    

    private void setUi(String location) throws IOException {
        context.getChildren().clear();
        context.getChildren().add(FXMLLoader.load(this.getClass().
                getResource(location + ".fxml")));
    }

    @FXML
    private void btnLogOut(ActionEvent event) {
        Stage stage = (Stage) context.getScene().getWindow();
       stage.close();
    }

    private void UsersOnAction(ActionEvent event) throws IOException {
        setUi("Inscription");
        new FadeIn(context).play();
      
    }

    @FXML
    private void HomePage(ActionEvent event) throws IOException {
        setUi("Home");
        new FadeIn(context).play();
      
    }

    @FXML
    private void Services(ActionEvent event) throws IOException {
        setUi("ProductForm");
        new FadeIn(context).play();
    }

    @FXML
    private void Sessions(ActionEvent event) throws IOException {
        setUi("SessionFXML");
        new FadeIn(context).play();
 
    }
    @FXML
    private void Cours(ActionEvent event) throws IOException {
        setUi("CoursFXML");
        new FadeIn(context).play();
    
    }

    @FXML
    private void Events(ActionEvent event) throws IOException {
        setUi("GestionTournois");
        new FadeIn(context).play();
  
    }

    @FXML
    private void Blog(ActionEvent event) throws IOException {
        setUi("Publication");
        new FadeIn(context).play();
  
    }

    @FXML
    private void Match(ActionEvent event) throws IOException {
        setUi("Match");
        new FadeIn(context).play();
      
        
    }

    @FXML
    private void Commande(ActionEvent event) throws IOException {
        setUi("CommandForm");
        new FadeIn(context).play();
    }

    @FXML
    private void Actuali(ActionEvent event) throws IOException {
        setUi("Actualite");
        new FadeIn(context).play();
    }
    
}
