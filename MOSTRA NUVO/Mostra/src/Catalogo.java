import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Catalogo {
private Opera[] opere;
private int count;

public Catalogo() {
    this.opere = null;
    this.count = 0;
}

public void aggingiOpera(Opera test){
this.opere[count]=test;
count++;
}

public void ordinaOpere(){
for(int i=0;i<count-1;i++){
    for(int j=0;j<count-1-i;j++){
    if(opere[j].compareTo(opere[j+1])>0){
    Opera temp=opere[j+1];
    opere[j+1]=opere[j];
    opere[j]=temp;
    }
    }
}
}

public void visualizzaOpere(){
for(int i=0;i<count;i++){
    System.out.println(opere[i].toString());
}
}

public void leggiDaFile(String namefile){
Scanner inputfile=null;

try{
inputfile=new Scanner(new File(namefile));
int dim= inputfile.nextInt();
this.opere= new Opera[dim];
while(inputfile.hasNext()){
String Tipo=inputfile.nextLine();
if(Tipo.equalsIgnoreCase("Quadro")){
String titolo=inputfile.next();
String autore= inputfile.next();
int anno= inputfile.nextInt();
String tecnica= inputfile.next();
String dimensioni=inputfile.next();
Quadro q= new Quadro(titolo, autore, anno, tecnica, dimensioni);
aggingiOpera(q);
}else if(!Tipo.equalsIgnoreCase("Quadro")){
//inputfile.nextLine();
}
}
}catch(FileNotFoundException e){
    System.out.println("Errore nell' apertura del file "+namefile);
    System.exit(0);
}
inputfile.close();
}



@Override
public String toString() {
    return "Catalogo" ;
}




}
