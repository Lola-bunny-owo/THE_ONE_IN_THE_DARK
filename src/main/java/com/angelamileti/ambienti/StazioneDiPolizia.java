package com.angelamileti.ambienti;

import com.angelamileti.Utilita;

/**
 * Classe che gestisce l'ambiente Stazione di Polizia. Come per ogni altro ambiente, questa classe 
 * contiene un metodo set nel quale s'impostano i valori degli attributi interessati, un metodo per
 * l'acquisizione dell'input inerente all'ambiente, ed altri metodi di vario genere, sempre correlati
 * all'ambiente.
 * @author Angela Mileti
 */

public class StazioneDiPolizia extends Ambiente {
    /**
     * @param args
     */

    public static boolean introduzioneAmbiente;

    public StazioneDiPolizia(){
        introduzioneAmbiente= false;
    }

    // Set dell'ambiente.
    public static void setStazioneDiPolizia() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Stazione di Polizia");
        if(!Ambiente.numeroStanze.isEmpty()){
            Ambiente.numeroStanze.clear();
        }
        Ambiente.numeroStanze.add(1); 
        Ambiente.numeroStanze.add(2);
        Ambiente.numeroStanze.add(3);
        Ambiente.numeroStanze.add(4);
        Ambiente.numeroStanze.add(5);
        Ambiente.numeroStanze.add(6);

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Ufficio n#1", "Ufficio n#2",  "Area denunce", "Stanza interrogatorio", "Celle di custodia"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze.first());
        Ambiente.setNomeStanzaCorrente("Di fronte casa");

        if(!introduzioneAmbiente){
            try {
                Utilita.introduzioneStazionePolizia();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo per l'acquisizione dell'input inerente all'ambiente.
    public static void acquisisciInputStazionePolizia(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                // Va di default all'ingresso
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){ 
            System.out.println("Non c'?? un secondo piano!");
        }else if((inputUtente.equalsIgnoreCase("vai gi??"))||(inputUtente.equalsIgnoreCase("gi??"))){
            System.out.println("Sei gi?? al piano terra!");
        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 2){
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    incrementoStanza();
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
            }else if(getNumeroStanzaCorrente() == 6){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
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
            System.out.println("Comando non riconosciuto.");
        }
    }

    public static void guardaStanzaStazioneDiPolizia() {
        // TO-DO: da implementare pi?? avanti :)
        System.out.println("Per ora, non puoi.");
    }


}
