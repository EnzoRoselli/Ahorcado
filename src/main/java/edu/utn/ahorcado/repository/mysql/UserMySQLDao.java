package edu.utn.ahorcado.repository.mysql;

import edu.utn.ahorcado.model.User;
import edu.utn.ahorcado.model.UserLocal;
import edu.utn.ahorcado.repository.interfaces.IUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserMySQLDao implements IUserDao {

    Connection connection;

    public UserMySQLDao(Connection connection){
        this.connection = connection;
    }


    public User save(User u) {
        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("insert into jugadores(username) values(?)");
            ps.setString(1, u.getUsername());
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

        return null;
    }

    @Override
    public UserLocal update(User value) {
        return null;
    }

    @Override
    public void remove(Integer id) {
        new UnsupportedOperationException();
    }

    @Override
    public void remove(User value) {
        new UnsupportedOperationException();
    }

    @Override
    public User getById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT id, username FROM jugadores WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            User user =null;

            if(rs.next()){
                user = new User(rs.getInt("id"), rs.getString("username"));
            }

            return user;
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

    @Override
    public List<User> getAll() {
        return null;
    }
}
