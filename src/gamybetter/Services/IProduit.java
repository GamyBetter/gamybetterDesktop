/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.util.List;

/**
 *
 * @author skon1
 * @param <T>
 */
public interface IProduit<T> {

    public boolean add(T t);

    public boolean update(T t);

    public boolean delete(T t);

    public List<T> getAll();

    public T getOne(T t);
    
    public T getById(String id);
    
    

}
