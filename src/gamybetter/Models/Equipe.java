/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.Objects;

/**
 *
 * @author snoussi amine
 */
public class Equipe {

    private int id_equipe, id_coach;
    private String nom_eq, description_equipe;
 


    public Equipe() {
    }

    public Equipe(Object id_coach, Object nom_eq, Object description_equipe) {
 
        this.id_coach = (int) id_coach;
        this.nom_eq = (String) nom_eq;
        this.description_equipe = (String) description_equipe;
       
    }
    public Equipe(Object id_equipe,Object id_coach, Object nom_eq, Object description_equipe) {
        this.id_equipe=(int) id_equipe;
        this.id_coach = (int) id_coach;
        this.nom_eq = (String) nom_eq;
        this.description_equipe = (String) description_equipe;
       
    }

    public int getId_equipe() {
        return id_equipe;
    }

    public void setId_equipe(int id_equipe) {
        this.id_equipe = id_equipe;
    }

    public int getId_coach() {
        return id_coach;
    }

    public void setId_coach(int id_coach) {
        this.id_coach = id_coach;
    }

    public String getNom_eq() {
        return nom_eq;
    }

    public void setNom_eq(String nom_eq) {
        this.nom_eq = nom_eq;
    }

    public String getDescription_equipe() {
        return description_equipe;
    }

    public void setDescription_equipe(String description_equipe) {
        this.description_equipe = description_equipe;
    }





    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id_equipe;
        hash = 79 * hash + this.id_coach;
        hash = 79 * hash + Objects.hashCode(this.nom_eq);
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
        final Equipe other = (Equipe) obj;
        if (this.id_equipe != other.id_equipe) {
            return false;
        }
        if (this.id_coach != other.id_coach) {
            return false;
        }
        if (!Objects.equals(this.nom_eq, other.nom_eq)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "" + "                                                  "  + nom_eq + "                                                             " + description_equipe + "" ;
    }
    
    
}
