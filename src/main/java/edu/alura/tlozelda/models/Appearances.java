package edu.alura.tlozelda.models;

public class Appearances {
    String name;

    

    public Appearances(DataAppearances data) {
        this.name = data.name();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "nombre: " + name + "\n";
    }

    
    
}
