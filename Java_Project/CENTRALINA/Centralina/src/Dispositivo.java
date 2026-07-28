public class Dispositivo implements Actionable {
private String codice;
private boolean acceso;
private boolean disconnesso;

public Dispositivo(String codice, boolean acceso, boolean disconnesso) {
    this.codice = codice;
    this.acceso = acceso;
    this.disconnesso = disconnesso;
}
public String getCodice() {
    return codice;
}
public boolean isAcceso() {
    return acceso;
}
public boolean isDisconnesso() {
    return disconnesso;
}
@Override
public void accendi() throws accendiext{
if(this.acceso==false){
    this.acceso=true;
}else throw new accendiext("il dispositivo e' gia acceso");
}
@Override
public void spegni() throws spegniext{
if(this.acceso==true){
    this.acceso=false;
}else throw new spegniext("il dispositivo e' gia spento");
}



public void setAcceso(boolean acceso) {
    this.acceso = acceso;
}
public void setDisconnesso(boolean disconnesso) {
    this.disconnesso = disconnesso;
}
@Override
public String toString() {
    return getClass().getSimpleName()+"[codice=" + codice + ", acceso=" + acceso + ", disconnesso=" + disconnesso ;
}

}
