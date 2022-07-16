package com.angelamileti;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.angelamileti.Ambienti.*;
import com.angelamileti.Db.Database;
import com.angelamileti.Mappe.*;

/**
 * Classe che gestisce l'input e l'output dell'utente. 
 * @author Angela Mileti
 */

public class GestioneIO {

    public Scanner gestoreInput = new Scanner(new InputStreamReader(System.in));
    public String inputUtente;

    public GestioneIO(){
        inputUtente = "";
    }

    /* Metodo che acquisisce i comandi dell'utente. Questi comandi possono essere eseguiti
     * in qualsiasi ambiente l'utente si trovi. 
     */
    public void gestisciInputUtente() throws InterruptedException {

        System.out.println("Aspettando un tuo comando..");
        System.out.println("");
        while (gestoreInput.hasNext()) {

            inputUtente = gestoreInput.nextLine();
            
            if(inputUtente.equalsIgnoreCase("/help")){

                try {
                    Utilita.stampaHelp();
                } catch (IOException e) {
                    System.out.println("Errore nella stampa della help.");
                }
                
            }else if(inputUtente.equalsIgnoreCase("/stanza")){
                Utilita.stampaStanzaCorrente();
        
            }else if(inputUtente.equalsIgnoreCase("/trama")){
        
                try {
                    Utilita.stampaTrama();
                } catch (IOException e) {
                    System.out.println("Errore nella stampa della trama.");
                }
            
            }else if((inputUtente.equalsIgnoreCase("/apri inventario"))||(inputUtente.equalsIgnoreCase("/inventario"))){
                Utilita.stampaInventario();
        
            }else if(inputUtente.startsWith("/usa ")){

                try {
                    Oggetti.usaOggetto(inputUtente);
                } catch (SQLException e) {
                    System.out.println("Errore nell'uso dell'oggetto.");
                }
                
            }else if(inputUtente.startsWith("/apri ")){

                try {
                    Oggetti.apriOggetto(inputUtente);
                } catch (SQLException e) {
                    System.out.println("Errore nell'apertura dell'oggetto.");
                }
            
            }else if(inputUtente.equalsIgnoreCase("/guarda stanza")){
        
                if(Ambiente.nomeAmbiente.equals("Casa")){
                    Casa.guardaStanzaCasa();
                }else if(Ambiente.nomeAmbiente.equals("Biblioteca")){
                    Biblioteca.guardaStanzaBiblioteca();
                }else if(Ambiente.nomeAmbiente.equals("Foresta")){
                    Foresta.guardaStanzaForesta();
                }else if(Ambiente.nomeAmbiente.equals("Diner")){
                    Diner.guardaStanzaDiner();
                }else if(Ambiente.nomeAmbiente.equals("Stazione di Polizia")){
                    StazioneDiPolizia.guardaStanzaStazioneDiPolizia();
                }else if(Ambiente.nomeAmbiente.equals("Spiaggia")){
                    Spiaggia.guardaStanzaSpiaggia();
                }
        
            }else if (inputUtente.startsWith("/guarda ")){
                try {
                    Oggetti.guardaOggetto(inputUtente);
                } catch (SQLException e) {
                    System.out.println("Errore nell'osservazione dell'oggetto.");
                }
        
            }else if(inputUtente.startsWith("/raccogli ")){

                try {
                    Oggetti.raccogliOggetto(inputUtente, gestoreInput);
                } catch (SQLException e) {
                    System.out.println("Errore nella raccolta dell'oggetto.");
                }
        
            }else if(inputUtente.startsWith("/scarta ")){

                try {
                    Oggetti.scartaOggetto(inputUtente);
                } catch (SQLException e) {
                    System.out.println("Errore nello scarto dell'oggetto.");
                }
        
            }else if(inputUtente.startsWith("/parla con ")){
                NPCs.parla(inputUtente);
            
            }else if(inputUtente.startsWith("vai in stanza ")){
                acquisisciInputConNumero(inputUtente);

            }else if(inputUtente.equalsIgnoreCase("/oggetti")){
                Utilita.stampaOggetti();
        
            }else if(inputUtente.equalsIgnoreCase("/lista stanze")){
                Utilita.stampaStanze();
        
            }else if(inputUtente.equalsIgnoreCase("/mappa")){
                    
                if((Ambiente.nomeAmbiente.equals("Casa"))&&(Ambiente.numeroStanzaCorrente <= 4)){
                    MappaCasaPrimoPiano.stampaFrame();
                }else if((Ambiente.nomeAmbiente.equals("Casa"))&&(Ambiente.numeroStanzaCorrente > 4)){
                    MappaCasaSecondoPiano.stampaFrame();
                }else if(Ambiente.nomeAmbiente.equals("Diner")){
                    MappaDiner.stampaFrame();
                }else if(Ambiente.nomeAmbiente.equals("Spiaggia")){
                    MappaSpiaggia.stampaFrame();
                }else if(Ambiente.nomeAmbiente.equals("Biblioteca")){
                    MappaBiblioteca.stampaFrame();
                }else if(Ambiente.nomeAmbiente.equals("Foresta")){
                    MappaForesta.stampaFrame();
                }else if(Ambiente.nomeAmbiente.equals("Stazione di Polizia")){
                    MappaPolizia.stampaFrame();
                }
        
            }else if(inputUtente.equalsIgnoreCase("/esci")){
                System.out.println("***** ARRIVEDERCI *****");
                System.out.println("");
        
                try {
                    Database.cancellaDatabase(Utilita.urlCasa);
                    Database.cancellaDatabase(Utilita.urlNPCs);
                    Database.connessioneDB(Utilita.urlCasa).close();
                    Database.connessioneDB(Utilita.urlNPCs).close();
                } catch (SQLException e) {
                    System.out.println("Errore chiusura del DB.");
                }
                
                gestoreInput.close();
                System.exit(0);

            }else{
                acquisisciInputSpostamento(inputUtente);
            }

            System.out.println("Aspettando un tuo comando..");
            System.out.println("");
        }

        gestoreInput.close();
    }

    // Metodo che acquisisce l'input dell'utente e verifica se questo input è 
    // di spostamento tra le stanze/ambienti.
    public static void acquisisciInputSpostamento(String inputUtente) throws InterruptedException {

        if (Ambiente.getNomeAmbiente().equals("Casa")) {
            Casa.acquisisciInputCasa(inputUtente);

        } else if (Ambiente.getNomeAmbiente().equals("Spiaggia")) {
            Spiaggia.acquisisciInputSpiaggia(inputUtente);

        } else if (Ambiente.getNomeAmbiente().equals("Stazione di Polizia")) {
            StazioneDiPolizia.acquisisciInputStazionePolizia(inputUtente);

        } else if (Ambiente.getNomeAmbiente().equals("Biblioteca")) {
            Biblioteca.acquisisciInputBiblioteca(inputUtente);

        } else if (Ambiente.getNomeAmbiente().equals("Foresta")) {
            Foresta.acquisisciInputForesta(inputUtente);

        } else if (Ambiente.getNomeAmbiente().equals("Diner")) {
            Diner.acquisisciInputDiner(inputUtente);
        }
    }

    // Metodo che acquisisce l'input dell'utente e lo trasforma in intero,
    // in modo da poter eseguire i controlli del caso e farlo spostare nella stanza da lui desiderata.
    public static void acquisisciInputConNumero(String inputUtente){
        String nuovoInput = inputUtente.substring(inputUtente.lastIndexOf(" ") + 1);
        int numeroStanzaUtente= 0;
        int controlloNumeroStanze= Ambiente.getNumeroStanze().size();

        // Trasforma l'input utente nell'intero equivalente
        numeroStanzaUtente= Integer.parseInt(nuovoInput);

        if((numeroStanzaUtente > 0)&&(numeroStanzaUtente < 10)&&(controlloNumeroStanze >= numeroStanzaUtente)){

            if(Utilita.controllaNumeroStanza(numeroStanzaUtente)){

                // Se l'ambiente in cui si trova il giocatore è la casa,
                // esegue il metodo di controllo sulla stanza.
                if(Ambiente.nomeAmbiente.equals("Casa")){
                    Casa.controllaStanza();
                }

                Ambiente.numeroStanzaCorrente= numeroStanzaUtente;
                Ambiente.nomeStanzaCorrente= Ambiente.nomiStanze[numeroStanzaUtente-1];
                System.out.println("Ti sei spostato in: [" + Ambiente.numeroStanzaCorrente + "] - " + Ambiente.nomiStanze[numeroStanzaUtente-1]);
            }

        }else {
            System.out.println("Non c'è alcuna stanza con questo numero!");
        }
    }

}
