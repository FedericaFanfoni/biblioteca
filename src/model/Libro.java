package model;

public class Libro {

    private String id;
    private String titolo;
    private String autore;

    public Libro(String id, String titolo, String autore){
        this.id = id;
        this.titolo = titolo;
        this.autore = autore;
    }

    public String getId(){
        return this.id;
    }

    public String getTitolo(){
        return this.titolo;
    }

    public String getAutore(){
        return this.autore;
    }

    public String toString(){
        return "ID: " + getId() + ";\nTitolo: " + getTitolo() + ";\nAutore: " + getAutore();
    }

    public void setId(String id){
        this.id = id;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

    public void setAutore(String autore){
        this.autore = autore;
    }
}
