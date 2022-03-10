/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXTextArea;
import gamybetter.Models.Personne;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ProfileController implements Initializable {

    @FXML
    private ImageView avatar;
    @FXML
    private JFXTextArea champDescription;
       @FXML
    private TextField role;

    /**
     * Initializes the controller class.
     */
    ServicePersonne sp = null;
 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sp = new ServicePersonne();
        int id_user = 0;
        id_user = CurrentUser.getCurrentUser();
        ServicePersonne sp = new ServicePersonne();
        Personne current = sp.getById(id_user);
        champDescription.setText(current.getDescription());
        role.setText(current.getRole());
    }
    private Stage stage;
    private Scene scene;

    @FXML
    public void changeView(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("Reclamation.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void reinitilasiserMotDePasse(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ChangerMotDePasse.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
