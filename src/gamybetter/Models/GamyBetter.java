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

import gamybetter.Utils.DataSource;
import java.io.IOException;

/**
 *
 * @author skon1
 */
public class GamyBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        DataSource ds = DataSource.getInstance();
       // StringBuffer s= Outils1.sendGET("fuck", "mariem", "rWpF1UwqSDRxrQzBoRQQsinXKzeyTM55uvmRQPSnVkhqgcRh");
        //System.out.println(s +"sssssssss");
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
      ServicePublication sp = new ServicePublication();
                
        Publication p1=new Publication ("mARIEEEEEEEEEEEEEEEM","TIIIIIIIIIIIIITRE",20,"12-03-2016");
         Publication p2=new Publication (60,"tiiiiiiiiiit","tiiiiiiiiiiit",55,"12-3-2016");
          Publication p3=new Publication (3,"publication3","titre3",40);
       // sp.ajouter(p1);
        //sp.ajouter(p2);
        // sp.ajouter(p3);
         
         //sp.getAll();
         //sp.getById(2);
         // sp.deleteById(1);
          
          Publication p=new Publication();
          p.setId_Publication(5);
        //sp.supprimer(p);
    sp.modifier(p3);
         //sp.getOne(p);
   
          
          
          
          
          ServiceCommentaire sc;
               
        sc = new ServiceCommentaire();

 Commentaire com1 = new Commentaire(66,2,"sousou",20);
 //Commentaire com2 = new Commentaire("12-3-2016","commentaire2");
  // Commentaire com3 = new Commentaire(6,"12-3-2016","Commentaire33333333");
// Commentaire skan = new Commentaire(25,null,"12-03-2016","tessssssssssst",null);
 //sc.ajouter(com1);
 //sc.ajouter(skan);
//sc.getAll();
  // sc.ajouter(com3);
 //sc.deleteById(30);
        //System.out.println(sc.getAll());
 
  //sc.getById(18);
 //Commentaire c = new Commentaire();
 //c.setIdCommentaire(6);
        //System.out.println(c + "commentaire");
//done
//sc.getOne(c);
      //  System.out.println(sc.getOne(c));
   //     System.out.println(sc.getOne(skan));
  //com3.setIdCommentaire(6);
//sc.supprimer(skan);
// sc.supprimer(com3);
//sc.modifier(com1);
   
     
    }
  
    
    
}
