/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import tn.edu.esprit.service.ServiceCommentaire;
import tn.edu.esprit.service.ServicePublication;
import tn.edu.esprit.utils.DataSource;
import gamybetter.Services.ServiceActualite;

/**
 *
 * @author Sayee
 */
public class GamyBetter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        DataSource ds = DataSource.getInstance();
       

        ServiceCommentaire sc;
        sc = new ServiceCommentaire();

        tn.edu.esprit.modeles.Commentaire com1 = new tn.edu.esprit.modeles.Commentaire(1, 2, null,"hdfgsegfuihsdfj");
        tn.edu.esprit.modeles.Commentaire com2 = new tn.edu.esprit.modeles.Commentaire(2,3, "12-3-2016","hahahaha");
         tn.edu.esprit.modeles.Commentaire com3 = new tn.edu.esprit.modeles.Commentaire(5,1, "12-3-2016","hmila");
        //add to database
     // sc.add(com3);
         // sc.update(com3);
        //sc.getById(15);

        //getfrom database
        // sc.delete(com1);
        // sc.delete(com2);
         //sc.delete(com3);
        //sc.getOne(15);
        sc.getAll();
        //System.out.println(sc.getOne(com1));
        ServicePublication sp = new ServicePublication();
        tn.edu.esprit.modeles.Publication pub1 = new tn.edu.esprit.modeles.Publication(18, 1, "yaallh ", "salutation", 15, "12-3-2016");
      //  Publication pub2 = new Publication(1, "sikiniiiii", "siki@gmail.com", "okk ", "bye", 15, "12-3-2020");
       // Publication pub3 = new Publication(5, "wissem", "hmila@gmail.com", "okk ", "bye", 15, "12-4-2016");
        //Publication pub4 = new Publication(7, "wissemhmila", "hmila@gmail.com", "beuuuhy ", "bahy", 15, "12-4-2020");        
//add to bd
      // sp.add(pub1);
        // sp.add(pub2);
        // System.out.println("*******************");
        //getFromdara(tekhdem)
        sp.getAll();

      // delete 
        // Publication pub3= new Publication (8,"siki","siki@gmail.com","okk ","bye",15,null); 
       // sp.delete(pub3);
       // sp.delete(pub2);
       // sp.add(pub1);
        
        //sp.update(pub4);
        //sp.update(pub1);
         //sp.getOne(pub2);
    }

/*        ServiceActualite sa=new  ServiceActualite();
   
   Actualite ac1=new Actualite("mimi", "bel");
  Actualite ac2=new Actualite("m", "m");
   Actualite ac3=new Actualite("sourour", "lmom",39);
   //sa.delete(ac3);
   //sa.update(ac3);
  // sa.add(ac3);
   //sa.add(ac2);
  /* sa.getAll();
        for(Actualite i : sa.getAll()){
           System.out.println(i + "\n");
        }*/
  
    //sa.getById(39);
     
      //  ServiceMatch sm =new  ServiceMatch();
      // Match sm1= new Match(2,"sour","sour","sour","sikni",null,"m",1,1);
       //Match sm2= new Match(1,"o","mmmmmmm","soouuuuu","si","26-12-1998","looooooooooooool",1,1);
     //Match sm4= new Match(5,"mimou","chobbbbbbbbba","siki","sikni","24-12-2022","mariem",3,2);
     //sm.add(sm1);
     // sm.add(sm2);
      //sm.add(sm4);
        
     // sm.getAll();
       
        
   // sm.getOne(sm1);
    // sm.getById(68);
           
       //sm.delete(sm1);
           
       //sm.update(sm1);
           
           
        }
    }
    

