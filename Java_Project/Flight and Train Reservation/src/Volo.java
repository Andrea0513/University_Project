public class Volo extends Prenotazione{
private String posto;
private int gate;

public Volo(String codice, String origine, String destinazione, String data, int ore, int minuti, String posto, int gate, Persona persona) {
        super(codice, origine, destinazione, data, ore, minuti, persona);
        this.posto = posto;
        this.gate = gate;
    }

public String getPosto() {
    return posto;
}
public int getGate() {
    return gate;
}

@Override
public void Stampa_Prenotazione(){
    System.out.println(" Prenotazione "+getClass().getSimpleName()+ " Codice: "+getCodice());
    super.Stampa_Prenotazione();
    System.out.println("posto:"+getPosto());
    System.out.println("il gate chiude "+getGate()+" minuti prima della partenza");
    System.out.println("---------------------------------------------");
}

@Override
public String toString() {
    return " Prenotazione "+getClass().getSimpleName()+ " Codice: "+getCodice()+ "\n"+super.toString()+"posto:"+getPosto()+"\n il gate chiude "+getGate()+" minuti prima della partenza"+"\n TAGLIA QUI ****************";
}





}
