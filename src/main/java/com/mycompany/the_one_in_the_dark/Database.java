package com.mycompany.the_one_in_the_dark;

import java.util.Properties;
import java.sql.*;

public class Database {

    public static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS oggetti (nomeOggetto VARCHAR(300), descrizione VARCHAR(300), inseribile BOOLEAN, inInventario BOOLEAN, idOggetto INT, stanza INT)";
    /* METODI SET */

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

    // Set del database - dev'essere fatto una sola volta
    public static void setDatabase(){
        
        try {
            connessioneDB();
            Statement statement= connessioneDB().createStatement();
            statement.executeUpdate(CREATE_TABLE);
            statement.close();
            connessioneDB().close();

        } catch (SQLException e) {
            System.out.println("Errore nella creazione della tabella.");
        }

    }
    
}
