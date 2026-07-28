public class Avviso extends Notifica {
private String codice;

public Avviso(int priority, String codice) {
    super(priority);
    this.codice = codice;
}

public String getCodice() {
    return codice;
}

@Override
public void showNotification(){
System.out.println(toString());
}

public boolean checkCode() {
        if (codice.length() == 4) {
            if (codice.charAt(0) == 'A') {
                for (int i = 1; i < 4; i++) {
                    if (!Character.isDigit(codice.charAt(i))) {
                        System.out.println("Codice errato: le ultime 3 posizioni devono essere numeriche.");
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }


@Override
public String toString() {
    return super.toString()+" , codice=" + codice + "]";
}











}
