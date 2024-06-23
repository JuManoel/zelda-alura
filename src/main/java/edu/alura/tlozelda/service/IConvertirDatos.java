package edu.alura.tlozelda.service;

import com.fasterxml.jackson.core.type.TypeReference;

public interface IConvertirDatos {
    <T> T obterDados(String json, Class<T> clase);
    <T> T obterDados(String json, TypeReference<T> typeReference);
}
