/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author snoussi amine
 */
public class Evenement {

    private int id_event,id_proprietaire, nb_eq;
    private String Nom_event, description_event;
    private String date_debut_event, date_fin_event;
    private String liste_equipe;
    private float prix;
    private int etat;

    public Evenement() {
    }

    public Evenement(Object id_proprietaire, Object nb_eq, Object Nom_event, Object description_event, Object date_debut_event, Object date_fin_event, Object prix, Object etat,Object liste_equipe) {
  
        this.id_proprietaire = (int) id_proprietaire;
        this.nb_eq = (int) nb_eq;
        this.Nom_event = (String) Nom_event;
        this.description_event = (String) description_event;
        this.date_debut_event = (String) date_debut_event;
        this.date_fin_event = (String) date_fin_event;
        this.prix = (float) prix;
        this.etat = (int) etat;
        this.liste_equipe=(String) liste_equipe;
    }
    
    public Evenement(Object id_event,Object id_proprietaire, Object nb_eq, Object Nom_event, Object description_event, Object date_debut_event, Object date_fin_event, Object prix, Object etat,Object liste_equipe) {
        this.id_event=(int) id_event;
        this.id_proprietaire = (int) id_proprietaire;
        this.nb_eq = (int) nb_eq;
        this.Nom_event = (String) Nom_event;
        this.description_event = (String) description_event;
        this.date_debut_event = (String) date_debut_event;
        this.date_fin_event = (String) date_fin_event;
        this.prix = (float) prix;
        this.etat = (int) etat;
        this.liste_equipe=(String) liste_equipe;
    }

   /* public Evenement(Object id_event, Object id_proprietaire, Object nb_eq, String Nom_event, Object description_event, Object date_debut_event, Object date_fin_event, Object prix,Object liste_equipe) {
        this.id_event = (int) id_event;
        this.id_proprietaire = (int) id_proprietaire;
        this.nb_eq = (int) nb_eq;
        this.Nom_event = (String) Nom_event;
        this.description_event = (String) description_event;
        this.date_debut_event = (String) date_debut_event;
        this.date_fin_event = (String) date_fin_event;
        this.prix = (float) prix;
        this.liste_equipe=(String) liste_equipe;
    }*/

    public int getId_event() {
        return id_event;
    }

    public void setId_event(int id_event) {
        this.id_event = id_event;
    }

    public int getId_proprietaire() {
        return id_proprietaire;
    }

    public void setId_proprietaire(int id_proprietaire) {
        this.id_proprietaire = id_proprietaire;
    }

    public int getNb_eq() {
        return nb_eq;
    }

    public void setNb_eq(int nb_eq) {
        this.nb_eq = nb_eq;
    }

    public String getNom_event() {
        return Nom_event;
    }

    public void setNom_event(String Nom_event) {
        this.Nom_event = Nom_event;
    }

    public String getDescription_event() {
        return description_event;
    }

    public void setDescription_event(String description_event) {
        this.description_event = description_event;
    }

    public String getDate_debut_event() {
        return date_debut_event;
    }

    public void setDate_debut_event(String date_debut_event) {
        this.date_debut_event = date_debut_event;
    }

    public String getDate_fin_event() {
        return date_fin_event;
    }

    public void setDate_fin_event(String date_fin_event) {
        this.date_fin_event = date_fin_event;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public String getListe_equipe() {
        return liste_equipe;
    }

    public void setListe_equipe(String liste_equipe) {
        this.liste_equipe = liste_equipe;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + this.id_event;
        hash = 13 * hash + this.id_proprietaire;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Evenement other = (Evenement) obj;
        if (this.id_event != other.id_event) {
            return false;
        }
        if (this.id_proprietaire != other.id_proprietaire) {
            return false;
        }
        if (this.etat != other.etat) {
            return false;
        }
        return true;
    }

}
