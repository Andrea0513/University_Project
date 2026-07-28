public class Moto extends Veicolo{
private String tipo;

public Moto(String targa, int riga, int colonna, String tipo) {
    super(targa, riga, colonna);
    this.tipo = tipo;
}

@Override
public double getTariffaOraria(){
if(tipo.equalsIgnoreCase("CICLOMOTORE")){
return 2.0;
}else if(tipo.equalsIgnoreCase("MOTOCICLETTA")){
return 3.0;
}
System.out.println("Moto non appartiene all' insieme valido");
return 0;
}
@Override
public char getSymbol(){
return 'M';
}



@Override
public String toString() {
    return super.toString()+ " (" + tipo + ")";
}

}
