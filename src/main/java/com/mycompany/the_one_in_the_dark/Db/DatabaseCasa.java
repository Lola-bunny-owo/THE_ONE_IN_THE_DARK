package com.mycompany.the_one_in_the_dark.Db;

import java.sql.*;

import com.mycompany.the_one_in_the_dark.Utilita;

/**
 * Classe che si occupa di popolare la tabella del database con i dati degli oggetti.
 * @author Angela Mileti
 */

public class DatabaseCasa extends Database {
    
    /* Set degli oggetti della Casa nel database */

    public static void setOggettiCasa() {

        try {
            setDatabase(Utilita.urlCasa);
            PreparedStatement statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            
            /* INGRESSO */
            statementPrep.setString(1, "Tappeto");
            statementPrep.setString(2, "Un tappeto color porpora.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 1);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti chini sul tappeto per guardarlo più da vicino. Sì, è proprio graffiato.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vaso");
            statementPrep.setString(2, "Un vaso con diversi fiori bianchi e blu.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 2);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Scarponi");
            statementPrep.setString(2, "Delle scarpe pesanti con delle macchie scure. Sembra essere terra.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 3);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Usi gli scarponi. Che puzza! Ew. Te li togli subito.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Corda");
            statementPrep.setString(2, "Una corda spessa, bianca e lunga. Potrebbe servire.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 4);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Usi la corda per disegnare a terra un serpente bianco. Ridi di gusto e ti senti stupido.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto");
            statementPrep.setString(2, "Un armadio che contiene altri oggetti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 5);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri l'armadietto e ci trovi.. degli Scarponi e una Corda."); 
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Album di foto");
            statementPrep.setString(2, "Un album di foto degli zii e dei loro amici.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 6);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri l'album delle foto. Che carini, erano così giovani.. Ti mancano tanto.\nTra i loro amici non riconosci nessuno. Però, noti che gli zii non hanno una bella cera.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Coniglietto");
            statementPrep.setString(2, "Un peluche di un coniglietto marrone. È vecchio e puzza.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 7);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Lettera");
            statementPrep.setString(2, "Una lettera.. per me?!");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 8);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Leggi la lettera. Dice: 'Caro nipote mio, se stai leggendo questo vuol dire che hai deciso di farci visita."
            + " Sai, ho notato che sei un ragazzino astuto per avere solo 10 anni. Sai anche mantenere dei segreti."
            + " Adesso devo chiederti di mantenere un mio segreto.. Io e tua zia siamo nei guai. Tu ti fidi di me, vero?"
            + " ..ho fatto cose di cui non vado molto fiero, ma... non so.. Non so se ce la faremo, presto finirà tutto. - zio Alan'"
            + "\nMa cosa può aver fatto lo zio?.. Sei molto confuso.");
            
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Baule");
            statementPrep.setString(2, "Un baule che vuole essere aperto a tutti i costi.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 9);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri il baule. Al suo interno ci trovi.. Un Album di foto, un Coniglietto ed una Lettera.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Foto");
            statementPrep.setString(2, "Una foto degli zii con dei loro amici. Anche il custode è in questa foto..");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 10);
            statementPrep.setInt(6, 1);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();
        
            /* SALONE */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Divano");
            statementPrep.setString(2, "Un divano scuro.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 11);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti sdrai sul divano per prenderti qualche minuto di pausa. Il custode è lì, sdraiato di fronte a te. Dorme rumorosamente.\n"
            + "Forse è meglio tornare ad indagare.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Dipinto");
            statementPrep.setString(2, "Un dipinto del mare al tramonto. È leggermente inclinato.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 12);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Incuriosito dall'inclinazione del dipinto, decidi di alzarlo leggermente e.. niente.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chiave");
            statementPrep.setString(2, "Una chiave.. ma cosa apre?");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 13);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Usi la chiave per aprire l'armadietto da cucina.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vestiti femminili");
            statementPrep.setString(2, "Dei vestiti da ragazzina.. Wtf. Che ci fanno qui questi vestiti?");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 14);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto");
            statementPrep.setString(2, "Un armadio che contiene altri oggetti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 15);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri l'armadietto e ci trovi.. Una Chiave e dei Vestiti femminili.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Sketchbook");
            statementPrep.setString(2, "Lo sketchbook di qualcuno. Forse dello zio?");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 16);
            statementPrep.setInt(6, 2);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Pagine, pagine.. Pagine bianche. Eppure dovrebbe essere uno sketchbook.\n"
            + "..Gli occhi di una donna. No, di una bambina che piange. 'Lola'. Non c'è nient'altro. C'è altro che non so?");
            statementPrep.executeUpdate();

            /* CUCINA */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Tavolo");
            statementPrep.setString(2, "Un comune tavolo da pranzo.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 17);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Coltello");
            statementPrep.setString(2, "Un coltello dal manico spesso e dalla punta affilata. Fa paura.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 18);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Usi il coltello per forzare l'armadietto da cucina. Non si apre.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Posateria");
            statementPrep.setString(2, "Una posateria con delle posate che sono state posate da qualcuno.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 19);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Forno");
            statementPrep.setString(2, "Un forno per cuocere il cosidetto cibo.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 20);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Vorresti usare il forno? Con questo caldo? .. Pazzo. Inizi a pensare che forse non è una buona idea.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Piatti");
            statementPrep.setString(2, "Dei piatti, solitamente usati per mangiare. Lol.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 21);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Dito sottovuoto");
            statementPrep.setString(2, "Ma questo è... è un dito?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 22);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadietto da cuina");
            statementPrep.setString(2, "Un armadietto da cucina. Richiede una chiave per essere aperto.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 23);
            statementPrep.setInt(6, 3);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri l'armadietto. Quasi ti viene da vomitare. Ci trovi dei piatti e.. un Dito sottovuoto.");
            statementPrep.executeUpdate();

            /* VERANDA */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Piede di porco");
            statementPrep.setString(2, "Un piede di porco di colore giallo. Sembra utile.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 24);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Usi il piede di porco per ???");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Sparachiodi");
            statementPrep.setString(2, "Una sparachiodi. Evidentemente il custode ha la passione del bricolage.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 25);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chiodi");
            statementPrep.setString(2, "Dei piccoli chiodi.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 26);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Ombrello");
            statementPrep.setString(2, "Un ombrello grigio. È ancora bagnato.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 27);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Apri l'ombrello ma la pioggia non sembra voler arrivare. La cosa ti scoccia.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Cestino");
            statementPrep.setString(2, "Un cestino vuoto. Sembra ci sia qualcosa al suo interno..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 28);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "All'interno del cestino ci trovi un Accendino.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Accendino");
            statementPrep.setString(2, "Un accendino. È scarico.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 29);
            statementPrep.setInt(6, 4);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Non puoi usare l'accendino, perché è scarico.");
            statementPrep.executeUpdate();

            /* CORRIDOIO LARGO */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica");
            statementPrep.setString(2, "Una macchina fotografica Casio QV-10. Al suo interno ci sono delle foto.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 30);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Guardi le foto sulla macchina. Fiori, la spiaggia, zia Felicia e zio Alan.. le altre foto risultano 'danneggiate'.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Romeo e Giulietta");
            statementPrep.setString(2, "Un libro di William Shakespeare.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 31);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "'Vedi come appoggia la guancia sulla mano? Oh, foss’io il guanto su quella mano e sentire la sua guancia!'");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Orgoglio e Pregiudizio");
            statementPrep.setString(2, "Un libro di Jane Austen.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 32);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "'E il vostro difetto è la propensione a odiare il prossimo' disse Elizabeth.\n"
            + "'E il vostro', disse Darcy con un sorriso, 'è di ostinarsi a fraintenderlo.'");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Le migliori barzellette di Totti");
            statementPrep.setString(2, "Un libro inutile.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 33);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, false);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ma davvero?");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Libreria");
            statementPrep.setString(2, "Una libreria. Ci sono tanti libri al suo interno.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 34);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "La libreria mette in evidenza tre libri: 'Romeo e Giulietta', 'Orgoglio e Pregiudizio' e per finire 'Le migliori barzellette di Totti'.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Manichino");
            statementPrep.setString(2, "Un manichino di legno. È macchiato.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 35);
            statementPrep.setInt(6, 5);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            /* CORRIDOIO STRETTO */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Tavolo sospetto");
            statementPrep.setString(2, "Un tavolo alquanto sospetto.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 36);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Orologio a pendolo");
            statementPrep.setString(2, "Un vecchio orologio a pendolo. Dice l'ora.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 37);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti avvicini all'orologio a pendolo.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Comodino");
            statementPrep.setString(2, "Un comodino piccolino con un posacenere. Il custode fuma?");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 38);
            statementPrep.setInt(6, 6);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            /* CAMERA DA LETTO DI SPIKE */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Armadio");
            statementPrep.setString(2, "Un armadio nel quale inserire dei vestiti.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 39);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Scrivania");
            statementPrep.setString(2, "Una scrivania mal ridotta, con delle penne e dei fogli bianchi.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 40);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti siedi alla scrivania. La sedia è molto scomoda, però ti devi accontentare. Se vuoi scoprire cosa è successo, questo è il minimo.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Letto");
            statementPrep.setString(2, "Il tuo letto impolverato. È assurdo quanto faccia schifo..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 41);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti tuffi sul letto nonostante la polvere. Provi il brivido del rischio. Etchiù.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Chitarra");
            statementPrep.setString(2, "Una chitarra acustica. Era sicuramente della zia..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 42);
            statementPrep.setInt(6, 7);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Era da un sacco che non mettevi le mani su una chitarra. Ti dai una possibilità."); //creep
            statementPrep.executeUpdate();

            /* CAMERA DA LETTO DEL CUSTODE */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Diario");
            statementPrep.setString(2, "Il diario del custode. Contiene tanti appunti e sicuramente segreti.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 43);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Leggi il diario, anche se forse non dovresti ficcare il naso in cose che non ti appartengono.\n"
            + "In realtà te ne freghi, perché hai bisogno di scoprire di più... 'Felicia.. l'unica cosa che ormai ricordo"
            + "è il tuo sorriso.. mi manchi. Il tuo nipotino Spike tra qualche giorno mi farà visita. Io lo aspetto.' ..Il custode e la zia?!");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Motosega");
            statementPrep.setString(2, "Una motosega rossa. Ma perché nella sua stanza?!");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 44);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti piacerebbe provarla, ma ti sembra troppo da serial killer.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Ventilatore");
            statementPrep.setString(2, "Un ventilatore grigio. Quanto vorrei averti tutto per me..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 45);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Fruuu fruuuu fruuuuuuuuuuuuu.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Giornale n#1");
            statementPrep.setString(2, "Un giornale vecchio.. Datato 25 Agosto 1975. Risale a 20 anni fa.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 46);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Leggi il giornale: 'Oggi, in prima pagina: il caso Felicia Thompson e Alan Thompson - i due cittadini"
            + "\nsono stati trovati morti suicidi. L'intera cittadina di Awhell è sconvolta e triste per le perdite.\n"
            + "Non molto si è ancora saputo sulla vicenda, ma a quanto pare è stata ritrovata una lettera da parte del signor Thompson.'"
            + "\n.. Ma gli zii non erano morti in un incidente?! I tuoi ti hanno mentito?..");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Giornale n#2");
            statementPrep.setString(2, "Un altro giornale vecchio.. Datato 11 Agosto 1975.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 47);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Leggi il giornale: 'Di nuovo disperazione e sconforto nella triste Awhell: un'altra ragazzina scomparsa."
            + "\nLa polizia sta facendo il possibile, ma per ora non ci sono stati progressi dall'ultima scomparsa. Il nome ed il volto sono stati"
            + "della ragazzina sono stati volutamente nascosti, anche se l'intera città sa tutto.'"
            + "\n .. Hai un orribile, orribile e disgustoso presentimento.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Muro");
            statementPrep.setString(2, "Il muro sembra strano..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 48);
            statementPrep.setInt(6, 8);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Tasti il muro ovunque, e senti sotto le dita che quel muro non è davvero un muro."
            + " Provi a tirare, e funziona: ciò che hai tirato era un pomello di una porta, che porta ad un'altra stanza."
            + "In pratica, è un passaggio segreto..");
            statementPrep.executeUpdate();
            
            /* BAGNO */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Vasca");
            statementPrep.setString(2, "Una vasca da bagno grigia. È attaccata al muro.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 49);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti fai un bel bagno caldo, per riordinarti i pensieri. Cosa cazzo è successo 20 anni fa?");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Water");
            statementPrep.setString(2, "Un gabinetto utilizzato per fare i propri bisogni oppure.. lo sappiamo tutti. Duh.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 50);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, ".. Non c'è bisogno di descrivere cosa fai al gabinetto, non interessa a nessuno!");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Specchio");
            statementPrep.setString(2, "Uno specchio che sembra stufo di specchiare le persone.");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 51);
            statementPrep.setInt(6, 9);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Ti guardi. Hai un aspetto orribile, e non è una novità.");
            statementPrep.executeUpdate();
            
            /* STANZA SEGRETA */
            statementPrep = connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica n#1");
            statementPrep.setString(2, "Una macchina fotografica piena di foto e video.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 52);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "Controlli il contenuto della macchina.. Ci sono delle foto. Foto di ragazzine."
            + "Sono sorridenti, felici, tranquille. Noti in ogni video e foto un mazzetto di soldi."
            + "Forse si facevano pagare per farsi riprendere?.. Ma, perché..?");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Macchina fotografica n#2");
            statementPrep.setString(2, "Una macchina fotografica semi-piena.");
            statementPrep.setBoolean(3, true);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 53);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, true);
            statementPrep.setString(9, "In questa macchina ci sono foto e video.. ripugnanti."
            + " Lividi, luci rosse e nudità. Ti viene da vomitare.. il voler indagare sul tuo passato ha portato a galla"
            + "molte più vicende di quanto pensassi. Ti sale il panico. Il custode chiaramente sa tutto. Hai bisogno di scoprire di più.");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Siringa");
            statementPrep.setString(2, "Una siringa usata..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 54);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep= connessioneDB(Utilita.urlCasa).prepareStatement("INSERT INTO oggetti VALUES (?,?,?,?,?,?,?,?,?)");
            statementPrep.setString(1, "Pillole");
            statementPrep.setString(2, "Dei contenitori con delle pillole di vario tipo. Stilnox, Xanax, ..");
            statementPrep.setBoolean(3, false);
            statementPrep.setBoolean(4, false);
            statementPrep.setInt(5, 55);
            statementPrep.setInt(6, 10);
            statementPrep.setBoolean(7, true);
            statementPrep.setBoolean(8, false);
            statementPrep.setString(9, "");
            statementPrep.executeUpdate();

            statementPrep.close();

        } catch (SQLException e) {
            System.out.println("Errore nell'inserimento dei dati");
        }
        
    }

}
