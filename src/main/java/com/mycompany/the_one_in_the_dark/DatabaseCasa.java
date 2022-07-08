package com.mycompany.the_one_in_the_dark;
import java.sql.*;

public class DatabaseCasa extends Database {

    /* Set degli oggetti della Casa nel database */

    public static void setOggettiCasa() {

        try {
            
            setDatabase();

            /* INGRESSO */
            PreparedStatement statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Tappeto");
            statementPrep.setString(2, "Un tappeto color porpora.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 1);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vaso");
            statementPrep.setString(2, "Un vaso con diversi fiori bianchi e blu.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 2);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto");
            statementPrep.setString(2, "Un armadio che contiene altri oggetti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 3);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Scarponi");
            statementPrep.setString(2, "Delle scarpe pesanti con delle macchie scure. Sembra essere terra.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 4);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Corda");
            statementPrep.setString(2, "Una corda spessa, bianca e lunga. Potrebbe servire.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 5);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Baule");
            statementPrep.setString(2, "Un baule che vuole essere aperto a tutti i costi.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 6);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Album di foto");
            statementPrep.setString(2, "Un album di foto degli zii e dei loro amici.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 7);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Coniglietto");
            statementPrep.setString(2, "Un peluche di un coniglietto marrone. È vecchio e puzza.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 8);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Lettera");
            statementPrep.setString(2, "Una lettera.. per me?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 9);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Foto");
            statementPrep.setString(2, "Una foto degli zii con dei loro amici. Anche il custode è in questa foto..");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 10);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* SALONE */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Divano");
            statementPrep.setString(2, "Un divano scuro.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 11);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Dipinto");
            statementPrep.setString(2, "Un dipinto del mare al tramonto.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 12);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto");
            statementPrep.setString(2, "Un armadio che contiene altri oggetti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 13);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chiave");
            statementPrep.setString(2, "Una chiave.. ma cosa apre?");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 14);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vestiti femminili");
            statementPrep.setString(2, "Dei vestiti da ragazzina.. Ma che ci fanno qui?");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 15);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Sketchbook");
            statementPrep.setString(2, "Lo sketchbook di qualcuno. Forse dello zio?");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 16);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* CUCINA */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Tavolo");
            statementPrep.setString(2, "Un comune tavolo da pranzo.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 17);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Coltello");
            statementPrep.setString(2, "Un coltello dal manico spesso e dalla punta affilata. Fa paura.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 18);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Posateria");
            statementPrep.setString(2, "Una posateria con delle posate che sono state posate da qualcuno.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 19);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Forno");
            statementPrep.setString(2, "Un forno per cuocere il cosidetto cibo.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 20);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto da cuina");
            statementPrep.setString(2, "Un armadietto da cucina.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 21);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Piatti");
            statementPrep.setString(2, "Dei piatti, solitamente usati per mangiare. Lol.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 22);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Dito sottovuoto");
            statementPrep.setString(2, "Ma questo è... è un dito?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 23);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            /* VERANDA */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Piede di porco");
            statementPrep.setString(2, "Un piede di porco di colore giallo. Sembra utile.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 24);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Sparachiodi");
            statementPrep.setString(2, "Una sparachiodi. Evidentemente il custode ha la passione del bricolage.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 25);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chiodi");
            statementPrep.setString(2, "Dei piccoli chiodi.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 26);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Ombrello");
            statementPrep.setString(2, "Un ombrello grigio. È ancora bagnato.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 27);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Cestino");
            statementPrep.setString(2, "Un cestino vuoto. Sembra ci sia qualcosa al suo interno..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 28);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Accendino");
            statementPrep.setString(2, "Un accendino. È scarico.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 29);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            /* CORRIDOIO LARGO */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica");
            statementPrep.setString(2, "Una macchina fotografica. Al suo interno ci sono delle foto.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 30);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Libreria");
            statementPrep.setString(2, "Una libreria. Ci sono tanti libri al suo interno.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 31);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Romeo e Giulietta");
            statementPrep.setString(2, "Un libro di William Shakespeare.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 32);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Orgoglio e Pregiudizio");
            statementPrep.setString(2, "Un libro di Jane Austen.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 33);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Le migliori barzellette di Totti");
            statementPrep.setString(2, "Un libro inutile.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 34);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Manichino");
            statementPrep.setString(2, "Un manichino di legno. È macchiato.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 35);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* CORRIDOIO STRETTO */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Tavolo sospetto");
            statementPrep.setString(2, "Un tavolo alquanto sospetto.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 36);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Orologio a pendolo");
            statementPrep.setString(2, "Un vecchio orologio a pendolo. Dice l'ora.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 37);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Comodino piccolino");
            statementPrep.setString(2, "Un comodino con un posacenere. Il custode fuma?");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 38);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* CAMERA DA LETTO DI SPIKE */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadio");
            statementPrep.setString(2, "Un armadio nel quale inserire dei vestiti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 39);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Scrivania");
            statementPrep.setString(2, "Una scrivania mal ridotta, con delle penne e dei fogli bianchi.	");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 40);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Letto");
            statementPrep.setString(2, "Il tuo letto impolverato. È assurdo quanto faccia schifo..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 41);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chitarra acustica");
            statementPrep.setString(2, "Una chitarra acustica. Era sicuramente della zia..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 42);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* CAMERA DA LETTO DEL CUSTODE */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Diario");
            statementPrep.setString(2, "Il diario del custode. Contiene tanti appunti e sicuramente segreti.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 43);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Motosega");
            statementPrep.setString(2, "Una motosega rossa. Ma perché nella sua stanza?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 44);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Ventilatore");
            statementPrep.setString(2, "Un ventilatore grigio. Quanto vorrei averti tutto per me..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 45);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Muro");
            statementPrep.setString(2, "Il muro sembra strano.. È un passaggio segreto! - serve inserire un codice d'accesso.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 46);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* BAGNO */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vasca");
            statementPrep.setString(2, "Una vasca da bagno grigia.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 47);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Water");
            statementPrep.setString(2, "Una motosega rossa. Ma perché nella sua stanza?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 48);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Specchio");
            statementPrep.setString(2, "Uno specchio che sembra stufo di specchiare le persone.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 49);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            /* STANZA SEGRETA */
            statementPrep = connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica n#1");
            statementPrep.setString(2, "Una macchina fotografica piena di foto e video.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 50);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica n#2");
            statementPrep.setString(2, "Una macchina fotografica semi-piena.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 51);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Siringa");
            statementPrep.setString(2, "Una siringa usata...Cosa è successo..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 52);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep= connessioneDB().prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Pillole");
            statementPrep.setString(2, "Dei contenitori con delle pillole di vario tipo. Stilnox, Xanax, ..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 53);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.executeUpdate();

            statementPrep.close();

        } catch (SQLException e) {
            System.out.println("Errore nell'inserimento dei dati");
        }
        
    }

}
