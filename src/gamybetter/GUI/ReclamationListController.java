/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import com.jfoenix.controls.JFXListView;
import gamybetter.Models.Reclamation;
import gamybetter.Services.ServicePersonne;
import gamybetter.Services.ServiceReclamation;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Admin
 */

public class ReclamationListController implements Initializable {
    @FXML
    private JFXListView<Reclamation> list;
    ServiceReclamation sr = new ServiceReclamation();
    ServicePersonne sp = new ServicePersonne();
    ObservableList<Reclamation> listrec = FXCollections.observableArrayList();
     

    /**
     * Initializes the controller class.
     */
    
    public void initialize(URL url, ResourceBundle rb) {
        
           listrec = FXCollections.observableArrayList(sr.getAll());
        list.setItems(listrec);
         list.setItems(listrec); 
    }    
    
}
