
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class DepositoBox<T extends Box<?>> {
private double capacita_massima;
private double volume_corrente;
LinkedList<T> coda;

public DepositoBox(double capacita_massima){
    this.capacita_massima = capacita_massima;
    this.volume_corrente = 0;
    this.coda=new LinkedList<>();
}


public void add(T test){
if(full(test.getVolume())){
coda.add(test);
this.volume_corrente+=test.getVolume();
return;
} System.out.println(test.getcodice()+" Rifiutato");
}



public boolean full(double volume){
if(this.volume_corrente+volume>capacita_massima){
    return false;
}else return true;
}


public void stampasufile(String namefile){
PrintWriter inputfile= null;
try{
inputfile= new PrintWriter(namefile);
ordinaperVolume();
for(T visto: coda){
inputfile.println(visto.toString());
}
}catch(IOException e){
System.out.println("Impossibile scrivere su file "+namefile);
System.exit(0);
}
System.out.println("Caricato su file...");
if (inputfile != null) {
                inputfile.close();
            }
}


public void ordinaperId(){
for(int i=0;i<coda.size()-1;i++){
for(int j=0;j<coda.size()-1-i;j++){
if(coda.get(j).compareTo(coda.get(j+1))>0){
T temp=coda.get(j);
coda.set(j, coda.get(j+1));
coda.set(j+1, temp);
}
}
}
for(T visto: coda){
System.out.println(visto.toString());
}

}
public void ordinaperVolume(){
cpv ord= new cpv();
for(int i=0;i<coda.size()-1;i++){
for(int j=0;j<coda.size()-1-i;j++){
if(ord.compare(coda.get(j), coda.get(j+1))>0){
T temp=coda.get(j);
coda.set(j, coda.get(j+1));
coda.set(j+1, temp);
}
}
}
}
}
