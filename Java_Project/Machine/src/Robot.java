public class Robot extends Macchinario{
private boolean visione_artificiale;
private float k;
public Robot(String nome, int tempo_utilizzo, float potenza, boolean visione_artificiale) {
    super(nome, tempo_utilizzo, potenza);
    this.visione_artificiale = visione_artificiale;
    if(this.visione_artificiale) {this.k= (float)(5*1.3);}
    else this.k=5;
}

@Override
public float Consumi(){
return (getPotenza()*this.k)* getMode();
}


@Override
    public String toString() {
        return super.toString() + ", consumo: " + Consumi() + " kWh";
    }


}
