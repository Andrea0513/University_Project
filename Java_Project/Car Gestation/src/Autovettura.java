
public abstract class Autovettura implements Comparable<Autovettura>{
    private String marca;
    private String tipo;
    protected double costo;
    protected ListaAccesori accessorylist;
    
    public Autovettura(String marca, String tipo, double costo) {
        this.marca = marca;
        this.tipo = tipo;
        this.costo = costo;
        this.accessorylist = new ListaAccesori();
    }
    public String getMarca() {
        return marca;
    }
    public String getTipo() {
        return tipo;
    }
    public double getCosto() {
        return costo;
    }

    public void inserisciAccessori(Accessorio e){
    accessorylist.inserisci(e);
    }

    public void eliminaAccessori(String e){
        accessorylist.elimina(e);
    }

    public abstract double CalcolaPreventivo();

    public void stampaVociPreventivo(){
    System.out.println("Voci Preventivo:");
    System.out.println("Costo base: "+getCosto());
    

    }

    @Override
public int compareTo(Autovettura e ){
return Double.compare(this.CalcolaPreventivo(), e.CalcolaPreventivo());}
    @Override
    public String toString() {
        return  getClass().getSimpleName()+"[ marca=" + marca + ", tipo=" + tipo + ", costo=" + costo + "]";
    }

    
}
