*-------------------------------------------------------------------------
* CONSEGNA ESERCIZIO - PUNTO 1:
* Assegnati due vettori A e B di 10 word ciascuno sviluppare un programma
* per il processore Motorola 68000 che:
* 1) Conti il numero di volte che si verifica A[i]=B[9-i] per i=0,...,4
*-------------------------------------------------------------------------

        ORG     $8000           * Direttiva: posiziona l'area Dati all'indirizzo $8000
A       DC.W    1,5,3,8,2,0,4,7,9,10    * Vettore A di 10 word (16 bit)
B       DC.W    10,9,7,4,0,2,8,3,5,1    * Vettore B di 10 word (speculare per testare il conteggio)
DIM     DC.W    10                      * Dimensione dei vettori (10 elementi)
COUNT   DS.W    1                       * Spazio di 1 word riservato in RAM per salvare il risultato finale

*-------------------------------------------------------------------------
* PROGRAMMA PRINCIPALE (MAIN)
*-------------------------------------------------------------------------
        ORG     $8100           * Direttiva: posiziona l'area Codice all'indirizzo $8100
MAIN:
        * --- FASE 1: PASSAGGIO DEI PARAMETRI SULLO STACK ---
        MOVE.L  #A,-(SP)        * Push dell'indirizzo di base del vettore A (32 bit -> SP scende di 4)
        MOVE.L  #B,-(SP)        * Push dell'indirizzo di base del vettore B (32 bit -> SP scende di 4)
        MOVE.W  DIM,-(SP)       * Push della dimensione dei vettori (16 bit -> SP scende di 2)
        SUBQ.L  #2,SP           * Riserva 2 byte vuoti sullo Stack per ospitare il valore di ritorno
        
        * --- FASE 2: CHIAMATA ALLA SUBROUTINE ---
        JSR     CONTA           * Salta alla subroutine CONTA (salva l'indirizzo di ritorno sullo Stack)
        
        * --- FASE 3: RECUPERO DEL RISULTATO E PULIZIA DELLO STACK ---
        MOVE.W  (SP)+,COUNT     * Preleva il valore calcolato dallo Stack (SP sale di 2) e lo salva in COUNT
        ADDA.L  #10,SP          * Ripristina lo Stack Pointer rimuovendo i parametri (2+4+4 = 10 byte)

FINE:   
        JMP     FINE            * Loop infinito per terminare l'esecuzione in sicurezza

*-------------------------------------------------------------------------
* SUBROUTINE: CONTA
* Confronta A[i] con B[9-i] per i = 0, 1, 2, 3, 4 e conta le uguaglianze
*-------------------------------------------------------------------------
        ORG     $8200           * Direttiva: posiziona la subroutine all'indirizzo $8200
CONTA:
        * --- LETTURA DEI PARAMETRI DAL FRAME DELLO STACK ---
        * Nota: all'offset 0(SP) ci sono i 4 byte dell'indirizzo di ritorno di JSR
        * all'offset 4(SP) ci sono i 2 byte riservati per il risultato
        * all'offset 6(SP) c'è la word DIM (non usata direttamente qui)
        * all'offset 8(SP) c'è l'indirizzo a 32 bit del vettore B
        * all'offset 12(SP) c'è l'indirizzo a 32 bit del vettore A
        
        MOVEA.L 12(SP),A0       * A0 = Indirizzo iniziale di A (punta a A[0])
        MOVEA.L 8(SP),A1        * A1 = Indirizzo iniziale di B (punta a B[0])
        
        ADDA.L  #20,A1          * Sposta A1 alla FINE di B (10 word = 20 byte totali)
        
        CLR.W   D1              * D1 = Indice i del ciclo (inizializzato a 0)
        CLR.W   D2              * D2 = Contatore delle uguaglianze trovate (inizializzato a 0)

LOOP:
        CMP.W   #5,D1           * Confronta l'indice i con 5 (dobbiamo analizzare i = 0, 1, 2, 3, 4)
        BEQ     FINE_S          * Se i == 5 abbiamo analizzato metà array: esci dal ciclo
        
        MOVE.W  (A0)+,D0        * Leggi A[i] in D0 e incrementa automaticamente A0 di 2 byte (post-incremento)
        CMP.W   -(A1),D0        * Decrementa A1 di 2 byte (pre-decremento, punta a B[9-i]) e confronta con D0
        BNE     INCREM          * Se i due elementi sono DIVERSI, salta l'incremento del contatore
        
        ADDQ.W  #1,D2           * Se sono UGUALI, incrementa il contatore delle uguaglianze in D2

INCREM:
        ADDQ.W  #1,D1           * Incrementa l'indice del ciclo: i++
        BRA     LOOP            * Torna all'inizio del ciclo LOOP

FINE_S:
        MOVE.W  D2,4(SP)        * Scrive il risultato finale nel vano di ritorno riservato sullo Stack
        RTS                     * Return from Subroutine: torna al programma principale MAIN

        END                     * Fine assoluta del codice sorgente