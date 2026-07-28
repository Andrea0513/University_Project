/*
Traccia: Sanremo

Rispettando i principi della programmazione strutturata, progettare ed implementare un programma che permetta ad un giurato l’assegnazione dei voti ai concorrenti al Festival di Sanremo.

1.All’avvio il Programma importa la lista dei concorrenti (massimo 29) da un file in maniera automatica.

2.  Per ciascun concorrente non valutato (all’inizio tutti i concorrenti sono sprovvisti di voto), il programma permette di scegliere se assegnare una voto (un numero da 1 a 10 - se il voto inserito non è valido, il programma ne richiede una nuova immissione) oppure posticiparne l’inserimento.

3. Vengono stampate tutte le esibizioni, con "[N.D.]" in corrispondenza dei voti non disponibili.

4. Viene stampato il riepilogo,  nella seguente forma:
Numero di esibizioni totali: 5
Numero di voti inseriti: 3
Valutazione media: 4.2

5. Vengono aggiunte alla lista delle esibizioni le due seguenti esibizioni (nota bene: NON viene richiesto all'utente, ma vanno direttamente inseriti i dati, scritti esplicitamente nel codice):

concorrente: Massimo Ranieri, valutato: false, voto: 999

concorrente: Elodie, valutato: false, voto: 999

6. viene fornita al giurato la possibilità di completare la valutazione (per i concorrenti non valutati in precedenza e per le nuove  esibizioni, come nel punto 2)

7. vengono stampate tutte le esibizioni (come nel punto 3)

8. viene stampato il riepilogo (come nel punto 4)

Quindi il programma termina.

BONUS: nel riepilogo, riportare anche l'esibizione con il voto più alto, nella forma
Valutazione più alta: Joan Thiele, 8

Nota: NON è richiesto un comportamento iterativo, ma per comodità di test è possibile ad esempio implementare un ciclo do-while infinito che ripeta le operazioni da testare (il ciclo va rimosso o commentato prima della consegna).

Dettagli implementativi

Il programma definisce un record (struct) esibizione con i seguenti campi:

    concorrente (stringa di lunghezza massima 120 caratteri)

    valutato (bool, true se il giurato ha fornito un voto per il concorrente, false altrimenti)

    voto (intero compreso tra 1 e 10, inclusi)

Le informazioni relative ai concorrenti ed alle valutazioni sono conservate in una struttura dati di tipo “array di record esibizione” con nome “esibizioni2025”.

La struttura dati esibizioni 2025 è memorizzata in area HEAP è può ospitare al massimo 29 record Esibizione.

I record per Massimo Ranieri ed Elodie non vengono inseriti a mano dall’utente, ma sono definiti direttamente nel codice come variabili automatiche.


Funzioni da implementare:

    voto_is_valido(): controlla se il voto è compreso tra 1 e 10 e restituisce true se è così
    input: numero (intero)

    mostra_riepilogo(): stampa a video riepilogo
    input: array di record Esibizione e relativo riempimento

    indice_prossimo_concorrente_non_valutato(): restituisce indice del prossimo concorrente non valutato a partire da un indice di partenza specificato
    input: array di record Esibizione, relativo riempimento, e indice di partenza
    output: indice del primo concorrente non valutato (a partire dall’indice di partenza). Viene restituito -1 se tutti i concorrenti hanno un voto.

    aggiungi_esibizione(): dato un record esibizione, lo accoda alla lista di valutazioni, restituisce false se non è possibile perché è stato superato il numero massimo di esibizioni
    input: record Esibizione nuovaEsibizione
    input,output: array di record Esibizione e relativo riempimento
    output (valore di ritorno): false se è stato già raggiunta la dimensione massima della lista esibizioni, true se è stato effettuato l'inserimento

    completa_valutazioni() permette al giurato di inserire (da tastiera) i voti per i concorrenti non ancora valutati.
    Richiama la funzione voto_is_valido() per validare il voto fornito dal giurato e la funzione indice_prossimo_concorrente_non_valutato() per individuare per quali concorrenti chiedere il voto.
    input: array di record Esibizione e relativo riempimento


Per l'implementazione si richiede di seguire le buone pratiche di programmazione strutturata, tra cui

    strutturare il programma secondo l'approccio top-down (nel main() deve essere leggibile la struttura generale del programma, lasciando solo il minimo dei dettagli implementativi)

    evitare variabili globali;

    utilizzare identificativi con nomi autoesplicativi;

    non usare valori letterali, preferendo costanti, enumerativi, e macro di preprocessore;

    dichiarare ed inizializzare variabili nello scope più restrittivo;

    evitare ripetizioni del codice (copia-e-incolla)

 */
/*******************************************************************************/
/* SVOLGIMENTO DI ESEMPIO */
/* In questo svolgimento sono state applicate tutte le "buone pratiche" che
 * favoriscono la leggibilità (e quindi anche la scrittura corretta) del codice.
 * Nella valutazione dello svolgimento, la loro applicazione è valutata positivamente,
 * ma non sono strettamente necessarie per il superamento della prova.
 * Oltre agli input ed output, per ogni funzione sono documentati anche
 * gli effetti collaterali (qualsiasi trasferimento di informazioni, incluse
 * le operazioni di input/output, che non sono visibili dalla firma della funzione).
 * Anche se questo dettaglio di documentazione non è in generale richiesto per
 * lo svolgimento, è un utile esercizio che aiuta a prevenire errori comuni. */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#define LENCONCORRENTE 121
#define MAXCONCORRENTI 29
#define NUM_NUOVE_ESIBIZIONI 2

// valori validi per voto:
const int MIN_VOTO=1;
const int MAX_VOTO=10;

// codice per funzione indice_prossimo_concorrente_non_valutato():
const int NESSUNO_SENZA_VOTO= -1;
// codice di errore per la funzione di lettura da file:
const int ERRORE_FILE = -1;

const int NESSUN_ERRORE = 0;

// Definizione record Esibizione (struct esibizione).
struct esibizione {
    char concorrente [LENCONCORRENTE];
    bool valutato;
    int voto;
};
typedef struct esibizione Esibizione;

int importaConcorrenti(Esibizione* valutazioni, int numeroConcorrentiDaImportare, const char* nomeFile) {
   FILE* file = fopen(nomeFile, "r");
   if (!file) {
       perror("Errore nell'apertura del file");
       return ERRORE_FILE;
   }
   int i = 0;
   // Legge numeroConcorrentiDaImportare concorrenti (meno se non sono presenti nel file)
   while (i < numeroConcorrentiDaImportare && fscanf(file, " %[^\n]",
                                              valutazioni[i].concorrente) != EOF) {
       valutazioni[i].valutato = false;
       valutazioni[i].voto = 999;
       i++;
   }
   fclose(file);
   return i; // Restituisce il numero di recensioni effettivamente importate
   
}


// Controlla se il voto (numero intero) è compreso tra MIN_VOTO e MAX_VOTO estremi inclusi,
// e restituisce true se è così (false altrimenti).
// input: voto
// output: true se il voto è valido
// effetti collaterali: nessuno
bool voto_is_valido (int voto){

    if (voto >= MIN_VOTO && voto <= MAX_VOTO)
        return true;
    else
        return false;
}


int indice_prossimo_concorrente_non_valutato(int indice_partenza, 
                                             int numConcorrenti, 
                                             const Esibizione* esibizioni){

    for (int i=indice_partenza; i<numConcorrenti; i++)
        if (! esibizioni[i].valutato)
            return i;
    
    return NESSUNO_SENZA_VOTO;
}

void mostra_riepilogo(const Esibizione* esibizioni, int numConcorrenti){

    int conteggioValutati = 0;
    float sommaVoti = 0.0f;
    int indiceVotoMax = -1;
    for (int i=0; i<numConcorrenti; i++){
        if (esibizioni[i].valutato){
            // calcolo somma parziale per media
            sommaVoti += esibizioni[i].voto;
            conteggioValutati++;
            // aggiornamento indice massimo parziale
            if (i == -1 esibizioni[i].voto > esibizioni[indiceVotoMax].voto)
                indiceVotoMax = i;
        }        
    }
    printf("Numero voti inseriti: %d\n", conteggioValutati);
    if (conteggioValutati > 0){
        float mediaVoti = sommaVoti / conteggioValutati;    
        printf("Valutazione media: %.2f\n", mediaVoti);
        printf("Valutazione più alta: %s, %d\n", esibizioni[indiceVotoMax].concorrente, 
                                                 esibizioni[indiceVotoMax].voto);
        }
    return;
}

// Stampa info singola esibizione
// con "[N.D.]" in corrispondenza dei voti non disponibili.
// input: singolo record Esibizione
// output: nessuno
// effetti collaterali: stampa a video
void stampa_esibizione(Esibizione e){
    if (e.valutato)
        printf("%s:\t[%d]\n", e.concorrente, e.voto);
    else
        printf("%s:\t[N.D.]\n", e.concorrente);
    return;
}


// Stampa tutte le esibizioni.
// input: array di record Esibizione e relativo riempimento.
// output: nessuno
// effetti collaterali: stampa a video
void stampa_esibizioni(const Esibizione* esibizioni, int numConcorrenti){

    for (int i=0; i<numConcorrenti; i++)
        stampa_esibizione(esibizioni[i]);
    return;
}


// Permette al giurato di inserire (da tastiera) i voti per i concorrenti non ancora valutati.
// Richiama la funzione voto_is_valido() per validare il voto fornito dal giurato 
// e la funzione indice_prossimo_concorrente_non_valutato() per individuare per quali concorrenti chiedere il voto.
// input,output: array di record Esibizione
// input: relativo riempimento
// effetti collaterali: stampa a video conteggio non valutati, usa costante globale NESSUNO_SENZA_VOTO
void completa_valutazioni(Esibizione* esibizioni, int numConcorrenti){
    int numValutazioniMancanti = 0;
    int indiceConc = indice_prossimo_concorrente_non_valutato(0, numConcorrenti, esibizioni);
    while(indiceConc != NESSUNO_SENZA_VOTO){
        int valutare;
        printf("Vuoi valutare %s? (1=sì, 0=no)\n", esibizioni[indiceConc].concorrente);
        scanf("%d", &valutare);
        if (valutare == 1){
            int voto;
            do{
                printf("Inserisci voto: ");
                scanf("%d", &voto);    
            }while(!voto_is_valido(voto));

            esibizioni[indiceConc].voto = voto;
            esibizioni[indiceConc].valutato = true;
        }
        else
            numValutazioniMancanti++;

        indiceConc = indice_prossimo_concorrente_non_valutato(indiceConc+1, numConcorrenti, esibizioni);
    }

    if(numValutazioniMancanti == 0)
        printf("Hai valutato tutti\n");
    else
        printf("%d concorrenti non sono stati valutati\n", numValutazioniMancanti);
                    
}


// Dato un record esibizione, lo accoda alla lista di valutazioni, 
// Restituisce false se non è possibile perché è stato superato il numero massimo di esibizioni
// input: record Esibizione nuovaEsibizione
// input,output: array di record Esibizione e relativo riempimento
// output (valore di ritorno): false se è stato già raggiunta la dimensione massima della lista esibizioni, true se è stato effettuato l'inserimento
// effetti collaterali: legge macro MAXCONCORRENTI
bool aggiungiEsibizione(Esibizione* esibizioni, int* numConcorrenti, Esibizione esibizione){

    if (*numConcorrenti < MAXCONCORRENTI){
        esibizioni[*numConcorrenti] = esibizione;
        (*numConcorrenti)++;
        return true;
    }
    else 
        return false;
}


int main(){

    // La struttura dati è dimensionata al caso peggiore.
    Esibizione* esibizioni2025 = calloc(MAXCONCORRENTI, sizeof(Esibizione));
    
    const char* nomeFileConcorrenti = "sanremo.txt";
    int numConcorrenti = importaConcorrenti(esibizioni2025, 
                                            MAXCONCORRENTI, 
                                            nomeFileConcorrenti);
    if ( numConcorrenti == ERRORE_FILE ){
	    return ERRORE_FILE;
    }

    completa_valutazioni(esibizioni2025, numConcorrenti);
    
    stampa_esibizioni(esibizioni2025, numConcorrenti);
    
    mostra_riepilogo(esibizioni2025, numConcorrenti);

    //   le seguenti istruzioni fino al ciclo for incluso potrebbero essere implementate
    //   come una funzione, per esempio aggiungi_nuove_esibizioni(), per leggibilità,
    //   ma visto che il main() ancora rientra nel limite di una schermata, non è necessario.
    Esibizione nuove_esibizioni[NUM_NUOVE_ESIBIZIONI]= {
    	{.concorrente="Elodie", .valutato=false, .voto=999},
    	{.concorrente="Massimo Ranieri", .valutato=false, .voto=999}
    };

    for (int i = 0; i < NUM_NUOVE_ESIBIZIONI; i++){
    	if( ! aggiungiEsibizione(esibizioni2025, &numConcorrenti, nuove_esibizioni[i]) )
        	printf("Impossibile aggiungere nuove esibizioni!\n");
    	else
        	printf("Inserimento (Esibizione %s) effettuato!\n", nuove_esibizioni[i].concorrente);
    }

    // Assegnazione  voto (o posticipazione) per ciascun concorrente non valutato.
    completa_valutazioni(esibizioni2025, numConcorrenti);
    
    // Stampa di tutte le esibizioni ("N.D." in corrispondenza dei voti non disponibili).
    stampa_esibizioni(esibizioni2025, numConcorrenti);

    // Stampa riepilogo.
    mostra_riepilogo(esibizioni2025, numConcorrenti);

free(esibizioni2025);
    printf("[Sistema]: Memoria HEAP liberata correttamente. Chiusura programma.\n");

   return NESSUN_ERRORE;
}
