package com.example.car.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO (pas une entite JPA): represente le client recupere depuis le service client.
 * Le service client expose le champ "nom", d'ou l'alias pour le champ "name".
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private Long id;
    @JsonAlias("nom")
    private String name;
    private Integer age;
}
