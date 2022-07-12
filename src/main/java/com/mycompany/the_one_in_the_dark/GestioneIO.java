package com.mycompany.the_one_in_the_dark;

import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.mycompany.the_one_in_the_dark.Ambienti.*;
import com.mycompany.the_one_in_the_dark.Db.Database;
import com.mycompany.the_one_in_the_dark.Mappe.*;

/**
 * Classe che gestisce l'input e l'output dell'utente. 
 * @author Angela Mileti
 */

public class GestioneIO {

    Scanner gestoreInput = new Scanner(new InputStreamReader(System.in));
    String inputUtente;

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

            // Se l'input è un intero, vuol dire che l'utente vuole cambiare stanza 
            // attraverso il numero della stanza.
            if (gestoreInput.hasNextInt()) {
                inputUtente = gestoreInput.nextInt() + "";
                Ambiente.acquisisciInputConNumero(inputUtente);
                System.out.println("Aspettando un tuo comando..");
                System.out.println("");
                
            // altrimenti, l'utente ha inserito un comando del tipo "/<comando>". Se il comando inserito 
            // non è del tipo appena citato, allora si verifica se il comando è uno spostamento.
            } else {
                inputUtente = gestoreInput.nextLine();
            
                if(inputUtente.equalsIgnoreCase("/help")){

                    try {
                        Utilita.stampaHelp();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                
                }else if(inputUtente.equalsIgnoreCase("/stanza")){
                    Ambiente.stampaStanzaCorrente();
        
                }else if(inputUtente.equalsIgnoreCase("/trama")){
        
                    try {
                        Utilita.stampaTrama();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
            
                }else if((inputUtente.equalsIgnoreCase("/apri inventario"))||(inputUtente.equalsIgnoreCase("/inventario"))){
                    Inventario.stampaInventario();
        
                }else if((inputUtente.startsWith("/usa "))||(inputUtente.startsWith("/apri "))){
                    Oggetti.usaOggetto(inputUtente);
            
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
                    Oggetti.guardaOggetto(inputUtente);
        
                }else if(inputUtente.startsWith("/raccogli ")){
                    Oggetti.raccogliOggetto(inputUtente);
        
                }else if(inputUtente.startsWith("/scarta ")){
                    Oggetti.scartaOggetto(inputUtente);
        
                }else if(inputUtente.startsWith("/parla con ")){
                    NPCs.parla(inputUtente);
        
                }else if(inputUtente.equalsIgnoreCase("/oggetti")){
                    Oggetti.stampaOggetti();
        
                }else if(inputUtente.equalsIgnoreCase("/lista stanze")){
                    Ambiente.stampaStanze();
        
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
        
                    System.exit(0);

                }else{
                    acquisisciInputSpostamento(inputUtente);
                }
                System.out.println("Aspettando un tuo comando..");
                System.out.println("");
            }
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

    /* METODI SET */
    
    public void setInputUtente(String inputUtente) {
        this.inputUtente = inputUtente;
    }

    public void setGestoreInput(Scanner gestoreInput) {
        this.gestoreInput = gestoreInput;
    }
    
    /* METODI GET */

    public String getInputUtente() {
        return inputUtente;
    }

    public Scanner getGestoreInput() {
        return gestoreInput;
    }

    

}
