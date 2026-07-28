public class GestioneCompagnia {
    public static void main(String[] args) throws Exception {
    Compagnia compagnia= new Compagnia(3);
    compagnia.caricaDafile();


    System.out.println("=== Membri della compagnia ===");
    compagnia.stampa();

System.out.println("Costo totale dei contratti:"+ compagnia.costoTotale());


System.out.println("Membro più critico della compagnia:");

System.out.println(compagnia.MembroCritico().toString());

System.out.println("=== Ordinamento naturale ===");
compagnia.ordina_per_cognome();
compagnia.stampa();


System.out.println("=== Ordinamento per costo del contratto ===");
compagnia.ordina_per_costo();
compagnia.stampa();
    }
}
