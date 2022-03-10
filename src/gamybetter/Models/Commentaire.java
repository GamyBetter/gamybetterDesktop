/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

/**
 *
 * @author Mariem
 */
public class Commentaire {

    private int id_commentaire, nbr_like, nbr_dislike, id_personne,id_publication;
    private String cont_commentaire;

    private String date;

  

 

    public Commentaire(Object id_personne, Object date, Object cont_commentaire,Object id_publication) {
        this.id_publication=(int) id_publication;
        this.id_personne = (int) id_personne;
        this.date = (String) date;
        this.cont_commentaire = (String) cont_commentaire;
    }
    public Commentaire(Object id_commentaire,Object id_personne, Object date, Object cont_commentaire,Object id_publication) {
        this.id_commentaire=(int) id_commentaire;
        this.id_personne = (int) id_personne;
        this.date = (String) date;
        this.cont_commentaire = (String) cont_commentaire;
        this.id_publication=(int) id_publication;
    }

    public Commentaire() {
    }

    public int getIdCommentaire() {
        return id_commentaire;
    }

    public void setIdCommentaire(int id) {
        this.id_commentaire = id_commentaire;
    }

    public int getNbr_like() {
        return nbr_like;
    }

    public void setNbr_like(int nbr_like) {
        this.nbr_like = nbr_like;
    }

    public int getNbr_dislike() {
        return nbr_dislike;
    }

    public void setNbr_dislike(int nbr_dislike) {
        this.nbr_dislike = nbr_dislike;
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

    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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
        return "Commentaire{" + "id_commentaire=" + id_commentaire + ", nbr_like=" + nbr_like + ", nbr_dislike=" + nbr_dislike + ", id_personne=" + id_personne + ", cont_commentaire=" + cont_commentaire + ", date=" + date + '}';
    }

   

}
