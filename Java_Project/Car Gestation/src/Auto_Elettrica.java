public class Auto_Elettrica extends Autovettura{
private double costoBatteria;
private double IncentivoStatale;

public Auto_Elettrica(String marca, String tipo, double costo, double costoBatteria, double incentivoStatale) {
    super(marca, tipo, costo);
    this.costoBatteria = costoBatteria;
    IncentivoStatale = incentivoStatale;
}

@Override
public double CalcolaPreventivo(){
return this.getCosto()+this.accessorylist.calcolaTotaleAccessori()+getCostoBatteria()-getIncentivoStatale();
}


public double getCostoBatteria() {
    return costoBatteria;
}

public double getIncentivoStatale() {
    return IncentivoStatale;
}

@Override
public void stampaVociPreventivo(){
    super.stampaVociPreventivo();
    System.out.println("Costo Batteria: "+getCostoBatteria());
    this.accessorylist.stampaCostiAccessori();
}



@Override
public String toString() {
    return super.toString()+",costoBatteria=" + costoBatteria + ", IncentivoStatale=" + IncentivoStatale + "]";
}

}
