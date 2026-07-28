/*  
 *  STATO: CONSEGNA / COMPLETATO
 *  NOME: 
 *  COGNOME: 
 *  MATRICOLA: 
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// 1) Definizione del record Prodotto
struct prodotto {
    int id;
    float prezzo;
    int quantita;
    char descrizione[101];
};
typedef struct prodotto Prodotto;

// Prototipi delle funzioni
int inizializzaInventario(Prodotto *prodotti, int numeroProdottiDaLeggere, const char *nomeFile);
void pulisciBuffer(void);
void aggiungiProdotto(Prodotto *prodotti, int *prodottiAttuali, int dimensioneMassima);
void stampaListaProdottiCostosiInEsaurimento(const Prodotto *prodotti, int prodottiAttuali);

// 4) Implementazione fornita dalla traccia (de-commentata)
int inizializzaInventario(Prodotto *prodotti, int numeroProdottiDaLeggere, const char *nomeFile) {
    FILE* file = fopen(nomeFile, "r");
    if (!file) {
        perror("Errore nell'apertura del file");
        return -1;
    }
    int i = 0;
    // Legge numeroProdottiDaLeggere prodotti (meno se non sono presenti nel file)
    while (i < numeroProdottiDaLeggere && fscanf(file, "%d %f %d %[^\n]",
                                               &prodotti[i].id,
                                               &prodotti[i].prezzo,
                                               &prodotti[i].quantita,
                                               prodotti[i].descrizione) == 4) {
        i++;
    }
    fclose(file);
    return i; // Restituisce il numero di prodotti effettivamente letti
}

int main() {
    int nFile = 0;
    int prodottiAttuali = 0;
    const char *nomeFile = "inventario2024.txt";

    printf("=== GESTIONE INVENTARIO PRODOTTI DI CANCELLERIA ===\n\n");

    // 2) Richiesta all'utente del numero di prodotti da leggere da file (max 50)
    do {
        printf("Inserisci il numero di prodotti da importare da file (max 50): ");
        if (scanf("%d", &nFile) != 1 || nFile < 0 || nFile > 50) {
            printf("Errore: inserisci un valore numerico valido compreso tra 0 e 50.\n");
            pulisciBuffer();
            nFile = -1; // Forza la ripetizione del ciclo
        }
    } while (nFile < 0 || nFile > 50);

    // 3) Allocazione dinamica nello heap (capienza = nFile + 10)
    int capienzaMassima = nFile + 10;
    Prodotto *inventario = (Prodotto *)malloc(capienzaMassima * sizeof(Prodotto));
    if (inventario == NULL) {
        printf("Errore critico: impossibile allocare memoria nell'area heap.\n");
        return 1;
    }

    // 4) Inizializzazione da file e stampa dei prodotti effettivamente importati
    if (nFile > 0) {
        prodottiAttuali = inizializzaInventario(inventario, nFile, nomeFile);
        if (prodottiAttuali < 0) {
            printf("Attenzione: impossibile caricare il file. L'inventario parte vuoto.\n");
            prodottiAttuali = 0;
        } else {
            printf("\nImportazione completata: %d prodotti letti correttamente da file.\n", prodottiAttuali);
        }
    }

    // 5) Inserimento di prodotti da tastiera (fino ad un massimo di 10)
    char scelta;
    do {
        pulisciBuffer(); // Pulisce lo stream prima di chiedere scelta algebrica/testuale
        printf("\nVuoi inserire un nuovo prodotto da tastiera? (s/n): ");
        scanf("%c", &scelta);

        if (scelta == 's' || scelta == 'S') {
            if (prodottiAttuali >= capienzaMassima) {
                printf("Capacita' massima dell'inventario raggiunta (%d prodotti).\n", capienzaMassima);
                break;
            }
            aggiungiProdotto(inventario, &prodottiAttuali, capienzaMassima);
        }
    } while ((scelta == 's' || scelta == 'S') && prodottiAttuali < capienzaMassima);

    // 6) Visualizzazione prodotti costosi in esaurimento
    stampaListaProdottiCostosiInEsaurimento(inventario, prodottiAttuali);

    // Liberazione della memoria allocata nello heap
    free(inventario);
    printf("\nMemoria liberata. Programma terminato con successo.\n");

    return 0;
}

// Funzione di supporto per svuotare il buffer di input (evita salti di lettura)
void pulisciBuffer(void) {
    int c;
    while ((c = getchar()) != '\n' && c != EOF);
}

// 5) Implementazione della funzione per aggiungere un prodotto da tastiera
void aggiungiProdotto(Prodotto *prodotti, int *prodottiAttuali, int dimensioneMassima) {
    if (*prodottiAttuali >= dimensioneMassima) {
        printf("Errore: memoria inventario piena.\n");
        return;
    }

    int indice = *prodottiAttuali;
    printf("\n--- Inserimento Prodotto #%d ---\n", indice + 1);

    printf("ID (intero): ");
    scanf("%d", &prodotti[indice].id);

    printf("Prezzo unitario (es. 15.50): ");
    scanf("%f", &prodotti[indice].prezzo);

    printf("Quantita' residua: ");
    scanf("%d", &prodotti[indice].quantita);

    pulisciBuffer(); // Rimuove il newline '\n' residuo dalla lettura numerica
    printf("Descrizione prodotto: ");
    scanf("%100[^\n]", prodotti[indice].descrizione);

    (*prodottiAttuali)++; // Incrementa il contatore reale nel main tramite puntatore
    printf("Prodotto aggiunto con successo!\n");
}

// 6) Implementazione della stampa per prodotti con quantita' < 10 e prezzo > 12.00
void stampaListaProdottiCostosiInEsaurimento(const Prodotto *prodotti, int prodottiAttuali) {
    printf("\n=======================================================\n");
    printf("  LISTA PRODOTTI COSTOSI IN ESAURIMENTO (Qta<10, Prz>12)\n");
    printf("=======================================================\n");

    bool trovato = false;
    for (int i = 0; i < prodottiAttuali; i++) {
        if (prodotti[i].quantita < 10 && prodotti[i].prezzo > 12.0f) {
            // Formato esatto: 100 x Penna a sfera - prezzo: 10.50 Euro
            printf("%d x %s - prezzo: %.2f Euro\n", 
                   prodotti[i].quantita, 
                   prodotti[i].descrizione, 
                   prodotti[i].prezzo);
            trovato = true;
        }
    }

    if (!trovato) {
        printf("Nessun prodotto corrisponde ai criteri di ricerca.\n");
    }
    printf("=======================================================\n");
}