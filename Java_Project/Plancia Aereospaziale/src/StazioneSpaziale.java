import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;

public class StazioneSpaziale {
    public static void main(String[] args) throws Exception {
        PrintWriter clearLog = new PrintWriter(new File("log.txt"));
        clearLog.close();

        System.out.println("=== AVVIO SISTEMA DI MONITORAGGIO STAZIONE SPAZIALE ===\n");
        PlanciaDiComando plancia = new PlanciaDiComando();
        
        Ingegneri n1 = new Ingegneri("ROSSI");
        Ingegneri n2 = new Ingegneri("BIANCHI");

        ModuliOrbitali m1 = new ModuliOrbitali("Alfa", "Picco anomalo di radiazioni rilevato nel quadrante est");
        ModuliOrbitali m2 = new ModuliOrbitali("Beta", "Perdita intermittente del segnale verso il satellite geostazionario");
        ModuliOrbitali m3 = new ModuliOrbitali("Alfa", "Intensità solare superiore alla soglia di sicurezza");
        ModuliOrbitali m4 = new ModuliOrbitali("Beta", "Errore di sincronizzazione tra moduli comunicanti.");

        plancia.registra(m1);
        plancia.registra(m2);
        plancia.registra(m3);
        plancia.registra(m4);
        plancia.registra(n1);
        plancia.registra(n2);

        System.out.println("--- GESTIONE SEGNALAZIONI IN CORSO ---");
        plancia.gestisciSegnalazione();

        System.out.println("=== RIEPILOGO INTERVENTI ===");
        System.out.println("Ingegnere " + n1.getNome() + ": " + n1.getNumInterventi() + " interventi");
        System.out.println("Ingegnere " + n2.getNome() + ": " + n2.getNumInterventi() + " interventi\n");

        System.out.println("=== Log delle comunicazioni memorizzate su file (log.txt) ===");
        BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
        String linea;
        while ((linea = reader.readLine()) != null) {
            System.out.println(linea);
        }
        reader.close();
    }
}