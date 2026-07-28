public abstract class Mezzo {
protected int idMezzo;

public Mezzo(int idMezzo) {
    this.idMezzo = idMezzo;
}




public int getIdMezzo() {
    return idMezzo;
}

public abstract int Capacita();

public abstract void prenota() throws PostiEsauritiException;


@Override
public String toString() {
    return getClass().getSimpleName()+ " ID: "+ idMezzo;
}


}
