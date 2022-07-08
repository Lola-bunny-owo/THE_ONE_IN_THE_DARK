package com.mycompany.the_one_in_the_dark;

import java.io.InputStreamReader;
import java.util.Scanner;

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
        return inInventario;
    }

    // Raccoglie un oggetto e lo ispeziona. 
    // Ulteriormente, sceglie se inserire l'oggetto nell'inventario o meno.
    public static void raccogliOggetto(String inputUtente) {

        String nuovoInput = inputUtente.substring(inputUtente.indexOf(" ") + 1);
        
        // Controlla che l'oggetto sia presente nel set di oggetti.
        for(int i= 0; i < Oggetti.numeroOggetti.length; i++){

            if(nuovoInput.equals(nomeOggetto[i])){
                Oggetti.oggettoRaccolto = true;

                System.out.println("--------------------------");
                System.out.println("-Hai raccolto un oggetto!-");
                System.out.println("--------------------------");
                System.out.println("NOME: " + nomeOggetto[i]);
                System.out.println("DESCRIZIONE: " + descrizioneOggetto[i]);
                System.out.println("Vuoi inserire questo oggetto nel tuo inventario? (s/n)");
                System.out.print(" --> ");
                Oggetti.sceltaInserimentoInventario(nomeOggetto[i], descrizioneOggetto[i]);
                i= Oggetti.numeroOggetti.length;
            }

        }

        if(Oggetti.oggettoRaccolto == false){
            System.out.println("Non c'è nessun oggetto con questo nome.");
        }
    }

    // Sceglie se inserire l'oggetto o meno nell'inventario.
    public static void sceltaInserimentoInventario(String nomeOggetto, String descrizioneOggetto) {
        Scanner controllaScelta = new Scanner(new InputStreamReader(System.in));
        String inputUtente = "";
        boolean sceltaValida = false;

        while (sceltaValida == false){
            inputUtente = controllaScelta.nextLine();
            if ((inputUtente.equalsIgnoreCase("s"))&&(controllaOggettiInInventario() == true)){
                inserisciOggetto(nomeOggetto, descrizioneOggetto);
                sceltaValida = true;
    
            }else if((inputUtente.equalsIgnoreCase("s"))&&(controllaOggettiInInventario() == false)){
                controllaOggettiInInventario();
                sceltaValida = true;

            }else if(inputUtente.equalsIgnoreCase("n")){
                System.out.println("Non hai inserito l'oggetto " + nomeOggetto+ " nel tuo inventario.");
                sceltaValida = true;
                    
            }else {
                    System.out.println("Hai sbagliato a scrivere? O forse sei solo stupido/a?");
                    
            }
        } 
    }

    // Inserisce un oggetto nell'inventario.
    public static void inserisciOggetto(String nomeOggetto, String descrizioneOggetto) {
        // Inserisce l'oggetto nell'inventario.
        Inventario.numeroOggettiInventario++;
        Inventario.setInventario(nomeOggetto, descrizioneOggetto);
        System.out.println("Hai inserito l'oggetto " + nomeOggetto + " nel tuo inventario!");
        System.out.println("");
        Oggetti.inInventario= true;
        getNumOggettiInInventario();
        Inventario.stampaInventario();
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
        }else{
            System.out.println("Il numero di oggetti nell'inventario è [" + Inventario.numeroOggettiInventario + "] - Puoi ancora inserire oggetti.");
            return Inventario.numeroOggettiInventario;
        }

    }



    
}
