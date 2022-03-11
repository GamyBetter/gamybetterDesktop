/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.util.List;

/**
 *
 * @author Sayee
 * @param <T>
 */
public interface ICommande<T> {
    public boolean add(T t);

<<<<<<< Updated upstream
    public void update(T t);

    public void delete(T t);
=======
    public boolean update(T t);

    public boolean delete(T t);
>>>>>>> Stashed changes

    public List<T> getAll();

    public T getOne(T t);
    
    public T getById(String id);
    
<<<<<<< Updated upstream
  public void SetCommandPrice(T c,double prix);  
=======
  public boolean SetCommandPrice(T c,double prix);  
>>>>>>> Stashed changes
}
