package com.mycompany.the_one_in_the_dark.Ambienti;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe che imposta l'ambiente in cui il giocatore si trova. Essa definisce attributi e metodi
 * che sono ereditati dalle sue sottoclassi. Sono definiti metodi set e get, alcuni metodi di stampa
 * relativi all'ambiente, dei controlli ed un metodo di acquisizione dell'input di tipo intero.
 * @author Angela Mileti
 */

public class Ambiente {

    /*  Attributi condivisi da ogni sottoclasse */

    public static String nomeAmbiente= "";
    protected static SortedSet<Integer> numeroStanze= new TreeSet<>();
    protected static String[] nomiStanze;
    public static int numeroStanzaCorrente;
    protected static String nomeStanzaCorrente= "";

    // Genera il costruttore della classe e inizializza le variabili statiche.
    public Ambiente(){
        nomeAmbiente= "";
        numeroStanze= new TreeSet<>();
        nomiStanze= new String[0];
        numeroStanzaCorrente= 0;
        nomeStanzaCorrente= "";
    }

    /* METODI SET */

    public static void setNomeAmbiente(String nomeAmbiente){
        Ambiente.nomeAmbiente= nomeAmbiente;
    }

    public static void setNumeroStanze(SortedSet<Integer> numeroStanze){
        Ambiente.numeroStanze= numeroStanze;
    }

    public static void setNomiStanze(String[] nomiStanze){ 
        Ambiente.nomiStanze= nomiStanze;
    }

    public static void setNumeroStanzaCorrente(int numeroStanzaCorrente){
        Ambiente.numeroStanzaCorrente= numeroStanzaCorrente;
    }

    public static void setNomeStanzaCorrente(String nomeStanzaCorrente){
        Ambiente.nomeStanzaCorrente= nomeStanzaCorrente;
    }

    /* METODI GET */

    public static String getNomeAmbiente(){
        return nomeAmbiente;
    }

    public static SortedSet<Integer> getNumeroStanze(){
        return numeroStanze;
    }
    
    public static String[] getNomiStanze(){
        return nomiStanze;
    }

    public static int getNumeroStanzaCorrente(){
        return numeroStanzaCorrente;
    }

    public static String getNomeStanzaCorrente(){
        return nomeStanzaCorrente;
    }

    /* METODI DI STAMPA */

    public static void stampaStanzaCorrente() {
        System.out.println("Sei in: [" + Ambiente.getNumeroStanzaCorrente() + "] - " + Ambiente.getNomeStanzaCorrente());
    }

    // Stampa le stanze dell'ambiente corrente
    public static void stampaStanze(){
        if(nomeAmbiente.equals("Casa")){
            System.out.println("Queste sono le stanze presenti in " + nomeAmbiente + ":");

            for(Integer numero: numeroStanze){
                if(numero == 10){
                    System.out.println("[???] - ???");
                }else{
                    System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
                }
            }

        }else if(nomeAmbiente.equals("Spiaggia")){
            System.out.println("Queste sono le aree presenti in " + nomeAmbiente + ":");

            for(Integer numero: numeroStanze){
                System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
            }

        }else if(nomeAmbiente.equals("Stazione di Polizia")){
            System.out.println("Questi sono i dipartimenti presenti in " + nomeAmbiente + ":");

            for(Integer numero: numeroStanze){
                System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
            }

        }else if(nomeAmbiente.equals("Biblioteca")){
            System.out.println("Queste sono le aule presenti in " + nomeAmbiente + ":");
            for(Integer numero: numeroStanze){
                System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
            }

        }else if(nomeAmbiente.equals("Diner")){
            System.out.println("Queste sono le sale presenti in " + nomeAmbiente + ":");
            for(Integer numero: numeroStanze){
                System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
            }
        }else if(nomeAmbiente.equals("Foresta")){
            System.out.println("Queste sono le zone presenti in " + nomeAmbiente + ":");
            for(Integer numero: numeroStanze){
                System.out.println("[" + numero + "] - " + nomiStanze[numero-1]);
            }
        }

    }

    /** Funzione che controlla se la stanza nella quale si vuole andare è diversa da quella corrente.
     * @param numeroStanzaUtente : è l'input da tastiera dell'utente, trasformato in intero
     * @return false se l'utente è già nella stanza nella quale vuole spostarsi, altrimenti true.
     */
    public static boolean controlloNumeroStanza(int numeroStanzaUtente){

        if(numeroStanzaUtente == numeroStanzaCorrente){
            System.out.println("Sei già nella stanza "+ numeroStanzaUtente + ".");
            return false;
        }else{
            return true;
        }

    }

    // Metodo che acquisisce l'input dell'utente e lo trasforma in intero,
    // in modo da poter eseguire i controlli del caso e farlo spostare nella stanza da lui desiderata.
    public static void acquisisciInputConNumero(String inputUtente){
        String nuovoInput = inputUtente.substring(inputUtente.lastIndexOf(" ") + 1);
        int numeroStanzaUtente= 0;
        int controlloNumeroStanze= getNumeroStanze().size();

        // Trasforma l'input utente nell'intero equivalente
        numeroStanzaUtente= Integer.parseInt(nuovoInput);

        if((numeroStanzaUtente > 0)&&(numeroStanzaUtente < 10)&&(controlloNumeroStanze >= numeroStanzaUtente)){

            if(controlloNumeroStanza(numeroStanzaUtente)){

                // Se l'ambiente in cui si trova il giocatore è la casa,
                // esegue il metodo di controllo sulla stanza.
                if(nomeAmbiente.equals("Casa")){
                    Casa.controllaStanza();
                }

                numeroStanzaCorrente= numeroStanzaUtente;
                nomeStanzaCorrente= nomiStanze[numeroStanzaUtente-1];
                System.out.println("Ti sei spostato in: [" + numeroStanzaCorrente + "] - " + nomiStanze[numeroStanzaUtente-1]);
            }

        }else {
            System.out.println("Non c'è alcuna stanza con questo numero!");
        }
    }

    // Incrementi e decrementi della stanza corrente

    public static void incrementoStanza(){
        setNumeroStanzaCorrente(numeroStanzaCorrente+1);
        setNomeStanzaCorrente(nomiStanze[numeroStanzaCorrente-1]);
    }

    public static void decrementoStanza(){
        setNumeroStanzaCorrente(numeroStanzaCorrente-1);
        setNomeStanzaCorrente(nomiStanze[numeroStanzaCorrente-1]);
    }

}
