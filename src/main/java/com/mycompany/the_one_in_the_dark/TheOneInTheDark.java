package com.mycompany.the_one_in_the_dark;

import java.io.Serializable;

/**
 *
 * @author Angela Mileti
 */

public class TheOneInTheDark implements Serializable{
    
    public static void main(String[] args) throws InterruptedException {
        Utilita.intro();
        GestioneIO IO= new GestioneIO();
        IO.gestisciInputUtente();
    }

}
