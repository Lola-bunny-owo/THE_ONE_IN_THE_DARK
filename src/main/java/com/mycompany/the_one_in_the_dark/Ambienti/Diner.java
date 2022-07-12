package com.mycompany.the_one_in_the_dark.Ambienti;

import com.mycompany.the_one_in_the_dark.Utilita;

/**
 * Classe che gestisce l'ambiente Diner. Come per ogni altro ambiente, questa classe contiene un
 * metodo set nel quale s'impostano i valori degli attributi interessati, un metodo per l'acquisizione
 * dell'input inerente all'ambiente, ed altri metodi di vario genere, sempre correlati all'ambiente.
 * @author Angela Mileti
 */

public class Diner extends Ambiente {
    /**
     * @param args
     */

    public Diner(){
        super();
    }

    static boolean introduzioneAmbiente= false;

    // Set dell'ambiente.
    public static void setDiner() {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Diner");
        if(!Ambiente.numeroStanze.isEmpty()){
            Ambiente.numeroStanze.clear();
        }
        Ambiente.numeroStanze.add(1); 
        Ambiente.numeroStanze.add(2);
        Ambiente.numeroStanze.add(3);
        Ambiente.numeroStanze.add(4);
        Ambiente.numeroStanze.add(5);
        Ambiente.numeroStanze.add(6);

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Bancone", "Tabella della città",  "Tavolini", "Magazzino", "Bagno"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze.first());
        Ambiente.setNomeStanzaCorrente("Ingresso");

        if(!introduzioneAmbiente){
            try {
                introduzioneDiner();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Metodo per l'acquisizione dell'input inerente all'ambiente.
    public static void acquisisciInputDiner(String inputUtente) throws InterruptedException{
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                incrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
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
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
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
            }else if(getNumeroStanzaCorrente() == 5){
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

        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){
            System.out.println("Non puoi andare alla stazione di Polizia da qui.");
        }else if((inputUtente.equalsIgnoreCase("vai nella Foresta"))||(inputUtente.equalsIgnoreCase("Foresta"))){

            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataForesta();
                Foresta.setForesta();
            }else{
                System.out.println("Non puoi andare nella Foresta da qui.");
            }
            
        }else if((inputUtente.equalsIgnoreCase("vai in Biblioteca"))||(inputUtente.equalsIgnoreCase("Biblioteca"))){ 
            System.out.println("Non puoi andare in Biblioteca da qui.");
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

    // Metodo di stampa per l'introduzione dell'ambiente.
    public static boolean introduzioneDiner() throws InterruptedException{
        System.out.println("> Entri nel diner 'Lola's Diner', e vieni subito pervaso da un odore di frittura misto dolcezza.");
        System.out.println("Il tuo sguardo viene subito catturato dall'incantevole cameriera al bancone. La sua uniforme rivela il suo nome: 'Fanny'.");
        System.out.println("Il nome del diner però è diverso..");
        Utilita.delay();
        System.out.println("Fanny è circondata da clienti, affascinati dal suo sorriso e dal suo profumo inebriante.");
        System.out.println("Allora ti chiedi: ordino da mangiare? Ordino da bere?");
        Utilita.delay();
        System.out.println("Vorresti prima ispezionare il posto, ma se non mangi tua nonna ti vede sciupato..");
        System.out.println("Sei combattuto..<");
        System.out.println("");
        return introduzioneAmbiente= true;
    }

    public static void guardaStanzaDiner() {
        // TO-DO: da implementare più avanti :)
        System.out.println("Nope. Non puoi ancora.");
    }

}
