/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.util.List;
import javafx.collections.ObservableList;
import gamybetter.Models.Panier;

/**
 *
 * @author Sayee
 * @param <T>
 */
public interface IPanier<T>{
     public boolean add(Panier t);

<<<<<<< Updated upstream
    public void update(Panier t);

    public void delete(Panier t);
=======
    public boolean update(Panier t);

    public boolean delete(Panier t);
>>>>>>> Stashed changes

    //public ObservableList<Panier> getItems();
    
    public List<Panier> getAll();

    public Panier getOne(Panier t);
    
    List<Panier> getItems(String id_commande);//String id_commande,int id_personne
    
    
    public Panier getById(int id);
    
    public double getItemPrix(String id);
}
