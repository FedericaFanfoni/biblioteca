package service;

import model.Persona;
import repository.PersonaRepository;

import java.util.List;

public class PersonaService {
    PersonaRepository pr = new PersonaRepository();

    public void createPersona(Persona persona){
        pr.createPersona(persona);
    }
    public List<Persona> readPersone(){ return pr.readPersone(); }
    public Persona readPersonaByID(int id){
        return pr.readPersonaByID(id);
    }
    public void updatePersona(int id, String nome, String cognome){ pr.updatePersona(id, nome, cognome); }
    public void deletePersona(int id){ pr.deletePersona(id); }
}
