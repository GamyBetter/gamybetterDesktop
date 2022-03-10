/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Match;
import gamybetter.Outils.SendMail;
import gamybetter.Services.ServiceMatch;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.management.Notification;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author MAG028
 */
public class MatchController implements Initializable {
  
   @FXML
    private JFXTextField tfscore;

    @FXML
    private JFXTextField tflien;

    @FXML
    private JFXTextField tfgold;

    @FXML
    private JFXDatePicker datepicker;
    

    @FXML
    private JFXRadioButton radio1;

    @FXML
    private JFXRadioButton radio2;

    
     
     
 
    @FXML
    private JFXComboBox<String> cbduree;
    private String [] duree ={"15minutes" ,"20minutes","25minutes", "30minutes","35minutes"};
    @FXML
    private JFXComboBox<String> cbheros;
    private String [] heros ={   " Jett" , "Sova", "Viper","Chamber" ,"Astra","Cypher" ,"Raze", "Breach","Skye",
     };
    @FXML
    private ImageView idvalorant;
    @FXML
    private Button btnmodifier;
    @FXML
    private Label radiobutton;
    @FXML
    private JFXTextField tfeq;
    @FXML
    private JFXTextField tfeq1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*  Image im =new Image("/gamybetter/Ressources/valo.png");
    idvalorant.setImage(im);
     // idimage.setImage(img);*/
    
    cbduree.getItems().addAll(duree);
     cbheros.getItems().addAll(heros);
     
       //radiobutton.setText("");
       ToggleGroup favLangToggleGroup = new ToggleGroup();
        this.radio1.setToggleGroup(favLangToggleGroup);
        this.radio2.setToggleGroup(favLangToggleGroup);
      
    tfeq.setVisible(false);
    tfeq1.setVisible(false);
    
    
    }    

    @FXML
    private void ajoutermatch(ActionEvent event) throws Exception {
      
        
        
        ServiceMatch sm = new ServiceMatch();
       
       LocalDate localDateDeb = datepicker.getValue();
        
        Date datedeb = java.sql.Date.valueOf(localDateDeb);
     
       
       
        int score = Integer.parseInt(tfscore.getText());
        String lien_streaming = tflien.getText();
        String status = radio2.getText();
        String gold = tfgold.getText();
        String duree = cbduree.getValue();
        
     Date date= datedeb;
        String heros = cbheros.getValue();
       //int id_equipe = Integer.parseInt(tfeq.getText());
       //int id_equipe1 = Integer.parseInt(tfeq1.getText());
        
if (tflien.getText().isEmpty() || tfgold.getText().isEmpty() || cbduree.getValue().isEmpty() || cbheros.getValue().isEmpty() )
{
    Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Veuillez remplir les champs!");
            alerts.show();
}else
{
        Match ma = new Match(score, lien_streaming, status, gold, duree, date, heros);
      
        ma.setEquipe(7);
        ma.setId_equipe1(7);
        sm.ajouter(ma);
        
 
        String title = "Ajout Réussi";
        String message = "You've successfully created a new match";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        //tray.setAnimation(Animations.POPUP);
        tray.showAndDismiss(Duration.seconds(10));
        
        SendMail.sendMail("sourour.belghith@esprit.tn");
}
    }
      
        
        
   
   @FXML
    void affichermatch(ActionEvent event) throws IOException {
        
          Parent dashboard ;
                dashboard = FXMLLoader.load(getClass().getResource("ListeMatch.fxml"));


                Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();

    }
   
    
   

  
   
}

   
    

  

   
  

