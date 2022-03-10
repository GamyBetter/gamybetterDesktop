/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Evenement;
import gamybetter.Services.ServiceEvenement;
import java.io.IOException;
import java.net.URL;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author snoussi amine
 */
public class EvenementFormController implements Initializable {

    @FXML
    private JFXTextField tfidprop;
    @FXML
    private JFXTextField tfnbeq;
    @FXML
    private JFXTextField tfnomevent;
    @FXML
    private JFXTextField tfprix;
    @FXML
    private JFXDatePicker tfdatedeb;
    @FXML
    private JFXDatePicker tfdatefin;
    @FXML
    private JFXListView<Evenement> Eventss;
    @FXML
    private JFXTextField tfdescevent;
    @FXML
    private JFXTextField tflisteequipe;
    @FXML
    private JFXTextField tfetat;
    @FXML
    private JFXButton BtnADD;
    @FXML
    private JFXButton BtnUpdate;
    @FXML
    private JFXButton BtnDelete;
    @FXML
    private JFXTextField tfidevent;

    ServiceEvenement se = new ServiceEvenement();
    List<Evenement> ev = new ArrayList<>(se.getAll());
    ObservableList<Evenement> listevents = FXCollections.observableArrayList(se.getAll());

    ListView<Evenement> listView = new ListView<Evenement>(listevents);
    @FXML
    private JFXButton BtnLoad;
    @FXML
    private JFXButton BtnGoBack;

    /**
     * Initializes the controller class.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfidevent.setVisible(false);
        loadListView();
    }
    private GestionTournois main;

    @FXML
    private void goBack() throws IOException {
        main.showMainItems();

    }

    @FXML
    private void AddEvent(ActionEvent event) {
        try {
            if (!(tfidprop.getText().isEmpty() || tfnbeq.getText().isEmpty() || tfnomevent.getText().isEmpty() || tfdescevent.getText().isEmpty() || tfdatedeb.getValue().toString().isEmpty() || tfdatefin.getValue().toString().isEmpty() || tfprix.getText().isEmpty() || tfetat.getText().isEmpty() || tflisteequipe.getText().isEmpty())) {

                // int id_event = Integer.parseInt(tfidevent.getText());
                //tfidevent.setVisible(false);
                LocalDate localDateDeb = tfdatedeb.getValue();
                LocalDate localDateFin = tfdatefin.getValue();
                Date datedeb = java.sql.Date.valueOf(localDateDeb);
                Date datefin = java.sql.Date.valueOf(localDateFin);
                int id_proprietaire = Integer.parseInt(tfidprop.getText());
                int nb_eq = Integer.parseInt(tfnbeq.getText());
                String Nom_event = tfnomevent.getText();
                String description_event = tfdescevent.getText();
                Date date_debut_event = datedeb;
                Date date_fin_event = datefin;
                float prix = Float.parseFloat(tfprix.getText());
                int etat = Integer.parseInt(tfetat.getText());
                String liste_equipe = tflisteequipe.getText();
                Evenement e = new Evenement(/*id_event,*/id_proprietaire, nb_eq, Nom_event, description_event, date_debut_event, date_fin_event, prix, etat, liste_equipe);
                se.ajouter(e);
                Eventss.getItems().add(e);
                ObservableList<Evenement> UpdatedListView = Eventss.getItems();
                Eventss.setItems(UpdatedListView);

                int ret = 1;
                if (ret == 0) {
                    JOptionPane.showMessageDialog(null, "Erreur evenement non ajouter");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
        }
        // System.out.println(Eventss);
    }

    @FXML
    private void UpdateEvent(ActionEvent event) {

        // int id_event = Integer.parseInt(tfidevent.getText());
        LocalDate localDateDeb = tfdatedeb.getValue();
        LocalDate localDateFin = tfdatefin.getValue();
        Date datedeb = java.sql.Date.valueOf(localDateDeb);
        Date datefin = java.sql.Date.valueOf(localDateFin);
        int id_proprietaire = Integer.parseInt(tfidprop.getText());
        int nb_eq = Integer.parseInt(tfnbeq.getText());
        String Nom_event = tfnomevent.getText();
        String description_event = tfdescevent.getText();
        Date date_debut_event = datedeb;
        Date date_fin_event = datefin;
        float prix = Float.parseFloat(tfprix.getText());
        int etat = Integer.parseInt(tfetat.getText());
        String liste_equipe = tflisteequipe.getText();
        Evenement e = new Evenement(/*id_event, */id_proprietaire, nb_eq, Nom_event, description_event, date_debut_event, date_fin_event, prix, etat, liste_equipe);
        se.modifier(e);
        Eventss.getItems().set(Eventss.getSelectionModel().getSelectedIndex(), e);
        JOptionPane.showMessageDialog(null, "evenement modifier");
    }

    @FXML
    private void DeleteEvent(ActionEvent event) {
        int id_event = Eventss.getSelectionModel().getSelectedItem().getId_event();
        Evenement e = se.getById(id_event);

        //tfidevent.setVisible(false);
        // DefaultTxtFields();
        int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this event", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("Yes Selected");
            se.supprimer(e);
            Eventss.getItems().remove(Eventss.getSelectionModel().getSelectedItem());
            ObservableList<Evenement> UpdatedListView = Eventss.getItems();
            Eventss.setItems(UpdatedListView);
            JOptionPane.showMessageDialog(null, "evenement supprimer");
        }
        else if(res == JOptionPane.NO_OPTION){
          System.out.println("No Selected");
          
        }
        
    }

    @FXML
    public void loadListView() {
        Eventss.setItems(listevents);
        Eventss.setPadding(new Insets(10));
    }

    @FXML
    private void OnSelect(MouseEvent event) {

        Eventss.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Evenement>() {
            @Override

            public void changed(ObservableValue<? extends Evenement> arg0, Evenement arg1, Evenement arg2) {

                Evenement c = Eventss.getSelectionModel().getSelectedItem();
                tfidevent.setText(Integer.toString(c.getId_event()));
                tfidprop.setText(Integer.toString(c.getId_proprietaire()));
                tfnbeq.setText(Integer.toString(c.getNb_eq()));
                tfnomevent.setText(c.getNom_event());
                tfdescevent.setText(c.getDescription_event());
                tfprix.setText(Float.toString(c.getPrix()));
                tfetat.setText(Integer.toString(c.getEtat()));
                tflisteequipe.setText(c.getListe_equipe());

            }

        });
    }

    @FXML
    private void OnClickedPrint(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.Eventss;

        if (job != null) {
            job.showPrintDialog(root.getScene().getWindow()); // Window must be your main Stage
            Printer printer = job.getPrinter();
            PageLayout pageLayout = printer.createPageLayout(Paper.A3, PageOrientation.LANDSCAPE, Printer.MarginType.HARDWARE_MINIMUM);
            boolean success = job.printPage(pageLayout, root);
            if (success) {
                job.endJob();
            }
        }
    }

}
