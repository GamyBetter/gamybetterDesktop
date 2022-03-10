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
public interface ICommentaire<T> {
    public void ajouter(T t);
    public T getById(int id);
    public List<T> getAll();
    public boolean modifier(T t);
    public boolean supprimer(T t);
    public List<T> getAllByID(int id);
    public T getOne(T t);
    
}
