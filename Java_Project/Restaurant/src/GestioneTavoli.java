public class GestioneTavoli {
    public static void main(String[] args) throws Exception {
    Ristorante mar= new Ristorante("Marinella");
    mar.loadTablesFromFile("Tavoli.txt");

    mar.displayTable();

    mar.ReserveTable(4);

    mar.ReserveTable(2);

    mar.releaseTable(2);
    
    mar.ReserveTable(8);

    mar.ReserveTable(8);
    
    }
}
