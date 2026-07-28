public class OggettiScolastici extends Oggetti{
private String livelloScolastico;

public OggettiScolastici(String descrizione, String luogoDiRitrovo, int codiceIdentificativo,
        String livelloScolastico) {
    super(descrizione, luogoDiRitrovo, codiceIdentificativo);
    this.livelloScolastico = livelloScolastico;
}

public String getLivelloScolastico() {
    return livelloScolastico;
}

@Override
public String RestituisciCodiceTracciamento(){
    return "SCOL-"+this.getCodiceIdentificativo();
}




@Override
public String toString() {
    return super.toString() + "\n LivelloScolastico (elementare/media/liceo/ND): " + livelloScolastico + "\n Oggetto registrato con codice identificativo: "+this.getCodiceIdentificativo();
}



}
