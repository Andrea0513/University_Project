public abstract class Oggetti implements Comparable<Oggetti> {
private String descrizione;
private String luogoDiRitrovo;
private int CodiceIdentificativo;


public Oggetti(String descrizione, String luogoDiRitrovo, int codiceIdentificativo) {
    this.descrizione = descrizione;
    this.luogoDiRitrovo = luogoDiRitrovo;
    CodiceIdentificativo = codiceIdentificativo;
}


public String getDescrizione() {
    return descrizione;
}


public String getLuogoDiRitrovo() {
    return luogoDiRitrovo;
}


public int getCodiceIdentificativo() {
    return CodiceIdentificativo;
}



public abstract String RestituisciCodiceTracciamento();


@Override
public String toString() {
    return "Descrizione:" + descrizione + "\n Luogo di ritrovamento:" + luogoDiRitrovo;
}




@Override
    public int CompareTo(Oggetti o) {
        return Integer.compare(this.getCodiceIdentificativo(), o.getCodiceIdentificativo());
    }






}