package com.angelamileti.ambienti;

import java.sql.*;

import com.angelamileti.NPCs;
import com.angelamileti.Utilita;
import com.angelamileti.db.Database;
import com.angelamileti.db.DatabaseCasa;

/**
 * Classe che gestisce l'ambiente Casa. Come per ogni altro ambiente, questa classe contiene un
 * metodo set nel quale s'impostano i valori degli attributi interessati, un metodo per l'acquisizione
 * dell'input inerente all'ambiente, ed altri metodi di vario genere, sempre correlati all'ambiente.
 * @author Angela Mileti
 */

public class Casa extends Ambiente {
    /**
     * @param args
     */

    static boolean setOggettiCasa;

    public Casa(){
        setOggettiCasa = false;
    }

    public static void setCasa() throws InterruptedException {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Casa");
        if(!Ambiente.numeroStanze.isEmpty()){
            Ambiente.numeroStanze.clear();
        }
        Ambiente.numeroStanze.add(1); 
        Ambiente.numeroStanze.add(2);
        Ambiente.numeroStanze.add(3);
        Ambiente.numeroStanze.add(4);
        Ambiente.numeroStanze.add(5);
        Ambiente.numeroStanze.add(6);
        Ambiente.numeroStanze.add(7);
        Ambiente.numeroStanze.add(8);
        Ambiente.numeroStanze.add(9);
        Ambiente.numeroStanze.add(10);

        Ambiente.setNomiStanze(new String[] { "Ingresso", "Salone", "Cucina",  "Veranda", "Corridoio largo", "Corridoio stretto", "Camera da letto di Spike", "Camera da letto del custode", "Bagno", "Stanza segreta"});
        Ambiente.setNumeroStanzaCorrente(numeroStanze.first());
        Ambiente.setNomeStanzaCorrente("Ingresso");

        // Set degli oggetti presenti nella casa
        if(!setOggettiCasa){
            DatabaseCasa.setOggettiCasa();
            setOggettiCasa= true;
        }

    }

    // Metodo per l'acquisizione dell'input inerente all'ambiente.
    public static void acquisisciInputCasa(String inputUtente){

        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 7){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 8){
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 10){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                // Va di defalut nella propria stanza.
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a sinistra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai sopra"))||(inputUtente.equalsIgnoreCase("sopra"))){

            if(getNumeroStanzaCorrente() == 1){
                System.out.println("Non puoi andare sopra dall'ingresso.");
            }else if(getNumeroStanzaCorrente() == 2){
                incrementoStanza();
                incrementoStanza();
                incrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                System.out.println("Non puoi andare sopra dalla cucina.");
            }else if(getNumeroStanzaCorrente() == 4){
                System.out.println("Non puoi andare sopra dalla veranda.");
            }else{
                System.out.println("Sei gi?? sopra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai gi??"))||(inputUtente.equalsIgnoreCase("gi??"))){
                
            if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                System.out.println("Non puoi andare gi?? dal corridoio stretto.");
            }else if(getNumeroStanzaCorrente() == 7){
                System.out.println("Non puoi andare gi?? dalla tua stanza.");
            }else if(getNumeroStanzaCorrente() == 8){
                System.out.println("Non puoi andare gi?? dalla stanza del custode.");
            }else if(getNumeroStanzaCorrente() == 9){
                System.out.println("Non puoi andare gi?? dal bagno.");
            }else if(getNumeroStanzaCorrente() == 10){
                System.out.println("Non puoi andare gi?? dalla stanza segreta.");
            }else{
                System.out.println("Sei gi?? sotto.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 6){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    Utilita.stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 8){

                    if((Utilita.giornaliAperti == 2)&&(NPCs.dialogoGrigioStanzaSegreta == false)){
                        incrementoStanza();
                        incrementoStanza();
                        Utilita.stampaStanzaCorrente();
                        
                    }else if((Utilita.giornaliAperti == 2)&&(NPCs.dialogoGrigioStanzaSegreta == true)){
                        System.out.println("Non puoi andare avanti. Ricordi? C'?? un possibile serial killer bloccato all'interno.");
                        System.out.println("In ogni caso, devi capirne di pi??.");

                    }else if(Utilita.giornaliAperti < 2){
                        System.out.println("Non puoi andare avanti. Cerca degli indizi, e forse la situazione cambier??.");
                    }
                    
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                Utilita.stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare indietro.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai in Spiaggia"))||(inputUtente.equalsIgnoreCase("Spiaggia"))){

            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataSpiaggia();
                Spiaggia.setSpiaggia();
            }else if(getNumeroStanzaCorrente() == 4){
                Utilita.stampaEntrataSpiaggia();
                Spiaggia.setSpiaggia();
            }else{
                System.out.println("Non puoi andare in Spiaggia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai in Biblioteca"))||(inputUtente.equalsIgnoreCase("Biblioteca"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataBiblioteca();
                Biblioteca.setBiblioteca();
            }else{
                System.out.println("Non puoi andare in Biblioteca da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai nella Foresta"))||(inputUtente.equalsIgnoreCase("Foresta"))){
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataForesta();
                Foresta.setForesta();
            }else{
                System.out.println("Non puoi andare nella Foresta da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai alla stazione di Polizia"))||(inputUtente.equalsIgnoreCase("Stazione di Polizia"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataStazioneDiPolizia();
                StazioneDiPolizia.setStazioneDiPolizia();
            }else{
                System.out.println("Non puoi andare alla stazione di Polizia da qui.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai al Diner"))||(inputUtente.equalsIgnoreCase("Diner"))){
            
            if(getNumeroStanzaCorrente() == 1){
                Utilita.stampaEntrataDiner();
                Diner.setDiner();
            }else{
                System.out.println("Non puoi andare al Diner da qui.");
            }

        }else{
            System.out.println("Comando non riconosciuto.");
        }

        controllaStanza();
    }

    // Metodo che permette all'utente di guardare la stanza.
    public static void guardaStanzaCasa(){
        if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Ingresso")){
            Casa.stampaIngresso();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Cucina")){
            Casa.stampaCucina();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Salone")){
            Casa.stampaSalone();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Veranda")){
            Casa.stampaVeranda();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Corridoio largo")){
            Casa.stampaCorridoioLargo();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Corridoio stretto")){
            Casa.stampaCorridoioStretto();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Camera da letto di Spike")){
            Casa.stampaCameraDaLettoSpike();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Camera da letto del custode")){
            Casa.stampaCameraDaLettoCustode();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Bagno")){
            Casa.stampaBagno();
        }else if(Ambiente.nomeStanzaCorrente.equalsIgnoreCase("Stanza segreta")){
            Casa.stampaStanzaSegreta();
        }
    }

    /*  METODI DI STAMPA
    * I seguenti sono dei metodi di stampa, che includono un filtro sugli oggetti presenti 
    * nell'ambiente. Gli oggetti sono filtrati in base al numero della stanza e in base alla 
    * loro visibilit??.
    */

    public static void stampaIngresso(){

        System.out.println("> L'ingresso della casa. Le pareti sembrano cadere a pezzi, il loro colore ?? un bianco sporco che non ti mette a tuo agio.");
        System.out.println("Il tappeto per terra ?? graffiato, forse ?? stata colpa di Ein..");
        System.out.println("Per essere un ingresso, ?? comunque bello grande. Tanti piccoli vasi con fiori di vario genere sono disposti di fianco alla porta.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    public static void stampaSalone(){
        System.out.println("> Il salone ?? grigio e cupo, come lo ?? del resto l'intera casa. Due grandi divani occupano gran parte della stanza.");
        System.out.println("Armadietti, piccole scrivanie e quadri la decorano.");
        System.out.println("Si pu?? salire al piano di sopra grazie alle scale affianco ai divani.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    public static void stampaCucina(){
        System.out.println("> La cucina ?? messa meglio: ordinata, pulita, la spazzatura al proprio posto.. Il sogno di tutti gli universitari fuorisede.");
        System.out.println("L'unico problema ?? l'odore: c'?? puzza nell'intera stanza. Forse qualcosa di ammuffito?");
        System.out.println("La tavola ?? apparecchiata per 2. Un gesto molto carino da parte del custode..<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    public static void stampaVeranda(){
        System.out.println("> La veranda ?? la stanza pi?? illuminata perch?? ?? l'unica nella quale il sole arriva direttamente.");
        System.out.println("Un paio di ruote forate sono appoggiate affianco alla porta.");
        System.out.println("Il tavolino pieno di chiodi, martelli e strumenti di vario genere ?? la principale attrazione della stanza.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    private static void stampaCorridoioLargo(){
        System.out.println("> Il corridoio largo ?? un corridoio molto vivace. Sono presenti dei cavalletti da pittura, delle fotocamere, librerie e strofinacci sporchi.");
        System.out.println("Le crepe sul muro e sul pavimento possono essere viste come decorazioni.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    private static void stampaCorridoioStretto(){
        System.out.println("> Qui dentro non c'?? quasi nulla. Ci sono solo le porte per le altre stanze, un pendolo e un piccolo comodino di fronte al bagno.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    private static void stampaCameraDaLettoSpike(){
        System.out.println("> La tua nuova stanza. ?? cos?? spenta e triste che ti fa venire voglia solo di dormire.");
        System.out.println("Il letto ?? pieno di polvere, e tu ci dovrai dormire sopra.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    private static void stampaCameraDaLettoCustode(){
        System.out.println("> La stanza del custode. Ti sembra strano che non la tenga chiusa a chiave.");
        System.out.println("Il suo letto ?? ordinato, e sulla scrivania ci sono tanti fogli ed un diario.");
        System.out.println("Il muro affianco al letto ha qualcosa che non va..<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    private static void stampaBagno() {
        System.out.println("> Gli angoli di questo bagno sono pieni di muffa. Piccoli ragnetti e formiche qui dentro si godono la vita."); 
        System.out.println("Almeno il gabinetto ?? pulito e, strano ma vero, nella vasca da bagno non c'?? nessuna donna dai capelli neri e lunghi morta.<");
        System.out.println("Noti il lavandino: ci sono delle goccie di .. sangue?<");
        Utilita.stampaOggetti();
    }

    private static void stampaStanzaSegreta(){
        System.out.println("> ?? una stanza con delle luci accecanti bianche. Le pareti sono tinte di colore rosso vermiglio. ?? sangue.");
        System.out.println("Non riesci a credere ai tuoi occhi. Per terra, dei teli bianchi sporcati anch'essi dal sangue.");
        System.out.println("Macchine fotografiche ovunque.. Non osi immaginare cosa sia successo in questa stanza. Il tuo passato ti ?? sconosciuto.<");
        System.out.println("Ci?? che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Utilita.stampaOggetti();
    }

    // Metodo che controlla la stanza corrente. Se ?? una stanza speciale, viene eseguito uno dei casi specifici.
    public static void controllaStanza(){
        Statement stm;
        ResultSet result;

        if(Ambiente.numeroStanzaCorrente == 2){

            try {
                stm= Database.connessioneDB(Utilita.urlNPCs).createStatement();
                result= stm.executeQuery("SELECT * FROM personaggi WHERE nomeNPC ='grigio' AND visibile = FALSE");

                if(result.next()){
                    stm.executeUpdate("UPDATE personaggi SET visibile = TRUE WHERE nomeNPC = 'grigio'");
                    stm.close();
                }
            }catch (SQLException e) {
                System.out.println("Errore nella query.");
            }

        }else {
            try {
                stm= Database.connessioneDB(Utilita.urlNPCs).createStatement();
                result= stm.executeQuery("SELECT * FROM personaggi WHERE nomeNPC ='grigio'");

                if(result.next()){
                    stm.executeUpdate("UPDATE personaggi SET visibile = FALSE WHERE nomeNPC = 'grigio'");
                    stm.close();
                }
            }catch (SQLException e) {
                System.out.println("Errore nella query.");
            }
        }
    }
}