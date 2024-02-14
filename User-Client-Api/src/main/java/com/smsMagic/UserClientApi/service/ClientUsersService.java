package com.smsMagic.UserClientApi.service;

import com.smsMagic.UserClientApi.entity.ClientUsers;
import com.smsMagic.UserClientApi.exception.ResourceNotFoundException;
import com.smsMagic.UserClientApi.Repository.ClientUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClientUsersService {

    private final ClientUsersRepository clientUsersRepository;

    @Autowired
    public ClientUsersService(ClientUsersRepository clientUsersRepository) {
        this.clientUsersRepository = clientUsersRepository;
    }

    public List<ClientUsers> getAllClientUsers() {
        return clientUsersRepository.findAll();
    }

    public ClientUsers getClientUserById(Long id) {
        return clientUsersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClientUsers", "id", id));
    }

    public ClientUsers createClientUser(ClientUsers clientUsers) {
        clientUsers.setCreatedAt(LocalDateTime.now());
        return clientUsersRepository.save(clientUsers);
    }

    public ClientUsers updateClientUser(Long id, ClientUsers clientUsersDetails) {
        ClientUsers clientUsers = clientUsersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClientUsers", "id", id));

        // Update the clientUsers details
        clientUsers.setClient(clientUsersDetails.getClient());
        clientUsers.setUser(clientUsersDetails.getUser());
        clientUsers.setUpdatedAt(LocalDateTime.now());
        clientUsers.setDeletedAt(clientUsersDetails.getDeletedAt());
        clientUsers.setActive(clientUsersDetails.isActive());

        return clientUsersRepository.save(clientUsers);
    }

    public void deleteClientUser(Long id) {
        ClientUsers clientUsers = clientUsersRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ClientUsers", "id", id));
        clientUsersRepository.delete(clientUsers);
    }
}

