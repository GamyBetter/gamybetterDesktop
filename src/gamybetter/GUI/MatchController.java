/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Match;
import gamybetter.Outils.SendMail;
import gamybetter.Services.ServiceMatch;
import java.awt.event.MouseEvent;
import java.io.File;
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
import javafx.stage.FileChooser;
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
    private ImageView idvalorant;
    @FXML
    private Label radiobutton;
    @FXML
    private JFXTextField tfeq;
    @FXML
    private JFXTextField tfeq1;
    @FXML
    private JFXButton im1;
    @FXML
    private JFXButton im2;
    @FXML
    private JFXTextField tftemps;
    @FXML
    private JFXTextField tfim1;
    @FXML
    private JFXTextField tfim2;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     /*  Image im =new Image("/gamybetter/Ressources/valo.png");
    idvalorant.setImage(im);
     // idimage.setImage(img);*/
    
    cbduree.getItems().addAll(duree);
     
     
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
     
        String image1 = tfim1.getText();
        String image2 = tfim2.getText();
        String score = tfscore.getText();
        String lien_streaming = tflien.getText();
        String status = radio2.getText();
        String gold = tfgold.getText();
        String duree = cbduree.getValue();
        
     Date date= datedeb;
        String temps= tftemps.getText();
       //int id_equipe = Integer.parseInt(tfeq.getText());
       //int id_equipe1 = Integer.parseInt(tfeq1.getText());
        
if (tflien.getText().isEmpty() || tfgold.getText().isEmpty() || cbduree.getValue().isEmpty() )
{
    Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Veuillez remplir les champs!");
            alerts.show();
}else
{
        Match ma = new Match(image1,image2,score, lien_streaming, status, gold, duree, date, temps);
      
        ma.setId_equipe1(1);
        ma.setId_equipe2(1);
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

    @FXML
    private void im1(ActionEvent event) {
          FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfim1.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void im2(ActionEvent event) {
          FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfim2.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }
   
    
   

  
   
}

   
    

  

   
  

