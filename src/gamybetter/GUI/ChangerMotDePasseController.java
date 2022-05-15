/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXPasswordField;
import gamybetter.Models.Personne;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.CurrentUser;
import gamybetter.Utils.Encryption;
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
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ChangerMotDePasseController implements Initializable {

    @FXML
    private JFXPasswordField newpassword;
    @FXML
    private JFXPasswordField confirmer;
    @FXML
    private JFXPasswordField oldPassword;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    int id_user = 0;
    ServicePersonne sp = new ServicePersonne();

    @FXML
    private void boutonRetour(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Profile.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void safeNewPassword(ActionEvent event) {
        String oldpass = Encryption.crypt(oldPassword.getText());
        String password = newpassword.getText();
        String confirme = confirmer.getText();
        id_user = CurrentUser.getCurrentUser();
        Personne current = sp.getById(id_user);
        if ((current.getMot_de_passe().equals(oldpass)) &&(password.equals(confirme)) ){
           current.setMot_de_passe(confirme);
            sp.modifier(current);
            alert.setTitle("confirmation");
            alert.setHeaderText("password");
            alert.setContentText("your password is changed successfully"); 
        }
        else  {
            alert.setTitle("echec");
            alert.setHeaderText("mot de passe");
            alert.setContentText("mot de passe erroné");
        }

         alert.showAndWait();
        
    }

}
