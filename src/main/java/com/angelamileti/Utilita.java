package com.angelamileti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.*;

import java.util.Scanner;
import javax.sound.sampled.*;

import com.angelamileti.Db.Database;
import com.angelamileti.Db.DatabaseNPCs;
import com.angelamileti.Ambienti.*;
import com.angelamileti.REST.*;

/**
 * Classe di Utilità: in quest'ultima, si trovano metodi di vario tipo, come metodi per la stampa,
 * metodi che implementano alcune funzionalità specifiche, controlli.
 * 
 * @author Angela Mileti
 */
public class Utilita {
    // Stringhe utili alla gestione del database
    public static final String CREATE_TABLE_CASA = "CREATE TABLE IF NOT EXISTS oggetti (nomeOggetto VARCHAR(300), descrizione VARCHAR(300), inseribile BOOLEAN, inInventario BOOLEAN,  raccoglibile BOOLEAN, stanza INT, visibile BOOLEAN, usabile BOOLEAN, descrizioneUsa VARCHAR(600))";
    public static final String CREATE_TABLE_NPCS = "CREATE TABLE IF NOT EXISTS personaggi (nomeNPC VARCHAR(300), descrizione VARCHAR(700), visibile BOOLEAN)";
    public static final String urlCasa= "jdbc:h2:.//src//main//resources//file//database//databaseCasa";
    public static final String urlNPCs= "jdbc:h2:.//src//main//resources//file//database//databasePersonaggi";
    public static int giornaliAperti= 0;

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
        System.out.println("Sarebbe triste non trovare il motivo per cui mi sono spostato qui in città.");
        delay(2000);
        System.out.println("Chissà se agli zii avrebbe fatto piacere la mia presenza...");
        delay(3000);
        System.out.println("Eccola, la vedo. Sembra tranquilla.");
        delay(2000);
        System.out.println("");
        System.out.println("> Sei arrivato nella tua nuova casa sulla spiaggia, la casa dei tuoi zii ormai defunti.");
        delay(3000);
        System.out.println("Entri in casa usando le chiavi, che fortunatamente non hai dimenticato.");
        delay(3500);
        System.out.println("Appena valichi l'ingresso, ritrovi ad un palmo da te una figura scura. È un uomo dalla folta barba bianca, dall'aspetto cupo.<");
        delay(3500);
        System.out.println("");
        System.out.println("???: E voi chi siete?");
        delay(3000);
        NPCs.introGrigio();
        delay(3000);
        System.out.println("> Non eri a conoscenza del custode di casa. Il suo modo di trattare il cagnolino ti ha infastidito.<");
        delay(3000);
        System.out.println("SPIKE: Ehi piccolino, tutto ok?");
        NPCs.einAbbaia();
        delay(2000);
        System.out.println("");
        System.out.println("> Ti senti libero di esplorare la tua nuova casa. A quanto pare Ein ha voglia di seguirti.<");
        stampaStanzaCorrente();
        delay(3000);
        System.out.println("");
        System.out.println("!Suggerimento!: ehi giocatore, digita il comando /help, per capire come muoverti nell'ambiente e per capire quali comandi puoi o meno inserire.");
        System.out.println("");
    }

    /* STAMPE A SCHERMO */

    // Stampa a schermo l'help dei comandi che prende da un file.
    public static void stampaHelp() throws IOException{
        Scanner stampaHelp= null;
        File fileHelp= new File(".//src//main//resources//file//Help.txt");

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
        File fileTrama= new File(".//src//main//resources//file//Trama.txt");
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

    /* STAMPA INTRODUZIONI AMBIENTI */

    public static boolean introduzioneSpiaggia() throws InterruptedException{
        System.out.println("> Fa caldo.. Il tuo corpo sta iniziando a piangere.");
        System.out.println("Senti il rumore delle onde. Un vento violento ed improvviso ti sferza il viso.");
        System.out.println("Il meteo è sempre inaffidabile..");
        delay(3000);
        System.out.println("Noti che dalla spiaggia puoi spostarti ovunque.");
        System.out.println("Ti senti Dio.");
        delay(2000);
        System.out.println("Fai due passi..<");
        System.out.println("");
        return Spiaggia.introduzioneAmbiente= true;
    }

    public static boolean introduzioneBiblioteca() throws InterruptedException{
        System.out.println("> La biblioteca: un posto amato da grandi e piccini. Il silenzio è una delle sue caratteristiche.");
        delay(2000);
        System.out.println("L'aspetto è serio e cupo, e anche le persone al suo interno sono abbastanza inquietanti. Sembrano tutte così spente..");
        delay(2000);
        System.out.println("Nonostante la paura, scegli di dare un'occhiata in giro. Magari può aiutarti a scoprire qualcosa..<");
        System.out.println("");
        return Biblioteca.introduzioneAmbiente= true;
    }

    public static boolean introduzioneForesta() throws InterruptedException{
        System.out.println("> Sei un pazzo, sei un pazzo, sei un pazzo. Continui a ripetertelo ma comunque prosegui.");
        System.out.println("Questa ti sembra l'occasione giusta per mangiare, perché potrebbe anche essere il tuo ultimo pasto.");
        delay(3000);
        System.out.println("Armato di coraggio, arrivi a quella che ti sembra l'entrata di Bosco Atro.");
        delay(2000);
        System.out.println("Ti guardi attorno, e vedi solo spine. Non ci sono altre strade, devi per forza attraversarle se vuoi proseguire..");
        System.out.println("Boh, almeno sarai ricordato come un eroe.. Certo, da tua madre.<");
        System.out.println("");
        return Foresta.introduzioneAmbiente= true;
    }

    public static boolean introduzioneDiner() throws InterruptedException{
        System.out.println("> Entri nel diner 'Lola's Diner', e vieni subito pervaso da un odore di frittura misto dolcezza.");
        System.out.println("Il tuo sguardo viene subito catturato dall'incantevole cameriera al bancone. La sua uniforme rivela il suo nome: 'Fanny'.");
        System.out.println("Il nome del diner però è diverso..");
        delay(4000);
        System.out.println("Fanny è circondata da clienti, affascinati dal suo sorriso e dal suo profumo inebriante.");
        System.out.println("Allora ti chiedi: ordino da mangiare? Ordino da bere?");
        delay(2000);
        System.out.println("Vorresti prima ispezionare il posto, ma se non mangi tua nonna ti vede sciupato..");
        System.out.println("Sei combattuto..<");
        System.out.println("");
        return Diner.introduzioneAmbiente= true;
    }

    // Metodo di stampa per l'introduzione dell'ambiente.
    public static boolean introduzioneStazionePolizia() throws InterruptedException{
        System.out.println("> Ti avvicini alla stazione di polizia timoroso. Chissà quante brutte storie ha sentito questo luogo, e chissà quante altre sono state sepolte.");
        delay(2000);
        System.out.println("All'ingresso non ci trovi anima viva, il ché è abbastanza strano. Dovrebbe essere pieno di agenti pronti a servirti ed ascoltarti, eppure.. zero.");
        delay(2000);
        System.out.println("Vuoi essere così ficcanaso da entrare in un posto del genere, senza aver ricevuto il permesso di nessuno?");
        System.out.println(".. Ovviamente sì.<");
        System.out.println("");
        return StazioneDiPolizia.introduzioneAmbiente= true;
    }

    /* STAMPA STANZE */

    // Stampa la stanza corrente
    public static void stampaStanzaCorrente() {
        System.out.println("Sei in: [" + Ambiente.getNumeroStanzaCorrente() + "] - " + Ambiente.getNomeStanzaCorrente());
    }

    // Stampa le stanze dell'ambiente corrente
    public static void stampaStanze(){
        if(Ambiente.nomeAmbiente.equals("Casa")){
            System.out.println("Queste sono le stanze presenti in " + Ambiente.nomeAmbiente + ":");

            for(Integer numero: Ambiente.numeroStanze){
                if(numero == 10){
                    System.out.println("[???] - ???");
                }else{
                    System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
                }
            }

        }else if(Ambiente.nomeAmbiente.equals("Spiaggia")){
            System.out.println("Queste sono le aree presenti in " + Ambiente.nomeAmbiente + ":");

            for(Integer numero: Ambiente.numeroStanze){
                System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
            }

        }else if(Ambiente.nomeAmbiente.equals("Stazione di Polizia")){
            System.out.println("Questi sono i dipartimenti presenti in " + Ambiente.nomeAmbiente + ":");

            for(Integer numero: Ambiente.numeroStanze){
                System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
            }

        }else if(Ambiente.nomeAmbiente.equals("Biblioteca")){
            System.out.println("Queste sono le aule presenti in " + Ambiente.nomeAmbiente + ":");
            for(Integer numero: Ambiente.numeroStanze){
                System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
            }

        }else if(Ambiente.nomeAmbiente.equals("Diner")){
            System.out.println("Queste sono le sale presenti in " + Ambiente.nomeAmbiente + ":");
            for(Integer numero: Ambiente.numeroStanze){
                System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
            }
        }else if(Ambiente.nomeAmbiente.equals("Foresta")){
            System.out.println("Queste sono le zone presenti in " + Ambiente.nomeAmbiente + ":");
            for(Integer numero: Ambiente.numeroStanze){
                System.out.println("[" + numero + "] - " + Ambiente.nomiStanze[numero-1]);
            }
        }

    }

    /* STAMPA INVENTARIO */

    // Stampa a schermo gli oggetti presenti nell'inventario.
    public static void stampaInventario(){
        System.out.println("| | | | | | | | | | | | | |");
        System.out.println("         INVENTARIO        ");
        System.out.println("| | | | | | | | | | | | | |");

        if(Inventario.numeroOggettiInventario == 0){
            System.out.println("Non hai nessun oggetto nel tuo inventario.");
        }else{
            Statement stm;
            ResultSet result;

            try {
                stm = Database.connessioneDB(urlCasa).createStatement();
                result= stm.executeQuery("SELECT * FROM oggetti WHERE inInventario = TRUE");

                while(result.next()){
                    System.out.println("---------------------------------------------");
                    System.out.println("NOME: [" + result.getString("nomeOggetto").substring(0, 1).toUpperCase() + result.getString("nomeOggetto").substring(1) + "]");
                    System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
                }
                System.out.println("---------------------------------------------");
                System.out.println("");

                stm.close();
            } catch (SQLException e) {
                System.out.println("Errore nella query.");
            }
               
        }  
        
    }

    /* STAMPA OGGETTI */

    /** Metodo che stampa gli oggetti presenti nella stanza corrente.
    * @param numeroStanzaCorrente: numero della stanza corrente.
    */
    public static void stampaOggetti() {
        Statement stm;
        ResultSet result;
        if(Ambiente.nomeAmbiente.equals("Casa")){

            try {
                stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
                result= stm.executeQuery("SELECT * FROM oggetti WHERE stanza =" + Ambiente.numeroStanzaCorrente + " AND visibile = TRUE");
                
                while(result.next()){
                    System.out.println("NOME: [" + result.getString("nomeOggetto").substring(0, 1).toUpperCase() + result.getString("nomeOggetto").substring(1) + "]");
                }
    
                stm.close();
            } catch (SQLException e) {
                System.out.println("Errore nella stampa degli oggetti.");
            }

        }else{
            System.out.println("Al momento, in questo ambiente non ci sono oggetti. :)");
        }
        
    }
    
    /* FUNZIONI DI CONTROLLO */

    /** Funzione che controlla se la stanza nella quale si vuole andare è diversa da quella corrente.
     * @param numeroStanzaUtente : è l'input da tastiera dell'utente, trasformato in intero
     * @return false se l'utente è già nella stanza nella quale vuole spostarsi, altrimenti true.
     */
    public static boolean controllaNumeroStanza(int numeroStanzaUtente){

        if(numeroStanzaUtente == Ambiente.numeroStanzaCorrente){
            System.out.println("Sei già nella stanza "+ numeroStanzaUtente + ".");
            return false;
        }else{
            return true;
        }

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
            stampaStanzaCorrente();

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
                riproduciChitarra(".//src//main//resources///audio//radiohead.wav");
            } catch (InterruptedException e) {
                System.out.println("Errore.");
            }

        }else if((oggettoUsato.equals("giornale n#1"))&&(Ambiente.numeroStanzaCorrente == 8)){
            giornaliAperti++;
        }else if((oggettoUsato.equals("giornale n#2"))&&(Ambiente.numeroStanzaCorrente == 8)){
            giornaliAperti++;
        }else if((oggettoUsato.equals("macchina fotografica n#2"))&&(Ambiente.numeroStanzaCorrente == 10)){
            
            try {
                NPCs.dialogoGrigioStanzaSegreta();
            } catch (InterruptedException | SQLException e) {
                System.out.println("Errore nella stampa del dialogo.");
            }
        }
    }

    // Metodo di controllo booleano sul numero di oggetti nell'inventario.
    public static boolean controllaOggettiInInventario() {

        if(Inventario.numeroOggettiInventario >= Oggetti.MAX_OGGETTI){
            System.out.println("Hai raggiunto il numero massimo di oggetti che puoi inserire nell'inventario. L'oggetto non è stato inserito.");
            System.out.println("Se vuoi puoi buttare qualcosa dal tuo inventario per avere uno o più slot liberi.");
            return false;
        }else{
            return true;
        }
    }

    // Metodo di controllo booleano sul numero di giornali aperti (nell'ambiente Casa).
    public static boolean controllaGiornaliAperti(String inputUtente){
        if(inputUtente.equalsIgnoreCase("muro")){
            
            if(giornaliAperti < 2){
                return false;
            }else{
                return true;
            }

        }else{
            return true;
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