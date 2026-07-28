public class ScartoIndustriale implements Riciclabile {
private String settore;
private boolean pericoloso;
private String codiceMateriale;

public ScartoIndustriale(String settore, boolean pericoloso, String codiceMateriale) {
    this.settore = settore;
    this.pericoloso= pericoloso;
    this.codiceMateriale = codiceMateriale;
}


public String getSettore() {
    return settore;
}



public String getCodiceMateriale() {
    return codiceMateriale;
}

public String FindCat(Tabella A)throws NonSmaltibileException{
if (this.pericoloso || this.settore.equalsIgnoreCase("CHIMICO") || this.settore.equalsIgnoreCase("SANITARIO")) {
        return "SPECIALE";}
return A.categoriaPerCodice(codiceMateriale);
}

public String getPericoloso(){
    if(this.pericoloso){
    return " [PERICOLOSO]";
    }else return "";
}
@Override
public String toString() {
    return "ScartoIndustriale: settore=" + settore + getPericoloso()+ "("+ codiceMateriale + ")"+ " -> ";
}





}
