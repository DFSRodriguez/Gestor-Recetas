package com.gestionrecetas.gestor_recetas;

import java.util.ArrayList;
import java.util.List;

public class Recetas {
   
        
        private String nombre;
        private int tiempoPreparacion;
        private List<Ingredientes> ingredientes;
        
    
        public Recetas(String nombre, int tiempoPreparacion) {
            this.nombre = nombre;
            this.tiempoPreparacion = tiempoPreparacion;
            this.ingredientes = new ArrayList<>();
            
     }

       public void agregarIngrediente(Ingredientes ingrediente) {
          this.ingredientes.add(ingrediente);
        }
        
        public List<Ingredientes> getIngredientes() {
            return ingredientes;
        }

        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        public int getTiempoPreparacion() {
            return tiempoPreparacion;
        }
        public void setTiempoPreparacion(int tiempoPreparacion) {
            this.tiempoPreparacion = tiempoPreparacion;
        }


          
    
}
