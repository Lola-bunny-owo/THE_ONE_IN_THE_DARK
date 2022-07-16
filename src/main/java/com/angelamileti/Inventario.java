package com.angelamileti;

/**
 * Classe che si occupa dell'inventario dell'utente.
 * @author Angela Mileti
 */

public class Inventario extends Oggetti{
    protected static int numeroOggettiInventario;

    Inventario(){
        super();
        numeroOggettiInventario= 0;
    }

    /* METODI GET */

    public static int getNumOggettiInInventario() {

        if(numeroOggettiInventario == MAX_OGGETTI){
            System.out.println("Il numero di oggetti nell'inventario è [" + numeroOggettiInventario + "] - Hai raggiunto il numero massimo di oggetti che puoi inserire nell'inventario.");
            return MAX_OGGETTI;
        }else if(numeroOggettiInventario == 0){
            System.out.println("Nel tuo inventario non c'è nulla!");
            return numeroOggettiInventario;
        }else {
            System.out.println("Il numero di oggetti nell'inventario è [" + numeroOggettiInventario + "] - Puoi ancora inserire oggetti.");
            return numeroOggettiInventario;
        }

    }

}
