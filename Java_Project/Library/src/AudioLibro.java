public class AudioLibro extends Libro{
private String voce_narrante;
private int durata;
public AudioLibro(String libro, String primo_autore, String contenuto, String voce_narrante, int durata) {
    super(libro, primo_autore, contenuto);
    this.voce_narrante = voce_narrante;
    this.durata = durata;
}

@Override
public void consuma(){
System.out.println("Riproduco l' audiolibro '"+ gettitolo()+"' di"+getPrimo_autore()+":");
System.out.println(getContenuto());
}

@Override
public String toString() {
    return super.toString()+ "voce_narrante=" + voce_narrante + ", durata=" + durata ;
}



}
