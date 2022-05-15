/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import gamybetter.Models.Publication;
import gamybetter.Services.ServicePublication;
import java.io.IOException;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class ViewPublicationController implements Initializable {
    @FXML
    private JFXTextField tfidpub;

    @FXML
    private JFXTextField tfidpersonne;

    @FXML
    private JFXTextField tfPublication;

    @FXML
    private JFXTextField tftitre;

    @FXML
    private JFXTextField tfnbr_comm;

    @FXML
    private JFXTextField tfdate;
  
    
    /*@FXML 
    private Ranting tfAvis ;*/
    
@FXML 
private JFXTextField tfRecherche;
        
    private ImageView idImage;
    
            @FXML
    private JFXListView<Publication> tfListView;

    ServicePublication sp = new ServicePublication();

    ObservableList<Publication> listPu = FXCollections.observableArrayList();
    @FXML
    private JFXButton tfDelete;
    @FXML
    private JFXButton tfModifier;
    @FXML
    private JFXButton viewComents;
    @FXML
    private ImageView btback;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
         Image icon=new Image("/gamybetter/Ressources");
       btback.setImage(icon);
        loadTableView();
        
        
        

        /* FilteredList<Publication> fp =new FilteredList<>(listPu,b-> true);
         tftri.textProperty().addListener((observable, oldValue, newValue) -> {
         fp.setPredicate(Publication -> {
         if(newValue.isEmpty() || newValue==null){
         return true;
         }
         String inputsearch = newValue.toLowerCase();
         if (String.valueOf(Publication.getDate()).toLowerCase().indexOf(inputsearch) > -1){
         return  true;

         }if (String.valueOf(Publication.getPublication()).toLowerCase().indexOf(inputsearch) > -1){
         return  true;

         }
    
         else if (Publication.getPublication().toLowerCase().indexOf(inputsearch)> -1){
         return  true;
        

         }else
         return  false;
         });
         });
         */  
       
    }
        
     /* public void Ranting(){
          tfAvis.ratingProperty().addListener(new ChangeListener<Number>(){
              public void changed(ObservableValue<? extends Number>ov,Number old,Number newT){
                  
              
              tfmsg.setText("Avis"+newT);
              }
          });
          
      } */ 
        
    

    public void loadTableView() {
        

        listPu = FXCollections.observableArrayList(sp.getAll());
        tfListView.setItems(listPu);
      
        tfListView.setItems(listPu);
    }

    @FXML
    public void delete(ActionEvent event) {
        int id = tfListView.getSelectionModel().getSelectedItem().getId_Publication();

        //Publication p=new Publication (getId,id_personne,publication,titre,nbr_commentaire,date);
        sp.deleteById(id);

        for (int i = 0; i < listPu.size(); i++) {
            if (listPu.get(i).getId_Publication()== id) {
                listPu.remove(i);
            }
        }
    }
    @FXML
    public void onSelect(MouseEvent mouseEvent) {
       
       tfListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Publication>() {

           @Override
           public void changed(ObservableValue<? extends Publication> observable, Publication oldValue, Publication newValue) {
               Publication ctable = tfListView.getSelectionModel().getSelectedItem();
        tfidpub.setText(Integer.toString(ctable.getId_Publication()));
        System.out.println("!id pub "+tfidpub.getText());
        tfidpersonne.setText(Integer.toString(ctable.getId_personne()));
        tfPublication.setText(ctable.getPublication());
        tftitre.setText(ctable.getTitre());
        tfnbr_comm.setText(Integer.toString(ctable.getNbr_commentaire()));
        tfdate.setText(ctable.getDate());
           }

    });
        
        

      
  
    }
    
       @FXML
    void Modifier(ActionEvent event) {
        int id_publication=Integer.parseInt(tfidpub.getText());
        //int id_personne= Integer.parseInt(tfidpersonne.getText());
         String publication =tfPublication.getText();
         String titre =tftitre.getText();
         int nbr_commentaire= Integer.parseInt(tfnbr_comm.getText());
         String date =tfdate.getText();
           System.out.println(+id_publication+publication+titre+nbr_commentaire+date);
           Publication p1=new Publication (id_publication,publication,titre,nbr_commentaire);
         
         ServicePublication sp=new ServicePublication();
          sp.modifier(p1);
          
          tfListView.getItems().set(tfListView.getSelectionModel().getSelectedIndex(), p1);
        
          
     
    }

    @FXML
    private void goToComments(ActionEvent event) throws IOException {
        String id_pub =tfidpub.getText();
        FXMLLoader loader=new FXMLLoader(getClass().getResource("ViewCommentaire.fxml"));
        Parent root = loader.load();
           
            ViewCommentaireController vcc = loader.getController();

            vcc.setIDPub(id_pub);
           
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void back(MouseEvent event) throws IOException {
        
    Stage primaryStage = new Stage();
            Parent dashboard = FXMLLoader.load(getClass().getResource("Publication.fxml"));
            
               Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
          
   
          
          

    } 
    
    
   @FXML 
   void Recherche(ActionEvent event){
     List<Publication> CollectedList=listPu.stream().filter(cmd -> tfRecherche.getText().equals(String.valueOf(cmd.getTitre())))
   .collect(Collectors.toList());
     ObservableList<Publication> searchTitre=FXCollections.observableArrayList(CollectedList);
     tfListView.setItems(searchTitre);
     if (tfRecherche.getText().isEmpty()){
      loadTableView();   
     }
     
             }
}
