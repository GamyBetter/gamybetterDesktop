/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Actualite;
import gamybetter.Services.ServiceActualite;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author MAG028
 */
public class ActualiteController implements Initializable {
    @FXML
    private ImageView idimage;

    @FXML
    private JFXTextField tfimage;

    @FXML
    private JFXTextField tfvideo;
    @FXML
    private JFXTextField tfmatch;
    @FXML
    private JFXTextField tfpersonne;
    @FXML
    private JFXTextField tftitre;
    @FXML
    
    private JFXTextArea tadescription;
    @FXML
    private JFXDatePicker datepicker;
    

     @FXML
    private JFXComboBox<String> combojeu;
    private String [] duree ={"Valorant" ,"FIFA","LOL"};
    

    /**
     * Initializes the controller class.
     */
      ServiceActualite ac = new ServiceActualite ();
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image imageee =new Image("/gamybetter/Ressources/valo.png");
     idimage.setImage(imageee);
        // TODO
     tfmatch.setVisible(false);
     tfpersonne.setVisible(false);
     
    combojeu.getItems().addAll(duree);
     
    }    
      @FXML
     private void ajouteractualite() {
        
         LocalDate localDateDeb = datepicker.getValue();
        
        Date datedeb = java.sql.Date.valueOf(localDateDeb);
         
         
         
        String image = tfimage.getText();
        String video = tfvideo.getText();
         String jeu = combojeu.getValue();
         String titre = tftitre.getText();
        String description = tadescription.getText();
        
         Date date= datedeb;
        
        
    // int id_match = Integer.parseInt(tfmatch.getText());
    // int id_personne = Integer.parseInt(tfpersonne.getText());
        
       
         Alert alerts = new Alert(Alert.AlertType.WARNING);
        
       if (tfimage.getText().isEmpty() || tfvideo.getText().isEmpty()  )
{
   
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Veuillez remplir les champs!");
            alerts.show();
}else {
   
        Actualite a =new Actualite (/*id_match,id_personne,*/image, video,jeu,titre,description,date/*,,*/);
        
        a.setId_match(1);
        a.setId_personne(1);
        ac.ajouter(a);
        
         alerts.setTitle("Ajout");
            alerts.setHeaderText(null);
            alerts.setContentText("Ajout réussi!");
            alerts.show();
        
   } 
 
       
        
    
     }
    

    @FXML
    private void afficher(ActionEvent event) throws IOException {
        
          Parent dashboard ;
          dashboard = FXMLLoader.load(getClass().getResource("Showall.fxml"));


                Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
    }

   

    @FXML
    private void ajoutimg(ActionEvent event) {
         FileChooser fc = new FileChooser();
           FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
            FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
            FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfimage.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void ajoutervid(ActionEvent event) {
         FileChooser fc = new FileChooser();
           
          File file= fc.showOpenDialog(null);
          if(file != null){
              tfvideo.appendText(file.getAbsolutePath()+ "\n");
              
          } else{
              System.out.println("not valid");
                  }
    }

    @FXML
    private void Menu(MouseEvent event) {
         Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }
    
    
    
}
