package com.mycompany.the_one_in_the_dark.REST;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.google.gson.Gson;

/**
 * Classe che implementa un'API RESTful necessaria all'avventura testuale.
 * @author Angela Mileti
 */

public class RestOrologio {

    // Implementazione dell'API RESTful per ottenere le informazioni relative all'ora attuale.
    public static RestOrologioResponse getOra(String timezone) {
        Client client = ClientBuilder.newClient();
        Gson gson = new Gson();

        WebTarget target = client.target("https://timeapi.io/api/Time/current/zone?timeZone=" + timezone);
        Response resp = target.queryParam("timezone", timezone)
        .request(MediaType.APPLICATION_JSON).get();

        RestOrologioResponse response = gson.fromJson(resp.readEntity(String.class), RestOrologioResponse.class);
        return response;
    }
    
}
