package com.mycompany.the_one_in_the_dark;

import java.util.Properties;
import java.sql.*;

public class Database {

    // Connessione al database
    public static Connection connessioneDB() {
        Connection connessione = null;

        try {
            Properties proprietadb = new Properties();
            proprietadb.setProperty("user", "Spike");
            proprietadb.setProperty("password", "bebop");
            connessione = DriverManager.getConnection("jdbc:h2:.//src//file//database", proprietadb);
        } catch (SQLException e) {
            System.out.println("Errore nella connessione al database.");
        }

        return connessione;
    }

    // Set del database - eseguito una unica volta.
    public static void setDatabase(){
        
        try {
            Statement statement= connessioneDB().createStatement();
            statement.executeUpdate(Utilita.CREATE_TABLE);
            statement.close();

        } catch (SQLException e) {
            System.out.println("Errore nella creazione della tabella.");
        }

    }

    // Cancella il database, se questo è pieno.
    public static void cancellaDatabase(){
        connessioneDB();
        try (Statement statement = connessioneDB().createStatement()) {
            statement.executeUpdate("TRUNCATE TABLE oggetti");
            statement.close();
        } catch (SQLException e) {
            System.out.println("Errore nella cancellazione della tabella.");
        }
    }

    
}
