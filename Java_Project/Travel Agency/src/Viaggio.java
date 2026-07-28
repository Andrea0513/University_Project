

public class Viaggio {
private int idViaggio;
private String origine;
private String destinazione;
private Mezzo mezzo;

public Viaggio(int idViaggio, String origine, String destinazione, Mezzo mezzo) {
    this.origine = origine;
    this.destinazione = destinazione;
    this.mezzo = mezzo;
    this.idViaggio = idViaggio;
}


public int getIdViaggio() {
    return idViaggio;
}


public String getDestinazione() {
    return destinazione;
}

public String getOrigine() {
    return origine;
}


public void prenotaViaggio()throws PostiEsauritiException{
this.mezzo.prenota();
}


@Override
public String toString() {
    return "Viaggio "+idViaggio+": "+origine+" --> "+destinazione+ " "+ this.mezzo.toString();
}

}
