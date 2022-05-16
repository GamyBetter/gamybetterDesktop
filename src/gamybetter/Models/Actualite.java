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
 * @author MAG028
 */
public class Actualite {
    private int id_actualite,id_match,id_personne;
    private String image,video ,jeu,description,titre;
    private Date date;

    public Actualite() {
    }

    public Actualite(Object id_actualite,Object id_match, Object id_personne,Object image, Object video, Object jeu,Object titre, Object description,Object date) {
        this.id_actualite = (int) id_actualite;
        this.id_match = (int)id_match;
        this.id_personne = (int)id_personne;
        this.image =(String) image;
        this.video = (String) video;
        this.jeu = (String)jeu;
        this.description = (String)description;
        this.titre = (String)titre;
      DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
    }
    public Actualite(Object id_match, Object id_personne,Object image, Object video, Object jeu,Object titre, Object description,Object date) {
      
        this.id_match = (int)id_match;
        this.id_personne = (int)id_personne;
        this.image =(String) image;
        this.video = (String) video;
        this.jeu = (String)jeu;
        this.description = (String)description;
        this.titre = (String)titre;
      DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
    }

     public Actualite(Object image, Object video, Object jeu,Object titre, Object description,Object date) {
       
        this.image =(String) image;
        this.video = (String) video;
        this.jeu = (String)jeu;
        this.description = (String)description;
        this.titre = (String)titre;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
    }
    
    
    public Actualite(Object id_actualite,Object id_match,Object id_personne,Object image, Object video) {
        this.id_actualite = (int) id_actualite;
        this.image = (String) image;
        this.video = (String) video;
        this.id_match = (int) id_match;
        this.id_personne=(int) id_personne;
    }
    

    
    public Actualite(Object image, Object video) {
        this.image = (String) image;
        this.video = (String) video;
    }
    
  /*  public Actualite(Object image, Object video, Object id_match, Object id_personne) {
        this.image = (String) image;
        this.video = (String) video;
        this.id_match = (int) id_match;
        this.id_match = (int) id_personne;
    }
*/
   /* public Actualite(Object image, Object video,Object id_match,Object id_personne) {
        this.image = (String) image;
        this.video = (String) video;
        this.id_m&atch = (int) id_match;
        this.id_personne=(int) id_personne;
    }*/

    public Actualite(int id_match, int id_personne, String image, String video) {
        this.id_match = id_match;
        this.id_personne = id_personne;
        this.image = image;
        this.video = video;
    }
    
    
    

    public String getJeu() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu = jeu;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

   

    
    
    public int getId_actualite() {
        return id_actualite;
    }

    public void setId_actualite(int id_actualite) {
        this.id_actualite = id_actualite;
    }

    public String getImage() {
        return image;
    }

    public String getVideo() {
        return video;
    }

    public int getId_match() {
        return id_match;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public int getId_personne() {
        return id_personne;
    }

    public void setId_personne(int id_personne) {
        this.id_personne = id_personne;
    }

    @Override
    public String toString() {
        return image + "\t " + video + "\t" + jeu + "\t" + description + "\t" + titre + "\t" + date;
    }

   
    
    

 
   
    
    
   
    
}
