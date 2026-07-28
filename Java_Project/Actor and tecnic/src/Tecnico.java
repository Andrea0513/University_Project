public class Tecnico extends Membro{
    private String funzione;

    public Tecnico(String name, String cognome, String funzione, String codice, int repliche, int cachet) {
        super(name, cognome,codice,repliche,cachet);
        this.funzione = funzione;
    }

    public String getFunzione() {
        return funzione;
    }

    public int CalcolaRischio(){
    if(this.funzione.equalsIgnoreCase("Luci")) return 80;
    return 40;
    }


    @Override
    public String toString() {
        return super.toString()+" specializzazione" + funzione + " "+ CalcolaRischio();
    }




}
