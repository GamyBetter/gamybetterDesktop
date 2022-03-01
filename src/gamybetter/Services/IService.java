/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.util.List;

/**
 *
 * @author Mariem
 */
public interface IService <C>{
     public void add(C c);

    public boolean update(C c);

    public boolean delete(C c);

    public List<C> getAll();
    
   public C getOne(C c); 
    public C getById(int id);

    
}
