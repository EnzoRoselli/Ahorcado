package edu.utn.ahorcado.repository.mysql;

import edu.utn.ahorcado.model.Match;
import edu.utn.ahorcado.repository.interfaces.IMatchDao;

import java.sql.*;
import java.util.List;

public class MatchMySQLDao implements IMatchDao {

    Connection connection;

    public MatchMySQLDao(Connection connection){
        this.connection = connection;
    }


    public void save(int jug1, int jug2, int palabra, Date fecha) {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("insert into matches(id_jugador1, id_jugador2, id_palabra, fecha) values(?,?,?,?)");
            ps.setInt(1, jug1);
            ps.setInt(2, jug2);
            ps.setInt(3, palabra);
            ps.setDate(4, fecha);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public Match update(Match value) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Match value) {

    }

    @Override
    public Match getById(Integer id) {
        return null;
    }

    @Override
    public List<Match> getAll() {return null;}

}
