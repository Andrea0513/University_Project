public class RifiutoDomestico implements Riciclabile{
private String descrizione;
private String codiceMateriale;

public RifiutoDomestico(String descrizione, String codiceMateriale) {
    this.descrizione = descrizione;
    this.codiceMateriale = codiceMateriale;
}

public String getDescrizione() {
    return descrizione;
}

public String getCodiceMateriale() {
    return codiceMateriale;
}


public String FindCat(Tabella A) throws NonSmaltibileException{
return A.categoriaPerCodice(codiceMateriale);
}

@Override
public String toString() {
    return descrizione + "[" + codiceMateriale + "]"+ "-> ";
}

}
