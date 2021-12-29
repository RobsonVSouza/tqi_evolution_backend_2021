package com.tqi.evolution.backend.project_tqi.controller;


import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.repository.ClientRepository;
import com.tqi.evolution.backend.project_tqi.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "v1/bank")
public class ProgramController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping(value = "/cliente")
    public List<Client> getAllClient(){
        return clientRepository.findAll();
    }

    @PostMapping(value = "/cadastro")
    public Client saveClient(@RequestBody Client client){
        return clientRepository.save(client);
    }

}
