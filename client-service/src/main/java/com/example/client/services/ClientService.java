package com.example.client.services;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Marque cette classe comme un composant Service
public class ClientService {

    @Autowired  // Injection de dependance
    private ClientRepository clientRepository;

    /** Recupere tous les clients de la base de donnees */
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    /** Recupere un client par son identifiant, exception si introuvable */
    public Client findById(Long id) throws Exception {
        return clientRepository.findById(id)
                .orElseThrow(() -> new Exception("Client non trouve avec l'ID: " + id));
    }

    /** Ajoute un nouveau client ou met a jour un client existant */
    public Client addClient(Client client) {
        return clientRepository.save(client);
    }
}
