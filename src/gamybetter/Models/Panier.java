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
  
    
    public Panier() {
    }

    public Panier(Object id_commande, Object id_produit, Object quantite_order, Object prix_unitaire, Object prix_produit_totale, Object image, Object nom_produit) {
          this.id_commande =(String) id_commande;
        this.id_produit = (String)id_produit;
        this.quantite_order = (int)quantite_order;
        this.prix_unitaire = (double)prix_unitaire;
        this.prix_produit_totale =(double) prix_produit_totale;
        this.image = (String)image;
        this.nom_produit =(String) nom_produit;
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

    @Override
    public String toString() {
        return "Panier{" + "id_commande=" + id_commande + ", id_produit=" + id_produit + ", quantite_order=" + quantite_order + ", prix_unitaire=" + prix_unitaire + ", prix_produit_totale=" + prix_produit_totale + ", image=" + image + ", nom_produit=" + nom_produit + '}';
    }

  
    
    
}
