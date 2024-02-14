package com.smsMagic.UserClientApi.Controller;

import com.smsMagic.UserClientApi.entity.ClientUsers;
import com.smsMagic.UserClientApi.service.ClientUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientUsers")
public class ClientUsersController {

    private final ClientUsersService clientUsersService;

    @Autowired
    public ClientUsersController(ClientUsersService clientUsersService) {
        this.clientUsersService = clientUsersService;
    }

    @GetMapping
    public ResponseEntity<List<ClientUsers>> getAllClientUsers() {
        List<ClientUsers> clientUsers = clientUsersService.getAllClientUsers();
        return new ResponseEntity<>(clientUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientUsers> getClientUserById(@PathVariable Long id) {
        ClientUsers clientUser = clientUsersService.getClientUserById(id);
        return new ResponseEntity<>(clientUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ClientUsers> createClientUser(@RequestBody ClientUsers clientUsers) {
        ClientUsers createdClientUser = clientUsersService.createClientUser(clientUsers);
        return new ResponseEntity<>(createdClientUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientUsers> updateClientUser(@PathVariable Long id, @RequestBody ClientUsers clientUsers) {
        ClientUsers updatedClientUser = clientUsersService.updateClientUser(id, clientUsers);
        return new ResponseEntity<>(updatedClientUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClientUser(@PathVariable Long id) {
        clientUsersService.deleteClientUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
