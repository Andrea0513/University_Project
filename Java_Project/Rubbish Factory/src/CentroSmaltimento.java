import java.util.LinkedList;

public class CentroSmaltimento<T extends Riciclabile> {
private String categoria;
private LinkedList<T> lista;


public CentroSmaltimento(String categoria) {
    this.categoria = categoria;
    this.lista = new LinkedList<>();
}

public String getCategoria() {
    return categoria;
}

public LinkedList<T> getLista() {
    return lista;
}


public void conferisci(T e, Tabella a) throws NonSmaltibileException {
        String newcat = e.FindCat(a);
        
        if (!newcat.equalsIgnoreCase(this.categoria) || newcat.equalsIgnoreCase("SPECIALE")) {
            throw new NonSmaltibileException("ERRORE: Questo centro accetta solo materiali di tipo " + this.categoria + ". Ricevuto: " + newcat);
        }
        lista.add(e);
        System.out.println("Conferimento accettato con successo.");
    }

public void stampa() {
        System.out.println("\n--- Contenuto del centro di smaltimento (" + categoria + ") ---");
        if (lista.isEmpty()) {
            System.out.println("Nessun rifiuto attualmente conferito in questo centro.");
            return;
        }
        for (T elemento : lista) {
            System.out.println(" - " + elemento.toString());
        }
    }

}
