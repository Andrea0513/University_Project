public class Quadro extends Opera{
private String tecnica;
private String dimensione;


public Quadro(String titolo, String autore, int annoDicreazione, String tecnica, String dimensione) {
    super(titolo, autore, annoDicreazione);
    this.tecnica = tecnica;
    this.dimensione = dimensione;
}


public String getTecnica() {
    return tecnica;
}


public String getDimensione() {
    return dimensione;
}


public void setTecnica(String tecnica) {
    this.tecnica = tecnica;
}


public void setDimensione(String dimensione) {
    this.dimensione = dimensione;
}


@Override
public String toString() {
    return super.toString()+ "Quadro [tecnica=" + tecnica + ", dimensione=" + dimensione + "]";
}


}
