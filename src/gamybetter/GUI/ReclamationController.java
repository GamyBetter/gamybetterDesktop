/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Reclamation;
import gamybetter.Services.ServicePersonne;
import gamybetter.Services.ServiceReclamation;
import gamybetter.Models.Personne;
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
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ReclamationController implements Initializable {

    @FXML
    private JFXTextField titre_reclamation;
    @FXML
    private JFXTextArea description_reclamation;
    @FXML
    private JFXTextField mail;

    /**
     * Initializes the controller class.
     */
    ServiceReclamation sr = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mail.setDisable(true);

        sr = new ServiceReclamation();

        int id_user = 0;
        id_user = CurrentUser.getCurrentUser();
        ServicePersonne sp = new ServicePersonne();
        Personne current = sp.getById(id_user);
        mail.setText(current.getEmail());

    }
private Stage stage;
    private Scene scene;
    @FXML
    private void safeReclamation(ActionEvent event) throws IOException {
        String titre = titre_reclamation.getText();
        String description = description_reclamation.getText();
        String email_sender = mail.getText();

        Reclamation r = new Reclamation(titre, description, email_sender);
        sr.ajouter(r);
         Parent root = FXMLLoader.load(getClass().getResource("ReclamationList.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
