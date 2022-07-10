package com.mycompany.the_one_in_the_dark.Ambienti;

import com.mycompany.the_one_in_the_dark.Utilita;

/**
 *
 * @author Angela Mileti
 */

public class Biblioteca extends Ambiente {
    /**
     * @param args
     */

    static boolean introduzioneAmbiente= false;

    public static void setBiblioteca() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Biblioteca");
        Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5 });

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Sala lettura n#1", "Sala lettura n#2",  "Info Point", "Bagno"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
        Ambiente.setNomeStanzaCorrente("Ingresso");

        if(!introduzioneAmbiente){
            try {
                introduzioneBiblioteca();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }

    public static void acquisisciInputBiblioteca(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){ 
            System.out.println("Non c'è un secondo piano!");
        }else if((inputUtente.equalsIgnoreCase("vai giù"))||(inputUtente.equalsIgnoreCase("giù"))){
            System.out.println("Sei già al piano terra!");
        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 2){
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 4){
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare indietro.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai in Spiaggia"))||(inputUtente.equalsIgnoreCase("Spiaggia"))){

            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataSpiaggia();
                Spiaggia.setSpiaggia();
            }else{
                System.out.println("Non puoi andare in Spiaggia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai nella Foresta"))||(inputUtente.equalsIgnoreCase("Foresta"))){
            System.out.println("Non puoi andare nella Foresta da qui.");
        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){
            System.out.println("Non puoi andare alla stazione di Polizia da qui.");
        }else if((inputUtente.equalsIgnoreCase("vai al Diner"))||(inputUtente.equalsIgnoreCase("Diner"))){
            System.out.println("Non puoi andare al Diner da qui.");
        }else if((inputUtente.equalsIgnoreCase("vai a casa"))||(inputUtente.equalsIgnoreCase("Casa"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataCasa();
                Casa.setCasa();
            }else{
                System.out.println("Non puoi andare a casa da qui.");
            }

        }else{
            Utilita.acquisisciInputComando(inputUtente);
        }

    }

    public static boolean introduzioneBiblioteca() throws InterruptedException{
        System.out.println("> La biblioteca: un posto amato da grandi e piccini. Il silenzio è una delle sue caratteristiche.");
        Utilita.delay();
        System.out.println("L'aspetto è serio e cupo, e anche le persone al suo interno sono abbastanza inquietanti. Sembrano tutte così spente..");
        Utilita.delay();
        System.out.println("Nonostante la paura, scegli di dare un'occhiata in giro. Magari può aiutarti a scoprire qualcosa..<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaBiblioteca() {
        // TO-DO: da implementare più avanti :)
        System.out.println("Non si può ancora!");
    }

}
