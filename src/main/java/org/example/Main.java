package org.example;

import org.example.Entities.Address;
import org.example.Entities.Client;
import org.example.Entities.ClientType;
import org.example.Rest.RestAddress;
import org.example.Rest.RestClient;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RestClient restClient = new RestClient();
        RestAddress restAddress = new RestAddress();
        Client client = restClient.getClientById(3);
        Address newAddress = new Address("192.168.44.93", "19-37-40-3-19-18", "Model 223", "Санкт-Петербург, Пушкина, 3");


        System.out.println("Получение клиента по id:");
        System.out.println(client);
        System.out.println();


        client.setClientName("Васечкин Ванька Яковлевич");
        restClient.updateClient(client);
        System.out.println("Получение измененного клиента:");
        System.out.println(restClient.getClientById(3));
        System.out.println();

        Client newClient = new Client();
        newClient.setClientName("Кадышева Арина Викторовна");
        newClient.setType(ClientType.PHYSICAL);
        newClient.setAdded(LocalDate.of(2023, 5, 5));
        newClient.setAddresses(List.of(newAddress));
        restClient.createClient(newClient);

        System.out.println("Получение списка клиентов:");
        List<Client> clients = restClient.getAllClients();
        clients.forEach(System.out::println);
        System.out.println();

        restClient.deleteClientById(6);

        System.out.println("Получение адреса по id:");
        Address address = restAddress.getAddressById(1);
        System.out.println(address);
        System.out.println();


        address.setModel("23444444444");
        address.setIp("192.168.134.173");
        restAddress.updateAddress(address);
        System.out.println("Получение измененного адреса:");
        System.out.println(restAddress.getAddressById(1));
        System.out.println();

        restAddress.createAddress(new Address("155.168.44.93", "19-37-40-3-19-18", "Model 545223", "Санкт-Петербург, Пушкина, 3"));

        restAddress.deleteAddressById(8);

        System.out.println("Получение списка адресов:");
        List<Address> addresses = restAddress.getAllAddresses();
        addresses.forEach(System.out::println);
        System.out.println();
    }
}