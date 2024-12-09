package service;

import model.Prestito;
import repository.PrestitoRepository;

import java.time.LocalDate;
import java.util.List;

public class PrestitoService {
    PrestitoRepository pr = new PrestitoRepository();

    public void createPrestito(Prestito p){
        pr.createPrestito(p);
    }
    public void updatePrestito(LocalDate fine, String idLibro){
        pr.updatePrestito(fine, idLibro);
    }
    public List<Prestito> readPrestiti(){
        return pr.readPrestiti();
    }
}
