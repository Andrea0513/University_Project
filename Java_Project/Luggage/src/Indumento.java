public class Indumento extends EffettoPersonale{
private String ingombro;

public Indumento(String tipo, double peso, String ingombro) {
    super(tipo, peso);
    this.ingombro = ingombro;
}

public boolean preparaPerViaggio() throws ClothesNotAllowed{
if(this.ingombro.equalsIgnoreCase("XL")){
throw new ClothesNotAllowed("Impossibile aggiungere indumento, motivo: troppo ingombrante");
}
System.out.println("Vestito piegato e pronto per essere inserito");
return true;
}

@Override
public String toString() {
    return super.toString()+" ingombro " + ingombro ;
}








}
