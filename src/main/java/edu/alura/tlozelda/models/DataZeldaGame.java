package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataZeldaGame(
                @JsonAlias("name") String nombre,
                @JsonAlias("description") String descripcion,
                @JsonAlias("released_date") String dataLanz) {

}
