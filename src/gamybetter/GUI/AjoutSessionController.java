/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import gamybetter.GUI.popups.AlertBox;
import gamybetter.Models.ComboBoxItemWrap;
import gamybetter.Models.Cours;
import gamybetter.Models.Personne;
import gamybetter.Models.Session;
import gamybetter.Services.ServiceCours;
import gamybetter.Services.ServicePersonne;
import gamybetter.Services.ServiceSession;
import gamybetter.Utils.CurrentUser;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URL;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Modality;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skon1
 */
public class AjoutSessionController implements Initializable {

    private Stage stage;
    private Scene scene;
    ServicePersonne personneService = new ServicePersonne();
    ServiceSession sessionService = new ServiceSession();
    ServiceCours coursService = new ServiceCours();
    Personne pers;
    List<Personne> listCoaches = null;
    List<Cours> listCours = null;

    private JFXTextField duree;
    LocalDate localDate;
    @FXML
    private JFXTextField jeu;
    @FXML
    private JFXTextField categorie;
    @FXML
    private JFXTextField prix;
    @FXML
    private JFXComboBox<String> choicebox;
    //private JFXComboBox<ComboBoxItemWrap<Cours>> choiceboxcours;
    @FXML
    private JFXDatePicker date;
    @FXML
    private JFXTextField nom_session;
    @FXML
    private JFXTextField email_coach;
    ListView<String> listview = null;
    List<Cours> selected_cours = null;

       DateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    //works
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initializeVarirables();

        choicebox.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            int index = choicebox.getSelectionModel().getSelectedIndex();
            Personne p = listCoaches.get(index);
        });
        date.valueProperty().addListener((observable, oldDate, newDate) -> {
            System.out.println(newDate);
        });
    }

    //works
    public void initializeVarirables() {
        //a changer valeur du current user
        CurrentUser.setCurrentUser(1);

        pers = personneService.getById(CurrentUser.getCurrentUser());
        //get list coaches
        listCoaches = new ArrayList<>();
        personneService.getAll().stream().map((p) -> {
            return p;
        }).forEachOrdered((p) -> {
            listCoaches.add(p);
        });
        //get list cours
        listCours = coursService.getAll();
        listCours.forEach(e -> {
            System.out.println(e);
        });
        //initialize choicebox
        this.choicebox.getItems().clear();
        listCoaches.forEach((p) -> {
            choicebox.getItems().add(listCoaches.indexOf(p) + 1 + "- " + p.getEmail());

        });

        nom_session.setText("");
        email_coach.setText(pers.getEmail());
        email_coach.setDisable(true);
        duree.setText("");
        jeu.setText("");
        categorie.setText("");
        prix.setText("");
    }

    //works
    @FXML
    public void switchToSessionFXML(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SessionFXML.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //works
    @FXML
    private void ajouter(ActionEvent event) throws ParseException {
        Session s = new Session();

        int index = choicebox.getSelectionModel().getSelectedIndex();
        Personne p = index != -1 ? listCoaches.get(index) : new Personne();
        Field[] fields = Session.class.getDeclaredFields();
        System.out.println("fields length" + fields.length);
        for (Field e : fields) {
            s.setNom(nom_session.getText());
//            s.setDuree((Time)dateFormat.parse(duree.getText()));
            s.setEmail_joueur(p.getEmail());
            s.setEmail_coach(email_coach.getText());
            s.setJeu(jeu.getText());
            s.setCategorie(categorie.getText());
            s.setDaate(java.sql.Date.valueOf(date.getValue()));
            s.setPrix(Double.parseDouble(prix.getText()));

        }
        System.out.println(s);
        sessionService.ajouter(s);
        sessionService.getAll().forEach(e -> {
            System.out.println("-----------" + e);
        });
        Session ss = sessionService.getAll().stream().filter(e -> e.equals(s)).findFirst().get();
        System.out.println("ssss" + ss);
        listCours.forEach(e -> {
            e.setId_session(ss.getId());
            coursService.modifier(e);
        });
    }

    /*Session ss = sessionService.getAll().stream().filter(e -> e.equals(s)).findFirst().get();
        //ajout session aux cours selectionnés
        
    //control saisie entier
    //System.out.println(Integer.parseInt(duree.getText()));
    /*
        
        //controle saisie float
        

        
        System.out.println(s);*/
    //
    @FXML
    private void annuler(ActionEvent event) {
        initializeVarirables();
    }

    public boolean isNumber(String text) {
        return text.matches("^[0-9]+$");
    }

    @FXML
    private void selectCours(ActionEvent event) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ListView");
        window.setMinWidth(500);
        JFXButton button = new JFXButton("Submit");
        this.listCours.clear();
        this.listCours = new ArrayList<>();
        this.listview = new ListView<>();
        coursService.getAll().forEach((c) -> {
            listview.getItems().add(c.toString(1));
        });
        button.setOnAction(e -> {
            String message = "";
            ObservableList<String> coursSelectionnes;
            coursSelectionnes = listview.getSelectionModel().getSelectedItems();
            message = coursSelectionnes.stream().map((cours) -> cours + "\n").reduce(message, String::concat);
            this.listview.getSelectionModel().getSelectedIndices().forEach((i) -> {
                this.listCours.add(coursService.getAll().get(i));
            });
            this.listCours.forEach((a) -> {
            });

            window.close();
        });
        this.listview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(listview, button);
        Scene sceneList = new Scene(layout);
        window.setScene(sceneList);
        window.showAndWait();

    }

}
