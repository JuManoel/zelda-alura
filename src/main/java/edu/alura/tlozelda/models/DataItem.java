package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataItem(
        @JsonAlias("name") String nombre,
        @JsonAlias("description") String descripcion) {

}
