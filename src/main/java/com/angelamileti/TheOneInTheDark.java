package com.angelamileti;

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
