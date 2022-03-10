/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXListView;
import gamybetter.Models.Reclamation;
import gamybetter.Services.ServiceReclamation;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class GestionReclamationController implements Initializable {

    @FXML
    private JFXListView<Reclamation> listReclamation;

    /**
     * Initializes the controller class.
     */
    ServiceReclamation sr = new ServiceReclamation();
    ObservableList<Reclamation> listrec = FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          listrec = FXCollections.observableArrayList(sr.getAll());
        listReclamation.setItems(listrec);
         listReclamation.setItems(listrec);    
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
