/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import gamybetter.GUI.popups.AlertBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import gamybetter.Models.Cours;
import gamybetter.Models.Personne;
import gamybetter.Services.ServiceCours;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.DataSource;
import gamybetter.Utils.HostAPI;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * FXML Controller class
 *
 * @author skon1
 */
public class AjoutCoursController implements Initializable {

    Connection cnx = DataSource.getInstance().getCnx();

    private Matcher matcher;
    private final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String CAT_JEU_PATTERN = "";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;

    ServiceCours coursService = null;
    ServicePersonne personneService = null;

    String choosen_coach1 = null;

    @FXML
    JFXTextField email_coach1 = null;

    @FXML
    JFXTextField categorie1 = null;

    @FXML
    JFXTextField jeu1 = null;

    @FXML
    JFXTextField prix1 = null;

    @FXML
    JFXTextField lien_session1 = null;

    List<Personne> listCoaches = null;
    List<Integer> listIds = null;
    @FXML
    JFXComboBox<String> choicebox1 = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeVariables();
        coursService = new ServiceCours();
        personneService = new ServicePersonne();

        //ChoiceBox
        listCoaches = new ArrayList();
        personneService.getAll().stream().map((p) -> {
            return p;
        }).forEachOrdered((p) -> {
            listCoaches.add(p);
            System.out.println(p);
        });
////////////////////////////////////////////
        listCoaches.forEach((p) -> {
            choicebox1.getItems().add(listCoaches.indexOf(p) + 1 + "- " + p.getNom_personne());

        });
        //add selected item properties to labels
        choicebox1.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            choosen_coach1 = newValue;
            int index = choicebox1.getSelectionModel().getSelectedIndex();
            Personne p = listCoaches.get(index);
            System.out.println(p.getId_personne() + " personne s??lectionn??e");
            email_coach1.setText(p.getEmail());
            choosen_coach1 = listCoaches.get(listCoaches.indexOf(p)).getNom_personne();
            System.out.println(choosen_coach1 + " " + listCoaches.get(listCoaches.indexOf(p)).getId_personne());

        });

        //----------------------------------------------
    }

    public void initializeVariables() {

        choosen_coach1 = "";
        email_coach1.setText("");
        email_coach1.setDisable(true);
        categorie1.setText("");
        jeu1.setText("");
        prix1.setText("");
        lien_session1.setText("");

    }

    public JFXComboBox<String> initializeChoicebox() {

        choicebox1.valueProperty().set(null);
        choicebox1.getSelectionModel().clearSelection();
        choicebox1.getItems().clear();
        listCoaches.forEach((p) -> {
            choicebox1.getItems().add(p.getNom_personne());
        });
        return choicebox1;
    }

    @FXML
    public void annuler() {
        choosen_coach1 = "";
        email_coach1.setText("");
        categorie1.setText("");
        jeu1.setText("");
        prix1.setText("");
        lien_session1.setText("");
        choicebox1 = initializeChoicebox();

    }

    @FXML
    public void Creer() {
        Cours c = new Cours();
        Boolean ajout = false;

        //Personne p = listCoaches.stream().filter(t -> t.getNom_personne().equals(choosen_coach1)).findFirst().get()
        if (choicebox1.getSelectionModel().getSelectedIndex() == -1) {
            AlertBox.display("Ajout du cours", "vous devez choisir un coach");
        } else {
            try {
                if (choosen_coach1.isEmpty()) {
                    AlertBox.display("Ajout du cours", "Veillez choisir un coach");
                } else if (categorie1.getText().isEmpty()) {
                    AlertBox.display("Ajout du cours", "Veillez remplir le champ categorie");
                } else if (jeu1.getText().isEmpty()) {
                    AlertBox.display("Ajout du cours", "Veillez remplir le champ jeu");
                } else if (prix1.getText().isEmpty()) {
                    AlertBox.display("Ajout du cours", "Veillez remplir le champ prix");
                } else if (isNumeric(prix1.getText()) == false) {
                    AlertBox.display("Ajout du cours", "Le prix doit etre un entier");
                } else {
                    int index = choicebox1.getSelectionModel().getSelectedIndex();
                    Personne p = listCoaches.get(index);
                    c.setId_coach(choosen_coach1 == null ? null : p.getId_personne());
                    c.setEmail_coach(email_coach1 == null ? null : email_coach1.getText());
                    c.setCategorie(categorie1 == null ? null : categorie1.getText());
                    c.setJeu(jeu1 == null ? null : jeu1.getText());
                    c.setPrix(prix1 == null ? null : validPrix(prix1.getText()) ? Double.parseDouble(prix1.getText()) : 0);
                    c.setLien_session(lien_session1 == null ? null : lien_session1.getText());
                    c.setId_session(0);
                    c.setListe_personnes("skander,amir");

                    String myIp = "";
                    Boolean listbol = false;
                    try {
                        myIp = HostAPI.sendGETURLINFO("https://www.javatpoint.com/java-string-to-boolean", "skanderg", "8hiwbmwOn1zJ5ryMzhnieTZx2TbsyA6zbUFWPQwKkacm0NKJ");
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    try {
                        if (myIp.length() > 0) {
                            listbol = HostAPI.sendGET(myIp, "skanderg", "8hiwbmwOn1zJ5ryMzhnieTZx2TbsyA6zbUFWPQwKkacm0NKJ");
                        }

                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    if (listbol == true) {
                        AlertBox.display("Error", "Lien de la session est susceptible");
                    } else {
                        System.out.println(listbol);
                        ajout = true;

                    }
                    if (ajout == true) {

                        String query_nocheck = "set foreign_key_checks=0";
                        Statement st;
                        try {
                            st = cnx.createStatement();
                            int rs = st.executeUpdate(query_nocheck);
                            coursService.ajouter(c);
                            AlertBox.display("Ajout du cours", "Cours ajout?? avec succ??s");
                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());                        }

                        String query_check = "set foreign_key_checks=1";
                        Statement st1;
                        try {
                            st1 = cnx.createStatement();
                            int rs1 = st1.executeUpdate(query_check);

                        } catch (SQLException ex) {
                            System.out.println(ex.getMessage());
                        }

                    }

                }
                annuler();
            } catch (NumberFormatException ex) {

                AlertBox.display("Ajout du cours", "Op??ration refus??e, v??rifier vos donn??es et r??essayer!!!");

            } finally {
                initializeChoicebox();
                initializeVariables();
            }
        }

    }

    public boolean validemail(String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }

    public boolean validPrix(String prix) {
        return prix.matches("^[0.00-9.99]+$") && prix.length() < 999999;
    }

    @FXML
    public void switchToCoursFXML(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("CoursFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}
