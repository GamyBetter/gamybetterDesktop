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
import gamybetter.Services.ServiceMatch;

import gamybetter.Services.ServiceProduit;

import gamybetter.Utils.DataSource;

/**
 *
 * @author skon1
 */
public class GamyBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource ds = DataSource.getInstance();
        //Algorithme pour les ids (ajout des ids et récupération des ids)
        
        //creation equipe
        //creation personne
         
        //ajout de plusieurs equipes à un evenements
        
        //ajout de produits
        //ajout de commande pour une personne contenant plusieurs produits
        
        //ajout d'une session
        //ajout d'un cours qui appartient à une session pour lequel plusieurs personnes sont inscrits
        
        
        //ajout d'un match appartenant à une personne et une equipe
        //ajout d'une actualité contenant un match et appartenant à une personne
       // ServiceActualite sp = new ServiceActualite();
       // Actualite ac1 = new Actualite ("mariem","belghith",110,4);
         //sp.ajouter(ac1);
          //sp.modifier(ac1);
      // sp.deleteById(6);
        // sp.supprimer(ac1);
      // sp.getAll();
        // sp.getById(6);
         //ServiceMatch sm = new ServiceMatch();
         //Match ac1 = new Match (100,9,"lol","ddd","jddjjd","jddjjd","24-12-1998","jddjjd",7,7);
        // sm.ajouter(ac1);
         //sm.modifier(ac1);
         //sm.supprimer(ac1);
      //  sm.getAll();
       // sm.getById(109);
       // sm.deleteById(79);
        
    }

}
