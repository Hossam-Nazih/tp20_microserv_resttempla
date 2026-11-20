package com.example.client;

import com.example.client.entities.Client;
import com.example.client.repositories.ClientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient  // Active l'enregistrement aupres d'Eureka
public class ClientServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ClientServiceApplication.class, args);
    }

    // Donnees de test: inserees seulement si la table est vide
    @Bean
    CommandLineRunner initialiserBase(ClientRepository clientRepository) {
        return args -> {
            if (clientRepository.count() == 0) {
                clientRepository.save(new Client(null, "Rabab SELIMANI", 23f));
                clientRepository.save(new Client(null, "Amal RAMI", 22f));
                clientRepository.save(new Client(null, "Samir SAFI", 25f));
            }
        };
    }
}
