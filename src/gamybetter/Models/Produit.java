/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Models;

/**
 *
 * @author Sayee
 */
public class Produit {
    private int id;
    private String nom_produit;
    private String categorie;
    private float prix;
    private String image;
    private String description;
    private int quantite_stock;
    

      public Produit() {
    }
    public Produit(Object nom_produit , Object prix , Object categorie , Object image , Object description, Object quantite  ){
        
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix = (float) prix;
        this.image =(String) image;
        this.quantite_stock =(int) quantite;
        this.description =(String) description;
    }
    
    public Produit(Object id,Object nom_produit , Object prix , Object categorie , Object image , Object description, Object quantite  ){
        this.id=(int) id;
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix = (float) prix;
        this.image =(String) image;
        this.quantite_stock =(int) quantite;
        this.description =(String) description;
    }

    /* public Produit(Object image , Object nom_produit , Object prix ){
        
        this.nom_produit =(String) nom_produit;
        this.prix = (float) prix;
        this.image =(String) image;

    }
     
    public Produit(Object id , Object nom_produit , Object prix , Object categorie , Object image ,  Object description , Object quantite ){
        this.id =(int) id;
        this.nom_produit =(String) nom_produit;
        this.categorie =(String) categorie;
        this.prix =(float) prix;
        this.image =(String) image;
        this.description =(String) description;
        this.quantite_stock =(int) quantite;
    }
*/
  
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
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
    public float getPrix() {
        return prix;
    }

    /**
     * @param prix the prix to set
     */
    public void setPrix(float prix) {
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
        return "Produit{" + "id=" + id + ", nom_produit=" + nom_produit + ", categorie=" + categorie + ", prix=" + prix + ", image=" + image + ", description=" + description + ", quantite=" + quantite_stock + '}';
    }
    
    
    
}
