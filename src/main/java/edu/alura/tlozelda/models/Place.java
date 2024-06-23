package edu.alura.tlozelda.models;

public class Place {
    private String nombre;
    private String descripsion;

    

    public Place(DataPlaces dataPlaces) {
        this.nombre = dataPlaces.nombre();
        this.descripsion = dataPlaces.descrision();

    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripsion() {
        return descripsion;
    }
    public void setDescripsion(String descripsion) {
        this.descripsion = descripsion;
    }
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\ndescripsion:" + descripsion + "\n";
    }

}
