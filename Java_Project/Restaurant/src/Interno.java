public class Interno extends Tavolo{
private boolean nearWindow;

public Interno(int numero, int numPosti, boolean prenotato, boolean nearWindow) {
    super(numero, numPosti, prenotato);
    this.nearWindow = nearWindow;
}

public boolean isNearWindow() {
    return nearWindow;
}

@Override
protected void specificaPrenotazione(){
System.out.println("Controllo posizione del tavolo rispetto alla cucina");
}


@Override
public String toString() {
    return super.toString()+"Interno [nearWindow=" + nearWindow ;
}

}
