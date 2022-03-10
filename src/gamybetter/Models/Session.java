/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.text.DateFormat;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author skon1
 */
public class Session {

    int id;
    String nom;
    String email_coach;
    String email_joueur;
    int duree;
    Date daate;
    String jeu;
    String categorie;
    float prix;

    public Session() {
    }

    public Session(Object nom, Object email_coach, Object email_joueur, Object duree, Object date, Object jeu, Object categorie, Object prix) {
        this.nom = (String) nom;
        this.email_coach = (String) email_coach;
        this.email_joueur = (String) email_joueur;
        this.duree = (int) duree;
        this.daate = (Date) date;
        this.jeu = (String) jeu;
        this.categorie = (String) categorie;
        this.prix = (float) prix;
    }

    public Session(Object id, Object nom, Object email_coach, Object email_joueur, Object duree, Object date, Object jeu, Object categorie, Object prix) {
        this.id = (int) id;
        this.nom = (String) nom;
        this.email_coach = (String) email_coach;
        this.email_joueur = (String) email_joueur;
        this.duree = (int) duree;
        this.daate = (Date) date;
        this.jeu = (String) jeu;
        this.categorie = (String) categorie;
        this.prix = (float) prix;
    }

    /* public Session(int id, int id_coach, String email_coach, String email_joueur, int duree, String date, String jeu, String categorie, float prix) {
        this.id = id;
        this.id_coach = id_coach;
        this.email_coach = email_coach;
        this.email_joueur = email_joueur;
        this.duree = duree;
        this.daate = date;
        this.jeu = jeu;
        this.categorie = categorie;
        this.prix = prix;
    }
    public Session(Object id, Object id_coach, Object email_coach, Object email_joueur, Object duree, Object date, Object jeu, Object categorie, Object prix) {
        this.id = (int)id;
        this.id_coach = (int)id_coach;
        this.email_coach = (String)email_coach;
        this.email_joueur = (String)email_joueur;
        this.duree = (int)duree;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.daate = (String)df.format(date);
        this.jeu = (String)jeu;
        this.categorie = (String)categorie;
        this.prix = (float)prix;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail_coach() {
        return email_coach;
    }

    public void setEmail_coach(String email_coach) {
        this.email_coach = email_coach;
    }

    public String getEmail_joueur() {
        return email_joueur;
    }

    public void setEmail_joueur(String email_joueur) {
        this.email_joueur = email_joueur;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public Date getDaate() {
        return daate;
    }

    public void setDaate(Date date) {
        this.daate = date;
    }

    public String getJeu() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu = jeu;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Session{" + "id=" + id + ", nom=" + nom + ", email_coach=" + email_coach + ", email_joueur=" + email_joueur + ", duree=" + duree + ", daate=" + daate + ", jeu=" + jeu + ", categorie=" + categorie + ", prix=" + prix + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Session other = (Session) obj;
        if (this.duree != other.duree) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        if (!Objects.equals(this.email_coach, other.email_coach)) {
            return false;
        }
        if (!Objects.equals(this.email_joueur, other.email_joueur)) {
            return false;
        }
        if (!Objects.equals(this.jeu, other.jeu)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.daate, other.daate)) {
            return false;
        }
        return true;
    }

}
