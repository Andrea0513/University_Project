public class Liquido extends EffettoPersonale{
private final int maxML=100;
private int ml;


public Liquido(String tipo, double peso, int ml) {
    super(tipo, peso);
    this.ml = ml;
}

@Override
public boolean preparaPerViaggio() throws LiquidNotAllowed{
if(this.ml> maxML){
throw new LiquidNotAllowed("Impossibile aggiungere il liquido, motivo: soglia massima superata");
}
System.out.println("l' oggetto soddisfa il valore di soglia per i liquidi e puo essere imbarcato");
return true;
}

@Override
public String toString() {
    return super.toString()+", volume: " + ml + " ml";
}

}
