import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ingegneri extends UnitaOperativa {
private int numInterventi;

public Ingegneri(String nome) {
    super(nome);
    this.numInterventi = 0;
}

public int getNumInterventi() {
    return numInterventi;
}

public void PrendiSegnalazione(UnitaOperativa test) throws IOException {
        System.out.println(toString() + " - Segnalazione ricevuta da" + test.toString());
        System.out.println("INTERVENTO EFFETTUATO\n");
        this.numInterventi++;
        
        String namefile = "log.txt";
        PrintWriter inputfile = null;
        try {
            inputfile = new PrintWriter(new FileWriter(namefile, true));
            inputfile.println("Segnalazione ricevuta da" + test.toString());
            inputfile.println("INTERVENTO EFFETTUATO");
        } catch (IOException e) {
            System.out.println("Errore in apertura/scrittura del file " + namefile + ": " + e.getMessage());
        } finally {
            if (inputfile != null) {
                inputfile.close();
            }
        }
    }

@Override
public String toString() {
    return " [ INGEGNERE "+ getNome() + " ]";
}


}
