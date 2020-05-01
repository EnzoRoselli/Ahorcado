package edu.utn.ahorcado.repository.interfaces;

import java.util.List;

public interface IGenericDao<T> {
    
    T update(T value);

    void remove(Integer id);

    void remove(T value);

    T getById(Integer id);

    List<T> getAll();
}
