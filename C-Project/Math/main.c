#include <stdio.h>
#include <math.h>
#include <stdlib.h>

#define MAX_SIZE 100

// Funzione per sommare due vettori
void somma_vettori(double v1[], double v2[], double risultato[], int n) {
    for (int i = 0; i < n; i++) {
        risultato[i] = v1[i] + v2[i];
    }
}

// Funzione per sottrarre due vettori
void sottrai_vettori(double v1[], double v2[], double risultato[], int n) {
    for (int i = 0; i < n; i++) {
        risultato[i] = v1[i] - v2[i];
    }
}

// Funzione per calcolare il prodotto scalare
double prodotto_scalare(double v1[], double v2[], int n) {
    double risultato = 0.0;
    for (int i = 0; i < n; i++) {
        risultato += v1[i] * v2[i];
    }
    return risultato;
}

double norma_vettore(const double v[], int n) {
    double somma_quadrati = 0.0;
    for (int i = 0; i < n; i++) {
        somma_quadrati += v[i] * v[i];
    }
    return sqrt(somma_quadrati);
}


// Funzione per stampare un vettore
void stampa_vettore(double v[], int n) {
    printf("[ ");
    for (int i = 0; i < n; i++) {
        printf("%.2f ", v[i]);
    }
    printf("]\n");
}

// Funzione per leggere un vettore con verifica di validità
void leggi_vettore(double v[], int n) {
    printf("Inserisci i valori del vettore (separati da spazio): ");
    for (int i = 0; i < n; i++) {
        while (1) {  // Ciclo per riprovare in caso di input non valido
            if (scanf("%lf", &v[i]) != 1) {
                printf("Errore nell'inserimento dei dati. Assicurati di inserire numeri validi. Riprova: ");
                // Pulisci il buffer di input in caso di errore
                while(getchar() != '\n');  
            } else {
                break;  // Esci dal ciclo se il valore è stato inserito correttamente
            }
        }
    }
pulisci_buffer();
}

int main() {
    int scelta, n, m;

    // Chiedi la dimensione dei vettori
    printf("Inserisci la dimensione dei vettori (1-%d): ", MAX_SIZE);
    while (1) {
        if (scanf("%d", &n) != 1 || n <= 0 || n > MAX_SIZE) {
            printf("La dimensione del vettore deve essere tra 1 e %d. Riprova: ", MAX_SIZE);
            while (getchar() != '\n');  // Pulisce il buffer
        } else {
            break;  // Esci dal ciclo se l'input è valido
        }
    }

    // Chiedi quanti vettori inserire
    printf("Quanti vettori vuoi inserire? ");
    while (1) {
       printf("Quanti vettori vuoi inserire? (1-%d): ", MAX_VETTORI);
        if (scanf("%d", &m) != 1 || m <= 0 || m > MAX_VETTORI) {
            printf("Errore: il numero di vettori deve essere compreso tra 1 e %d.\n", MAX_VETTORI);
            pulisci_buffer();
        } else {
            pulisci_buffer();
            break;
        }
    }

    // Dichiarazione per l'array di vettori
    double vettori[m][MAX_SIZE];
    double risultato[MAX_SIZE];

    // Leggi i vettori
    for (int i = 0; i < m; i++) {
        printf("\nInserisci il vettore %d:\n", i + 1);
        leggi_vettore(vettori[i], n);
    }

    do {
        // Stampa il menù
        printf("\nMenu Operazioni sui Vettori:\n");
        printf("1. Somma di due vettori\n");
        printf("2. Sottrazione di due vettori\n");
        printf("3. Prodotto scalare di due vettori\n");
        printf("4. Dimensione di un vettore\n");
        printf("5. Uscire\n");
        printf("Scegli un'operazione (1-5): ");
        if (scanf("%d", &scelta) != 1) {
            printf("Scelta non valida. Riprova.\n");
            while(getchar() != '\n');  // Pulisce il buffer
            continue;  // Continua il ciclo se l'input è errato
        }
	pulisci_buffer();

        int v1_index, v2_index;

        switch (scelta) {
            case 1:

                printf("\n--- SOMMA VETTORIALE ---\n");
                // [BUONA PRATICA]: Chiamata alla nuova funzione di supporto per la convalida degli indici
                v1_idx = leggi_indice_vettore(m, "Scegli il primo addendo");
                v2_idx = leggi_indice_vettore(m, "Scegli il secondo addendo");

                somma_vettori(vettori[v1_idx], vettori[v2_idx], risultato, n);
                printf("\nRisultato di Vettore %d + Vettore %d:\n", v1_idx + 1, v2_idx + 1);
                stampa_vettore(risultato, n);
                break;

            case 2:

               printf("\n--- SOTTRAZIONE VETTORIALE ---\n");
                v1_idx = leggi_indice_vettore(m, "Scegli il minuendo");
                v2_idx = leggi_indice_vettore(m, "Scegli il sottraendo");

                sottrai_vettori(vettori[v1_idx], vettori[v2_idx], risultato, n);
                printf("\nRisultato di Vettore %d - Vettore %d:\n", v1_idx + 1, v2_idx + 1);
                stampa_vettore(risultato, n);
                break;
                }

                v1_index--; v2_index--;
                sottrai_vettori(vettori[v1_index], vettori[v2_index], risultato, n);
                printf("Sottrazione dei vettori %d e %d: ", v1_index + 1, v2_index + 1);
                stampa_vettore(risultato, n);
                break;

            case 3:
             printf("\n--- PRODOTTO SCALARE ---\n");
                v1_idx = leggi_indice_vettore(m, "Scegli il primo vettore");
                v2_idx = leggi_indice_vettore(m, "Scegli il secondo vettore");

                double prod = prodotto_scalare(vettori[v1_idx], vettori[v2_idx], n);
                printf("\nIl prodotto scalare (Vettore %d · Vettore %d) vale: %.4f\n", v1_idx + 1, v2_idx + 1, prod);
                break;

            case 4:
                printf("\n--- CALCOLO NORMA EUCLIDEA ---\n");
                v1_idx = leggi_indice_vettore(m, "Scegli il vettore di cui calcolare la norma");

                double norma = norma_vettore(vettori[v1_idx], n);
                printf("\nLa Norma Euclidea (lunghezza/modulo) del Vettore %d in R^%d vale: %.4f\n", v1_idx + 1, n, norma);
                break;

            case 5:
                printf("\n--- RIEPILOGO VETTORI IN MEMORIA ---\n");
                for (int i = 0; i < m; i++) {
                    printf("Vettore %d: ", i + 1);
                    stampa_vettore(vettori[i], n);
                }
                break;
	    
	   case 6:
		printf("\nChiusura del programma. Arrivederci!\n");
                break;

            default:
                printf("Opzione inesistente. Scegli un numero compreso tra 1 e 6.\n");
        }
    } while (scelta != 6);

    return 0;  
}
