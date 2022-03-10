/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Mariem
 */
public class Commentaire {

    private int id_commentaire, id_personne, id_publication;
    private String cont_commentaire;
   private Date date;

//    private Date date;

    public Commentaire(Object id_personne, Object date, Object cont_commentaire, Object id_publication) {
        this.id_publication = (int) id_publication;
        this.id_personne = (int) id_personne;
        //this.date = (String) date;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
        this.cont_commentaire = (String) cont_commentaire;
    }

    public Commentaire(Object id_commentaire, Object id_personne, Object date, Object cont_commentaire, Object id_publication) {
        this.id_commentaire = (int) id_commentaire;
        this.id_personne = (int)id_personne;
        this.date = (Date) date;
        this.cont_commentaire = (String) cont_commentaire;
        this.id_publication = (int)id_publication ;
    }

    public Commentaire(LocalDate date, Object cont_commentaire) {

        //this.date = (String) date;DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
     
        //DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //this.date = (String)df.format(date);
        //this.date = (Date) date;
          this.cont_commentaire = (String) cont_commentaire;
       
    }
       public Commentaire(Object id_personne,Object date, Object cont_commentaire) {

        //this.date = (String) date;DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
           this.id_personne=(int)id_personne;
      
        this.date = (Date) date;
          this.cont_commentaire = (String) cont_commentaire;
       
    }

    public Commentaire(int id_commentaire, String cont_commentaire, int id_publication) {

        // this.date = (String) date;  DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.id_commentaire = id_commentaire;
      
        this.cont_commentaire = cont_commentaire;
        this.id_publication =  id_publication;
    }

    public Commentaire(int id_commentaire, int id_personne, String cont_commentaire, int id_publication) {
        this.id_commentaire = id_commentaire;
        this.id_personne = id_personne;
        this.cont_commentaire = cont_commentaire;
        this.id_publication = id_publication;
        
    }

   /* public Commentaire(Object id_commentaire, Object cont_commentaire, Object  date) {
        this.id_commentaire = (int)id_commentaire;
        this.cont_commentaire = (String)cont_commentaire;
       this.date = (Date) date;
        // DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        //this.date = (String) df.format(date);
    }*/

    public Commentaire(String cont_commentaire) {
        this.cont_commentaire = cont_commentaire;
        
    }

    public Commentaire(int id_personne, String cont_commentaire) {
        this.id_personne = id_personne;
        this.cont_commentaire = cont_commentaire;
    }
    

    
    public Commentaire() {
    }

    public int getIdCommentaire() {
        return id_commentaire;
    }

    public void setIdCommentaire(int id) {
        this.id_commentaire = id;
    }



    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getId_publication() {
        return id_publication;
    }

    public void setId_publication(int id_publication) {
        this.id_publication = id_publication;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId_commentaire() {
        return id_commentaire;
    }

    public void setId_commentaire(int id_commentaire) {
        this.id_commentaire = id_commentaire;
    }

    public String getCont_commentaire() {
        return cont_commentaire;
    }

    public void setCont_commentaire(String cont_commentaire) {
        this.cont_commentaire = cont_commentaire;
    }

    @Override
    public String toString() {
        return  cont_commentaire + "\t \t" + date ;
    }

    

}
