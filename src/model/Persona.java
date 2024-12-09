package model;

import java.util.List;

public class Persona {

    private int id;
    private String nome;
    private String cognome;
    private List<Libro> libri;

    public Persona(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }

    public Persona(int id, String nome, String cognome){
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
    }

    public int getId(){
        return this.id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return this.cognome;
    }

    public List<Libro> getLibri(){
        return this.libri;
    }

    public String toString(){
        return getNome() + " " + getCognome() + " ID: " + getId();
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setLibri(List<Libro> libri){
        this.libri = libri;
    }
}
