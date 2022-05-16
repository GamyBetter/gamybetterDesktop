/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gamybetter.GUI.popups.AlertBox;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Label;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import gamybetter.Services.ServiceCours;
import gamybetter.Models.Cours;
import gamybetter.Models.Personne;
import gamybetter.Models.Session;
import gamybetter.Services.ServicePersonne;
import gamybetter.Utils.CurrentUser;

import java.util.stream.Collectors;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author skon1
 */
public class CoursFXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;

    Stage window;
    BorderPane layout;
    //for selected informations
    Label skander;
    @FXML
    JFXTextField nom_coach;
    @FXML
    JFXTextField email_coach;
    @FXML
    JFXTextField categorie;
    @FXML
    JFXTextField jeu;
    @FXML
    JFXTextField prix;
    @FXML
    JFXTextField lien_session;
    @FXML
    Label nom_lien_session;
    @FXML
    JFXTextField rech;

    //listview
    @FXML
    JFXListView<String> listViewCours;

    List<Integer> listIds = new ArrayList();

    private ObservableList<Cours> cours = FXCollections.observableArrayList();

    ServiceCours coursService = new ServiceCours();
    ServicePersonne personneService = new ServicePersonne();
    @FXML
    private JFXButton modifierbtn;
    @FXML
    private JFXButton supprimerbtn;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CurrentUser.setCurrentUser(2);
        if(personneService.getById(CurrentUser.getCurrentUser()).getRole().equalsIgnoreCase("admin")==false){
            modifierbtn.setVisible(false);
            supprimerbtn.setVisible(false);
        }
        nom_lien_session.setVisible(true);
        lien_session.setVisible(true);
        coursService.getAll().forEach((c) -> {
            this.cours.add(c);
        });

        cours.forEach((c) -> {
            listViewCours.getItems().add("Coach : " + personneService.getById(c.getId_coach()).getNom_personne() + "\nJeu : " + c.getJeu() + "\nPrix : " + c.getPrix());
            listIds.add(c.getId());
        });
        listViewCours.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            System.out.println(newValue);
            int index = listViewCours.getSelectionModel().getSelectedIndex();
            onSelect(listIds.get(index));
        });

        rech.textProperty().addListener((observable, oldValue, newValue) -> {
            recherche();
        });

    }

    public boolean recherche() {
        ObservableList<Cours> cours_rech = FXCollections.observableArrayList();
        coursService.getAll().forEach((c) -> {
            cours_rech.add(c);
        });
        long count_jeu = cours_rech.stream().filter(t -> t.getJeu().toLowerCase().startsWith(this.rech.getText().toLowerCase())).count();
        long count_coach = cours_rech.stream().filter(t -> personneService.getById(t.getId_coach()).getNom_personne().toLowerCase().startsWith(this.rech.getText().toLowerCase())).count();
        if (count_coach != 0 && count_coach != this.cours.size()) {
            List<Cours> list = cours_rech.stream().filter(t -> personneService.getById(t.getId_coach()).getNom_personne().toLowerCase().startsWith(this.rech.getText().toLowerCase())).collect(Collectors.toList());
            listViewCours.getItems().clear();
            list.forEach((c) -> {
                listViewCours.getItems().add("Coach : " + personneService.getById(c.getId_coach()).getNom_personne() + "\nJeu : " + c.getJeu() + "\nPrix : " + c.getPrix());
                listIds.add(c.getId());
            });
            return true;
        } else if (count_jeu != 0 && count_coach != this.cours.size()) {
            List<Cours> list = cours_rech.stream().filter(t -> t.getJeu().toLowerCase().startsWith(this.rech.getText().toLowerCase())).collect(Collectors.toList());
            listViewCours.getItems().clear();
            list.forEach((c) -> {
                listViewCours.getItems().add("Coach : " + personneService.getById(c.getId_coach()).getNom_personne() + "\nJeu : " + c.getJeu() + "\nPrix : " + c.getPrix());
                listIds.add(c.getId());
            });
            return true;
        } else if (rech.getText().equals("")) {
            listViewCours.getItems().clear();
            cours.forEach((c) -> {
                listViewCours.getItems().add("Coach : " + personneService.getById(c.getId_coach()).getNom_personne() + "\nJeu : " + c.getJeu() + "\nPrix : " + c.getPrix());
                listIds.add(c.getId());
            });
            return true;
        }
        coursService.getAll().forEach((c) -> {
            this.cours.add(c);
        });

        listViewCours.getItems().clear();
        return false;
    }

    public void switchToAnotherScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Get all of the products
    public ObservableList<Cours> getCours() {

        ObservableList<Cours> cours = FXCollections.observableArrayList();
        coursService.getAll().forEach(e -> {
            cours.add(e);
        });
        return cours;
    }

    @FXML
    public void acheterCours() {
        nom_lien_session.setText("Lien de la session :");
        nom_lien_session.setVisible(true);
        lien_session.setVisible(true);

    }

    public void onSelect(int id) {
        Cours c = cours.stream().filter((t) -> t.getId() == id).findFirst().get();
        System.out.println(c + "cours recupéré");
        System.out.println(listViewCours.getSelectionModel().getSelectedItem() + "selected item");
        Personne p = personneService.getById(c.getId_coach());
        nom_coach.setText(p.getNom_personne());
        nom_coach.setDisable(true);
        email_coach.setText(p.getEmail());
        email_coach.setDisable(true);
        categorie.setText(c.getCategorie());
        jeu.setText(c.getJeu());
        prix.setText(Double.toString(c.getPrix()));
        lien_session.setText(c.getLien_session());
        nom_lien_session.setVisible(false);
        lien_session.setVisible(false);
    }

    @FXML
    public void switchToAjouterCours(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjoutCours.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void modifier(ActionEvent event) {
        try {
            if (listViewCours.getSelectionModel().getSelectedItem().isEmpty() == false) {
                Cours c = cours.get(listViewCours.getSelectionModel().getSelectedIndex());
                c.setCategorie(categorie.getText());
                c.setJeu(jeu.getText());
                c.setPrix(Double.parseDouble(prix.getText()));
                c.setLien_session(lien_session.getText());
                boolean up = coursService.modifier(c);
                AlertBox.display("Succès de mise a jour", "Votre cours est mis a jour");
                if (up) {
                    cours = getCours();
                    listViewCours.getItems().clear();
                    cours.forEach((cc) -> {
                        listViewCours.getItems().add("Coach : " + personneService.getById(cc.getId_coach()).getNom_personne() + "\nJeu : " + cc.getJeu() + "\nPrix : " + cc.getPrix());
                        listIds.add(cc.getId());
                    });
                }

            }
        } catch (NullPointerException ex) {
            AlertBox.display("Error", "no item selected !");
        }

    }

    @FXML
    private void supprimer(ActionEvent event) {
        try {
            if (listViewCours.getSelectionModel().getSelectedItem().isEmpty() == false) {
                Cours c = cours.get(listViewCours.getSelectionModel().getSelectedIndex());
                boolean up = coursService.supprimer(c);
                if (up) {
                    cours = getCours();
                    listViewCours.getItems().clear();
                    cours.forEach((cc) -> {
                        listViewCours.getItems().add("Coach : " + personneService.getById(cc.getId_coach()).getNom_personne() + "\nJeu : " + cc.getJeu() + "\nPrix : " + cc.getPrix());
                        listIds.add(cc.getId());
                    });
                }
            }
        } catch (NullPointerException ex) {
            AlertBox.display("Error", "no item selected !");
        }

    }

    @FXML
    private void Menu(MouseEvent event) {
        Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }

}
