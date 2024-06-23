package edu.alura.tlozelda.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataPlaces(
        @JsonAlias("name") String nombre,
        @JsonAlias("appearances") List<DataAppearances> aparece) {

}
