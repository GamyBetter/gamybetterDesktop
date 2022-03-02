/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;
import java.text.DateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
/**
 *
 * @author Mariem
 */
public class Publication {
      private int id_publication, nbr_commentaire,nbr_Like,nbr_Dislike,id_personne;
    private String  publication, titre;
   // Date date;
    private String date;

    public Publication(Object id_personne, Object publication, Object titre, Object nbr_commentaire,Object date) {

      

        
        this.id_personne =(int) id_personne;
        this.publication = (String)publication;
        this.titre = (String)titre;
        this.nbr_commentaire =(int) nbr_commentaire;
       
        this.date =(String) date;
        

    }
 
      public Publication(Object id_publication,Object id_personne, Object publication, Object titre, Object nbr_commentaire,Object date) {

      

        this.id_publication=(int) id_publication;
       this.id_personne =(int) id_personne;
        this.publication = (String)publication;
        this.titre = (String)titre;
        this.nbr_commentaire =(int) nbr_commentaire;
       

        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (String)df.format(date);
        

    }  

        public Publication() {
    }
    public int getNbr_Like() {
        return nbr_Like;
    }

    public void setNbr_Like(int nbr_Like) {
        this.nbr_Like = nbr_Like;
    }

    public int getNbr_Dislike() {
        return nbr_Dislike;
    }

    public void setNbr_Dislike(int nbr_Dislike) {
        this.nbr_Dislike = nbr_Dislike;
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
        return "Publication{" + "idPublication=" + id_publication + ", nbr_commentaire=" + nbr_commentaire + ", nbr_Like=" + nbr_Like + ", nbr_Dislike=" + nbr_Dislike + ", id_personne=" + id_personne + ", publication=" + publication + ", titre=" + titre + ", date=" + date + '}';
    }
  
    
}
