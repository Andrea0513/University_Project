public class GestioneSpedizione {
    public static void main(String[] args) throws Exception {
        DepositoBox<Box<?>> deposito = new DepositoBox<>(15000.0);

        ColloNormale oggetto1 = new ColloNormale("Libro", 15, 2);
        ColloSpeciale oggetto2 = new ColloSpeciale("Vaso", 50, 1, "fragile", 20);
        ColloSpeciale oggetto3 = new ColloSpeciale("Reagente chimico", 100, 1, "infiammabile", 30);
        
        ColloNormale oggetto4 = new ColloNormale("Gigante Royal", 1, 500);

        Box<ColloNormale> box1 = new Box<>("BX001", 2, 3, 5, oggetto1);
        Box<ColloSpeciale> box2 = new Box<>("BX002", 1, 2, 2, oggetto2);
        Box<ColloSpeciale> box3 = new Box<>("BX003", 3, 3, 3, oggetto3);
        
        Box<ColloNormale> box4 = new Box<>("BX004", 555, 5555, 55555, oggetto4);

        System.out.println("--- Tentativo di inserimento dei box nel deposito ---");
        deposito.add(box3);
        deposito.add(box1);
        deposito.add(box2);
        deposito.add(box4);

        System.out.println("\n--- Stampa della lista dei box ordinata per Codice ID ---");
        deposito.ordinaperId();

        System.out.println("\n--- Esportazione su file ordinata per Volume ---");
        deposito.stampasufile("output.txt");

        System.out.println("\nElaborazione del deposito completata con successo!");
    }
}