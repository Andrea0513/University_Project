public class FileSensibile extends FileStandard{
private String livello;
private boolean crittografato;

public FileSensibile(String nome, String descrizione, double costoperMB, String livello, boolean crittografato) {
    super(nome, descrizione, costoperMB);
    this.livello = livello;
    this.crittografato = crittografato;
}

@Override
public double costotot(double dimensione){
double totale=dimensione*this.costoperGB;
if(this.livello.equalsIgnoreCase("alto")){
if(this.crittografato){
    return (totale+(dimensione*0.25));
}
return totale+(dimensione*0.20);
}else if(this.livello.equalsIgnoreCase("medio")){
if(this.crittografato){
    return (totale+(dimensione*0.15));
}
    return totale+(dimensione*0.10);
}else if(this.livello.equalsIgnoreCase("basso")){
if(this.crittografato){
    return (totale+(dimensione*0.10));
}
    return totale+(dimensione*0.05);
}else return 0;
}

@Override
public FileSensibile clonazione(){
FileSensibile clone= new FileSensibile(nome, descrizione, costoperGB,livello,crittografato);
return clone;
}



@Override
public String toString() {
    return "FileSensibile [livello=" + livello + ", crittografato=" + crittografato + "]";
}

}
