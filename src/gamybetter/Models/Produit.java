/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

import java.util.Objects;

/**
 *
 * @author Sayee
 */
public class Produit {
    private String id;
    private String nom_produit;
    private String categorie;
    private double prix;
    private String image;
    private String description;
    private int quantite_stock;
    private int discount;
    
    public Produit(){
}
    
    public Produit(Object id, Object nom_produit ,  Object description , Object categorie   , Object quantite ,Object prix ){
        
       this.id =(String) id;
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix =(double) prix;
        this.description =(String) description;
        this.quantite_stock =(int) quantite;
    }

     public Produit(Object nom_produit  , Object description , Object categorie   , Object quantite ,Object prix ){
       
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix =(double) prix;
        this.description =(String) description;
        this.quantite_stock =(int) quantite;

    }
     
    public Produit(Object id , Object image, Object nom_produit ,  Object description , Object categorie   , Object quantite ,Object prix ,Object discount){
        this.id =(String) id;
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix =(double) prix;
        this.image =(String) image;
        this.description =(String) description;
        this.quantite_stock =(int) quantite;
        this.discount =(int) discount;
    }

  
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the nom_produit
     */
    public String getNom_produit() {
        return nom_produit;
    }

    /**
     * @param nom_produit the nom_produit to set
     */
    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    /**
     * @return the categorie
     */
    public String getCategorie() {
        return categorie;
    }

    /**
     * @param categorie the categorie to set
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    /**
     * @return the prix
     */
    public double getPrix() {
        return prix;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(double prix) {
        this.prix = prix;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the quantite
     */
    public int getQuantiteStock() {
        return quantite_stock;
    }

    /**
     * @param quantite the quantite to set
     */
    public void setQuantiteStock(int quantite) {
        this.quantite_stock = quantite;
    }

    @Override
    public String toString() {
        return "\t"+  nom_produit + "\t \t \t\t \t \t" + categorie + "\t \t \t\t \t \t" + description + "\t \t \t \t \t \t\t \t \t" + prix + " DT\t \t \t " +discount +"\t \t \t"+quantite_stock;
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
        final Produit other = (Produit) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

  
    
    
    
}
