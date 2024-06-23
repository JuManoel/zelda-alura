package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataItem(
        @JsonAlias("name") String nombre,
        @JsonAlias("description") String descripcion) {

}
