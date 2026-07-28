import java.io.IOException;
import java.util.LinkedList;

public class PlanciaDiComando {
private LinkedList<UnitaOperativa> rec;
LinkedList<UnitaOperativa> segnali;

public PlanciaDiComando(){
this.rec= new LinkedList<>();
this.segnali= new LinkedList<>();
}

public void registra(UnitaOperativa test){
if(test instanceof Ingegneri){
    rec.add(test);}
if(test instanceof ModuliOrbitali){
    segnali.add(test);
}
}

public LinkedList<UnitaOperativa> getRec() {
    return rec;
}

public LinkedList<UnitaOperativa> getSegnali() {
    return segnali;
}

public void gestisciSegnalazione() throws IOException {
        for (UnitaOperativa segnale : segnali) {
            ((ModuliOrbitali) segnale).inviaSegnale(this);
            if (!rec.isEmpty() && rec.get(0) instanceof Ingegneri) {
                UnitaOperativa temp = rec.get(0);
                ((Ingegneri) rec.get(0)).PrendiSegnalazione(segnale);
                rec.remove(0);
                rec.addLast(temp);
            }
        }
    }
}






