public class Persona {
private String nome;
private String cognome;

public Persona(String cognome,String nome){
this.cognome=cognome;
this.nome=nome;
}

public String getNome() {
    return nome;
}
public String getCognome() {
    return cognome;
}
@Override
public String toString(){
    return "Passeggero: "+ getNome()+ " "+ getCognome();
}
}
