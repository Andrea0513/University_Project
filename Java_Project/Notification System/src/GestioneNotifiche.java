public class GestioneNotifiche {
    public static void main(String[] args) {
        System.out.println("=== INIZIO TEST APPLICAZIONE GESTIONE NOTIFICHE ===");

        CodaNotifiche coda = new CodaNotifiche(5);

        System.out.println("\n--- FASE 1: TEST INSERIMENTO E CONTROLLO ECCEZIONI ---");
        try {
            Messaggio m1 = new Messaggio(2, "Ciao, come stai?");
            Messaggio m2 = new Messaggio(0, "Riunione alle 15:00"); // Priorità minima (diventerà 0 o gestita)
            Messaggio m3 = new Messaggio(3, "File inviato");

            Avviso a1 = new Avviso(5, "A401");
            Avviso a2 = new Avviso(3, "A402");

            coda.inserisci(m1);
            coda.inserisci(a1);
            coda.inserisci(m2);
            coda.inserisci(a2);
            coda.inserisci(m3);
            System.out.println("Inseriti 5 elementi con successo. Coda piena: " + coda.piena());
            
            System.out.println("\nTentativo di inserimento Avviso non valido...");
            Avviso aErrato = new Avviso(4, "B123"); // Codice non valido (inizia per B)
            coda.inserisci(aErrato);
            
        } catch (ERRORE e) {
            System.err.println("ECCEZIONE CATTURATA CORRETTAMENTE: " + e.getMessage());
        }

        System.out.println("\n--- FASE 2: TEST SOSTITUZIONE A CODA PIENA ---");
        try {
            Avviso a3 = new Avviso(10, "A999");
            System.out.println("Inserimento di un nuovo Avviso in coda già piena...");
            coda.inserisci(a3);
            System.out.println("Inserimento completato (elemento a priorità minima sostituito).");
        } catch (ERRORE e) {
            System.err.println("Errore inatteso durante la sostituzione: " + e.getMessage());
        }

        System.out.println("\n--- FASE 3: STATO ATTUALE DELLA CODA ---");
        coda.visualizza();

        System.out.println("\n--- FASE 4: TEST FUNZIONE FILTRA ---");
        
        System.out.println("-> Risultato di filtra(0) [Deve mostrare SOLO i Messaggi]:");
        Notifica[] soloMessaggi = coda.Filtra(0);
        if (soloMessaggi != null) {
            for (Notifica n : soloMessaggi) {
                if (n != null) {
                    n.showNotification();
                }
            }
        }

        System.out.println("\n-> Risultato di filtra(5) [Deve mostrare SOLO Avvisi con priorità 5]:");
        Notifica[] avvisiPrio5 = coda.Filtra(5);
        if (avvisiPrio5 != null) {
            for (Notifica n : avvisiPrio5) {
                if (n != null) {
                    n.showNotification();
                }
            }
        }

        System.out.println("\n--- FASE 5: TEST ELIMINAZIONE DALLA TESTA ---");
        coda.elimina();

        System.out.println("\nStato della coda dopo l'eliminazione:");
        coda.visualizza();

        System.out.println("\n=== FINE TEST ===");
    }
}