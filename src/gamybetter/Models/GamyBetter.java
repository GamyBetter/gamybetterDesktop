package gamybetter.Models;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
import gamybetter.Services.ServiceEquipe;
import gamybetter.Services.ServicePersonne;

import gamybetter.Services.ServiceProduit;

import gamybetter.Utils.DataSource;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

import gamybetter.Utils.DataSource;

/**
 *
 * @author skon1
 */
public class GamyBetter extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource ds = DataSource.getInstance();
        //Algorithme pour les ids (ajout des ids et récupération des ids)
<<<<<<< HEAD

        //Instancier les services
        ServicePersonne personneService = new ServicePersonne();
        ServiceEquipe equipeService = new ServiceEquipe();
        //creation equipe
        //creation personne

        /*Personne p = new Personne("Skander Gassa",99581454,5,30,"0000","Admin","skander@esprit.tn","Im skander gassa 24 yo","Coach","Valorant","Jett","Clutchy","Duelist",100f,0);
        personneService.ajouter(p);
        Personne p1 = new Personne();
        List<Personne> listpersonne = new ArrayList<>();
        for(Personne val : personneService.getAll()){
            listpersonne.add(val);
        }
        Equipe e = new Equipe(listpersonne.get(0).getId_personne(),"equipe 1", "Celle ci est la premiere equipe");
        equipeService.ajouter(e);
        Equipe e2 = new Equipe(listpersonne.get(1).getId_personne(),"equipe 2", "Celle ci est la deuxieme equipe");
        equipeService.ajouter(e2);*/
        //ajout de plusieurs equipes à un evenements
        //ajout de produits
        //ajout de commande pour une personne contenant plusieurs produits
        //ajout d'une session
        //ajout d'un cours qui appartient à une session pour lequel plusieurs personnes sont inscrits
        //ajout d'un match appartenant à une personne et une equipe
        //ajout d'une actualité contenant un match et appartenant à une personne
        ServicePublication sp = new ServicePublication();
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/gamybetter/GUI/AjoutCours.fxml"));
        primaryStage.setTitle("Cours page");
        primaryStage.setScene(new Scene(root,1200,800));
        primaryStage.show();
    }
=======
        
        //creation equipe
        //creation personne
         
        //ajout de plusieurs equipes à un evenements
        
        //ajout de produits
        //ajout de commande pour une personne contenant plusieurs produits
        
        //ajout d'une session
        //ajout d'un cours qui appartient à une session pour lequel plusieurs personnes sont inscrits
        
        
        //ajout d'un match appartenant à une personne et une equipe
        //ajout d'une actualité contenant un match et appartenant à une personne
        ServicePublication sp = new ServicePublication();
         
    }

>>>>>>> snoussi
}


