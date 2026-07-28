public class UnitaOperativa {
private String Nome;


public UnitaOperativa(String nome) {
    Nome = nome;
}

public String getNome(){
return Nome;
}

@Override
public String toString(){
return " "+Nome;
}
}
