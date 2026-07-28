public abstract class Veicolo {
protected String targa;
protected int riga;
protected int colonna;

public Veicolo(String targa, int riga, int colonna) {
    this.targa = targa;
    this.riga = riga;
    this.colonna = colonna;
}

public abstract char getSymbol();
public abstract double getTariffaOraria();
public double calcoloCosto(int orario){
return getTariffaOraria()*orario;
};

public void parcheggia(AreaParcheggio test) {
        for (int i = 0; i < test.getVeicolo().length; i++) {
            if (test.getVeicolo()[i] == null) {
                test.getVeicolo()[i] = this;
                return;
            }
        }
        System.out.println("Impossibile far entrare il veicolo " + targa + ": elenco di attesa pieno!");
    }



public int getRiga() {
    return riga;
}

public int getColonna() {
    return colonna;
}

@Override
public String toString() {
    return getClass().getSimpleName()+ " " + targa;
}

public String getTarga() {
    return targa;
}


}
