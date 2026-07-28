public class Centralina {
private int extSize;
private int MaxDevices;
private Dispositivo[] dispositivi;
private int count;
public Centralina(int extSize,int MaxDevices) {
    this.extSize = extSize;
    this.dispositivi = new Dispositivo[MaxDevices];
    this.MaxDevices= MaxDevices;
    this.count=0;
}

public void inserisci(Dispositivo e) {
        if (this.count >= this.dispositivi.length) {
            System.out.println("Impossibile inserire " + e.getCodice() + ": centralina piena!");
            return;
        }
        if (!cercaCodice(e.getCodice())) {
            this.dispositivi[this.count] = e;
            this.count++;
        } else {
            System.out.println("Dispositivo duplicato ignorato: " + e.getCodice());
        }
    }

public void elimina(String s) {
        for (int i = 0; i < this.count; i++) {
            if (dispositivi[i].getCodice().equals(s)) {
                for (int j = i; j < this.count - 1; j++) {
                    dispositivi[j] = dispositivi[j + 1];
                }
                this.count--;
                dispositivi[this.count] = null;
                System.out.println("Dispositivo " + s + " eliminato correttamente.");
                return;
            }
        }
        System.out.println("Dispositivo " + s + " non trovato per l'eliminazione.");
    }

public void estendiCentralina() {
        if (this.count >= this.dispositivi.length) {
            Dispositivo[] elencoEsteso = new Dispositivo[this.dispositivi.length + this.extSize];
            for (int i = 0; i < this.count; i++) {
                elencoEsteso[i] = this.dispositivi[i];
            }
            this.dispositivi = elencoEsteso;
            this.MaxDevices = this.dispositivi.length;
            System.out.println("Espansione avvenuta con successo! Nuova capienza: " + this.MaxDevices);
        } else {
            System.out.println("Impossibile estendere: c'è ancora spazio disponibile (" + (this.dispositivi.length - this.count) + " posti liberi).");
        }
    }



public boolean cercaCodice(String s){
for(int i=0;i<this.count;i++){
    if(dispositivi[i].getCodice().equals(s)){return true;}else;
}
return false;
}

public void disconnettiSpenti(){
for(int i=0; i<this.count;i++){
if(!dispositivi[i].isAcceso()) {dispositivi[i].setDisconnesso(true);}
}
}

public void showConfig(){
int nondisc=0;
int disc=0;
    for(int i=0;i<this.count;i++){
if(!dispositivi[i].isDisconnesso()) {nondisc++;}
else disc++;
}
System.out.println("il numero di dispositivi connessi e' ="+ nondisc +" ed il numero di elementi disconnessi e'= "+disc);
System.out.println("Elenco dispositivi connessi:");
for(int i=0;i<this.count;i++){
if(!dispositivi[i].isDisconnesso()){
    System.out.println(dispositivi[i].getCodice()+" "+dispositivi[i].getClass().getSimpleName());
}
}
}

public void accendiTutti() throws accendiext{
for(int i=0;i<this.count;i++){
if(!dispositivi[i].isAcceso()) {dispositivi[i].accendi();}
}
}

public void Stampalista(){
for(int i=0;i<this.count;i++){
System.out.println(dispositivi[i].toString());
}
}


}
