public class ListaViaggi {
    public class Nodo{
    private Viaggio data;
    private Nodo next;
        public Nodo(Viaggio data){
        this.data=data;
        this.next=null;
        }
    }
private Nodo testa;

public ListaViaggi(){
this.testa=null;
}

public boolean empty(){return testa==null;}
public boolean full(){ return false;}



public void append(Viaggio test) {
        Nodo q = new Nodo(test);
        if (empty()) {
            testa = q;
            return;
        }
        Nodo temp = testa;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = q;
    }

public void cerca(int ID){
Nodo temp=testa;
while(temp!=null){
if(temp.data.getIdViaggio()==ID){
System.out.println(temp.data.toString());
return;
}
temp=temp.next;
}
System.out.println(" Spiacente, non e' presente questo ID");
}


public void filtra(String destinazione) {
        Nodo temp = testa;
        boolean trovato = false;
        while (temp != null) {
            if (temp.data.getDestinazione().equalsIgnoreCase(destinazione)) {
                System.out.println(" - " + temp.data.toString());
                trovato = true;
            }
            temp = temp.next;
        }
        if (!trovato) {
            System.out.println("Spiacente, non è presente nessun viaggio verso: " + destinazione);
        }
    }

public void prenota(int idViaggio) {
        Nodo temp = testa;
        while (temp != null) {
            if (temp.data.getIdViaggio() == idViaggio) {
                try {
                    temp.data.prenotaViaggio();
                    System.out.println("Prenotazione completata con successo per il viaggio ID: " + idViaggio);
                } catch (PostiEsauritiException e) {
                    System.out.println("IMPOSSIBILE PRENOTARE -> " + e.getMessage());
                }
                return;
            }
            temp = temp.next;
        }
        System.out.println("Impossibile prenotare: viaggio con ID " + idViaggio + " non trovato.");
    }

public void Stampa(){
Nodo temp=testa;
    while(temp!=null){
System.out.println(temp.data.toString());
temp=temp.next;
}
}



}