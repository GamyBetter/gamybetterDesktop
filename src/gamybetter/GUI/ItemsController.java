/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author snoussi amine
 */
public class ItemsController implements Initializable {
    private GestionTournois main;
    @FXML
    private void goEvenementForm() throws IOException {
        main.showEvenementScene(); 
    }
    @FXML
    private void goEquipeForm() throws IOException {
        main.showEquipeScene();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
