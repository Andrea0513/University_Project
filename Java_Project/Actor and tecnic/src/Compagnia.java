import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
public class Compagnia{
private Membro[] elementi;
private int count;


public Compagnia(int n) {
    this.elementi = new Membro[n];
    this.count = 0;
}

public void aggiungi(Membro test) throws ThereIsCode{
for(int j=0;j<this.count;j++){
if(test.getContratto().getCodice().equals(elementi[j].getContratto().getCodice())){
throw new ThereIsCode("Duplicato ignorato: contratto"+test.getContratto().getCodice());
}
}
for(int i=0;i<elementi.length;i++){
if(elementi[i]==null){
elementi[i]=test;
this.count++;
return;
}
}
}

public void caricaDafile(){
String namefile="attoritec.txt";
Scanner inputfile=null;

try{

inputfile = new Scanner(new File(namefile));
int capacity= inputfile.nextInt();
if(capacity>elementi.length){
System.out.println("eseguo ridimensionamento");
    this.elementi=new Membro[capacity];

}
while(inputfile.hasNext()){
String tipo=inputfile.next();
if(tipo.equals("ATTORE")){
String code= inputfile.next();
String name= inputfile.next();
String cognome= inputfile.next();
int cash= inputfile.nextInt();
int volte= inputfile.nextInt();
boolean risk= inputfile.nextBoolean();
Attore a= new Attore(name, cognome, risk, code, volte, cash);
try{
aggiungi(a);
}catch(ThereIsCode s){
System.out.println(s.getMessage());
}
}else if (tipo.equals("TECNICO")){
String code= inputfile.next();
String name= inputfile.next();
String cognome= inputfile.next();
int cash= inputfile.nextInt();
int volte= inputfile.nextInt();
String spec= inputfile.nextLine();
Tecnico t= new Tecnico(name, cognome, spec ,code, volte, cash);
try{
aggiungi(t);
}catch(ThereIsCode c){
System.out.println(c.getMessage());
}
}
}

}catch(FileNotFoundException e){
System.out.println("Errore in apertura del file "+namefile);
System.exit(0);
}

inputfile.close();
}



public int costoTotale(){
int costoTot=0;
    for(int i=0;i<count;i++){
costoTot+=(elementi[i].getContratto().getCachet()*elementi[i].getContratto().getRepliche());
}
return costoTot;
}


public void ordina_per_costo(){
cpc c= new cpc();
for(int i=0;i<this.count-1;i++){
    for(int j=0;j<this.count-1-i;j++){
if(c.compare(this.elementi[j],this.elementi[j+1])>0){
Membro temp=this.elementi[j+1];
this.elementi[j+1]=this.elementi[j];
this.elementi[j]=temp;
}
}
}
}

public void ordina_per_cognome(){
for(int i=0;i<this.count-1;i++){
for(int j=0;j<this.count-1-i;j++){
if(this.elementi[j].compareTo(this.elementi[j+1])>0){
    Membro temp=this.elementi[j];
this.elementi[j]=this.elementi[j+1];
this.elementi[j+1]=temp;
}
    }
}

}

public void stampa(){
for(int i=0;i<this.count;i++){
System.out.println(this.elementi[i].toString());
}
}

public Membro MembroCritico(){
int Max=0;
Membro massimo=null;
for(int i=0;i<this.count;i++){
if(this.elementi[i].CalcolaRischio()>Max){
massimo=this.elementi[i];
Max=this.elementi[i].CalcolaRischio();
}
}
return massimo;
}
}