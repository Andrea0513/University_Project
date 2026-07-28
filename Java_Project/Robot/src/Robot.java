public class Robot {
private Modulo[] moduli;
private int indxmod;
public Robot() {
    this.moduli = new Modulo[5];
    this.indxmod=0;
}

public void inserisciModulo(Modulo modulo) {
        if (this.indxmod >= this.moduli.length) {
            System.out.println("Impossibile inserire il modulo " + modulo.getTipo() + ": capienza massima raggiunta!");
            return;
        }
        this.moduli[this.indxmod] = modulo;
        this.indxmod++;
    }

public void eliminaModulo(String s) {
        for (int i = 0; i < this.indxmod; i++) {
            if (moduli[i] != null && moduli[i].getTipo().equals(s)) {
                for (int j = i; j < this.indxmod - 1; j++) {
                    moduli[j] = moduli[j + 1];
                }
                moduli[this.indxmod - 1] = null;
                this.indxmod--;
                return;
            }
        }
        System.out.println("Modulo " + s + " non trovato per l'eliminazione.");
    }


public void visualizza_Moduli(){
this.indxmod = 0;
        for (int i = 0; i < moduli.length; i++) {
            if (moduli[i] != null) {
                this.indxmod++;
            }
        }
}


public void findindex(){
for(int i=0;i<moduli.length;i++){
if(moduli[i] != null){ this.indxmod++;}else;
}}

public Modulo[] getModuli() {
    return moduli;
}

public int getIndxmod() {
    return indxmod;
}
public void monitora()throws AlarmExeception{}
public int ripristina(){return 1;}
public boolean intrattieni(){return true;}
}
