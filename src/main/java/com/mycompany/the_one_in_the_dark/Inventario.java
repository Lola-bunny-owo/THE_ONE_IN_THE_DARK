package com.mycompany.the_one_in_the_dark;

import java.sql.*;

public class Inventario extends Oggetti{

    protected static int numeroOggettiInventario= 0;

    Inventario(){
        super();
    }

    public static void main(String[] args) {
        
    }

    // Stampa a schermo gli oggetti nel proprio inventario
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
                stm = Database.connessioneDB().createStatement();
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

    public static void setInventario(String nomeOggetto, String descrizioneOggetto){
        // TO-DO: inserire l'oggetto nel inventario
    }

}
