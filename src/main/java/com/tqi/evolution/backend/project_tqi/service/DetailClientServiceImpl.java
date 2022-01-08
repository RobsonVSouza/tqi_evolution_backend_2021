package com.tqi.evolution.backend.project_tqi.service;

import com.tqi.evolution.backend.project_tqi.data.DetalheUsuarioData;
import com.tqi.evolution.backend.project_tqi.entity.Client;
import com.tqi.evolution.backend.project_tqi.repository.ClientRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailClientServiceImpl implements UserDetailsService {

    private final ClientRepository clientRepository;

    public DetailClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Client> client = clientRepository.findByEmail(username);
        if (client.isEmpty()){
            throw new UsernameNotFoundException("Cliente [" + username + "] não encontrado");
        }

        return new DetalheUsuarioData(client);
    }
}
