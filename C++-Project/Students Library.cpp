

#include <iostream>
#include <cstdlib>
#include <string.h>
#include <ctime>
using namespace std;

typedef char Stringa[100];

struct Prestito{
 int Cid;
 Stringa Titolo_libro;
 Stringa Data_prestito;
 Stringa Tipologia_prestito;
 Stringa Nome_studente;
 Stringa Cognome_studente;
 int Matricola;
};

typedef Prestito Elenco[100];

void inserisci_prestito(int riemp, Elenco e);
void visualizza_prestiti(int riemp, Elenco e);
void trova_prestito(int riemp, Elenco e, Stringa nome);
void Eliminazione( int riemp,Elenco e);

int main()
{
    srand((unsigned int)time(NULL));
    Elenco e; int riemp=0; int choice; char yn; Stringa nome;
do{
    cout<<"1)Inserisci prestiti\n";
    cout<<"2)Ordina in base alla matricola\n";
    cout<<"3)Ricerca per nome libro oppure Cognome\n";
    cout<<"4)Elimina Primo Prestito\n";
    cout<<"Quale operazione vuoi svolgere? ";
    cin>>choice;
    cin.ignore();

    		switch(choice){
    case 1: do{
	if(riemp>=100){
cout <<" Capacita' massima raggiunta! << endl;
break;
}    
inserisci_prestito(riemp, e);
    riemp++;
    cout<<"vuoi inserire un nuovo prestito? ";
    cin>>yn;
    cin.ignore();
    }while(yn=='y');
    break;

    case 2: 
	if(riemp == 0) {
                    cout << "Nessun prestito da ordinare." << endl;
                } else {
visualizza_prestiti(riemp,e);
    cout<<"abbiamo usato il selection sort per ordinare, e l' elenco ordinato e':\n";
    for(int i=0;i<riemp;i++){
        cout<<i+1<<")"<<e[i].Matricola<<" "<<e[i].Titolo_libro<<" "<<e[i].Nome_studente<<" "<<e[i].Cognome_studente<<"\n "<<endl;
    }
}
    break;
    case 3: 
	if(riemp == 0) {
                    cout << "Elenco vuoto." << endl;
                } else {
cout<<"inserisci il Cognome dello studente oppure il nome del libro";
cin.getline(nome,100);
trova_prestito(riemp,e,nome);
}
    break;
    case 4: Eliminazione(riemp,e);
    break;    
    
    case 5:
    cout << "Chiusura in corso..." << endl;
    break;

    default:
    cout << "Scelta non valida. Riprova." << endl;

}
}while(choice!=5);
cout<<"il programma e terminato";

    return 0;
}
void inserisci_prestito(int riemp, Elenco e){
 int numero;
    numero=rand();
    cout<<"l' id e': "<<numero;
    cout<<" il nome del libro e':";
    cin.getline(e[riemp].Titolo_libro,100);

    cout<<" la data in cui e' avvenuto il prestito e':";
    cin.getline(e[riemp].Data_prestito,100);

    cout<<" La tipologia del prestito e' del tipo:";
    cin.getline(e[riemp].Tipologia_prestito,100);

    cout<<" il nome dello studente che ha avuto in prestito il libro e':";
    cin.getline(e[riemp].Nome_studente,100);

    cout<<" il cognome dello studente che ha avuto in prestito il libro e':";
    cin.getline(e[riemp].Cognome_studente,100);

    cout<<" la matricola dello studente e':";
    cin>>e[riemp].Matricola;
    cin.ignore();
    
}
void visualizza_prestiti(int riemp, Elenco e){
    int min;
    for(int i=0;i<riemp-1;i++){
        min=i;
        for(int j=i+1;j<riemp;j++){
            if(e[j].Matricola<e[min].Matricola){
                min=j;
            }
        } if(min!=i){
            Prestito temp;
            temp=e[i];
            e[i]=e[min];
            e[min]=temp;}
        
    }
}
void trova_prestito(int riemp, Elenco e, Stringa nome){
bool trovato=false;
cout<<"i prestiti abbinati a questo Cognome/Titolo sono:\n";
for(int i=0;i<riemp;i++){
    if(strcmp(e[i].Cognome_studente,nome)==0 || strcmp(e[i].Titolo_libro,nome)==0){
        trovato=true;
    cout<<i+1<<" "<<e[i].Matricola<<" "<<e[i].Titolo_libro<<" "<<e[i].Nome_studente<<" "<<e[i].Cognome_studente<<"\n "<<endl;}
}if(!trovato){cout<<"NESSUNO";}}

void Eliminazione( int riemp,Elenco e){
if(riemp == 0) {
        cout << "Errore: l'elenco e' gia' vuoto, impossibile eliminare!" << endl;
        return;
    }
  for(int i=0;i<riemp-1;i++){
      e[i]=e[i+1];
riemp--;
}
 
for(int i=0;i<riemp;i++){
 cout<<i+1<<")"<<e[i].Matricola<<" "<<e[i].Titolo_libro<<" "<<e[i].Nome_studente<<" "<<e[i].Cognome_studente<<"\n "<<endl;}  
}
}