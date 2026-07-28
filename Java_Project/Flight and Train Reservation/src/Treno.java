public class Treno extends Prenotazione{
private int carrozza;
private String posto;






public Treno(String codice, String origine, String destinazione, String data, int ore, int minuti, Persona persona,int carrozza, String posto) {
    super(codice, origine, destinazione, data, ore, minuti, persona);
    this.carrozza = carrozza;
    this.posto = posto;
}
public int getCarrozza() {
    return carrozza;
}
public String getPosto() {
    return posto;
}

@Override
public void Stampa_Prenotazione(){
    System.out.println(" Prenotazione "+getClass().getSimpleName()+ " Codice: "+getCodice());
    super.Stampa_Prenotazione();
    System.out.println("carrozza:"+getCarrozza());
    System.out.println("posto: "+getPosto());
    System.out.println("\n---------------------------------------------");
}

@Override
public String toString(){
    return  " Prenotazione "+getClass().getSimpleName()+ " Codice: "+getCodice() +"\n" + super.toString()+" \n carrozza:"+getCarrozza()+"posto: "+getPosto()+"\n TAGLIA QUI ****************" ;
}

}
