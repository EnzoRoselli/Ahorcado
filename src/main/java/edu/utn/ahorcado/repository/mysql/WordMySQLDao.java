package edu.utn.ahorcado.repository.mysql;

import edu.utn.ahorcado.model.Word;
import edu.utn.ahorcado.repository.interfaces.IWordDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordMySQLDao implements IWordDao {

    Connection connection;

    public WordMySQLDao(Connection connection){
        this.connection = connection;
    }


    public Word save(Word value) {

        PreparedStatement ps=null;
        try {
            ps = connection.prepareStatement("insert into palabras(palabra) values(?)");
            ps.setString(1, value.getPalabra());
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
    public Word update(Word value) {
        return null;
    }

    @Override
    public void remove(Integer id) {}

    @Override
    public void remove(Word value) {}

    @Override
    public Word getById(Integer id) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT id, palabra FROM palabras WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            Word word=null;

            if(rs.next()){
                word = new Word(rs.getInt("id"), rs.getString("palabra"));
            }

            return word;
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
    public List<Word> getAll() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = connection.prepareStatement("SELECT * FROM palabras");
            rs = ps.executeQuery();
            List<Word>  words= new ArrayList<>();

            while(rs.next()){
                words.add(new Word(rs.getInt("id"), rs.getString("palabra")));
            }

            return words;
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
    public Word getRandomWord() {

        List<Word> palabras = getAll();

        Word palabra;
        Random r = new Random();

        palabra = palabras.get(r.nextInt(palabras.size()));

        return palabra;
    }
}
