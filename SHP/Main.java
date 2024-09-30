

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventarioLibros inventario = new InventarioLibros();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Mostrar libros ordenados por año de publicación");
            System.out.println("3. Buscar libros por autor");
            System.out.println("4. Calcular valor del inventario");
            System.out.println("5. Mostrar todos los libros");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Ingrese el autor del libro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    System.out.print("Ingrese el precio del libro: ");
                    double precio = scanner.nextDouble();
                    inventario.registrarLibro(titulo, autor, anio, precio);
                    break;
                case 2:
                    inventario.ordenarPorAnio();
                    break;
                case 3:
                    System.out.print("Ingrese el autor a buscar: ");
                    String autorBusqueda = scanner.nextLine();
                    inventario.buscarPorAutor(autorBusqueda);
                    break;
                case 4:
                    inventario.calcularValorInventario();
                    break;
                case 5:
                    inventario.mostrarLibros();
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida, intente nuevamente.");
                    break;
            }
        } while (opcion != 0);

    }
}
