public class Auto extends Veicolo {
private String categoria;
private String Orientamento;


public Auto(String targa, int riga, int colonna, String categoria, String orientamento) {
    super(targa, riga, colonna);
    this.categoria = categoria;
    Orientamento = orientamento;
}

@Override
public double getTariffaOraria(){
if(categoria.equalsIgnoreCase("PICCOLA")){
return 4.0;
}else if(categoria.equalsIgnoreCase("MEDIA")){
return 4.5;
}else if(categoria.equalsIgnoreCase("GRANDE")){
return 5.0;
}
System.out.println("Auto non appartiene all' insieme valido");
return 0;
}

@Override
public char getSymbol(){
return 'A';
}

public String getOrientamento(){
    return Orientamento;
}

@Override
public String toString() {
    return super.toString()+ "  ( " + categoria + ", " + Orientamento + ")";
}





}
