public class Illuminazione extends Dispositivo{
private int livelloluce;

public Illuminazione(String codice, boolean acceso, boolean disconnesso) {
    super(codice, acceso, disconnesso);
    if(isAcceso()) this.livelloluce= 50;
    else this.livelloluce=0;
}

@Override
public void accendi() throws accendiext{
    super.accendi();
    this.livelloluce=50;
}

@Override
public void spegni() throws spegniext{
    super.spegni();
    this.livelloluce=0;
}

@Override
public String toString() {
    return super.toString()+ ", livelloluce=" + livelloluce + "]";
}
}
