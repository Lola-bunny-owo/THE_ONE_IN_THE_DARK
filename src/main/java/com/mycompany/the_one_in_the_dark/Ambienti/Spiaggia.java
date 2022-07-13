package com.mycompany.the_one_in_the_dark.Ambienti;

import com.mycompany.the_one_in_the_dark.Utilita;

/**
 * Classe che gestisce l'ambiente Spiaggia. Come per ogni altro ambiente, questa classe contiene un
 * metodo set nel quale s'impostano i valori degli attributi interessati, un metodo per l'acquisizione
 * dell'input inerente all'ambiente, ed altri metodi di vario genere, sempre correlati all'ambiente.
 * @author Angela Mileti
 */

public class Spiaggia extends Ambiente {
    /**
     * @param args
     */

    public Spiaggia(){
        super();
    }

    static boolean introduzioneAmbiente= false;

    // Set dell'ambiente.
    public static void setSpiaggia() {
    
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Spiaggia");
        if(!Ambiente.numeroStanze.isEmpty()){
            Ambiente.numeroStanze.clear();
        }
        Ambiente.numeroStanze.add(1); 
        Ambiente.numeroStanze.add(2);
        Ambiente.numeroStanze.add(3);
        Ambiente.numeroStanze.add(4);
        Ambiente.numeroStanze.add(5);

        Ambiente.setNomiStanze(new String[] { "Di fronte casa", "Per la foresta", "Per il diner",  "Per la stazione di polizia", "Per la biblioteca"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze.first());
        Ambiente.setNomeStanzaCorrente("Di fronte casa");

        if(!introduzioneAmbiente){
            try {
                introduzioneSpiaggia();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo per l'acquisizione dell'input inerente all'ambiente.
    public static void acquisisciInputSpiaggia(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("destra"))||(inputUtente.equalsIgnoreCase("destra"))){

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
            System.out.println("Comando non riconosciuto.");
        }
    }

    // Metodo di stampa per l'introduzione dell'ambiente.
    public static boolean introduzioneSpiaggia() throws InterruptedException{
        System.out.println("> Fa caldo.. Il tuo corpo sta iniziando a piangere.");
        System.out.println("Senti il rumore delle onde. Un vento violento ed improvviso ti sferza il viso.");
        System.out.println("Il meteo è sempre inaffidabile..");
        Utilita.delay(3000);
        System.out.println("Noti che dalla spiaggia puoi spostarti ovunque.");
        System.out.println("Ti senti Dio.");
        Utilita.delay(2000);
        System.out.println("Fai due passi..<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaSpiaggia() {
        // TO-DO: da implementare più avanti :)
        System.out.println("Ti piacerebbe.");
    }

}
