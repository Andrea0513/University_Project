public class GestioneCataloghi {

public static void main(String[] args) {
    

Catalogo CATALOGO= new Catalogo();
CATALOGO.leggiDafile("../fileopere.txt");

Mostra mostra=new Mostra("I Maestri del Colore", "Venezia", "16-30 Settembre 2024", CATALOGO);

mostra.stampaCatalogoMostra();
mostra.ordinaCatalogo();
mostra.stampaCatalogoMostra();


}



}
