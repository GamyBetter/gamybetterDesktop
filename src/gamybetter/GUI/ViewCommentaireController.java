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
import javafx.fxml.Initializable;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import gamybetter.Models.Commentaire;

import gamybetter.Services.ServiceCommentaire;
import java.io.IOException;

import java.util.Collections;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ViewCommentaireController implements Initializable {

    
    
      @FXML
    private JFXTextField nbrrCommtr;
    @FXML
    private JFXButton tfdelete;

    @FXML
    private JFXTextField idcomm;

    @FXML
    private JFXTextField idperson;

    private JFXTextField tfdate;

    @FXML
    private JFXTextField continu;
      @FXML
    private JFXListView<Commentaire> tftable;
       @FXML
    private ImageView btback;
    
    
    ServiceCommentaire sc = new ServiceCommentaire();

    ObservableList<Commentaire> listCu = FXCollections.observableArrayList();
    @FXML
    private JFXTextField id_pub;
       public void setIDPub(String id){
        
        id_pub.setText(id);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
     
       
        System.out.println("TEST TEST TEST"+id_pub.getText());
        //id_pub.setText("18");
        //String PUBIDgetted=id_pub.getText();/////////////////////////////////////////////////////////////////////////////////20
        int index =Integer.parseInt("7");
        listCu = FXCollections.observableArrayList(sc.getAllByID(index));
        //System.out.println(listCu);
        /*tfidcom.setCellValueFactory(new PropertyValueFactory<>("id_commentaire"));
        tfidPer.setCellValueFactory(new PropertyValueFactory<>("id_personne"));

        tfDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        tfContCom.setCellValueFactory(new PropertyValueFactory<>("cont_commentaire"));
*/
        tftable.setItems(listCu);
        
        int nbrecom=  tftable.getItems().size();
      
      nbrrCommtr.setText(Integer.toString(nbrecom));
      
      
          Image icon=new Image("/gamybetter/Ressources");
       btback.setImage(icon);
        
    }

    @FXML
    public void delete(ActionEvent event) {
        int id = tftable.getSelectionModel().getSelectedItem().getId_commentaire();

        sc.deleteById(id);

        for (int i = 0; i < listCu.size(); i++) {
            if (listCu.get(i).getId_commentaire() == id) {
                listCu.remove(i);
            }
        }
    }
    

    
    public void onSelect(MouseEvent mouseEvent) {
        
        Commentaire ctable = tftable.getSelectionModel().getSelectedItem();
       
        idcomm.setText(Integer.toString(ctable.getIdCommentaire()));
        idperson.setText(Integer.toString(ctable.getId_personne()));
        tfdate.setText(ctable.getDate().toString());
        continu.setText(ctable.getCont_commentaire());
        
       
       System.out.println(idcomm);
           System.out.println(idperson);
        
  
    

}
    
    @FXML
    void ModifierCom(ActionEvent event) {
       String date =tfdate.getText();
       String cont_commentaire =continu.getText();
    
    }
    
    
     @FXML
    void NombrCommentaire(ActionEvent event) {
      int nbrecom=  tftable.getItems().size();
      
      nbrrCommtr.setText(Integer.toString(nbrecom));
    }
    
      @FXML
    void AjouterCommentaire(ActionEvent event) throws IOException {
FXMLLoader loader;
          loader = new FXMLLoader(getClass().getResource("Commentaire.fxml"));
        Parent root = loader.load();
            
           
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    

    }
    
    @FXML
    void back(MouseEvent event) throws IOException {
Stage primaryStage = new Stage();
            Parent dashboard = FXMLLoader.load(getClass().getResource("ViewAllComnts.fxml"));
            
               Scene dashboardScene = new Scene(dashboard);
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(dashboardScene);
             //   window.setTitle("Gestion Produit");
                window.show();
    }
    
}
