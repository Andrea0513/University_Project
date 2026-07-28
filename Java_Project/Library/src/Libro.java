public abstract class Libro implements Fruible, Comparable<Libro> {
private String titolo;
private String primo_autore;
protected String contenuto;

public Libro(String libro, String primo_autore, String contenuto) {
    this.titolo = libro;
    this.primo_autore = primo_autore;
    this.contenuto = contenuto;
}

public String gettitolo() {
    return titolo;
}
public String getContenuto() {
    return contenuto;
}
public String getPrimo_autore() {
    return primo_autore;
}

@Override
public abstract void consuma();

@Override
public String toString() {
    return getClass().getSimpleName()+ ": " + titolo + " di " + primo_autore;
}
@Override
public int compareTo(Libro altroLibro) {
    return this.titolo.compareTo(altroLibro.gettitolo());
}

}
