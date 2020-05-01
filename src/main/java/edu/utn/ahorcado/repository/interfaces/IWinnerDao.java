package edu.utn.ahorcado.repository.interfaces;

import edu.utn.ahorcado.model.Winner;

import java.sql.Date;

public interface IWinnerDao extends IGenericDao<Winner>{
    void save(Winner winner);
}
