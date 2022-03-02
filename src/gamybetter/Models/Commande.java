/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Sayee
 */
public class Commande {
 

    private String id_commande;
    private int id_personne;
    private String nom_personne;
    private String prenom_personne;
    private String email_personne;
    private String addresse_personne;
    private Date date;
    private float prix_totale;

    public Commande(){
        
    }

    public Commande(Object id_commande, Object id_personne,Object  nom_personne,Object  prenom_personne,Object  email_personne, Object addresse_personne, Object prix_totale) {
        this.id_commande =(String) id_commande;
        this.id_personne =(int) id_personne;
        this.nom_personne = (String)nom_personne;
        this.prenom_personne =(String) prenom_personne;
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(float) prix_totale;
    }

    public Commande(Object id_commande,Object addresse_personne, Object  email_personne, Object id_personne, Object prix_totale) {
        this.id_commande =(String) id_commande;
        this.id_personne =(int) id_personne;
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(float) prix_totale;

    }
    
    public Commande(Object id_commande,Object date,Object  nom_personne,Object  prenom_personne,Object addresse_personne, Object  email_personne, Object id_personne, Object prix_totale) {
        this.id_commande =(String) id_commande;
        this.id_personne =(int) id_personne;
        this.nom_personne = (String)nom_personne;
        this.prenom_personne =(String) prenom_personne;
        this.email_personne = (String)email_personne;
        this.addresse_personne = (String)addresse_personne;
        this.prix_totale =(float) prix_totale;
        this.date = (Date)date;

    }
    
    



    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
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

    public String getPrenom_personne() {
        return prenom_personne;
    }

    public void setPrenom_personne(String prenom_personne) {
        this.prenom_personne = prenom_personne;
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

    public void setAddresse_personne(String addresse_personne) {
        this.addresse_personne = addresse_personne;
    }

    public float getPrix_totale() {
        return prix_totale;
    }

    public void setPrix_totale(float prix_totale) {
        this.prix_totale = prix_totale;
    }

    

    @Override
    public String toString() {
        return "Commande{" + "id_commande=" + id_commande + ", id_personne=" + id_personne + ", nom_personne=" + nom_personne + ", prenom_personne=" + prenom_personne + ", email_personne=" + email_personne + ", addresse_personne=" + addresse_personne + ", date=" + date + ", prix_totale=" + prix_totale + '}';
    }

    
}