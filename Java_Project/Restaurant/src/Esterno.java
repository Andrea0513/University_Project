public class Esterno extends Tavolo{
private boolean sottoPortico;

public Esterno(int numero, int numPosti, boolean prenotato, boolean sottoPortico) {
    super(numero, numPosti, prenotato);
    this.sottoPortico = sottoPortico;
}

public boolean isSottoPortico() {
    return sottoPortico;
}


@Override
protected void specificaPrenotazione() {
    System.out.println("Verifica delle condizioni metereologiche per il tavolo esterno "+ getNumero());


}



@Override
public String toString() {
    return super.toString()+"Esterno [sottoPortico:" + sottoPortico + "]";
}




}
