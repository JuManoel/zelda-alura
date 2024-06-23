package edu.alura.tlozelda.models;

import java.time.LocalDate;

public class ZeldaGame {
    private String nombre;
    private String descripcion;
    private LocalDate dataLanz;

    public ZeldaGame(DataZeldaGame dataZe) {
        this.nombre = dataZe.nombre();
        this.descripcion = dataZe.descripcion();
        this.dataLanz = LocalDate.parse(dataZe.dataLanz());
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public LocalDate getDataLanz() {
        return dataLanz;
    }
    public void setDataLanz(LocalDate dataLanz) {
        this.dataLanz = dataLanz;
    }

    @Override
    public String toString() {
        String str = """
                Nombre: %s
                Descripcion: %s
                Fecha de lanzamiento: %s
                """;
        str = String.format(str, this.getNombre(), this.descripcion,this.dataLanz.toString());
        return str;
    }
    
}
