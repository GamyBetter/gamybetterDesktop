/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

/**
 *
 * @author MAG028
 */
public class Actualite {
    private int id_match,id_personne;
    private String image,video ;

    public Actualite() {
    }
/*
    public Actualite(Object image, Object video) {
        this.image = (String) image;
        this.video = (String) video;
    }*/

    public Actualite(Object image, Object video,Object id_match,Object id_personne) {
        this.image = (String) image;
        this.video = (String) video;
        this.id_match = (int) id_match;
        this.id_personne=(int) id_personne;
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
        return "Actualite{" + "id_match=" + id_match + ", image=" + image + ", video=" + video + '}';
    }

   
    
    
   
    
}
