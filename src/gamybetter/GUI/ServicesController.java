/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Sayee
 */
public class ServicesController implements Initializable {

    @FXML
    private AnchorPane root;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void GoToProductFrom(ActionEvent event) {
        
try {
  Stage window = (Stage) this.root.getScene().getWindow();
                window.setScene(new Scene(FXMLLoader.load(getClass().getResource("ProductForm.fxml"))));

       /* Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("ProductForm.fxml"));
    
        
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();*/
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }

    @FXML
    private void GoToCommandeFrom(ActionEvent event) {
        Node node = (Node) event.getSource();
         Stage stage = (Stage) node.getScene().getWindow();
            stage.close();
        try {
        
            Parent root = FXMLLoader.load(getClass().getResource("CommandForm.fxml"));
    
        
    
        Scene scene = new Scene(root);
        stage.setScene(scene);
    
        stage.show();
      } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
    }
    }
    
}
