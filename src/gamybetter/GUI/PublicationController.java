/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import gamybetter.Models.Publication;
import gamybetter.Outils.Outils;
import gamybetter.Services.ServicePublication;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class PublicationController {//implements Initializable {

    @FXML
    private ImageView idavatr;

    @FXML
    private ImageView idImage;

    @FXML
    private JFXButton tfPublier;

    @FXML
    private JFXTextArea tfPublic;

    @FXML
    private TextField tfidpublication;

    @FXML
    private Text errPublication;

    /*  @FXML
     private JFXComboBox<String> tfchoix;
     private String [] Titre={"VALO","FIFA","LOL"};*/
    @FXML
    private JFXDatePicker tfDate;

    @FXML
    private JFXTextField tfTitre;

    @FXML
    private JFXTextField tfNbrCom;
    private ImageView btback;
    @FXML
    private JFXTextField tfidPers;

    @FXML
    private JFXTextField tfphoto;
     @FXML
    private JFXButton idImage1;

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {

        Image imabak = new Image("/gamybetter/Ressources");
        idImage.setImage(imabak);
        Image avatar = new Image("/gamybetter/Ressources");
        idavatr.setImage(avatar);
        Image icon = new Image("/gamybetter/Ressources");
        btback.setImage(icon);
      // tfchoix.getItems().addAll(Titre);

        tfidPers.setText("1");

    }

    @FXML
    void PublierPub(ActionEvent event) {
        //  int id_personne= Integer.parseInt( tfidPers.getText());
        String publication = tfPublic.getText();
        String titre = tfTitre.getText();
        String image = tfphoto.getText();
//String titre = tfchoix.getValue();
// int nbr_commentaire= Integer.parseInt(tfNbrCom.getText());

        LocalDate date = tfDate.getValue();

        if (tfPublic.getText().isEmpty() || tfTitre.getText().isEmpty()) {
            Alert alerts = new Alert(Alert.AlertType.WARNING);
            alerts.setTitle("Warning");
            alerts.setHeaderText(null);
            alerts.setContentText("Veuillez remplir les champs!");
            alerts.show();

        } else {
            /* Publication p=new Publication (publication,titre,nbr_commentaire,date);
         
             ServicePublication sp=new ServicePublication();
             sp.ajouter(p);
             System.out.println(p);*/

            String publicattionTXT = tfPublic.getText();
            /* if(publicattionTXT.length()==1){
             errPublication.setText("message incomplet ");
             errPublication.setVisible(true);
             return ;
             }*/
            if (Outils.containsBadWords((publicattionTXT))) {
                JOptionPane.showMessageDialog(null, "Cet Avis ne respecte pas nos standards de la communauté en matière de contenus indésirables");
                return;

            }

            Publication p = new Publication(publication, titre, image);

            ServicePublication sp = new ServicePublication();
            p.setId_personne(1);
            sp.ajouter(p);

            try {
                Stage primaryStage = new Stage();
                Parent dashboard = FXMLLoader.load(getClass().getResource("ViewPublication.fxml"));

                Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
                //   window.setTitle("Gestion Produit");
                window.show();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("ena lenna");
            }
        }

    }

    /*  @FXML
     void Update(ActionEvent event) {

     int id_personne= Integer.parseInt(tfidPer.getText());
     String publication =tfPublic.getText();
     String titre =tfTitre.getText();
     int nbr_commentaire= Integer.parseInt(tfNbrCom.getText());
     String date =tfDate.getText();
         

    
     Publication p1=new Publication (id_personne,publication,titre,nbr_commentaire,date);
         
     ServicePublication sp=new ServicePublication();
     sp.update(p1);
          
          
     try {
     Stage primaryStage = new Stage();
     Parent root = FXMLLoader.load(getClass().getResource("ViewPublication.fxml"));
            
     Scene scene = new Scene(root);
     primaryStage.setMaximized(true);
     primaryStage.setTitle("ViewPiblication");
     primaryStage.setScene(scene);
     primaryStage.show();
     } catch (IOException ex) {
     System.out.println(ex.getMessage());
     }
          
          
          
     }
     */
    void Modifier(ActionEvent event) {
        int id_publication = Integer.parseInt(tfidpublication.getText());
        //int id_personne= Integer.parseInt(tfidPer.getText());
        String publication = tfPublic.getText();
        String titre = tfTitre.getText();
        int nbr_commentaire = Integer.parseInt(tfNbrCom.getText());
        LocalDate date = tfDate.getValue();

        Publication p = new Publication(id_publication, publication, titre, nbr_commentaire, date);

        ServicePublication sp = new ServicePublication();
        sp.modifier(p);

        try {
            Stage primaryStage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("ViewPublication.fxml"));

            Scene scene = new Scene(root);
            primaryStage.setMaximized(true);
            primaryStage.setTitle("ViewPiblication");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    @FXML
    void SelectImage(ActionEvent event) {

        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter ext1 = new FileChooser.ExtensionFilter("JPG files(.jpg)", ".jpg");
        FileChooser.ExtensionFilter ext2 = new FileChooser.ExtensionFilter("JPEG files(.jpeg)", ".jpeg");
        FileChooser.ExtensionFilter ext3 = new FileChooser.ExtensionFilter("PNG files(.png)", ".png");
        File file = fc.showOpenDialog(null);
        if (file != null) {
            tfphoto.appendText(file.getAbsolutePath() + "\n");

        } else {
            System.out.println("not valid");
        }

    }
    
   
}
