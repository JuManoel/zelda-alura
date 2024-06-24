package edu.alura.tlozelda.models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class ZeldaGame {
    private String nombre;
    private String descripcion;
    private LocalDate dataLanz;

    public ZeldaGame(DataZeldaGame dataZe) {
        this.nombre = dataZe.nombre();
        this.descripcion = dataZe.descripcion();
        try {
            this.dataLanz = LocalDate.parse(dataZe.dataLanz());
        } catch (DateTimeParseException e) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
            String data = dataZe.dataLanz().trim();
            try {
                this.dataLanz = LocalDate.parse(data,formatter);
            } catch (DateTimeParseException f) {
                data= "January 1, "+data;
                this.dataLanz = LocalDate.parse(data,formatter);
            }
        }
        
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
