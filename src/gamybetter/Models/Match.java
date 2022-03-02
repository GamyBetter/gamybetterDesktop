/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.ArrayList;


/**
 *
 * @author MAG028
 */
public class Match {
    private int id_match,score,id_equipe,id_equipe1;
    private String lien_streaming,status,gold,duree ;
    private String Date,heros;
     /*private equipe [] Equipe ; ArrayList equipe = new ArrayList(); */
   /* private coach [] Coach ; ArrayList coach = new ArrayList(); */
    /*private String [] heros;*ArrayList heros = new ArrayList(); */ 

   
         
public Match() {
    }
    public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe,Object id_equipe1) {
    
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        this.Date = (String) Date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_equipe1=(int) id_equipe1;
      
        
    }
    public Match(Object id_match,Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe,Object id_equipe1) {
    
        this.id_match=(int) id_match;
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        this.Date = (String) Date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_equipe1=(int) id_equipe1;
      
        
    }

   /* public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe,Object id_personne) {
      this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        this.Date = (String) Date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_personne = (int) id_personne;
        
    }*/

   

    public int getId_match() {
        return id_match;
    }

    public int getScore() {
        return score;
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public int getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(int id_equipe1) {
        this.id_equipe1 = id_equipe1;
    }

 

    public String getHeros() {
        return heros;
    }

    public String getLien_streaming() {
        return lien_streaming;
    }

    public String getStatus() {
        return status;
    }

    public String getGold() {
        return gold;
    }

    public String getDuree() {
        return duree;
    }

    public String getDate() {
        return Date;
    }

    public void setId_match(int id_match) {
        this.id_match = id_match;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setEquipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }



    public void setHeros(String heros) {
        this.heros = heros;
    }

    public void setLien_streaming(String lien_streaming) {
        this.lien_streaming = lien_streaming;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    @Override
    public String toString() {
        return "Match{" + "id=" + id_match + ", score=" + score + ", equipe=" + id_equipe + ", lien_streaming=" + lien_streaming + ", status=" + status + ", gold=" + gold + ", duree=" + duree + ", Date=" + Date + ", heros=" + heros + '}';
    }

   
    
}
