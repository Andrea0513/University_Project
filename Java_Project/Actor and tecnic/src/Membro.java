public abstract class Membro implements Comparable<Membro> {
private String name;
private String cognome;
private Contratto contratto;


public Membro(String name, String cognome, String codice, int repliche, int cachet) {
    this.name = name;
    this.cognome = cognome;
    this.contratto = new Contratto(codice, repliche, cachet);
}

public abstract int CalcolaRischio();



public String getName() {
    return name;
}

public String getCognome() {
    return cognome;
}

public Contratto getContratto() {
    return contratto;
}

@Override
public int compareTo(Membro test){
int cpcogn= this.cognome.compareTo(test.getCognome());
    if(cpcogn!=0){return cpcogn;}
int cpn= this.name.compareTo(test.getName());
return cpn;
}

@Override
public String toString() {
    return getClass().getSimpleName()+ "  " + name + " " + cognome+" " + contratto.toString();
}




}
