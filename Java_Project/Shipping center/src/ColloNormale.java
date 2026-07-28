public  class ColloNormale implements CalcolaTariffa {
protected String nome;
protected double prezzUnitario;
protected int quantita;
public ColloNormale(String nome, double prezzUnitario, int quantita) {
    this.nome = nome;
    this.prezzUnitario = prezzUnitario;
    this.quantita = quantita;
}
public String getNome() {
    return nome;
}
public double getPrezzUnitario() {
    return prezzUnitario;
}
public int getQuantita() {
    return quantita;
}
@Override
public  double calcolatariffa(){
return prezzUnitario*quantita;
}


@Override
public String toString() {
    return nome + "(" + prezzUnitario + "x " + quantita + ") Costo "+ calcolatariffa() +" euro";
}




}
