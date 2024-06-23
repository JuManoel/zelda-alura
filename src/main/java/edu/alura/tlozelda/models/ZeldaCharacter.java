package edu.alura.tlozelda.models;

public class ZeldaCharacter {
    private String nombre;
    private String raca;
    private String descripcion;

    

    public ZeldaCharacter(DataCharacter personagem) {
        this.nombre = personagem.nombre();
        this.raca = personagem.raca();
        this.descripcion = personagem.descripcion();
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getRaca() {
        return raca;
    }
    public void setRaca(String raca) {
        this.raca = raca;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
