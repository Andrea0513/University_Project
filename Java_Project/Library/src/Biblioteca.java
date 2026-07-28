public class Biblioteca {
    public static void main(String[] args) throws Exception {
        ElencoLibri elenco = new ElencoLibri();
        
        elenco.inserisci(new LibroCartaceo("Il Signore degli Anelli", "J.R.R. Tolkien", "Un Anello per domarli,\nun Anello per trovarli,\nun Anello per ghermirli e nel buio incatenarli.\n", "Tolkien.txt", 320));
        elenco.inserisci(new AudioLibro("La magia del ritorno", "Nicholas Sparks", "Rimasto gravemente ferito in Afghanistan, Trevor Benson ha dovuto abbandonare la professione di chirurgo...", "Francesco Pannofino", 600));
        elenco.inserisci(new LibroCartaceo("I Promessi Sposi", "Alessandro Manzoni", "Quel ramo del lago di Como, che volge a mezzogiorno, tra due catene non interrotte di monti, tutto a seni e a golfi...", "Manzoni.txt", 800));

        System.out.println("=== Stampa dell'elenco iniziale ===");
        elenco.stampa_elenco();

        elenco.ordina();
        System.out.println("\n=== Stampa dell'elenco ordinato alfabeticamente ===");
        elenco.stampa_elenco();

        elenco.cerca_titolo("I Promessi Sposi");

        System.out.println("\n=== Fruizione (Consumo) dell'elenco di libri ===");
        elenco.fruisciLibri();
    }
}