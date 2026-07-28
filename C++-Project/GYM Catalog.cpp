/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <cstdlib>
#include <string.h>
#include <ctime>
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
using namespace std;
void inserisci_corsi(Cat c, int riemp,int n);
void stampa_ordine(Cat c, int riemp);
void Trova_corso(Cat c,int riemp);
void Elimina_corso(Cat c, int &riemp);
void ordina_per_titolo(Cat c,int riemp);
int main()
{
   
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
        case 1: cout<<"Quanti corsi vuoi inserire?";
        cin>>n;
        cin.ignore();
        inserisci_corsi(c,riemp,n);
        riemp+=n;
        break;
        case 2: ordina_per_titolo(c,riemp);
        stampa_ordine(c,riemp);
        
        break;
        case 3: ordina_per_titolo(c,riemp);
        Trova_corso(c,riemp);
        break;
        case 4: Elimina_corso(c,riemp);
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
}
void stampa_ordine(Cat c, int riemp){
    cout<<"Questa e' la lista dei corsi in ordine di Titolo"<<endl;
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
    cout<<"il corso è iniziato/inizia dal "<<c[media].Data_inizio<<", svolto da "<<c[media].Cognome_istruttore<<",nella fascia oraria "<<c[media].Orario<<", la durata e' di "<<c[media].Durata<<" mesi, "<<" con massimo "<<c[media].Numero_max_pax<<"persone."<<endl;
}else if(trovato==false){ cout<<"il corso non e' presente, mi dispiace";}

}
void Elimina_corso(Cat c,int &riemp){
    if (riemp < 2) {
  cout<<"Nessun secondo corso da eliminare\n"; 
        return;
    }
    cout<<"eliminiamo il secondo corso della lista";
    for(int i=1;i<riemp-1;i++){
    c[i]=c[i+1];}
    riemp--;
    stampa_ordine(c,riemp);}
void ordina_per_titolo(Cat c,int riemp){
   int min;
    for(int i=0;i<riemp-1;i++){
        min=i;
        for(int j=i+1;j<riemp;j++){
            if(strcmp(c[j].Titolo_corso,c[min].Titolo_corso)<0){
                min=j;
            }
        } if(min!=i){
            Catalogo temp=c[i];
            c[i]=c[min];
            c[min]=temp;
        }
    } 
}