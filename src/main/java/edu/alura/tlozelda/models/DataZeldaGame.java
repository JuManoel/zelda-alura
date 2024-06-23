package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataZeldaGame(
                @JsonAlias("name") String nombre,
                @JsonAlias("description") String descripcion,
                @JsonAlias("released_date") String dataLanz) {

}
