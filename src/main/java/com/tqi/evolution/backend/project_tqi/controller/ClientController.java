package com.tqi.evolution.backend.project_tqi.controller;


import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/bank")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder encoder;

    public ClientController(ClientService clientService, PasswordEncoder encoder) {
        this.clientService = clientService;
        this.encoder = encoder;
    }

    @GetMapping(value = "/client")
    public List<Client> getAllClient() {
        return clientService.getAll();
    }

    @PostMapping(value = "/register")
    public Client saveClient(@Valid @RequestBody Client client) {
        client.setPassword(encoder.encode(client.getPassword()));
        return clientService.save(client);
    }

    @GetMapping(value = "/validate")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String email, @RequestParam String password) {

        Optional<Client> optionalClient = clientService.findByEmail(email);
        if (optionalClient.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(false);
        }

        boolean valid = encoder.matches(password, optionalClient.get().getPassword());

        HttpStatus status = (valid) ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return ResponseEntity.status(status).body(valid);
    }
}
