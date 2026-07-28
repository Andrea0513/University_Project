import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ModuliOrbitali extends UnitaOperativa{
private String Missione;

public ModuliOrbitali(String nome, String missione) {
    super(nome);
    Missione = missione;
}



public String getMissione() {
    return Missione;
}

public void inviaSegnale(PlanciaDiComando test) throws IOException {
        PrintWriter inputfile = null;
        String namefile = "log.txt";
        try {
            inputfile = new PrintWriter(new FileWriter(namefile, true));
            inputfile.println("Segnalazione inviata: '" + this.Missione + "'");
        } catch (IOException e) {
            System.out.println("Errore nell'apertura/scrittura del file " + namefile);
            System.exit(0);
        } finally {
            if (inputfile != null) {
                inputfile.close();
            }
        }
    }


@Override
public String toString() {
    return " Modulo "+getNome() + " '' "+getMissione()+" ' ";
}





}
