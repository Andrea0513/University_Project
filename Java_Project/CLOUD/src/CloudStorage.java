import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class CloudStorage<T extends CloudItem<?>> {
private LinkedList<T> pila;


public CloudStorage() {
    this.pila = new LinkedList<>();
}
public void aggiungi(T TEST){
pila.add(TEST);
}

public void stampasufile(String namefile){
PrintWriter inputfile=null;
try{
inputfile=new PrintWriter(namefile);
}catch(FileNotFoundException e){
System.out.println("ERRORE in apertura file"+namefile);
System.exit(0);
}

for(T item: pila){
inputfile.println(item.toString());
}
inputfile.close();
}

public void ordina(){
for(int i=0;i<pila.size()-1;i++){
for(int j=0;j<pila.size()-1-i;j++){
if(pila.get(j).getDimensione()>pila.get(j+1).getDimensione()){
T temp=pila.get(j);
    pila.set(j, pila.get(j+1));
    pila.set(j+1, temp);
}
}
}
}

public void backup() {
        LinkedList<CloudItem<?>> backupList = new LinkedList<>();
        for (T item : pila) {
            backupList.add(item.clonazione());
        }

        String namefile = "backup.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(namefile);
        } catch (FileNotFoundException e) {
            System.out.println("ERRORE in apertura file " + namefile);
            System.exit(0);
        }

        for (CloudItem<?> item : backupList) {
            writer.println(item.toString());
        }
        writer.close();
    }



}