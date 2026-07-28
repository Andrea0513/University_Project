public class Mostra {
private String nome;
private String location;
private String data;
private Catalogo catalogo;

public Mostra(String nome, String location, String data, Catalogo catalogo){
    this.nome=nome;
    this.location=location;
    this.data=data;
    this.catalogo=catalogo;
}

public void ordinaCatalogo(){
    catalogo.ordinaOpere();
}



public void stampaCatalogoMostra(){
System.out.println("***Mostra"+getNome()+"***");
System.out.println("***"+getLocation()+getData());
this.catalogo.VisualizzaOpere();
}


public String getNome() {
    return nome;
}


public String getLocation() {
    return location;
}


public String getData() {
    return data;
}


public Catalogo getCatalogo() {
    return catalogo;
}



}
