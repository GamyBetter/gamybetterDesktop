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
    private int id_match,id_equipe1,id_equipe2;
    private String lien_streaming,status,gold,duree ,score;
    private String image1,image2,temps;
     /*private equipe [] Equipe ; ArrayList equipe = new ArrayList(); */
   /* private coach [] Coach ; ArrayList coach = new ArrayList(); */
    /*private String [] heros;*ArrayList heros = new ArrayList(); */ 
    private Date date;
   
         
public Match() {
    }

    public Match(Object id_match, Object id_equipe1,Object id_equipe2, Object image1, Object image2,Object score, Object lien_streaming, Object status, Object gold, Object duree,Object date,Object temps) {
        this.id_match = (int)id_match;
        this.id_equipe1 =(int) id_equipe1;
        this.id_equipe2 =(int) id_equipe2;
           this.image1 = (String)image1;
        this.image2 = (String)image2;
        this.score =(String) score;
        this.lien_streaming =(String) lien_streaming;
        this.status =(String) status;
        this.gold = (String)gold;
        this.duree = (String)duree;
        
        
     
        
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
        this.temps = (String)temps;
    }

    public Match(int id_equipe1, int id_equipe2, String lien_streaming, String status, String gold, String duree, String score, String heros, String image1, String image2, String temps, Object date) {
        this.id_equipe1 = id_equipe1;
        this.id_equipe2 = id_equipe2;
        this.lien_streaming = lien_streaming;
        this.status = status;
        this.gold = gold;
        this.duree = duree;
        this.score = score;
        
        this.image1 = image1;
        this.image2 = image2;
        this.temps = temps;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
    }

    public Match(String image1, String image2, String score,String lien_streaming, String status, String gold, String duree, Object date, String temps) {
        this.image1 = image1;
        this.image2 = image2;
         this.score = score;
        this.lien_streaming = lien_streaming;
        this.status = status;
        this.gold = gold;
        this.duree = duree;
       this.temps = temps;
        DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        this.date = (Date) date;
    }



 

    
   

   

    public int getId_match() {
        return id_match;
    }

    

    

    public int getId_equipe1() {
        return id_equipe1;
    }

    public void setId_equipe1(int id_equipe1) {
        this.id_equipe1 = id_equipe1;
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

    public int getId_equipe2() {
        return id_equipe2;
    }

    public void setId_equipe2(int id_equipe2) {
        this.id_equipe2 = id_equipe2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getTemps() {
        return temps;
    }

    public void setTemps(String temps) {
        this.temps = temps;
    }

    @Override
    public String toString() {
        return "Match{" + "lien_streaming=" + lien_streaming + ", status=" + status + ", gold=" + gold + ", duree=" + duree + ", score=" + score + ", image1=" + image1 + ", image2=" + image2 + ", temps=" + temps + ", date=" + date + '}';
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
