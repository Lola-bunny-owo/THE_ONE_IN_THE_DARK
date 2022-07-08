package com.mycompany.the_one_in_the_dark;

/**
 *
 * @author Angela Mileti
 */

public class StazioneDiPolizia extends Ambiente {
    /**
     * @param args
     */

    static boolean introduzioneAmbiente= false;

    public static void main(String[] args) {

        setStazioneDiPolizia();

        // Stampa del nome dell'ambiente
        System.out.println("Nome ambiente: " + Ambiente.getNomeAmbiente());

        // Stampa del numero di stanze
        for(int i= 0; i< Ambiente.getNumeroStanze().length; i++){
            System.out.println("Numero dipartimento: " + Ambiente.getNumeroStanze()[i]);
        }

        // Stampa del nome delle stanze
        for (int j= 0; j< Ambiente.getNomiStanze().length; j++){
            System.out.println("Nome dipartimento: " + Ambiente.getNomiStanze()[j]);
        }

        // Stampa delle stanze
        Ambiente.stampaStanze();

        // Stampa numero stanze
        System.out.println("Il numero di dipartimenti presenti in " + Ambiente.getNomeAmbiente() + " è: " + Ambiente.getNumeroStanze().length);
    }

    public static void setStazioneDiPolizia() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Stazione di Polizia");
        Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5, 6 });

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Ufficio n#1", "Ufficio n#2",  "Area denunce", "Stanza interrogatorio", "Celle di custodia"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
        Ambiente.setNomeStanzaCorrente("Di fronte casa");

        if(!introduzioneAmbiente){
            try {
                introduzioneStazionePolizia();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void acquisisciInputStazionePolizia(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                // Va di default all'ingresso
                decrementoStanza();
                decrementoStanza();
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
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 2){
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
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
            Utilita.acquisisciInputComando(inputUtente);
        }
      
    }

    public static boolean introduzioneStazionePolizia() throws InterruptedException{
        System.out.println("> Ti avvicini alla stazione di polizia timoroso. Chissà quante brutte storie ha sentito questo luogo, e chissà quante altre sono state sepolte.");
        Utilita.delay();
        System.out.println("All'ingresso non ci trovi anima viva, il ché è abbastanza strano. Dovrebbe essere pieno di agenti pronti a servirti ed ascoltarti, eppure.. zero.");
        Utilita.delay();
        System.out.println("Vuoi essere così ficcanaso da entrare in un posto del genere, senza aver ricevuto il permesso di nessuno?");
        System.out.println(".. Ovviamente sì.<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaStazioneDiPolizia() {
    }

}
