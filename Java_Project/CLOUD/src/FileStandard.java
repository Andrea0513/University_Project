public class FileStandard implements Clone<FileStandard>,CalcolaTot{
protected String nome;
protected String descrizione;
protected double costoperGB;

public FileStandard(String nome, String descrizione, double costoperGB) {
    this.nome = nome;
    this.descrizione = descrizione;
    this.costoperGB = costoperGB;
}







@Override
public double costotot(double dimensione){
double totale=dimensione*costoperGB;
return totale;
}



@Override
public FileStandard clonazione(){
FileStandard clone= new FileStandard(nome, descrizione, costoperGB);
return clone;
}



public String getNome() {
    return nome;
}

public String getDescrizione() {
    return descrizione;
}

public double getCostoperGB() {
    return costoperGB;
}

@Override
public String toString() {
    return "[nome=" + nome + ", descrizione=" + descrizione + ", costoperMB=" + costoperGB + "]";
}




}