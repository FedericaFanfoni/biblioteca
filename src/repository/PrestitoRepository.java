package repository;

import config.DbConnection;
import model.Libro;
import model.Persona;
import model.Prestito;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrestitoRepository {

    public void createPrestito(Prestito p){
        String sql = "INSERT INTO libri_prestati (idp, idl, inizio) VALUES(?, ?, ?)";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setInt(1, p.getPersona().getId());
            pstmt.setString(2, p.getLibro().getId());
            pstmt.setDate(3, Date.valueOf(p.getInizio()));
            pstmt.executeUpdate();
            System.out.println("Prestito aggiunto con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void updatePrestito(LocalDate fine, String idLibro){
        String sql = "UPDATE libri_prestati SET fine = ? WHERE idl = ? AND fine IS NULL";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setDate(1, Date.valueOf(fine));
            pstmt.setString(2, idLibro);
            pstmt.executeUpdate();
            System.out.println("Prestito modificata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }


    }
    public List<Prestito> readPrestiti(){
        List<Prestito> prestiti = new ArrayList<>();
        String sql =
                "SELECT p.nome, p.cognome, l.idl, l.titolo, l.autore, lp.inizio, lp.fine FROM libri_prestati lp\n" +
                "JOIN persone p ON p.id = lp.idp\n" +
                "JOIN libri l ON l.idl = lp.idl";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {

                Persona p  = new Persona(rs.getString("nome"), rs.getString("cognome"));
                Libro l = new Libro(rs.getString("idl"), rs.getString("titolo"), rs.getString("autore"));

                Prestito prestito = new Prestito(
                        l,
                        p,
                        rs.getDate("inizio").toLocalDate(),
                        rs.getDate("fine") == null ? null : rs.getDate("fine").toLocalDate()
                        );
                prestiti.add(prestito);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return prestiti;
    }
}
