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
public class Panier {
    private String id_commande;
    private String id_produit;
    private int quantite_order;
    private double prix_unitaire;
    private double prix_produit_totale;
    private String image;
    private String nom_produit;
    private int id_personne;
    private int discount;
  
    
    public Panier() {
    }
    
 

    public Panier(Object id_produit,Object quantite_order, Object prix_unitaire, Object discount, Object image, Object nom_produit ,Object prix_produit_totale) {
        this.id_produit =(String) id_produit; 
        this.quantite_order = (int)quantite_order; 
        this.prix_unitaire = (double)prix_unitaire;
        this.discount = (int)discount;
        this.image = (String)image;
        this.nom_produit =(String) nom_produit;
        this.prix_produit_totale =(double) prix_produit_totale;
        
        
        
    }
    
    public Panier(Object id_commande,Object id_produit,Object quantite_order, Object prix_unitaire, Object discount, Object image, Object nom_produit ,Object prix_produit_totale) {
        this.id_produit =(String) this.id_produit;  
        this.id_commande =(String) id_commande;
        this.id_produit = (String)id_produit;
        this.quantite_order = (int)quantite_order;
        this.prix_unitaire = (double)prix_unitaire;
        this.prix_produit_totale =(double) prix_produit_totale;
        this.image = (String)image;
        this.nom_produit =(String) nom_produit;
        this.discount = (int)discount;
    }

      public Panier(Object id_commande,Object  id_produit,Object  quantite_order) {
        this.id_commande =(String) id_commande;
        this.id_produit = (String)id_produit;
        this.quantite_order = (int)quantite_order;

    }
    
    public Panier(Object id_commande,Object  id_produit,Object  quantite_order, Object prix_unitaire) {
        this.id_commande =(String) id_commande;
        this.id_produit = (String)id_produit;
        this.quantite_order = (int)quantite_order;
        this.prix_unitaire = (double)prix_unitaire;
    }

    public String getId_commande() {
        return id_commande;
    }

    public void setId_commande(String id_commande) {
        this.id_commande = id_commande;
    }

    public String getId_produit() {
        return id_produit;
    }

    public void setId_produit(String id_produit) {
        this.id_produit = id_produit;
    }

    public int getQuantite_order() {
        return quantite_order;
    }

    public void setQuantite_order(int quantite_order) {
        this.quantite_order = quantite_order;
    }

    public double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public double getPrix_produit_totale() {
        return prix_produit_totale;
    }

    public void setPrix_produit_totale(double prix_produit_totale) {
        this.prix_produit_totale = prix_produit_totale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "\t\t"+nom_produit+"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t" + prix_unitaire+" DT \t\t\t\t\t\t\t\t" + quantite_order+"\t\t\t\t\t\t" +discount+"\t\t\t\t\t\t\t"+ prix_produit_totale ;
    }

    
    

  
    
    
}
