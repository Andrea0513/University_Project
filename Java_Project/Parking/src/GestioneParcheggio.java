public class GestioneParcheggio {
    public static void main(String[] args) throws Exception {
        System.out.println("=== SISTEMA GESTIONE PARCHEGGIO AUTOMATIZZATO ===\n");
        
        AreaParcheggio area = new AreaParcheggio();
        
        Moto m1 = new Moto("M001", 0, 0, "CICLOMOTORE");
        Moto m2 = new Moto("M002", 1, 2, "MOTOCICLETTA"); // Tenterà di occupare (1,2), già presa da a1!
        Moto m3 = new Moto("M003", 4, 0, "MOTOCICLETTA");
        
        Auto a1 = new Auto("A001", 1, 2, "PICCOLA", "ORIZZONTALE"); // Occuperà (1,2) e (1,3)
        Auto a2 = new Auto("A002", 2, 3, "GRANDE", "VERTICALE");   // Occuperà (2,3) e (3,3)
        Auto a3 = new Auto("A003", 4, 7, "MEDIA", "ORIZZONTALE");  // Colonna 7 fuori griglia! Fallirà.

        System.out.println("--- REGISTRAZIONE VEICOLI IN INGRESSO ---");
        m1.parcheggia(area);
        a1.parcheggia(area);
        a2.parcheggia(area);
        m2.parcheggia(area);
        a3.parcheggia(area);
        m3.parcheggia(area);

        System.out.println("\n--- ASSEGNAZIONE POSTI NELLA GRIGLIA 5x7 ---");
        for (int i = 0; i < area.getVeicolo().length; i++) {
            if (area.getVeicolo()[i] != null) {
                area.occupaCella(area.getVeicolo()[i].getRiga(), area.getVeicolo()[i].getColonna(), area.getVeicolo()[i]);
            }
        }

        System.out.println("\nMAPPA AREA PARCHEGGIO (M = Moto, A = Auto, . = Libero)");
        System.out.println("-----------------------------------------------------");
        area.stampaArea();

        System.out.println("\nSTATISTICHE OCCUPAZIONE");
        System.out.println("-----------------------------------------------------");
        System.out.println("Celle totali occupate: " + area.contaCelleOccupate() + " su 35");
        System.out.println("Percentuale area occupata: " + String.format("%.2f", area.percentualeAreaOccupata()) + "%");

        System.out.println("\nCOSTI SOSTA STIMATI (Per 3 ore di permanenza)");
        System.out.println("-----------------------------------------------------");
        area.stampacosti();
        
        System.out.println("\n=== FINE SIMULAZIONE ===");
    }
}