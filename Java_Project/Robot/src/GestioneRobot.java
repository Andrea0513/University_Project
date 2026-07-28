public class GestioneRobot {
    public static void main(String[] args) throws Exception {
        System.out.println("=== INIZIO SIMULAZIONE GESTIONE ROBOT ===");

        MM n1 = new MM();
        n1.inserisciModulo(new Modulo("Motore", true, false));
        n1.inserisciModulo(new Modulo("Sensore", true, false));
        n1.inserisciModulo(new Modulo("Luce", true, false));
        
        System.out.println("\nElenco dei moduli del Robot MM:");
        n1.visualizza_Moduli();

        MI n2 = new MI(20);
        n2.inserisciModulo(new Modulo("Camera", true, false));
        n2.inserisciModulo(new Modulo("Batteria", true, false));
        n2.inserisciModulo(new Modulo("Motore", true, false));
        n2.inserisciModulo(new Modulo("Sensore", true, false));
        
        System.out.println("\nElenco dei moduli del Robot MI:");
        n2.visualizza_Moduli();

        Robot[] flotta = new Robot[2];
        flotta[0] = n1;
        flotta[1] = n2;

        System.out.println("\n--- TEST RIPRISTINO IN ASSENZA DI GUASTI ---");
        System.out.println("Effetto della chiamata del metodo ripristina sui robot in assenza di malfunzionamenti:");
        int ripristiniIniziali = flotta[0].ripristina() + flotta[1].ripristina();
        System.out.println("Complessivamente sono state effettuate " + ripristiniIniziali + " operazioni di ripristino.");

        System.out.println("\n--- SIMULAZIONE GUASTI E ALLARMI ---");
        System.out.println("Generazione di guasti sui robot in corso...");
        n2.getModuli()[0].disattiva();
        n1.getModuli()[1].alertOn();
        n1.getModuli()[1].disattiva();
        n2.getModuli()[2].disattiva();
        n2.getModuli()[3].disattiva();

        System.out.println("\n--- TEST RIPRISTINO IN PRESENZA DI GUASTI ---");
        System.out.println("Effetto della chiamata del metodo ripristina sui robot in presenza di malfunzionamenti:");
        int ripristiniGuasti = flotta[0].ripristina() + flotta[1].ripristina();
        System.out.println("Complessivamente sono state effettuate " + ripristiniGuasti + " operazioni di ripristino.");
        
        System.out.println("\nElenco dei moduli del Robot MI dopo il ripristino (i moduli guasti sono stati rimossi):");
        n2.visualizza_Moduli();
        
        System.out.println("\nElenco dei moduli del Robot MM dopo il ripristino (i moduli guasti sono stati riattivati):");
        n1.visualizza_Moduli();

        System.out.println("\n--- TEST DEL METODO MONITORA SUL ROBOT MM ---");
        try {
            n1.monitora();
        } catch (AlarmExeception e) {
            System.err.println("ALLARME CATTURATO: " + e.getMessage());
        }

        System.out.println("\n--- TEST INTRATTENIMENTO ROBOT MI ---");
        if (n2.intrattieni()) {
            System.out.println("Robot MI intrattiene: Intrattenimento effettuato con successo!");
        } else {
            System.out.println("Robot MI non intrattiene: Livello di energia insufficiente.");
        }
        
        System.out.println("\n=== FINE SIMULAZIONE ===");
    }
}