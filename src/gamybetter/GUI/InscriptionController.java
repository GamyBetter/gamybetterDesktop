/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXPasswordField;
import gamybetter.Models.Personne;
import gamybetter.Utils.ControleSaisie;
import gamybetter.Services.ServicePersonne;
import java.awt.Insets;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class InscriptionController implements Initializable {

    @FXML
    private TextField nom_personne;
    @FXML
    private TextField contact;
    @FXML
    private TextField description;
    @FXML
    private TextField email;
    @FXML
    private JFXPasswordField mot_de_passe;
    @FXML
    private JFXPasswordField confirme;

    /**
     * Initializes the controller class.
     */
    ServicePersonne sp = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        sp = new ServicePersonne();

    }
    private Stage stage;
    private Scene scene;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    @FXML
    private void InscriptionPersonne(ActionEvent event) throws IOException {
        String nom = nom_personne.getText();
        String descriptionn = description.getText();
        int contactt = Integer.parseInt(contact.getText());
        String mail = email.getText();
        String password = mot_de_passe.getText();
        String confirmer = confirme.getText();
        if ( ! password.equals(confirmer)) {
            alert.setTitle("echec");
            alert.setHeaderText("mot de passe");
            alert.setContentText("mot de passe erroné");
          
        }
        else if (password.equals(confirmer) && ControleSaisie.validemail(mail)) {

            Personne p = new Personne(nom, contactt, descriptionn, mail, password);
            p.setRole("user");
            sp.ajouter(p);
            alert.setTitle("Success");
            alert.setHeaderText("Added");
            alert.setContentText("Person added successfully  !");

            Parent root = FXMLLoader.load(getClass().getResource("Connexion.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        alert.showAndWait();

    }

    

}
