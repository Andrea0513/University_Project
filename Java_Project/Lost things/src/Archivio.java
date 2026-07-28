public class Archivio {
    public class Nodo{
    private Oggetti data;
    private Nodo next;
        public Nodo(Oggetti data){
        this.data=data;
        this.next=null;
        }
    }

private Nodo testa;

Archivio(){
    this.testa=null;
}

public boolean empty(){return testa==null;}
public boolean full(){return false;}


public void push(Oggetti e) throws ThereIsJust {
        if (full()) {
            System.out.println("Impossibile aggiungere: archivio pieno.");
            return;
        }
        Nodo temp = testa;
        while (temp != null) {
            if (temp.data.getDescrizione().equalsIgnoreCase(e.getDescrizione()) && temp.data.getCodiceIdentificativo() == e.getCodiceIdentificativo()) {
                throw new ThereIsJust("ERRORE: oggetto già presente in archivio. Inserimento annullato.");
            }
            temp = temp.next;
        }
        Nodo q = new Nodo(e);
        q.next = testa;
        testa = q;
        System.out.println("Aggiunto con successo:\n" + q.data.toString() + "\n-----------------------------------");
    }

public Oggetti pop(int code) {
        if (empty()) {
            System.out.println("L'archivio è vuoto, impossibile rimuovere oggetti.");
            return null;
        }
        if (testa.data.getCodiceIdentificativo() == code) {
            Oggetti eliminato = testa.data;
            testa = testa.next;
            return eliminato;
        }

        Nodo temp = testa;
        while (temp.next != null) {
            if (temp.next.data.getCodiceIdentificativo() == code) {
                Oggetti eliminato = temp.next.data;
                temp.next = temp.next.next;
                return eliminato;
            }
            temp = temp.next;
        }
        return null;
    }

public boolean stampaPerLuogo(String s) {
        Nodo temp = testa;
        boolean trovato = false;
        while (temp != null) {
            if (temp.data.getLuogoDiRitrovo().equalsIgnoreCase(s)) {
                System.out.println("Oggetto: " + temp.data.getDescrizione());
                System.out.println("Luogo di ritrovo: " + s);
                System.out.println("Codice identificativo: " + temp.data.getCodiceIdentificativo());
                System.out.println("Codice di tracciamento: " + temp.data.RestituisciCodiceTracciamento());
                System.out.println("-----------------------------------");
                trovato = true;
            }
            temp = temp.next;
        }
        return trovato;
    }







}