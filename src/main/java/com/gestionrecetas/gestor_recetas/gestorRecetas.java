package com.gestionrecetas.gestor_recetas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class gestorRecetas {

    private List<Recetas> listaRecetas;
    private Scanner scanner;
    public boolean entradaValida = false;
    public gestorRecetas() {
        this.listaRecetas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void crearReceta() {
        
        System.out.print("Ingrese el nombre de la receta: ");
        String nombreReceta = scanner.nextLine();
        if (recetaExiste(nombreReceta)) {
            System.out.println(" Error: Ya existe una receta con ese nombre.");
            return;
        }
        int tiempoPreparacion= 0;
        while (!entradaValida) {
            try {
                    System.out.print("Ingrese el tiempo de preparación (minutos): ");
                    tiempoPreparacion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer
                    entradaValida = true; // Si llega aquí, la entrada fue válida
        } catch (java.util.InputMismatchException e) {
            System.out.println("⚠️ Error: Ingrese solo números enteros.");
            scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
            }
        }        

        Recetas nuevaReceta = new Recetas(nombreReceta, tiempoPreparacion);
    
        System.out.println("\nAgregue ingredientes (escriba 'fin' para terminar):");
        while (true) {
            System.out.print("Nombre del ingrediente: ");
            String nombreIngrediente = scanner.nextLine();
    
            if (nombreIngrediente.equalsIgnoreCase("fin")) {
            break;
            }
            double cantidad = 0;
            while (entradaValida) {
                try {
                    System.out.print("Cantidad: ");
                    cantidad = scanner.nextDouble();
                    scanner.nextLine(); // Limpiar buffer
                    entradaValida = false; // Si llega aquí, la entrada fue válida
                } catch (java.util.InputMismatchException e) {
                    System.out.println(" Error: Ingrese solo números enteros.");
                    scanner.nextLine(); // Limpiar buffer para evitar bucle infinito
                }

            }
    
            System.out.print("Unidad (g, ml, cucharadas, etc.): ");
            String unidad = scanner.nextLine();
    
            Ingredientes ingrediente = new Ingredientes(nombreIngrediente, cantidad, unidad);
            nuevaReceta.agregarIngrediente(ingrediente);
    
            System.out.println("Ingrediente agregado ");
        }
    
        listaRecetas.add(nuevaReceta);
        System.out.println("\n ¡Receta creada y guardada!\n");
    }

    //metodo para verificar recetas existentes
    private boolean recetaExiste(String nombre) {
        for (Recetas receta : listaRecetas) {
            if (receta.getNombre().equalsIgnoreCase(nombre)) {
                return true; // La receta ya existe
            }
        }
        return false; // No existe aún
    }
    
        //metodo para mostrar recetas
        public void mostrarRecetas() {
            if (listaRecetas.isEmpty()) {
                System.out.println("No hay recetas guardadas.");
                return;
            }
    
            for (Recetas receta : listaRecetas) {
                System.out.println("\n🔹 RECETA: " + receta.getNombre());
                System.out.println("Tiempo de preparación: " + receta.getTiempoPreparacion() + " minutos");
                System.out.println("Ingredientes:");
                for (Ingredientes ing : receta.getIngredientes()) {
                    System.out.println("- " + ing.getCantidad() + " " + ing.getUnidad() + " de " + ing.getNombre());
                }
            }
        }

        public void eliminarReceta(String nombre) {
            if (listaRecetas.isEmpty()) {
                System.out.println("No hay recetas guardadas.");
                return;
            }
            for (int i = 0; i < listaRecetas.size(); i++) {
                Recetas receta = listaRecetas.get(i);
                if (receta.getNombre().equalsIgnoreCase(nombre)) {
                    listaRecetas.remove(i);
                    System.out.println("Receta eliminada: " + nombre);
                    return; 
                }
            }
            System.out.println("No se encontró la receta: " + nombre);
        }

        public void mostrarDetalles(String nombre){
            //metodo para mostrar los detalles de una receta
            if (listaRecetas.isEmpty()) {
                System.out.println("No hay recetas guardadas.");
                return;
            }
            for (int i = 0; i < listaRecetas.size(); i++) {
                Recetas receta = listaRecetas.get(i);
                System.out.println("Nombre: " + receta.getNombre());
                System.out.println("Ingredientes:");
                for (Ingredientes ing : receta.getIngredientes()) {
                    System.out.println("- " + ing.getCantidad() + " " + ing.getUnidad() + " de " + ing.getNombre());
                }

            }

        }

        public void editarRecetas (String nombre, String nuevaNombre, int nuevoTiempo){
            //metodo para editar una receta
            if (listaRecetas.isEmpty()) {
                System.out.println("No hay recetas guardadas.");
                return;
            }
            for (int i = 0; i < listaRecetas.size(); i++) {
                Recetas receta = listaRecetas.get(i);
                if (receta.getNombre().equals(nombre)) {
                    receta.setNombre(nuevaNombre);
                    receta.setTiempoPreparacion(nuevoTiempo);
                    System.out.println("La receta ha sido editada exitosamente.");
                    return;
                }
            }
            System.out.println("No se encontró ninguna receta con el nombre especificado.");
        }

        /*public void editarIngredientes(String nombre, String nuevoNombre, double nuevaCantidad, String nuevaUnidad){
            //metodo para editar un ingrediente
            if (listaRecetas.isEmpty()) {
                System.out.println("No hay recetas guardadas.");
                return;
            }
            for (int i = 0; i < listaRecetas.size(); i++) {
                Recetas receta = listaRecetas.get(i);


        }*/


















    }
    