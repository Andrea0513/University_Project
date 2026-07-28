public class MI extends Robot  {
private int LivelloEnergia;

public MI( int livelloEnergia) {
    super();
    LivelloEnergia = livelloEnergia;
}
@Override
 public int ripristina(){
    int eliminazione = 0;
        for (int i = 0; i < getIndxmod(); i++) {
            if (!getModuli()[i].get_isOperative()) {
                eliminaModulo(getModuli()[i].getTipo());
                eliminazione++;
                i--;
            }
        }
        return eliminazione;
    }
@Override
public boolean intrattieni(){
System.out.println(" Test dei metodi intrattieni");
if(this.LivelloEnergia>=10){return true;}
else return false;
}




}
