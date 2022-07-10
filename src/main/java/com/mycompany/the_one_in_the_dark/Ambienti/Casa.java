package com.mycompany.the_one_in_the_dark.Ambienti;
import com.mycompany.the_one_in_the_dark.Oggetti;
import com.mycompany.the_one_in_the_dark.Utilita;
import com.mycompany.the_one_in_the_dark.Db.DatabaseCasa;

/**
 *
 * @author Angela Mileti
 */

public class Casa extends Ambiente {
    /**
     * @param args
     */

    static boolean setOggettiCasa= false;

    public static void setCasa() throws InterruptedException {
        
        // Set del nome dell'ambiente e del numero delle stanze.
        Ambiente.setNomeAmbiente("Casa");
        Ambiente.setNumeroStanze(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });

        // Set dei nomi delle stanze
        Ambiente.setNomiStanze(new String[] { "Ingresso", "Salone", "Cucina",  "Veranda", "Corridoio largo", "Corridoio stretto", "Camera da letto di Spike", "Camera da letto del custode", "Bagno", "Stanza segreta"});

        // Set numero della stanza corrente e del nome della stanza corrente
        Ambiente.setNumeroStanzaCorrente(numeroStanze[0]);
        Ambiente.setNomeStanzaCorrente("Ingresso");

        // Set degli oggetti presenti nella casa
        if(!setOggettiCasa){
            DatabaseCasa.setOggettiCasa();
            setOggettiCasa= true;
        }

    }

    // Acquisisce l'input dell'utente, il quale vuole spostarsi tra le stanze dell'ambiente.
    public static void acquisisciInputCasa(String inputUtente){
        if((inputUtente.equalsIgnoreCase("vai a destra"))||(inputUtente.equalsIgnoreCase("destra"))){

            if(getNumeroStanzaCorrente() == 1){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 7){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 8){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 10){
                decrementoStanza();
                stampaStanzaCorrente();
            }else{
                System.out.println("Non puoi andare a destra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai a sinistra"))||(inputUtente.equalsIgnoreCase("sinistra"))){
                
            if(getNumeroStanzaCorrente() == 2){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 5){
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 6){
                // Va di defalut nella propria stanza.
                incrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                incrementoStanza();
                stampaStanzaCorrente();
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
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 3){
                System.out.println("Non puoi andare sopra dalla cucina.");
            }else if(getNumeroStanzaCorrente() == 4){
                System.out.println("Non puoi andare sopra dalla veranda.");
            }else{
                System.out.println("Sei già sopra.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai giù"))||(inputUtente.equalsIgnoreCase("giù"))){
                
            if(getNumeroStanzaCorrente() == 5){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
            }else if(getNumeroStanzaCorrente() == 6){
                System.out.println("Non puoi andare giù dal corridoio stretto.");
            }else if(getNumeroStanzaCorrente() == 7){
                System.out.println("Non puoi andare giù dalla tua stanza.");
            }else if(getNumeroStanzaCorrente() == 8){
                System.out.println("Non puoi andare giù dalla stanza del custode.");
            }else if(getNumeroStanzaCorrente() == 9){
                System.out.println("Non puoi andare giù dal bagno.");
            }else if(getNumeroStanzaCorrente() == 10){
                System.out.println("Non puoi andare giù dalla stanza segreta.");
            }else{
                System.out.println("Sei già sotto.");
            }

        }else if((inputUtente.equalsIgnoreCase("vai avanti"))||(inputUtente.equalsIgnoreCase("avanti"))){
                    
                if(getNumeroStanzaCorrente() == 1){
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 3){
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 6){
                    incrementoStanza();
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else if(getNumeroStanzaCorrente() == 8){
                    incrementoStanza();
                    incrementoStanza();
                    stampaStanzaCorrente();
                }else{
                    System.out.println("Non puoi andare avanti.");
                }

        }else if((inputUtente.equalsIgnoreCase("vai indietro"))||(inputUtente.equalsIgnoreCase("indietro"))){
                
            if(getNumeroStanzaCorrente() == 3){
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 4){
                decrementoStanza();
                stampaStanzaCorrente();
            }else if(getNumeroStanzaCorrente() == 9){
                decrementoStanza();
                decrementoStanza();
                decrementoStanza();
                stampaStanzaCorrente();
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
            Utilita.acquisisciInputComando(inputUtente);
        }
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

    // Sono dei metodi di stampa, che includono un filtro sugli oggetti presenti nella stanza.
    // Gli oggetti sono filtrati in base al numero della stanza e in base alla loro visibilità.

    public static void stampaIngresso(){

        System.out.println("> L'ingresso della casa. Le pareti sembrano cadere a pezzi, il loro colore è un bianco sporco che non ti mette a tuo agio.");
        System.out.println("Il tappeto per terra è graffiato, quindi forse in questa casa ci sono stati dei gatti. O chissà..");
        System.out.println("Per essere un ingresso, è comunque bello grande. Tanti piccoli vasi con fiori di vario genere sono disposti di fianco alla porta.<");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    public static void stampaSalone(){
        System.out.println("> Il salone è grigio e cupo, come lo è del resto l'intera casa. Due grandi divani occupano gran parte della stanza.");
        System.out.println("Armadietti, piccole scrivanie e quadri la decorano.");
        System.out.println("Si può salire al piano grazie alle scale affianco ai divani.<");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    public static void stampaCucina(){
        System.out.println("> La cucina è messa meglio: ordinata, pulita, la spazzatura al proprio posto.. Il sogno di tutti gli universitari fuorisede.");
        System.out.println("Un dolce odore di pancake ti fa venire l'acquolina in bocca. Il custode sa cucinare?");
        System.out.println("La tavola è apparecchiata per 2. Ma quante altre persone vivono in questa casa?<");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    public static void stampaVeranda(){
        System.out.println("> La veranda è la stanza più illuminata perché è l'unica nella quale il sole arriva direttamente.");
        System.out.println("Un paio di ruote forate sono appoggiate affianco alla porta.");
        System.out.println("Il tavolino pieno di chiodi, martelli e strumenti di vario genere è la principale attrazione della stanza.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    private static void stampaCorridoioLargo(){
        System.out.println("> Il corridoio largo è un corridoio molto vivace. Sono presenti dei cavalletti da pittura, delle fotocamere, librerie e strofinacci sporchi.");
        System.out.println("Le crepe sul muro e sul pavimento rendono però tutto quanto abbastanza inquietante.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    private static void stampaCorridoioStretto(){
        System.out.println("> Qui dentro non c'è quasi nulla. Ci sono solo le porte per le altre stanze, e un piccolo comodino di fronte al bagno.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    private static void stampaCameraDaLettoSpike(){
        System.out.println("> La tua nuova stanza. È così spenta e triste che ti fa venire voglia solo di dormire.");
        System.out.println("Il letto è pieno di polvere, e tu ci dovrai dormire sopra.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    private static void stampaCameraDaLettoCustode(){
        System.out.println("> La stanza del custode. Ti sembra strano che non la tenga chiusa a chiave.");
        System.out.println("Il suo letto è ordinato, e sulla scrivania ci sono tanti fogli ed un diario.");
        System.out.println("Il muro affianco al letto ha qualcosa che non va.. È un passaggio per un'altra stanza.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

    private static void stampaBagno() {
        System.out.println("> Gli angoli di questo bagno sono pieni di muffa. Piccoli ragnetti e formiche qui dentro si godono la vita."); 
        System.out.println("Almeno il gabinetto è pulito e, strano ma vero, nella vasca da bagno non c'è nessuna donna dai capelli neri e lunghi morta.");
        System.out.println("Noti il lavandino: ci sono delle goccie di sangue..");
        Oggetti.stampaOggetti();
    }

    private static void stampaStanzaSegreta(){
        System.out.println("> È una stanza con delle luci accecanti bianche. Le pareti sono tinte di un colore rosso vermiglio. È sangue.");
        System.out.println("Non riesci a credere ai tuoi occhi. Per terra, dei teli bianchi sporcati anch'essi dal sangue.");
        System.out.println("Macchine fotografiche ovunque.. Non osi immaginare cosa sia successo in questa stanza. Il tuo passato ti è sconosciuto.");
        System.out.println("Ciò che salta subito all'occhio in questa stanza sono i seguenti oggetti:");
        Oggetti.stampaOggetti();
    }

}