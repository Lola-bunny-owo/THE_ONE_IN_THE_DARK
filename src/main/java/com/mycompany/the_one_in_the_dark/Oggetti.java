package com.mycompany.the_one_in_the_dark;

import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

import com.mycompany.the_one_in_the_dark.Ambienti.Ambiente;
import com.mycompany.the_one_in_the_dark.Db.Database;

/**
 *
 * @author Angela Mileti
 */

public class Oggetti {

    // Queste variabili devo salvarle da qualche parte? 
    protected static String[] nomeOggetto;
    protected static String[] descrizioneOggetto;
    protected static int[] numeroOggetti;
    protected static boolean oggettoRaccolto= false;
    protected static boolean inInventario= false;
    
    /**
     * MAX_OGGETTI: variabile che indica il numero massimo di oggetti 
     * che si possono inserire nell'inventario. 
     */ 

    protected static final int MAX_OGGETTI = 10;

    /* METODI SET */

    Oggetti() {
    }

    // Controlla se un oggetto è nell'inventario o meno
    public static boolean isInInventario() {
        // TO-DO: implementare il metodo
        return inInventario;
    }

    // Raccoglie un oggetto e lo ispeziona. 
    // Ulteriormente, sceglie se inserire l'oggetto nell'inventario o meno.
    public static void raccogliOggetto(String inputUtente) {
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        
        // Controlla che l'input sia nel database
        try {
            stm= Database.connessioneDB().createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza =" + Ambiente.numeroStanzaCorrente + " AND nomeOggetto ='" + nuovoInput + "' AND visibile = TRUE");
            if(result.next()){
                oggettoRaccolto= true;
                System.out.println("---------------------------------------------");
                System.out.println("--Hai raccolto l'oggetto " + nuovoInput + "!-");
                System.out.println("---------------------------------------------");
                System.out.println("Guardi l'oggetto: ");
                System.out.println("NOME: [" + result.getString("nomeOggetto") + "]");
                System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
                System.out.println("Vuoi inserire questo oggetto nel tuo inventario? (s/n)");
                System.out.print(" --> ");
                Oggetti.sceltaInserimentoInventario(result.getString("nomeOggetto"));
                stm.close();
            }else{
                System.out.println("Non c'è alcun oggetto con quel nome.");
            }
        } catch (SQLException e) {
            System.out.println("Il nome dell'oggetto inserito non esiste.");
        } 
    }

    // Sceglie se inserire l'oggetto o meno nell'inventario.
    public static void sceltaInserimentoInventario(String nomeOggetto) {
        Scanner controllaScelta = new Scanner(new InputStreamReader(System.in));
        String inputUtente = "";
        boolean sceltaValida = false;

        while (sceltaValida == false){
            inputUtente = controllaScelta.nextLine();
            if ((inputUtente.equalsIgnoreCase("s"))&&(controllaOggettiInInventario() == true)){
                Statement stm;
                ResultSet res;

                try {
                    stm= Database.connessioneDB().createStatement();
                    res= stm.executeQuery("SELECT * FROM oggetti WHERE inseribile = TRUE AND nomeOggetto ='" + nomeOggetto + "'");
                    
                    if(res.next()){
                        inserisciOggetto(nomeOggetto);
                        stm.close();
                    }else{
                        System.out.println("L'oggetto non può essere inserito nell'inventario!");
                    }

                } catch (SQLException e) {
                    e.printStackTrace();
                }

                sceltaValida = true;
    
            }else if((inputUtente.equalsIgnoreCase("s"))&&(controllaOggettiInInventario() == false)){
                controllaOggettiInInventario();
                sceltaValida = true;

            }else if(inputUtente.equalsIgnoreCase("n")){
                System.out.println("Non hai inserito l'oggetto " + nomeOggetto + " nel tuo inventario.");
                sceltaValida = true;
                    
            }else {
                    System.out.println("Hai sbagliato a scrivere? O forse sei solo stupido/a?");
                    
            }
        } 
    }

    // Inserisce un oggetto nell'inventario.
    public static void inserisciOggetto(String nomeOggetto) {

        try {
            Statement stm = Database.connessioneDB().createStatement();
            // Aggiorna valore dell'oggetto nella tabella oggetti
            stm.executeUpdate("UPDATE oggetti SET inInventario = TRUE WHERE nomeOggetto = '" + nomeOggetto + "'");
            stm.executeUpdate("UPDATE oggetti SET inseribile = FALSE WHERE nomeOggetto = '" + nomeOggetto + "'");
            stm.executeUpdate("UPDATE oggetti SET visibile = FALSE WHERE nomeOggetto = '" + nomeOggetto + "'");
            System.out.println("Hai inserito l'oggetto [" + nomeOggetto + "] nel tuo inventario!");
            System.out.println("");
            Inventario.numeroOggettiInventario++;
            System.out.println("");
            getNumOggettiInInventario();
            stm.close();
        } catch (SQLException e) {  
            System.out.println("Errore nell'aggiornamento dell'attributo nel database.");
        }
        
    }

    // Esegue un controllo booleano sul numero di oggetti nell'inventario.
    public static boolean controllaOggettiInInventario() {

        if(Inventario.numeroOggettiInventario >= MAX_OGGETTI){
            System.out.println("Hai raggiunto il numero massimo di oggetti che puoi inserire nell'inventario. L'oggetto non è stato inserito.");
            System.out.println("Se vuoi puoi buttare qualcosa dal tuo inventario per avere uno o più slot liberi.");
            return false;
        }else{
            return true;
        }
    }

    // Restituisce il numero di oggetti nell'inventario.
    public static int getNumOggettiInInventario() {

        if(Inventario.numeroOggettiInventario == MAX_OGGETTI){
            System.out.println("Il numero di oggetti nell'inventario è [" + Inventario.numeroOggettiInventario + "] - Hai raggiunto il numero massimo di oggetti che puoi inserire nell'inventario.");
            return MAX_OGGETTI;
        }else if(Inventario.numeroOggettiInventario == 0){
            System.out.println("Nel tuo inventario non c'è nulla!");
            return Inventario.numeroOggettiInventario;
        }else {
            System.out.println("Il numero di oggetti nell'inventario è [" + Inventario.numeroOggettiInventario + "] - Puoi ancora inserire oggetti.");
            return Inventario.numeroOggettiInventario;
        }

    }

    // Metodo che permette di guardare l'oggetto.
    public static void guardaOggetto(String inputUtente) {
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        Statement stm;
        ResultSet result;
        try {
            stm= Database.connessioneDB().createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza =" + Ambiente.numeroStanzaCorrente + " AND nomeOggetto ='" + nuovoInput + "' AND visibile = TRUE");
            if(result.next()){
                System.out.println("NOME: [" + result.getString("nomeOggetto") + "]");
                System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
                stm.close();
            }else{
                System.out.println("Non c'è nessun oggetto con questo nome. Ti sogni le cose?");
            }
        } catch (SQLException e) {
            System.out.println("Il nome dell'oggetto inserito non esiste.");
        } 
    }

    // Metodo che permette di aprire un oggetto.
    public static void usaOggetto(String inputUtente) {
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);

        try {
            stm= Database.connessioneDB().createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto ='" + nuovoInput + "' AND visibile = TRUE AND usabile = TRUE");
            
            if(result.next()){
                System.out.println(result.getString("descrizioneUsa"));
                Utilita.controllaOggettoUsato(nuovoInput);
                stm.close();
            }else if(result.next() == false){
                System.out.println("Non puoi usare questo oggetto.");
            }else{
                System.out.println("Non puoi usare un oggetto che non esiste.");
            }

        } catch (SQLException e) {
            System.out.println("Errore nella query.");
        }

    }

    // Metodo che permette di scartare un oggetto dall'inventario.
    public static void scartaOggetto(String inputUtente) {
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        try {
            stm= Database.connessioneDB().createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto ='" + nuovoInput + "' AND inInventario = TRUE");
            
            if(result.next()){
                stm.executeUpdate("UPDATE oggetti SET inInventario = FALSE WHERE nomeOggetto = '" + nuovoInput + "'");
                stm.executeUpdate("UPDATE oggetti SET inseribile = TRUE WHERE nomeOggetto = '" + nuovoInput + "'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = '" + nuovoInput + "'");
                // Ritorna da solo a casa sua?? Ahahah.
                System.out.println("Hai scartato l'oggetto [" + nuovoInput + "] dall'inventario!");
                Inventario.numeroOggettiInventario--;
                getNumOggettiInInventario();
                stm.close();
            }else{
                System.out.println("Non c'è nessun oggetto con questo nome nel tuo inventario. Fatti controllare da un medico.");
            }

        } catch (SQLException e) {
            System.out.println("Il nome dell'oggetto inserito non esiste.");
        }

    }

    // Metodo che stampa gli oggetti visibili presenti nella stanza corrente.
    public static void stampaOggetti() {
        Statement stm;
        ResultSet result;
        if(Ambiente.nomeAmbiente.equals("Casa")){
            try {
                stm= Database.connessioneDB().createStatement();
                result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza =" + Ambiente.numeroStanzaCorrente + " AND visibile = TRUE");
                
                while(result.next()){
                    System.out.println("NOME: [" + result.getString("nomeOggetto") + "]");
                }
    
                stm.close();
            } catch (SQLException e) {
                System.out.println("Errore nella stampa degli oggetti.");
            } 
        }else{
            System.out.println("Al momento, in questo ambiente non ci sono oggetti. :)");
        }
        
    }

}
