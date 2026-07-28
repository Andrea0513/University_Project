/*
# 📚 University Library Loan Management System (Gestione Prestiti)

Hi everyone! 👋 Welcome to my C++ project called **University Library Loan Management System**! 

I created this software to simulate how a university library or book club manages book loans for students. The coolest part about this project is that it uses **procedural C++ programming**, fixed-size arrays of custom `struct` types, and classic algorithms like **Selection Sort** without relying on complex external libraries!

The whole application is built using fundamental computer science concepts like data structures (`struct`), string manipulation with `char` arrays, pass-by-reference variables, and modular functions!

---

## 💡 What is this project about?

Basically, the software manages a general catalog of book loans (`Prestito`). Every loan record holds important information about both the book and the student:
* **Book Details**: A unique randomly generated Loan ID (`Cid`), the book title (*Titolo_libro*), the loan date, and the loan type (like monthly or weekly).
* **Student Details**: The student's first name, last name (*Cognome_studente*), and their unique university identification number (*Matricola*).

Using an interactive terminal menu, the librarian can add new loans, sort the records alphabetically or by ID, search for specific books or students, and remove returned books from the system!

---

## 🛠️ How the Code is Structured

To keep the project clean, modular, and easy to read, I divided the logic into specific functions:

* **`struct Prestito` & `Elenco`**: The core data structure. Instead of using standard C++ vectors, I created a custom `struct` to group all the variables together and defined an array type (`Elenco`) capable of storing up to 100 simultaneous loans!
* **`inserisci_prestito()`**: Handles data input. It automatically generates a random 4-digit ID using `rand()` and uses `cin.getline()` to safely read multi-word strings like book titles and full names without breaking the input buffer!
* **`visualizza_prestiti()`**: This is where the sorting happens! I implemented the classic **Selection Sort algorithm** from scratch. It loops through the array, finds the student with the smallest *Matricola* number, and swaps (`temp`) the records to sort the whole list in ascending order!
* **`trova_prestito()`**: A targeted search function. It uses the standard C library function `strcmp()` to compare the user's search query against both the student's last name and the book title, printing all matching records instantly!
* **`Eliminazione()`**: Handles book returns. When a book is returned, this function removes the oldest loan (index 0) by shifting all subsequent array elements one position to the left (`e[i] = e[i+1]`). By passing the array counter by reference (`int &riemp`), the program safely decreases the total size without memory leaks!

---

## 🌟 Key Features

1. **Custom Selection Sort Algorithm**: Instead of using pre-made sorting functions, the project demonstrates a direct implementation of Selection Sort, making it a great educational example of time complexity and array manipulation!
2. **Safe Buffer Management**: One of the biggest challenges in C++ is mixing standard `cin >>` numbers with `cin.getline()` text strings. I implemented careful buffer clearing using `cin.ignore()` to prevent the terminal from skipping user inputs!
3. **Dual-Criteria Searching**: The search function is really flexible! You don't need two separate menus: you can type either a student's surname or a book title into the exact same prompt, and the program will find the correct match!
4. **Pass-by-Reference Shifting**: The deletion mechanism modifies the actual size variable directly in the memory address (`&riemp`), ensuring that the main menu and all other subroutines stay perfectly synchronized with the real number of active loans.

Thank you so much for checking out my C++ library project! I hope you like it! 😄

*/
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
