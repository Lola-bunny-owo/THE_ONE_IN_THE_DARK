package com.mycompany.the_one_in_the_dark;

import java.sql.*;
import java.util.Random;

import com.mycompany.the_one_in_the_dark.Ambienti.Ambiente;
import com.mycompany.the_one_in_the_dark.Db.Database;

/**
 * Classe relativa agli NPC all'interno dell'avventura testuale. Questa si occupa di gestire le 
 * interazioni con i personaggi, i dialoghi (in generale), e alcuni controlli.
 * @author Angela Mileti
 */

public class NPCs {
    public static Random rand= new Random();

    public NPCs(){
    }
    
    // Introduzione del personaggio "Grigio".
    public static void introGrigio() throws InterruptedException{
        System.out.println("GRIGIO: Benvenuto. Io sono Ralof, anche detto 'Il Grigio', e sono il custode di questa casa.");
        Utilita.delay();
        System.out.println("GRIGIO: Ho sentito parlare di lei, signor Spike. In realtà, non ricordo molto. La mia memoria fa brutti scherzi.");
        System.out.println("GRIGIO: Non faccia caso a me, e si accomodi pure. Io non sarò altro che un fantasma, per tutta la sua permanenza qui.");
        Utilita.delay();
        System.out.println("GRIGIO: Per ora, vado a farmi un pisolino nel salone.");
        System.out.println("");
        System.out.println("GRIGIO: Ah, a proposito. Lui è Ein, vive in questa casa da qualche mese. È un nuovo arrivato come te.");
        einAbbaia();
        System.out.println("GRIGIO: Puoi farci quello che vuoi con lui, calcialo, lascialo ad un canile, fai quello che ti pare.");
        System.out.println("");
        Utilita.delay();
    }

    // Stampa a schermo del dialogo con Grigio.
    public static void dialogoGrigioSalone() throws InterruptedException{
        System.out.println("GRIGIO: ...");
        Utilita.delay();
        System.out.println("GRIGIO: Perché mi hai svegliato, ragazzo?");
        System.out.println("GRIGIO: Ti ho già detto che non devi far caso a me. Ricordi? Sono un fantasma.");
    }

    // Stampa a schermo del dialogo con Ein.
    public static void einAbbaia(){
        int limite= 3;
        int numeroRandom= rand.nextInt(limite);

        if(numeroRandom == 0){
            System.out.println("EIN: wof!");
        }else if(numeroRandom == 1){
            System.out.println("EIN: wof wof!");
        }else if(numeroRandom == 2){
            System.out.println("EIN: woorf! *scodinzola*");
        }  
    }

    // Metodo che gestisce il dialogo con i personaggi dell'avventura testuale.
    public static void parla(String inputUtente){
        Statement stm;
        ResultSet result;
        String nuovoInput = inputUtente.substring(inputUtente.lastIndexOf(" ") + 1);

        try {
            stm = Database.connessioneDB(Utilita.urlNPCs).createStatement();
            result = stm.executeQuery("SELECT * FROM personaggi WHERE nomeNPC = '" + nuovoInput + "' AND visibile = TRUE");
            
            if(result.next()){
                controllaPersonaggio(nuovoInput);
            }else{
                System.out.println("Non puoi parlare con " + nuovoInput + ".");
            }
            stm.close();
        } catch (SQLException | InterruptedException i) {
            System.out.println("Errore.");
        }

    }

    // Metodo che controlla il nome del personaggio con il quale il giocatore sta parlando.
    // In base al personaggio, viene stampato un dialogo diverso.
    public static void controllaPersonaggio(String nomePersonaggio) throws InterruptedException{

        if((nomePersonaggio.equals("Grigio"))&&(Ambiente.numeroStanzaCorrente == 2)){
            dialogoGrigioSalone();
        }else if(nomePersonaggio.equals("Ein")){
            einAbbaia();
        }
        
    }
}
