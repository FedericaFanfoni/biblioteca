package repository;

import config.DbConnection;
import model.Libro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LibroRepository {

    public void createLibro(Libro libro){
        String sql = "INSERT INTO libri (idl, titolo, autore) VALUES(?, ?, ?)";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, libro.getId());;
            pstmt.setString(2, libro.getTitolo());
            pstmt.setString(3, libro.getAutore());
            pstmt.executeUpdate();
            System.out.println("Libro inserito con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public List<Libro> readLibri(){
        List<Libro> listaLibri =  new ArrayList<>();
        String sql = "SELECT * FROM libri";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getString("idl"),
                        rs.getString("titolo"),
                        rs.getString("autore")
                );

                listaLibri.add(libro);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaLibri;
    }
    public Libro readLibroByID(String id){
        String sql = "SELECT * FROM libri WHERE idl = '" + id + "'";
        Libro libro = null;

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                libro = new Libro(
                        rs.getString("idl"),
                        rs.getString("titolo"),
                        rs.getString("autore")
                );
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return libro;
    }
    public List<Libro> getLibriOfPersona(int id){
        List<Libro> listaLibri =  new ArrayList<>();

        String sql = "SELECT l.* FROM libri_prestati lp\n" +
                "JOIN libri l ON l.idl = lp.idl\n" +
                "JOIN persone p ON p.id = lp.idp\n" +
                "WHERE p.id = " + id + " AND lp.fine IS NULL";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Libro libro = new Libro(
                        rs.getString("idl"),
                        rs.getString("titolo"),
                        rs.getString("autore")
                );

                listaLibri.add(libro);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaLibri;
    }
    public void updateLibro(String id, String titolo, String autore){
        String sql = "UPDATE libri SET titolo = ?, autore = ? WHERE idl = '" + id + "'";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, titolo );
            pstmt.setString(2, autore);
            pstmt.executeUpdate();
            System.out.println("Libro modificato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void deleteLibro(String id){
        String sql = "DELETE FROM libri WHERE idl = '" + id + "'";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Libro eliminato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
