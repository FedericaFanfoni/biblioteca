package model;

import java.time.LocalDate;

public class Prestito {

    private int id;
    private Libro libro;
    private Persona persona;
    private LocalDate inizio;
    private LocalDate fine;

    /*public Prestito(Libro libro, Persona persona){
        this.libro  = libro;
        this.persona = persona;
    }*/

    public Prestito(Libro libro, Persona persona, LocalDate inizio) {
        this.libro = libro;
        this.persona = persona;
        this.inizio = inizio;
    }

    public Prestito(Libro libro, Persona persona, LocalDate inizio, LocalDate fine){
        this.libro  = libro;
        this.persona = persona;
        this.inizio = inizio;
        this.fine = fine;
    }

    public int getId(){
        return this.id;
    }

    public Libro getLibro(){
        return  this.libro;
    }

    public Persona getPersona(){
        return this.persona;
    }

    public LocalDate getInizio(){
        return this.inizio;
    }

    public LocalDate getFine(){
        return this.fine;
    }

    public String toString(){
        return "Utente: " + getPersona().getNome() + " " + getPersona().getCognome() + ", " + getLibro().getTitolo();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLibro(Libro libro){
        this.libro = libro;
    }

    public void setPersona(Persona persona){
        this.persona = persona;
    }

    public void setInizio(LocalDate inizio){
        this.inizio = inizio;
    }

    public void setFine(LocalDate fine){
        this.fine = fine;
    }
}
