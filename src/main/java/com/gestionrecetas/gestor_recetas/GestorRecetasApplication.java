package com.gestionrecetas.gestor_recetas;



import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


 
@SpringBootApplication

public class GestorRecetasApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorRecetasApplication.class, args);
		gestorRecetas gestor = new gestorRecetas();
		Scanner scanner = new Scanner(System.in);


		while (true) {
			System.out.println("MENÚ PRINCIPAL ");
			System.out.println("1. Crear una nueva receta");
			System.out.println("2. Mostar recetas");
			System.out.println("3. Ver detalles de una receta");
			System.out.println("4. Eliminar una receta");
			System.out.println("5. Modificar una receta");
			System.out.println("6. Salir");
			System.out.print("Seleccione una opción: ");
	
			int opcion = scanner.nextInt();
			scanner.nextLine(); // Limpiar buffer
	
			switch (opcion) {
				case 1:
					gestor.crearReceta();
					break;
				case 2:
					gestor.mostrarRecetas();
					break;
				case 3:
					System.out.println("Ingrese el nombre de la receta que desea consultar: ");
					String nombreDetalles = scanner.nextLine();
					gestor.mostrarDetalles(nombreDetalles);
					break;
				case 4:
					System.out.println("Ingrese el nombre de la receta que desea eliminar: ");
					String nombreEliminar = scanner.nextLine();
					System.out.println("está seguro que desea borrar esta receta?(SI/NO) ");
					String confirmacion = scanner.nextLine();
					if (confirmacion.equalsIgnoreCase("no")) {
						System.out.println("No se eliminó ninguna receta");
					}else{
					gestor.eliminarReceta(nombreEliminar);
					}
					break;
				case 5://editar recetas
					System.out.println("Ingrese el nombre de la receta que desea editar: ");
					String nombreEditar = scanner.nextLine();
					System.out.println("Ingrese el nuevo nombre de la receta: ");
					String nuevoNombre = scanner.nextLine();
					System.out.println("Ingrese el nuevo tiempo de la receta: ");
					int nuevoTiempo = scanner.nextInt();
					scanner.nextLine(); //limpiar buffer
					gestor.editarRecetas(nombreEditar,nuevoNombre,nuevoTiempo);
					/*System.out.println("Desea modificar los ingredientes de esta receta? (SI/NO)");
					String confirmacion2 = scanner.nextLine();
					if (confirmacion2.equalsIgnoreCase("si")) {
						gestor.editarIngredientes(nombreEditar); */

					break;
				case 6:
					System.out.println(" Saliendo del programa...");
					scanner.close();
					return;
				default:
					System.out.println(" Opción no válida. Intente de nuevo.");
			}
		}
		
	}

	
}

 