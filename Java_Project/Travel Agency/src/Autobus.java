public class Autobus extends Mezzo {
private int nPosti;
private int nPostiDisponibili;

public Autobus(int idMezzo, int nPosti, int nPostiDisponibili) {
    super(idMezzo);
    this.nPosti = nPosti;
    this.nPostiDisponibili = nPostiDisponibili;
}


@Override
    public void prenota() throws PostiEsauritiException {
        if (nPostiDisponibili <= 0) {
            throw new PostiEsauritiException("Errore: Posti esauriti sull'autobus ID " + getIdMezzo());
        }
        this.nPostiDisponibili--;
    }
@Override
public int Capacita() {
return this.nPosti;
}


public int getCapacita() {
    return nPosti;
}

public int getnPostiDisponibili() {
    return nPostiDisponibili;
}

@Override
public String toString() {
    return super.toString()+" posti disponibili: "+nPostiDisponibili;
}


}
