package com.mycompany.the_one_in_the_dark;

/**
 * Classe main dalla quale inizia l'esecuzione del gioco. 
 * @author Angela Mileti
 */

public class TheOneInTheDark{
    
    public static void main(String[] args) throws InterruptedException {
        Utilita.intro();
        GestioneIO IO= new GestioneIO();
        IO.gestisciInputUtente();
    }
}
