import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class LibroCartaceo extends Libro{
private String nomefile;
private int numpagine;

public LibroCartaceo(String libro, String primo_autore, String contenuto, String nomefile, int numpagine) {
    super(libro, primo_autore, contenuto);
    this.nomefile = nomefile;
    this.numpagine = numpagine;
}

@Override
    public void consuma() {
        PrintWriter miofile = null;
        try {
            miofile = new PrintWriter(this.nomefile);
            miofile.println("*****" + gettitolo() + "*****");
            miofile.println("di:" + getPrimo_autore());
            miofile.println(getContenuto());
            System.out.println("Scrittura completata con successo sul file: " + this.nomefile);
        } catch (FileNotFoundException e) {
            System.out.println("Errore in apertura del file: " + this.nomefile);
            System.out.println("Il programma termina.");
            System.exit(0);
        }
            if (miofile != null) {
                miofile.close();
            }
    }

@Override
public String toString() {
    return super.toString()+ ",numpagine=" + numpagine ;
}

}
