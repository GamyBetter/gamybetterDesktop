/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
/**
 *
 * @author Mariem
 */
public class Publication {
      private int id_publication, nbr_commentaire,id_personne;
    private String  publication, titre;
   // Date date;
    private String date;
    private String image;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Publication(Object id_personne, Object publication, Object titre, Object nbr_commentaire,Object date) {
        this.id_personne =(int) id_personne;
        this.publication = (String)publication;
        this.titre = (String)titre;
        this.nbr_commentaire =(int) nbr_commentaire;
       
        this.date =(String) date;
      
        

    }

    public Publication(int id_publication,int id_personne, String publication, String titre, int nbr_commentaire, String date, String image) {
        this.id_publication = id_publication;
            this.id_personne = id_personne;
        this.publication = publication;
       this.titre = titre;
        this.nbr_commentaire = nbr_commentaire;
    
        this.date = date;
        this.image = image;
    }

    public Publication(int id_personne, String publication, String titre) {
        this.id_personne = id_personne;
        this.publication = publication;
        this.titre = titre;
    }

    public Publication(String publication, String titre, String image) {
        this.publication = publication;
        this.titre = titre;
        this.image = image;
    }
    
    

    public Publication(String publication, String titre,LocalDate date) {
        this.publication = publication;
        this.titre = titre;
       // this.date = date;
    }

    public Publication(String publication, String titre, String image,LocalDate date) {
        this.publication = publication;
        this.titre = titre;
        this.image = image;
    }
    
    
    
 
      public Publication(Object id_publication,Object id_personne, Object publication, Object titre, Object nbr_commentaire,Object date) {

      

        this.id_publication=(int) id_publication;
       this.id_personne =id_personne!=null ? (int)id_personne : 0 ;
        this.publication = (String)publication;
        this.titre = (String)titre;
        this.nbr_commentaire =(int) nbr_commentaire;
       

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (String) date;
        

    }  
      
         public Publication( Object publication, Object titre, Object nbr_commentaire,Object date) {

      

  
             this.publication = (String) publication;
             this.titre = (String) titre;
             this.nbr_commentaire = (int) nbr_commentaire;
             DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
             this.date = (String) date;
        

    } 

    public Publication(int id_publication,String publication, String titre, int nbr_commentaire) {
        this.id_publication = id_publication;
        
        this.publication = publication;
        this.titre = titre;
        this.nbr_commentaire = nbr_commentaire;
    }
         

    public Publication(int id_publication, String publication, String titre, int nbr_commentaire, LocalDate date) {
        this.id_publication = id_publication;
        
        this.publication = publication;
        this.titre = titre;
        this.nbr_commentaire = nbr_commentaire;
        //this.date = date;
    }
         

    public Publication( String publication,String titre,int nbr_commentaire, LocalDate date) {
          this.publication = publication;
             this.titre = titre;
        this.nbr_commentaire = nbr_commentaire;
     
     
       /// this.date = date;
    }

    public Publication(String publication, String titre) {
        this.publication = publication;
        this.titre = titre;
    }

  

         
        public Publication() {
    }

    

  

    public int getId_Publication() {
        return id_publication;
    }

    public void setId_Publication(int idPublication) {
        this.id_publication = idPublication;
    }

    public int getNbr_commentaire() {
        return nbr_commentaire;
    }

    public void setNbr_commentaire(int nbr_commentaire) {
        this.nbr_commentaire = nbr_commentaire;
    }

  

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getPublication() {
        return publication;
    }

    public void setPublication(String publication) {
        this.publication = publication;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

   
    @Override
    public String toString() {
        return       publication+"\t \t" +titre+ "\t \t" + date+"\t\t" +image+"\t\t" ;
                
       /*"Publication{" + "idPublication=" + id_publication + ", nbr_commentaire=" + nbr_commentaire + ", id_personne=" + id_personne + ", publication=" + publication + ", titre=" + titre + ", date=" + date + '}';*/
    }
  
    
}
