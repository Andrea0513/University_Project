public class Box<T extends ColloNormale> implements Comparable<Box<?>>{
private String codice;
private double larghezza;
private double altezza;
private double profondita;
private T contenuto;
public Box(String codice, double larghezza, double altezza, double profondita, T contenuto) {
    this.codice = codice;
    this.larghezza = larghezza;
    this.altezza = altezza;
    this.profondita = profondita;
    this.contenuto = contenuto;
}

public double getVolume(){
return larghezza*altezza*profondita;
}

public T getContenuto() {
    return contenuto;
}
public String getcodice(){
    return this.codice;
}

public int getId() {
        try {
            return Integer.parseInt(codice.substring(2));
        } catch (Exception e) {
            return 0;
        }
    }

public double costoBox(){
return contenuto.calcolatariffa()+getVolume()*2;
}

@Override
public int compareTo(Box<?> test){
return getId()-test.getId();
}


@Override
public String toString() {
    return "Box " + codice + " contenuto: "+ contenuto.toString() ;
}


}