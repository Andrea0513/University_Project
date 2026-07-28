import java.util.Scanner;
import java.io.*;

public class Tabella {
private String[] codice;
private String[] categoria;
private int size;


public Tabella(int size) {
    this.codice= new String[size];
this.categoria= new String[size];
    this.size = size;
}

public int getSize() {
    return size;
}

public void carica(int choice) {
        if (choice == 0) {
            Scanner inputfile = null;
            String namefile = "Rifiuti.txt";
            try {
                inputfile = new Scanner(new File(namefile));
            } catch (FileNotFoundException e) {
                System.out.println("Problema con l'apertura del file " + namefile);
                System.exit(0);
            }

            int i = 0;
            while (i < size && inputfile.hasNext()) {
                String codiceletto = inputfile.next();
                String categorialetto = inputfile.next();
                aggiungi(codiceletto, categorialetto, i);
                i++;
            }
            inputfile.close();
            
        } else if (choice == 1) {
            Scanner tastiera = new Scanner(System.in);
            for (int i = 0; i < size; i++) {
                System.out.print("Inserire codice (es. PL01): ");
                String codice = tastiera.nextLine();

                System.out.print("Inserire categoria (es. PLASTICA): ");
                String categoria = tastiera.nextLine();

                aggiungi(codice, categoria, i);
            }
        } else {
            System.out.println("Scelta errata: numero non valido.");
        }
    }




public String categoriaPerCodice(String a) throws NonSmaltibileException {
        for (int i = 0; i < this.size; i++) {
            if (codice[i] != null && codice[i].equalsIgnoreCase(a)) {
                return categoria[i];
            }
        }
        throw new NonSmaltibileException("Codice non associato a nessun elemento in tabella.");
    }


public void aggiungi(String codice, String categoria, int i){
this.codice[i]=codice;
this.categoria[i]=categoria;
}


public void stampa(){
System.out.println("==== Stampa della tabella ====");
for(int i=0;i<this.size;i++){
System.out.println("Codice:"+this.codice[i]+" -> Categoria:"+ this.categoria[i]);
}
}


}
