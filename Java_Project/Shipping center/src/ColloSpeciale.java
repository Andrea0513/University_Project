public class ColloSpeciale extends ColloNormale{
private String caratteristica;
private double assicurazione;
public ColloSpeciale(String nome, double prezzUnitario, int quantita, String caratteristica, double assicurazione) {
    super(nome, prezzUnitario, quantita);
    this.caratteristica = caratteristica;
    this.assicurazione = assicurazione;
}
public String getCaratteristica() {
    return caratteristica;
}
public double getAssicurazione() {
    return assicurazione;
}
@Override
public double calcolatariffa(){
if(caratteristica.equalsIgnoreCase("fragile")){
return super.calcolatariffa()+assicurazione+30;
}else return super.calcolatariffa()+assicurazione;
}

@Override
public String toString() {
    return super.toString()+" Speciale: " + caratteristica + " assicurazione= " + assicurazione + " euro, Costo"+ calcolatariffa() ;
}


}
