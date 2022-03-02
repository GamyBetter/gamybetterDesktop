/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.Objects;

/**
 *
 * @author skon1
 */
public class Cours {
    int id;
    int id_coach;
    String email_coach;
    String categorie;
    String jeu;
    float prix;
    String lien_session;
    String liste_personnes;
    int id_session;

 public Cours() {
    }
    //without id
    public Cours(Object id_coach, Object email_coach, Object categorie, Object jeu, Object prix, Object lien_session,Object liste_personnes, Object id_session) {
        this.id_coach =(int) id_coach;
        this.email_coach =(String) email_coach;
        this.categorie =(String) categorie;
        this.jeu =(String) jeu;
        this.prix =(float) prix;
        this.lien_session =(String) lien_session;
        this.liste_personnes=(String)liste_personnes;
        this.id_session=(int)id_session;
    }
     public Cours(Object id,Object id_coach, Object email_coach, Object categorie, Object jeu, Object prix, Object lien_session,Object liste_personnes, Object id_session) {
         this.id=(int) id;
         this.id_coach =(int) id_coach;
        this.email_coach =(String) email_coach;
        this.categorie =(String) categorie;
        this.jeu =(String) jeu;
        this.prix =(float) prix;
        this.lien_session =(String) lien_session;
        this.liste_personnes=(String)liste_personnes;
        this.id_session=(int)id_session;
    }
    
    
    //with id
   /* public Cours(int id, int id_coach, String email_coach, String categorie, String jeu, float prix, String lien_session) {
        this.id = id > 0 ? id : 0;
        this.id_coach = id_coach;
        this.email_coach = email_coach;
        this.categorie = categorie;
        this.jeu = jeu;
        this.prix = prix;
        this.lien_session = lien_session;
    }
    
    public Cours(Object id, Object id_coach, Object email_coach, Object categorie, Object jeu, Object prix, Object lien_session) {
        this.id = (int)id;
        this.id_coach = (int)id_coach;
        this.email_coach = (String)email_coach;
        this.categorie = (String)categorie;
        this.jeu = (String)jeu;
        this.prix = (float)prix;
        this.lien_session = (String)lien_session;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public String getEmail_coach() {
        return email_coach;
    }

    public void setEmail_coach(String email_coach) {
        this.email_coach = email_coach;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getJeu() {
        return jeu;
    }

    public void setJeu(String jeu) {
        this.jeu = jeu;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public String getLien_session() {
        return lien_session;
    }

    public void setLien_session(String lien_session) {
        this.lien_session = lien_session;
    }

    public String getListe_personnes() {
        return liste_personnes;
    }

    public void setListe_personnes(String liste_personnes) {
        this.liste_personnes = liste_personnes;
    }

    public int getId_session() {
        return id_session;
    }

    public void setId_session(int id_session) {
        this.id_session = id_session;
    }

    @Override
    public String toString() {
        return "Cours{" + "id=" + id + ", id_coach=" + id_coach + ", email_coach=" + email_coach + ", categorie=" + categorie + ", jeu=" + jeu + ", prix=" + prix + ", lien_session=" + lien_session + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cours other = (Cours) obj;
        if (this.id_coach != other.id_coach) {
            return false;
        }
        if (!Objects.equals(this.email_coach, other.email_coach)) {
            return false;
        }
        if (!Objects.equals(this.categorie, other.categorie)) {
            return false;
        }
        if (!Objects.equals(this.jeu, other.jeu)) {
            return false;
        }
        if (Float.floatToIntBits(this.prix) != Float.floatToIntBits(other.prix)) {
            return false;
        }
        if (!Objects.equals(this.lien_session, other.lien_session)) {
            return false;
        }
        return true;
    }
    
    
    
}
