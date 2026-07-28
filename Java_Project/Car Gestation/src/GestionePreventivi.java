
public class GestionePreventivi{



    public static void main(String[] args) throws Exception {
    Auto_a_Combustione autoComb= new Auto_a_Combustione("Fiat", "Panda", 10000.0, "Benzina", 300.0);
    Auto_Elettrica autoElet= new Auto_Elettrica("Fiat", "500", 21000.0, 1500.0, 2000.0);
    Accessorio nav = new Accessorio("Navigatore", 500.0);
        Accessorio sip = new Accessorio("Sedile in pelle", 1200.0);
        Accessorio sdp = new Accessorio("Sensori di parcheggio", 700.0);
        Accessorio cil = new Accessorio("Cerchi in lega", 2000.0);

        System.out.println("=== Configurazione Auto a Combustione ===");
        autoComb.inserisciAccessori(nav);
        autoComb.inserisciAccessori(sip);

        System.out.println("\n=== Configurazione Auto Elettrica ===");
        autoElet.inserisciAccessori(sdp);
        autoElet.inserisciAccessori(cil);
        autoElet.inserisciAccessori(cil);

        System.out.println("\n==============================================");
        System.out.println("       CONFRONTO INIZIALE PREVENTIVI          ");
        System.out.println("==============================================");

        int confronto = autoElet.compareTo(autoComb);
        if (confronto > 0) {
            System.out.println("-> Il preventivo dell'Auto Elettrica è PIÙ ALTO di quello a Combustione!\n");
        } else if (confronto < 0) {
            System.out.println("-> Il preventivo dell'Auto a Combustione è PIÙ ALTO di quello Elettrica!\n");
        } else {
            System.out.println("-> I due preventivi hanno ESATTAMENTE LO STESSO PREZZO!\n");
        }

        System.out.println(autoComb.toString());
        autoComb.stampaVociPreventivo();

        System.out.println(autoElet.toString());
        autoElet.stampaVociPreventivo();

        System.out.println("==============================================");
        System.out.println("       MODIFICA OPTIONAL E RICALCOLO          ");
        System.out.println("==============================================");
        
        System.out.println("Tentativo di eliminazione di un accessorio non esistente ('ciao'):");
        autoComb.eliminaAccessori("ciao");

        System.out.println("\nAbbassiamo il preventivo della Panda eliminando il 'Navigatore':");
        autoComb.eliminaAccessori("Navigatore");

        System.out.println("\nNuovo preventivo aggiornato per la Panda:");
        autoComb.stampaVociPreventivo();
    }
}