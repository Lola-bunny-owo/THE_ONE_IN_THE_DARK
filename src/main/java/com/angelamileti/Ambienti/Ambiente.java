package com.angelamileti.Ambienti;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Classe che imposta l'ambiente in cui il giocatore si trova. Sono definiti metodi set e get
 * e metodi di incrementi/decrementi stanza.
 * @author Angela Mileti
 */

public class Ambiente {

    /*  Attributi che permettono di impostare l'ambiente */

    public static String nomeAmbiente= "";
    public static SortedSet<Integer> numeroStanze= new TreeSet<>();
    public static String[] nomiStanze;
    public static int numeroStanzaCorrente;
    public static String nomeStanzaCorrente= "";

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
