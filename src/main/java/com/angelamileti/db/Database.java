package com.angelamileti.db;

import java.util.Properties;
import com.angelamileti.Utilita;
import java.sql.*;

/**
 * Classe che gestisce la connessione al database. Questa classe permette di definire
 * delle funzioni che vengono ereditate da tutte le altre classi di tipo database.
 * @author Angela Mileti
 */

public class Database {

    // Connessione al database
    public static Connection connessioneDB(String url) {
        Connection connessione = null;
        try {
            Properties proprietadb = new Properties();
            proprietadb.setProperty("user", "Spike");
            proprietadb.setProperty("password", "bebop");
            connessione = DriverManager.getConnection(url, proprietadb);
        } catch (SQLException e) {
            System.out.println("Errore nella connessione al database.");
        }

        return connessione;
    }

    // Set del database - eseguito una unica volta.
    public static void setDatabase(String url){
        
        try {
            Statement statement= connessioneDB(url).createStatement();

            if(url == Utilita.urlCasa){
                statement.executeUpdate(Utilita.CREATE_TABLE_CASA);
            }else if(url == Utilita.urlNPCs){
                statement.executeUpdate(Utilita.CREATE_TABLE_NPCS);
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Errore nella creazione della tabella.");
        }

    }

    // Cancella il database, se questo è pieno.
    public static void cancellaDatabase(String url){
        connessioneDB(url);
        try (Statement statement = connessioneDB(url).createStatement()) {

            if(url == Utilita.urlCasa){
                statement.executeUpdate("DROP TABLE IF EXISTS oggetti");
            }else if(url == Utilita.urlNPCs){
                statement.executeUpdate("DROP TABLE IF EXISTS personaggi");
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Errore nella cancellazione della tabella.");
        }
    }

    
}