import java.util.Scanner;
import java.io.*;

public class Catalogo{
private Opera[] opere;

public Catalogo() {
    this.opere = null;
}

public void aggiungi_Opera(int i,String Tipo, String Titolo, String Autore, int Annodicreazione, String Tecnica, String Dimensioni){
if(Tipo.equals("Quadro")){
Quadro q= new Quadro(Titolo, Autore, Annodicreazione, Tecnica, Dimensioni);
opere[i]=q;
}else;
}

public void ordinaOpere(){

for(int i=0;i<opere.length;i++){
    System.out.println("Catalogo ordinato per titolo");
    if(opere[i]==null) return;
for(int j=i+1;j<opere.length-1;j++){
   if(opere[j]==null) return;
   else;
   if(opere[i].getTitolo().compareTo(opere[j].getTitolo())>0){

 Opera temp;
    temp=opere[i];
    opere[i]=opere[j];
    opere[j]=temp;
    

}else;
}
}}

public void VisualizzaOpere(){
for(int i=0;i<opere.length;i++){
if(opere[i]==null){ 
    return;
}
else;
System.out.println(opere[i].toString());


}

}

public void leggiDafile(String namefile){
Scanner inputfile=null;

try{
inputfile= new Scanner(new File(namefile));
}catch(FileNotFoundException e ){
    System.out.println("errore di apertura del file"+namefile);
    System.out.println("il programma termina");
    System.exit(0);
}
int i=0;
int n= inputfile.nextInt();
this.opere=new Opera[n];
while(inputfile.hasNext()){
String Tipo= inputfile.next();
if (Tipo.equals("Quadro")) {
String Titolo = inputfile.next();
String Autore = inputfile.next();
int Annodicreazione = inputfile.nextInt();
String Tecnica = inputfile.next();
String Dimensioni = inputfile.next();

aggiungi_Opera(i, Tipo, Titolo, Autore, Annodicreazione, Tecnica, Dimensioni); 
            i++;
            System.out.println("Quadro aggiunto con successo!\n");
        }
    }inputfile.close();
}



}


