public class Modulo {
private String  tipo;
private boolean isOperative;
private boolean alert;

public Modulo(String tipo,boolean isOperative, boolean alert){
this.tipo=tipo;
this.isOperative=isOperative;
this.alert=alert;
}

public String getTipo() {
    return tipo;
}

public boolean get_isOperative() {
    return isOperative;
}

public boolean get_Alert() {
    return alert;
}

public void alertOn(){
this.alert=true;
}

public void alertOff(){
this.alert=false;
}

public void attiva(){
this.isOperative=true;
}

public void disattiva(){
this.isOperative=false;
}


@Override
public String toString() {
    return "Modulo [tipo=" + tipo + ", isOperative=" + isOperative + ", alert=" + alert + "]";
}





}
