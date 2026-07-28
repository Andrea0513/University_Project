public class ListaAccesori {
    public class Nodo{
    
    private Accessorio dato;
    private Nodo next;
    public Nodo(Accessorio dato) {    this.dato = dato; this.next = null;}
    public Accessorio getDato() {
        return dato;
    }
}

private Nodo testa;
public ListaAccesori(){this.testa=null;}

public boolean full(){return false;}
public boolean empty(){return testa==null;}

public void inserisci(Accessorio dato){
if(cerca(dato.getNome())) {System.out.println("Accessorio gia presente impossibile aggiungere"); return;}

Nodo q=new Nodo(dato);
q.next=testa;
testa=q;
System.out.println("Accessorio inserito");
}

public void elimina(String s) {
        if (!cerca(s)) {
            System.out.println("Accessorio '" + s + "' non presente: impossibile eliminare.");
            return;
        }
            if (testa != null && testa.getDato().getNome().equalsIgnoreCase(s)) {
            testa = testa.next;
            System.out.println("Accessorio '" + s + "' eliminato correttamente.");
            return;
        }

        Nodo temp = testa;
        while (temp != null && temp.next != null) {
            if (temp.next.getDato().getNome().equalsIgnoreCase(s)) {
                temp.next = temp.next.next;
                System.out.println("Accessorio '" + s + "' eliminato correttamente.");
                return;
            }
            temp = temp.next;
        }
    }

public boolean cerca(String s){
Nodo temp;
temp=testa;
while(temp!=null){
if(temp.dato.getNome().equals(s)){
return true;
}
temp=temp.next;
}
return false;
}

public void stampaCostiAccessori(){
Nodo temp;
temp=testa;
System.out.println("Costo accessori");
while(temp!=null){
System.out.println(temp.dato.toString());
temp=temp.next;
}
}

public double calcolaTotaleAccessori(){
Nodo temp;
temp=testa;
double tot=0;
while(temp!=null){
tot=tot+temp.dato.getCostobase();
temp=temp.next;
}
return tot;
}





}
