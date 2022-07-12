package com.mycompany.the_one_in_the_dark;

import java.sql.*;
import com.mycompany.the_one_in_the_dark.Db.Database;

/**
 * Classe che si occupa dell'inventario dell'utente.
 * @author Angela Mileti
 */

public class Inventario extends Oggetti{
    protected static int numeroOggettiInventario= 0;

    Inventario(){
        super();
    }
    
    // Stampa a schermo gli oggetti presenti nell'inventario.
    public static void stampaInventario(){
        System.out.println("| | | | | | | | | | | | | |");
        System.out.println("         INVENTARIO        ");
        System.out.println("| | | | | | | | | | | | | |");

        if(numeroOggettiInventario == 0){
            System.out.println("Non hai nessun oggetto nel tuo inventario.");
        }else{
            Statement stm;
            ResultSet result;

            try {
                stm = Database.connessioneDB("jdbc:h2:.//src//file//databaseCasa").createStatement();
                result= stm.executeQuery("SELECT * FROM oggetti WHERE inInventario = TRUE");

                while(result.next()){
                    System.out.println("---------------------------------------------");
                    System.out.println("NOME: [" + result.getString("nomeOggetto") + "]");
                    System.out.println("DESCRIZIONE: [" + result.getString("descrizione") + "]");
                }
                System.out.println("---------------------------------------------");
                System.out.println("");

                stm.close();
            } catch (SQLException e) {
                System.out.println("Errore nella query.");
            }
               
        }  
        
    }

}
