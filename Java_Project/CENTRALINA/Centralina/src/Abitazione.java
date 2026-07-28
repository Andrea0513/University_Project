public class Abitazione {
public static void main(String[] args) {
    
Centralina centrale= new Centralina(5, 3);
centrale.inserisci(new Illuminazione("ILL00", true, false));
centrale.inserisci(new Illuminazione("ILL01", false, false));
centrale.inserisci(new Condizionamento("COND00", true, false));

System.out.println(" Dispositivi appartenti alla lista: ");
centrale.Stampalista();

System.out.println(" Disconnettiamo i dispostivi spenti: ");
centrale.disconnettiSpenti();
centrale.Stampalista();

System.out.println(" Accendiamo tutti i dispositivi: ");
try{
centrale.accendiTutti();
}
catch(accendiext e){
    System.out.println(e.getMessage());
}

System.out.println("Stampiamo la lista aggiornata: ");
centrale.Stampalista();



System.out.println(" elaborazione dei dispositivi disconnesi.....");
centrale.showConfig();

centrale.estendiCentralina();
centrale.inserisci(new Condizionamento("COND01", false, false));

centrale.estendiCentralina();
centrale.inserisci(new Condizionamento("COND02", true, false));
System.out.println("Stampiamo la lista aggiornata: ");
centrale.Stampalista();

if(centrale.cercaCodice("COND03")) System.out.println("Dispositivo trovato");
else System.out.println(" Dispositivo non trovato");
if(centrale.cercaCodice("COND02")) System.out.println("Dispositivo trovato");
else System.out.println(" Dispositivo non trovato");


centrale.elimina("ILL01");
System.out.println("Stampiamo la lista aggiornata: ");
centrale.Stampalista();

if(centrale.cercaCodice("ILL01")) System.out.println("Dispositivo trovato");
else System.out.println(" Dispositivo non trovato");




System.out.println("\n--- Testiamo l'estendibilità multipla ---");
    
        centrale.inserisci(new Illuminazione("ILL02", true, false));
        centrale.inserisci(new Illuminazione("ILL03", true, false));
        centrale.estendiCentralina();





}
}
