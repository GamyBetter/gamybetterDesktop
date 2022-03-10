/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Personne;
import gamybetter.Services.ServicePersonne;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class GestionUtilisateurController implements Initializable {

    @FXML
    private JFXListView<Personne> listUsers;
   
    @FXML
    private JFXTextField champNom;
    @FXML
    private JFXTextField champRole;
    @FXML
    private JFXTextField champMail;
    @FXML
    private JFXTextField champContact;

    /**
     * Initializes the controller class.
     */
     ServicePersonne sp = new ServicePersonne();
     ObservableList<Personne> listPer = FXCollections.observableArrayList();   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listPer = FXCollections.observableArrayList(sp.getAll());
        listUsers.setItems(listPer);
         listUsers.setItems(listPer);    
         
    }    
    
    @FXML
    private void upDate(ActionEvent event) {
        String nom = champNom.getText();
        String role = champRole.getText();
        String mail = champMail.getText();
        int contact = Integer.parseInt(champContact.getText());
        Personne p = listUsers.getSelectionModel().getSelectedItem();
         
         p.setNom_personne(champNom.getText());
         p.setRole(champRole.getText());
         p.setEmail(champMail.getText());
         p.setContact(Integer.parseInt(champContact.getText()));
         
         sp.modifier(p);
         listPer = FXCollections.observableArrayList(sp.getAll());
         listUsers.getItems().set(listUsers.getSelectionModel().getSelectedIndex(), p);
         
         
                    
        
    }

    @FXML
    private void delete(ActionEvent event) {
        String nom = champNom.getText();
        String role = champRole.getText();
        String mail = champMail.getText();
        int contact = Integer.parseInt(champContact.getText());
        Personne p = listUsers.getSelectionModel().getSelectedItem();
        sp.supprimer(p);
         listUsers.getItems().remove(listUsers.getSelectionModel().getSelectedItem());
        ObservableList<Personne> UpdatedListView = listUsers.getItems();
        listUsers.setItems(UpdatedListView);
         
         
        
    }

    @FXML
    private void onSelect(MouseEvent event) {
        listUsers.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Personne>() {
            @Override

            public void changed(ObservableValue<? extends Personne> arg0, Personne arg1, Personne arg2) {

                Personne p = listUsers.getSelectionModel().getSelectedItem();
                    
                    champNom.setText(p.getNom_personne());
                    champRole.setText(p.getRole());
                    champMail.setText(p.getEmail());
                    champContact.setText(Integer.toString(p.getContact()));
                    
    }
        });
    }

    @FXML
    private void boutonRetour(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("AcceuilAdmin.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
