package com.angelamileti.Db;

import java.sql.*;

import com.angelamileti.Utilita;

/**
 * Classe che si occupa di popolare la tabella del database con i dati dei personaggi.
 * @author Angela Mileti
 */

public class DatabaseNPCs extends Database {
    
    /* Set dei personaggi nel database */

    public static void setPersonaggi() {

        try {
            setDatabase(Utilita.urlNPCs);
            PreparedStatement statementPrep = connessioneDB(Utilita.urlNPCs).prepareStatement("INSERT INTO personaggi VALUES (?,?,?)");

            /* IL GRIGIO */
            statementPrep= connessioneDB(Utilita.urlNPCs).prepareStatement("INSERT INTO personaggi VALUES (?,?,?)");
            statementPrep.setString(1, "Grigio");
            statementPrep.setString(2, "'Il Grigio' è un signore barbuto dall'aspetto cupo ed è il custode della tua nuova casa.\n"
            + "Da quello che hai potuto vedere, non è una persona che dà molta confidenza agli sconosciuti. Tu non fai eccezione alla regola.\n"
            + "Il suo sguardo pungente farebbe rabbrividire anche il peggior serial killer. A quanto pare ha problemi con la memoria.\n"
            + "C'è qualcosa che nasconde..");
            statementPrep.setBoolean(3, false);
            statementPrep.executeUpdate();

            /* EIN */
            statementPrep= connessioneDB(Utilita.urlNPCs).prepareStatement("INSERT INTO personaggi VALUES (?,?,?)");
            statementPrep.setString(1, "Ein");
            statementPrep.setString(2, "Ein è un simpatico cagnolino del colore del sole, e a quanto pare, ha scelto di seguirti.\n"
            + "Grazie al suo carattere vivace e al contempo dolce, sa come tirarti sù quando le cose vanno per il peggio.\n"
            + "Il suo dolcetto preferito sono delle gomme da masticare al caffè. È meglio non viziarlo!");
            statementPrep.setBoolean(3, true);
            statementPrep.executeUpdate();

            // Presto, nuovi personaggi :).

            statementPrep.close();

        } catch (SQLException e) {
            System.out.println("Errore nell'inserimento dei dati");
        }
        
    }

}
