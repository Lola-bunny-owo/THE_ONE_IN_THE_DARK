package com.mycompany.the_one_in_the_dark;

public class Inventario extends Oggetti{

    protected static int numeroOggettiInventario= 0;
    protected static String[] nomeOggettiInventario;
    protected static String[] descrizioneOggettiInventario;

    Inventario(){
        super();
    }

    // Stampa a schermo gli oggetti nel proprio inventario
    public static void stampaInventario(){
        System.out.println("| | | | | | | | | | | | | |");
        System.out.println("         INVENTARIO        ");
        System.out.println("| | | | | | | | | | | | | |");

        if(numeroOggettiInventario == 0){
            System.out.println("Non hai nessun oggetto nel tuo inventario.");
        }else{

            for(int i= 0; i< numeroOggettiInventario; i++){
                System.out.println("Oggetto n°[" + i+1 + "]: ");
                System.out.println(" - NOME: " + nomeOggettiInventario[i]);
                System.out.println(" - DESCRIZIONE:" + descrizioneOggettiInventario[i]);
            }
            
        }  
        
    }

    public static void setInventario(){
        
    }

}
