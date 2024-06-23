package edu.alura.tlozelda.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public record ResponseApi<T>(
        @JsonAlias("success") boolean success,
        @JsonAlias("count") int count,
        @JsonAlias("data") List<T> data) {

}
