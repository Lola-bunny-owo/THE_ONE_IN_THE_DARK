package com.angelamileti;

import java.sql.*;
import java.util.Scanner;

import com.angelamileti.Ambienti.Ambiente;
import com.angelamileti.Db.Database;

/**
 * Classe che si occupa di gestire gli oggetti nell'avventura testuale. Al suo interno sono 
 * definite funzioni che rappresentano alcune tipologie di comandi che l'utente può inserire.
 * (Es: /raccogli <nomeOggetto>)
 * @author Angela Mileti
 */

public class Oggetti {
    // Definizione di variabili utili
    protected static String[] nomeOggetto;
    protected static String[] descrizioneOggetto;
    protected static int[] numeroOggetti;
    /**
     * MAX_OGGETTI: costante che indica il numero massimo di oggetti 
     * che si possono inserire nell'inventario. 
     */ 
    protected static final int MAX_OGGETTI = 10;


    /* Il seguente metodo di raccolta di un oggetto, raccoglie l'oggetto e lo ispeziona.
     * Da questo metodo ne discendono altri due, che permettono al giocatore di scegliere
     * se inserire o meno l'oggetto nell'inventario. 
     * Importante: l'oggetto può essere inserito nell'inventario solo dopo averlo raccolto.
     */
    public static void raccogliOggetto(String inputUtente, Scanner inputScanner) throws SQLException {
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        nuovoInput= nuovoInput.toLowerCase();
        
        // Controlla che l'input sia nel database
        stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
        result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza = " + Ambiente.numeroStanzaCorrente + " AND nomeOggetto = '" + nuovoInput + "' AND visibile = TRUE AND raccoglibile = TRUE");
        if(result.next()){

            System.out.println("---------------------------------------------");
            System.out.println("--Hai raccolto l'oggetto " + nuovoInput + "!-");
            System.out.println("---------------------------------------------");
            System.out.println("Guardi l'oggetto: ");
            System.out.println("NOME: [" + result.getString("nomeOggetto").substring(0, 1).toUpperCase() + result.getString("nomeOggetto").substring(1) + "]");
            System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
            System.out.println("Vuoi inserire questo oggetto nel tuo inventario? (s/n)");
            sceltaInserimentoInventario(result.getString("nomeOggetto"), inputScanner);
        }else if(!result.next()){
            System.out.println("Non puoi raccogliere l'oggetto [" + nuovoInput + "] !");
        }else {
            System.out.println("Non c'è alcun oggetto con quel nome.");
        }

        stm.close();
    }

    // Sceglie se inserire l'oggetto o meno nell'inventario.
    public static void sceltaInserimentoInventario(String nomeOggetto, Scanner inputScanner) throws SQLException {
        String inputUtente = "";
        boolean sceltaValida = false;

        while (sceltaValida == false){
            System.out.print(" --> ");
            inputUtente = inputScanner.nextLine();
            if ((inputUtente.equalsIgnoreCase("s"))&&(Utilita.controllaOggettiInInventario() == true)){
                Statement stm;
                ResultSet res;

                stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
                res= stm.executeQuery("SELECT * FROM oggetti WHERE inseribile = TRUE AND nomeOggetto = '" + nomeOggetto + "'");
                    
                if(res.next()){
                    inserisciOggetto(nomeOggetto);
                        
                }else{
                    System.out.println("L'oggetto non può essere inserito nell'inventario!");
                }

                stm.close();
                sceltaValida = true;
    
            }else if((inputUtente.equalsIgnoreCase("s"))&&(Utilita.controllaOggettiInInventario() == false)){
                Utilita.controllaOggettiInInventario();
                sceltaValida = true;

            }else if(inputUtente.equalsIgnoreCase("n")){
                System.out.println("Non hai inserito l'oggetto " + nomeOggetto + " nel tuo inventario.");
                sceltaValida = true;
                    
            }else {
                System.out.println("Hai sbagliato a scrivere? O forse sei solo stupido/a?");
     
            }
        }

    }

    // Inserisce l'oggetto nell'inventario.
    public static void inserisciOggetto(String nomeOggetto) {

        try {
            Statement stm = Database.connessioneDB(Utilita.urlCasa).createStatement();
            // Aggiorna valore dell'oggetto nella tabella oggetti
            stm.executeUpdate("UPDATE oggetti SET inInventario = TRUE WHERE nomeOggetto = '" + nomeOggetto + "'");
            stm.executeUpdate("UPDATE oggetti SET inseribile = FALSE WHERE nomeOggetto = '" + nomeOggetto + "'");
            stm.executeUpdate("UPDATE oggetti SET visibile = FALSE WHERE nomeOggetto = '" + nomeOggetto + "'");
            System.out.println("Hai inserito l'oggetto [" + nomeOggetto + "] nel tuo inventario!");
            System.out.println("");
            Inventario.numeroOggettiInventario++;
            System.out.println("");
            Inventario.getNumOggettiInInventario();
            stm.close();
        } catch (SQLException e) {  
            System.out.println("Errore nell'aggiornamento degli attributi nel database.");
        }
        
    }

    /* Metodi per guardare, usare, aprire, scartare un oggetto. */

    // Metodo che permette di guardare un oggetto.
    public static void guardaOggetto(String inputUtente) throws SQLException {
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        nuovoInput= nuovoInput.toLowerCase();
        Statement stm;
        ResultSet result;

        stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
        result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza =" + Ambiente.numeroStanzaCorrente + " AND nomeOggetto ='" + nuovoInput + "' AND visibile = TRUE");
            
        if(result.next()){
            System.out.println("NOME: [" + result.getString("nomeOggetto").substring(0, 1).toUpperCase() + result.getString("nomeOggetto").substring(1) + "]");
            System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
        }else{
            System.out.println("Non c'è nessun oggetto con questo nome. Ti sogni le cose?");
        }
        
        stm.close();
    }

    /* Questo metodo controlla se l'input inserito dall'utente è un oggetto che si può usare, con gli attributi
    * visibile e usabile impostati a true.
    * Se la query restituisce un risultato valido, allora si usa l'oggetto.
    * Se la query restituisce un risultato non valido, si controlla se l'oggetto è nell'inventario e se
    * è presente lo si usa altrimenti stampa un messaggio di errore.
    */
    public static void usaOggetto(String inputUtente) throws SQLException {
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        nuovoInput= nuovoInput.toLowerCase();

        
        if(Utilita.controllaGiornaliAperti(nuovoInput) == true){
            stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto ='" + nuovoInput + "' AND visibile = TRUE AND usabile = TRUE");
            
            if(result.next()){
                System.out.println(result.getString("descrizioneUsa"));
                Utilita.controllaOggettoUsato(nuovoInput);
                    
            // Controlla se l'oggetto è nell'inventario.
            }else if(!result.next()){
            
                result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto = '" + nuovoInput + "' AND inInventario = TRUE AND usabile = TRUE");
                if(result.next()){
                    System.out.println(result.getString("descrizioneUsa"));
                    Utilita.controllaOggettoUsato(nuovoInput);
                            
                }else{
                    System.out.println("Non puoi usare questo oggetto.");
                }
                    
            }else{
                System.out.println("Non puoi usare un oggetto che non esiste.");
            }
            
            stm.close();

        }else{
            System.out.println("Non hai tempo adesso, devi prima trovare degli indizi.");
        }
    }

    /* Questo metodo controlla se l'input inserito dall'utente è un oggetto che si può aprire, con gli attributi
    * visibile e usabile impostati a true.
    * Se la query restituisce un risultato valido, allora si controlla che la stanza in cui
    * ci si trova sia la stessa stanza in cui si trova l'oggetto.
    */
    public static void apriOggetto(String inputUtente) throws SQLException{
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        nuovoInput= nuovoInput.toLowerCase();
        int numeroStanza= 0;

        if(Utilita.controllaGiornaliAperti(nuovoInput) == true){

            stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto = '" + nuovoInput + "' AND visibile = TRUE AND usabile = TRUE");
                    
            if(result.next()){

                numeroStanza= result.getInt("stanza");
                if(numeroStanza == Ambiente.numeroStanzaCorrente){
                    System.out.println(result.getString("descrizioneUsa"));
                    Utilita.controllaOggettoUsato(nuovoInput);
                }else{
                    System.out.println("Non puoi aprire questo oggetto qui.");
                }

            }else if(!result.next()){
                System.out.println("Non puoi aprire questo oggetto.");

            }else{
                System.out.println("Non puoi aprire un oggetto che non esiste.");
            }

            stm.close();

        }else{
            System.out.println("Non hai tempo adesso, devi prima trovare degli indizi.");
        }
    }

    // Metodo che scarta l'oggetto dall'inventario, se è presente.
    public static void scartaOggetto(String inputUtente) throws SQLException{
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        nuovoInput= nuovoInput.toLowerCase();

        stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
        result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto ='" + nuovoInput + "' AND inInventario = TRUE");
            
        // Se l'oggetto è nell'inventario, vengono aggiornati i valori degli attributi.
        // Inoltre, l'oggetto torna alla sua posizione iniziale.
        if(result.next()){
            stm.executeUpdate("UPDATE oggetti SET inInventario = FALSE WHERE nomeOggetto = '" + nuovoInput + "'");
            stm.executeUpdate("UPDATE oggetti SET inseribile = TRUE WHERE nomeOggetto = '" + nuovoInput + "'");
            stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = '" + nuovoInput + "'");
        
            System.out.println("Hai scartato l'oggetto [" + nuovoInput.substring(0, 1).toUpperCase() + nuovoInput.substring(1) + "] dall'inventario!");
            Inventario.numeroOggettiInventario--;
            Inventario.getNumOggettiInInventario();
            stm.close();
        }else{
            System.out.println("Non c'è nessun oggetto con questo nome nel tuo inventario. Fatti controllare da un medico.");
        }

    }

}
