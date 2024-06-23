package edu.alura.tlozelda.models;

public class Item {
    private String nombre;
    private String descripcion;

    public Item(DataItem item) {
        this.nombre = item.nombre();
        this.descripcion = item.descripcion();
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
    
}
