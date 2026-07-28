public abstract class EffettoPersonale {
private String tipo;
private double peso;

public EffettoPersonale(String tipo, double peso) {
    this.tipo = tipo;
    this.peso = peso;
}





public abstract boolean preparaPerViaggio() throws ClothesNotAllowed,LiquidNotAllowed;





public double getPeso() {
    return peso;
}

@Override
public String toString() {
    return tipo + ", peso=" + peso;
}

public String getTipo() {
    return tipo;
}

}
