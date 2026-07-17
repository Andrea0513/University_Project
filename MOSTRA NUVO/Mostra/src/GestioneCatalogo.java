public class GestioneCatalogo {
    public static void main(String[] args) throws Exception {
    Mostra mostra=new Mostra("I Maestri del Colore", "Venezia", "16-30 settmbre 2024", new Catalogo());
    
    mostra.getCat().leggiDaFile("Filetesto.txt");
    mostra.stampCatalogoMostra();

    mostra.ordinaCatalogo();
    mostra.stampCatalogoMostra();
    






    }
}
