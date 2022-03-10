/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Commentaire;
import gamybetter.Models.Publication;
import gamybetter.Services.ServiceCommentaire;
import gamybetter.Services.ServicePublication;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mariem
 */
public class ViewAllComntsController implements Initializable {
    @FXML
    private JFXListView<Commentaire> listVCom;
     @FXML
    private JFXTextField tfidcomnts;
      @FXML
    private JFXButton tfdelete;

    @FXML
    private JFXTextField tfidper;

    @FXML
    private JFXTextField tfdate;

    @FXML
    private JFXTextField tfcontCom;

    @FXML
    private JFXTextField tfidpublication;
        @FXML
    private ImageView btback;

    /**
     * Initializes the controller class.
     */
    ServiceCommentaire sc= new ServiceCommentaire();
     
    
    ObservableList<Commentaire> listCo = FXCollections.observableArrayList();   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       /*   Image icon=new Image("/gamybetter/Ressources");
       btback.setImage(icon);*/
        
        loadTableView();
    
    }   
     public void loadTableView() {
        
        
      listCo = FXCollections.observableArrayList(sc.getAll());
        listVCom.setItems(listCo);
         listVCom.setItems(listCo);
     }
     
     @FXML
    void Modifier(ActionEvent event) {
      int id_commentaire=Integer.parseInt(tfidcomnts.getText());
       int id_personne= Integer.parseInt(tfidper.getText());
      //int id_personne =Integer.parseInt("2");

      
// String date =tfdate.getText();
      
         String cont_commentaire =tfcontCom.getText();
         
         int id_publication= Integer.parseInt(tfidpublication.getText());
       
        // tfidper.setText(2);
           Commentaire c1=new Commentaire (id_commentaire,id_personne,cont_commentaire,id_publication);
         
        // c1.setId_personne(2);
          sc.modifier(c1);
          listVCom.getItems().set(listVCom.getSelectionModel().getSelectedIndex(), c1);
            
        

    }
    
     @FXML
    void onSelect(MouseEvent event) {
         listVCom.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Commentaire>() {

           @Override
           public void changed(ObservableValue<? extends Commentaire> observable, Commentaire oldValue, Commentaire newValue) {
               Commentaire ctable = listVCom.getSelectionModel().getSelectedItem();
        tfidcomnts.setText(Integer.toString(ctable.getIdCommentaire()));
        tfidper.setText(Integer.toString(ctable.getId_personne()));
        tfdate.setText(String.valueOf(ctable.getDate()));
        tfcontCom.setText(ctable.getCont_commentaire());
        tfidpublication.setText(Integer.toString(ctable.getId_publication()));
      
        
          
           }
         });
    
    }
                 

    @FXML
    void delete(ActionEvent event) {
        int id = listVCom.getSelectionModel().getSelectedItem().getIdCommentaire();

        //Publication p=new Publication (getId,id_personne,publication,titre,nbr_commentaire,date);
        sc.deleteById(id);

        for (int i = 0; i < listCo.size(); i++) {
            if (listCo.get(i).getIdCommentaire()== id) {
                listCo.remove(i);
            }
        }

    }
       @FXML
    void Goback(MouseEvent event) throws IOException {
Stage primaryStage = new Stage();
            Parent dashboard = FXMLLoader.load(getClass().getResource("ViewPublication.fxml"));
            
               Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
    }
    
}
