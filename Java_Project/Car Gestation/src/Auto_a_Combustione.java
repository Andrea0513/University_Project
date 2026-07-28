public class Auto_a_Combustione extends Autovettura{
private String Carburante;
private double tassaambientale;


public Auto_a_Combustione(String marca, String tipo, double costo, String carburante, double tassaambientale) {
    super(marca, tipo, costo);
    Carburante = carburante;
    this.tassaambientale = tassaambientale;
}
    
@Override
public double CalcolaPreventivo(){
return this.getCosto()+this.accessorylist.calcolaTotaleAccessori()+getTassaambientale();
}

public String getCarburante() {
    return Carburante;
}

public double getTassaambientale() {
    return tassaambientale;
}


@Override
public void stampaVociPreventivo(){
    super.stampaVociPreventivo();
    System.out.println("Tassa ambientale: "+getTassaambientale());
    this.accessorylist.stampaCostiAccessori();;
}


@Override
public String toString() {
    return super.toString()+", Carburante=" + Carburante + ", tassaambientale=" + tassaambientale + "]";
}






    
}
