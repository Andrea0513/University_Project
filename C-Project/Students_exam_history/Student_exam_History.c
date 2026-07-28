/*
Esercitazione fine corso 1 (1h 15’)
Utilizzando i principi della programmazione strutturata, progettare e implementare
un programma per la memorizzazione e la gestione dei risultati dei voti d’esame.

Il programma mette a disposizione un menù attraverso il quale l’utente
può scegliere tra le seguenti funzionalità:

Stampa storico - stampa a video tutte le informazioni contenute in una
    struttura dati “storico”. Richiama la funzione stampa_esame().

Inserisci nuovo esame - aggiunge un nuovo esame alla struttura dati,
    inizializzandone i campi con le informazioni inserite da tastiera
    *opportunamente validate*

Calcola media - data una matricola inserita dall’utente da tastiera,
    il programma stampa a video la media degli esami sostenuti.

Stampa voti sopra soglia - dato un voto minimo inserito dall’utente da tastiera,
    stampa a video la lista di esami con voto maggiore o uguale a quello inserito.

Cancella voti studente - data una matricola inserita dall’utente da tastiera,
    elimina le informazioni di tutti gli esami relativi a quello studente.

Per l’implementazione del programma, seguire le indicazioni riportate di seguito.

Si preveda una opportuna struttura dati "storico" che permetta la memorizzazione
di un record "esame" contenente i seguenti campi informativi:
- matricola_studente (permette memorizzazione di 4 caratteri)
- nome_esame (il nome dell’esame è al massimo di 50 caratteri)
- voto (numero intero)
- lode (valore booleano) 

La struttura dati “storico” gestisca al massimo 100 record di tipo “esame”.

La struttura dati sia inizializzata come di seguito riportato:
        { "1234", "Fondamenti di Informatica", 25, false}
        { "1235", "Fondamenti di Informatica", 28, false}
        { "1236", "Fondamenti di Informatica", 30, true}
        { "1234", "Analisi I", 18, false}
        { "1236", "Analisi I", 27, false}
        { "1235", "Fisica I", 28, false}
        { "1236", "Fisica I", 26, false}

Implementare le seguenti funzioni:

stampa_esame(). Prende in ingresso un singolo record di tipo esame
e mostra a video le informazioni in esso contenute nel formato seguente:

Matricola: 1236 - Esame: Fondamenti di Informatica - Voto: 30 e lode.

valida_esame(). Prende in ingresso un singolo record di tipo esame X
    e restituisce un valore booleano.
    I dati di un esame sono validi se
    1) il voto è compreso tra 18 e 30 e
    2) se il voto è 30 in caso di lode.

stampa voti sopra soglia(). Prende in ingresso la struttura dati
    “storico” (ed il suo riempimento)  ed una soglia voto.
    Stampa a video le informazioni di tutti gli esami il cui voto
    è maggiore o uguale alla soglia.

calcola_media_studente(). Prende in ingresso la struttura dati X
    “storico” (ed il suo riempimento) ed una matricola
    e restituisce la media degli esami sostenuti
    dallo studente associato alla matricola.  

cancella voti studente(). Prende in ingresso la struttura
    dati “storico” (ed il suo riempimento)  ed una matricola.
    Elimina dalla struttura dati *tutti* gli esami sostenuti
    dallo studente avente la matricola indicata.

N.B. le funzioni possono richiamare a loro volta alcune delle funzioni
    previste per la realizzazione di compiti elementari.

E’ possibile utilizzare funzioni della libreria cstring,
    quali strcpy, strcmp, strlen, strcat.

*/

#include <stdio.h>
#include <stdbool.h>
#include <string.h>

#define MAT_MAX 5
#define MAX_NOME_ESAME 51
#define MAX_ESAMI 100
#define VOTO_MAX 30
#define VOTO_MIN 18

typedef struct{
char matricola_studente[MAT_MAX];
char nome_esame[MAX_NOME_ESAME];
int voto; 
bool lode; 
}Storico;

enum{ // serve per ordinare i vari casi possibili all' interno del menu.
    ESCI,
    STAMPA_STORICO,
    INSERISCI_NUOVO_ESAME,
    CALCOLA_MEDIA,
    STAMPA_VOTI_SOPRA_SOGLIA,
    CANCELLA_VOTI_STUDENTI
}; 

int menu(){ // Stampa a schermo tutte le azioni possibili all' interno del programma.
    int input_utente;
    printf("--------------------\n");
    printf("%d. Stampa storico\n",STAMPA_STORICO);
    printf("%d. Inserisci nuovo esame\n",INSERISCI_NUOVO_ESAME);
    printf("%d. Calcola media\n",CALCOLA_MEDIA);
    printf("%d. Stampa voti sopra soglia\n",STAMPA_VOTI_SOPRA_SOGLIA);
    printf("%d. Cancella voti studenti\n",CANCELLA_VOTI_STUDENTI);
    printf("%d. Esci\n",ESCI);
    printf("Scegli quale operazione vuoi svolgere...\n");
    scanf("%d",&input_utente);

    while(input_utente>CANCELLA_VOTI_STUDENTI || input_utente<ESCI){ 
        printf("perfavore, inserire un numero in elenco!!\n");
        scanf("%d",&input_utente);
    }
    return input_utente;
}

int stampa_esame(Storico esame){
    printf("Numero matricola: %s - Nome dell' esame: %s - voto dell' esame: %d -",esame.matricola_studente, esame.nome_esame, esame.voto);
    if(esame.lode==true){
        printf("con lode\n"); 
    }else{
        printf("\n");
    return 0;
}} //stampa il singolo esame

bool valida_esame(Storico *esame){
if(esame->voto<VOTO_MIN || esame->voto>VOTO_MAX){
    printf("mi dispiace ma non è possibile eseguire l' operazione\n");
    return false;
}else{
if(esame->voto==VOTO_MAX){
    int lode_singolo_esame;
    printf("è stata conseguita la lode?? 1.si 0.no");
    scanf("%d",&lode_singolo_esame);
    if(lode_singolo_esame==1){
    esame->lode=true;
}else{ esame->lode=false;
    }
    return true;
}
} 
// valida l' esame inserito e controlla se è presente nell' intervallo dato nel quale deve essere contenuto il voto, inoltre nel caso di voto massimo, verifica e aggiunge ove necessario la lode

void inserisci_matricola(Storico *esame){
     printf("inserisci la matricola dello studente che ha tenuto l' esame: ");
    scanf("%4s",esame->matricola_studente);
    scanf("%*[^\n]");
    getchar();
}//inserisce la singola matricola nell' array di struct

void inserisci_nome_esame(Storico *esame){
    printf("inserisci il nome dello studente che ha tenuto l' esame: ");
    scanf(" %[^\n]",esame->nome_esame);
}//inserisce il nome dell' esame tenuto dallo studente nell' array di struct

void inserisci_voto(Storico *esame){
    printf("inserisci il voto: ");
    scanf("%d",&esame->voto);
} ////inserisce il voto all' esame nell' array di struct

void Stampa_storico(const Storico esame[],int numero_esami){
	for(int i=0;i<numero_esami;i++){
    	stampa_esame(esame[i]);
	}
} // stampa tutti gli array di struct presenti in Storico

int inserisci_nuovo_esame(Storico esame[],int *numero_esami){ 

   inserisci_matricola(&esame[*numero_esami]);
   inserisci_nome_esame(&esame[*numero_esami]);
   inserisci_voto(&esame[*numero_esami]);
   if(valida_esame(&esame[*numero_esami])==true){
   (*numero_esami)++; }else {return 0;};
}//richiama tutte le funzioni per modificare l' array di struct, e valida l' esame

void Calcola_media(const Storico esame[],int *numero_esami){
    int conteggio=0; 
    float totale, media=0;
    char Matricola_ricercata[MAT_MAX];
    printf("inserisci la matricola che vuoi ricercare: ");
    scanf("%4s",Matricola_ricercata);
    scanf("%*[^\n]");
    getchar();
    for(int i=0;i<*numero_esami;i++){
    if(strcmp(esame[i].matricola_studente,Matricola_ricercata)==0){
        conteggio++;
        media=media+esame[i].voto;
    }else;
}if(conteggio==0){
    printf("non è presente la matricola da te inserita\n");
}else if(conteggio!=0){ 
totale=media/conteggio;
printf("la media dei voti della matricola da te inserita è: %f\n",totale);  
}
}// Inserita una matricola, controlla se è presenta nei vari array di struct, e se è presente ne tiene il conto e somma tutti i voti dei vari esami di quella matricola fino a dare la media finale


void Stampa_Voto_sopra_soglia(const Storico esame[],int *numero_esami){
    int voto_min;
    int conteggio=0;
    printf("inserire il voto che si vuole controllare: ");
    scanf("%d",&voto_min);
    for(int i=0;i<*numero_esami;i++){
        if(esame[i].voto>=voto_min){
            stampa_esame(esame[i]);
            conteggio++;
        }
    }if (conteggio==0){
        printf("non ci sono voti più alti di questo inserito!!\n");
    }
} // Inserito un voto, verifica con un ciclo for tutti i voti che ci sono negli array e stampa quelli dove è presente

void Cancella_Voti(Storico esame[],int*numero_esami){
    int conteggio=0;
char Matricola_ricercata[MAT_MAX];
    printf("inserisci la matricola che vuoi ricercare: ");
    scanf("%4s",Matricola_ricercata);
    scanf("%*[^\n]");
    getchar();
    for(int i=0;i<*numero_esami;i++){
    if(strcmp(esame[i].matricola_studente,Matricola_ricercata)==0){
        for(int j=i;j<*numero_esami;j++){
        esame[j]=esame[j+1];
        }
	(*numero_esami)--;
	conteggio++;
	i--;
    }
}
if(conteggio==0){
    printf("non è presente la matricola da te inserita\n");
}else{
	printf("Cancellati %d esami con successo!\n", conteggio);
}

}
int main () {
Storico esame[MAX_ESAMI]={
    { "1234", "Fondamenti di Informatica", 25, false},
    { "1235", "Fondamenti di Informatica", 28, false},
    { "1236", "Fondamenti di Informatica", 30, true},
    { "1234", "Analisi I", 18, false},
    { "1236", "Analisi I", 27, false},
    { "1235", "Fisica I", 28, false},
    { "1236", "Fisica I", 26, false}
};
int numero_esami= 7;
int input_utente;

do{
input_utente=menu();
 switch(input_utente){ 
     case STAMPA_STORICO:{ Stampa_storico(esame,numero_esami);
     }break;
     case INSERISCI_NUOVO_ESAME:{ inserisci_nuovo_esame(esame,&numero_esami);
    }break;
     case CALCOLA_MEDIA:{Calcola_media(esame,&numero_esami);
         
     }break;
     case STAMPA_VOTI_SOPRA_SOGLIA:{ Stampa_Voto_sopra_soglia(esame,&numero_esami);
         
     }break;
     case CANCELLA_VOTI_STUDENTI:{ Cancella_Voti(esame,&numero_esami);
         
     }break;
     case ESCI:{
         printf("Uscita dal programma in corso...\n");
     }break;
}
}while(input_utente!=ESCI);

return 0;

}