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
    private int id_match;
    private String image,video ;

    public Actualite() {
    }

    public Actualite(Object image, Object video) {
        this.image = (String) image;
        this.video = (String) video;
    }

    public Actualite(Object image, Object video,Object id_match) {
        this.image = (String) image;
        this.video = (String) video;
        this.id_match = (int) id_match;
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

    @Override
    public String toString() {
        return "Actualite{" + "id_match=" + id_match + ", image=" + image + ", video=" + video + '}';
    }

   
    
    
   
    
}
