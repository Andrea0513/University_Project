import java.util.Locale;
import java.util.Scanner;

public class GestioneMacchinari {
    public static void main(String[] args) throws Exception {
        Scanner tastiera = new Scanner(System.in);
        tastiera.useLocale(Locale.US);
        float soglia;

        System.out.println("=== Gestione Macchinari Industriali ===");
        System.out.println("Inizializzazione dell'elenco dal file...");

        ElencoMacchinari elenco = new ElencoMacchinari("Macchinari.txt");

        System.out.println("\n--- Elenco Macchinari Registrati ---");
        elenco.stampa();

        System.out.println("\nConsumo totale di tutti i macchinari: " + elenco.consumoTot() + " kWh");

        System.out.print("\nInserire il valore di soglia del consumo (es. 15.0): ");
        soglia = tastiera.nextFloat();

        System.out.println("\n--- Macchinari con consumo > " + soglia + " kWh ---");
        elenco.stampaSopraSoglia(soglia);

        tastiera.close();
    }
}