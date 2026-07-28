import java.io.FileNotFoundException;
import java.io.File;
import java.util.Locale;
import java.util.Scanner;

public class ElencoMacchinari {
private int size;
private final static int RESIZE =2;
private int capacita;
private Macchinario[] macchinari;

public ElencoMacchinari(String nomefile) {
        this.size = 0;
        Scanner inputfile = null;
        try {
            inputfile = new Scanner(new File(nomefile));
            inputfile.useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file " + nomefile);
            System.exit(0);
        }

        this.capacita = inputfile.nextInt();
        this.macchinari = new Macchinario[this.capacita];

        while (inputfile.hasNext()) {
            String tipo = inputfile.next();
            if (tipo.equals("Pressa")) {
                String name = inputfile.next();
                int time = inputfile.nextInt();
                float pot = inputfile.nextFloat();
                int colpi = inputfile.nextInt();
                Pressa p = new Pressa(name, time, pot, colpi);
                add(p);
            } else if (tipo.equals("Robot")) {
                String name = inputfile.next();
                int time = inputfile.nextInt();
                float pot = inputfile.nextFloat();
                boolean visione = inputfile.nextBoolean();
                Robot r = new Robot(name, time, pot, visione);
                add(r);
            }
        }
        inputfile.close();
    }

public void add(Macchinario test) {
        int sott = this.capacita - this.size;

        if (sott <= RESIZE) {
            System.out.println("Effettuo ridimensionamento...");
            System.out.println("Capacità attuale: " + this.capacita);
            this.capacita = this.capacita * 2;
            System.out.println("Capacità dopo il ridimensionamento: " + this.capacita);
            Macchinario[] nuovo = new Macchinario[this.capacita];

            for (int i = 0; i < this.size; i++) {
                nuovo[i] = this.macchinari[i];
            }
            this.macchinari = nuovo;
        }

        this.macchinari[this.size] = test;
        this.size++;
    }

public float consumoTot(){
float tot=0;
for(int i=0;i<this.size;i++){
tot=tot+this.macchinari[i].Consumi();
}
return tot;
}

public void stampaSopraSoglia(float soglia){
for(int i=0;i<this.size;i++){
if(this.macchinari[i].Consumi()>soglia){System.out.println(this.macchinari[i].toString());}
}
}

public void stampa(){
for(int i=0;i<this.size;i++){
    System.out.println(this.macchinari[i].toString());
}
}







}
