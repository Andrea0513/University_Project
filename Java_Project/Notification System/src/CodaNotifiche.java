public class CodaNotifiche {
private Notifica[] buffer;
private int testa;// fine
private int coda; // inizio
private int dimensione; // posizione oggetti
private int capacita; // spazio totale
private final int Maxpriority=5;

public CodaNotifiche(int capacita) {
    this.buffer = new Notifica[capacita];
    this.testa = 0;
    this.coda = 0;
    this.dimensione = 0;
    this.capacita = capacita;
}


public boolean vuota(){
return dimensione==0;
}

public boolean piena(){
return dimensione==capacita;
}


public void inserisci(Notifica e) throws ERRORE {
        // 1. Controllo di validità preliminare sul codice dell'Avviso
        if (e instanceof Avviso) {
            if (!((Avviso) e).checkCode()) {
                throw new ERRORE("Impossibile aggiungere: il codice dell'Avviso non rispetta lo standard (deve essere 'A' seguito da 3 cifre).");
            }
        }

        // 2. Se la coda è piena, proviamo a sostituire l'elemento con priorità minore
        if (piena()) {
            for (int i = 0; i < dimensione; i++) {
                int indiceReale = (testa + i) % capacita;
                if (buffer[indiceReale].getPriority() < e.getPriority()) {
                    buffer[indiceReale] = e;
                    System.out.println("Elemento con priorità inferiore sostituito con successo.");
                    return;
                }
            }
            System.out.println("Coda piena e nessun elemento con priorità inferiore da sostituire.");
            return;
        }

        // 3. Inserimento normale nella coda circolare
        buffer[coda] = e;
        coda = (coda + 1) % capacita;
        dimensione++;
    }


public void elimina(){
if(vuota()){
System.out.println(" la coda è vuota, impossibile estrarre!!"); return;
}
buffer[testa]=null;

testa=(testa+1)% capacita;

dimensione--;

}


public Notifica[] Filtra(int test){
    if(vuota()){
System.out.println(" impossibile ricercare, vettore vuoto"); 
Notifica[] vuoto= null;
return vuoto;
}else;
Notifica[] filtraggio = new Notifica[dimensione];
    if(test <= Maxpriority && test>-1){
if(test==0){
for(int i=0;i<dimensione;i++){
int indiceReale= (testa +i)%capacita;
if(buffer[indiceReale] instanceof Messaggio){
filtraggio[indiceReale]= buffer[indiceReale];
}
}
}else {for(int i=0;i<dimensione;i++){
    int indiceReale= (testa +i)%capacita;
    if(buffer[indiceReale] instanceof Avviso){
if(buffer[indiceReale].getPriority()==test) {  filtraggio[indiceReale]=buffer[indiceReale];}
    }
}
}

}return filtraggio;}

public void visualizza(){

for(int i=0;i<dimensione;i++){
int indiceReale= (testa + i)% capacita;
if(buffer[indiceReale]!=null){
buffer[indiceReale].showNotification();
}
}
}

}
