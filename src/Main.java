import model.Libro;
import model.Persona;
import model.Prestito;
import service.LibroService;
import service.PersonaService;
import service.PrestitoService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        sceltaMenu();
    }

    public static void sceltaMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Scegli in quale menù andare.");
        System.out.println("1. Libri");
        System.out.println("2. Persone");
        System.out.println("3. Prestiti");
        System.out.println("4. Exit");

        int choice = scanner.nextInt();

        avvioMenu(choice);
    }

    public static void avvioMenu(int choice) {
        Scanner scanner = new Scanner(System.in);
        if (choice == 1) {
            int select;
            do {

                System.out.println("***Menù Libri***");
                System.out.println("1. Aggiungi un libro");
                System.out.println("2. Lista dei libri");
                System.out.println("3. Modifica un libro");
                System.out.println("4. Elimina un libro");
                System.out.println("5. Torna alla selezione del menù");

                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createLibro();
                        break;
                    case 2:
                        readLibri();
                        break;
                    case 3:
                        updateLibro();
                        break;
                    case 4:
                        deleteLibro();
                        break;
                    case 5:
                        sceltaMenu();
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                    }

                } while (choice < 6);
                  scanner.close();
        }else if(choice == 2){
            int select;
            do {

                System.out.println("***Menù Persone***");
                System.out.println("1. Aggiungi una persona");
                System.out.println("2. Lista delle persone");
                System.out.println("3. Modifica una persona");
                System.out.println("4. Elimina una persona");
                System.out.println("5. Torna alla selezione del menù");

                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        createPersona();
                        break;
                    case 2:
                        readPersone();
                        break;
                    case 3:
                        updatePersona();
                        break;
                    case 4:
                        deletePersona();
                        break;
                    case 5:
                        sceltaMenu();
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 6);
            scanner.close();

        }else if(choice == 3){
            int select;
            do {

                System.out.println("***Menù Prestiti***");
                System.out.println("1. Effettua prestito");
                System.out.println("2. Restituisci libro");
                System.out.println("3. Lista dei prestiti");
                System.out.println("4. Torna alla selezione del menù");

                select = scanner.nextInt();

                switch (select) {
                    case 1:
                        effettuaPrestito();
                        break;
                    case 2:
                        updatePrestito();
                        break;
                    case 3:
                        readPrestiti();
                        break;
                    case 4:
                        sceltaMenu();
                        break;
                    default:
                        System.out.println("Scelta non valida");
                        avvioMenu(choice);
                }

            } while (choice < 4);
            scanner.close();
        }
    }

    public static void createLibro(){
        LibroService ls = new LibroService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il codice del libro");
        String codiceLibro = scanner.nextLine();

        System.out.println("Inserisci il titolo del libro");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci il nome dell'autore del libro");
        String autore = scanner.nextLine();

        Libro libro = new Libro(codiceLibro, titolo, autore);

        ls.createLibro(libro);
    }
    public static void readLibri(){
        LibroService ls = new LibroService();

        for(Libro libro : ls.readLibro()){
            System.out.println(libro.toString());
        }
    }
    public static void updateLibro(){
        LibroService ls = new LibroService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale libro vuoi modificare");
        readLibri();

        System.out.println("Inserisci il codice del libro da modificare");
        String id = scanner.nextLine();

        System.out.println("Inserisci il nuovo titolo");
        String titolo = scanner.nextLine();

        System.out.println("Inserisci il nuovo autore");
        String autore = scanner.nextLine();

        ls.updateLibro(id, titolo, autore);
    }
    public static void deleteLibro(){
        LibroService ls = new LibroService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale libro vuoi eliminare");
        readLibri();

        System.out.println("Inserisci il codice del libro da modificare");
        String id = scanner.nextLine();

        ls.deleteLibro(id);

    }

    public static void createPersona(){
        PersonaService ps = new PersonaService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci il nome");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il cognome");
        String cognome = scanner.nextLine();


        Persona persona = new Persona(nome, cognome);

        ps.createPersona(persona);
    }
    public static void readPersone(){
        PersonaService ps = new PersonaService();

        for(Persona persona : ps.readPersone()){
            System.out.println(persona.toString());
        }
    }
    public static void updatePersona(){
        PersonaService ps = new PersonaService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale persona vuoi modificare");
        readPersone();

        System.out.println("Inserisci l'ID della persona da modificare");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inserisci il nuovo nome");
        String nome = scanner.nextLine();

        System.out.println("Inserisci il nuovo cognome");
        String cognome = scanner.nextLine();

        ps.updatePersona(id, nome, cognome);
    }
    public static void deletePersona(){
        PersonaService ps = new PersonaService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli quale persona vuoi eliminare");
        readPersone();

        System.out.println("Inserisci il codice della da modificare");
        int id = scanner.nextInt();

        ps.deletePersona(id);
    }

    public static void effettuaPrestito(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleziona l'utente che effettua il prestito");
        readPersone();
        System.out.println("Scrivi l'id dell'utente");
        int idPersona = scanner.nextInt();

        PersonaService ps = new PersonaService();
        Persona persona = ps.readPersonaByID(idPersona);

        System.out.println("Seleziona il libro da dare in prestito");
        readLibri();
        System.out.println("Scrivi l'id del libro scelto");
        scanner.nextLine();
        String idLibro = scanner.nextLine();

        LibroService ls = new LibroService();
        Libro libro = ls.readLibroByID(idLibro);

        LocalDate inizio = LocalDate.now();

        PrestitoService prs = new PrestitoService();
        Prestito p = new Prestito(libro, persona, inizio);
        prs.createPrestito(p);

    }
    public static void updatePrestito(){
        Scanner scanner = new Scanner(System.in);
        LibroService ls = new LibroService();

        System.out.println("Seleziona l'utente che effettua la restituizione");
        readPersone();
        System.out.println("Scrivi l'id dell'utente");
        int idPersona = scanner.nextInt();
        scanner.nextLine();

        List<Libro> libri = ls.getLibriOfPersona(idPersona);

        if(!libri.isEmpty()){

            for(Libro libro : libri){
                System.out.println(libro.toString());
            }

            System.out.println("Seleziona libro da restituire");
            String idLibro = scanner.nextLine();

            LocalDate fine = LocalDate.now();

            PrestitoService ps = new PrestitoService();
            ps.updatePrestito(fine, idLibro);
        }else {
            System.out.println("Nessun libro da restituire");
        }

    }
    public static void readPrestiti(){
        PrestitoService ps = new PrestitoService();

            ps.readPrestiti().forEach(System.out::println);


    }
}