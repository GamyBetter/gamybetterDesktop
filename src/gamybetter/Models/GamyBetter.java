/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import gamybetter.Services.ServiceCommentaire;
import gamybetter.Services.ServicePublication;
import gamybetter.Services.ServiceActualite;
import gamybetter.Models.Commande;
import gamybetter.Models.Publication;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gamybetter.Services.ServiceCommande;

import gamybetter.Services.ServiceProduit;
import gamybetter.Outils.Outils1;
import gamybetter.Services.ServiceEquipe;
import gamybetter.Services.ServicePersonne;

import gamybetter.Utils.DataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author skon1
 */
public class GamyBetter extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
           DataSource ds = DataSource.getInstance();
        //Algorithme pour les ids (ajout des ids et récupération des ids)

        //Instancier les services
        ServicePersonne personneService = new ServicePersonne();
        ServiceEquipe equipeService = new ServiceEquipe();
              ServicePublication sp = new ServicePublication();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println(getClass().getResource("../GUI/AjoutCours.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("../GUI/AjoutCours.fxml"));
        primaryStage.setTitle("Cours page");
        primaryStage.setScene(new Scene(root,1200,800));
        primaryStage.show();
    }
  
    
    
}
