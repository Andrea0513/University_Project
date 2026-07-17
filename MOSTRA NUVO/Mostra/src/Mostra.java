public class Mostra {
private String nome;
private String location;
private String data;
private Catalogo cat;

public Mostra(String nome, String location, String data, Catalogo cat) {
    this.nome = nome;
    this.location = location;
    this.data = data;
    this.cat = cat;
}

public void ordinaCatalogo(){
this.cat.ordinaOpere();
}

public void stampCatalogoMostra(){
System.out.println(toString());
this.cat.visualizzaOpere();

}





public Catalogo getCat() {
    return cat;
}

@Override
public String toString() {
    return "***Mostra "+ nome + "*** \n  ***"+location+" "+data+" ***";
}







}
