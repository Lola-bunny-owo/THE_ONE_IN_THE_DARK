package com.angelamileti.ambienti;

import com.angelamileti.Utilita;

/**
 * Classe che gestisce l'ambiente Foresta. Come per ogni altro ambiente, questa classe contiene un
 * metodo set nel quale s'impostano i valori degli attributi interessati, un metodo per l'acquisizione
 * dell'input inerente all'ambiente, ed altri metodi di vario genere, sempre correlati all'ambiente.
 * @author Angela Mileti
 */

public class Foresta extends Ambiente {
    /**
     * @param args
     */

    public static boolean introduzioneAmbiente;

    public Foresta(){
        introduzioneAmbiente= false;
    }

    // Set dell'ambiente.
    public static void setForesta() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Foresta");
        if(!Ambiente.numeroStanze.isEmpty()){
            Ambiente.numeroStanze.clear();
        }
        Ambiente.numeroStanze.add(1); 
        Ambiente.numeroStanze.add(2);
        Ambiente.numeroStanze.add(3);
        Ambiente.numeroStanze.add(4);
        Ambiente.numeroStanze.add(5);

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Zona spinosa", "Per il diner",  "Per la spiaggia", "Sentiero sconosciuto"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze.first());
        Ambiente.setNomeStanzaCorrente("Ingresso");

        if(!introduzioneAmbiente){
            try {
                Utilita.introduzioneForesta();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   

    // Metodo per l'acquisizione dell'input inerente all'ambiente.
    public static void acquisisciInputForesta(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){ 
            System.out.println("Sei in una foresta.. ma davvero chiedi di andare sopra? Vuoi andare in cielo?");
        }else if((inputUtente.equalsIgnoreCase("vai giù"))||(inputUtente.equalsIgnoreCase("giù"))){
            System.out.println("Sei in una foresta.. ma davvero chiedi di andare giù? Aspetta un altro po', che forse ti accontento..");
        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                }else if(getNumeroStanzaCorrente() == 4){
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
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

        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){
            System.out.println("Non puoi andare alla stazione di Polizia da qui.");
        }else if((inputUtente.equalsIgnoreCase("vai al Diner"))||(inputUtente.equalsIgnoreCase("Diner"))){
            
            if(getNumeroStanzaCorrente() == 3){
                Utilita.stampaEntrataDiner();
                Diner.setDiner();
            }else {
                System.out.println("Non puoi andare al Diner da qui.");
            }
            
        }else if((inputUtente.equalsIgnoreCase("vai a casa"))||(inputUtente.equalsIgnoreCase("Casa"))){
                    
            if(getNumeroStanzaCorrente() == 5){
                Utilita.stampaEntrataCasa();
                Casa.setCasa();
            }else {
                System.out.println("Non puoi andare a casa da qui.");
            }
                
            
        }else if((inputUtente.equalsIgnoreCase("vai in Biblioteca"))||(inputUtente.equalsIgnoreCase("Biblioteca"))){
            System.out.println("Non puoi andare in Biblioteca da qui.");
        }else{
            System.out.println("Comando non riconosciuto.");
        }
    
    }

    public static void guardaStanzaForesta() {
        // TO-DO: da implementare più avanti :)
        System.out.println("Nope. Non puoi ancora.");
    }
}
