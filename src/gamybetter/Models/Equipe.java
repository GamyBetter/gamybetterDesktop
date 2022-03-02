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
    private String nom_eq, description_equipe, nom_coach;
    private String membre_equipe1, membre_equipe2, membre_equipe3, membre_equipe4, membre_equipe5;
    private String match;

    public Equipe() {
    }

    public Equipe(Object id_equipe, Object id_coach, Object nom_eq, Object description_equipe, Object nom_coach, Object membre_equipe1, Object membre_equipe2, Object membre_equipe3, Object membre_equipe4, Object membre_equipe5, Object match) {
        this.id_equipe = (int) id_equipe;
        this.id_coach = (int) id_coach;
        this.nom_eq = (String) nom_eq;
        this.description_equipe = (String) description_equipe;
        this.nom_coach = (String) nom_coach;
        this.membre_equipe1 = (String) membre_equipe1;
        this.membre_equipe2 = (String) membre_equipe2;
        this.membre_equipe3 = (String) membre_equipe3;
        this.membre_equipe4 = (String) membre_equipe4;
        this.membre_equipe5 = (String) membre_equipe5;
        this.match = (String) match;
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

    public String getNom_coach() {
        return nom_coach;
    }

    public void setNom_coach(String nom_coach) {
        this.nom_coach = nom_coach;
    }

    public String getMembre_equipe1() {
        return membre_equipe1;
    }

    public void setMembre_equipe1(String membre_equipe1) {
        this.membre_equipe1 = membre_equipe1;
    }

    public String getMembre_equipe2() {
        return membre_equipe2;
    }

    public void setMembre_equipe2(String membre_equipe2) {
        this.membre_equipe2 = membre_equipe2;
    }

    public String getMembre_equipe3() {
        return membre_equipe3;
    }

    public void setMembre_equipe3(String membre_equipe3) {
        this.membre_equipe3 = membre_equipe3;
    }

    public String getMembre_equipe4() {
        return membre_equipe4;
    }

    public void setMembre_equipe4(String membre_equipe4) {
        this.membre_equipe4 = membre_equipe4;
    }

    public String getMembre_equipe5() {
        return membre_equipe5;
    }

    public void setMembre_equipe5(String membre_equipe5) {
        this.membre_equipe5 = membre_equipe5;
    }

    public String getMatch() {
        return match;
    }

    public void setMatch(String match) {
        this.match = match;
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
    
}
