public class Condizionamento extends Dispositivo {
    private int temperatura;
    private int umidita;

public Condizionamento(String codice, boolean acceso, boolean disconnesso) {
    super(codice, acceso, disconnesso);
    if(isAcceso()) this.temperatura= 23;
    else this.temperatura=0;
    if(isAcceso()) this.umidita=40;
    else this.umidita=0;
}

@Override
public void accendi() throws accendiext{
    super.accendi();
    this.temperatura=23;
    this.umidita=40;
}

@Override
public void spegni() throws spegniext{
    super.spegni();
    this.temperatura=0;
    this.umidita=0;
}

@Override
public String toString() {
    return super.toString()+", temperatura=" + temperatura + ", umidita=" + umidita + "]";
}



}
