package com.mycompany.the_one_in_the_dark;

/**
 *
 * @author Angela Mileti
 */

public class Casa extends Ambiente {
    /**
     * @param args
     */

    static boolean setOggettiCasa= false;
    
    public static void main(String[] args) {
        setCasa();
        // Stampa del nome dell'ambiente
        System.out.println("Nome ambiente: " + Ambiente.getNomeAmbiente());

        // Stampa del numero di stanze
        for(int i= 0; i< Ambiente.getNumeroStanze().length; i++){
            System.out.println("Numero stanza: " + Ambiente.getNumeroStanze()[i]);
        }

        // Stampa del nome delle stanze
        for (int j= 0; j< Ambiente.getNomiStanze().length; j++){
            System.out.println("Nome stanza: " + Ambiente.getNomiStanze()[j]);
        }

        // Stampa delle stanze
        Ambiente.stampaStanze();

        // Stampa numero stanze
        System.out.println("Il numero di stanze presenti in " + Ambiente.getNomeAmbiente() + " è: " + Ambiente.getNumeroStanze().length);
    }

    public static void setCasa() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Casa");
        Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        // Set dei nomi delle stanze
        Ambiente.setNomiStanze(new String[] { "Ingresso", "Salone", "Cucina",  "Veranda", "Corridoio largo", "Corridoio stretto", "Camera da letto di Spike", "Camera da letto del custode", "Bagno", "Stanza segreta"});

        // Set numero della stanza corrente e del nome della stanza corrente
        Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
        Ambiente.setNomeStanzaCorrente("Ingresso");

        // Set degli oggetti presenti nella casa
        // INGRESSO
        if(!setOggettiCasa){
            Oggetti.setNomeOggetto(new String[] { "Libro", "Carota", "Penna", "Gomma" });
            Oggetti.setDescrizione(new String[] { "Un vecchio libro di storia", "Cibo commestibile", "Una penna a stilo", "Gomma per cancellare" });
            Oggetti.setNumeroOggetti(new int[] { 1, 2, 3, 4 });
            setOggettiCasa= true;
        }

    }

    public static void acquisisciInputCasa(String inputUtente){
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 7){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 8){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 10){
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                // Va di defalut nella propria stanza.
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                incrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){

            if(getNumeroStanzaCorrente() == 1){
                System.out.println("Non puoi andare sopra dall'ingresso.");
            }else if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                System.out.println("Non puoi andare sopra dalla cucina.");
            }else if(getNumeroStanzaCorrente() == 4){
                System.out.println("Non puoi andare sopra dalla veranda.");
            }else{
                System.out.println("Sei già sopra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai giù"))||(inputUtente.equalsIgnoreCase("giù"))){
                
            if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
            }else if(getNumeroStanzaCorrente() == 6){
                System.out.println("Non puoi andare giù dal corridoio stretto.");
            }else if(getNumeroStanzaCorrente() == 7){
                System.out.println("Non puoi andare giù dalla tua stanza.");
            }else if(getNumeroStanzaCorrente() == 8){
                System.out.println("Non puoi andare giù dalla stanza del custode.");
            }else if(getNumeroStanzaCorrente() == 9){
                System.out.println("Non puoi andare giù dal bagno.");
            }else if(getNumeroStanzaCorrente() == 10){
                System.out.println("Non puoi andare giù dalla stanza segreta.");
            }else{
                System.out.println("Sei già sotto.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 6){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare indietro.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai in Spiaggia"))||(inputUtente.equalsIgnoreCase("Spiaggia"))){

            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataSpiaggia();
                Spiaggia.setSpiaggia();
            }else if(getNumeroStanzaCorrente() == 4){
                Utilita.stampaEntrataSpiaggia();
                Spiaggia.setSpiaggia();
            }else{
                System.out.println("Non puoi andare in Spiaggia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai in Biblioteca"))||(inputUtente.equalsIgnoreCase("Biblioteca"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataBiblioteca();
                Biblioteca.setBiblioteca();
            }else{
                System.out.println("Non puoi andare in Biblioteca da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai nella Foresta"))||(inputUtente.equalsIgnoreCase("Foresta"))){
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataForesta();
                Foresta.setForesta();
            }else{
                System.out.println("Non puoi andare nella Foresta da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataStazioneDiPolizia();
                StazioneDiPolizia.setStazioneDiPolizia();
            }else{
                System.out.println("Non puoi andare alla stazione di Polizia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai al Diner"))||(inputUtente.equalsIgnoreCase("Diner"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataDiner();
                Diner.setDiner();
            }else{
                System.out.println("Non puoi andare al Diner da qui.");
            }

        }else{
            Utilita.acquisisciInputComando(inputUtente);
        }
    }

}