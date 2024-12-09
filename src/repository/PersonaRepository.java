package repository;

import config.DbConnection;
import model.Persona;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonaRepository {

    public void createPersona(Persona persona){
        String sql = "INSERT INTO persone ( nome, cognome) VALUES(?, ?)";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, persona.getNome());;
            pstmt.setString(2, persona.getCognome());
            pstmt.executeUpdate();
            System.out.println("Persona aggiunta con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public List<Persona> readPersone(){
        List<Persona> listaPersone = new ArrayList<>();
        String sql = "SELECT * FROM persone";

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Persona persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome")
                );

                listaPersone.add(persona);
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }

        return listaPersone;
    }
    public Persona readPersonaByID(int id){
        String sql = "SELECT * FROM persone WHERE id = " + id;
        Persona persona = null;

        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                persona = new Persona(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getString("cognome")
                );
            }
        }
        catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return persona;
    }
    public void updatePersona(int id, String nome, String cognome){
        String sql = "UPDATE persone SET nome = ?, cognome = ? WHERE id = ? ";
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql);
        ) {
            pstmt.setString(1, nome );
            pstmt.setString(2, cognome);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Persona modificata con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
    public void deletePersona(int id){
        String sql = "DELETE FROM persone WHERE id = " + id;
        try (Connection c = DbConnection.openConnection();
             PreparedStatement pstmt = c.prepareStatement(sql)
        ) {
            pstmt.executeUpdate();
            System.out.println("Persona eliminato con successo!");

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
