public class OggettiPersonali extends Oggetti{
private String categoria;

public OggettiPersonali(String descrizione, String luogoDiRitrovo, int codiceIdentificativo, String categoria) {
    super(descrizione, luogoDiRitrovo, codiceIdentificativo);
    this.categoria = categoria;
}

public String getCategoria() {
    return categoria;
}


@Override
public String RestituisciCodiceTracciamento(){
    return "PERS-"+this.getCodiceIdentificativo();
}


@Override
public String toString() {
    return super.toString()+"\nCategoria:" + categoria+ "\n Oggetto registrato con codice identificativo: "+this.getCodiceIdentificativo();
}


}
