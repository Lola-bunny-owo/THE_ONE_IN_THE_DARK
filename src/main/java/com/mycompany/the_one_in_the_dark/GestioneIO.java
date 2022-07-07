package com.mycompany.the_one_in_the_dark;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author Angela Mileti
 */

public class GestioneIO {
    Scanner gestoreInput = new Scanner(new InputStreamReader(System.in));
    String inputUtente = "";

    // Acquisisce l'input da tastiera

    public void gestisciInputUtente() {

        System.out.println("Aspettando un tuo comando..");
        System.out.println("");
        while (gestoreInput.hasNext()) {

            if (gestoreInput.hasNextInt()) {
                inputUtente = gestoreInput.nextInt() + "";
                Ambiente.acquisisciInputConNumero(inputUtente);
                System.out.println("Aspettando un tuo comando..");

            } else {
                inputUtente = gestoreInput.nextLine();

                if (Ambiente.getNomeAmbiente().equals("Casa")) {
                    Casa.acquisisciInputCasa(inputUtente);

                } else if (Ambiente.getNomeAmbiente().equals("Spiaggia")) {
                    Spiaggia.acquisisciInputSpiaggia(inputUtente);

                } else if (Ambiente.getNomeAmbiente().equals("Stazione di Polizia")) {
                    StazioneDiPolizia.acquisisciInputStazionePolizia(inputUtente);

                } else if (Ambiente.getNomeAmbiente().equals("Biblioteca")) {
                    Biblioteca.acquisisciInputBiblioteca(inputUtente);

                } else if (Ambiente.getNomeAmbiente().equals("Foresta")) {
                    Foresta.acquisisciInputForesta(inputUtente);

                } else if (Ambiente.getNomeAmbiente().equals("Diner")) {
                    Diner.acquisisciInputDiner(inputUtente);
                }

                System.out.println("Aspettando un tuo comando..");
                System.out.println("");
            }
        }

        gestoreInput.close();
    }

    // Set input utente
    public void setInputUtente(String inputUtente) {
        this.inputUtente = inputUtente;
    }

    // Set gestore input
    public void setGestoreInput(Scanner gestoreInput) {
        this.gestoreInput = gestoreInput;
    }
    
    // Get input utente
    public String getInputUtente() {
        return inputUtente;
    }

    // Get gestore input
    public Scanner getGestoreInput() {
        return gestoreInput;
    }

    

}
