/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;


/**
 *
 * @author MAG028
 */
public class Match {
    private int id_match,score,id_equipe,id_equipe1;
    private String lien_streaming,status,gold,duree ;
    private String heros;
     /*private equipe [] Equipe ; ArrayList equipe = new ArrayList(); */
   /* private coach [] Coach ; ArrayList coach = new ArrayList(); */
    /*private String [] heros;*ArrayList heros = new ArrayList(); */ 
    private Date date;
   
         
public Match() {
    }

public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, Date date, Object heros) {
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
        this.heros = (String) heros;
        
    }


    public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, Date date,Object heros,Object id_equipe,Object id_equipe1) {
    
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_equipe1=(int) id_equipe1;
      
        
    }
    public Match(Object id_match,Object score, Object lien_streaming, Object status, Object gold, Object duree, Object date,Object heros,Object id_equipe,Object id_equipe1) {
    
        this.id_match=(int) id_match;
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        //DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_equipe1=(int) id_equipe1;
      
        
    }

   /* public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, Object Date,Object heros,Object id_equipe,Object id_equipe1) {
      this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
        this.Date = (Date) Date;
        this.heros = (String) heros;
        this.id_equipe = (int) id_equipe;
        this.id_equipe1 = (int) id_equipe1;
        
    }*/

    
    public Match(Object score, Object lien_streaming, Object status, Object gold, Object duree, LocalDate date, Object heros) {
        
        
        this.score = (int) score;
        this.lien_streaming = (String) lien_streaming;
        this.status = (String) status;
        this.gold = (String) gold;
        this.duree = (String) duree;
       // this.date = (Date) date;
        this.heros = (String) heros;
        
    }


   /* public Match(int id_match, int score, String lien_streaming, String status, String gold, String duree, LocalDate date, String heros) {
        this.id_match = id_match;
        this.score = score;
        this.lien_streaming = lien_streaming;
        this.status = status;
        this.gold = gold;
        this.duree = duree;
        this.heros = heros;
    }

   
*/
   

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

    public Date getDate() {
        return date;
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

    public void setDate(Date Date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Match{" + "score=" + score + ", lien_streaming=" + lien_streaming + ", status=" + status + ", gold=" + gold + ", duree=" + duree + ", heros=" + heros + ", Date=" + date + '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Match other = (Match) obj;
        if (this.score != other.score) {
            return false;
        }
        if (!Objects.equals(this.date, other.date)) {
            return false;
        }
        return true;
    }

   

   
   
    
}
