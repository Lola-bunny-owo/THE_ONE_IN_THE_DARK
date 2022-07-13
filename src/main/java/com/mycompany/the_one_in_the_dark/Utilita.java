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
import com.mycompany.the_one_in_the_dark.Db.DatabaseNPCs;
import com.mycompany.the_one_in_the_dark.Ambienti.*;
import com.mycompany.the_one_in_the_dark.REST.*;

/**
 * Classe di Utilità: in quest'ultima, si trovano metodi di vario tipo, come metodi per la stampa,
 * metodi che implementano alcune funzionalità specifiche, etc./
 * 
 * @author Angela Mileti
 */
public class Utilita {
    // Stringhe utili alla gestione del database
    public static final String CREATE_TABLE_CASA = "CREATE TABLE IF NOT EXISTS oggetti (nomeOggetto VARCHAR(300), descrizione VARCHAR(300), inseribile BOOLEAN, inInventario BOOLEAN, idOggetto INT, stanza INT, visibile BOOLEAN, usabile BOOLEAN, descrizioneUsa VARCHAR(600))";
    public static final String CREATE_TABLE_NPCS = "CREATE TABLE IF NOT EXISTS personaggi (nomeNPC VARCHAR(300), descrizione VARCHAR(700), visibile BOOLEAN)";
    public static final String urlCasa= "jdbc:h2:.//src//file//database//databaseCasa";
    public static final String urlNPCs= "jdbc:h2:.//src//file//database//databasePersonaggi";

    public Utilita(){
        // Costruttore vuoto
    }

    // Metodo che dà un delay di 2s ai messaggi.
    public static void delay(int tempo) throws InterruptedException{
        Thread.sleep(tempo);
    }

    // Introduzione al gioco.
    public static void intro() throws InterruptedException{
        
        Database.cancellaDatabase(urlCasa);
        Database.cancellaDatabase(urlNPCs);
        DatabaseNPCs.setPersonaggi();
        Casa.setCasa();
        System.out.println("...Quasi arrivato.");
        delay(2000);
        System.out.println("");
        System.out.println("'''''''''''''''''''''''''");
        System.out.println("'                       '");
        System.out.println("'  Benvenuti ad Awhell  '");
        System.out.println("'                       '");
        System.out.println("'''''''''''''''''''''''''");
        System.out.println("");
        delay(2000);
        System.out.println("Chissà se questa cittadina è accogliente come dicono..");
        delay(2000);
        System.out.println("Ma, piuttosto, dov'è casa mia?");
        delay(2000);
        System.out.println("> Sei arrivato nella tua nuova casa sulla spiaggia. Entri in casa usando le chiavi, che fortunatamente non hai dimenticato.");
        System.out.println("Appena valichi l'ingresso, ritrovi ad un palmo da te una figura scura. È un uomo dalla folta barba bianca, dall'aspetto cupo.<");
        delay(5000);
        System.out.println("");
        System.out.println("???: E voi chi siete?");
        NPCs.introGrigio();
        delay(6000);
        System.out.println("> Non eri a conoscenza del custode di casa. Il suo modo di trattare il cagnolino ti ha infastidito.<");
        System.out.println("SPIKE: Ehi piccolino, tutto ok?");
        NPCs.einAbbaia();
        delay(3000);
        System.out.println("> Ti senti libero di esplorare la tua nuova casa. A quanto pare Ein ha voglia di seguirti.<");
        Ambiente.stampaStanzaCorrente();
        delay(2000);
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
    
    // Metodo che in base all'oggetto usato dal giocatore, cambia la visibilità dell'oggetto oppure richiama altri metodi.
    public static void controllaOggettoUsato(String oggettoUsato){
        Statement stm;
        
        if((oggettoUsato.equals("baule"))&&(Ambiente.numeroStanzaCorrente == 1)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'album di foto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'coniglietto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'lettera'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("armadietto"))&&(Ambiente.numeroStanzaCorrente == 1)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'scarponi'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'corda'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("armadio"))&&(Ambiente.numeroStanzaCorrente == 2)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'chiave'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'vestiti femminili'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("chiave"))&&(Ambiente.numeroStanzaCorrente != 3)){
            Ambiente.numeroStanzaCorrente = 3;
            Ambiente.setNomeStanzaCorrente("Cucina");
            Ambiente.stampaStanzaCorrente();

        }else if((oggettoUsato.equals("armadietto da cucina"))&&(Ambiente.numeroStanzaCorrente == 3)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'dito sottovuoto'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'piatti'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("cestino"))&&(Ambiente.numeroStanzaCorrente == 4)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'accendino'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("libreria"))&&(Ambiente.numeroStanzaCorrente == 5)){

            try {
                stm= Database.connessioneDB(urlCasa).createStatement();
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'romeo e giulietta'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'orgoglio e pregiudizio'");
                stm.executeUpdate("UPDATE oggetti SET visibile = TRUE WHERE nomeOggetto = 'le migliori barzellette di Totti'");
                stm.close();
            } catch (SQLException e) {
                System.out.println("Impossibile aggiornare gli attributi.");
            }

        }else if((oggettoUsato.equals("orologio a pendolo"))&&(Ambiente.numeroStanzaCorrente == 6)){
        
            RestOrologioResponse ora = RestOrologio.getOra("Europe/Rome");
            System.out.println("Esso segna:"); 
            System.out.println("ORA: " + ora.hour + ":" + ora.minute + ":" + ora.seconds);

        }else if((oggettoUsato.equals("chitarra"))&&(Ambiente.numeroStanzaCorrente == 7)){

            try {
                delay(2000);
                riproduciChitarra("src/audio/radiohead.wav");
            } catch (InterruptedException e) {
                System.out.println("Errore.");
            }

        }else if((oggettoUsato.equals("giornale n#1"))&&(Ambiente.numeroStanzaCorrente == 8)){
            Oggetti.giornaliAperti++;
        }else if((oggettoUsato.equals("giornale n#2"))&&(Ambiente.numeroStanzaCorrente == 8)){
            Oggetti.giornaliAperti++;
        }else if((oggettoUsato.equals("macchina fotografica n#2"))&&(Ambiente.numeroStanzaCorrente == 10)){
            
            try {
                NPCs.dialogoGrigioStanzaSegreta();
            } catch (InterruptedException e) {
                System.out.println("Errore nella stampa del dialogo.");
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
