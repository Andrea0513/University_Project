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
public String getAutore() {
    return autore;
}
public int getAnnoDicreazione() {
    return annoDicreazione;
}


@Override
public int compareTo(Opera test){
return getTitolo().compareTo(test.getTitolo());
}




@Override
public String toString() {
    return "Opera [titolo=" + titolo + ", autore=" + autore + ", annoDicreazione=" + annoDicreazione + "]";
}



}
