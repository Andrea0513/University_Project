public class GestioneBagagli {
    public static void main(String[] args) throws Exception {
        Bagaglio bag = new Bagaglio();
        System.out.println("--- Effettuo l'inserimento nel bagaglio di alcuni oggetti ---");
        
        bag.push(new Indumento("Pantaloni di Velluto", 1.3, "L"));
        bag.push(new Indumento("Maglione verde", 0.5, "M"));
        bag.push(new Liquido("Profumo", 0.2, 90));
        
        // Questo indumento genererà una ClothesNotAllowed (taglia XL) e verrà intercettato
        bag.push(new Indumento("Cappotto", 2.3, "XL"));
        
        // Questo liquido genererà una LiquidNotAllowed (150ml > 100ml) e verrà intercettato
        bag.push(new Liquido("Shampoo", 0.5, 150));
        
        bag.push(new Indumento("Scarpe da ginnastica", 1.2, "L"));
        
        System.out.println("\n--- Contenuto del bagaglio dopo gli inserimenti ---");
        System.out.println(bag.toString());
        // [BUONA PRATICA]: Chiamata al metodo rinominato in minuscolo "stampa()".
        bag.stampa();
        System.out.println("Peso totale attuale: " + bag.getPeso() + " kg");

        System.out.println("\n--- Oggetto estratto (pop) ---");
        EffettoPersonale estratto = bag.pop("Scarpe da ginnastica");
        if (estratto != null) {
            System.out.println("Estratto con successo: " + estratto.toString());
        }

        System.out.println("\n--- Contenuto del bagaglio dopo l'estrazione ---");
        bag.stampa();
        System.out.println("Peso totale aggiornato: " + bag.getPeso() + " kg");

        if (bag.getPeso() < bag.getPesoMax()) {
            System.out.println("Il bagaglio rispetta il limite di peso consentito.");
        } else {
            System.out.println("Il bagaglio NON rispetta il limite di peso!");
        }

        System.out.println("\n--- Filtro Liquidi presenti nel bagaglio ---");
        EffettoPersonale[] liqu = bag.getLiquido();
        if (liqu != null) {
            for (int i = 0; i < liqu.length; i++) {
                if (liqu[i] != null) {
                    System.out.println(liqu[i].toString());
                }
            }
        }
    }
}