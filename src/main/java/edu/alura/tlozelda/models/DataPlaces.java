package edu.alura.tlozelda.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DataPlaces(
                @JsonAlias("name") String nombre,
                @JsonAlias("description") String descrision) {
}
