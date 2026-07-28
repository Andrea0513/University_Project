public class AreaParcheggio {
private Veicolo[][] veicoli;
private Veicolo[] areaparc;

public AreaParcheggio() {
    this.veicoli = new Veicolo[5][7];
    this.areaparc= new Veicolo[35];
}
public Veicolo[] getVeicolo(){
    return this.areaparc;
}

public void verificaCellaLibera(int riga, int colonna) throws PostoNonValidoExc {
        if (riga >= 5 || riga < 0 || colonna >= 7 || colonna < 0) {
            throw new PostoNonValidoExc("Cella fuori dall'area di parcheggio: (" + riga + ", " + colonna + ")");
        } 
        if (this.veicoli[riga][colonna] != null) {
            throw new PostoNonValidoExc("Cella già occupata da un altro veicolo: (" + riga + ", " + colonna + ")");
        }
    }

public void occupaCella(int riga, int colonna, Veicolo v) {
        try {
            if (v instanceof Moto) {
                verificaCellaLibera(riga, colonna);
                this.veicoli[riga][colonna] = v;
            } else if (v instanceof Auto) {
                Auto auto = (Auto) v;
                if (auto.getOrientamento().equalsIgnoreCase("ORIZZONTALE")) {
                    verificaCellaLibera(riga, colonna);
                    verificaCellaLibera(riga, colonna + 1);
                    this.veicoli[riga][colonna] = v;
                    this.veicoli[riga][colonna + 1] = v;
                } else if (auto.getOrientamento().equalsIgnoreCase("VERTICALE")) {
                    verificaCellaLibera(riga, colonna);
                    verificaCellaLibera(riga + 1, colonna);
                    this.veicoli[riga][colonna] = v;
                    this.veicoli[riga + 1][colonna] = v;
                }
            }
            System.out.println("Parcheggiato con successo: " + v.toString() + " in (" + riga + ", " + colonna + ")");

        } catch (PostoNonValidoExc e) {
            for (int i = 0; i < getVeicolo().length; i++) {
                if (getVeicolo()[i] != null && getVeicolo()[i].getTarga().equals(v.getTarga())) {
                    getVeicolo()[i] = null;
                    break;
                }
            }
            System.out.println("NON PARCHEGGIATO -> " + v.toString() + " | Motivo: " + e.getMessage());
        }
    }
public int contaCelleOccupate(){
int count=0;
    for(int i=0;i<5;i++){
    for(int j=0;j<7;j++){
    if(this.veicoli[i][j]!=null){
    count++;
    }
    }
}
return count;
}



public double percentualeAreaOccupata(){
return (double)(contaCelleOccupate()*100)/35;
}


public void stampacosti(){
for(int i=0;i<getVeicolo().length;i++){
    if(getVeicolo()[i]!=null){
    System.out.println(getVeicolo()[i].toString()+" --> "+getVeicolo()[i].calcoloCosto(3));
    }
    }

}

public void stampaArea(){
for(int i=0;i<5;i++){
    for(int j=0;j<7;j++){
    if(this.veicoli[i][j]==null){
    System.out.print(" . ");
    }else System.out.print(" "+this.veicoli[i][j].getSymbol()+" ");
    }System.out.print("\n");

}


}
}