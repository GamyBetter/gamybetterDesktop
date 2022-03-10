/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import gamybetter.Models.Equipe;
import gamybetter.Services.ServiceEquipe;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author snoussi amine
 */
public class EquipeFormController implements Initializable {

    @FXML
    private Label nomequipe;
    @FXML
    private Label descriptionequipe;
    @FXML
    private JFXListView<Equipe> equipe;
    @FXML
    private JFXButton BtnAdd;
    @FXML
    private JFXButton BtnUpdate;
    @FXML
    private JFXButton BtnDelete;
    @FXML
    private JFXTextField tfid_equipe;
    @FXML
    private JFXTextField tfid_coach;
    @FXML
    private JFXTextField tfnom_equipe;
    @FXML
    private JFXTextField tfdescription_equipe;

    ServiceEquipe se = new ServiceEquipe();
    List<Equipe> eq = new ArrayList<>(se.getAll());
    ObservableList<Equipe> listequipe = FXCollections.observableArrayList(se.getAll());

    ListView<Equipe> listView = new ListView<Equipe>(listequipe);
    @FXML
    private JFXButton BtnGoBack;
    @FXML
    private JFXButton BtnPDF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tfid_equipe.setVisible(false);
        loadListView();
    }
    private GestionTournois main;

    @FXML
    private void goBack() throws IOException {
        main.showMainItems();

    }

    @FXML
    private void AddEquipe(ActionEvent event) {
         try {
            if (!(tfid_coach.getText().isEmpty() || tfnom_equipe.getText().isEmpty() || tfdescription_equipe.getText().isEmpty() )) {
        // int id_equipe = Integer.parseInt(tfid_equipe.getText());
        int id_coach = Integer.parseInt(tfid_coach.getText());
        String nom_equipe = tfnom_equipe.getText();
        String description_equipe = tfdescription_equipe.getText();
        Equipe e = new Equipe(/*id_equipe ,*/id_coach, nom_equipe, description_equipe);
        se.ajouter(e);
        equipe.getItems().add(e);
        ObservableList<Equipe> UpdatedListView = equipe.getItems();
        equipe.setItems(UpdatedListView);
        int ret = 1;
                if (ret == 0) {
                    JOptionPane.showMessageDialog(null, "Erreur team non ajouter");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs");
        }

    }

    @FXML
    private void UpdateEquipe(ActionEvent event) {
        int id_equipe = Integer.parseInt(tfid_equipe.getText());

        int id_coach = Integer.parseInt(tfid_coach.getText());
        String nom_equipe = tfnom_equipe.getText();
        String description_equipe = tfdescription_equipe.getText();
        Equipe e = new Equipe(id_equipe, id_coach, nom_equipe, description_equipe);
        se.modifier(e);
        //System.out.println(se.modifier(e));
        equipe.getItems().set(equipe.getSelectionModel().getSelectedIndex(), e);
        JOptionPane.showMessageDialog(null, "Team modifier");
    }

    @FXML
    private void DeleteEquipe(ActionEvent event) {
        int id_equipe = equipe.getSelectionModel().getSelectedItem().getId_equipe();
        Equipe e = se.getById(id_equipe);

        //txt.setVisible(false);
        // DefaultTxtFields();
        int res = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this Team", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (res == JOptionPane.YES_OPTION) {
            System.out.println("Yes Selected");
            se.supprimer(e);
            equipe.getItems().remove(equipe.getSelectionModel().getSelectedItem());
            ObservableList<Equipe> UpdatedListView = equipe.getItems();
            equipe.setItems(UpdatedListView);
            JOptionPane.showMessageDialog(null, "equipe supprimer");
        } else if (res == JOptionPane.NO_OPTION) {
            System.out.println("No Selected");

        }
    }

    public void loadListView() {
        equipe.setItems(listequipe);
        equipe.setPadding(new Insets(10));
    }

    @FXML
    private void OnSelect(MouseEvent event) {
        equipe.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Equipe>() {
            @Override

            public void changed(ObservableValue<? extends Equipe> arg0, Equipe arg1, Equipe arg2) {

                Equipe c = equipe.getSelectionModel().getSelectedItem();
                tfid_equipe.setText(Integer.toString(c.getId_equipe()));
                tfid_coach.setText(Integer.toString(c.getId_coach()));
                tfnom_equipe.setText(c.getNom_eq());
                tfdescription_equipe.setText(c.getDescription_equipe());

            }

        });
    }

    @FXML
    private void OnClickedPrint(ActionEvent event) {
        PrinterJob job = PrinterJob.createPrinterJob();

        Node root = this.equipe;

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
