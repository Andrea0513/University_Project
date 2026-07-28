*-------------------------------------------------------------------------
* CONSEGNA ESERCIZIO - PUNTO 2:
* Assegnati due vettori A e B di 10 word ciascuno sviluppare un programma
* per il processore Motorola 68000 che:
* 2) Crei un vettore C di 10 word tale che C[i]=A[i]+B[9-i] per i=0,...,9
*-------------------------------------------------------------------------

        ORG     $8000           * Direttiva: posiziona l'area Dati all'indirizzo $8000
A       DC.W    1,5,3,8,2,0,4,7,9,10    * Vettore A di 10 word (16 bit)
B       DC.W    10,9,7,4,0,2,8,3,5,1    * Vettore B di 10 word
C       DS.W    10                      * Spazio di 10 word riservato in RAM per il vettore C
DIM     DC.W    10                      * Dimensione dei vettori (10 elementi)

*-------------------------------------------------------------------------
* PROGRAMMA PRINCIPALE (MAIN)
*-------------------------------------------------------------------------
        ORG     $8100           * Direttiva: posiziona l'area Codice all'indirizzo $8100
MAIN:
        * --- FASE 1: PASSAGGIO DEI PARAMETRI SULLO STACK ---
        MOVE.L  #A,-(SP)        * Push dell'indirizzo di base di A (32 bit -> SP scende di 4)
        MOVE.L  #B,-(SP)        * Push dell'indirizzo di base di B (32 bit -> SP scende di 4)
        MOVE.L  #C,-(SP)        * Push dell'indirizzo di base di C (32 bit -> SP scende di 4)
        MOVE.W  DIM,-(SP)       * Push della dimensione del vettore (16 bit -> SP scende di 2)
        
        * --- FASE 2: CHIAMATA ALLA SUBROUTINE ---
        JSR     RIEMP           * Salta alla subroutine RIEMP (push indirizzo di ritorno: 4 byte)
        
        * --- FASE 3: PULIZIA DELLO STACK ---
        ADDA.L  #14,SP          * Ripristina lo Stack Pointer rimuovendo i parametri (4+4+4+2 = 14 byte)

FINE:   
        JMP     FINE            * Loop infinito per terminare l'esecuzione in sicurezza

*-------------------------------------------------------------------------
* SUBROUTINE: RIEMP
* Calcola C[i] = A[i] + B[9-i] per i = 0, 1, ..., 9
*-------------------------------------------------------------------------
        ORG     $8200           * Direttiva: posiziona la subroutine all'indirizzo $8200
RIEMP:
        * --- LETTURA DEI PARAMETRI DAL FRAME DELLO STACK ---
        * Nota: all'offset 0(SP) ci sono i 4 byte dell'indirizzo di ritorno di JSR
        * all'offset 4(SP) c'è la word DIM (dimensione vettore)
        * all'offset 6(SP) c'è l'indirizzo a 32 bit del vettore C
        * all'offset 10(SP) c'è l'indirizzo a 32 bit del vettore B
        * all'offset 14(SP) c'è l'indirizzo a 32 bit del vettore A
        
        MOVEA.L 14(SP),A0       * A0 = Indirizzo iniziale di A (punta a A[0])
        MOVEA.L 10(SP),A1       * A1 = Indirizzo iniziale di B (punta a B[0])
        MOVEA.L 6(SP),A2        * A2 = Indirizzo iniziale di C (punta a C[0])
        MOVE.W  4(SP),D0        * D0 = Dimensione del vettore (10)
        
        CLR.W   D1              * D1 = Indice i del ciclo (inizializzato a 0)
        ADDA.L  #20,A1          * Sposta A1 alla FINE di B (10 word = 20 byte totali)

LOOP:
        CMP.W   D0,D1           * Confronta l'indice i con DIM (10)
        BEQ     FUORI_S         * Se i == 10, abbiamo elaborato tutti gli elementi: esci
        
        MOVE.W  (A0)+,D2        * Leggi A[i] in D2 e incrementa automaticamente A0 di 2 byte (post-incremento)
        ADD.W   -(A1),D2        * Decrementa A1 di 2 byte (pre-decremento, punta a B[9-i]) e somma a D2
        MOVE.W  D2,(A2)+        * Scrive il risultato (A[i]+B[9-i]) in C[i] e incrementa A2 di 2 byte

INCREM:
        ADDQ.W  #1,D1           * Incrementa l'indice del ciclo: i++
        BRA     LOOP            * Torna all'inizio del ciclo LOOP

FUORI_S:
        RTS                     * Return from Subroutine: torna al programma principale MAIN

        END                     * Fine assoluta del codice sorgente