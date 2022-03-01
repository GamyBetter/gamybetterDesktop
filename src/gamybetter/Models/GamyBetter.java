/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import gamybetter.Models.Commande;
import static java.lang.System.in;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import gamybetter.Services.ServiceCommande;
import gamybetter.Services.ServicePanier;
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
        //connect into database
        DataSource ds = DataSource.getInstance();
        //get service functionnalities
        
        
        /*/////////////////////////////////////////////
        ////////// test personne ///////////////
        ServicePersonne sp = new ServicePersonne();
        //create person instance
        //
        //add to database
        //sp.add(p1);
        //Personnes person2 = new Personnes("Fares","Chobba");
        //sp.ajouter2(person2);
        
        //get from database
        //sp.getAll();
        for(Personnes i : sp.getAll()){
            System.out.println(i + "\n");
        }
        /////////////////////////////////////////////
        /////////////////////////////////////////////
        
        /////////////////////////////////////////////
        ////////// test produit ////////////////
        ServiceProduit spp = new ServiceProduit();
        Produit prod = new Produit(2,"red dragon",180.9f,"souri", "gamer ","1564654",22);
         for(Produit i : spp.getAll()){
            System.out.println(i + "\n");c
        }
         //spp.update(prod);
         //spp.delete(prod);

        Produit p3 = new Produit(8,"Souris gamer",45.99f,"souri", "Sana","aaa",19);
        System.out.println(spp.getOne(p3));*/
        /////////////////////////////////////////////
        /////////////////////////////////////////////
         ////////// test commande ////////////////
         ServiceCommande sc = new ServiceCommande();
         Commande comvide = new Commande();
         Commande com = new Commande("#C0044","rue sahafa 5050","Esprit@fert.com",123,22.9f);

         Commande cc = new Commande("#C0045","rue sahafa 5050","Esprit@fert.com",12,22.9f);
         

         sc.add(com);
         sc.add(cc);
         //sc.update(cc);
         //sc.delete(com);
         //System.out.println(sc.getById(23));
        sc.getAll().forEach((i) -> {
           System.out.println(i + "\n");
        }); //for(Produit i : sc.getAll()){
        // System.out.println(i + "\n");
        //}*/
        /////////////////////////////////////////////
        /////////////////////////////////////////////
         /////////////////////////////////////////////
         ////////// test Panier ////////////////
         /*ServicePanier sp = new ServicePanier();
         Panier pan = new Panier();
         Panier p = new Panier("#C0005","3",9);
         Panier pp = new Panier("#C0004","1",5);
         

         //sp.add(p);
         //sp.add(pp);
         //sp.update(pp);
         //sc.delete(com);
         //System.out.println(sp.getById(23));
        sp.getAll().forEach((i) -> {
         System.out.println(i + "\n");
        }); //for(Produit i : sc.getAll()){
        // System.out.println(i + "\n");
        //}*/
        /////////////////////////////////////////////
        /////////////////////////////////////////////
        
        
    }
    
}
