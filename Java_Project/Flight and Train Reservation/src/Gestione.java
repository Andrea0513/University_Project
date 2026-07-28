import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Gestione {

    public static void stampaSuFile(Prenotazione[] filtro) {
        String nomefile = "Nuovofile.txt";
        PrintWriter miofile = null;

        try {
            miofile = new PrintWriter(nomefile);
            for (int i = 0; i < filtro.length; i++) {
                miofile.println(filtro[i].toString());
            }
            System.out.println("\nScrittura su file '" + nomefile + "' completata con successo!");
        } catch (FileNotFoundException e) {
            System.out.println("Errore in apertura del file: " + nomefile);
            System.out.println("Il programma termina.");
            System.exit(0);
        }
        if (miofile != null) {
            miofile.close();
        
        }
    }

    public static void contaClassi(Prenotazione[] filtro) {
        int cv = 0;
        int ct = 0;
        for (int i = 0; i < filtro.length; i++) {
            if (filtro[i] instanceof Volo) {
                cv++;
            } else if (filtro[i] instanceof Treno) {
                ct++;
            }
        }
        System.out.println("Nel filtro selezionato sono presenti " + cv + " prenotazioni Volo e " + ct + " prenotazioni Treno.");
    }

    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        String dataSearch;
        int ore, minuti;

        Persona bm = new Persona("Bianchi", "Maria");
        Persona rm = new Persona("Rossi", "Mario");

        Treno rmm = new Treno("PL456", "ROMA", "MILANO", "5/7/2024", 9, 30, bm, 11, "14D");
        Treno rnm = new Treno("PH123", "ROMA", "NAPOLI", "5/7/2024", 13, 20, bm, 8, "15A");
        
        // [CORREZIONE BUG]: Passaggio corretto dei parametri nel nuovo ordine per non invertire l'orario di partenza con il gate di chiusura!
        Volo afm = new Volo("EJ1212", "ATENE", "FRANCOFORTE", "1/8/2025", 11, 45, "23B", 40, rm);
        Volo rnmr = new Volo("AZ1515", "ROMA", "NAPOLI", "5/7/2024", 20, 13, "21C", 40, rm);

        Elenco p = new Elenco();
        p.push(rnmr);
        p.push(afm);
        p.push(rnm);
        p.push(rmm);

        System.out.println("=== SISTEMA DI GESTIONE PRENOTAZIONI VIAGGI ===\n");
        System.out.print("Inserisci la data da cercare nel formato gg/mm/aaaa (es. 5/7/2024): ");
        dataSearch = tastiera.next();

        System.out.print("Inserisci l'ora di partenza minima (es. 10): ");
        ore = tastiera.nextInt();
        System.out.print("Inserisci i minuti di partenza minimi (es. 00): ");
        minuti = tastiera.nextInt();

        System.out.println("\n=======================================================");
        System.out.println("               STAMPA ELENCO GENERALE                  ");
        System.out.println("=======================================================");
        p.stampaElenco();

        System.out.println("=======================================================");
        System.out.println("         RISULTATI FILTRO PER DATA E ORARIO            ");
        System.out.println("=======================================================");
        System.out.println("Filtro applicato -> Data: " + dataSearch + " | A partire dalle ore: " + String.format("%02d:%02d", ore, minuti));
        
        int elementiSelezionati = p.contaSE(dataSearch, ore, minuti);
        System.out.println("Numero totale di prenotazioni trovate: " + elementiSelezionati);

        if (elementiSelezionati > 0) {
            Prenotazione[] listaFiltrata = p.filtraElenco(dataSearch, ore, minuti);
            stampaSuFile(listaFiltrata);
            contaClassi(listaFiltrata);
        } else {
            System.out.println("Nessun viaggio trovato corrispondente ai criteri inseriti.");
        }

        tastiera.close();
    }
}