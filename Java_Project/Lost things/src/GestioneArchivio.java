public class GestioneArchivio {
    public static void main(String[] args) throws Exception {
        Archivio arch = new Archivio();

        try {
            System.out.println(">>> Inserimento oggetto personale:");
            arch.push(new OggettiPersonali("portafoglio nero", "stazione", 100, "portafoglio"));
        } catch (ThereIsJust e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(">>> Inserimento oggetto scolastico:");
            arch.push(new OggettiScolastici("libro di matematica", "biblioteca", 101, "liceo"));
        } catch (ThereIsJust e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(">>> Inserimento oggetto personale:");
            arch.push(new OggettiPersonali("occhiali da sole", "spiaggia", 102, "occhiali"));
        } catch (ThereIsJust e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(">>> Tentativo di inserimento oggetto duplicato:");
            arch.push(new OggettiPersonali("portafoglio nero", "stazione", 100, "portafoglio"));
        } catch (ThereIsJust e) {
            System.out.println("ECCEZIONE CATTURATA: " + e.getMessage() + "\n");
        }

        String s = "stazione";
        System.out.println(">>> Ricerca oggetti trovati nel luogo: " + s);
        if (!arch.stampaPerLuogo(s)) {
            System.out.println("Nessun oggetto trovato in questo luogo.\n");
        }

        int codiceRicerca = 101;
        System.out.println(">>> RESTITUZIONE (estrazione) oggetto con codice: " + codiceRicerca);
        Oggetti ritrovato = arch.pop(codiceRicerca);
        if (ritrovato != null) {
            System.out.println("Oggetto restituito con successo:\n" + ritrovato.toString() + "\n");
        } else {
            System.out.println("Sei arrivato alla fine della lista e l'oggetto non è presente.\n");
        }

        String b = "biblioteca";
        System.out.println(">>> Ricerca oggetti trovati nel luogo: " + b);
        if (!arch.stampaPerLuogo(b)) {
            System.out.println("Nessun oggetto trovato in questo luogo.");
        } else {
            System.out.println("Ricerca per il luogo '" + b + "' completata.");
        }
    }
}