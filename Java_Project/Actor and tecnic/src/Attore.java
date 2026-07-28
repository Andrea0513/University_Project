public class Attore extends Membro{
private boolean ruolo;

public Attore(String name, String cognome, boolean ruolo, String codice, int repliche, int cachet) {
    super(name, cognome,codice,repliche,cachet );
    this.ruolo = ruolo;
}



public boolean isRuolo() {
    return ruolo;
}

public int CalcolaRischio(){
if(ruolo) return 100;
return 50;
}



@Override
public String toString() {
    return super.toString()+ " ruoloPrincipale=" + ruolo+" "+ CalcolaRischio();
}





}
