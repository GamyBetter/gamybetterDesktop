/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.Date;
import java.util.Objects;
import javafx.scene.control.TextField;

/**
 *
 * @author Admin
 */
public class Personne {

    private int id_personne, contact,age;
    private String nom_personne,prenom, mot_de_passe, role, email, description,username,image,activation,reset;
    private Date date ;

    public Personne( Object id_personne,Object  contact, Object age, Object nom_personne, Object prenom, Object mot_de_passe, Object role, Object email, Object description, Object username, Object image, Object date) {
        this.id_personne = (int)id_personne;
        this.contact = (int)contact;
        this.age = (int) age;
        this.nom_personne =(String) nom_personne;
        this.prenom = (String)prenom;
        this.mot_de_passe =(String) mot_de_passe;
        this.role = (String)role;
        this.email = (String)email;
        this.description = (String)description;
        this.username =(String) username;
        this.image =(String) image;
        this.date =(Date) date;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "Personne{" + "id_personne=" + id_personne + ", contact=" + contact + ", age=" + age + ", nom_personne=" + nom_personne + ", prenom=" + prenom + ", mot_de_passe=" + mot_de_passe + ", role=" + role + ", email=" + email + ", description=" + description + ", username=" + username + ", date=" + date + '}';
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
