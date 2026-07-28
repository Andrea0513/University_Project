public class Contratto {
private String codice;
private int repliche;
private int cachet;

public Contratto(String codice, int repliche, int cachet) {
    this.codice = codice;
    this.repliche = repliche;
    this.cachet = cachet;
}


public String getCodice() {
    return codice;
}
public int getRepliche() {
    return repliche;
}
public int getCachet() {
    return cachet;
}

public int Calcolacost(){
    return this.cachet*this.repliche;
}


@Override
public String toString() {
    return "Contratto=" + codice +", costo="+ (this.cachet*this.repliche) +" ]" ;
}


}
