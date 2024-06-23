package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataCharacter(
        @JsonAlias("name") String nombre,
        @JsonAlias("race") String raca,
        @JsonAlias("description") String descripcion) {

}