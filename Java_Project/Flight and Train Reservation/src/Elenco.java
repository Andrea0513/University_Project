public class Elenco{

    public class Nodo{
    private Prenotazione dato;
    private Nodo next;
    public Nodo(Prenotazione dato){this.dato =dato; this.next=null;}
    public Prenotazione getdato(){return dato;}
}

Nodo testa;
Elenco(){this.testa=null;}

public boolean empty(){return testa==null;}
    public boolean full() {return false;}

public void push(Prenotazione dato) {
        Nodo q = new Nodo(dato);
        q.next = testa;
        testa = q;
    }

public int contaSE(String data, int orario,int minuti){
int conta=0;
Nodo temp;
temp=this.testa;
while(temp!=null){
    if(temp.getdato().getData().equals(data)){
        if(temp.getdato().getTime().getOre()==orario){
            if(temp.getdato().getTime().getMinuti()>minuti){
                conta++;
            }else;
        }else if(temp.getdato().getTime().getOre()>orario){
        conta++;
        }
}
temp=temp.next;

}
return conta;
}

public Prenotazione[] filtraElenco(String data, int orario, int minuti) {
        int dimensioneFiltro = contaSE(data, orario, minuti);
        Prenotazione[] vettFiltro = new Prenotazione[dimensioneFiltro];
        
        Nodo temp = testa;
        int i = 0;
        while (temp != null && i < dimensioneFiltro) {
            if (temp.getdato().getData().equals(data)) {
                if (temp.getdato().getTime().getOre() > orario || 
                   (temp.getdato().getTime().getOre() == orario && temp.getdato().getTime().getMinuti() >= minuti)) {
                    vettFiltro[i] = temp.getdato();
                    i++;
                }
            }
            temp = temp.next;
        }
        return vettFiltro;
    }
public void stampaElenco(){
Nodo temp;
temp=testa;
while(temp!=null){
    temp.getdato().Stampa_Prenotazione();
temp=temp.next;
}
}



}

