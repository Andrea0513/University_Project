import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ristorante {
public class Nodo{
private Tavolo elem;
private Nodo next;

         public Nodo(Tavolo elem){
         this.elem=elem;
        this.next=null;
}
}


private String Nome;
private int numTavoli;
private Nodo testa;
private Nodo coda;


public Ristorante(String Nome){
this.Nome=Nome;
this.numTavoli=0;
this.testa=null;
this.coda=null;
}

public boolean isEmpty(){if(testa==null && coda==null) return true; else return false;}
public boolean isFull(){return false;}



public void addTable(Tavolo test){
if(isFull()){
    System.out.println(" Impossibile aggiungere tavolo");
    return;
}
if(isEmpty()){
Nodo q= new Nodo(test);
testa=coda=q;
return;
}
Nodo q=new Nodo(test);
coda.next=q;
coda=q;
}

public void ReserveTable(int num) {
        if (isEmpty()) {
            System.out.println("Impossibile prenotare: non ci sono tavoli registrati nel ristorante.");
            return;
        }
        Nodo temp = testa;
        while (temp != null) {
            if (temp.elem.getNumPosti() == num) {
                if (temp.elem.prenota(num)) {
                    return;
                }
            }
            temp = temp.next;
        }
        System.out.println("Non è stato possibile trovare un tavolo libero con esattamente " + num + " posti.");
    }

public void releaseTable(int table) {
        Tavolo trovato = findTable(table);
        if (trovato != null) {
            trovato.libera(table);
        } else {
            System.out.println("Impossibile liberare: tavolo numero " + table + " non trovato.");
        }
    }


public void displayTable(){
System.out.println("Ristorante "+this.Nome);
if(isEmpty()){
    System.out.println("Nessun tavolo trovat");
    return;
}
Nodo temp=testa;
while(temp!=null){
System.out.println(temp.elem.toString());
temp=temp.next;
}
}

public Tavolo findTable(int table) {
        if (isEmpty()) {
            System.out.println("Non ci sono tavoli nel ristorante.");
            return null;
        }
        Nodo temp = testa;
        while (temp != null && temp.elem.getNumero() != table) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Tavolo numero " + table + " non trovato.");
            return null;
        }
        return temp.elem;
    }




public void loadTablesFromFile(String namefile) {
        Scanner inputfile = null;
        try {
            inputfile = new Scanner(new File(namefile));
            
            int expectedTables = inputfile.nextInt();
            
            while (inputfile.hasNext()) {
                String tipo = inputfile.next();
                int numtable = inputfile.nextInt();
                int numposti = inputfile.nextInt();
                boolean prenotato = inputfile.nextBoolean();
                
                if (tipo.equalsIgnoreCase("Esterno")) {
                    boolean portico = inputfile.nextBoolean();
                    Esterno e = new Esterno(numtable, numposti, prenotato, portico);
                    addTable(e);
                } else if (tipo.equalsIgnoreCase("Interno")) {
                    boolean window = inputfile.nextBoolean();
                    Interno i = new Interno(numtable, numposti, prenotato, window);
                    addTable(i);
                }
            }
            System.out.println("Caricamento da file '" + namefile + "' completato (Tavoli letti: " + this.numTavoli + "/" + expectedTables + ").");
            
        } catch (FileNotFoundException e) {
            System.out.println("Errore critico: impossibile aprire il file " + namefile);
            System.exit(0);
        } finally {
            if (inputfile != null) {
                inputfile.close();
            }
        }
    }

protected void TableAT(){
    //Empty because is required by the track, but is not clear the use
}
}

