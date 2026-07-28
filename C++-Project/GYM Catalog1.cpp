/*Scrivere un programma in C++ che consenta di inserire un array di corsi in palestra (definendone opportunamente il tipo chiamato Catalogo) visualizzarli, eliminarli e cercarli. Ogni Corso è descritto da:
- Codice identificativo numerico
- Titolo del corso (stringa)
- Data di inizio (stringa)
- Cognome istruttore (stringa)
- Orario (stringa)
- Durata
- Numero massimo di partecipanti Il programma, inoltre, dovrà consentire:
1. Inserire più corsi nell’elenco tramite la funzione inserisci_corsi che:
a. Chiede all’utente quanti corsi inserire x
b. Per ogni prestito che l’utente vuole inserire:x
c. Chiede di inserire tutti i campi tranne il codice identificativox
d. Genera un codice numerico randomico tra 1 e 100 e lo associa al campo id;x
e. Inserisce il nuovo corso all’interno dell’array..x
2. Visualizzare i corsi secondo ordinamento alfabetico per titolo visualizza_corsi. Specificare l’algoritmo di ordinamento adottato.x
3. Trovare un corso tra quelli inseriti in base al titolo del corso, tramite ricerca binaria. La funzione trova_corso:
a. Prende in ingresso una stringa da cercare;
b. Visualizza il corso con titolo pari a quello specificato, se presente.
4. (OPZIONALE) Eliminare il secondo corso dall’elenco, tramite la funzione elimina_corso che:
a. Visualizza tutti i corsi in maniera ordinata.
b. Elimina dall’array il secondo corso (indice 1). (N.B.: l’eliminazione di un elemento prevede di traslare tutti gli elementi dell’array prestiti, che sono successivi all’elemento da cancellare, di una posizione a sinistra dell’elemento da cancellare.) Il main del programma presenta un messaggio iniziale e almeno una volta, e finché l'utente non sceglie di uscire, chiede all'utente di inserire un carattere per scegliere se:
(1) inserire corsi
(2) visualizzare i corsi in ordine di titolo
(3) cercare un corso per titolo
(4) eliminare un corso
(5) uscire
A seconda della scelta dell'utente, il main() richiama la funzione specifica, oppure comunica che è stata effettuata una scelta errata.*/

#include <iostream>
#include <cstdlib>
#include <string.h>
#include <ctime>

using namespace std;

typedef char Stringa[100];

struct Catalogo{
 int id;
 Stringa Titolo_corso;
 Stringa Data_inizio;
 Stringa Cognome_istruttore;
 Stringa Orario;
 int Durata;
 int Numero_max_pax;
};

typedef Catalogo Cat[100];

void inserisci_corsi(Cat c, int riemp,int n);
void stampa_ordine(Cat c, int riemp);
void Trova_corso(Cat c,int riemp);
void Elimina_corso(Cat c, int &riemp);
void ordina_per_titolo(Cat c,int riemp);

int main(){

srand((unsigned int)time(NULL));   

    Cat c;
    int choice, riemp=0, n;

do{ 
    cout<<"\nDecidi quale operazione svolgere: "<<endl;
    cout<<"1) Inserisci corsi"<<endl;
    cout<<"2) Visualizzare i corsi in ordine di titolo"<<endl;
    cout<<"3) cercare un corso per titolo"<<endl;
    cout<<"4) eliminare corso"<<endl;
    cout<<"5) Uscire dal programma"<<endl;
    cin>>choice;
    cin.ignore();
    switch(choice){
        case 1: 
		cout<<"Quanti corsi vuoi inserire?";
        	cin>>n;
        	cin.ignore();

	if(riemp+n >100){        
		cout << "Errore: lo spazio disponibile nell'elenco non e' sufficiente (" << (100 - riemp) << " posti rimasti)." << endl;
                } else {
	inserisci_corsi(c,riemp,n);
	}
		break;        
	
	case 2:
	if(riemp==0){
	cout << "Nessun corso presente nel catalogo." << endl;
                } else {

	 ordina_per_titolo(c,riemp);
        stampa_ordine(c,riemp);
	}        
        break;

        case 3: 
if (riemp == 0) {
                    cout << "Nessun corso presente nel catalogo." << endl;
                } else {
ordina_per_titolo(c,riemp);
        Trova_corso(c,riemp);
        }
	break;
        
	case 4: 
	Elimina_corso(c,riemp);
        break;
    
	case 5:
	cout <<"Chiusura del programma in corso..."<<endl;
	break;

	default: cout<<" ERRORE, devi inserire un numero tra 1 e 5";
   	 }
}while(choice!=5);

    return 0;
}


void inserisci_corsi(Cat c,int riemp,int n){

for(int i=riemp;i<riemp+n;i++){
    
    int id=rand() % 100 + 1;
    c[i].id=id;
    cout<<"l' id del corso e' "<<c[i].id;
    cout<<" inserisci il titolo del corso: ";
    cin.getline(c[i].Titolo_corso,100);

    cout<<"inserisci la data di inizio del corso: ";
    cin.getline(c[i].Data_inizio,100);

    cout<<"inserisci il cognome dell' istruttore: ";
    cin.getline(c[i].Cognome_istruttore,100);

    cout<<"inserisci l' orario in cui si tiene il corso: ";
    cin.getline(c[i].Orario,100);

    cout<<"quanti mesi dura il corso: ";
    cin>>c[i].Durata;

    cout<<"inserisci il numero massimo di persone: ";
    cin>>c[i].Numero_max_pax;

    cin.ignore();
    
}   
riemp=+ n; 
}

void stampa_ordine(Cat c, int riemp){
    cout<<"Questa e' la lista dei corsi in ordine di Titolo (Algortimo: SELECTION SORT)"<<endl;
    for(int i=0;i<riemp;i++){
        cout<<i+1<<") "<<c[i].Titolo_corso<<",il corso è iniziato/inizia dal "<<c[i].Data_inizio<<", svolto da "<<c[i].Cognome_istruttore<<",nella fascia oraria "<<c[i].Orario<<", la durata e' di "<<c[i].Durata<<" mesi, "<<" con massimo "<<c[i].Numero_max_pax<<"persone."<<endl;
    }
}

void Trova_corso(Cat c,int riemp){
Stringa corso;
bool trovato=false;
cout<<"inserisci il nome di un corso che vuoi cercare";
cin.getline(corso,100);
int prima=0, ultima=riemp-1, media;
while(prima<=ultima && !trovato){
media=(int)(prima+ultima)/2;
if(strcmp(corso,c[media].Titolo_corso)==0){
    trovato=true;
}else if(strcmp(corso,c[media].Titolo_corso)<0){
    ultima=media-1;
}else if(strcmp(corso,c[media].Titolo_corso)>0){
    prima=media+1;
}
}if(trovato==true){
    cout<<"il corso " <<corso<<" e' il seguente"<<endl;
    cout<<media+1<<"),il corso è iniziato/inizia dal "<<c[media].Data_inizio<<", svolto da "<<c[media].Cognome_istruttore<<",nella fascia oraria "<<c[media].Orario<<", la durata e' di "<<c[media].Durata<<" mesi, "<<" con massimo "<<c[media].Numero_max_pax<<"persone."<<endl;
}else if(trovato==false){ cout<<"il corso non e' presente, mi dispiace";}

}

void Elimina_corso(Cat c, int &riemp) {
    if (riemp < 2) {
        cout << "Errore: sono presenti meno di 2 corsi. Impossibile eliminare il secondo elemento!" << endl;
        return;
    }

    cout << "\n--- Visualizzazione prima dell'eliminazione ---";
    ordina_per_titolo(c, riemp);
    stampa_ordine(c, riemp);

    cout << "\nEliminazione del secondo corso in corso (Indice 1: '" << c[1].Titolo_corso << "')..." << endl;
    
    
    for(int i = 1; i < riemp - 1; i++) {
        c[i] = c[i + 1];
    }
    riemp--; // Decrementa il numero di elementi effettivi

    cout << "[Successo] Corso eliminato! Ecco il catalogo aggiornato:";
    stampa_ordine(c, riemp);
}