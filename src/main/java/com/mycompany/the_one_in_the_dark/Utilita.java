package com.mycompany.the_one_in_the_dark;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.mycompany.the_one_in_the_dark.Mappe.MappaBiblioteca;
import com.mycompany.the_one_in_the_dark.Mappe.MappaCasaPrimoPiano;
import com.mycompany.the_one_in_the_dark.Mappe.MappaCasaSecondoPiano;
import com.mycompany.the_one_in_the_dark.Mappe.MappaDiner;
import com.mycompany.the_one_in_the_dark.Mappe.MappaForesta;
import com.mycompany.the_one_in_the_dark.Mappe.MappaPolizia;
import com.mycompany.the_one_in_the_dark.Mappe.MappaSpiaggia;

/**
 *
 * @author Angela Mileti
 */
public class Utilita {

    // Metodo che dà un delay di 2s ai messaggi.
    public static void delay() throws InterruptedException{
        Thread.sleep(2000);
    }

    // Introduzione al gioco.
    public static void intro() throws InterruptedException{
        Casa.setCasa();
        Database.setDatabase();
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
        introGrigio();
        delay();
        System.out.println("> Non eri a conoscenza del custode di casa, ma te ne fai una ragione. Ti senti libero di esplorare la tua nuova casa a due piani.");
        Ambiente.stampaStanzaCorrente();
        delay();
        System.out.println("");
        System.out.println("!Suggerimento!: ehi giocatore, digita il comando /help, per capire come muoverti nell'ambiente e per capire quali comandi puoi o meno inserire.");
        System.out.println("");
    }

    // Introduzione del personaggio "Grigio".
    public static void introGrigio() throws InterruptedException{
        System.out.println("GRIGIO: Benvenuto. Io sono Ralof, anche detto 'Il Grigio', e sono il custode di questa casa.");
        delay();
        System.out.println("GRIGIO: Ho sentito parlare di lei, signor Spike. In realtà, non ricordo molto. La mia memoria fa brutti scherzi.");
        System.out.println("GRIGIO: Non faccia caso a me, e si accomodi pure. Io non sarò altro che un fantasma, per tutta la sua permanenza qui.");
        // aggiungere "checkpoint", perché potenzialmente il giocatore non vuole rileggersi sempre sta pappardella
    }


    /* STAMPE A SCHERMO */

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
    
    // TO DO - scrivere la trama del gioco
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

    // Acquisisci comandi utente
    public static void acquisisciInputComando(String inputUtente){
        if(inputUtente.equalsIgnoreCase("/help")){

            try {
                Utilita.stampaHelp();
            } catch (IOException e) {
                e.printStackTrace();
            }
        
        }else if(inputUtente.equalsIgnoreCase("/stanza corrente")){
            Ambiente.stampaStanzaCorrente();

        }else if(inputUtente.equalsIgnoreCase("/trama")){

            try {
                Utilita.stampaTrama();
            } catch (IOException e) {
                e.printStackTrace();
            }
    
        }else if((inputUtente.equalsIgnoreCase("/apri inventario"))||(inputUtente.equalsIgnoreCase("/inventario"))){
            Inventario.stampaInventario();

        }else if(inputUtente.startsWith("/usa ")){
            // TO - DO: usare oggetto
                
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
    
        }else if(inputUtente.startsWith("/raccogli ")){
            Oggetti.raccogliOggetto(inputUtente);
        
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
                
        }else{
            System.out.println("Comando non riconosciuto.");
        }
    }
    
    
}
