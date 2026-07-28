public abstract class Tavolo implements Reservable {
private int Numero;
private int numPosti;
private boolean prenotato;

public Tavolo(int numero, int numPosti, boolean prenotato) {
    Numero = numero;
    this.numPosti = numPosti;
    this.prenotato = prenotato;
}

public int getNumero() {
    return Numero;
}

public int getNumPosti() {
    return numPosti;
}

public boolean isPrenotato() {
    return prenotato;
}


@Override
public boolean prenota(int numeropersone){
if(this.prenotato){
    System.out.println("Impossibile prenotare il tavolo è gia occupato");
    return false;
    }
System.out.println("Prenotazione confermata per il tavolo "+getClass().getSimpleName()+" "+getNumero() ) ;
specificaPrenotazione();
System.out.println(" Tavolo "+Numero+" prenotato con "+numeropersone+" posti ");
this.prenotato=true;
return true;
}

@Override
public void libera(int tavolo){
    if(this.prenotato){
    this.prenotato=false;
    System.out.println("Tavolo "+getNumero()+" liberato");
    return;
    }
System.out.println("Impossibile liberare il tavolo, perche gia lo è");
}



protected abstract void specificaPrenotazione();

@Override
public String toString() {
    return "Tavolo [Numero tavolo =" + Numero + ", numPosti=" + numPosti + ", prenotato=" + prenotato + "] - ";
}










}
