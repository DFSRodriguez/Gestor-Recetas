package com.gestionrecetas.gestor_recetas;

public class Ingredientes {
    private String nombre;
    private double cantidad;
    private String unidad;

    public Ingredientes (String nombre, double cantidad, String unidad){
        
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidad = unidad;


    }
      

    // Getter y Setter para el nombre
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Getter y Setter para la cantidad
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    // Getter y Setter para la unidad
    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
}

    


