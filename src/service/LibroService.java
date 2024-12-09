package service;

import model.Libro;
import repository.LibroRepository;

import java.util.List;

public class LibroService {
    LibroRepository lr = new LibroRepository();

    public void createLibro(Libro libro){
        lr.createLibro(libro);
    }
    public List<Libro> readLibro(){ return lr.readLibri(); }
    public Libro readLibroByID(String id){
        return lr.readLibroByID(id);
    }
    public List<Libro> getLibriOfPersona(int id){
        return lr.getLibriOfPersona(id);
    }
    public void updateLibro(String id, String titolo, String autore){
        lr.updateLibro(id,titolo,autore);
    }
    public void deleteLibro(String id){ lr.deleteLibro(id); }
}
