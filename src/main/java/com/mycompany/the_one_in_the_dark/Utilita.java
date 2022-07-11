package com.mycompany.the_one_in_the_dark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.sound.sampled.*;

import com.mycompany.the_one_in_the_dark.Db.Database;
import com.mycompany.the_one_in_the_dark.Ambienti.*;
import com.mycompany.the_one_in_the_dark.Mappe.*;

/**
 *
 * @author Angela Mileti
 */
public class Utilita {

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS oggetti (nomeOggetto VARCHAR(300), descrizione VARCHAR(300), inseribile BOOLEAN, inInventario BOOLEAN, idOggetto INT, stanza INT, visibile BOOLEAN, usabile BOOLEAN, descrizioneUsa VARCHAR(600))";

    // Metodo che dà un delay di 2s ai messaggi.
    public static void delay() throws InterruptedException{
        Thread.sleep(2000);
    }

    // Introduzione al gioco.
    public static void intro() throws InterruptedException{
        Database.cancellaDatabase();
        Casa.setCasa();
        System.out.println("...Quasi arrivato.");
        delay();
        System.out.println("");
        System.out.println("'''''''''''''''''''''''''");
        System.out.println("'                       '");
        System.out.println("'  Benvenuti ad Awhell  '");
        System.out.println("'                       '");
        System.out.println("'''''''''''''''''''''''''");
        System.out.println("");
        delay();
        System.out.println("Chissà se questa cittadina è accogliente come dicono..");
        delay();
        System.out.println("Ma, piuttosto, dov'è casa mia?");
        delay();
        System.out.println("> Sei arrivato nella tua nuova casa sulla spiaggia. Entri in casa usando le chiavi, che fortunatamente non hai dimenticato.");
        System.out.println("Appena valichi l'ingresso, ritrovi ad un palmo da te una figura scura. È un uomo dalla folta barba bianca, dall'aspetto cupo.<");
        delay();
        System.out.println("");
        System.out.println("E voi chi siete?");
        NPCs.introGrigio();
        delay();
        System.out.println("> Non eri a conoscenza del custode di casa, ma te ne fai una ragione. Ti senti libero di esplorare la tua nuova casa a due piani.");
        Ambiente.stampaStanzaCorrente();
        delay();
        System.out.println("");
        System.out.println("!Suggerimento!: ehi giocatore, digita il comando /help, per capire come muoverti nell'ambiente e per capire quali comandi puoi o meno inserire.");
        System.out.println("");
    }

    /* STAMPE A SCHERMO */

    // Stampa a schermo l'help dei comandi che prende da un file.
    public static void stampaHelp() throws IOException{
        Scanner stampaHelp= null;
        File fileHelp= new File(".//src//file//Help.txt");

        try{
            stampaHelp= new Scanner(new BufferedReader(new FileReader(fileHelp)));
            while(stampaHelp.hasNextLine()){
                System.out.println(stampaHelp.nextLine());
            }
        }finally{
            if(stampaHelp!= null){
                stampaHelp.close();
            }
        }
    }
    
    // Stampa a schermo la trama del gioco che prende da un file.
    public static void stampaTrama() throws IOException{
        Scanner stampaTrama= null;
        File fileTrama= new File(".//src//file//Trama.txt");
        try{
            stampaTrama= new Scanner(new BufferedReader(new FileReader(fileTrama)));
            while(stampaTrama.hasNextLine()){
                System.out.println(stampaTrama.nextLine());
            }
        }finally{
            if(stampaTrama!= null){
                stampaTrama.close();
            }
        }
    }

    /* STAMPE ENTRATE AMBIENTI - quando il giocatore entra nell'ambiente, visualizza il messaggio. */

    public static void stampaEntrataSpiaggia(){
        System.out.println("***** SPIAGGIA *****");
        System.out.println("");
    }

    public static void stampaEntrataBiblioteca(){
        System.out.println("***** BIBLIOTECA *****");
        System.out.println("");
    }

    public static void stampaEntrataForesta(){
        System.out.println("***** FORESTA *****");
        System.out.println("");
    }

    public static void stampaEntrataDiner(){
        System.out.println("***** LOLA'S DINER *****");
        System.out.println("");
    }

    public static void stampaEntrataCasa(){
        System.out.println("***** CASA *****");
        System.out.println("");
    }

    public static void stampaEntrataStazioneDiPolizia(){
        System.out.println("***** STAZIONE DI POLIZIA *****");
        System.out.println("");
    }

    // Metodo che acquisisce i comandi dell'utente. Questi comandi sono comandi
    // utilizzabili dall'utente in qualsiasi ambiente e stanza egli si trovi.
    public static void acquisisciInputComando(String inputUtente) throws InterruptedException{

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
            
        }else if((inputUtente.equalsIgnoreCase("/apri taccuino"))||(inputUtente.equalsIgnoreCase("/taccuino"))){
            //TO - DO: apri taccuino
    
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
                Database.cancellaDatabase();
                Database.connessioneDB().close();
            } catch (SQLException e) {
                System.out.println("Errore chiusura del DB.");
            }

            System.exit(0);

        }else{
            System.out.println("Comando non riconosciuto.");
        }
    }
    
    // Metodo che in base all'oggetto che viene usato, cambia la visibilità di alcuni oggetti o richiama altri metodi.
    public static void controllaOggettoUsato(String oggettoUsato){
        Statement stm;
        
        if((oggettoUsato.equals("Baule"))&&(Ambiente.numeroStanzaCorrente == 1)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Album di foto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Coniglietto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Lettera'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Armadietto"))&&(Ambiente.numeroStanzaCorrente == 1)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Scarponi'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Corda'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Armadietto"))&&(Ambiente.numeroStanzaCorrente == 2)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Chiave'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Vestiti femminili'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Armadietto da cucina"))&&(Ambiente.numeroStanzaCorrente == 3)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Dito sottovuoto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Piatti'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Cestino"))&&(Ambiente.numeroStanzaCorrente == 4)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Accendino'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Libreria"))&&(Ambiente.numeroStanzaCorrente == 5)){

            try {
                stm= Database.connessioneDB().createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Romeo e Giulietta'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Orgoglio e Pregiudizio'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'Le migliori barzellette di Totti'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("Orologio a pendolo"))&&(Ambiente.numeroStanzaCorrente == 6)){
        
            // TO-DO: Implementare l'utilizzo dell'API RESTful.

        }else if((oggettoUsato.equals("Chitarra"))&&(Ambiente.numeroStanzaCorrente == 7)){

            try {
                delay();
                riproduciChitarra("src/audio/radiohead.wav");
            } catch (InterruptedException e) {
                System.out.println("Errore.");
            }
            
        }
    }

    // Al comando /usa Chitarra, viene riprodotto l'audio specificato dalla stringa passata come parametro.
    public static void riproduciChitarra(String path){
        File file = new File(path);
        try {
            // Crea un oggetto di tipo AudioInputStream che contiene il file audio.
            // Crea un oggetto di tipo Clip che permette di riprodurre l'audio.
            AudioInputStream audioStream= AudioSystem.getAudioInputStream(file);
            Clip clip= AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();

            // Riproduce il file fino a quando non arriva alla fine.
            while(clip.getFramePosition() < clip.getFrameLength()){
                Thread.sleep(100);
            }
            
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            System.out.println("Errore nella riproduzione dell'audio.");
        }
        
    }
    
}
