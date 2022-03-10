/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import gamybetter.Models.Evenement;
import gamybetter.Models.Personne;
import gamybetter.Services.ServiceEvenement;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
//import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;
import javafx.scene.input.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.glxn.qrgen.QRCode;

/**
 * FXML Controller class
 *
 * @author snoussi amine
 */
public class EvenementController implements Initializable {

    @FXML
    private JFXListView<?> listevents;
    @FXML
    private JFXButton BtnParticiper;

    private Personne participant;

    @FXML
    private JFXButton BtnGoBack;

    @FXML
    private ImageView qrIV;

    ServiceEvenement se = new ServiceEvenement();
    List<Evenement> ev = new ArrayList<>(se.getAll());
    ObservableList<Evenement> Events = FXCollections.observableArrayList(se.getAll());
    ListView<Evenement> listView = new ListView<Evenement>(Events);

    Personne membre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        /* if (UserSession.getInstance() != null) {
            membre = UserSession.getInstance().getUser();
        }*/
    }

    /*boolean verifParticipant() {
        if (participant == null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("vous devez d'abord vous connecter ?");
            alert.setContentText("vous devez d'abord vous connecter ?");
            ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
            ButtonType cancelButton = new ButtonType("cancel", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(okButton, cancelButton);

            if (alert.showAndWait().get() == okButton) {
                goLogin();
            }

            return true;
        }

        return false;
    }*/

 /*private void goLogin() {
        try {
            Parent root = FXMLLoader.
                    load(getClass().getResource("Connexion.fxml"));

            listevents.getScene().setRoot(root);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/
    @FXML
    private void participer(ActionEvent event) {

        JFrame f = new JFrame();

        int a = JOptionPane.showConfirmDialog(f, "Êtes-vous sûr?");
        if (a == JOptionPane.YES_OPTION) {
            System.out.println("-------------------");
            ServiceEvenement se = new ServiceEvenement();
            if (se.eventSature(1)) { //id user ()
                JOptionPane.showMessageDialog(null, "Evenement vient d'être saturé!");
            } else {
                //todo: changer le deuxieme parametre pour y mettre l'id du membre courant
                if (se.sinscrirEvenement(1, membre.getId_personne()) != 0) {
                    JOptionPane.showMessageDialog(null, "Inscription réussite! Vous serez informés de votre adversaire ultérieurement.");
                } else {
                    int b = JOptionPane.showConfirmDialog(f, "Vous êtes déjà inscrit! voulez vous annuler votre inscription?");
                }
            }
        }
    }

    @FXML
    public void loadListView() {

    }
    
    public void createQR(String Event) {
        // GENERATE QR CODE
        ByteArrayOutputStream out = QRCode.from(Event).to(ImageType.PNG).withSize(100, 100).stream();
        ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
        qrIV.setImage(new Image(in));
    }

}
