package com.smsMagic.UserClientApi.service;

import com.smsMagic.UserClientApi.entity.Client;
import com.smsMagic.UserClientApi.exception.ResourceNotFoundException;
import com.smsMagic.UserClientApi.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
    }

    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    public Client updateClient(Long id, Client clientDetails) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));

        // Update the client details
        client.setName(clientDetails.getName());
        client.setUser(clientDetails.getUser());
        client.setCompany(clientDetails.getCompany());
        client.setEmail(clientDetails.getEmail());
        client.setPhone(clientDetails.getPhone());

        return clientRepository.save(client);
    }

    public void deleteClient(Long id) {
        Client client = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
        clientRepository.delete(client);
    }
}
