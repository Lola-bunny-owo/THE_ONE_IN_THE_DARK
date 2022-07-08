package com.mycompany.the_one_in_the_dark;

/**
 *
 * @author Angela Mileti
 */

public class Foresta extends Ambiente {
    /**
     * @param args
     */

    static boolean introduzioneAmbiente= false;

    public static void main(String[] args) {

        setForesta();
        // Stampa del nome dell'ambiente
        System.out.println("Nome ambiente: " + Ambiente.getNomeAmbiente());

        // Stampa del numero di stanze
        for(int i= 0; i< Ambiente.getNumeroStanze().length; i++){
            System.out.println("Numero zona: " + Ambiente.getNumeroStanze()[i]);
        }

        // Stampa del nome delle stanze
        for (int j= 0; j< Ambiente.getNomiStanze().length; j++){
            System.out.println("Nome zona: " + Ambiente.getNomiStanze()[j]);
        }

        // Stampa delle stanze
        Ambiente.stampaStanze();

        // Stampa numero stanze
        System.out.println("Il numero di zone presenti in " + Ambiente.getNomeAmbiente() + " è: " + Ambiente.getNumeroStanze().length);
    }

    public static void setForesta() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Foresta");
        Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5 });

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Zona spinosa", "Per il diner",  "Per la spiaggia", "Sentiero sconosciuto"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
        Ambiente.setNomeStanzaCorrente("Ingresso");

        if(!introduzioneAmbiente){
            try {
                introduzioneForesta();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void acquisisciInputForesta(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                stampaStanzaCorrente();
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
            }else if(getNumeroStanzaCorrente() == 4){
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
            Utilita.acquisisciInputComando(inputUtente);
        }
    
    }

    public static boolean introduzioneForesta() throws InterruptedException{
        System.out.println("> Sei un pazzo, sei un pazzo, sei un pazzo. Continui a ripetertelo ma comunque prosegui.");
        System.out.println("Questa ti sembra l'occasione giusta per mangiare, perché potrebbe anche essere il tuo ultimo pasto.");
        Utilita.delay();
        System.out.println("Armato di coraggio, arrivi a quella che ti sembra l'entrata di Bosco Atro.");
        Utilita.delay();
        System.out.println("Ti guardi attorno, e vedi solo spine. Non ci sono altre strade, devi per forza attraversarle se vuoi proseguire..");
        System.out.println("Boh, almeno sarai ricordato come un eroe.. Certo, da tua madre.<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaForesta() {
    } 

}
