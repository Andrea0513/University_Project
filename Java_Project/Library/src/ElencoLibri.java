public class ElencoLibri {
private Libro[] elenco;
private int index;
public ElencoLibri() {
    this.elenco = new Libro[5];
}

public void inserisci(Libro e){
for(int i=0;i<elenco.length;i++){
if(elenco[i]==null) {elenco[i]=e; this.index++; return;}
else;
}
}

public void ordina(){

for(int i=0;i<this.index;i++){
for(int j=i+1;j<this.index;j++){
    if(elenco[i].gettitolo().compareTo(elenco[j].gettitolo())>0){
    Libro temp=elenco[i];
    elenco[i]=elenco[j];
    elenco[j]=temp;
    }else;
}
}
}

public void stampa_elenco(){
for(int i =0;i<this.index;i++){
System.out.println(elenco[i].toString());
}
}

public void fruisciLibri(){
for(int i=0;i<this.index;i++){
elenco[i].consuma();
}
}

public void cerca_titolo(String s){
    for(int i=0;i<this.index;i++){
    if(elenco[i].gettitolo().equals(s)){    System.out.println(" Il titolo "+s+"  e' presente in elenco");         return;}
    else;
}

System.out.println(" Il titolo "+s+"  non e' presente in elenco");
}







}
