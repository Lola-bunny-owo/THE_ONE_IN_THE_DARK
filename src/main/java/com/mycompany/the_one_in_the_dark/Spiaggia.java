package com.mycompany.the_one_in_the_dark;

/**
 *
 * @author Angela Mileti
 */

public class Spiaggia extends Ambiente {
    /**
     * @param args
     */

    static boolean introduzioneAmbiente= false;

    public static void main(String[] args) {

        setSpiaggia();
        // Stampa del nome dell'ambiente
        System.out.println("Nome ambiente: " + Ambiente.getNomeAmbiente());

        // Stampa del numero di stanze
        for(int i= 0; i< Ambiente.getNumeroStanze().length; i++){
            System.out.println("Numero area: " + Ambiente.getNumeroStanze()[i]);
        }

        // Stampa del nome delle stanze
        for (int j= 0; j< Ambiente.getNomiStanze().length; j++){
            System.out.println("Nome area: " + Ambiente.getNomiStanze()[j]);
        }

        // Stampa delle stanze
        Ambiente.stampaStanze();

        // Stampa numero stanze
        System.out.println("Il numero di aree presenti in " + Ambiente.getNomeAmbiente() + " è: " + Ambiente.getNumeroStanze().length);
}

    public static void setSpiaggia() {
    
    // Set del nome dell'ambiente e del numero delle stanze.
    Ambiente.setNomeAmbiente("Spiaggia");
    Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5 });

    Ambiente.setNomiStanze(new String[] { "Di fronte casa", "Per la foresta", "Per il diner",  "Per la stazione di polizia", "Per la biblioteca"});
    Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
    Ambiente.setNomeStanzaCorrente("Di fronte casa");

    if(!introduzioneAmbiente){
        try {
            introduzioneSpiaggia();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

    public static void acquisisciInputSpiaggia(String inputUtente){
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
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){ 
            System.out.println("Nope.");
        }else if((inputUtente.equalsIgnoreCase("vai giù"))||(inputUtente.equalsIgnoreCase("giù"))){
            System.out.println("Fai schifo.");
        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    // Va di default alla sentiero per la stazione di polizia
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
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare indietro.");
            }


        }else if((inputUtente.equalsIgnoreCase("vai in Biblioteca"))||(inputUtente.equalsIgnoreCase("Biblioteca"))){

            if(getNumeroStanzaCorrente() == 5){
                Utilita.stampaEntrataBiblioteca();
                Biblioteca.setBiblioteca();
            }else{
                System.out.println("Non puoi andare in Biblioteca da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai nella Foresta"))||(inputUtente.equalsIgnoreCase("Foresta"))){
            
            if(getNumeroStanzaCorrente() == 2){
                Utilita.stampaEntrataForesta();
                Foresta.setForesta();   
            }else{
                System.out.println("Non puoi andare in Foresta da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){

            if(getNumeroStanzaCorrente() == 4){
                Utilita.stampaEntrataStazioneDiPolizia();
                StazioneDiPolizia.setStazioneDiPolizia();
            }else{
                System.out.println("Non puoi andare alla stazione di Polizia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai al Diner"))||(inputUtente.equalsIgnoreCase("Diner"))){
            
            if(getNumeroStanzaCorrente() == 3){
                Utilita.stampaEntrataDiner();
                Diner.setDiner();   
            }else{
                System.out.println("Non puoi andare al Diner da qui.");
            }
        
        }else if((inputUtente.equalsIgnoreCase("vai a casa"))||(inputUtente.equalsIgnoreCase("casa"))){
            
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

    public static boolean introduzioneSpiaggia() throws InterruptedException{
        System.out.println("> Fa caldo.. Il tuo corpo sta iniziando a piangere.");
        System.out.println("Senti il rumore delle onde. Un vento violento ed improvviso ti sferza il viso.");
        System.out.println("Il meteo è sempre inaffidabile..");
        Utilita.delay();
        System.out.println("Noti che dalla spiaggia puoi spostarti ovunque.");
        System.out.println("Ti senti Dio.");
        Utilita.delay();
        System.out.println("Fai due passi..<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaSpiaggia() {
    } 

}
