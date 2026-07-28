public class Bagaglio implements Trasportabile {
    public class Nodo{
    private EffettoPersonale data;
    private Nodo next;
    
    public Nodo(EffettoPersonale data) {
        this.data = data;
        this.next = null;
    }
    }

private double pesoMax;
private Nodo testa;
private double pesoAtt;

public Bagaglio() {
    this.pesoMax = 20;
    testa = null;
    this.pesoAtt=0;
}

public boolean isEmpty(){return testa==null;}
public boolean isFull(){return false;}


public void push(EffettoPersonale data){
if(isFull()){
System.out.println("Impossibile aggiungere oggetti");
return;
}
try{
if(data.preparaPerViaggio()){
if(checkPeso(data.getPeso())){
Nodo q= new Nodo(data);
q.next=testa;
testa=q;
calcolaPeso(data);
}
}
}catch(ClothesNotAllowed e){
System.out.println(e.getMessage());
}catch(LiquidNotAllowed a){
System.out.println(a.getMessage());
}
}



public EffettoPersonale pop(String s){
EffettoPersonale find;
    if(isEmpty()){
    System.out.println("Vuoto");
    return null;
}
if(testa.data.getTipo().equalsIgnoreCase(s)){
find=testa.data;
testa=testa.next;
this.pesoAtt-=find.getPeso();
return find;
}
Nodo temp=testa;
while(temp.next != null && !(temp.next.data.getTipo().equalsIgnoreCase(s))) temp=temp.next;
if(temp.next==null){
System.out.println("Oggetto '" + s + "' non trovato nel bagaglio.");
            return null;
}
find=temp.next.data;
temp.next=temp.next.next;
this.pesoAtt-=find.getPeso();
return find;
}



public EffettoPersonale[] getLiquido(){
    if(isEmpty()){
System.out.println(" Vuoto");
    return null;
}
int cout=0;
Nodo temp=testa;
while(temp!=null){
if(temp.data instanceof Liquido){
count++;
}
temp=temp.next;
}

EffettoPersonale[] tipo= new EffettoPersonale[5];
temp = testa;
        int idx = 0;
        while (temp != null) {
            if (temp.data instanceof Liquido) {
                tipo[idx] = temp.data;
                idx++;
            }
            temp = temp.next;
        }
        return tipo;
}


public void calcolaPeso(EffettoPersonale test){
this.pesoAtt+=test.getPeso();
}


public void stampa(){
if(isEmpty()){
System.out.println(" Vuoto");
    return;
}
Nodo temp=testa;
while(temp!=null){
    System.out.println(temp.data.toString());
temp=temp.next;
}
}







@Override
public boolean checkPeso(double test){
if(this.pesoAtt+test>this.pesoMax){
System.out.println("Impossibile aggiungere effetto personale, sforato il limite bagaglio");
return false;
}
return true;
}

@Override
public double getPeso(){
return pesoAtt;
}

public double getPesoMax(){
    return pesoMax;
}



@Override
public String toString() {
    return "Bagaglio (pesoMax: " + pesoMax + " kg )";
}


}


