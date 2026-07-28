public class Prenotazione {
private String codice;
private String origine;
private String destinazione;
private String data;
private DepTime time;
private Persona persona;

public Prenotazione(String codice, String origine, String destinazione, String data,int ore, int minuti,Persona persona) {
    this.codice = codice;
    this.origine = origine;
    this.destinazione = destinazione;
    this.data = data;
 this.time= new DepTime(ore,minuti);
 this.persona=persona;
}

public String getCodice() {
    return codice;
}

public String getOrigine() {
    return origine;
}

public String getDestinazione() {
    return destinazione;
}

public String getData() {
    return data;
}

public DepTime getTime() {
    return time;
}

public void Stampa_Prenotazione(){
System.out.println(" from: "+getOrigine()+ " to: "+ getDestinazione());
System.out.println("Departure date: "+getData());
System.out.println(this.time);
System.out.println(this.persona);

}

@Override
public String toString(){
    return " from: "+getOrigine()+ " to: "+ getDestinazione()+ "\n Departure date: "+getData()+ " " + this.time+this.persona;
}




}
