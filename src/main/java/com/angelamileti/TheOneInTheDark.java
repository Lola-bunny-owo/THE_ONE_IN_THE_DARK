package com.angelamileti;

/**
 * Classe che definisce due funzioni: una d'inizializzazione ed una di esecuzione. Vengono
 * richiamate all'interno della classe Main.
 * @author Angela Mileti
 */


public class TheOneInTheDark{
    
    private static GestioneIO gestioneIO;

    public static void init() {
        gestioneIO = new GestioneIO();
    }

    public static void run() throws InterruptedException {
        Utilita.intro();
        gestioneIO.gestisciInputUtente();
    }
}
