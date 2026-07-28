public class Pressa extends Macchinario{
private int colpi_al_minuto;


public Pressa(String nome, int tempo_utilizzo, float potenza, int colpi_al_minuto) {
    super(nome, tempo_utilizzo, potenza);
    this.colpi_al_minuto = colpi_al_minuto;
}

@Override
public float Consumi(){
return (float)(getPotenza()*getTempo_utilizzo()/60.0)*getMode();
}

@Override
    public String toString() {
        return super.toString() + ", consumo: " + Consumi() + " kWh";
    }
}
