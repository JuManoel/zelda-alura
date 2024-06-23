package edu.alura.tlozelda.models;

import java.util.ArrayList;
import java.util.List;

public class Place {
    private String nombre;
    private List<Appearances> aparece;

    

    public Place(DataPlaces dataPlaces) {
        this.nombre = dataPlaces.nombre();
        aparece = new ArrayList<Appearances>();
        for (DataAppearances dataAppearances : dataPlaces.aparece()) {
            aparece.add(new Appearances(dataAppearances));
        }
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public List<Appearances> getAparece() {
        return aparece;
    }
    public void setPAarece(List<Appearances> parece) {
        this.aparece = parece;
    }

}
