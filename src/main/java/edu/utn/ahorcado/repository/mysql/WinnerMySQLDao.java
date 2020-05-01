package edu.utn.ahorcado.repository.mysql;

import edu.utn.ahorcado.model.Match;
import edu.utn.ahorcado.model.Winner;
import edu.utn.ahorcado.repository.interfaces.IWinnerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class WinnerMySQLDao implements IWinnerDao {

    private Connection connection;

    public WinnerMySQLDao(Connection connection){
        try {
            this.connection = ConnectionMySQL.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void save(Winner value) {

        PreparedStatement ps=null;

        try {
            ps = connection.prepareStatement("insert into ganadores(id_jugador, id_palabra, fecha) values(?,?,?)");
            ps.setInt(1, value.getJugId());
            ps.setInt(2, value.getPalabraId());
            ps.setDate(3, value.getFecha());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            ConnectionMySQL.close(ps);
        }

    }

    @Override
    public Winner update(Winner value) {
        return null;
    }

    @Override
    public void remove(Integer id) {

    }

    @Override
    public void remove(Winner value) {

    }

    @Override
    public Winner getById(Integer id) {
        return null;
    }

    @Override
    public List<Winner> getAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM ganadores");
            rs = ps.executeQuery();
            List<Winner> winner = new ArrayList<>();

            if(rs.next()){
                winner.add(new Winner(rs.getInt("id"), rs.getInt("id_jugador"),
                        rs.getInt("id_palabra"), rs.getDate("fecha")));
            }

            return winner;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }
}
