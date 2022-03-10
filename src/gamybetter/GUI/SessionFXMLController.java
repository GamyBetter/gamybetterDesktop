/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import gamybetter.Models.Cours;
import gamybetter.Models.Session;
import gamybetter.Services.ServiceCours;
import gamybetter.Services.ServiceSession;
import gamybetter.Utils.DataSource;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author skon1
 */
public class SessionFXMLController implements Initializable {

    Connection cnx = DataSource.getInstance().getCnx();

    ServiceCours coursService = new ServiceCours();
    ServiceSession sessionService = new ServiceSession();

    @FXML
    private JFXListView<String> list_sessions = new JFXListView<>();
    @FXML
    private JFXListView<String> liste_cours = new JFXListView<>();
    private ObservableList<Cours> cours = FXCollections.observableArrayList();
    ;
    private ObservableList<Session> session = FXCollections.observableArrayList();
    List<Cours> listCours = null;
    ListView<String> listview = null;

    /**
     * Initializes the controller class.
     */
    private Stage stage;
    private Scene scene;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        sessionService.getAll().forEach(e -> {
            session.add(e);
        });
        session.forEach((c) -> {
            list_sessions.getItems().add("Session " + c.getNom());
        });

        list_sessions.getSelectionModel().selectedItemProperty().addListener((v, oldValue, newValue) -> {
            int index = list_sessions.getSelectionModel().getSelectedIndex();
            cours.clear();
            liste_cours.getItems().clear();
            List<Cours> l = coursService.getAll().stream().filter(e -> e.getId_session() == session.get(index).getId()).collect(Collectors.toList());
            if (l.isEmpty()) {
                System.out.println("fergha");
            } else {
                l.forEach(e -> {
                    cours.add(e);
                });
            }
            if (cours.isEmpty() == false) {
                cours.forEach(e -> {
                    liste_cours.getItems().add(e.getEmail_coach() + "\n" + e.getJeu());
                });
            } else {
                System.out.println("fergha list cours");
            }

        });
    }

    @FXML
    private void selectCours(ActionEvent event) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ListView");
        window.setMinWidth(500);
        JFXButton button = new JFXButton("Submit");
        this.listCours = new ArrayList<>();
        this.listview = new ListView<>();
        coursService.getAll().stream().filter(e -> e.getId_session() == 0).collect(Collectors.toList()).forEach((c) -> {
            listview.getItems().add(c.toString(1));
        });
        button.setOnAction(e -> {
            String message = "";
            ObservableList<String> coursSelectionnes;
            coursSelectionnes = listview.getSelectionModel().getSelectedItems();
            //message = coursSelectionnes.stream().map((cc) -> cc + "\n").reduce(message, String::concat);
            this.listview.getSelectionModel().getSelectedIndices().forEach((i) -> {
                this.listCours.add(coursService.getAll().get(i));
            });
            this.listCours.forEach((a) -> {
                a.setId_session(session.get(list_sessions.getSelectionModel().getSelectedIndex()).getId());
                coursService.modifier(a);
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

    @FXML
    private void suppCours(ActionEvent event) {
        int index = liste_cours.getSelectionModel().getSelectedIndex();
        System.out.println(cours.get(index));
        Cours t = cours.get(index);
        String query_nocheck = "set foreign_key_checks=0";
        Statement st;
        try {
            st = cnx.createStatement();
            int rs = st.executeUpdate(query_nocheck);
            t.setId_session(0);
            coursService.modifier(t);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        String query_check = "set foreign_key_checks=1";
        try {
            Statement st1 = cnx.createStatement();
            int rs1 = st1.executeUpdate(query_check);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    @FXML
    public void switchToCreerSession(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AjoutSession.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
