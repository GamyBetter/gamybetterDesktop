/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.GUI;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

 /*
 * @author MAG028
 */
public class MainFXML extends Application {
    
    //@Override
    public void start(Stage primaryStage)  throws IOException{
        
         //   
            System.out.println("LOADING ...");
        try {
           
         // Parent root = FXMLLoader.load(getClass().getResource("Actualite.fxml"));
         Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
           
            
       //Parent root = FXMLLoader.load(getClass().getResource("ListeMatch.fxml"));
         // Parent root = FXMLLoader.load(getClass().getResource("Match.fxml"));
          System.out.println("LOADED");
            Scene scene = new Scene(root);
            
          //  primaryStage.setTitle("Match");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("loading args");
        launch(args);
        System.out.println("loaded");
    }
    
}
