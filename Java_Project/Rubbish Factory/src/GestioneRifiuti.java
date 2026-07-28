import java.util.Scanner;

public class GestioneRifiuti {
    public static void main(String[] args) throws Exception {
Scanner tastiera= new Scanner(System.in);

Tabella tab= new Tabella( 10);
CentroSmaltimento<ScartoIndustriale> centro= new CentroSmaltimento<>("VETRO");

int choice= tastiera.nextInt();
tastiera.nextLine();

if(choice==0){
System.out.println("=== Creazione tabella da file==");
System.out.println("Inserisci il nome da file: \n Rifiuti.txt");
tab.carica(choice);

tab.stampa();

}else if(choice==1){
System.out.println("=== Creazione tabella da tastiera===");
System.out.println("Inserisci il nome del file da tastiera");
tab.carica(choice);

tab.stampa();
}

System.out.println("=== Classificazione materiali (polimorfismo) ===");

Riciclabile[] elementi = {
    new RifiutoDomestico("BOTTIGLIA", "PL01"),
    new RifiutoDomestico("VASETTO", "VE01"),
    new RifiutoDomestico("GIORNALAIO", "CA01"),
    new ScartoIndustriale("CHIMICO", true, "PL01"),
    new ScartoIndustriale("SANITARIO", false, "VE01"),
    new ScartoIndustriale("MECCANICO", false, "PL01")
};

for(int i = 0; i < elementi.length; i++) {
    try {
        System.out.println(elementi[i].toString() + elementi[i].FindCat(tab));
    } catch (NonSmaltibileException e) {
        System.out.println(elementi[i].toString() + "ERRORE: " + e.getMessage());
    }
}

System.out.println("===Conferimento oggetti ad un centro di smaltimenti===");
try{
centro.conferisci(new ScartoIndustriale("CHIMICO", true, "PL01"), tab);
}catch(NonSmaltibileException e){
System.out.println(e.getMessage());
}

try{
centro.conferisci(new ScartoIndustriale("SANITARIO", false, "VE01"), tab);
}catch(NonSmaltibileException e){
System.out.println(e.getMessage());
}

try{
centro.conferisci(new ScartoIndustriale("CARTOLERIA",false, "CA01"), tab);
}catch(NonSmaltibileException e){
System.out.println(e.getMessage());
}

try{
centro.conferisci(new ScartoIndustriale("MECCANICO",false, "VE01"), tab);
}catch(NonSmaltibileException e){
System.out.println(e.getMessage());
}

centro.stampa();

tastiera.close();
}
}
