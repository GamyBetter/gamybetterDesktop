/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;
import java.util.Date;

/**
 *
 * @author Sayee
 */
public class Commande {
 

    private int id_commande;
    private int id_personne;
    private String nom_personne;
    private String email_personne;
    private String addresse_personne;
    private Date date;
    private Double prix_totale;
    private int discount;

    public Commande(){
        
    }
    
    public Commande(Object id_commande, Object id_personne){
        this.id_commande =(int) id_commande;
        this.id_personne =(int) id_personne;
    }

    public Commande(Object id_commande, Object id_personne,Object  nom_personne,Object  email_personne, Object addresse_personne, Object prix_totale) {
        this.id_commande =(int) id_commande;
        this.id_personne =(int) id_personne;
        this.nom_personne = (String)nom_personne;
        
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(Double) prix_totale;
    }

    public Commande(Object id_commande,Object addresse_personne, Object  email_personne, Object id_personne, Object prix_totale) {
        this.id_commande =(int) id_commande;
        this.id_personne =(int) id_personne;
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(Double) prix_totale;

    }
    
    public Commande(Object id_commande,Object date,Object  nom_personne,Object addresse_personne, Object  email_personne, Object prix_totale,Object Discount , Object id_personne) {
        this.id_commande =(int) id_commande;
        this.id_personne =(int) id_personne;
        this.nom_personne = (String)nom_personne;
        this.discount =(int) Discount;
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(Double) prix_totale;
        this.date = (Date)date;

    }
    
    



    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public String getNom_personne() {
        return nom_personne;
    }

    public void setNom_personne(String nom_personne) {
        this.nom_personne = nom_personne;
    }

    public String getEmail_personne() {
        return email_personne;
    }

    public void setEmail_personne(String email_personne) {
        this.email_personne = email_personne;
    }

    public String getAddresse_personne() {
        return addresse_personne;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    

    public void setAddresse_personne(String addresse_personne) {
        this.addresse_personne = addresse_personne;
    }

    public Double getPrix_totale() {
        return prix_totale;
    }

    public void setPrix_totale(Double prix_totale) {
        this.prix_totale = prix_totale;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    

    @Override
    public String toString() {
        return   "\t" + nom_personne +"\t\t\t\t \t " + date + "\t\t \t \t \t\t\t\t\t  " + addresse_personne+ "\t \t \t \t \t \t \t \t " + email_personne  +" \t \t  \t \t \t\t" + prix_totale+" DT";
    }



    
}