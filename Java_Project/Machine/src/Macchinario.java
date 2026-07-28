public abstract class Macchinario implements Configurabile{
protected String nome;
protected int tempo_utilizzo;
protected float potenza;
protected int mode;


public Macchinario(String nome, int tempo_utilizzo, float potenza) {
    this.nome = nome;
    this.tempo_utilizzo = tempo_utilizzo;
    this.potenza = potenza;
    this.mode = 4;
}


public String getNome() {
    return nome;
}

public int getTempo_utilizzo() {
    return tempo_utilizzo;
}


public float getPotenza() {
    return potenza;
}


public int getMode() {
    return mode;
}

@Override
public abstract float Consumi();


@Override
public String toString() {
    return getClass().getSimpleName() +" "+ nome ;
}

}
