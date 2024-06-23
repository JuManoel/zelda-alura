package edu.alura.tlozelda.models;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DataAppearances(
                @JsonAlias("name") String name) {

}
