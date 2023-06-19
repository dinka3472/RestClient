package org.example.Rest;

import org.example.Entities.Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.List;


public class RestClient {
    private final javax.ws.rs.client.Client client = ClientBuilder.newClient();
    private final String URL = "http://localhost:8080/labServlet-1.0-SNAPSHOT/api/clients";

    public List<Client> getAllClients(){
        try {
            return client.target(URL).request(MediaType.APPLICATION_JSON).get(new GenericType<List<Client>>(){});
        } catch (ClientErrorException e) {
            int statusCode = e.getResponse().getStatus();
            String errorMessage = e.getResponse().readEntity(String.class);
            System.out.println("Ошибка при получении адреса. Код ошибки: " + statusCode);
            System.out.println("Сообщение об ошибке: " + errorMessage);
        }
        return null;
    }

    public Client getClientById(Integer id) {
        try {
            return client.target(URI.create(URL + "/" + id)).request(MediaType.APPLICATION_JSON).get(Client.class);
        } catch (ClientErrorException e) {
            printErrorMessage(e);
        }
        return null;
    }

    public void updateClient(Client client){
        try {
            this.client.target(URL).request().put(Entity.entity(client, MediaType.APPLICATION_JSON));
        } catch (ClientErrorException e) {
            printErrorMessage(e);
        }

    }

    public void deleteClientById(Integer id) {
        try {
            client.target(URI.create(URL + "/" + id)).request().delete();
        } catch (ClientErrorException e) {
            printErrorMessage(e);
        }

    }

    public void createClient(Client client) {
        try {
            this.client.target(URL).request().post(Entity.entity(client, MediaType.APPLICATION_JSON));
        } catch (ClientErrorException e) {
            printErrorMessage(e);
        }

    }
    private void printErrorMessage(ClientErrorException e) {
        int statusCode = e.getResponse().getStatus();
        String errorMessage = e.getResponse().readEntity(String.class);
        System.out.println("Ошибка при получении адреса. Код ошибки: " + statusCode);
        System.out.println("Сообщение об ошибке: " + errorMessage);
    }

}
