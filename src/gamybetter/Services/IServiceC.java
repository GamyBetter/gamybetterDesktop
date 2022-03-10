/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamybetter.Services;

import java.util.List;

/**
 *
 * @author USER
 */
public interface IServiceC<T> {
    public void ajouter(T t);
    public T getById(String id);
    public List<T> getAll();
    public boolean modifier(T t);
    public boolean supprimer(T t);
    public T getOne(T t);
}
