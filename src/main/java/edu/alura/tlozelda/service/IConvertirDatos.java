package edu.alura.tlozelda.service;

public interface IConvertirDatos {
    <T> T obterDados(String json, Class<T> clase);
}
