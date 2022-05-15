/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXListView;
import gamybetter.Models.Personne;
import gamybetter.Models.Reclamation;
import gamybetter.Services.ServicePersonne;
import gamybetter.Services.ServiceReclamation;
import gamybetter.Utils.CurrentUser;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Admin
 */
public class ReclamationListController implements Initializable {

    @FXML
    private JFXListView<Reclamation> list;
    ServiceReclamation sr = new ServiceReclamation();
    ObservableList<Reclamation> listrec = FXCollections.observableArrayList();
    List <Reclamation> listper = new ArrayList(); 
    int id_user = 0;

    ServicePersonne sp = new ServicePersonne();

    /**
     * Initializes the controller class.
     */
    public void initialize(URL url, ResourceBundle rb) {
        listper = new ArrayList(sr.getAll());
        id_user = CurrentUser.getCurrentUser();
        Personne current = sp.getById(id_user);
        String currentMail = current.getEmail();
        System.out.println(currentMail);
        List<Reclamation> result = listper.stream().filter(e -> e.getEmail_sender().equals(currentMail)).collect(Collectors.toList());
        result.forEach(System.out::println);
        for ( Reclamation r : result){
                listrec.add(r);
        }
        
         list.setItems(listrec);
         list.setItems(listrec); 
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
