package com.angelamileti;

import java.sql.*;
import java.util.Random;

import com.angelamileti.Ambienti.Ambiente;
import com.angelamileti.Db.Database;

/**
 * Classe relativa agli NPC all'interno dell'avventura testuale. Questa si occupa di gestire le 
 * interazioni con i personaggi, i dialoghi (in generale), e alcuni controlli.
 * @author Angela Mileti
 */

public class NPCs {
    public static Random rand= new Random();
    public static boolean dialogoGrigioStanzaSegreta;

    public NPCs(){
        dialogoGrigioStanzaSegreta= false;
    }
    
    // Introduzione del personaggio "Grigio".
    public static void introGrigio() throws InterruptedException{
        System.out.println("GRIGIO: Benvenuto. Io sono Ralof, anche detto 'Il Grigio', e sono il custode di questa casa.");
        Utilita.delay(4000);
        System.out.println("GRIGIO: Ho sentito parlare di lei, signor Spike. In realtà, non ricordo molto. La mia memoria fa brutti scherzi.");
        Utilita.delay(4000);
        System.out.println("GRIGIO: Non faccia caso a me, e si accomodi pure. Io non sarò altro che un fantasma, per tutta la sua permanenza qui.");
        Utilita.delay(4000);
        System.out.println("GRIGIO: Per ora, vado a farmi un pisolino nel salone.");
        Utilita.delay(3000);
        System.out.println("");
        System.out.println("GRIGIO: Ah, a proposito. Lui è Ein, un Corgi che vive in questa casa da qualche mese. È un nuovo arrivato come te.");
        einAbbaia();
        Utilita.delay(3000);
        System.out.println("GRIGIO: Puoi farci quello che vuoi con lui, calcialo, lascialo ad un canile, fai quello che ti pare.");
        System.out.println("");
    }

    // Stampa a schermo del dialogo con Grigio nel salone dell'ambiente Casa
    public static void dialogoGrigioSalone() throws InterruptedException{
        System.out.println("GRIGIO: ...");
        Utilita.delay(2000);
        System.out.println("GRIGIO: Perché mi hai svegliato, ragazzo?");
        System.out.println("GRIGIO: Ti ho già detto che non devi far caso a me. Ricordi? Sono un fantasma.");
    }

    // Stampa a schermo del dialogo con Grigio nella stanza segreta dell'ambiente Casa
    public static void dialogoGrigioStanzaSegreta() throws InterruptedException, SQLException{
        Statement stm;
        ResultSet result;
        boolean oggettoPresente= false;

        Utilita.delay(15000);
        System.out.println("");
        System.out.println("GRIGIO: ...");
        Utilita.delay(3000);
        System.out.println("GRIGIO: Che ci fai qui, verme che non sei altro?");
        Utilita.delay(3000);
        System.out.println("GRIGIO: .. quanto hai scoperto? Eh?");
        System.out.println("SPIKE: ...");
        Utilita.delay(2000);
        System.out.println("GRIGIO: PARLA!");
        Utilita.delay(2000);
        System.out.println("SPIKE: ..abb-abbastanza. E tu invece, perché stai nascondendo queste cose?");
        System.out.println("SPIKE: Malato di merda! Correrò subito dalla polizia!");
        Utilita.delay(6000);
        System.out.println("GRIGIO: Non credo proprio.");
        System.out.println("");
        Utilita.delay(3000);
        System.out.println("> Il custode ha uno sguardo perso, vuoto. Si avvicina molto lentamente verso di te.");
        System.out.println("Con un balzo, te lo ritrovi addosso. Provi in tutti i modi a respingerlo, ma cadi"
        + " a terra fallendo miseramente.");
        System.out.println("Fortunatamente hai Ein dalla tua: sfrutta la tua posizione per saltarti"
        + " addosso e attaccare il custode.");
        Utilita.delay(12000);
        System.out.println("Ma il custode sembra esser fatto di roccia. Nonostante adesso si ritrovi con il braccio"
        + " sanguinante, lancia Ein contro il muro e dice: <");
        Utilita.delay(5000);
        System.out.println("");
        System.out.println("GRIGIO: Tutto qui? Mi aspettavo di più dal nipote dei Thompson. Invece sei solo una mezza calzetta.");
        Utilita.delay(3000);
        System.out.println("> Il custode si avvicina di nuovo, e questa volta non ti lasci sorprendere:");
        Utilita.delay(2000);

        // Controlla che nell'inventario ci sia l'oggetto "Sparachiodi" e "Chiodi".
        stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
        result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto = 'sparachiodi' AND inInventario = TRUE");

        if(result.next()){

            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto = 'chiodi' AND inInventario = TRUE");

            // Se nell'inventario sono presenti entrambi gli oggetti, stampa il seguente dialogo..
            // altrimenti ne stampa uno diverso.
            if(result.next()){
                System.out.println("Si butta di nuovo su di te, ma questa volta usi la sparachiodi a mo' di pistola.");
                System.out.println("Dato che non sei un assassino, gli spari due chiodi sulle mani"
                + " e gli tiri un calcio, per immobilizzarlo.");
                System.out.println("Lui cade a terra, preso dal dolore.");
                System.out.println("Per tua fortuna hai ancora un po' di chiodi.");
                Utilita.delay(15000);
                oggettoPresente= true;
            }else{
                System.out.println("Non appena prova a buttarsi di nuovo su di te, prendi la tua sparachiodi"
                + " e la usi per tirargliela dove non batte il sole.");
                System.out.println("Lui cade a terra, preso dal dolore.");
                Utilita.delay(10000);
                oggettoPresente= true;
            }
        }
        stm.close();

        // Se nell'inventario non ci sono i due oggetti sopracitati, controlla che nell'inventario ci sia l'oggetto "Coltello".
        if(!oggettoPresente){

            stm= Database.connessioneDB(Utilita.urlCasa).createStatement();
            result= stm.executeQuery("SELECT * FROM oggetti WHERE nomeOggetto = 'coltello' AND inInventario = TRUE");

            if(result.next()){
                System.out.println("Si butta su di te, ma questa volta usi il coltello.");
                System.out.println("Cerchi di non colpire punti vitali, e allo stesso tempo gli fai abbastanza"
                + " male da immobilizzarlo.");
                System.out.println("Lui cade a terra, preso dal dolore.");
                Utilita.delay(15000);
                oggettoPresente= true;
            }else{
                System.out.println("Si butta su di te, e riesci a spostarti in tempo.");
                Utilita.delay(5000);
            }
            stm.close();
        }

        System.out.println("");
        System.out.println("Prendi in braccio Ein che è sdraiato a terra, leggermente ferito, e scappi verso la porta.");
        System.out.println("Forse non sei forte, ma sei veloce: ritorni nella stanza del custode"
        + " e blocchi l'entrata alla stanza segreta spostando il letto davanti.");
        System.out.println("Per ora l'hai scampata, ma adesso devi riflettere!<");
        Utilita.delay(10000);
        Ambiente.decrementoStanza();
        Ambiente.decrementoStanza();
        // Si blocca l'accesso alla stanza segreta.
        dialogoGrigioStanzaSegreta = true;
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
        nuovoInput= nuovoInput.toLowerCase();

        try {
            stm = Database.connessioneDB(Utilita.urlNPCs).createStatement();
            result = stm.executeQuery("SELECT * FROM personaggi WHERE nomeNPC = '" + nuovoInput + "' AND visibile = TRUE");
            
            if(result.next()){
                controllaPersonaggio(nuovoInput);
            }else{
                System.out.println("Non puoi parlare con " + nuovoInput.substring(0, 1).toUpperCase() + nuovoInput.substring(1) + ".");
            }
            stm.close();
        } catch (SQLException | InterruptedException i) {
            System.out.println("Errore.");
        }

    }

    // Metodo che controlla il nome del personaggio con il quale il giocatore sta parlando.
    // In base al personaggio, viene stampato un dialogo diverso.
    public static void controllaPersonaggio(String nomePersonaggio) throws InterruptedException{

        if((nomePersonaggio.equals("grigio"))&&(Ambiente.numeroStanzaCorrente == 2)){
            dialogoGrigioSalone();
        }else if(nomePersonaggio.equals("ein")){
            einAbbaia();
        }
        
    }
}
