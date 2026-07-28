import java.util.Scanner;

/**
 * Traghetto
 */
public class Traghetto extends Mezzo{
private int nCabine;
private int nPostiAuto;
private int nCabineDisponibili;
private int nPostiAutoDisponibili;

Scanner tastiera= new Scanner(System.in);
public Traghetto(int idMezzo, int nCabine, int nPostiAuto, int nCabineDisponibili, int nPostiAutoDisponibili) {
    super(idMezzo);
    this.nCabine = nCabine;
    this.nPostiAuto = nPostiAuto;
    this.nCabineDisponibili = nCabineDisponibili;
    this.nPostiAutoDisponibili = nPostiAutoDisponibili;
}




@Override
public int Capacita() {
    return nCabine;
}


public int getnPostiAuto() {
    return nPostiAuto;
}


public int getnCabineDisponibili() {
    return nCabineDisponibili;
}

public int getnPostiAutoDisponibili() {
    return nPostiAutoDisponibili;
}

@Override
    public void prenota() throws PostiEsauritiException {
        if (nCabineDisponibili <= 0) {
            throw new PostiEsauritiException("Errore: Cabine esaurite sul traghetto ID " + getIdMezzo());
        }
        this.nCabineDisponibili--;
        
        if (this.nPostiAutoDisponibili > 0) {
            this.nPostiAutoDisponibili--;
        }
    }

public void prenotaAuto()throws PostiEsauritiException{
if(nPostiAutoDisponibili<=0){
throw new PostiEsauritiException("ERRORE");
}else if(nPostiAutoDisponibili>0){
    this.nPostiAutoDisponibili=this.nPostiAutoDisponibili-1;
return;
}
}

@Override
public String toString() {
    return super.toString()+", cabine disponibili: "+ nCabineDisponibili+" ,posti auto disponibili "+ nPostiAutoDisponibili;
}


}
