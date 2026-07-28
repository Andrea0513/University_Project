public class Opera implements Comparable<Opera>{
private String titolo;
private String autore;
private int annoDicreazione;
public Opera(String titolo, String autore, int annoDicreazione) {
    this.titolo = titolo;
    this.autore = autore;
    this.annoDicreazione = annoDicreazione;
}
public String getTitolo() {
    return titolo;
}
public String getautore() {
    return autore;
}
public int getAnnoDicreazione() {
    return annoDicreazione;
}

public void setTitolo(String titolo) {
    this.titolo = titolo;
}
public void setAutore(String autore) {
    this.autore = autore;
}
public void setAnnoDicreazione(int annoDicreazione) {
    this.annoDicreazione = annoDicreazione;
}
@Override
public String toString() {
    return "Opera [titolo=" + titolo + ", Aautore=" + autore + ", annoDicreazione=" + annoDicreazione + "]";
}

@Override
public int compareTo(Opera e){
return this.titolo.compareTo(e.getTitolo());
}
}
