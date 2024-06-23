package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataCharacter(
        @JsonAlias("name") String nombre,
        @JsonAlias("race") String raca,
        @JsonAlias("description") String descripcion,
        @JsonAlias("gender") String genero) {

}