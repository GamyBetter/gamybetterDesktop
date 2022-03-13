/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import gamybetter.Models.Commentaire;
import gamybetter.Outils.Outils;
import gamybetter.Services.ServiceCommentaire;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class CommentaireController implements Initializable {
    private TextField tfidPeid_pubrs1;
    @FXML
    private TextField tfidPers1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tfidPers.setVisible(false);
        tfidPers.setText("2");
        
        //Image imabak=new Image("/gamybetter/Ressources/valorant.jpg");
       //idImage.setImage(imabak);
       
      // Image avatar= new Image("/gamybetter/Ressources/Avatar.jpg");
     //  idavatr.setImage(avatar);

     
        // TODO
    }    
    
 


    @FXML
    private JFXTextArea tfcontCom;

    @FXML
    private JFXDatePicker ftDAte;

    @FXML
    private TextField tfidPers;
      
        @FXML
    private ImageView idImage;
    private ImageView idavatr;
    
    

              
               ServiceCommentaire sc=new ServiceCommentaire();
    @FXML
    void AjouterCommentaire(ActionEvent event) throws IOException {
        
           int id_personne= Integer.parseInt(tfidPers.getText());
             LocalDate  date =ftDAte.getValue();
         String cont_commentaire =tfcontCom.getText();
       
        
         
            
        
         if(tfcontCom.getText().isEmpty()){
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Veuillez remplir les champs!");
            alerts.show();    
         }
         
         String publicattionTXT=tfcontCom.getText();
         if(Outils.containsBadWords((publicattionTXT))){
             JOptionPane.showMessageDialog(null, "Cet Avis ne respecte pas nos standards de la communauté en matière de contenus indésirables");
            return;
             
         }
         else{
             Commentaire c=new Commentaire (id_personne,date,cont_commentaire);
          c.setId_personne(2);
         sc.ajouter(c);
         String title = "Ajout Réussi";
        String message = "You've successfully created a new Comnt ";
        TrayNotification tray = new TrayNotification();
        tray.setTitle(title);
        tray.setMessage(message);
        tray.showAndWait();
        tray.setRectangleFill(Paint.valueOf("#2A9A84"));
        //tray.setAnimation(Animations.POPUP);
        tray.showAndDismiss(Duration.seconds(3));
          System.out.println(c);
             
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ViewAllComnts.fxml"));
        Parent root = loader.load();
            
           
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
         }
         
            
         
    

    }
    
    
   /* @FXML
    void Modifier(ActionEvent event) {
        int id_commentaire=Integer.parseInt(tfidPeid_pubrs1.getText());
         int id_personne= Integer.parseInt(tfidPers.getText());
             LocalDate date =ftDAte.getValue();
         String cont_commentaire =tfcontCom.getText();
         
         Commentaire c=new Commentaire (id_commentaire,id_personne,date,cont_commentaire);
        
         sc.modifier(c);
         
          try {
           Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewPublication.fxml"));
            
            Scene scene = new Scene(root);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("ViewCommentaire");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
          

    }*/
}
