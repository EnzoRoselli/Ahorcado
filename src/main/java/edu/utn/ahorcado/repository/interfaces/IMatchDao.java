package edu.utn.ahorcado.repository.interfaces;

import edu.utn.ahorcado.model.Match;

import java.sql.Date;

public interface IMatchDao extends IGenericDao<Match>{
    void save(int jug1, int jug2, int palabra, Date fecha);
}
