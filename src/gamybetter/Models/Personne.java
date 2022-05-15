/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.Objects;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class Personne {

    private int id_personne, contact, rating, ig_rank,id_equipe;
    private String nom_personne, mot_de_passe, role, email, description, competence, jeux, heros, ig_name, ig_role;
    private float prix;

  
    
    public Personne(Object id_personne,Object nom_personne, Object contact, Object rating,Object role,Object mot_de_passe,  Object email, Object description, Object competence, Object jeux,Object prix,  Object heros, Object ig_name, Object ig_role, Object ig_rank) {
        this.id_personne=(int) id_personne;
        this.nom_personne = (String) nom_personne;
        this.contact = (int) contact;
        this.rating = (int) rating;
        this.ig_rank = (int) ig_rank;
        this.mot_de_passe = (String) mot_de_passe;
        this.role = (String) role;
        this.email = (String) email;
        this.description = (String) description;
        this.competence = (String) competence;
        this.jeux = (String) jeux;
        this.heros = (String) heros;
        this.ig_name = (String) ig_name;
        this.ig_role = (String) ig_role;
        this.prix = (float) prix;
   
    }

    public Personne() {
    }


    public Personne (Object nom_personne, Object contact,Object description, Object email,Object mot_de_passe){
        this.nom_personne = (String) nom_personne;
        this.contact = (int) contact;
        this.description = (String) description;
        this.email = (String) email;
        this.mot_de_passe = (String) mot_de_passe;
        
        
    }

    public Personne(String email, String password) {
        this.email = email;
        this.mot_de_passe = password;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getIg_rank() {
        return ig_rank;
    }

    public void setIg_rank(int ig_rank) {
        this.ig_rank = ig_rank;
    }

    public String getNom_personne() {
        return nom_personne;
    }

    public void setNom_personne(String nom_personne) {
        this.nom_personne = nom_personne;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_passe) {
        this.mot_de_passe = mot_passe;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competance) {
        this.competence = competance;
    }

    public String getJeux() {
        return jeux;
    }

    public void setJeux(String jeux) {
        this.jeux = jeux;
    }

    public String getHeros() {
        return heros;
    }

    public void setHeros(String heros) {
        this.heros = heros;
    }

    public String getIg_name() {
        return ig_name;
    }

    public void setIg_name(String ig_name) {
        this.ig_name = ig_name;
    }

    public String getIg_role() {
        return ig_role;
    }

    public void setIg_role(String ig_role) {
        this.ig_role = ig_role;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

  
    @Override
    public String toString() {
        return "Personne{" +  " nom_personne=" + nom_personne + ", role=" + role + ", email=" + email + ", contact=" + contact + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.mot_de_passe, other.mot_de_passe)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    

}
