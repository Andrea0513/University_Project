public class Accessorio implements Comparable<Accessorio>{
private String nome;
private double costobase;

public Accessorio(String nome,double costobase){
    this.nome=nome;
    this.costobase=costobase;
}

public String getNome() {
    return nome;
}

public double getCostobase() {
    return costobase;
}

@Override
public int compareTo(Accessorio dato){
    return Double.compare(this.costobase, dato.getCostobase());
}


@Override
public String toString() {
    return   nome + ":" + costobase ;
}



}
