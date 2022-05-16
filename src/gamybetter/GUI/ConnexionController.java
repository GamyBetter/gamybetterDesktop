/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXPasswordField;
import gamybetter.Models.Personne;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.ControleSaisie;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ConnexionController implements Initializable {

    @FXML
    private TextField mail;
    @FXML
    private JFXPasswordField password;
    ServicePersonne sp = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sp = new ServicePersonne();
    }
    private Stage stage;
    private Scene scene;

    @FXML
    private boolean verifyConnexion(ActionEvent event) throws IOException {
        String email = mail.getText();
        String passwordd = Encryption.crypt(password.getText());
        
        Personne p = new Personne(email, passwordd);

        for (Personne s : sp.getAll()) {

            if (s.equals(p) && ControleSaisie.validemail(email)) {

                CurrentUser.setCurrentUser(s.getId_personne());
                    if (s.getRole().equalsIgnoreCase("user")){
                        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                    else if (s.getRole().equalsIgnoreCase("admin")){
                        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
                        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    }
                System.out.println("Connected user !");
                

                return true;
            }
        }

        System.out.println("Invalid username,password");
        return false;
    }

    @FXML
    private void resetPassword(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("ResetPassword.fxml"));
                Stage stage = new Stage ();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }

    @FXML
    private void verifyConnexion(MouseEvent event) {
    }

   

}
