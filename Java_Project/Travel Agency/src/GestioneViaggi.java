import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GestioneViaggi {
    public static void main(String[] args) throws Exception {
        ListaViaggi list = new ListaViaggi();
        Scanner inputfile = null;
        String nomeFile = "viaggi.txt";

        try {
            inputfile = new Scanner(new File(nomeFile));
            
            while (inputfile.hasNext()) {
                String tipo = inputfile.next();
                
                if (tipo.equals("AUTOBUS")) {
                    int idAut = inputfile.nextInt();
                    int idViagg = inputfile.nextInt();
                    String origine = inputfile.next();
                    String dest = inputfile.next();
                    int disp = inputfile.nextInt();
                    
                    Autobus aut1 = new Autobus(idAut, disp, disp);
                    list.append(new Viaggio(idViagg, origine, dest, aut1));
                    
                } else if (tipo.equals("TRAGHETTO")) {
                    int idTrag = inputfile.nextInt();
                    int idViagg = inputfile.nextInt();
                    String origine = inputfile.next();
                    String dest = inputfile.next();
                    int cabDisp = inputfile.nextInt();
                    int autDisp = inputfile.nextInt();
                    
                    Traghetto trag1 = new Traghetto(idTrag, cabDisp, autDisp, cabDisp, autDisp);
                    list.append(new Viaggio(idViagg, origine, dest, trag1));
                }
            }
            System.out.println("Lettura del file '" + nomeFile + "' completata con successo!\n");
            
        } catch (FileNotFoundException e) {
            System.out.println("ERRORE CRITICO: Impossibile trovare il file " + nomeFile);
            System.out.println("Assicurati di aver salvato il testo delle partenze nel file 'viaggi.txt'.");
            System.exit(0);
        } finally {
            if (inputfile != null) {
                inputfile.close();
            }
        }

        System.out.println("=========================================================");
        System.out.println("             LISTA VIAGGI DISPONIBILI NELLA RETE         ");
        System.out.println("=========================================================");
        list.Stampa();

        System.out.println("\n=========================================================");
        System.out.println("             VIAGGI DISPONIBILI CON DESTINAZIONE: NAPOLI ");
        System.out.println("=========================================================");
        list.filtra("Napoli");

        System.out.println("\n=========================================================");
        System.out.println("             SIMULAZIONE PRENOTAZIONI IN CORSO           ");
        System.out.println("=========================================================");
        list.prenota(2);
        list.prenota(2);
        
        list.prenota(1);
        
        list.prenota(3);
        list.prenota(3);
        
        list.prenota(1);

        System.out.println("\n=========================================================");
        System.out.println("             LISTA VIAGGI DOPO LE PRENOTAZIONI           ");
        System.out.println("=========================================================");
        list.Stampa();
    }
}