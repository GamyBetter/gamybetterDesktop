/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

/**
 *
 * @author Admin
 */
public class Reclamation {
    private int id_reclamation,id_personne;
    private String titre,reclamation,email_sender;

    public Reclamation() {
    }

    public Reclamation(Object titre, Object reclamation, Object email_sender,Object id_personne) {
    
        this.titre = (String) titre;
        this.reclamation = (String) reclamation;
        this.email_sender = (String) email_sender;
        this.id_personne=(int) id_personne;
    }

    public Reclamation(Object id_personne,Object id_reclamation, Object titre, Object reclamation,Object email_sender) {
        this.id_reclamation=(int) id_reclamation;
        this.titre = (String) titre;
        this.reclamation = (String) reclamation;
        this.email_sender = (String) email_sender;
        this.id_personne=(int) id_personne;
    }
  
    public Reclamation (Object titre,Object reclamation){
        this.titre= (String) titre ;
        this.reclamation = (String) reclamation ;
    }

    public Reclamation(String titre, String description, String email_sender) {
        this.titre = (String) titre;
        this.reclamation = (String) description;
        this.email_sender = (String) email_sender;
    }

    public int getId_reclamation() {
        return id_reclamation;
    }

    public void setId_reclamation(int id_reclamation) {
        this.id_reclamation = id_reclamation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getReclamation() {
        return reclamation;
    }

    public void setReclamation(String reclamation) {
        this.reclamation = reclamation;
    }

    public String getEmail_sender() {
        return email_sender;
    }

    public void setEmail_sender(String email_sender) {
        this.email_sender = email_sender;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id_reclamation=" + id_reclamation + ", titre=" + titre + ", reclamation=" + reclamation + ", email_sender=" + email_sender + '}';
    }
    
}


